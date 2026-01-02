package modelos;
public class Bibliotecario extends Usuario{
    private String IDEmpleado;
    private String turno;
    private String areaTrabajo;
    private double salario;
    
//===========================Constructor=======================
    public Bibliotecario(String IDEmpleado, String turno, String areaTrabajo,
                         String nombre, String CUI, String correo, String usuario,
                         String contrasena, char genero, int telefono,
                         char estadoCivil, double salario) {
        
        super(nombre, CUI, correo, contrasena, usuario, genero, telefono, 0, estadoCivil);
        this.IDEmpleado = IDEmpleado;
        this.turno = turno;
        this.areaTrabajo = areaTrabajo;
        this.salario = salario;
    }
//---------------------------------------
    public Bibliotecario(){
        super();
    }
    //============================== Getters y Setters ==================================
//----------------------------------------    
    public String getIDEmpleado() {
        return IDEmpleado;
    }
    public void setIDEmpleado(String IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }
//-----------------------------------------
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
//---------------------------------------------
    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }
//-----------------------------------------------
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
//-----------------------------------------------
    @Override
    public String toString() {
        return "Bibliotecario{" + 
                "IDEmpleado=" + IDEmpleado 
                + ", turno=" + turno + 
                ", areaTrabajo=" + 
                areaTrabajo + 
                super.toString();
    }  
}
