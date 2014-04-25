name := "akkaPersistenceNoAndroid"

organization := "com.optrak"

version := "1.0"

scalaVersion := "2.10.4"

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-language:_",
  "-encoding", "UTF-8"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.10" % "2.3.2",
  //"org.mapdb" % "mapdb" % "0.9.13",
  //"io.github.drexin" %% "akka-persistence-mapdb" % "0.1-SNAPSHOT",
  //"com.github.michaelpisula" %% "akka-persistence-inmemory" % "0.1-SNAPSHOT", // should be used for testing only, according to documentation at https://github.com/michaelpisula/akka-journal-inmemory/blob/master/README.md 
	"com.typesafe.akka" % "akka-persistence-experimental_2.10" % "2.3.2"
)
