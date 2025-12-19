package Repositorios;

import modelos.Estudiante;

public class RepositorioEstudiante {
    private Estudiante[] estudiantes = new Estudiante[100];
//-- 
    public void agregarEstudiante(Estudiante estudianteAgregar){
        for(int i=0; i<estudiantes.length;i++){
            if(estudiantes[i]==null){
                estudiantes[i]= estudianteAgregar;
                break;
            }
        }
    }
//--  
    public void eliminarEstudiante(String carnet){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i]!=null && estudiantes[i].getCarnet().equals(carnet)){
                estudiantes[i].setActivo(false);
            }
        }
    }
//--       
    public void mostrarEstudiante(String carnet){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i]!=null && estudiantes[i].getCarnet().equals(carnet) && 
                estudiantes[i].isActivo()){
                System.out.println(estudiantes[i].toString());
            }
        }
    }
//--       
    public Estudiante retornarEstudiante(String carnet){
        for(int i=0;i<estudiantes.length;i++){
            if(estudiantes[i]!=null && estudiantes[i].getCarnet().equals(carnet)){
                return estudiantes[i];
            }
        }
        return null;
    }
//----------------------------------        
    public boolean encontrarEstudiante(String usuario, String contrasena){
        if (usuario == null || contrasena == null) {
            return false;
        }
                usuario = usuario.trim();
                contrasena = contrasena.trim();
        for (Estudiante e : estudiantes) {
            if (e != null &&
                e.getUsuario().equals(usuario) &&
                e.getContrasena().equals(contrasena)) {
                return true;
                }
            }
        return false;
    }
//--       
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
//--  
    public Estudiante buscarPorCarne(String carne) {
        if (carne == null) return null;
        carne = carne.trim();
            for (int i = 0; i < estudiantes.length; i++) {
                if (estudiantes[i] != null &&
                    estudiantes[i].getCarnet().equals(carne)) {
                    return estudiantes[i];
                }
            }
            return null;
    }
//--
    public void eliminarPorCarne(String carne) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null &&
                estudiantes[i].getCarnet().equals(carne)) {
                estudiantes[i] = null;
                break;
            }
        }
    }
//--
    public Estudiante buscarPorCredenciales(String usuario, String contrasena) {
        for (Estudiante e : estudiantes) {
            if (e != null &&
                e.getUsuario().equals(usuario) &&
                e.getContrasena().equals(contrasena)) {
                return e;
            }
        }
        return null;
    }
//--
    public Estudiante[] buscarEstudiantes(String texto) {
        if (texto == null) texto = "";
            texto = texto.trim().toLowerCase();
                if (texto.isEmpty()) {
                    return todoslosestudiantes(); // ya lo tienes
            }
                int conteo = 0;
                    for (Estudiante e : estudiantes) {
                        if (e != null && coincidencia(e, texto)) {
                            conteo++;
                        }
                    }

                Estudiante[] resultado = new Estudiante[conteo];
                    int idx = 0;
            for (Estudiante e : estudiantes) {
                if (e != null && coincidencia(e, texto)) {
                    resultado[idx++] = e;
                }
            }
            return resultado;
        }
//--
    private boolean coincidencia(Estudiante e, String texto) {
           String nombre = e.getNombre();
            if (nombre == null) {
                nombre = "";
            } else {
                nombre = nombre.toLowerCase();
            }

            String carnet = e.getCarnet();
            if (carnet == null) {
                carnet = "";
            } else {
                carnet = carnet.toLowerCase();
            }

            String usuario = e.getUsuario();
            if (usuario == null) {
                usuario = "";
            } else {
                usuario = usuario.toLowerCase();
            }

            return nombre.contains(texto) || carnet.contains(texto) || usuario.contains(texto);
        }
}




    
