package DinamicasPoblacionales;

import Entidades.Animales;
import Entidades.Organismo;
import Entidades.Planta;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EstadisticasEcosistema {
    public static void mostrarEstadisticas(List<Organismo> organismos) {
        // Filtrar animales y plantas
        List<Animales> animales = organismos.stream()
                .filter(o -> o instanceof Animales)
                .map(o -> (Animales) o)
                .collect(Collectors.toList());
        List<Planta> plantas = organismos.stream()
                .filter(o -> o instanceof Planta)
                .map(o -> (Planta) o)
                .collect(Collectors.toList());

        // Mostrar estadísticas generales
        System.out.println("Cantidad de animales: " + animales.size());
        System.out.println("Cantidad de plantas: " + plantas.size());

        // Mostrar estadísticas detalladas para Animales
        mostrarEstadisticasAnimales(animales);
        // Mostrar estadísticas detalladas para Plantas
        mostrarEstadisticasPlantas(plantas);
    }

    private static void mostrarEstadisticasAnimales(List<Animales> animales) {
        OptionalDouble promedioEdadAnimales = animales.stream()
                .mapToInt(Animales::getEdad)
                .average();
        OptionalDouble promedioSaludAnimales = animales.stream()
                .mapToDouble(Animales::getSalud)
                .average();

        System.out.println("-- Estadísticas de Animales --");
        System.out.println("Promedio de edad de animales: " + promedioEdadAnimales.orElse(0));
        System.out.println("Promedio de salud de animales: " + promedioSaludAnimales.orElse(0));
        // Aquí se pueden agregar más estadísticas específicas de animales
    }

    private static void mostrarEstadisticasPlantas(List<Planta> plantas) {
        OptionalDouble promedioEdadPlantas = plantas.stream()
                .mapToInt(Planta::getEdad)
                .average();
        OptionalDouble promedioSaludPlantas = plantas.stream()
                .mapToDouble(Planta::getSalud)
                .average();

        System.out.println("-- Estadísticas de Plantas --");
        System.out.println("Promedio de edad de plantas: " + promedioEdadPlantas.orElse(0));
        System.out.println("Promedio de salud de plantas: " + promedioSaludPlantas.orElse(0));
        // Aquí se pueden agregar más estadísticas específicas de plantas
    }
}



