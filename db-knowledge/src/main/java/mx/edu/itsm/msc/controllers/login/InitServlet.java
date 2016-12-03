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

	private AgentController dwh;
	private AgentController buy;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		try {
			NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("0.0.0.0"),1527);
			server.start(null); 	
			
			CondVar startUpLatch = new CondVar();
			dwh = Container.getContainer().createNewAgent("AgenteDWH", "mx.edu.itsm.msc.agentedwh.AgenteDWH", new Object[] { startUpLatch });
			dwh.start();
			
			buy = Container.getContainer().createNewAgent("AgenteComprador", "mx.edu.itsm.msc.agenteComprador.AgenteComprador", new Object[] { startUpLatch });
			buy.start();

			try {
				startUpLatch.waitOn();
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
                        
                        Object myObject = "any";
			dwh.putO2AObject(myObject, true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("On shutdown web app");
    }

	public AgentController getDwh() {
		return dwh;
	}

	public AgentController getBuy() {
		return buy;
	}
}
