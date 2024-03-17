package Entidades;
import java.util.Random;

public class Animales extends Organismo {
    private double velocidadMovimiento;
    private double energia;

    public Animales(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double velocidadMovimiento, double energia) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.velocidadMovimiento = velocidadMovimiento;
        this.energia = energia;
    }

    @Override
    public void mover() {
        Random random = new Random();
        this.posX += random.nextInt(3) - 1; // Mueve el animal en dirección X aleatoriamente (-1, 0, 1)
        this.posY += random.nextInt(3) - 1; // Mueve el animal en dirección Y aleatoriamente (-1, 0, 1)
        this.energia -= 1; // Cada movimiento consume energía
    }

    @Override
    public void reproducirse(Organismo pareja) {
        if (pareja instanceof Animales && this.estadoReproductivo && pareja.estadoReproductivo && this.energia > 50) {
            // Implementar lógica de reproducción específica, por ejemplo, crear un nuevo Animal
        }
    }

    @Override
    public void envejecer() {
        this.edad++;
        this.salud -= 0.05; // La salud disminuye cada año que envejece
        if (this.salud <= 0) {
            // Implementar lógica de muerte
        }
    }

    public void comer(double cantidad) {
        this.energia += cantidad; // Comer incrementa la energía
        if (this.energia > 100) this.energia = 100; // Límite de energía
    }

    // Getters y setters para velocidadMovimiento y energia
}

