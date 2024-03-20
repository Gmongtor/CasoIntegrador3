package Entidades;

import java.util.List;
import java.util.Random;

public abstract class Organismo {
    protected int posX, posY;
    protected double salud;
    protected int edad;
    protected boolean estadoReproductivo;
    protected boolean vivo = true;

    public Organismo(int posX, int posY, double salud, int edad, boolean estadoReproductivo) {
        this.posX = posX;
        this.posY = posY;
        this.salud = Math.max(salud, 0); // Asegurar que la salud no sea negativa
        this.edad = edad;
        this.estadoReproductivo = estadoReproductivo;
    }

    public abstract void mover();
    public abstract void envejecer();

    // Métodos de control de estado
    public boolean estaVivo() {
        return vivo;
    }

    public void marcarComoMuerto() {
        this.vivo = false;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEstadoReproductivo() {
        return estadoReproductivo;
    }

    public void setEstadoReproductivo(boolean estadoReproductivo) {
        this.estadoReproductivo = estadoReproductivo;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public abstract void visualizar();

    public void decrementarSalud(int i) {
        salud -= i;
    }

    public void incrementarSalud(int i) {
        salud += i;
    }
    public void cazar(List<Organismo> presas) {
        if (!presas.isEmpty() && this.salud < 100) { // Ejemplo de condición
            Random random = new Random();
            Organismo presa = presas.get(random.nextInt(presas.size()));
            // Suponiendo que decrementarSalud() quita salud a la presa y puede marcarla como no viva
            presa.decrementarSalud(10); // Ejemplo de daño
            this.incrementarSalud(10); // El depredador recupera salud
            System.out.println(this.getClass().getSimpleName() + " ha cazado a " + presa.getClass().getSimpleName());
        }
    }

    public boolean esPredador() {
        return this instanceof Animales;
    }
    public Organismo reproducirse() {
        // Añadir una condición de probabilidad para la reproducción
        Random random = new Random();
        if (random.nextDouble() < 0.1) { // Supongamos que hay un 10% de probabilidad de reproducción
            // Lógica de reproducción existente
        }
        return null;
    }

    public Object getTipo() {
        return this.getClass().getSimpleName();
    }
}





