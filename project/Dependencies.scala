import sbt._

object Dependencies {

  val scalaVersions: Seq[String] = Seq("2.12.13", "2.13.4")

  lazy val smoothieMap = "io.timeandspace" % "smoothie-map" % "2.0.2"
  lazy val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.2.3"
  lazy val logbackCore = "ch.qos.logback" % "logback-core" % "1.2.3"

}
