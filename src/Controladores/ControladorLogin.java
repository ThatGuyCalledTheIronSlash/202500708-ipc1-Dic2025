package Controladores;

import Repositorios.RepositorioBiblioteca;
import Repositorios.RepositorioEstudiante;
import modelos.Estudiante;

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
        Estudiante est = estudiantes.buscarPorCredenciales(usuario, contrasena);
        if (est != null) {
            System.out.println("Bienvenido a Estudiante");
            controladorPrincipal.setEstudianteActual(est);  // << importante
            controladorPrincipal.mostrarVistaEstudiante();
            return;
        }

        // Bibliotecario
        if (bibliotecarios.encontrarBibliotecario(usuario, contrasena)) {
            System.out.println("Bienvenido a Bibliotecario");
            // En progreso
            controladorPrincipal.mostrarVistaAdmin();
            return;
        }

        // Ninguno
        System.out.println("No se encontrÃ³ usuario");
    }
}