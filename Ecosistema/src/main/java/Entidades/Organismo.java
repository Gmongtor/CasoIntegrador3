package Entidades;


public abstract class Organismo {
    protected int posX, posY; // Posición del organismo en el ecosistema
    protected double salud; // Salud actual del organismo
    protected int edad; // Edad del organismo en ciclos o unidades de tiempo
    protected boolean estadoReproductivo; // Indica si el organismo está en edad reproductiva

    public Organismo(int posX, int posY, double salud, int edad, boolean estadoReproductivo) {
        this.posX = posX;
        this.posY = posY;
        this.salud = salud;
        this.edad = edad;
        this.estadoReproductivo = estadoReproductivo;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract void mover();
    public abstract void reproducirse(Organismo pareja);
    public abstract void envejecer();



    public int getPosX() { return posX; }
    public void setPosX(int posX) { this.posX = posX; }

    public int getPosY() { return posY; }
    public void setPosY(int posY) { this.posY = posY; }

    public double getSalud() { return salud; }
    public void setSalud(double salud) { this.salud = salud; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public boolean isEstadoReproductivo() { return estadoReproductivo; }
    public void setEstadoReproductivo(boolean estadoReproductivo) { this.estadoReproductivo = estadoReproductivo; }
}


