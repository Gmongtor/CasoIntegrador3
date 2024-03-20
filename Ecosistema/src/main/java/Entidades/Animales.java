package Entidades;

import java.util.List;
import java.util.Random;

public class Animales extends Organismo {
    private double velocidadMovimiento;
    private double energia;
    private String tipo; // Tipo de animal (por ejemplo, "León", "Tigre", "Elefante")
    private static final Random random = new Random();

    public Animales(int posX, int posY, double salud, int edad, boolean estadoReproductivo, double velocidadMovimiento, double energia, String tipo) {
        super(posX, posY, salud, edad, estadoReproductivo);
        this.velocidadMovimiento = velocidadMovimiento;
        this.energia = energia;
        this.tipo = tipo;
    }

    @Override
    public void mover() {
        if (!estaVivo()) return;
        posX += random.nextInt(3) - 1;
        posY += random.nextInt(3) - 1;
        consumirEnergia(1);
    }

    @Override
    public Organismo reproducirse() {
        if (random.nextDouble() < 0.05 && estaVivo() && estadoReproductivo && salud > 50) { // Probabilidad del 5% de reproducción
            Animales cria = new Animales(posX, posY, 100, 0, false, velocidadMovimiento, energia / 2, tipo); // La cría hereda características pero comienza con la mitad de energía
            System.out.println(this.tipo + " se ha reproducido.");
            return cria;
        }
        return null;
    }

    @Override
    public void envejecer() {
        if (!estaVivo()) return;
        edad++;
        salud -= 0.05;
        if (salud <= 0) marcarComoMuerto();
    }

    public void comer(double cantidad) {
        if (!estaVivo()) return;
        energia += cantidad;
        if (energia > 100) energia = 100;
    }

    private void consumirEnergia(double cantidad) {
        energia -= cantidad;
        if (energia <= 0) {
            marcarComoMuerto();
        }
    }

    @Override
    public void visualizar() {
        System.out.println("Tipo: " + tipo + " - Posición: (" + posX + "," + posY + "), Salud: " + salud + ", Edad: " + edad + ", Energía: " + energia);
    }
    @Override
    public boolean esPredador() {
        // Definimos que solo leones y tigres son considerados predadores en este ejemplo
        return tipo.equals("León") || tipo.equals("Tigre");
    }

    // Método cazar corregido para considerar el nuevo método esPredador en la clase Organismo
    public void cazar(List<Organismo> posiblesPresas) {
        if (!esPredador()) return; // Utiliza el método esPredador para verificar si el animal puede cazar

        Organismo presaCazada = posiblesPresas.stream()
                .filter(presa -> !presa.esPredador()) // Filtra para cazar solo a las presas, no a otros predadores
                .findAny().orElse(null); // Encuentra cualquier presa potencial

        if (presaCazada != null) {
            double energiaObtenida = 10; // Ejemplo simplificado
            this.energia += energiaObtenida;
            presaCazada.decrementarSalud((int) energiaObtenida); // Asume que decrementarSalud() afecta la salud de la presa
            System.out.println(tipo + " ha cazado a " + ((Animales)presaCazada).getTipo());
            // Considera remover la presa de la lista en el simulador, no aquí, para evitar ConcurrentModificationException
        }
    }

    public double getVelocidadMovimiento() {
        return velocidadMovimiento;
    }

    public void setVelocidadMovimiento(double velocidadMovimiento) {
        this.velocidadMovimiento = velocidadMovimiento;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}





