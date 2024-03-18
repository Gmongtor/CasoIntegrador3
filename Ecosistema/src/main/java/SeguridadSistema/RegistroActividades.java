package SeguridadSistema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroActividades {
    private static final String ARCHIVO_LOG = "simulaciones.log";

    public static void registrar(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_LOG, true))) {
            bw.write(mensaje);
            bw.newLine();
            System.out.println("Registro de actividad: " + mensaje);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de registro");
            e.printStackTrace();
        }
    }
}

