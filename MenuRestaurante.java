
import java.util.Scanner;

public class MenuRestaurante {

    private Scanner scanner = new Scanner(System.in);

    private Recepcion recepcion = new Recepcion();
    private Salon salon = new Salon();
    private Receta receta = new Receta();
    private Carta carta = new Carta();
    private Cocina cocina = new Cocina();

    public void iniciar() {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n=== RESTAURANTE ===");
            System.out.println("1. Registrar reserva");
            System.out.println("2. Consultar reserva");
            System.out.println("3. Agregar cliente a fila");
            System.out.println("4. Contar clientes en fila");
            System.out.println("5. Registrar comanda");
            System.out.println("6. Consultar siguiente comanda");
            System.out.println("7. Preparar siguiente comanda");
            System.out.println("8. Contar comandas");
            System.out.println("9. Sentar primer cliente");
            System.out.println("10. Retirar ultimo cliente");
            System.out.println("11. Consultar siguiente cliente");
            System.out.println("12. Contar reservas");
            System.out.println("13. Agregar comensal al salon");
            System.out.println("14. Listar comensales por apellido");
            System.out.println("15. Retirar comensal por posicion");
            System.out.println("16. Contar comensales del salon");
            System.out.println("17. Agregar paso a receta");
            System.out.println("18. Insertar paso en receta");
            System.out.println("19. Eliminar paso de receta");
            System.out.println("19. Eliminar paso de receta");
            System.out.println("20. Mostrar receta");
            System.out.println("21. Registrar plato");
            System.out.println("22. Buscar plato");
            System.out.println("23. Eliminar plato");
            System.out.println("24. Listar platos");
            System.out.println("25. Consultar plato rapidamente");
            System.out.println("26. Registrar categoria servida");
            System.out.println("27. Listar categorias servidas");
            System.out.println("28. Contar categorias servidas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            String entrada = scanner.nextLine();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido");
                opcion = -1;
                continue;
            }

            switch (opcion) {

                case 1:
                    System.out.print("Documento: ");
                    String documento = scanner.nextLine();
                    recepcion.registrarReserva(documento);
                    break;

                case 2:
                    System.out.print("Documento: ");
                    String consulta = scanner.nextLine();
                    System.out.println(
                            "Tiene reserva: " +
                                    recepcion.tieneReserva(consulta));
                    break;

                case 3:
                    System.out.print("Documento: ");
                    String doc = scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();

                    Comensal comensal = new Comensal(doc, nombre, apellido);

                    recepcion.agregarAFila(comensal);
                    break;

                case 4:
                    System.out.println(
                            "Clientes esperando: " +
                                    recepcion.contarFila());
                    break;

                case 5:
                    System.out.print("Mesa: ");
                    String mesa = scanner.nextLine();

                    System.out.print("Prioridad (1, 2 o 3): ");
                    String valor = scanner.nextLine();

                    try {
                        int prioridad = Integer.parseInt(valor);
                        cocina.recibirComanda(mesa, prioridad);
                    } catch (NumberFormatException e) {
                        System.out.println("Prioridad invalida");
                    }
                    break;

                case 6:
                    cocina.consultarSiguiente();
                    break;

                case 7:
                    cocina.prepararSiguiente();
                    break;

                case 8:
                    System.out.println(
                            "Comandas pendientes: " +
                                    cocina.contarComandas());
                    break;

                case 9:
                    recepcion.sentarPrimero();
                    break;

                case 10:
                    recepcion.retirarUltimo();
                    break;

                case 11:
                    recepcion.consultarSiguiente();
                    break;

                case 12:
                    System.out.println(
                            "Total de reservas: " +
                                    recepcion.contarReservas());
                    break;

                case 13:
                    // Agregar comensal al salon
                    break;

                case 14:
                    salon.listarPorApellido();
                    break;

                case 15:
                    // Retirar comensal por posicion
                    break;

                case 16:
                    System.out.println(
                            "Comensales en salon: " + salon.contarComensales());
                    break;

                case 17:
                    System.out.print("Escribe el nuevo paso: ");
                    String nuevoPaso = scanner.nextLine();
                    receta.agregarPaso(nuevoPaso);
                    break;

                case 18:
                    System.out.print("Despues de que paso deseas insertar: ");
                    String referencia = scanner.nextLine();

                    System.out.print("Escribe el nuevo paso: ");
                    String pasoInsertar = scanner.nextLine();

                    receta.insertarPaso(referencia, pasoInsertar);
                    break;

                case 19:
                    System.out.print("Escribe el paso que deseas eliminar: ");
                    String pasoEliminar = scanner.nextLine();

                    receta.eliminarPaso(pasoEliminar);
                    break;

                case 20:
                    receta.mostrarReceta();
                    break;

                case 21:
                    System.out.print("Codigo del plato: ");
                    String codigoPlato = scanner.nextLine();

                    System.out.print("Nombre del plato: ");
                    String nombrePlato = scanner.nextLine();

                    System.out.print("Categoria del plato: ");
                    String categoriaPlato = scanner.nextLine();

                    Plato nuevoPlato = new Plato(
                            codigoPlato, nombrePlato, categoriaPlato);

                    carta.registrarPlato(nuevoPlato);
                    break;

                case 22:
                    System.out.print("Codigo del plato a buscar: ");
                    String codigoBuscar = scanner.nextLine();

                    carta.buscarPlato(codigoBuscar);
                    break;

                case 23:
                    System.out.print("Codigo del plato a eliminar: ");
                    String codigoEliminar = scanner.nextLine();

                    carta.eliminarPlato(codigoEliminar);
                    break;

                case 24:
                    carta.listarPlatos();
                    break;

                case 25:
                    System.out.print("Codigo del plato a consultar: ");
                    String codigoRapido = scanner.nextLine();

                    carta.consultarRapido(codigoRapido);
                    break;

                case 26:
                    System.out.print("Categoria servida: ");
                    String categoriaServida = scanner.nextLine();

                    carta.registrarCategoria(categoriaServida);
                    break;

                case 27:
                    carta.listarCategorias();
                    break;

                case 28:
                    System.out.println(
                            "Total de categorias servidas: " +
                                    carta.contarCategorias());
                    break;

                case 0:
                    System.out.println("Hasta pronto");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}
