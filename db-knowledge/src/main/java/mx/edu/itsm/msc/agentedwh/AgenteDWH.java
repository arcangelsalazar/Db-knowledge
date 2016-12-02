/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.agentedwh;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import mx.edu.itsm.msc.controllers.dwh.DataWareHouse;
import mx.edu.itsm.msc.jadecontainer.CondVar;
import mx.edu.itsm.msc.jadecontainer.Container;

/**
 *
 * @author arcangel.salazar
 */
public class AgenteDWH extends Agent{

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
					DataWareHouse.crearDataWareHouse();
				}

				ACLMessage msg= receive( mt1 );
				if (msg!=null){
					System.out.println( "gets " 
							+  msg.getPerformative() + " from "
							+  msg.getSender().getLocalName() + "="
							+  msg.getContent() );
					DataWareHouse.crearDataWareHouse();
				}
				else{
					System.out.println( "gets NULL" );
				}

				block();
			}
		});
	}


	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		AgentController rma;
		try {

			CondVar startUpLatch = new CondVar();
			rma = Container.getContainer().createNewAgent("AgenteDWH", "mx.edu.itsm.msc.agentedwh.AgenteDWH", new Object[] { startUpLatch });
			rma.start();

			try {
				startUpLatch.waitOn();
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			Object myObject = "any";
			rma.putO2AObject(myObject, true);
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}

	}
}
