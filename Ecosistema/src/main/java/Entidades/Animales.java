package Entidades;

import java.util.Random;

public class Animales extends Organismo {
    private double velocidadMovimiento;
    private double energia;
    private String tipo; // Tipo de animal (e.g., "León", "Tigre", "Elefante")
    private static final Random random = new Random();

    public Animales(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double velocidadMovimiento, double energia, String tipo) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.velocidadMovimiento = Math.max(velocidadMovimiento, 0);
        this.energia = Math.max(energia, 0);
        this.tipo = tipo;
    }

    @Override
    public void mover() {
        if (!estaVivo()) return;
        posX += random.nextInt(3) - 1;
        posY += random.nextInt(3) - 1;
        consumirEnergia(1);
    }

    @Override
    public Organismo reproducirse() {
        if (!estaVivo() || this.energia <= 50) return null;
        consumirEnergia(20);
        // Asumiendo que todos los animales tienen una probabilidad de reproducción
        System.out.println(this.tipo + " ha tenido una cría.");
        return new Animales(posX, posY, 100, 0, true, velocidadMovimiento, 50, tipo);
    }

    @Override
    public void envejecer() {
        if (!estaVivo()) return;
        edad++;
        salud -= 0.05;
        if (salud <= 0) marcarComoMuerto();
    }

    public void comer(double cantidad) {
        if (!estaVivo()) return;
        energia += cantidad;
        if (energia > 100) energia = 100;
    }

    private void consumirEnergia(double cantidad) {
        energia -= cantidad;
        if (energia <= 0) {
            energia = 0;
            marcarComoMuerto();
        }
    }

    // Método para visualizar información básica del animal, incluido su tipo
    public void visualizar() {
        System.out.println("Tipo: " + tipo + " - Posición: (" + posX + "," + posY + "), Salud: " + salud + ", Edad: " + edad + ", Energía: " + energia);
    }

    // Getters y Setters
    public double getVelocidadMovimiento() { return velocidadMovimiento; }
    public void setVelocidadMovimiento(double velocidadMovimiento) { this.velocidadMovimiento = Math.max(velocidadMovimiento, 0); }

    public double getEnergia() { return energia; }
    public void setEnergia(double energia) { this.energia = Math.max(energia, 0); }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}




