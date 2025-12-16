package Controladores;

import Repositorios.RepositorioBiblioteca;
import Repositorios.RepositorioEstudiante;

public class ControladorLogin {

    private ControladorPrincipal controladorPrincipal;
    private RepositorioBiblioteca bibliotecarios;
    private RepositorioEstudiante estudiantes;

    public ControladorLogin(ControladorPrincipal controladorPrincipal,
                            RepositorioBiblioteca bibliotecarios,
                            RepositorioEstudiante estudiantes) {

        this.controladorPrincipal = controladorPrincipal;
        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiantes;
    }

    public void iniciarSesion(String usuario, String contrasena) {

        // Admin
        if (usuario.equals("admin") && contrasena.equals("admin123")) {
            System.out.println("Bienvenido a Admin");
            controladorPrincipal.mostrarVistaAdmin();
            return;
        }

        // Estudiante
        if (estudiantes.encontrarEstudiante(usuario, contrasena)) {
            System.out.println("Bienvenido a Estudiante");
            controladorPrincipal.mostrarVistaEstudiante();
            return;
        }

        // Bibliotecario
        if (bibliotecarios.encontrarBibliotecario(usuario, contrasena)) {
            System.out.println("Bienvenido a Bibliotecario");
            // Aún no tienes vista de bibliotecario, de momento podrías reusar Admin
            controladorPrincipal.mostrarVistaAdmin();
            return;
        }

        // Ninguno
        System.out.println("No se encontró usuario");
    }
}
