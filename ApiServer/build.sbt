organization  := "com.sf"

version       := "0.1"

scalaVersion  := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
//    "io.spray"            %% "spray-json_2.11" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test"
  )
}
// https://mvnrepository.com/artifact/com.google.maps/google-maps-services
libraryDependencies += "com.google.maps" % "google-maps-services" % "0.1.16"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.0" % "test"
libraryDependencies += "com.maxmind.geoip" % "geoip-api" % "1.3.1"
// https://mvnrepository.com/artifact/io.spray/spray-json_2.11
libraryDependencies += "io.spray" % "spray-json_2.11" % "1.3.2"
//libraryDependencies += "com.typesafe" % "config" % "1.3.1"

//Revolver.settings
