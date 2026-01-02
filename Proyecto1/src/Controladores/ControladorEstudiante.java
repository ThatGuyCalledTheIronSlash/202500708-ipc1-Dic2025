
package Controladores;

import modelos.Estudiante;
import modelos.Libro;
import Repositorios.RepositorioLibro;

public class ControladorEstudiante {
   
    private ControladorPrincipal controladorPrincipal;
    private RepositorioLibro libros;
    private Estudiante estudianteActual;
    
//===================== CONSTRUCTOR ==============================
    public ControladorEstudiante(ControladorPrincipal controladorPrincipal,
        RepositorioLibro libros){
            this.controladorPrincipal = controladorPrincipal;
            this.libros = libros;
    }
//======================== OBTENER DATOS ================================   
    public Libro[] obtenerCatalogoLibros(){
        return libros.todosLosLibros();
    }
    
    public void setEstudianteActual(Estudiante estudiante) {
        this.estudianteActual = estudiante;
    }

    public Estudiante getEstudianteActual() {
        return estudianteActual;
    }
    
//========================= METODOS ======================================
    
    public Libro[] buscarLibros(String texto, String filtro) {
        return libros.buscarLibros(texto, filtro);
    }
       
    public void CerrarSesion(){
         controladorPrincipal.mostrarLogin();
    }

}
