package bixiproject2
//import org.apache.hive.jdbc.HiveDriver
//import java.sql.DriverManager
//import bixiproject2.HiveManaged.connection

object HiveManaged extends App with HiveClient {

  stmt.execute("set hive.exec.dynamic.partition.mode=nonstrict")
  stmt.execute("DROP TABLE IF EXISTS ext_system_information")
  stmt.execute("DROP TABLE IF EXISTS ext_station_information")
  stmt.execute("DROP TABLE IF EXISTS enriched_station_information")
  //----------------------------------------------ext_system_information
  stmt.execute(
    """CREATE EXTERNAL TABLE bdsf2001_adriest.ext_system_information (
      |  system_id STRING,
      |  language STRING,
      |  name STRING,
      |  short_name STRING,
      |  operator STRING,
      |  url STRING,
      |  purchase_url STRING,
      |  start_date STRING,
      |  phone_number STRING,
      |  email STRING,
      |  license_url STRING,
      |  timezone STRING
      |  )
      |  ROW FORMAT DELIMITED
      |  FIELDS TERMINATED BY ','
      |  STORED AS TEXTFILE
      |  LOCATION '/user/bdsf2001/adriest/external/system_information'
      |  TBLPROPERTIES ("serialization.null.format" = "")""".stripMargin)
  //-----------------------------------------------ext_station_information
  stmt.execute(
    """CREATE EXTERNAL TABLE bdsf2001_adriest.ext_station_information (
      |  station_id  STRING,
      |  external_id  STRING,
      |  name  STRING,
      |  short_name  STRING,
      |  lat  DOUBLE,
      |  lon  DOUBLE,
      |  rental_methods ARRAY<STRING>,
      |  capacity  INT,
      |  electric_bike_surcharge_waiver  BOOLEAN,
      |  is_charging  BOOLEAN,
      |  eightd_has_key_dispenser  BOOLEAN,
      |  eightd_id STRING,
      |  eightd_service_type STRING,
      |  eightd_bikes_availability STRING,
      |  eightd_docks_availability STRING,
      |  eightd_name STRING,
      |  eightd_description STRING,
      |  eightd_schedule_description STRING,
      |  eightd_link_for_more_info STRING,
      |  has_kiosk  BOOLEAN
      |   )
      |  ROW FORMAT DELIMITED
      |  FIELDS TERMINATED BY ','
      |  COLLECTION ITEMS TERMINATED BY '|'
      |  STORED AS TEXTFILE
      |  LOCATION '/user/bdsf2001/adriest/external/station_information'
      |  TBLPROPERTIES ("serialization.null.format" = "")""".stripMargin)
  //------------------------------------------------enriched_station_information
  stmt.execute(
    """CREATE TABLE bdsf2001_adriest.enriched_station_information (
      |  system_id String,
      |  timezone String,
      |  station_id Int,
      |  name String,
      |  short_name String,
      |  lat Double,
      |  lon Double,
      |  capacity Int
      |  )
      |  STORED AS PARQUET""".stripMargin)
  //------------------------------------------------insert into enriched_station_information
  stmt.execute(
    """INSERT INTO TABLE bdsf2001_adriest.enriched_station_information
      | SELECT
      |  t.system_id,
      |  t.timezone,
      |  s.station_id,
      |  s.name,
      |  s.short_name,
      |  s.lat,
      |  s.lon,
      |  s.capacity
      |  FROM bdsf2001_adriest.ext_system_information AS t
      |  CROSS JOIN bdsf2001_adriest.ext_station_information AS s""".stripMargin)

    stmt.close()
      connection.close()
}
