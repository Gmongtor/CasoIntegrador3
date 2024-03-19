import java.util.Scanner;
import java.util.List;
import DinamicasPoblacionales.SimuladorEcosistema;
import Entidades.Animales;
import Entidades.Planta;
import Entidades.Simulador;




private static void mostrarOrganismosPorTipo(String tipo) {
    // Simulación de obtener listas de animales y plantas
    List<Animales> animales = simulador.getAnimales(); // Asume que esta función existe
    List<Planta> plantas = simulador.getPlantas(); // Asume que esta función existe

    if ("Animales".equals(tipo)) {
        for (int i = 0; i < animales.size(); i++) {
            System.out.println((i + 1) + ". " + animales.get(i).getNombre()); // Asume que Animales tiene un método getNombre()
        }
        System.out.println("Seleccione un animal para ver acciones disponibles o escriba 'volver' para regresar:");
        String input = scanner.nextLine();
        if (!"volver".equalsIgnoreCase(input)) {
            int seleccion = Integer.parseInt(input) - 1;
            mostrarAccionesAnimales(animales.get(seleccion));
        }
    } else if ("Plantas".equals(tipo)) {
        for (int i = 0; i < plantas.size(); i++) {
            System.out.println((i + 1) + ". " + plantas.get(i).getNombre()); // Asume que Planta tiene un método getNombre()
        }
        System.out.println("Seleccione una planta para ver acciones disponibles o escriba 'volver' para regresar:");
        String input = scanner.nextLine();
        if (!"volver".equalsIgnoreCase(input)) {
            int seleccion = Integer.parseInt(input) - 1;
            mostrarAccionesPlantas(plantas.get(seleccion));
        }
    }
}
private static void mostrarAccionesAnimales(Animales animalSeleccionado) {
    System.out.println("1. Predar");
    System.out.println("2. Reproducirse");
    System.out.println("Seleccione una acción para este animal o escriba 'volver' para regresar:");
    String accion = scanner.nextLine();
    switch (accion) {
        case "1":
            // animalSeleccionado.predar(); Asume que este método existe y está implementado
            System.out.println("Predando...");
            break;
        case "2":
            // animalSeleccionado.reproducirse(); Asume que este método existe y está implementado
            System.out.println("Reproduciéndose...");
            break;
        case "volver":
            return;
        default:
            System.out.println("Acción no reconocida.");
            break;
    }
}

private static void mostrarAccionesPlantas(Planta plantaSeleccionada) {
    System.out.println("1. Polinizar");
    System.out.println("Seleccione una acción para esta planta o escriba 'volver' para regresar:");
    String accion = scanner.nextLine();
    switch (accion) {
        case "1":
            // plantaSeleccionada.polinizar(); Asume que este método existe y está implementado
            System.out.println("Polinizando...");
            break;
        case "volver":
            return;
        default:
            System.out.println("Acción no reconocida.");
            break;
    }
}



