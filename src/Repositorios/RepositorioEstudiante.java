package Repositorios;

import modelos.Estudiante;

public class RepositorioEstudiante {
    private Estudiante[] estudiantes = new Estudiante[100];

//================================UTILIDADES=================================
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

    public void agregarEstudiante(Estudiante estudianteAgregar){
        for(int i=0; i<estudiantes.length;i++){
            if(estudiantes[i]==null){
                estudiantes[i]= estudianteAgregar;
                break;
            }
        }
    }
    
    public Estudiante buscarPorCarne(String carne) {
        if (carne == null) return null;
            carne = carne.trim();
        if (carne.isEmpty()) return null;
            return buscarPorCarneRecursivo(carne, 0);
    }
    
    private Estudiante buscarPorCarneRecursivo(String carne, int indice) {
        if (indice >= estudiantes.length) {
            return null;
        }
        Estudiante actual = estudiantes[indice];
        if (actual != null && carne.equals(actual.getCarnet())) {
            return actual;
        }
        return buscarPorCarneRecursivo(carne, indice + 1);
}
    
    public void eliminarPorCarne(String carne) {
        if (carne == null) return;
            carne = carne.trim();
        if (carne.isEmpty()) return;

        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null &&
                estudiantes[i].getCarnet().equals(carne)) {
                estudiantes[i] = null;
                break;
            }
        }
    }
       
//===============================BUSQUEDAS====================================
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
//===============================METODOS======================================    
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
//================================PARA EL LOGIN ==============================
    public Estudiante buscarPorCredenciales(String usuario, String contrasena) {
        if (usuario == null || contrasena == null) {
                    return null;
                }
                usuario = usuario.trim();
                contrasena = contrasena.trim();
                for (Estudiante e : estudiantes) {
                    if (e != null &&
                        e.getUsuario().equals(usuario) &&
                        e.getContrasena().equals(contrasena)) {
                        return e;
                    }
                }
                return null;
            }
//============================================================================
}

    
