package ejemploestudiante;

import modelos.Estudiante;

public class RepositorioEstudiante {
    private Estudiante[] estudiantes = new Estudiante[100];
    
    public void agregarEstudiante(Estudiante estudianteAgregar){
        for(int i=0; i<estudiantes.length;i++){
            if(estudiantes[i]==null){
                estudiantes[i]= estudianteAgregar;
                break;
            }
        }
    }
    
    public void eliminarEstudiante(String carnet){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i]!=null && estudiantes[i].getCarnet().equals(carnet)){
                estudiantes[i].setActivo(false);
            }
        }
    }
    
    public void mostrarEstudiante(String carnet){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i]!=null && estudiantes[i].getCarnet().equals(carnet) && 
                estudiantes[i].isActivo()){
                System.out.println(estudiantes[i].toString());
            }
        }
    }
    
    public Estudiante retornarEstudiante(String carnet){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i]!=null && estudiantes[i].getCarnet().equals(carnet)){
                return estudiantes[i];
            }
        }
        return null;
    }
    
    public boolean encontrarEstudiante(String carnet, String contrasena){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i] != null && estudiantes[i].getCarnet().equals(carnet) && 
                    estudiantes[i].getcontrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }
    
    public Estudiante[] todoslosestudiantes(){
        return estudiantes;
    }
}

    
