package mx.edu.itsm.msc.controllers.login;

import jade.wrapper.AgentController;

import java.net.InetAddress;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mx.edu.itsm.msc.jadecontainer.CondVar;
import mx.edu.itsm.msc.jadecontainer.Container;

import org.apache.derby.drda.NetworkServerControl;

@WebListener
public class InitServlet implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
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
	
	@Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("On shutdown web app");
    }
}
