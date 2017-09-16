name := "Upong"
version := "0.1.0"

scalaVersion := "2.12.3"

val gdxVersion = "1.9.6"
libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx" % gdxVersion,
  "com.badlogicgames.gdx" % "gdx-freetype" % gdxVersion,
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl" % gdxVersion,
  "com.badlogicgames.gdx" % "gdx-platform" % gdxVersion classifier "natives-desktop",
  "com.badlogicgames.gdx" % "gdx-freetype-platform" % gdxVersion classifier "natives-desktop",
  "com.badlogicgames.gdx" % "gdx-tools" % gdxVersion
)

// make project name and version accessible from source code
lazy val upong = (project in file(".")).
  enablePlugins(BuildInfoPlugin).
    settings(
      buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
      buildInfoPackage := "upong"
    )
