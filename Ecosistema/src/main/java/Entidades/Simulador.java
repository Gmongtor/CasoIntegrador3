package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Simulador {
    private Ambiente ambiente;
    private List<Organismo> organismos;

    public Simulador(String clima, String terreno, double recursosDisponibles) {
        this.ambiente = new Ambiente(clima, terreno, recursosDisponibles);
        this.organismos = new ArrayList<>();
    }

    public void agregarOrganismo(Organismo organismo) {
        this.organismos.add(organismo);
    }

    public List<Animales> getAnimales() {
        return organismos.stream()
                .filter(organismo -> organismo instanceof Animales)
                .map(organismo -> (Animales) organismo)
                .collect(Collectors.toList());
    }

    public List<Planta> getPlantas() {
        return organismos.stream()
                .filter(organismo -> organismo instanceof Planta)
                .map(organismo -> (Planta) organismo)
                .collect(Collectors.toList());
    }

    public void ejecutarSimulacion(int pasos) {
        for (int i = 0; i < pasos; i++) {
            // Aquí implementarías la lógica para cada paso de la simulación,
            // como mover organismos, aplicar efectos del ambiente, etc.
            System.out.println("Ejecutando paso " + (i + 1) + " de la simulación...");
            // Por simplicidad, este ejemplo no incluye detalles específicos de implementación.
        }
    }
}

