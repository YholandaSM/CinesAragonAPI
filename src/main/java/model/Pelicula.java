package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Pelicula {

    private String titulo, trailer, sinopsis, fechaEstreno, url;
    private int duracion, nVotos, sPuntuacion, id, id_genero, id_publico;
    private Double precio;
    private Genero genero;
    //private Publico publico

    public Pelicula(int id) {
        this.id = id;
    }
    
    
    
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Pelicula(String titulo, String trailer, String sinopsis, String fechaEstreno, String url, int duracion, int nVotos, int sPuntuacion, int id, Double precio, int id_publico) {
        this.titulo = titulo;
        this.trailer = trailer;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.url = url;
        this.duracion = duracion;
        this.nVotos = nVotos;
        this.sPuntuacion = sPuntuacion;
        this.id = id;
        this.precio = precio;
        this.id_publico = id_publico;
    }

    public Pelicula() {
    }

    //GETTERS & SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getnVotos() {
        return nVotos;
    }

    public void setnVotos(int nVotos) {
        this.nVotos = nVotos;
    }

    public int getsPuntuacion() {
        return sPuntuacion;
    }

    public void setsPuntuacion(int sPuntuacion) {
        this.sPuntuacion = sPuntuacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int idPelicula) {
        this.id = idPelicula;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public int getId_publico() {
        return id_publico;
    }

    public void setId_publico(int id_publico) {
        this.id_publico = id_publico;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", trailer=" + trailer + ", sinopsis=" + sinopsis + ", fechaEstreno=" + fechaEstreno + ", duracion=" + duracion + ", nVotos=" + nVotos + ", sPuntuacion=" + sPuntuacion + ", id=" + id + ", precio=" + precio + '}';
    }

    public static String toCadena(Pelicula pelicula) {
        return "Pelicula{"
                + "titulo=" + pelicula.getTitulo() + ", "
                + "trailer=" + pelicula.getTrailer() + ","
                + " sinopsis=" + pelicula.getSinopsis() + ", "
                + "fechaEstreno=" + pelicula.getFechaEstreno() + ", "
                + "duracion=" + pelicula.getDuracion()
                + ", nVotos=" + pelicula.getnVotos()
                + ", sPuntuacion=" + pelicula.getnVotos()
                + ", id=" + pelicula.getId()
                + ", precio=" + pelicula.getPrecio()
                + ", id_genero" + pelicula.getId_genero()
                + '}';
    }

    public static String
            toArrayJSon(ArrayList<Pelicula> peliculas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(peliculas);

        return resp;
    }

    public static String toObjectJson(Pelicula pelicula) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(pelicula);
        return resp;
    }
}
