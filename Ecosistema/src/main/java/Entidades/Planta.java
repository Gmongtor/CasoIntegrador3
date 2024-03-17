package  Entidades;
public class Planta extends Organismo {
    private double tasaCrecimiento;

    public Planta(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double tasaCrecimiento) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.tasaCrecimiento = tasaCrecimiento;
    }

    @Override
    public void mover() {
        // Las plantas no se mueven pero pueden crecer, extendiendo su tamaño o influencia.
        // Podríamos interpretar el movimiento como un crecimiento basado en su tasa de crecimiento.
        this.salud += this.tasaCrecimiento; // Asumimos que la salud puede representar también el tamaño o vitalidad.
    }

    @Override
    public void reproducirse(Organismo pareja) {
        // Las plantas se reproducen dispersando semillas alrededor de su ubicación actual.
        // Este método podría ser implementado para crear nuevas plantas en posiciones cercanas.
        // Nota: La implementación específica dependerá de cómo se maneje la lógica del ecosistema en el simulador.
        if (this.estadoReproductivo && this.salud > 50) { // Ejemplo de condición para reproducirse.
            // Lógica para dispersar semillas y crear nuevas plantas.
            System.out.println("Dispersando semillas...");
            // La creación de nuevas plantas se manejará en la lógica del simulador.
        }
    }

    @Override
    public void envejecer() {
        this.edad++;
        this.salud -= 0.1; // Las plantas pierden salud (vitalidad) con el tiempo, representando su envejecimiento.
        if (this.edad > 1) { // Ejemplo de condición para alcanzar el estado reproductivo.
            this.estadoReproductivo = true;
        }
    }

    public double getTasaCrecimiento() {
        return tasaCrecimiento;
    }

    public void setTasaCrecimiento(double tasaCrecimiento) {
        this.tasaCrecimiento = tasaCrecimiento;
    }
}

