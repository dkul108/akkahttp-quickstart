name := "akkahttp-quickstart"

version := "0.1"

scalaVersion := "2.12.6"

val circeVersion = "0.10.0"

//mainClass in assembly := Some("Main")



libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.21",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.21" % Test,

  "com.typesafe.akka" %% "akka-stream" % "2.5.21",
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.21" % Test,

  "com.typesafe.akka" %% "akka-http" % "10.1.7",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.1.7" % Test,


  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,

  "de.heikoseeberger" %% "akka-http-circe" % "1.25.2",

//  "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.0",
//  "com.github.tototoshi" %% "scala-csv" % "1.3.5",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)