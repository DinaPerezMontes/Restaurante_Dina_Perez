import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
public class Carta {

    private HashMap<String, Plato> platos = new HashMap<>();
    private LinkedHashMap<String, Plato> memoria =
    new LinkedHashMap<>(3, 0.75f, true);
    private LinkedHashSet<String> categoriasServidas =
    new LinkedHashSet<>();


    public void registrarPlato(Plato plato) {

        if (platos.containsKey(plato.getCodigo())) {
            System.out.println("El codigo ya existe");
        } else {
            platos.put(plato.getCodigo(), plato);
            System.out.println("Plato registrado correctamente");
        }
    }

public void buscarPlato(String codigo) {

    Plato plato = platos.get(codigo);

    if (plato != null) {
        System.out.println("Plato: " + plato.getNombre());
        System.out.println("Categoria: " + plato.getCategoria());
    } else {
        System.out.println("El plato no existe");
    }
}

public void eliminarPlato(String codigo) {

    Plato eliminado = platos.remove(codigo);

    if (eliminado != null) {
        System.out.println("Plato eliminado: " + eliminado.getNombre());
    } else {
        System.out.println("El plato no existe");
    }
}

public void listarPlatos() {

    if (platos.isEmpty()) {
        System.out.println("No hay platos registrados");
        return;
    }

    for (Plato plato : platos.values()) {
        System.out.println(
            plato.getCodigo() + " - " +
            plato.getNombre() + " - " +
            plato.getCategoria()
        );
    }
}

public void consultarRapido(String codigo) {

    if (memoria.containsKey(codigo)) {
        Plato plato = memoria.get(codigo);

        System.out.println(
            "Consulta rapida desde memoria: " + plato.getNombre()
        );
        return;
    }

    Plato plato = platos.get(codigo);

    if (plato == null) {
        System.out.println("El plato no existe");
        return;
    }

    if (memoria.size() == 3) {
        String antiguo = memoria.keySet().iterator().next();
        memoria.remove(antiguo);
    }

    memoria.put(codigo, plato);

    System.out.println(
        "Plato consultado desde carta: " + plato.getNombre()
    );
}

public void registrarCategoria(String categoria) {

    if (categoriasServidas.add(categoria)) {
        System.out.println("Categoria registrada: " + categoria);
    } else {
        System.out.println("La categoria ya estaba registrada");
    }
}

public void listarCategorias() {

    if (categoriasServidas.isEmpty()) {
        System.out.println("No hay categorias registradas");
        return;
    }

    for (String categoria : categoriasServidas) {
        System.out.println(categoria);
    }
}

public int contarCategorias() {
    return categoriasServidas.size();
}

}
