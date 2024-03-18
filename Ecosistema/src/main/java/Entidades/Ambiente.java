package Entidades;
import java.util.HashMap;
import java.util.Map;

public class Ambiente {
    private String clima;
    private String terreno;
    private double recursosDisponibles;
    private Map<String, Double> factoresAmbientales;

    public Ambiente(String clima, String terreno, double recursosDisponibles) {
        this.clima = clima;
        this.terreno = terreno;
        this.recursosDisponibles = recursosDisponibles;
        this.factoresAmbientales = new HashMap<>();
        inicializarFactoresAmbientales();
    }

    private void inicializarFactoresAmbientales() {
        factoresAmbientales.put("temperatura", 20.0);
        factoresAmbientales.put("humedad", 50.0);
        factoresAmbientales.put("nutrientes", 100.0);
    }

    public void actualizarClima(String nuevoClima) {
        this.clima = nuevoClima;
        // Implementación de ajustes de factores ambientales según el clima puede variar.
    }

    public void simularEvento(String evento) {
        switch (evento) {
            case "lluvia":
                factoresAmbientales.put("humedad", factoresAmbientales.get("humedad") + 20);
                recursosDisponibles += 50;
                break;
            case "sequía":
                factoresAmbientales.put("humedad", Math.max(0, factoresAmbientales.get("humedad") - 30));
                recursosDisponibles -= 50;
                break;
            case "incendio":
                factoresAmbientales.put("temperatura", factoresAmbientales.get("temperatura") + 10);
                factoresAmbientales.put("nutrientes", factoresAmbientales.get("nutrientes") - 40);
                // Los incendios reducen significativamente los nutrientes disponibles
                break;
            case "inundación":
                factoresAmbientales.put("humedad", 100.0); // La humedad alcanza su máximo
                recursosDisponibles += 100; // Aumento significativo en recursos hídricos
                factoresAmbientales.put("nutrientes", factoresAmbientales.get("nutrientes") + 20); // Las inundaciones pueden aportar nutrientes
                break;
            case "cambio estacional":
                // Suponiendo un cambio hacia una estación más fría como ejemplo
                factoresAmbientales.put("temperatura", factoresAmbientales.get("temperatura") - 10);
                // Ajustes específicos para otros factores podrían agregarse aquí
                break;
            default:
                System.out.println("Evento no reconocido.");
                break;
        }
    }

    // Getters y setters
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


