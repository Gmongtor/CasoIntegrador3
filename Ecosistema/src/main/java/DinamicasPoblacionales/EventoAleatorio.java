package DinamicasPoblacionales;

import Entidades.Ambiente;
import Entidades.Organismo;

import java.util.List;
import java.util.Random;

public class EventoAleatorio {
    private static final Random random = new Random();

    public static void aplicarEvento(Ambiente ambiente, List<Organismo> organismos) {
        int tipoEvento = random.nextInt(5); // Añadido un evento adicional

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
                eventoPositivo(ambiente, organismos); // Nuevo tipo de evento
                break;
        }
    }

    private static void desastreNatural(Ambiente ambiente, List<Organismo> organismos) {
        // Se mantiene la lógica previa, considerando expandirla con más detalles según sugerencias.
    }

    private static void broteEnfermedad(List<Organismo> organismos) {
        // Se mantiene la lógica previa, considerando expandirla con más detalles según sugerencias.
    }

    private static void cambiarClima(Ambiente ambiente) {
        // Se mantiene la lógica previa
    }

    private static void eventoPositivo(Ambiente ambiente, List<Organismo> organismos) {
        System.out.println("Ha ocurrido un evento positivo: lluvias beneficiosas.");
        ambiente.simularEvento("lluvia"); // Ejemplo de cómo un evento positivo puede ser implementado
        // Se podría considerar la implementación de lógicas específicas que beneficien a los organismos y al ambiente
    }

    private static void reducirPoblacion(List<Organismo> organismos, double porcentaje) {
        // Se mantiene la lógica previa
    }
}


