import sbt._
import Keys._

object build extends Build{
  val buildSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.10.0-M2",
    scalacOptions += "-Xmacros",
    resolvers ++= Seq(
      "sonatype" at "https://oss.sonatype.org/content/repositories/releases"
    )
  )

  lazy val root = Project(
    "compile-time-fibonacci",
    file("."),
    settings = buildSettings
  )dependsOn(macrodef)

  lazy val macrodef = Project(
    "macrodef",
    file("macrodef"),
    settings = buildSettings
  )
}

