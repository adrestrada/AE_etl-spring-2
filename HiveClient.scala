package bixiproject2

import org.apache.hive.jdbc.HiveDriver

import java.sql.{Connection, DriverManager, Statement}

trait HiveClient {

  val driverName: String = classOf[HiveDriver].getName
  Class.forName(driverName)
  val connectionString: String =
    "jdbc:hive2://quickstart.cloudera:10000/bdsf2001_adriest;user=adriest;password=valeria9"
  val  connection: Connection = DriverManager.getConnection(connectionString)
  val stmt: Statement = connection.createStatement()
}

//val driverName: String = "org.apache.hive.jdbc.HiveDriver"
//  Class.forName(driverName)
//  val connectionString: String =
//  "jdbc:hive2://quickstart.cloudera:10000/bdsf2001_adriest;user=adriest;password=valeria9"
//  val  connection = DriverManager.getConnection(connectionString)
//  val stmt = connection.createStatement()
//  stmt.close()
//  connection.close()
//}