/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;

/**
 *
 * @author Hp
 */
public class Entrada implements Serializable{
    
    private int idEntrada;
    private Sesion sesion;
    private Compra compra;
    private Butaca butaca;
    float importe;

    public Entrada() {
    }

    public Entrada(int idEntrada, Sesion sesion, Compra compra, Butaca butaca, float importe) {
        this.idEntrada = idEntrada;
        this.sesion = sesion;
        this.compra = compra;
        this.butaca = butaca;
        this.importe = importe;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
     public static String toObjectJson(Entrada entrada) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(entrada);
        return resp;
    }
    
    
    
}
