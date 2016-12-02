package mx.edu.itsm.msc.controllers.apriori;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Profesor Bastar
 */
public class Main {

    public static void main(String[] args) throws IOException {

        double minSup = .10;
        double minCon = .01;

        ArrayList<String> lectura = leerCsv("./src/main/resources/result.csv/part-r-00000-38d761f7-f7ad-47f3-afea-9fa18bb201c4.csv");
        String dum[] = lectura.get(0).split(",");
        int m[][] = new int[lectura.size()][dum.length];

        for (int i = 1; i < lectura.size(); i++) {
            String renglon[] = lectura.get(i).split(",");
            for (int j = 1; j < m[i].length; j++) {
                m[i][j] = Integer.parseInt(renglon[j]);
            }
        }
        ArrayList<ReglaAsociacion> reglas
                = AlgoritmoApriory.generaReglasDeAsociacion(m, minSup, minCon);
        if (reglas != null) {
            for (ReglaAsociacion regla : reglas) {
                System.out.println("Regla: " + regla + " confianza de " + regla.getConfianza());
            }
        }
    }

    public static ArrayList<String> leerCsv(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        ArrayList<String> salida = new ArrayList<>();
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            salida.add(cadena);
        }
        b.close();
        return salida;
    }

}
