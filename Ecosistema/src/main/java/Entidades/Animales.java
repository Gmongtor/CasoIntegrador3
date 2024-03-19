package Entidades;

import java.util.Random;

public class Animales extends Organismo {
    private double velocidadMovimiento;
    private double energia;
    private static final Random random = new Random();

    public Animales(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double velocidadMovimiento, double energia) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.velocidadMovimiento = velocidadMovimiento;
        this.energia = energia;
    }

    @Override
    public void mover() {
        if (!estaVivo()) return;
        posX += random.nextInt(3) - 1;
        posY += random.nextInt(3) - 1;
        consumirEnergia(1);
    }

    @Override
    public Animales reproducirse() {
        if (!estaVivo() || this.energia <= 50) return null;
        consumirEnergia(20);
        return new Animales(posX, posY, 100, 0, true, velocidadMovimiento, 50);
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

    // Método para visualizar información básica del animal
    public void visualizar() {
        System.out.println("Animal - Posición: (" + posX + "," + posY + "), Salud: " + salud + ", Edad: " + edad + ", Energía: " + energia);
    }

    // Getters y Setters omitidos para brevedad
}



