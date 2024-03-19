import DinamicasPoblacionales.SimuladorEcosistema;
import Entidades.Ambiente;
import Entidades.Animales;
import Entidades.Planta;
import SeguridadSistema.GestorAutentificacion;

public class Main {
    public static void main(String[] args) {
        try {
            // Inicializar el sistema de seguridad
            GestorAutentificacion gestorAutenticacion = new GestorAutentificacion();
            gestorAutenticacion.registrarUsuario("admin", "adminPass", "admin");
            gestorAutenticacion.registrarUsuario("user", "userPass", "user");

            // Intento de inicio de sesión
            if (gestorAutenticacion.iniciarSesion("admin", "adminPass")) {
                System.out.println("Inicio de sesión exitoso para admin.");
            } else {
                System.out.println("Inicio de sesión fallido para admin.");
                // Si la autenticación falla, terminar ejecución
                return;
            }

            // Creación del ambiente y del simulador
            Ambiente ambiente = new Ambiente("Templado", "Bosque", 1000);
            SimuladorEcosistema simulador = new SimuladorEcosistema(ambiente);

            // Agregar algunos organismos al simulador
            simulador.agregarOrganismo(new Animales(0, 0, 100, 1, true, 5, 100));
            simulador.agregarOrganismo(new Planta(5, 5, 100, 0, true, 2));

            // Ejecutar la simulación para un número definido de pasos
            System.out.println("Iniciando simulación del ecosistema...");
            simulador.ejecutarSimulacion(10);
            System.out.println("Simulación completada.");

        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la simulación:");
            e.printStackTrace();
        }
    }
}


