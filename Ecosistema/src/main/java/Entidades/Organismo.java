package Entidades;

public abstract class Organismo {
    protected int posX, posY;
    protected double salud;
    protected int edad;
    protected boolean estadoReproductivo;
    protected boolean vivo = true;

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

    // Getters
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public double getSalud() {
        return salud;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isEstadoReproductivo() {
        return estadoReproductivo;
    }

    public boolean isVivo() {
        return vivo;
    }

    // Setters
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoReproductivo(boolean estadoReproductivo) {
        this.estadoReproductivo = estadoReproductivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}




