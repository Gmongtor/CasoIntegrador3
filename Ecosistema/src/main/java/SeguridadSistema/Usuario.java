package SeguridadSistema;

public class Usuario {
    private String nombreUsuario;
    private String contraseñaHash;
    private String rol;

    public Usuario(String nombreUsuario, String contraseñaHash, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseñaHash = contraseñaHash;
        this.rol = rol;
    }

    // Getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseñaHash() {
        return contraseñaHash;
    }

    public String getRol() {
        return rol;
    }
}


