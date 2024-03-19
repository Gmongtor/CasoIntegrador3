package Entidades;

public class Planta extends Organismo {
    private double tasaCrecimiento;
    private String nombre; // Nuevo campo para el nombre específico de la planta

    public Planta(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double tasaCrecimiento, String nombre) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.tasaCrecimiento = tasaCrecimiento;
        this.nombre = nombre; // Asignar el nombre específico de la planta
    }

    @Override
    public void mover() {
        // Implementación sin cambios
    }

    @Override
    public Planta reproducirse() {
        // Implementación sin cambios, pero se incluye el nombre en la nueva planta
        if (!estaVivo() || !estadoReproductivo || salud <= 50) return null;

        System.out.println(nombre + " ha dispersado semillas.");
        return new Planta(posX, posY, 100, 0, false, tasaCrecimiento, "Cria de " + nombre);
    }

    @Override
    public void envejecer() {
        // Implementación sin cambios
    }

    @Override
    public void visualizar() {
        System.out.println("Planta - Nombre: " + nombre + ", Posición: (" + posX + "," + posY + "), Salud: " + salud + ", Edad: " + edad + ", Tasa de Crecimiento: " + tasaCrecimiento);
    }

    // Getters y Setters adicionales
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}




