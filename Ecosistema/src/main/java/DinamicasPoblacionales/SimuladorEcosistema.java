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
        for (Organismo organismo : new ArrayList<>(organismos)) {
            organismo.envejecer();
            organismo.mover();
            organismo.reproducirse(organismos.get(random.nextInt(organismos.size())));
        }

        if (random.nextBoolean()) {
            EventoAleatorio.aplicarEvento(ambiente);

        }

    }

    public void ejecutarSimulacion(int pasos) {
        for (int i = 0; i < pasos; i++) {
            simularPaso();
        }
        EstadisticasEcosistema.mostrarEstadisticas(organismos);
    }
}

