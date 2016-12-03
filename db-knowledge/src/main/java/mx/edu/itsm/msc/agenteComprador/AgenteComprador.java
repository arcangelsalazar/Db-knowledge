/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.agenteComprador;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.AgentController;

import java.net.InetAddress;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mx.edu.itsm.msc.controllers.login.DataSource;
import mx.edu.itsm.msc.jadecontainer.CondVar;
import mx.edu.itsm.msc.jadecontainer.Container;

import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author arcangel.salazar
 */
public class AgenteComprador extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3011381440196651905L;

	MessageTemplate mt1 = 
			MessageTemplate.and(  
					MessageTemplate.MatchPerformative( 1 ),
					MessageTemplate.MatchSender( new AID( "any", AID.ISLOCALNAME))) ;

	@Override
	protected void setup() {
		System.out.println("iniciando agente");
		setEnabledO2ACommunication(true, 0);

		Object[] args = getArguments();
		if(args.length > 0) {
			CondVar latch = (CondVar)args[0];
			latch.signal();
		}

		addBehaviour(new CyclicBehaviour(this) 
		{
			public void action( ) 
			{  
				System.out.print("Behaviour ONE: ");
				Object myObject = myAgent.getO2AObject();
				if(myObject != null){
					System.out.println(myObject.toString());
					insertarEnDB(myObject.toString());
				}

				ACLMessage msg= receive( mt1 );
				if (msg!=null){
					System.out.println( "gets " 
							+  msg.getPerformative() + " from "
							+  msg.getSender().getLocalName() + "="
							+  msg.getContent() );
					insertarEnDB(msg.getContent());
					
				}
				else{
					System.out.println( "gets NULL" );
				}

				block();
			}
		});
	}
	
	

	public void insertarEnDB(String params){
		String codigo = params;
		try {
			Statement stm1 = DataSource.getInstance().getConnection().createStatement();
			
			ResultSet rs = stm1.executeQuery("SELECT max(folio) as folio from articulos");
			
			rs.next();
			int folio = rs.getInt("folio");
			folio++;			
			
			PreparedStatement stm = DataSource.getInstance().getConnection().prepareStatement(
					"SELECT * from articulos where codigo=?");
			stm.setString(1, codigo);
			System.out.println(codigo);
			rs = stm.executeQuery();
			
			if (rs.next()) {
				stm = DataSource.getInstance().getConnection().prepareStatement(
						"INSERT INTO articulos(folio, codigo, descripcion, marca, cantidad, precio, categoria ) "
						+ "VALUES(?,?,?,?,?,?,?)");
				stm.setInt(1, folio);
				stm.setString(2, rs.getString("codigo"));
				stm.setString(3, rs.getString("descripcion"));
				stm.setString(4, rs.getString("marca"));
				stm.setInt(5, rs.getInt("cantidad"));
				stm.setBigDecimal(6, rs.getBigDecimal("precio"));
				stm.setString(7, rs.getString("categoria"));
				stm.executeUpdate();
				stm.close();
				
			}
			
			
			
			System.out.println("Agregado exitosamente");
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		 	
		
		AgentController rma;
		try {
			NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("0.0.0.0"),1527);
			server.start(null);			
			
			CondVar startUpLatch = new CondVar();
			rma = Container.getContainer().createNewAgent("AgenteComprador", "mx.edu.itsm.msc.agenteComprador.AgenteComprador", new Object[] { startUpLatch });
			rma.start();

			try {
				startUpLatch.waitOn();
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			Object myObject = "150014";
			rma.putO2AObject(myObject, true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
