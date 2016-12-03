/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BIGZENER
 */
public class Cliente {
    private int port=2550;
    private Socket client;
    private String ip="localhost";
    public BufferedWriter write;
    private BufferedReader reader;
    
    public Cliente(String ip,int puerto) {
        this.ip=ip;
        this.port=puerto;
        init();
    }
    private void init(){
        try {
            client=new Socket();
            client.connect(new InetSocketAddress(InetAddress.getByName(ip).getHostAddress(),port));
            write=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Cliente() {
        init();
    }    
    public String get(){       
        if(reader!=null)
        try {
            
            return reader.readLine();
        } catch (IOException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    public void send(String s){
        try {
            write.write(s+"\n");
            write.flush();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
