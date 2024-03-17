package Entidades;
public class Plantas extends Organismo {
    private double tasaCrecimiento;

    public Plantas(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double tasaCrecimiento) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.tasaCrecimiento = tasaCrecimiento;
    }

    @Override
    public void mover() {
    }

    @Override
    public void reproducirse(Organismo pareja) {
    }

    @Override
    public void envejecer() {
        edad++;
        salud -= 0.1;
    }

    public double getTasaCrecimiento() {
        return tasaCrecimiento;
    }

    public void setTasaCrecimiento(double tasaCrecimiento) {
        this.tasaCrecimiento = tasaCrecimiento;
    }
}

