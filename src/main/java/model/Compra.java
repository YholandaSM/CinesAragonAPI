package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;

/**
 *
 * @author Hp
 */
public class Compra implements Serializable{
    
    private int idCompra;
    private Usuario usuario;
    private String fechaCompra;

    public Compra() {
    }

    public Compra(int idCompra, Usuario usuario, String fechaCompra) {
        this.idCompra = idCompra;
        this.usuario = usuario;
        this.fechaCompra = fechaCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
      public static String toObjectJson(Compra compra) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(compra);
        return resp;
    }
    
}
