

ThisBuild / version := "0.1.0"
ThisBuild / description := "Simple DSL to orchestrate applications"
ThisBuild / organization := "jsoft.orchestrator"
ThisBuild / organizationName := "jsoft"
ThisBuild / licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

onChangedBuildSource in Global := ReloadOnSourceChanges

lazy val enablingPublishingSettings = Seq(
  publishArtifact := true,
  publishMavenStyle := true,
  // http://www.scala-sbt.org/0.12.2/docs/Detailed-Topics/Artifacts.html
  publishArtifact in Test := false,
  // Bintray
  bintrayPackageLabels := Seq("scala", "sbt"),
  bintrayRepository := "maven",
  bintrayVcsUrl := Option("https://github.com/joacovela16/modux"),
  bintrayOrganization := Option("jsoft"),
)

lazy val root = (project in file("."))
  .settings(
    enablingPublishingSettings,
    name := "orchestrator4s",
    scalacOptions ++= Seq("-language:higherKinds"),
    crossScalaVersions := Dependencies.scalaVersions,
    scalacOptions ++= Seq("-feature", "-deprecation"),
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      Dependencies.smoothieMap,
      Dependencies.logbackClassic,
      Dependencies.logbackCore
    )
  )


lazy val examples = (project in file("./examples"))
  .aggregate(root)
  .dependsOn(root)
  .settings(
    name := "example",
    publish / skip := true
  )