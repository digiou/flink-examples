package com.customedialabs.examples

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.connectors.rabbitmq.RMQSource
import org.apache.flink.streaming.connectors.rabbitmq.common.RMQConnectionConfig
import org.apache.flink.streaming.util.serialization.SimpleStringSchema

/**
  * Created by digiou on 19/10/2016.
  */
object RabbitMQExample extends App {

  val env = StreamExecutionEnvironment.getExecutionEnvironment

  val cnxConf = new RMQConnectionConfig.Builder()
    .setHost("localhost")
    .setUserName("guest")
    .setPassword("guest")
    .setPort(5672)
    .setVirtualHost("/")
    .build()

  val streamWithoutCorrelationIds = env
    .addSource(new RMQSource[String](cnxConf, "hello", new SimpleStringSchema))
    .flatMap {_.toLowerCase.split("\\W+") filter {_.nonEmpty}}
    .map { (_, 1) }
    .keyBy(0)
    .timeWindow(Time.seconds(7))
    .sum(1)

  streamWithoutCorrelationIds.print()
  
  env.execute("Rabbit Stream printout")
}