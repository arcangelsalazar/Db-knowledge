/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.cliente;

/**
 *
 * @author BIGZENER
 */
public class Prueba {
    public static void main(String arg[]) throws InterruptedException{
        Cliente c =new Cliente();
        while(true){
            c.send("probando");
            Thread.sleep(1000);
        }
    }
}
