package Entidades;

public abstract class Organismo {
    protected int posX, posY;
    protected double salud;
    protected int edad;
    protected boolean estadoReproductivo;
    protected boolean vivo = true; // Nuevo campo para indicar si el organismo está vivo

    public Organismo(int posX, int posY, double salud, int edad, boolean estadoReproductivo) {
        this.posX = posX;
        this.posY = posY;
        this.salud = salud;
        this.edad = edad;
        this.estadoReproductivo = estadoReproductivo;
    }

    public abstract void mover();
    public abstract void reproducirse(Organismo pareja);
    public abstract void envejecer();

    public boolean estaVivo() {
        return vivo;
    }

    public void marcarComoMuerto() {
        this.vivo = false;
    }

    // Getters y Setters para posX, posY, salud, edad, estadoReproductivo, y vivo
}



