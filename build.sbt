name := "flink-examples"

version := "0.0.1"
organization := "com.customedialabs"
scalaVersion := "2.11.8"

val flinkVersion = "1.1.3"

libraryDependencies ++= Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion,
  "org.apache.flink" %% "flink-clients" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion,
  "org.apache.flink" %% "flink-cep-scala" % flinkVersion,
  "org.apache.flink" %% "flink-connector-rabbitmq" % flinkVersion
)

val scalaTestVersion = "3.0.0"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % scalaTestVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)

mainClass in (Compile, run) := Some("com.customedialabs.examples.RabbitMQExample")