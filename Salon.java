import java.util.ArrayList;
public class Salon {

    private ArrayList<Comensal> comensales = new ArrayList<>();

    public void agregarComensal(Comensal comensal) {
        comensales.add(comensal);

        System.out.println(
            comensal.getNombre() + " fue agregado al salon"
        );
    }

public void listarPorApellido() {

    ArrayList<Comensal> listaOrdenada =
        new ArrayList<>(comensales);

    listaOrdenada.sort(
        (a, b) -> a.getApellido().compareToIgnoreCase(b.getApellido())
    );

    for (Comensal comensal : listaOrdenada) {
        System.out.println(
            comensal.getApellido() + " " + comensal.getNombre()
        );
    }
}

public void retirarComensal(int posicion) {

    if (posicion >= 0 && posicion < comensales.size()) {

        Comensal retirado = comensales.remove(posicion);

        System.out.println(
            retirado.getNombre() + " fue retirado del salon"
        );

    } else {
        System.out.println("La posicion no existe");
    }
}
public int contarComensales() {
    return comensales.size();
}
}