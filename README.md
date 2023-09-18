# ETL spring-2
to create the dimensions to be used as reference data. 
It is a set of Hive tables that are normally cold and updated not frequently. 
The program run ETL for system information and station information automatically as  Drop table Transform JSON files to CSV Enrich stations information data with system information. 
Note that the system information has only one record. You can simply use cross join to accomplish this task Skillset HDFS Hive JSON CSV Parquet Scala SQL REST API
