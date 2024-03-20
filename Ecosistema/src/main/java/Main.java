import DinamicasPoblacionales.SimuladorEcosistema;

import java.util.Scanner;

public class
Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimuladorEcosistema simulador = new SimuladorEcosistema(); // Asume que esta clase puede manejar la simulación

        while (true) {
            System.out.println("\nMenú de Simulación de Ecosistema:");
            System.out.println("1. Iniciar Simulación");
            System.out.println("2. Visualizar Organismos");
            System.out.println("3. Simular Desastres Naturales");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            String eleccion = scanner.nextLine();

            switch (eleccion) {
                case "1":
                    System.out.println("Iniciando Simulación...");
                    simulador.ejecutarSimulacion(10); // Ejemplo de ejecución por 10 días
                    break;
                case "2":
                    System.out.println("Visualizando Organismos...");
                    simulador.mostrarAnimales();
                    simulador.mostrarPlantas();
                    break;
                case "3":
                    System.out.println("Simulando Desastres Naturales...");
                    simulador.generarEventoAleatorio(); // Asume que esta funcionalidad está implementada
                    break;
                case "4":
                    System.out.println("Saliendo de la Simulación.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Selección no válida. Por favor, intenta de nuevo.");
                    break;
            }
        }
    }
}








