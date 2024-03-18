package SeguridadSistema;
import java.util.HashMap;
import java.util.Map;

public class Autenticacion {
    private Map<String, String> usuarios = new HashMap<>();

    public Autenticacion() {
        // Ejemplo de usuario predeterminado, en práctica usa contraseñas cifradas
        usuarios.put("investigador", "12345");
    }

    public boolean autenticar(String usuario, String contraseña) {
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contraseña);
    }
}

