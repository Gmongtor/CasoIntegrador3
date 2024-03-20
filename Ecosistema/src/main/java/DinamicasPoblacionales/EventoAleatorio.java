package DinamicasPoblacionales;

import Entidades.Ambiente;
import Entidades.Organismo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EventoAleatorio {
    private static final Random random = new Random();

    public static void aplicarEvento(Ambiente ambiente, List<Organismo> organismos) {
        int tipoEvento = random.nextInt(5);

        switch (tipoEvento) {
            case 0:
                System.out.println("No ocurre ningún evento significativo.");
                break;
            case 1:
                cambiarClima(ambiente);
                break;
            case 2:
                desastreNatural(ambiente, organismos);
                break;
            case 3:
                broteEnfermedad(organismos);
                break;
            case 4:
                eventoPositivo(ambiente, organismos);
                break;
                case 5:
                impactoMeteorito(organismos);
                break;
            default:
                System.out.println("No ocurre ningún evento significativo.");
                break;

        }
    }
    private static void impactoMeteorito(List<Organismo> organismos) {
        double porcentajeReduccion = 0.5; // Supongamos que un meteorito elimina el 50% de la población
        System.out.println("Un impacto de meteorito ha ocurrido, causando una masiva reducción de la población.");

        int nuevosOrganismosSize = (int) (organismos.size() * (1 - porcentajeReduccion));
        List<Organismo> sobrevivientes = random
                .ints(0, organismos.size())
                .distinct()
                .limit(nuevosOrganismosSize)
                .mapToObj(organismos::get)
                .collect(Collectors.toList());

        organismos.clear(); // Limpia la lista original
        organismos.addAll(sobrevivientes); // Añade los organismos que sobreviven
    }
    private static void cambiarClima(Ambiente ambiente) {
        // Ejemplo: Cambiar el clima aleatoriamente
        String[] climas = {"Lluvioso", "Soleado", "Nublado", "Ventoso"};
        String nuevoClima = climas[random.nextInt(climas.length)];
        ambiente.setClima(nuevoClima);
        System.out.println("El clima ha cambiado a: " + nuevoClima);
    }

    private static void desastreNatural(Ambiente ambiente, List<Organismo> organismos) {
        // Simulación de un desastre natural que afecta la salud de los organismos
        System.out.println("Ha ocurrido un desastre natural: incendio forestal.");
        organismos.forEach(o -> o.setSalud(o.getSalud() - 20)); // Asume método setSalud
    }

    private static void broteEnfermedad(List<Organismo> organismos) {
        // Simulación de un brote de enfermedad que reduce la salud
        System.out.println("Un brote de enfermedad ha reducido la salud de los organismos.");
        organismos.forEach(o -> o.setSalud(o.getSalud() * 0.9)); // Reduce la salud en un 10%
    }

    private static void eventoPositivo(Ambiente ambiente, List<Organismo> organismos) {
        System.out.println("Ha ocurrido un evento positivo: lluvias beneficiosas.");
        ambiente.simularEvento("lluvia");
        organismos.forEach(o -> o.setSalud(o.getSalud() + 10)); // Asume método setSalud
    }
}



