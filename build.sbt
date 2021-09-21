name := "spring2-project"

version := "0.1"

scalaVersion := "2.12.10"
//-------------------------------------------------------------HDFS,HIVE,CIRCE conexion
val HadoopVersion = "2.7.3"
val hiveJdbcVersion = "1.1.0-cdh5.16.2"

val hiveDeps = Seq(
  "org.apache.hive" % "hive-jdbc" % hiveJdbcVersion
)
val hdfsDeps = Seq(
  "org.apache.hadoop" % "hadoop-common" % HadoopVersion,
  "org.apache.hadoop" % "hadoop-hdfs" % HadoopVersion
)
libraryDependencies ++= hiveDeps ++ hdfsDeps

resolvers += "cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"

val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)



//addCompilerPlugin(
//  "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full
//)
