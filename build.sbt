val mcVersion = "1.13.2"

val spigotResolver = "spigot-repo" at "https://hub.spigotmc.org/nexus/content/repositories/snapshots/"
val sonatypeResolver = "Sonatype OSS" at "https://oss.sonatype.org/content/groups/public/"

val dependencies = Seq(
    "org.spigotmc" % "spigot-api" % s"${mcVersion}-R0.1-SNAPSHOT" % "provided",
    "org.bukkit" % "bukkit" % s"${mcVersion}-R0.1-SNAPSHOT" % "provided",
)

lazy val root = (project in file("."))
    .settings(
        name := "mc-scala-template",
        scalaVersion := "2.13.0",
        libraryDependencies ++= dependencies,
        resolvers += spigotResolver,
        resolvers += sonatypeResolver,
    )
