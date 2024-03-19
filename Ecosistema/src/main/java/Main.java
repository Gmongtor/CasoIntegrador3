import java.util.Scanner;
import DinamicasPoblacionales.SimuladorEcosistema;
import Entidades.Animales;
import Entidades.Planta;
import Entidades.Simulador;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SimuladorEcosistema simulador; // Suponiendo que SimuladorEcosistema incluye métodos para manejar organismos

    public static void main(String[] args) {
        // Inicialización del simulador con parámetros de ejemplo
        simulador = new SimuladorEcosistema("Templado", "Bosque", 1000.0);
        // Aquí podrías añadir algunos animales y plantas a tu simulador para la demostración

        String opcion = "";
        while (!opcion.equals("3")) {
            System.out.println("\nMenú Principal");
            System.out.println("1. Ver Animales");
            System.out.println("2. Ver Plantas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    mostrarOrganismosPorTipo("Animales");
                    break;
                case "2":
                    mostrarOrganismosPorTipo("Plantas");
                    break;
                case "3":
                    System.out.println("Saliendo del simulador...");
                    break;
                default:
                    System.out.println("Opción no reconocida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarOrganismosPorTipo(String tipo) {
        // Implementación detallada de este método aquí
    }

    private static void mostrarAccionesAnimales(Animales animalSeleccionado) {
        // Implementación detallada de este método aquí
    }

    private static void mostrarAccionesPlantas(Planta plantaSeleccionada) {
        // Implementación detallada de este método aquí
    }
}




