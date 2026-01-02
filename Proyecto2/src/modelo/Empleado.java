package modelo;

public class Empleado extends Usuario {
    
  private static int contadorId = 1;

    private int idEmpleado;
    private String dpi;
    private String fechaNacimiento;
    private String puesto;          
    private String turno;         
    private String sucursalAsignada;
    private double salarioBase;
    private boolean activo;
 //===================Constructor======================
    public Empleado(String nombreCompleto,
            String usuario,
            String contrasena,
            String telefono,
            String email,
        String dpi,
        String fechaNacimiento,
        String puesto,
        String turno,
        String sucursalAsignada,
        double salarioBase) {
            super(nombreCompleto, usuario, contrasena, telefono, email);
            this.idEmpleado = contadorId;
            this.dpi = dpi;
            this.fechaNacimiento = fechaNacimiento;
            this.puesto = puesto;
            this.turno = turno;
            this.sucursalAsignada = sucursalAsignada;
            this.salarioBase = salarioBase;
            this.activo = true;
            contadorId=contadorId+1;
    }
//====================Getters y Setters====================
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSucursalAsignada() {
        return sucursalAsignada;
    }

    public void setSucursalAsignada(String sucursalAsignada) {
        this.sucursalAsignada = sucursalAsignada;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String toString() {
        return "Empleado{id=" + idEmpleado + ", nombre=" + getNombreCompleto() + "}";
    }
}  
    
