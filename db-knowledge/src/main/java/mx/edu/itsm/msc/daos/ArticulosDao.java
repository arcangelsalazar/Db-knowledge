package mx.edu.itsm.msc.daos;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.drda.NetworkServerControl;

import mx.edu.itsm.msc.controllers.login.DataSource;

public class ArticulosDao {

	public static List<String> obtenerMasVendidos(){
		List<String> codigos = new ArrayList<>();
		try {
			Connection con = DataSource.getInstance().getConnection();
			Statement stm = con.createStatement();
			stm.execute("select sum(cantidad), codigo from ARTICULOS group by codigo order by  sum(cantidad) desc");
			ResultSet rs = stm.getResultSet();
			
			while (rs.next()) {
				String codigo = rs.getString("codigo");
				codigos.add(codigo);
			}
			stm.close();
			con.close();
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codigos;
	}
	
	public static String descripcionYPrecio(Integer id){
		String res = "";
		try {
			Connection con = DataSource.getInstance().getConnection();

			PreparedStatement stm = con.prepareStatement("select * from ARTICULOS where codigo =?");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				res = id.toString();
				res = res+","+rs.getString("descripcion");
				res = res+","+rs.getString("precio");
			}
			stm.close();
			con.close();
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static String ontenerArticulo(Integer id){
		String res = "";
		try {
			Connection con = DataSource.getInstance().getConnection();

			PreparedStatement stm = con.prepareStatement("select * from ARTICULOS where codigo =?");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				res = id.toString();
				res = res+","+rs.getString("descripcion");
				res = res+","+rs.getString("precio");
			}
			stm.close();
			con.close();
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		try {
			NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("0.0.0.0"),1527);
			server.start(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		System.out.println(ArticulosDao.obtenerMasVendidos().toString());
		System.out.println(ArticulosDao.obtenerMasVendidos().toString());
		System.out.println(ArticulosDao.obtenerMasVendidos().toString());
		System.out.println(ArticulosDao.descripcionYPrecio(10245));
		System.out.println(ArticulosDao.descripcionYPrecio(10245));
		System.out.println(ArticulosDao.descripcionYPrecio(10245));
	}
}
