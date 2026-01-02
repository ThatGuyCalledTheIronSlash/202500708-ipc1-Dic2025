package Controladores;

import Repositorios.RepositorioBiblioteca;
import modelos.Bibliotecario;

public class ControladorBiblioteca {

    private ControladorPrincipal controladorPrincipal;
    private RepositorioBiblioteca repoBiblioteca;
    private Bibliotecario bibliotecarioActual;

    public ControladorBiblioteca(ControladorPrincipal controladorPrincipal, RepositorioBiblioteca repoBiblioteca) {
        this.controladorPrincipal = controladorPrincipal;
        this.repoBiblioteca = repoBiblioteca;
    }

 //============================= OBTENER DATOS =======================
    public Bibliotecario[] obtenerBibliotecarios() {
        return repoBiblioteca.todosLosBibliotecarios();
    }

    public void setBibliotecarioActual(Bibliotecario bibliotecario) {
        this.bibliotecarioActual = bibliotecario;
    }
    
    public Bibliotecario getBibliotecarioActual() {
       return bibliotecarioActual;
    }

//============================= OPERACIONES ===========================
    public Bibliotecario buscarPorID(String idEmpleado) {
        if (idEmpleado == null) return null;
        idEmpleado = idEmpleado.trim();
        if (idEmpleado.isEmpty()) return null;
        return repoBiblioteca.retornarBibliotecario(idEmpleado);
    }

    public String eliminarBibliotecario(String idEmpleado) {
        if (idEmpleado == null) {
                return "Operación cancelada.";
            }
        idEmpleado = idEmpleado.trim();
            if (idEmpleado.isEmpty()) {
                return "Debe ingresar un ID de empleado.";
            }

            Bibliotecario b = repoBiblioteca.retornarBibliotecario(idEmpleado);
                if (b == null) {
                    return "No se encontró un bibliotecario con ese ID.";
                }

            repoBiblioteca.eliminarBibliotecario(idEmpleado);
                return "Bibliotecario \"" + b.getNombre() + "\" eliminado correctamente.";
        }
    
//============================= NAVEGACION =============================
    
    public void cerrarSesion() {
        controladorPrincipal.mostrarLogin();
    }
    
}
