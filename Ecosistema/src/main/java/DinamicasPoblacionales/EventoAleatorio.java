package DinamicasPoblacionales;

import Entidades.Ambiente;
import Entidades.Organismo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EventoAleatorio {
    private static final Random random = new Random();

    public static void aplicarEvento(Ambiente ambiente, List<Organismo> organismos) {
        int tipoEvento = random.nextInt(5); // Asegúrate de que el rango incluya todos los eventos que desees

        switch (tipoEvento) {
            case 0:
                System.out.println("No ocurre ningún evento significativo.");
                break;
            case 1:
                erupcionVolcanica(ambiente, organismos);
                break;
            case 2:
                pandemia(organismos);
                break;
            case 3:
                inundacionMasiva(ambiente, organismos);
                break;
            case 4:
                invasionAlienigena(organismos);
                break;
        }
    }

    private static void erupcionVolcanica(Ambiente ambiente, List<Organismo> organismos) {
        System.out.println("Una erupción volcánica ha ocurrido, destruyendo gran parte del hábitat.");
        eliminarOrganismosAleatoriamente(organismos, 0.2);
    }

    private static void pandemia(List<Organismo> organismos) {
        System.out.println("Una pandemia ha afectado a la población, eliminando a muchos organismos.");
        eliminarOrganismosAleatoriamente(organismos, 0.06);
    }

    private static void inundacionMasiva(Ambiente ambiente, List<Organismo> organismos) {
        System.out.println("Una inundación masiva ha sumergido el área, resultando en muchas pérdidas.");
        eliminarOrganismosAleatoriamente(organismos, 0.2);
    }

    private static void invasionAlienigena(List<Organismo> organismos) {
        System.out.println("Una invasión alienígena ha diezmado a la población.");
        eliminarOrganismosAleatoriamente(organismos, 0.05);
    }

    // Función para eliminar una porción de los organismos de manera aleatoria
    private static void eliminarOrganismosAleatoriamente(List<Organismo> organismos, double porcentaje) {
        if (!organismos.isEmpty()) {
            int nuevosOrganismosSize = (int) (organismos.size() * (1 - porcentaje));
            // Asegurar que nuevosOrganismosSize no sea negativo ni cero
            nuevosOrganismosSize = Math.max(nuevosOrganismosSize, 1);

            // Asegurarse de que nuevosOrganismosSize no sea mayor que el tamaño de la lista actual de organismos
            nuevosOrganismosSize = Math.min(nuevosOrganismosSize, organismos.size() - 1);

            List<Organismo> sobrevivientes = random.ints(0, organismos.size())
                    .distinct()
                    .limit(nuevosOrganismosSize)
                    .mapToObj(organismos::get)
                    .collect(Collectors.toList());

            organismos.clear(); // Limpia la lista original
            organismos.addAll(sobrevivientes); // Añade los organismos que sobreviven
        } else {
            System.out.println("No hay organismos para eliminar.");
        }
    }

}




