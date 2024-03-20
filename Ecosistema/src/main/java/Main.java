import DinamicasPoblacionales.SimuladorEcosistema;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Datos del usuario para el acceso
        final String USERNAME = "admin";
        final String PASSWORD = "1234";

        // Solicita el nombre de usuario y la contraseña
        System.out.println("Bienvenido a la Simulación del Ecosistema");
        System.out.print("Ingrese el nombre de usuario: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String passwordInput = scanner.nextLine();

        // Verifica las credenciales
        if (!USERNAME.equals(usernameInput) || !PASSWORD.equals(passwordInput)) {
            System.out.println("Usuario o contraseña incorrectos. Acceso denegado.");
            return;
        }

        // Si las credenciales son correctas, procede con el menú de la simulación
        SimuladorEcosistema simulador = new SimuladorEcosistema();

        while (true) {
            System.out.println("\nMenú de Simulación de Ecosistema:");
            System.out.println("1. Iniciar Simulación");
            System.out.println("2. Visualizar Organismos y Estadísticas");
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
                    System.out.println("Visualizando Organismos y Estadísticas...");
                    simulador.mostrarAnimales();
                    simulador.mostrarPlantas();
                    System.out.println(simulador.mostrarEstadisticas()); // Muestra estadísticas
                    break;
                case "3":
                    System.out.println("Simulando Desastres Naturales...");
                    simulador.generarEventoAleatorio(); // Ejecuta un evento aleatorio
                    System.out.println(simulador.mostrarEstadisticas()); // Muestra estadísticas después del evento
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










