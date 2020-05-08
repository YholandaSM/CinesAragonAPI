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
public class Publico {
    
    private int idPublico;
    private String  nombre;

    public Publico() {
    }

    public Publico(int idPublico, String nombre) {
        this.idPublico = idPublico;
        this.nombre = nombre;
    }

    public int getIdPublico() {
        return idPublico;
    }

    public void setIdPublico(int idPublico) {
        this.idPublico = idPublico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
      public static String toArrayJSon(ArrayList<Publico> lstPublico) {
       
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(lstPublico);

            return resp;
        }
    
}
