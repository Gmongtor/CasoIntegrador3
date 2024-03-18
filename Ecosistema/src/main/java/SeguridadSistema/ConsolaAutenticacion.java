package SeguridadSistema;
import java.util.Scanner;

public class ConsolaAutenticacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuarioCorrecto = "admin";
        String contraseñaCorrecta = "admin123";

        System.out.println("Bienvenido al Sistema de Mensajes Secretos");

        System.out.print("Ingrese usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();

        if (usuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta)) {
            System.out.println("Autenticación exitosa. Bienvenido " + usuario);
            mostrarMensajeSecreto();
        } else {
            System.out.println("Usuario o contraseña incorrectos. Por favor, intente nuevamente.");
        }
    }

    private static void mostrarMensajeSecreto() {
        System.out.println("Mensaje secreto: ¡Java es increíble!");
    }
}



