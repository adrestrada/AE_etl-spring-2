package bixiproject2

case class SystemInformation(last_updated: Int,
                             ttl: Int,
                             data: Datalist)

case class Datalist(system_id: String,
                language: String,
                name: String,
                short_name: String,
                operator: String,
                url: String,
                purchase_url: String,
                start_date: String,
                phone_number: String,
                email: String,
                license_url: String,
                timezone: String
               )

object SystemInformations {
  def toCsv(data: Datalist): String = {
    s"${data.system_id}," +
      s"${data.language}," +
      s"${data.name}," +
      s"${data.short_name}," +
      s"${data.operator}," +
      s"${data.url}," +
      s"${data.purchase_url}," +
      s"${data.start_date}," +
      s"${data.phone_number}," +
      s"${data.email}," +
      s"${data.license_url}," +
      s"${data.timezone}\n"
  }
}
