package Controladores;

import Repositorios.RepositorioBiblioteca;
import Repositorios.RepositorioEstudiante;
import modelos.Estudiante;
import modelos.Bibliotecario;

public class ControladorLogin {

    private ControladorPrincipal controladorPrincipal;
    private RepositorioBiblioteca bibliotecarios;
    private RepositorioEstudiante estudiantes;

    
//=============================CONSTRUCTOR================================
    public ControladorLogin(ControladorPrincipal controladorPrincipal,
         RepositorioBiblioteca bibliotecarios, RepositorioEstudiante estudiantes) {
        this.controladorPrincipal = controladorPrincipal;
        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiantes;
    }
//============================METODOS=======================================
    public void iniciarSesion(String usuario, String contrasena) {
        // Admin
        if (usuario.equals("admin") && contrasena.equals("admin123")) {
            System.out.println("Bienvenido a Admin");
                controladorPrincipal.mostrarVistaAdmin();
            return;
        }

        // Estudiante
        Estudiante est = estudiantes.buscarPorCredenciales(usuario, contrasena);
        if (est != null) {
            System.out.println("Bienvenido a Estudiante");
                controladorPrincipal.setEstudianteActual(est);
                controladorPrincipal.mostrarVistaEstudiante();
            return;
        }

        // Bibliotecario
        Bibliotecario bib = bibliotecarios.buscarPorCredenciales(usuario, contrasena); 
        if (bib != null) {
            System.out.println("Bienvenido a Bibliotecario");
                controladorPrincipal.setBibliotecarioActual(bib);
                controladorPrincipal.mostrarVistaBibliotecario();
            return;
        }

        // Ninguno
        System.out.println("No se encontro usuario");
    }
}