package model;

/**
 *
 * @author Hp
 */
public class Sala {
    private int idSala;
    private String planta;
    private Cine cine;

    public Sala() {
    }

    public Sala(int idSala) {
        this.idSala = idSala;
    }
    
    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
    
    
}
