import java.util.Scanner;
import Entidades.Ambiente;
import Entidades.Animales;
import Entidades.Planta;
import DinamicasPoblacionales.SimuladorEcosistema;
import DinamicasPoblacionales.EstadisticasEcosistema;
import DinamicasPoblacionales.EventoAleatorio;
import SeguridadSistema.RegistroActividades;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String contrasenaCorrecta = "1234"; // Contraseña simplificada para el ejemplo

        System.out.println("Por favor, ingresa la contraseña para acceder a la simulación del ecosistema:");
        String contrasenaIngresada = scanner.nextLine();

        if (!contrasenaIngresada.equals(contrasenaCorrecta)) {
            System.out.println("Contraseña incorrecta. Acceso denegado.");
            return; // Termina el programa si la contraseña es incorrecta
        }
        // Inicializar el ambiente y los organismos
        Ambiente ambiente = new Ambiente("Templado", "Bosque", 1000);
        // Ejemplos de animales y plantas
        // Añadir aquí los ejemplos adicionales

        System.out.println("¿Qué deseas visualizar? [animales, plantas, desastres]:");
        String seleccion = scanner.nextLine();

        switch (seleccion.toLowerCase()) {
            case "animales":
                // Simular y mostrar animales
                break;
            case "plantas":
                // Simular y mostrar plantas
                break;
            case "desastres":
                // Permitir al usuario desencadenar un desastre natural
                System.out.println("Introduce el desastre a simular [lluvia, sequía, incendio, inundación, cambio estacional]:");
                String desastre = scanner.nextLine();
                ambiente.simularEvento(desastre);
                break;
            default:
                System.out.println("Selección no válida.");
                break;
        }
        // Inicializar el ambiente y los organismos
        Ambiente ambiente = new Ambiente("Templado", "Bosque", 1000);
        // Ejemplos de animales y plantas
        // Añadir aquí los ejemplos adicionales

        System.out.println("¿Qué deseas visualizar? [animales, plantas, desastres]:");
        String seleccion = scanner.nextLine();

        switch (seleccion.toLowerCase()) {
            case "animales":
                // Simular y mostrar animales
                break;
            case "plantas":
                // Simular y mostrar plantas
                break;
            case "desastres":
                // Permitir al usuario desencadenar un desastre natural
                System.out.println("Introduce el desastre a simular [lluvia, sequía, incendio, inundación, cambio estacional]:");
                String desastre = scanner.nextLine();
                ambiente.simularEvento(desastre);
                break;
            default:
                System.out.println("Selección no válida.");
                break;
        }
    }
}

        // Continuar con el resto de la simulación si la contraseña es correcta
