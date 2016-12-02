package mx.edu.itsm.msc.jadecontainer;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;

public class Container {

	private static AgentContainer container;
	
	private Container(){
		
	}
	
	public static AgentContainer getContainer(){
		if(container==null){
			jade.core.Runtime myRuntime = jade.core.Runtime.instance();
			Profile myProfile = new ProfileImpl();
			
			container = myRuntime.createMainContainer(myProfile);
		}		
		
		return container;
	}
}
