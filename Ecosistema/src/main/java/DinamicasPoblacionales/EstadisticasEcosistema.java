package DinamicasPoblacionales;
import Entidades.Animales;
import Entidades.Planta;
import Entidades.Organismo;
import java.util.List;

public class EstadisticasEcosistema {
    public static void mostrarEstadisticas(List<Organismo> organismos) {
        int cantidadAnimales = 0;
        int cantidadPlantas = 0;
        for (Organismo organismo : organismos) {
            if (organismo instanceof Animales) {
                cantidadAnimales++;
            } else if (organismo instanceof Planta) {
                cantidadPlantas++;
            }
            System.out.println("Cantidad de animales: " + cantidadAnimales);
            System.out.println("Cantidad de plantas: " + cantidadPlantas);
        }
    }
}
