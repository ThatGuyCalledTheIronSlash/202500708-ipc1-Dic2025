package modelos;


import modelos.Usuario;


public class Estudiante extends Usuario {
    private String carrera;
    private int semestre;
    private String facultad;
    private String carnet;
    private boolean activo;
    
public Estudiante(String carrera, int semestre, String facultad, String carnet,String nombre, String CUI, String correo, String contrasena, String usuario,
    char genero, int telefono, int edad, char estadoCivil){
    
    
        super(nombre, CUI, correo, contrasena, usuario, genero, telefono, edad, estadoCivil);
        this.carrera = carrera;
        this.semestre = semestre;
        this.facultad = facultad;
        this.carnet = carnet;
        this.activo=true;
    }
//-----------------------------------------------------
    public Estudiante(){
        super();
        this.activo = true;
    }
//-----------------------------------------------------    
    public String getCarrera(){
        return carrera;
    }
    
    public void setCarrera(String carrera){
        this.carrera= carrera;
    }
 //-----------------------------------------------------   
    public int getSemestre(){
        return semestre;
    }
    
    public void setSemestre(int semestre){
        this.semestre = semestre;
    }
//-----------------------------------------------------    
    public String getFacultad(){
        return facultad;
    }
    
    public void setFacultad(String facultad){
        this.facultad=facultad;
    }
//-----------------------------------------------------    
    public void setCarnet(String carne){
        this.carnet = carnet;
    }
    public String getCarnet(){
        return carnet;
    }
//-----------------------------------------------------
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
//-----------------------------------------------------
    @Override
    public String toString() {
        return "Estudiante{" + 
                "carrera=" + carrera + 
                ", semestre=" + semestre + 
                ", facultad=" + facultad + 
                ", carne=" + carnet + 
                ", activo=" + activo + 
                super.toString();
    }
       
}
