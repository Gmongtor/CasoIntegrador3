package DinamicasPoblacionales;

import Entidades.Ambiente;
import Entidades.Organismo;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class EventoAleatorio {
    private static final Random random = new Random();

    // Modificamos el método para que ahora acepte y modifique una lista de organismos
    public static void aplicarEvento(Ambiente ambiente, List<Organismo> organismos) {
        int tipoEvento = random.nextInt(4); // Genera un número entre 0 y 3 para seleccionar el tipo de evento

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
        }
    }

    // Los métodos específicos para cada tipo de evento ahora necesitan modificar la lista de organismos
    private static void desastreNatural(Ambiente ambiente, List<Organismo> organismos) {
        String[] desastres = {"inundación", "sequía", "incendio forestal", "terremoto"};
        String desastre = desastres[random.nextInt(desastres.length)];
        System.out.println("Ha ocurrido un desastre natural: " + desastre);

        // Ejemplo de cómo un desastre puede afectar la población:
        if (desastre.equals("sequía")) {
            ambiente.setRecursosDisponibles(ambiente.getRecursosDisponibles() - 20);
            reducirPoblacion(organismos, 0.1); // Reduce la población en un 10%
        }
    }

    private static void broteEnfermedad(List<Organismo> organismos) {
        System.out.println("Ha ocurrido un brote de enfermedad.");
        reducirPoblacion(organismos, 0.2); // Reduce la población en un 20%
    }
    private static void cambiarClima(Ambiente ambiente) {
        // Aquí se debería cambiar el estado del clima en el objeto ambiente.
        // Por simplicidad, asumimos que ambiente tiene un método setClima(String clima).
        String[] climasPosibles = {"Soleado", "Lluvioso", "Nublado", "Ventoso"};
        String nuevoClima = climasPosibles[random.nextInt(climasPosibles.length)];
        ambiente.setClima(nuevoClima);
        System.out.println("El clima ha cambiado a: " + nuevoClima);
    }

    // Método para reducir la población basado en un porcentaje
    private static void reducirPoblacion(List<Organismo> organismos, double porcentaje) {
        Iterator<Organismo> iterator = organismos.iterator();
        while (iterator.hasNext()) {
            Organismo organismo = iterator.next();
            // Suponiendo que la decisión de eliminar un organismo se toma aleatoriamente basada en el porcentaje dado
            if (random.nextDouble() < porcentaje) {
                iterator.remove();
            }
        }
    }
}

