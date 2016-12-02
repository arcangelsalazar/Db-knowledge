package mx.edu.itsm.msc.controllers.login;

import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(loadOnStartup=1)
public class InitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			Statement stm = DataSource.getInstance().getConnection().createStatement();
			stm.execute("CREATE TABLE articulos(folio int not null, codigo varchar(255) not null,"
					+ "descripcion varchar(255) not null, marca varchar(255) not null,"
					+ "marca varchar(255) not null, cantidad int, precio decimal(16,4) not null, "
					+ "categoria varchar(255) not null PRIMARY KEY(folio))");
			stm.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
