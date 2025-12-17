
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
                "Sistemas",   //Carrera
                5,            //Semestre
                "Ingenieria", //Facultad
                "202500708",  //Carnet
                "David",      //nombre
                "1234567",    //CUI
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
                "emple001",        // IDEmpleado
                "matutina",        // turno
                "Secretaria",      // areaTrabajo
                "Maria",           // nombre
                "12345545",        // CUI (DPI)
                "maria@gmail.com", // correo
                "maria123",        // usuario
                "bibliotecaria001",// contrasena
                'F',               // genero
                123123,            // telefono
                'S',               // estadoCivil
                4500.0             // salario
        );
        bibliotecarios.agregarBibliotecarios(nuevoBibliotecario);
    }
}