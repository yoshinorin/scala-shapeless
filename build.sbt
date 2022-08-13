name := "shapeless-example"
version := "0.0.1"

scalaVersion := "2.13.8"

scalacOptions ++= Seq(
  "-Yrangepos",
  "-Ywarn-unused",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-encoding",
  "UTF-8"
)

scalacOptions --= Seq(
  "-Xlint:nullary-override",
)

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.9",
  "org.scalatest" %% "scalatest" % "3.2.11" % "test"
)
