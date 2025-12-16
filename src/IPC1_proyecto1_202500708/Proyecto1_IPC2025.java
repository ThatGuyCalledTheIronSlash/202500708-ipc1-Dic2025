
package IPC1_proyecto1_202500708;

import Repositorios.RepositorioBiblioteca;
import Repositorios.RepositorioEstudiante;
import Repositorios.RepositorioLibro;
import Controladores.ControladorPrincipal;
import modelos.Estudiante;
import modelos.Bibliotecario;

public class Proyecto1_IPC2025 {

    public static RepositorioEstudiante estudiantes = new RepositorioEstudiante();
    public static RepositorioBiblioteca bibliotecarios = new RepositorioBiblioteca();
    public static RepositorioLibro libros = new RepositorioLibro();

    public static void main(String[] args) {

        cargarDatosIniciales();

        ControladorPrincipal controladorprincipal = new Controladores.ControladorPrincipal(
                        bibliotecarios, estudiantes, libros);
    }

    private static void cargarDatosIniciales() {
        Estudiante nuevoEstudiante = new Estudiante(
                "Sistemas", 
                5, 
                "Ingenieria", 
                "202500708",
                "David", 
                "1234567", 
                "estudiantes@gmail.coom",
                "estudiante1", 
                "estudianteusuario",
                'M', 
                20, 
                213213, 
                'S'
        );
        estudiantes.agregarEstudiante(nuevoEstudiante);

        Bibliotecario nuevoBibliotecario = new Bibliotecario(
                "emple001", 
                "matutina", 
                "Secretaria",
                "Maria", 
                "12345545", 
                "maria@gmail.com",
                "maria123", 
                "bibliotecaria001",
                'F', 
                30, 
                123123, 
                'S'
        );
        bibliotecarios.agregarBibliotecarios(nuevoBibliotecario);
    }
}