package Entidades;
import java.util.Random;

public class Animales extends Organismo {
    private double velocidadMovimiento; // Velocidad a la que el animal puede moverse
    private double energia; // Energía actual del animal, afecta su capacidad de moverse y reproducirse

    public Animales(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double velocidadMovimiento, double energia) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.velocidadMovimiento = velocidadMovimiento;
        this.energia = energia;
    }

    @Override
    public void mover() {
        Random random = new Random();
        posX += random.nextInt(3) - 1; // Mueve el animal en dirección X aleatoriamente
        posY += random.nextInt(3) - 1; // Mueve el animal en dirección Y aleatoriamente
        energia -= 1; // Consumo de energía por movimiento
    }

    @Override
    public void reproducirse(Organismo pareja) {
        if (pareja instanceof Animales && estadoReproductivo && pareja.estadoReproductivo && energia > 50) {
            // Aquí se puede desarrollar una lógica más compleja para la creación de un nuevo animal
        }
    }

    @Override
    public void envejecer() {
        edad++;
        salud -= 0.05; // Disminución de salud con la edad
        if (salud <= 0) {
            // Implementar lógica de muerte, como remover el animal del ecosistema
        }
    }

    public void comer(double cantidad) {
        energia += cantidad;
        if (energia > 100) energia = 100; // Límite máximo de energía
    }

    public double getVelocidadMovimiento() { return velocidadMovimiento; }
    public void setVelocidadMovimiento(double velocidadMovimiento) { this.velocidadMovimiento = velocidadMovimiento; }

    public double getEnergia() { return energia; }
    public void setEnergia(double energia) { this.energia = energia; }
}


