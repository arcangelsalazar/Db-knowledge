package mx.edu.itsm.msc.controllers.apriori;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

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

        double minSup = .50;
        double minCon = .20;

        ArrayList<String> lectura = leerCsv("./src/main/resources/result/part-r-00000-c5827cc1-6fee-49b0-9bdc-eae3c5e4f6bc.csv");
        String dum[] = lectura.get(0).split(",");
        int m[][] = new int[lectura.size()][dum.length];
        //For
        int ides[] = new int[dum.length];

        for (int i = 0; i < ides.length; i++) {
            ides[i] = Integer.parseInt(dum[i]);
        }

        System.out.println("---");
        for (int i = 1; i < lectura.size(); i++) {
            String renglon[] = lectura.get(i).split(",");
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = Integer.parseInt(renglon[j]);
            }
        }
        ArrayList<ReglaAsociacion> reglas
                = AlgoritmoApriory.generaReglasDeAsociacion(m, minSup, minCon);

        ArrayList<ReglaAsociacion> reglasConID = AlgoritmoApriory.convierteReglasAID(reglas, ides);

        if (reglas != null) {
            for (ReglaAsociacion regla : reglasConID) {
                System.out.println(regla);
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
