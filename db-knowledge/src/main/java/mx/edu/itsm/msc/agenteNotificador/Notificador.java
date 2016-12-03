/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.agenteNotificador;

import jade.core.behaviours.Behaviour;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPSyntaxErrorException;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPTermParser;

/**
 *
 * @author BIGZENER
 */
public class Notificador extends Behaviour {

    private ServerSocket server;
    private int port=2551;//recomendador
    ObjectInputStream reader;
    private ObjectOutputStream write;
    
    public void inid(){
        
    }

    
    
    @Override
    public void action() {
    }

    @Override
    public boolean done() {
        return false;
    }
    
    public static void main(String[] args) {
    	// New instance of Prolog engine
    	JIPEngine jip = new JIPEngine();

    	JIPTerm query = null;

    	try
    	{            
    	    jip.compileFile("./reglas.pl");
    	    jip.loadFile("reglas.jip");
    		// parse query
    	    JIPTermParser parser = jip.getTermParser();
    	    query = parser.parseTerm("transaccion(X,150014)");
    	 // open a synchronous query
        	JIPQuery jipQuery = jip.openSynchronousQuery(query);
        	JIPTerm solution;

        	
        	// Loop while there is another solution
        	while (jipQuery.hasMoreChoicePoints())
        	{
        	    solution = jipQuery.nextSolution();
        	    System.out.println(solution);
        	}   
    	}
    	catch(JIPSyntaxErrorException ex)
    	{
    	    // there is a syntax error in the query
    	    ex.printStackTrace();
    	    System.exit(0);
    	}        
	}
}
