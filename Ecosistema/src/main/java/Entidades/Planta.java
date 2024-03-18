package Entidades;

public class Planta extends Organismo {
    private double tasaCrecimiento;

    public Planta(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double tasaCrecimiento) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.tasaCrecimiento = tasaCrecimiento;
    }


    @Override
    public void mover() {
        salud += tasaCrecimiento;
    }

    @Override
    public void reproducirse(Organismo pareja) {
        if (estadoReproductivo && salud > 50) {
            System.out.println("Dispersando semillas...");
        }
    }


    @Override
    public void envejecer() {
        edad++;
        salud -= 0.1;
        if (edad > 1 && salud > 50) {
            estadoReproductivo = true;
        }
    }
    public double getTasaCrecimiento() { return tasaCrecimiento; }
    public void setTasaCrecimiento(double tasaCrecimiento) { this.tasaCrecimiento = tasaCrecimiento; }
}


