
package Controladores;

import modelos.Libro;
import Repositorios.RepositorioLibro;
import modelos.Estudiante;

public class ControladorEstudiante {
    
    private ControladorPrincipal controladorPrincipal;
    private RepositorioLibro libros;
    private Estudiante estudianteActual;
    
 //----------------------------------------------   
    public ControladorEstudiante(ControladorPrincipal controladorPrincipal,
        RepositorioLibro libros){
            this.controladorPrincipal = controladorPrincipal;
            this.libros = libros;
    }
//----------------------------------------------    
    public Libro[] obtenerCatalogoLibros(){
        return libros.todosLosLibros();
    }
//----------------------------------------------       
    public void CerrarSesion(){
         controladorPrincipal.mostrarLogin();
    }
//----------------------------------------------
    public Libro[] buscarLibros(String texto, String filtro) {
        return libros.buscarLibros(texto, filtro);
    }
//------------------------------------------------
    public void setEstudianteActual(modelos.Estudiante estudiante) {
        this.estudianteActual = estudiante;
    }
//-----------------------------------------------
    public modelos.Estudiante getEstudianteActual() {
        return estudianteActual;
    }
}
