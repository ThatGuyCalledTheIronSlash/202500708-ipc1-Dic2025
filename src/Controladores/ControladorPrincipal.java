package Controladores;

import Repositorios.RepositorioBiblioteca;
import Repositorios.RepositorioEstudiante;
import Repositorios.RepositorioLibro;
import InterfacesGraficas.VentanaLogin;
import InterfacesGraficas.VentanaAdmin;
import InterfacesGraficas.VentanaBibliotecario;
import InterfacesGraficas.VentanaEstudiante;
import modelos.Estudiante;
import modelos.Bibliotecario;

public class ControladorPrincipal {

    // Repositorios
        private RepositorioBiblioteca bibliotecarios;
        private RepositorioEstudiante estudiantes;
        private RepositorioLibro libros;

    // Vistas
        private VentanaLogin vLogin;
        private VentanaAdmin vAdmin;
        private VentanaEstudiante vEstudiante;
        private VentanaBibliotecario vBibliotecario;

    // Controladores
        private ControladorLogin controladorLogin;
        private ControladorAdmin controladorAdmin;
        private ControladorEstudiante controladorEstudiante;
        private ControladorBiblioteca controladorBiblioteca;

    public ControladorPrincipal(RepositorioBiblioteca bibliotecarios,RepositorioEstudiante estudiantes,
        RepositorioLibro libros) {
            this.bibliotecarios = bibliotecarios;
            this.estudiantes = estudiantes;
            this.libros = libros;
             iniciarControladores();
             iniciarVistas();
    }   
    //Controladores
    private void iniciarControladores() {
        controladorLogin = new ControladorLogin(this, bibliotecarios, estudiantes);
        controladorAdmin = new ControladorAdmin(this, bibliotecarios, estudiantes, libros);
        controladorEstudiante = new ControladorEstudiante(this, libros);
        controladorBiblioteca = new ControladorBiblioteca(this, bibliotecarios);
    }
    //Vistas
    private void iniciarVistas() {

        vLogin = new VentanaLogin(controladorLogin);
        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);

        vAdmin = new VentanaAdmin(controladorAdmin);
        vAdmin.setLocationRelativeTo(null);
        vAdmin.setVisible(false);

        vEstudiante = new VentanaEstudiante(controladorEstudiante);
        vEstudiante.setLocationRelativeTo(null);
        vEstudiante.setVisible(false);
        
        vBibliotecario = new VentanaBibliotecario(controladorAdmin);
        vBibliotecario.setLocationRelativeTo(null);
        vBibliotecario.setVisible(false);
    }
    //EstabelecerEstudianteActual
    public void setEstudianteActual(Estudiante est) {
        controladorEstudiante.setEstudianteActual(est);
    }
    
    public void setBibliotecarioActual(Bibliotecario b) {
        controladorBiblioteca.setBibliotecarioActual(b);
    }
    
    //Metodos para cambiar de vista
    public void mostrarLogin() {
        ocultarTodasLasVistas();
            vLogin.limpiarCampos();
            vLogin.setVisible(true);
    }
//--
    public void mostrarVistaAdmin() {
        ocultarTodasLasVistas();
            vAdmin.setVisible(true);
    }
//--
    public void mostrarVistaEstudiante() {
        ocultarTodasLasVistas();
            Estudiante est = controladorEstudiante.getEstudianteActual();
                vEstudiante.cargarPerfil(est);
                vEstudiante.recargarCatalogo();
                vEstudiante.setVisible(true);
    }
//--
    public void mostrarVistaBibliotecario() {
        ocultarTodasLasVistas();
        Bibliotecario bib = controladorBiblioteca.getBibliotecarioActual();
        vBibliotecario.cargarPerfil(bib);
        vBibliotecario.recargarTodo();
        vBibliotecario.setVisible(true);
    }    
//--
    private void ocultarTodasLasVistas() {
        if (vLogin != null) vLogin.setVisible(false);
        if (vEstudiante != null) vEstudiante.setVisible(false);
        if (vAdmin != null) vAdmin.setVisible(false);
        if (vBibliotecario != null) vBibliotecario.setVisible(false);
    }
//Obtener Repositorios
    public RepositorioBiblioteca getRepoBibliotecarios() {
        return bibliotecarios; 
    }
//--
    public RepositorioEstudiante getRepoEstudiantes() {
        return estudiantes; 
    }
//--
    public RepositorioLibro getRepoLibros() { 
        return libros; 
    }
}
