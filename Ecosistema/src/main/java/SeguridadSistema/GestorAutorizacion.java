package SeguridadSistema;

public class GestorAutorizacion {
    public boolean verificarAcceso(Usuario usuario, String accion) {
        // Implementación simplificada: verificar rol y acción
        if ("admin".equals(usuario.getRol()) && "configurarSimulacion".equals(accion)) {
            return true;
        }
        return false;
    }
}



