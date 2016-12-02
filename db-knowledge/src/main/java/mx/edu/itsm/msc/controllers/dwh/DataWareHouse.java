package mx.edu.itsm.msc.controllers.dwh;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

public class DataWareHouse {
	
	private static String fileOutput = "/var/matriz.csv";
	private static String interFile = "/var/result";
	
	public static void main(String[] args) {
		DataWareHouseResult dr = DataWareHouse.crearDataWareHouse();

		System.out.println("folio renglon 0: "+dr.getResults().get(0).get(0));
		System.out.println("producto1 1: "+dr.getResults().get(0).get(1));
		System.out.println("codigo del producto 1"+dr.getColumns()[1]);

		System.out.println("folio renglon 1: "+dr.getResults().get(1).get(0));
		System.out.println("producto1 1: "+dr.getResults().get(1).get(1));
		System.out.println("codigo del producto 1"+dr.getColumns()[1]);
	}

	public static DataWareHouseResult crearDataWareHouse(){
		SparkSession ss = SparkSession.builder()
				.appName("DataWareHouse")
				.master("local")
				.config("spark.sql.warehouse.dir", "file:////tmp")
				.config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
				.master("local[*]")
				.getOrCreate();


		//Dataset<Row> df = ss.read().option("header", "true").csv("./src/main/resources/movAlmacenes.csv");

		Dataset<Row> df = ss.read().format("jdbc")
				.option("url", "jdbc:derby://localhost:1527/c:/var/db-knowledge")
				.option("driver", "org.apache.derby.jdbc.ClientDriver")
				.option("user", "APP")
				.option("password", "APP")
				.option("dbtable", "articulos")
				.load();

		df = df.groupBy(df.col("folio")).pivot("codigo").count().na().fill(0);
		df.show(150,false);

		df.drop(df.col("folio")).coalesce(1).write().option("header", "true").mode(SaveMode.Overwrite).csv(interFile);
		List<Row> list = df.collectAsList();
		DataWareHouseResult dr = new DataWareHouseResult();

		new File(fileOutput).delete();

		File directory = new File(interFile+"/");

		String[] extensions = new String[] {"csv"};
		List<File> files = (List<File>)FileUtils.listFiles(directory, extensions, true);
		files.get(0).renameTo(new File(fileOutput));

		dr.setColumns(df.columns());
		dr.setResults(list);

		return dr;
	}
}
