/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.agentedwh;

import jade.core.behaviours.Behaviour;

import java.util.logging.Level;
import java.util.logging.Logger;
//import org.jpl7.Query;

import mx.edu.itsm.msc.controllers.dwh.DataWareHouse;

/**
 *
 * @author arcangel.salazar
 */
public class ComportamientoDWH extends Behaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5674910113407634212L;

	@Override
	public void action() {
		try {
			DataWareHouse.crearDataWareHouse();
		} catch (Exception ex) {
			Logger.getLogger(ComportamientoDWH.class.getName()).log(Level.SEVERE, null, ex);
		} 
	}

	@Override
	public boolean done() {
		return false;
	}

}
