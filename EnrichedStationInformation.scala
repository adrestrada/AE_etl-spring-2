package bixiproject2

case class EnrichedStationInformation(
                                     system_id : String,
                                     timezone : String,
                                     station_id : Int,
                                     name : String,
                                     short_name : String,
                                     lat : Double,
                                     lon : Double,
                                     capacity : Int
                                     )

