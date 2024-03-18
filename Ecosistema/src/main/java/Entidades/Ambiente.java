package Entidades;
import java.util.HashMap;
import java.util.Map;

public class Ambiente {
    private String clima;
    private String terreno;
    private double recursosDisponibles;
    private Map<String, Double> factoresAmbientales; // Ejemplo: temperatura, humedad, nutrientes

    public Ambiente(String clima, String terreno, double recursosDisponibles) {
        this.clima = clima;
        this.terreno = terreno;
        this.recursosDisponibles = recursosDisponibles;
        this.factoresAmbientales = new HashMap<>();
        inicializarFactoresAmbientales();
    }

    private void inicializarFactoresAmbientales() {
        // Inicializar con valores predeterminados. Estos podrían variar según el clima y terreno.
        factoresAmbientales.put("temperatura", 20.0); // Temperatura en grados Celsius
        factoresAmbientales.put("humedad", 50.0); // Humedad como porcentaje
        factoresAmbientales.put("nutrientes", 100.0); // Nivel de nutrientes disponibles
    }

    public void actualizarClima(String nuevoClima) {
        this.clima = nuevoClima;
        // Aquí se pueden ajustar los factores ambientales en respuesta al cambio de clima.
    }

    public void simularEvento(String evento) {
        // Ejemplo de cómo un evento (e.g., lluvia, sequía, incendio) podría afectar los factores ambientales
        switch (evento) {
            case "lluvia":
                this.factoresAmbientales.put("humedad", this.factoresAmbientales.get("humedad") + 20);
                this.recursosDisponibles += 50; // Asumimos que la lluvia aumenta los recursos hídricos disponibles
                break;
            case "sequía":
                this.factoresAmbientales.put("humedad", Math.max(0, this.factoresAmbientales.get("humedad") - 30));
                this.recursosDisponibles -= 50; // Los recursos hídricos disminuyen
                break;
            // Agregar más eventos según sea necesario
        }
    }

    // Métodos getters y setters para acceder y modificar los atributos y factores ambientales
    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public double getRecursosDisponibles() {
        return recursosDisponibles;
    }

    public void setRecursosDisponibles(double recursosDisponibles) {
        this.recursosDisponibles = recursosDisponibles;
    }

    public Map<String, Double> getFactoresAmbientales() {
        return factoresAmbientales;
    }

    public void setFactoresAmbientales(Map<String, Double> factoresAmbientales) {
        this.factoresAmbientales = factoresAmbientales;
    }
}

