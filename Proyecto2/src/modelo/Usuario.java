package modelo;

public class Usuario {
    private String nombreCompleto;
    private String usuario;
    private String contrasena;
    private String telefono;
    private String email;
    
public Usuario(String nombreCompleto, String usuario, String contrasena, String telefono, String email){
    
    this.nombreCompleto = nombreCompleto;
    this.usuario = usuario;
    this.contrasena = contrasena;
    this.telefono = telefono;
    this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
