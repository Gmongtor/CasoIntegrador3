package SeguridadSistema;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroActividades {
    private static final Logger LOGGER = Logger.getLogger(RegistroActividades.class.getName());

    public void registrar(String mensaje) {
        LOGGER.log(Level.INFO, mensaje); // Utilizar java.util.logging para un manejo de logs más robusto
    }
}


