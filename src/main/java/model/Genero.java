/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Genero {

    
    private int idGenero;
    private String genero;

    public Genero() {
    }

    public Genero(int idGenero, String genero) {
        this.idGenero = idGenero;
        this.genero = genero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public static String toArrayJSon(ArrayList<Genero> lstGeneros) {
       
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(lstGeneros);

            return resp;
        }

}
