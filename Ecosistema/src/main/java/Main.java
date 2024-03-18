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
            }

            // Creación del ambiente
            Ambiente ambiente = new Ambiente("Templado", "Bosque", 1000);

            // Crear simulador
            SimuladorEcosistema simulador = new SimuladorEcosistema(ambiente);

            // Agregar algunos organismos
            simulador.agregarOrganismo(new Animales(0, 0, 100, 1, true, 5, 100)); // Ejemplo, asumiendo que tienes un constructor adecuado
            simulador.agregarOrganismo(new Planta(5, 5, 100, 0, true, 2)); // Ejemplo, asumiendo que tienes un constructor adecuado

            // Ejecutar simulación
            simulador.ejecutarSimulacion(10); // Simular 10 pasos

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

