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
