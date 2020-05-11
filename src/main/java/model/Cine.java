    
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Cine {
    private int id;
    private String nombre;
    private String loc;

    public Cine() {
    }

    public Cine(int id, String nombre, String loc) {
        this.id = id;
        this.nombre = nombre;
        this.loc = loc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Cine{" + "id=" + id + ", nombre=" + nombre + ", loc=" + loc + '}';
    }
    
    public static String
            toArrayJSon(ArrayList<Cine> cines) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(cines);

        return resp;
    }

    public static String toObjectJson(Cine cine) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(cine);
        return resp;
    }
    
}
