package com.customedialabs.examples

import com.customedialabs.examples.events.EventExample
import com.customedialabs.examples.util.serialization.AvroDeserializationSchema
import org.apache.flink.cep.scala.CEP
import org.apache.flink.cep.scala.pattern._
import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.rabbitmq.RMQSource
import org.apache.flink.streaming.connectors.rabbitmq.common.RMQConnectionConfig

/**
  * Created by digiou on 19/10/2016.
  */
object CEPExample extends App {

  val env = StreamExecutionEnvironment.getExecutionEnvironment

  val cnxConf = new RMQConnectionConfig.Builder()
    .setHost("localhost")
    .setUserName("guest")
    .setPassword("guest")
    .setPort(5672)
    .setVirtualHost("/")
    .build()

  val input = env
    .addSource(new RMQSource[EventExample](cnxConf, "hello", new AvroDeserializationSchema[EventExample](classOf[EventExample])))

  val startPattern = Pattern.begin[EventExample]("start")
    .where(_.value == "start")
    .followedBy("end")
    .where(_.value == "end")

  val patternStream = CEP.pattern(input, startPattern)

  val alerts = patternStream.select( x => selectStartFn(x))

  def selectStartFn(pattern: scala.collection.mutable.Map[String, EventExample]) = {
    val startEvent = pattern.get("start")
    val endEvent = pattern.get("end")
    (startEvent.toString, endEvent.toString)
  }

  alerts.print

  env.execute("CEP example with RabbitMQ")
}
