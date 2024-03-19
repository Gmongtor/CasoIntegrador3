package Entidades;

public class Interacciones {

    public static void predacion(Animales depredador, Organismo presa) {
        if (!(presa instanceof Animales)) return; // Asegura que solo los animales puedan ser presas
        System.out.println(depredador.getTipo() + " ha cazado a " + ((Animales) presa).getTipo());
        depredador.comer(20); // Asume que comer incrementa la energía del depredador
        presa.marcarComoMuerto(); // Marca la presa como muerta
    }

    public static void polinizacion(Planta planta1, Planta planta2) {
        System.out.println(planta1.getNombre() + " ha polinizado a " + planta2.getNombre());
        // Este método podría incrementar la probabilidad de reproducción o la salud de las plantas
    }
}



