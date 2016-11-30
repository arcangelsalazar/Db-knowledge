package mx.edu.itsm.msc.controllers.login;

import java.util.List;

import org.apache.spark.sql.Row;

public class DataWareHouseResult {
	private List<Row> results;
	private String[] columns;
	
	public List<Row> getResults() {
		return results;
	}
	public void setResults(List<Row> results) {
		this.results = results;
	}
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
}
