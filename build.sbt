name := "flink-examples"

version := "0.0.1"
organization := "xyz.digiou"
scalaVersion := "2.11.8"

resolvers ++= Seq(
  "apache snapshots" at "https://repository.apache.org/content/repositories/snapshots/"
)

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

val avroVersion = "1.8.0"

libraryDependencies ++= Seq(
  "org.apache.avro" % "avro" % avroVersion
)

mainClass in (Compile, run) := Some("xyz.digiou.examples.CEPExample")