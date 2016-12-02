package mx.edu.itsm.msc.controllers.dwh;

import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DataWareHouse {
	public static void main(String[] args) {
		DataWareHouseResult dr = DataWareHouse.crearDataWareHouse();
		
		System.out.println("folio renglon 0: "+dr.getResults().get(0).get(0));
		System.out.println("producto1 1: "+dr.getResults().get(0).get(1));
		System.out.println("código del producto 1"+dr.getColumns()[1]);
		
		System.out.println("folio renglon 1: "+dr.getResults().get(1).get(0));
		System.out.println("producto1 1: "+dr.getResults().get(1).get(1));
		System.out.println("código del producto 1"+dr.getColumns()[1]);
	}

	public static DataWareHouseResult crearDataWareHouse(){
		SparkSession ss = SparkSession.builder()
		 .appName("DataWareHouse")
	     .master("local")
	     .config("spark.sql.warehouse.dir", "file:////tmp")
                     .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                     .master("local[*]")
	     .getOrCreate();

		Dataset<Row> df = ss.read().option("header", "true").csv("./src/main/resources/movVentas_con_700_Registros.csv");
		df = df.groupBy(df.col("folio")).pivot("codigo").count().na().fill(0);
		df.show(150,false);
		
                df.coalesce(1).write().csv("./src/main/resources/result.csv");
                List<Row> list = df.collectAsList();
		DataWareHouseResult dr = new DataWareHouseResult();
		
		dr.setColumns(df.columns());
		dr.setResults(list);
		
		return dr;
	}
}
