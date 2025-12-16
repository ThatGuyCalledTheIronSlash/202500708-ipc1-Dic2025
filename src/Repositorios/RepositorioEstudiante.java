package Repositorios;

import modelos.Estudiante;

public class RepositorioEstudiante {
    private Estudiante[] estudiantes = new Estudiante[100];
//-----------------------------------    
    public void agregarEstudiante(Estudiante estudianteAgregar){
        for(int i=0; i<estudiantes.length;i++){
            if(estudiantes[i]==null){
                estudiantes[i]= estudianteAgregar;
                break;
            }
        }
    }
//----------------------------------        
    public void eliminarEstudiante(String carnet){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i]!=null && estudiantes[i].getCarnet().equals(carnet)){
                estudiantes[i].setActivo(false);
            }
        }
    }
//----------------------------------        
    public void mostrarEstudiante(String carnet){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i]!=null && estudiantes[i].getCarnet().equals(carnet) && 
                estudiantes[i].isActivo()){
                System.out.println(estudiantes[i].toString());
            }
        }
    }
//----------------------------------        
    public Estudiante retornarEstudiante(String carnet){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i]!=null && estudiantes[i].getCarnet().equals(carnet)){
                return estudiantes[i];
            }
        }
        return null;
    }
//----------------------------------        
    public boolean encontrarEstudiante(String carnet, String contrasena){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i] != null && estudiantes[i].getCarnet().equals(carnet) && 
                    estudiantes[i].getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }
//----------------------------------       
    public Estudiante[] todoslosestudiantes(){
        int contador = 0;
        for (Estudiante e : estudiantes) {
            if (e != null) contador++;
        }
        Estudiante[] copia = new Estudiante[contador];
        int idx = 0;
        for (Estudiante e : estudiantes) {
            if (e != null) {
                copia[idx++] = e;
            }
        }
        return copia;
    }
//----------------------------------    
    public Estudiante buscarPorCarne(String carne) {
    for (int i = 0; i < estudiantes.length; i++) {
        if (estudiantes[i] != null
            && estudiantes[i].getCarnet().equals(carne)) {
            return estudiantes[i];
        }
    }
    return null;
    }
//----------------------------------
    public void eliminarPorCarne(String carne) {
    for (int i = 0; i < estudiantes.length; i++) {
        if (estudiantes[i] != null &&
            estudiantes[i].getCarnet().equals(carne)) {
            estudiantes[i] = null;
            break;
        }
    }
}
}

    
