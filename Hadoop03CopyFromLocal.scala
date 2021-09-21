package bixiproject2
import org.apache.hadoop.fs.Path

object Hadoop03CopyFromLocal extends App with HadoopClient {

  fs.copyFromLocalFile(new Path
  ("C:/Users/Valeria/IdeaProjects/spring2-project/DataBixi/station_information.csv"),
    new Path("/user/bdsf2001/adriest/external/station_information"))
  fs.copyFromLocalFile(new Path
  ("C:/Users/Valeria/IdeaProjects/spring2-project/DataBixi/system_information.csv"),
    new Path("/user/bdsf2001/adriest/external/system_information"))
  fs.close()
}
