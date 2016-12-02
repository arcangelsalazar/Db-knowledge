package mx.edu.itsm.msc.daos;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.InetAddress;
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
			Statement stm = DataSource.getInstance().getInstance().getConnection().createStatement();
			stm.execute("select sum(cantidad), codigo from ARTICULOS group by codigo order by  sum(cantidad) desc");
			ResultSet rs = stm.getResultSet();
			
			while (rs.next()) {
				String codigo = rs.getString("codigo");
				codigos.add(codigo);
			}
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codigos;
	}
	
	public static String descripcionYPrecio(Integer id){
		String res = "";
		try {
			PreparedStatement stm = DataSource.getInstance().getConnection().prepareStatement("select * from ARTICULOS where id =?");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				res = id.toString();
				res = res+","+rs.getString("descripcion");
				res = res+","+rs.getString("precio");
			}
			
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
		System.out.println(ArticulosDao.descripcionYPrecio(1));
	}
}
