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
        this.salud = Math.max(salud, 0); // Asegurar que la salud no sea negativa
        this.edad = edad;
        this.estadoReproductivo = estadoReproductivo;
    }

    public abstract void mover();
    public abstract Organismo reproducirse(); // Modificado para no requerir retorno ni parámetro
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
}





