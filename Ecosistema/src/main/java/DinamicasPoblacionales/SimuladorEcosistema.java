package DinamicasPoblacionales;

import Entidades.Ambiente;
import Entidades.Organismo;

import java.util.ArrayList;
import java.util.List;

public class SimuladorEcosistema {
    private Ambiente ambiente;
    private List<Organismo> organismos;
    private int diaActual;

    public SimuladorEcosistema(Ambiente ambiente) {
        this.ambiente = ambiente;
        this.organismos = new ArrayList<>();
        this.diaActual = 0;
    }

    public void agregarOrganismo(Organismo organismo) {
        if (organismo != null) {
            this.organismos.add(organismo);
        } else {
            System.err.println("Intento de agregar un organismo nulo al ecosistema.");
        }
    }

    public void ejecutarSimulacion(int numeroDeDias) {
        if (numeroDeDias < 1) {
            System.err.println("El número de días para la simulación debe ser positivo.");
            return;
        }
        for (int i = 0; i < numeroDeDias; i++) {
            System.out.println("Día " + (diaActual + 1) + ":");
            try {
                ejecutarPasoDiario();
            } catch (Exception e) {
                System.err.println("Error durante la ejecución del día " + (diaActual + 1) + ": " + e.getMessage());
            }
            diaActual++;
        }
    }

    private void ejecutarPasoDiario() {
        // Aquí se incluiría la lógica para actualizar el estado de cada organismo y del ambiente
        // Por ejemplo, se podrían aplicar efectos de eventos aleatorios, procesos de envejecimiento, reproducción, etc.
    }

    // Métodos adicionales como getAnimales(), getPlantas(), y mostrarEstadisticas() se definen aquí
}




