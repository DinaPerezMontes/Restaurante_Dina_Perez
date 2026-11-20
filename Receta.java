import java.util.ArrayList;

public class Receta {
    private ArrayList<String> pasos = new ArrayList<>();

    public void agregarPaso(String paso) {

        pasos.add(paso);

        System.out.println("Paso agregado: " + paso);
    }
public void insertarPaso(String referencia, String nuevoPaso) {

    int posicion = pasos.indexOf(referencia);

    if (posicion != -1) {

        pasos.add(posicion + 1, nuevoPaso);

        System.out.println("Paso insertado: " + nuevoPaso);

    } else {

        System.out.println("El paso de referencia no existe");

    }

}
public void eliminarPaso(String paso) {

    if (pasos.remove(paso)) {
        System.out.println("Paso eliminado: " + paso);
    } else {
        System.out.println("El paso no existe en la receta");
    }

}

public void mostrarReceta() {

    if (pasos.isEmpty()) {
        System.out.println("La receta no tiene pasos");
        return;
    }

    for (int i = 0; i < pasos.size(); i++) {

        System.out.println(
            (i + 1) + ". " + pasos.get(i)
        );

    }
}

}

