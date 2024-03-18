package DinamicasPoblacionales;

import Entidades.Ambiente;
import Entidades.Organismo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimuladorEcosistema {
    private Ambiente ambiente;
    private List<Organismo> organismos;
    private Random random = new Random();

    public SimuladorEcosistema(Ambiente ambiente) {
        this.ambiente = ambiente;
        this.organismos = new ArrayList<>();
    }

    public void agregarOrganismo(Organismo organismo) {
        organismos.add(organismo);
    }

    public void simularPaso() {
        List<Organismo> nuevosOrganismos = new ArrayList<>();
        for (Organismo organismo : new ArrayList<>(organismos)) {
            organismo.envejecer();
            organismo.mover();
            // Asumimos que reproducirse ahora correctamente maneja la lógica interna y puede agregar nuevos organismos
            if (random.nextDouble() < 0.1) { // Supongamos una probabilidad de 10% de reproducción
                Organismo nuevoOrganismo = organismo; // Ajustar según la implementación real
                if (nuevoOrganismo != null) {
                    nuevosOrganismos.add(nuevoOrganismo);
                }
            }
        }
        organismos.addAll(nuevosOrganismos);

        // Corrección: Pasar la lista de organismos a aplicarEvento para manejar la reducción de la población
        if (random.nextBoolean()) {
            EventoAleatorio.aplicarEvento(ambiente, organismos);
        }
    }

    public void ejecutarSimulacion(int pasos) {
        for (int i = 0; i < pasos; i++) {
            simularPaso();
        }
        EstadisticasEcosistema.mostrarEstadisticas(organismos);
    }
}


