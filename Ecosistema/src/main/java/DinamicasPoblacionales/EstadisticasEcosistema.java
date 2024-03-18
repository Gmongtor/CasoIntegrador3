package  DinamicasPoblacionales;

import Entidades.Animales;
import Entidades.Organismo;
import Entidades.Planta;

import java.util.List;
import java.util.OptionalDouble;

public class EstadisticasEcosistema {
    public static void mostrarEstadisticas(List<Organismo> organismos) {
        long cantidadAnimales = organismos.stream().filter(o -> o instanceof Animales).count();
        long cantidadPlantas = organismos.stream().filter(o -> o instanceof Planta).count();

        OptionalDouble promedioEdadAnimales = organismos.stream()
                .filter(o -> o instanceof Animales)
                .mapToInt(Organismo::getEdad)
                .average();
        OptionalDouble promedioSaludAnimales = organismos.stream()
                .filter(o -> o instanceof Animales)
                .mapToDouble(Organismo::getSalud)
                .average();

        OptionalDouble promedioEdadPlantas = organismos.stream()
                .filter(o -> o instanceof Planta)
                .mapToInt(Organismo::getEdad)
                .average();
        OptionalDouble promedioSaludPlantas = organismos.stream()
                .filter(o -> o instanceof Planta)
                .mapToDouble(Organismo::getSalud)
                .average();

        System.out.println("Cantidad de animales: " + cantidadAnimales);
        System.out.println("Cantidad de plantas: " + cantidadPlantas);

        System.out.println("Promedio de edad de animales: " + promedioEdadAnimales.orElse(0));
        System.out.println("Promedio de salud de animales: " + promedioSaludAnimales.orElse(0));

        System.out.println("Promedio de edad de plantas: " + promedioEdadPlantas.orElse(0));
        System.out.println("Promedio de salud de plantas: " + promedioSaludPlantas.orElse(0));
    }
}


