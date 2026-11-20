
public class Comanda {

    private String mesa;
    private int prioridad;
    private int llegada;

    public Comanda(String mesa, int prioridad, int llegada) {
        this.mesa = mesa;
        this.prioridad = prioridad;
        this.llegada = llegada;
    }

    public String getMesa() {
        return mesa;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getLlegada() {
        return llegada;
    }
}
