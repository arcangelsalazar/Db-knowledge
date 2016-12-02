/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.agenteNotificador;

import gnu.prolog.term.AtomTerm;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.PrologException;
import jade.core.behaviours.Behaviour;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Environment ev = new Environment();
        ev.ensureLoaded(AtomTerm.get(""));
        Interpreter it = ev.createInterpreter();
        
        ev.runInitialization(it);
        
        try {
			it.runOnce(null);
		} catch (PrologException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        //Query.hasSolution("use_module(library(jpl))"); // only because we call e.g. jpl_pl_syntax/1 below
	
        String t1 = "consult('reglas.pl')";
        //System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
                
        
    }

    private void initSocket(){
        try {
            System.out.println("abriendo socket");
            server=new ServerSocket(port);
            Socket client=server.accept();
            reader=new ObjectInputStream(client.getInputStream());
            write=new ObjectOutputStream(client.getOutputStream());     
            
            System.out.println("socket abierto");
        } catch (IOException ex) {
            Logger.getLogger(Notificador.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    public Notificador() {
        inid();
        initSocket();
    }
    
    @Override
    public void action() {
        //try {
//            Object entrada;
//            entrada=reader.readObject();
//            System.out.println(entrada.toString());
//            
//            String t1 = "consult('reglas.pl')";
//            //System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
//            
//            String resultado="";
//            String t4 = "transaccion(X,"+entrada.toString()+")";
		//System.out.println("first solution of " + t4 + ": X = " + Query.oneSolution(t4).get("Y"));
//		Map<String, Term>[] ss4 = Query.allSolutions(t4);
//		for (int i = 0; i < ss4.length; i++) {
//			resultado+=(ss4[i].get("X"))+",";
//			System.out.println("X = " + ss4[i]);
//		}
//        
//            write.writeObject(resultado);
//        
//        } catch (IOException ex) {
//            Logger.getLogger(Comportamiento.class.getName()).log(Level.SEVERE, null, ex);
//            initSocket();
//        } catch (PrologException pex) {
//            try {
//                write.writeObject("");
//            } catch (IOException ex) {
//                Logger.getLogger(Notificador.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Notificador.class.getName()).log(Level.SEVERE, null, ex);
//        } 
    }

    @Override
    public boolean done() {
        return false;
    }
    
}
