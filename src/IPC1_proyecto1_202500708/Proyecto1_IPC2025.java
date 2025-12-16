
package IPC1_proyecto1_202500708;

import InterfacesGraficas.VentanaLogin;
import modelos.Bibliotecario;
import modelos.Estudiante;
import ejemploestudiante.RepositorioEstudiante;
import ejemploestudiante.RepositorioBiblioteca;
import ejemploestudiante.RepositorioLibro;


public class Proyecto1_IPC2025 {
        public static RepositorioEstudiante estudiantes = new RepositorioEstudiante();
        public static RepositorioBiblioteca bibliotecarios = new RepositorioBiblioteca();
        public static RepositorioLibro libros = new RepositorioLibro();
    //----------------------------------------------------------------
    public static void main(String[] args) {
        //cargar usuarios
        cargarDatosIniciales();
        //mostrar el Login
        VentanaLogin inicio = new VentanaLogin(bibliotecarios, estudiantes,libros);
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
    }
    //----------------------------------------------------------------
     private static void cargarDatosIniciales(){   
        //Agregar Estudiante
        Estudiante nuevoEstudiante = new Estudiante("Sistemas", 5, "Ingenieria", "202500708", "David", "1234567", "estudiantes@gmail.coom", "estudiante1", "estudianteusuario", 'M', 20, 213213, 'S');
        estudiantes.agregarEstudiante(nuevoEstudiante);
       
        //Agregar bibliotecarios
        Bibliotecario nuevoBibliotecario = new Bibliotecario("emple001", "matutina", "Secretaria", "Maria", "12345545", "maria@gmail.com", "maria123", "bibliotecaria001", 'F', 30, 123123, 's');
        bibliotecarios.agregarBibliotecarios(nuevoBibliotecario);
        
    }
    
    
}