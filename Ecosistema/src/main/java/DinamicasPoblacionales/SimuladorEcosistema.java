package DinamicasPoblacionales;

import Entidades.Animales;
import Entidades.Ambiente;
import Entidades.Organismo;
import Entidades.Planta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimuladorEcosistema {
    private Ambiente ambiente;
    private List<Organismo> organismos;
    private int diaActual;
    private static final Random random = new Random();

    public SimuladorEcosistema() {
        this.ambiente = new Ambiente("Templado", "Bosque", 1000);
        this.organismos = new ArrayList<>();
        this.diaActual = 0;
        // Asumimos que se agregan algunos organismos de muestra al iniciar
        inicializarEcosistema();
    }

    private void inicializarEcosistema() {
        organismos.add(new Animales(0, 0, 100, 5, true, 1.5, 100, "León"));
        organismos.add(new Animales(5, 5, 100, 10, true, 1.2, 100, "Tigre"));
        organismos.add(new Animales(10, 10, 100, 15, true, 1.0, 100, "Elefante"));

        organismos.add(new Planta(10, 10, 100, 5, true, 0.2, "Roble"));
        organismos.add(new Planta(15, 15, 100, 10, true, 0.3, "Pino"));
        organismos.add(new Planta(20, 20, 100, 15, true, 0.4, "Cedro"));
    }

    public void agregarOrganismo(Organismo organismo) {
        if (organismo != null) {
            this.organismos.add(organismo);
        } else {
            System.err.println("Intento de agregar un organismo nulo al ecosistema.");
        }
    }

    public void ejecutarSimulacion(int numeroDeDias) {
        for (int i = 0; i < numeroDeDias; i++) {
            System.out.println("Día " + (diaActual + 1) + " de la simulación.");
            ejecutarPasoDiario();
            diaActual++;
        }
    }

    private void ejecutarPasoDiario() {
        // Lógica simplificada para la demostración
        organismos.forEach(Organismo::envejecer);
        // Añadir más lógica para mover, reproducirse, etc.
    }

    public void mostrarAnimales() {
        System.out.println("Animales en el ecosistema:");
        organismos.stream().filter(o -> o instanceof Animales)
                .forEach(o -> ((Animales)o).visualizar());
    }

    public void mostrarPlantas() {
        System.out.println("Plantas en el ecosistema:");
        organismos.stream().filter(o -> o instanceof Planta)
                .forEach(o -> ((Planta)o).visualizar());
    }

    public void generarEventoAleatorio() {
        int evento = random.nextInt(3); // Ejemplo de eventos
        switch (evento) {
            case 0:
                System.out.println("No ocurre nada especial.");
                break;
            case 1:
                System.out.println("Lluvia nutre el ecosistema.");
                // Implementar efectos de la lluvia
                break;
            case 2:
                System.out.println("Sequía afecta el ecosistema.");
                // Implementar efectos de la sequía
                break;
        }
    }
}





