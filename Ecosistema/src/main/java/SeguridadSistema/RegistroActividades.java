package SeguridadSistema;

import java.util.ArrayList;
import java.util.List;

public class RegistroActividades {
    private List<String> registros = new ArrayList<>();

    public void registrar(String mensaje) {
        registros.add(mensaje);
    }
}

