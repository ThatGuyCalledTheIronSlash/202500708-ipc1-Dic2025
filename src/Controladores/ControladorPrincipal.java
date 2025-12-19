package Controladores;

import Repositorios.RepositorioBiblioteca;
import Repositorios.RepositorioEstudiante;
import Repositorios.RepositorioLibro;
import InterfacesGraficas.VentanaLogin;
import InterfacesGraficas.VentanaAdmin;
import InterfacesGraficas.VentanaEstudiante;

public class ControladorPrincipal {

    // Repositorios
    private RepositorioBiblioteca bibliotecarios;
    private RepositorioEstudiante estudiantes;
    private RepositorioLibro libros;

    // Vistas (se crean una vez)
    private VentanaLogin vLogin;
    private VentanaAdmin vAdmin;
    private VentanaEstudiante vEstudiante;

    // Controladores
    private ControladorLogin controladorLogin;
    private ControladorAdmin controladorAdmin;
    private ControladorEstudiante controladorEstudiante;

    public ControladorPrincipal(RepositorioBiblioteca bibliotecarios,
                                RepositorioEstudiante estudiantes,
                                RepositorioLibro libros) {

        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiantes;
        this.libros = libros;

        iniciarControladores();
        iniciarVistas();
    }

    //------------ Controladores ----------------
    private void iniciarControladores() {
        controladorLogin = new ControladorLogin(this, bibliotecarios, estudiantes);
        controladorAdmin = new ControladorAdmin(this, bibliotecarios, estudiantes, libros);
        controladorEstudiante = new ControladorEstudiante(this, libros);
    }

    //------------ Vistas ----------------
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
    }

    //------------ Métodos para cambiar de vista -------------
    public void mostrarLogin() {
        ocultarTodasLasVistas();
        vLogin.limpiarCampos();
        vLogin.setVisible(true);
    }

    public void mostrarVistaAdmin() {
        ocultarTodasLasVistas();
        vAdmin.setVisible(true);
    }

    public void mostrarVistaEstudiante() {
        ocultarTodasLasVistas();
        vEstudiante.recargarCatalogo();
        vEstudiante.setVisible(true);
    }

    private void ocultarTodasLasVistas() {
        if (vLogin != null) vLogin.setVisible(false);
        if (vEstudiante != null) vEstudiante.setVisible(false);
        if (vAdmin != null) vAdmin.setVisible(false);
    }

    // Opcional: getters por si algún controlador necesita los repos
    public RepositorioBiblioteca getRepoBibliotecarios() { return bibliotecarios; }
    public RepositorioEstudiante getRepoEstudiantes() { return estudiantes; }
    public RepositorioLibro getRepoLibros() { return libros; }
}
