package xyz.digiou.examples

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

/**
  * Listens to a raw socket on port 9999.
  * Prints the word count from the socket every 7-sec.
  *
  * Must be used with "nc -lk 9999" in a Unix/like terminal.
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
