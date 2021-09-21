package bixiproject2

case class StationInformation(last_updated: Int,
                              ttl: Int,
                              data: Data)

case class Data(stations: List [Stations])

case class  Stations(station_id: String,
                    external_id: String,
                    name: String,
                    short_name: Int,
                    lat: Double,
                    lon: Double,
                    rental_methods: List[String],
                    capacity: Int,
                    electric_bike_surcharge_waiver: Boolean,
                    is_charging: Boolean,
                    eightd_has_key_dispenser: Boolean,
                    //eightd_station_services: List [EightdStationServices],
                     eightd_station_services: Option[List[EightdStationServices]],
                    has_kiosk: Boolean
                    )


case class EightdStationServices(id: String,
                                 service_type: String,
                                 bikes_availability: String,
                                 docks_availability: String ,
                                 name: String,
                                 description: String,
                                 schedule_description: String,
                                 link_for_more_info: String
                                )

object StationInformation {
  def toCsv(data: Stations): String = {
    s"${data.station_id}," +
      s"${data.external_id}," +
      s"${data.name}," +
      s"${data.short_name}," +
      s"${data.lat}," +
      s"${data.lon}," +
      s"${data.rental_methods.addString(new StringBuilder(),"|")}," + // para cada list
      s"${data.capacity}," +
      s"${data.electric_bike_surcharge_waiver}," +
      s"${data.is_charging}," +
      s"${data.eightd_has_key_dispenser}," +
      s"${data.eightd_station_services.addString(new StringBuilder(),"|")}," + // arreglar!!!!!!
      s"${data.has_kiosk}\n"
  }
}




// 123,"name", ...."key"|"creditcard",nextcol,
//  create table...
// rental methods List[String],
//...
// fileds terminated by ','
// collection items terminated by '|'

