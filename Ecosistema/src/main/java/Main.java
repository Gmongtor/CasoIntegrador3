import DinamicasPoblacionales.SimuladorEcosistema;
import Entidades.Ambiente;
import Entidades.Organismo;
import SeguridadSistema.GestorAutentificacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static SimuladorEcosistema simulador;
    private static GestorAutentificacion gestorAutenticacion;

    public static void main(String[] args) {
        try {
            iniciarSistemaDeSeguridad();
            crearSimuladorEcosistema();

            String opcion = "";
            while (!"3".equals(opcion)) {
                mostrarMenuPrincipal();
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
        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la simulación:");
            e.printStackTrace();
        }
    }

    private static void iniciarSistemaDeSeguridad() {
        // Simula la inicialización del sistema de seguridad y el inicio de sesión
        gestorAutenticacion = new GestorAutentificacion();
        System.out.println("Sistema de seguridad inicializado.");
    }

    private static void crearSimuladorEcosistema() {
        // Crear el ambiente y el simulador
        Ambiente ambiente = new Ambiente("Templado", "Bosque", 1000);
        simulador = new SimuladorEcosistema(ambiente);
        System.out.println("Simulador del ecosistema creado.");
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nMenú Principal");
        System.out.println("1. Ver Animales");
        System.out.println("2. Ver Plantas");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarOrganismosPorTipo(String tipo) {
        List<Organismo> organismos = new ArrayList<>(); // Asumiendo que simulador tiene un método para obtener los organismos
        // Logica para filtrar organismos por tipo (Animales o Plantas) y mostrarlos
        System.out.println("Mostrando " + tipo + ":");
        // Aquí iría la lógica para mostrar los organismos y permitir realizar acciones como reproducirse, polinizar o predar.
    }
}



