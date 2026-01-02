package modelo;

public class Sucursal {

    private static int contadorId = 1;

    private int idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private String gerenteAsignado;
    private int capacidadMesas;
    private String horario;   
    private String estado;
//===============CONSTRUCTOR==================
    public Sucursal(String nombre,String direccion,String telefono,String gerenteAsignado,
        int capacidadMesas,String horario,String estado) {
            this.idSucursal = contadorId;
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
            this.gerenteAsignado = gerenteAsignado;
            this.capacidadMesas = capacidadMesas;
            this.horario = horario;
            this.estado = estado;
            contadorId = contadorId + 1;
    }
//============Getters y Setters ==============
    public int getIdSucursal() {
        return idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGerenteAsignado() {
        return gerenteAsignado;
    }

    public void setGerenteAsignado(String gerenteAsignado) {
        this.gerenteAsignado = gerenteAsignado;
    }

    public int getCapacidadMesas() {
        return capacidadMesas;
    }

    public void setCapacidadMesas(int capacidadMesas) {
        this.capacidadMesas = capacidadMesas;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String toString() {
        return "Sucursal{id=" + idSucursal + ", nombre=" + nombre + "}";
    }
}
