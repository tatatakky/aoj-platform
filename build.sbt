name := "aoj-platform"

version := "0.1"

lazy val baseName = "aoj-platform"

lazy val `itp1` = (project in file("problems/course/itp1")).settings(
  name := s"$baseName-itp1",
  scalaVersion := "2.13.5",
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-core" % "2.5.0",
    "org.typelevel" %% "cats-effect" % "3.2.8",
    "org.scalacheck" %% "scalacheck" % "1.15.3" % "test"
  )
)

lazy val `examples` = (project in file("examples")).settings(
  name := s"$baseName-examples",
  scalaVersion := "2.13.5"
).dependsOn( `itp1` )

lazy val root = (project in file("."))
  .settings(
    name := baseName,
    scalaVersion := "2.13.5"
  ).aggregate( `examples`, `itp1` )
