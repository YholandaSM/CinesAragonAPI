/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Hp
 */
public class ParametrosJason implements Serializable{
    
    Pelicula pelicula;
    Cine cine;

    public ParametrosJason() {
    }

    public ParametrosJason(Pelicula pelicula, Cine cine) {
        this.pelicula = pelicula;
        this.cine = cine;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
    
    
    
}
