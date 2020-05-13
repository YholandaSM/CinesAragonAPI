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
    
    private Pelicula pelicula;
    private Cine cine;
    private Genero genero;
    private Publico publico;

    public ParametrosJason() {
    }

    public ParametrosJason(Pelicula pelicula, Cine cine) {
        this.pelicula = pelicula;
        this.cine = cine;
    }

    public ParametrosJason(Cine cine, Genero genero, Publico publico) {
        this.cine = cine;
        this.genero = genero;
        this.publico = publico;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Publico getPublico() {
        return publico;
    }

    public void setPublico(Publico publico) {
        this.publico = publico;
    }
    
    
    
}
