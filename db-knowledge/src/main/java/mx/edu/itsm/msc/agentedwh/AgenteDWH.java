/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.agentedwh;

import jade.core.Agent;

/**
*
* @author arcangel.salazar
*/
public class AgenteDWH extends Agent{
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3011381440196651905L;
	
	
	@Override
    protected void setup() {
        System.out.println("iniciando agente");
        addBehaviour(new ComportamientoDWH());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
