package Entidades;

public class Planta extends Organismo {
    private double tasaCrecimiento;

    public Planta(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double tasaCrecimiento) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.tasaCrecimiento = tasaCrecimiento;
    }

    @Override
    public void mover() {
        // Las plantas no se "mueven" en el sentido tradicional, pero podríamos interpretar este método como crecimiento
        if (!estaVivo()) return;
        salud += tasaCrecimiento; // Aumentar la salud simula el crecimiento
        if (salud > 100) salud = 100; // Límite superior para la salud
    }

    @Override
    public Planta reproducirse() {
        // En este contexto simplificado, reproducirse podría implicar la creación de una nueva planta bajo ciertas condiciones
        if (!estaVivo() || !estadoReproductivo || salud <= 50) return null;

        // Suponiendo una simplificación donde cada evento de reproducción tiene éxito
        System.out.println("Una planta ha dispersado semillas.");
        return new Planta(posX, posY, 100, 0, false, tasaCrecimiento); // Nueva planta con estado inicial
    }

    @Override
    public void envejecer() {
        if (!estaVivo()) return;
        edad++;
        salud -= 0.1; // Las plantas también pierden salud al envejecer
        if (salud <= 0) marcarComoMuerto();
        if (edad > 1 && salud > 50) estadoReproductivo = true;
    }

    // Método para visualizar información básica de la planta
    public void visualizar() {
        System.out.println("Planta - Posición: (" + posX + "," + posY + "), Salud: " + salud + ", Edad: " + edad + ", Tasa de Crecimiento: " + tasaCrecimiento);
    }

    // Getters y Setters
    public double getTasaCrecimiento() { return tasaCrecimiento; }
    public void setTasaCrecimiento(double tasaCrecimiento) { this.tasaCrecimiento = tasaCrecimiento; }
}



