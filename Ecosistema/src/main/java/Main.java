import Entidades.Animales;
import Entidades.Planta;
import DinamicasPoblacionales.SimuladorEcosistema;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimuladorEcosistema simulador = new SimuladorEcosistema();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nBienvenido al Simulador de Ecosistema");
            System.out.println("1. Ver Organismos");
            System.out.println("2. Configuración del Ecosistema");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    verOrganismos();
                    break;
                case "2":
                    configuracionEcosistema();
                    break;
                case "3":
                    salir = true;
                    System.out.println("Saliendo del simulador...");
                    break;
                default:
                    System.out.println("Opción no reconocida.");
            }
        }
        scanner.close();
    }

    private static void verOrganismos() {
        System.out.println("Elige el tipo de organismo:");
        System.out.println("1. Animales");
        System.out.println("2. Plantas");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                simulador.mostrarAnimales();
                break;
            case "2":
                simulador.mostrarPlantas();
                break;
            default:
                System.out.println("Opción no reconocida.");
        }
    }

    private static void configuracionEcosistema() {
        System.out.println("Generando evento aleatorio en el ecosistema...");
        simulador.generarEventoAleatorio();
    }
}





