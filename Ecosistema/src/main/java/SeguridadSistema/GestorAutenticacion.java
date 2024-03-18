package SeguridadSistema;

import java.util.HashMap;
import java.util.Map;

public class GestorAutenticacion {
    private Map<String, Usuario> usuariosRegistrados = new HashMap<>();

    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        Usuario usuario = usuariosRegistrados.get(nombreUsuario);
        if (usuario != null && usuario.getContraseñaHash().equals(contraseña.hashCode())) {
            // La autenticación es exitosa
            return true;
        }
        return false;
    }

    public void registrarUsuario(String nombreUsuario, String contraseña, String rol) {
        usuariosRegistrados.put(nombreUsuario, new Usuario(nombreUsuario, String.valueOf(contraseña.hashCode()), rol));
    }
}


