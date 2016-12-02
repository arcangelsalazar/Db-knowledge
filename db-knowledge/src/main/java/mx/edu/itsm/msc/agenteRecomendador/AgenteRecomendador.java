/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.agenteRecomendador;

import jade.core.Agent;

/**
 *
 * @author BIGZENER
 */
public class AgenteRecomendador extends Agent{
    @Override
    protected void setup() {
        System.out.println("iniciando agente");
        addBehaviour(new Comportamiento());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
