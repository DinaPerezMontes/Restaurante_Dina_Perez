import java.util.ArrayDeque;
import java.util.HashSet;
public class Recepcion {
   private HashSet<String> reservas = new HashSet<>();
   private ArrayDeque<Comensal> fila = new ArrayDeque<>();
   public void registrarReserva(String documento) {
   
    if (reservas.add(documento)) {
        System.out.println("Reserva registrada correctamente");
    } else {
        System.out.println("El cliente ya tiene una reserva registrada");
    }
}
     public boolean tieneReserva(String documento) {
    return reservas.contains(documento);
}

public int contarReservas() {
    return reservas.size();
}
public void agregarAFila(Comensal comensal) {

    fila.addLast(comensal);

    System.out.println(
        comensal.getNombre() + " ingresó a la fila"
    );
}
public void sentarPrimero() {

    Comensal primero = fila.pollFirst();

    if (primero != null) {
        System.out.println(
            primero.getNombre() + " pasó a la mesa"
        );
    } else {
        System.out.println("No hay clientes en la fila");
    }
}
public void retirarUltimo() {

    Comensal ultimo = fila.pollLast();

    if (ultimo != null) {
        System.out.println(
            ultimo.getNombre() + " se retiró de la fila"
        );
    } else {
        System.out.println("No hay clientes en la fila");
    }
}
public void consultarSiguiente() {

    Comensal siguiente = fila.peekFirst();

    if (siguiente != null) {
        System.out.println(
            "Siguiente cliente: " + siguiente.getNombre()
        );
    } else {
        System.out.println("No hay clientes en la fila");
    }
}

public int contarFila() {
    return fila.size();




}



   }
   
   




