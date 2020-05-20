package model;

/**
 *
 * @author Hp
 */
public class CompraEntrada {

    private Compra compra;
    private Entrada entrada;

    public CompraEntrada() {
    }

    public CompraEntrada(Compra compra, Entrada entrada) {
        this.compra = compra;
        this.entrada = entrada;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

}
