package com.customedialabs.examples

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

/**
  * Created by digiou on 17/10/2016.
  */
object SocketExample extends App {
  val env = StreamExecutionEnvironment.getExecutionEnvironment
  val text = env.socketTextStream("localhost", 9999)

  val counts = text.flatMap {_.toLowerCase.split("\\W+") filter {_.nonEmpty} }
    .map { (_, 1) }
    .keyBy(0)
    .timeWindow(Time.seconds(7))
    .sum(1)

  counts.print

  env.execute("Socket Stream WordCount")
}
