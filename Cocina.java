
import java.util.PriorityQueue;

public class Cocina {

    private int contadorLlegadas = 0;

    private PriorityQueue<Comanda> comandas =
        new PriorityQueue<>(
            (a, b) -> {
                int resultado = Integer.compare(
                    a.getPrioridad(), b.getPrioridad()
                );

                if (resultado != 0) {
                    return resultado;
                }

                return Integer.compare(
                    a.getLlegada(), b.getLlegada()
                );
            }
        );

    public void recibirComanda(String mesa, int prioridad) {

        if (prioridad < 1 || prioridad > 3) {
            System.out.println("Prioridad invalida");
            return;
        }

        contadorLlegadas++;

        Comanda comanda = new Comanda(
            mesa, prioridad, contadorLlegadas
        );

        comandas.add(comanda);

        System.out.println(
            "Comanda recibida: " + mesa +
            " - Prioridad: " + prioridad +
            " - Llegada: " + contadorLlegadas
        );
    }

public void consultarSiguiente() {

    Comanda siguiente = comandas.peek();

    if (siguiente != null) {
        System.out.println(
            "Siguiente comanda: Mesa " + siguiente.getMesa()
            + " - Prioridad: " + siguiente.getPrioridad()
            + " - Llegada: " + siguiente.getLlegada()
        );
    } else {
        System.out.println("No hay comandas pendientes");
    }
}

public void prepararSiguiente() {

    Comanda siguiente = comandas.poll();

    if (siguiente != null) {
        System.out.println(
            "Preparando comanda de mesa " + siguiente.getMesa()
            + " - Prioridad: " + siguiente.getPrioridad()
            + " - Llegada: " + siguiente.getLlegada()
        );
    } else {
        System.out.println("No hay comandas pendientes");
    }
}

public int contarComandas() {
    return comandas.size();
}

}
