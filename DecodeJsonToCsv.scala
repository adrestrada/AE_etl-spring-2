package bixiproject2

import io.circe._
import io.circe.generic.semiauto._
import io.circe.parser._
import java.io.{BufferedWriter, File, FileWriter}
//import java.sql.DriverManager
//import org.apache.hadoop.fs.Path

object DecodeJsonToCsv extends App {
  //-------------------------------------------------------------DECODING SYSTEM_INFORMATION JSON ==> CSV
  implicit val systemInfoDecoder: Decoder[SystemInformation] = deriveDecoder
  implicit val systDataListDecoder: Decoder[Datalist] = deriveDecoder

  val systemInfoPath = scala.io.Source.
    fromFile("C:\\Users\\Valeria\\IdeaProjects\\spring2-project\\DataBixi\\system_information.json")
  val systeminfoLines = try systemInfoPath.mkString finally systemInfoPath.close()

  decode[SystemInformation](systeminfoLines) match {
    case Right(v) =>
      val outPutFile =  new BufferedWriter(
        new FileWriter(
          new File("C:\\Users\\Valeria\\IdeaProjects\\spring2-project\\DataBixi\\system_information.csv")))
      outPutFile.write(SystemInformations.toCsv(v.data))
      outPutFile.close()
  }
 //----------------------------------------------------------------DECODING STATION_INFORMATION JSON ==> CSV
  implicit val stationInfoDecoder: Decoder[StationInformation] = deriveDecoder
  implicit val statListDecoder: Decoder[Data] = deriveDecoder
  implicit val stationsDecoder: Decoder[Stations] = deriveDecoder
  implicit val EightStationServiceDecoder: Decoder[EightdStationServices] = deriveDecoder

  val stationInfoPath = scala.io.Source.
    fromFile("C:\\Users\\Valeria\\IdeaProjects\\spring2-project\\DataBixi\\station_information.json")
  val stationInfoLines = try stationInfoPath.mkString finally stationInfoPath.close()

  decode[StationInformation](stationInfoLines) match {
    case Right(v) =>
      val outPutFile = new BufferedWriter(
        new FileWriter(
          new File ("C:\\Users\\Valeria\\IdeaProjects\\spring2-project\\DataBixi\\station_information.csv")))
      v.data.stations
        .map(line => StationInformation.toCsv(line))
        .foreach(line => outPutFile.write(line))
      outPutFile.close()
  }
}


