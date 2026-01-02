package modelo;

public class Cliente extends Usuario {
    private static int contadorId = 1;

    private int idCliente;
    private String direccionEntrega;
    private String nivel;
    private int puntosAcumulados;

    
    //===================Constructor======================
    public Cliente(String nombreCompleto,
            String direccionEntrega,
            String usuario, 
            String contrasena,
            String telefono,
            String email,
            String nivel,
             int puntosAcumulados
            ) {
            super(nombreCompleto, usuario, contrasena, telefono, email);
            this.idCliente = contadorId;
            this.direccionEntrega = direccionEntrega;
            this.nivel = nivel;
            this.puntosAcumulados = puntosAcumulados;
                contadorId=contadorId+1;
    }
    //====================Getters y Setters====================
    public int getIdCliente() {
        return idCliente;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String status) {
        this.nivel = status;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public void agregarPuntos(int puntos) {
        this.puntosAcumulados = this.puntosAcumulados + puntos;
    }

    public String toString() {
        return "Cliente{id=" + idCliente + ", nombre=" + getNombreCompleto() + "}";
    }  
}
