
package ejemploestudiante;

import java.util.Scanner;

public class Login {

    private RepositorioBiblioteca bibliotecario;
    private RepositorioEstudiante estudiantes;
    private RepositorioLibro libros;
    private Scanner entrada = new Scanner(System.in);

    public Login(RepositorioBiblioteca bibliotecario, RepositorioEstudiante estudiantes, RepositorioLibro libros) {
        this.bibliotecario = bibliotecario;
        this.estudiantes = estudiantes;
        this.libros = libros;
    }

    public void iniciarsesion() {
        boolean salir = false;
        //estudiantes.mostrarEstudiante("2020");
        do {
            System.out.print("usuario: ");
            String usuario = entrada.nextLine();
            System.out.print("Contrasena: ");
            String contrasena = entrada.nextLine();

            if (usuario.equals("admin") && contrasena.equals("admin123")) {
                System.out.println("Bienvenido a Admin");
                ControladorAdmin admin = new ControladorAdmin(bibliotecario, estudiantes, libros);
                admin.menuPrincipal();
            } else if (estudiantes.encontrarEstudiante(usuario, contrasena)) {
                System.out.println("Bienvenido a Estudiantes");
                ControladorEstudiante estudiante = new ControladorEstudiante(libros);
                estudiante.mostrarLibros();
            } else if (bibliotecario.encontrarBibliotecario(usuario, contrasena)) {
                System.out.println("Bienvenido a Bibliotecario");
            } else {
                System.out.println("No se encontro usuario");
            }
        } while (!salir);

    }
}