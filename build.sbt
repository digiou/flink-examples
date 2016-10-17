name := "flink-examples"

version := "0.0.1"

organization := "com.customedialabs"

scalaVersion := "2.11.7"

val flinkVersion = "1.1.3"

libraryDependencies ++= Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion,
  "org.apache.flink" %% "flink-clients" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion
)

fork in run := true