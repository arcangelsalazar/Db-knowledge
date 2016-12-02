package mx.edu.itsm.msc.controllers.login;

import jade.wrapper.AgentController;

import java.net.InetAddress;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import mx.edu.itsm.msc.jadecontainer.CondVar;
import mx.edu.itsm.msc.jadecontainer.Container;

import org.apache.derby.drda.NetworkServerControl;

@WebServlet(loadOnStartup=1)
public class InitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("0.0.0.0"),1527);
			server.start(null); 	
			
			CondVar startUpLatch = new CondVar();
			AgentController dwh = Container.getContainer().createNewAgent("AgenteDWH", "mx.edu.itsm.msc.agentedwh.AgenteDWH", new Object[] { startUpLatch });
			dwh.start();

			try {
				startUpLatch.waitOn();
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			
			Statement stm = DataSource.getInstance().getConnection().createStatement();
			stm.execute("Select * from articulos");
			stm.getResultSet();
			stm.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
