import sbt._,Keys._

object build extends Build{
  val buildSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.10.3",
    resolvers ++= Seq(
      Opts.resolver.sonatypeReleases
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
    settings = buildSettings ++ Seq(
      libraryDependencies <++= scalaVersion{ v =>
        Seq(
          "org.scala-lang" % "scala-reflect" % v
        )
      }
    )
  )
}

