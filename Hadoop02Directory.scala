package bixiproject2

import org.apache.hadoop.fs.Path

object Hadoop02Directory extends App with HadoopClient {
  //------------------------------------------------------------Create Directory and subDirectory
  val outPutDir = "/user/bdsf2001/adriest/"
  val outPutDir1 = "external/"
  val outPutDirProject = outPutDir + outPutDir1
  if (fs.exists(new Path(outPutDirProject))) {
    fs.delete(new Path(s"$outPutDirProject"), true)
  }
  fs.mkdirs(new Path(s"$outPutDirProject"))
  fs.mkdirs(new Path(s"${outPutDirProject}station_information"))
  fs.mkdirs(new Path(s"${outPutDirProject}system_information"))
}


