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
        // Aquí podrías ajustar los factores ambientales según el nuevo clima, si es necesario.
    }

    public void simularEvento(String evento) {
        switch (evento.toLowerCase()) {
            case "lluvia":
                ajustarPorLluvia();
                break;
            case "sequía":
                ajustarPorSequia();
                break;
            case "incendio":
                ajustarPorIncendio();
                break;
            case "inundación":
                ajustarPorInundacion();
                break;
            case "cambio estacional":
                ajustarPorCambioEstacional();
                break;
            default:
                System.out.println("Evento no reconocido: " + evento);
                break;
        }
    }

    private void ajustarPorLluvia() {
        factoresAmbientales.put("humedad", factoresAmbientales.get("humedad") + 20);
        recursosDisponibles += 50;
        System.out.println("El evento de lluvia aumenta la humedad y los recursos hídricos disponibles.");
    }

    private void ajustarPorSequia() {
        factoresAmbientales.put("humedad", Math.max(0, factoresAmbientales.get("humedad") - 30));
        recursosDisponibles -= 50;
        System.out.println("El evento de sequía reduce la humedad y los recursos hídricos disponibles.");
    }

    private void ajustarPorIncendio() {
        factoresAmbientales.put("temperatura", factoresAmbientales.get("temperatura") + 10);
        factoresAmbientales.put("nutrientes", Math.max(0, factoresAmbientales.get("nutrientes") - 40));
        System.out.println("El evento de incendio aumenta la temperatura y reduce los nutrientes disponibles.");
    }

    private void ajustarPorInundacion() {
        factoresAmbientales.put("humedad", 100.0);
        recursosDisponibles += 100;
        factoresAmbientales.put("nutrientes", factoresAmbientales.get("nutrientes") + 20);
        System.out.println("El evento de inundación maximiza la humedad y aumenta los recursos hídricos y nutrientes disponibles.");
    }

    private void ajustarPorCambioEstacional() {
        // Este método se mantiene intencionalmente simple para el ejemplo.
        factoresAmbientales.put("temperatura", factoresAmbientales.get("temperatura") - 10);
        System.out.println("El evento de cambio estacional ajusta la temperatura.");
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

    public void setFactoresAmbientales(Map<String, Double> factoresAmbientales
    ) {
        this.factoresAmbientales = factoresAmbientales;
    }
}



