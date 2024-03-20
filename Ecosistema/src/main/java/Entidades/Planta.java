package Entidades;

import java.util.Random;

public class Planta extends Organismo {
    private double tasaCrecimiento;
    private String nombre; // Nuevo campo para el nombre específico de la planta
    private static final Random random = new Random();

    public Planta(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double tasaCrecimiento, String nombre) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.tasaCrecimiento = tasaCrecimiento;
        this.nombre = nombre;
    }

    @Override
    public void mover() {
        // Las plantas generalmente no se mueven, por lo que este método podría quedar vacío o realizar alguna otra lógica específica si es necesario.
    }

    @Override
    public Organismo reproducirse() {
        // Añade una probabilidad aleatoria para la reproducción.
        double probabilidadReproduccion = 0.2; // Por ejemplo, un 20% de probabilidad
        if (random.nextDouble() < probabilidadReproduccion && estaVivo() && estadoReproductivo && salud > 80) {
            System.out.println(nombre + " ha dispersado semillas.");
            return new Planta(posX, posY, 100, 0, false, tasaCrecimiento, "Brote de " + nombre);
        }
        return null;
    }

    @Override
    public void envejecer() {
        edad++;
        // Aquí puedes implementar lógica adicional como decremento de salud con el tiempo si lo consideras necesario.
    }

    @Override
    public void visualizar() {
        System.out.println("Planta - Nombre: " + nombre + ", Posición: (" + posX + "," + posY + "), Salud: " + salud + ", Edad: " + edad + ", Tasa de Crecimiento: " + tasaCrecimiento);
    }

    // Getters y Setters adicionales
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}





