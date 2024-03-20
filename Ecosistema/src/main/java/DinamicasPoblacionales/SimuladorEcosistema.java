package DinamicasPoblacionales;

import Entidades.Ambiente;
import Entidades.Animales;
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
    private int totalMuertes = 0; // Mantiene el conteo total de muertes

    public SimuladorEcosistema() {
        this.ambiente = new Ambiente("Templado", "Bosque", 1000);
        this.organismos = new ArrayList<>();
        this.diaActual = 0;
        inicializarEcosistema();
    }

    private void inicializarEcosistema() {
        // Esta implementación inicializa los organismos específicamente requeridos.
        for (int i = 0; i < 10; i++) {
            organismos.add(new Animales(0, 0, 100, 5, true, 1.5, 100, "León"));
        }
        for (int i = 0; i < 5; i++) {
            organismos.add(new Animales(5, 5, 100, 10, true, 1.2, 100, "Zebra"));
        }
        for (int i = 0; i < 15; i++) {
            organismos.add(new Animales(10, 10, 100, 3, true, 1.0, 100, "Elefante"));
        }
        for (int i = 0; i < 10; i++) {
            organismos.add(new Animales(15, 15, 100, 7, true, 1.3, 100, "Jirafa"));
        }
        for (int i = 0; i < 15; i++) {
            organismos.add(new Planta(10, 10, 100, 5, true, 0.2, "Roble"));
        }
        for (int i = 0; i < 20; i++) {
            organismos.add(new Planta(15, 15, 100, 10, true, 0.1, "Pino"));
        }

    }

    public void ejecutarSimulacion(int numeroDeDias) {
        for (int i = 0; i < numeroDeDias; i++) {
            System.out.println("Día " + (diaActual + 1) + " de la simulación.");
            ejecutarPasoDiario();
            diaActual++;

            try {
                Thread.sleep(1000); // Pausa de 1 segundo entre días
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restablece el estado de interrupción
                System.out.println("La simulación fue interrumpida.");
                break;
            }
        }
    }


    private void ejecutarPasoDiario() {
        organismos.forEach(Organismo::mover);
        ejecutarCaza();
        List<Organismo> nuevosOrganismos = new ArrayList<>();
        organismos.forEach(organismo -> {
            Organismo nuevo = organismo.reproducirse();
            if (nuevo != null) {
                nuevosOrganismos.add(nuevo);
            }
        });
        organismos.addAll(nuevosOrganismos);

        int muertesAntesDelEvento = organismos.size();
        generarEventoAleatorio();
        int muertesDespuesDelEvento = muertesAntesDelEvento - organismos.size();
        totalMuertes += muertesDespuesDelEvento; // Actualizar el total de muertes basado en el evento

        organismos.removeIf(o -> !o.estaVivo());
    }

    public void mostrarAnimales() {
        System.out.println("Animales en el ecosistema:");
        organismos.stream().filter(o -> o instanceof Animales).forEach(o -> ((Animales)o).visualizar());
    }

    public void mostrarPlantas() {
        System.out.println("Plantas en el ecosistema:");
        organismos.stream().filter(o -> o instanceof Planta).forEach(o -> ((Planta)o).visualizar());
    }

    public String mostrarEstadisticas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total Organismos: ").append(organismos.size()).append("\n");
        sb.append("Total Muertes: ").append(totalMuertes).append("\n");
        return sb.toString();
    }

    public void generarEventoAleatorio() {
        EventoAleatorio.aplicarEvento(ambiente, organismos); // Aplica el evento y actualiza el total de muertes internamente
    }

    private void ejecutarCaza() {
        List<Organismo> presasEliminadas = new ArrayList<>();

        // Itera sobre los organismos para identificar a los depredadores
        for (Organismo predador : organismos) {
            if (predador instanceof Animales && predador.esPredador()) {
                // Chequea si el depredador caza con éxito basado en la probabilidad baja, por ejemplo, 5%
                if (random.nextDouble() < 0.05) { // 5% de probabilidad de caza exitosa
                    Organismo presaSeleccionada = seleccionarPresa((Animales)predador);
                    if (presaSeleccionada != null) {
                        System.out.println(predador.getTipo() + " ha cazado a " + presaSeleccionada.getTipo());
                        presasEliminadas.add(presaSeleccionada);
                        // Incrementa la salud del depredador, simula que ha comido
                        predador.incrementarSalud(10); // Supongamos que comer recupera 10 de salud
                    }
                }
            }
        }

        // Remueve todas las presas cazadas de la lista de organismos
        organismos.removeAll(presasEliminadas);
    }


    private Organismo seleccionarPresa(Animales depredador) {
        // Simula la selección de una presa. Podría ser al azar entre los tipos permitidos.
        List<Organismo> posiblesPresas = new ArrayList<>();
        for (Organismo organismo : organismos) {
            // Asumiendo que tienes una manera de determinar si un organismo puede ser presa
            if (esPresa(depredador, organismo)) {
                posiblesPresas.add(organismo);
            }
        }

        if (!posiblesPresas.isEmpty()) {
            // Selecciona al azar una presa de la lista de posibles presas
            return posiblesPresas.get(new Random().nextInt(posiblesPresas.size()));
        }

        return null;
    }

    private boolean esPresa(Animales depredador, Organismo posiblePresa) {
        // Define las reglas para determinar si un organismo es una presa válida
        // Por ejemplo, los leones pueden cazar zebras y jirafas pero no elefantes
        if (depredador.getTipo().equals("León") && (posiblePresa.getTipo().equals("Zebra") || posiblePresa.getTipo().equals("Jirafa"))) {
            return true;
        }
        // Añadir más reglas según los tipos de animales presentes en tu simulación
        return false;
    }

}








