package Controladores;

import Repositorios.RepositorioBiblioteca;
import modelos.Bibliotecario;

public class ControladorBiblioteca {

    private ControladorPrincipal controladorPrincipal;
    private RepositorioBiblioteca repoBiblioteca;

    public ControladorBiblioteca(ControladorPrincipal controladorPrincipal,
                                 RepositorioBiblioteca repoBiblioteca) {
        this.controladorPrincipal = controladorPrincipal;
        this.repoBiblioteca = repoBiblioteca;
    }

    // --- Acceso al repositorio ---

    public Bibliotecario[] obtenerBibliotecarios() {
        return repoBiblioteca.todosLosBibliotecarios();
    }

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

    // --- ID automático ---

    public String generarNuevoID() {
        int max = 0;
        for (Bibliotecario b : repoBiblioteca.todosLosBibliotecarios()) {
            if (b != null) {
                try {
                    int valor = Integer.parseInt(b.getIDEmpleado());
                    if (valor > max) max = valor;
                } catch (NumberFormatException e) {
                    // ignorar IDs no numéricos
                }
            }
        }
        int siguiente = max + 1;
        return String.format("%04d", siguiente);
    }

    // --- Cerrar sesión ---

    public void cerrarSesion() {
        controladorPrincipal.mostrarLogin();
    }
}
