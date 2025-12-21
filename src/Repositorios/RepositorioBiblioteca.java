
package Repositorios;
 import modelos.Bibliotecario;

public class RepositorioBiblioteca {
    private Bibliotecario[] bibliotecarios = new Bibliotecario[100];
    
//================================OPERACIONES=========================== 
    public void agregarBibliotecarios(Bibliotecario nuevoBibliotecario) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] == null) {
                bibliotecarios[i] = nuevoBibliotecario;
                break;
            }
        }
    }
    
    public void eliminarBibliotecario(String IDEmpleado) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null &&
                bibliotecarios[i].getIDEmpleado().equals(IDEmpleado)) {
                bibliotecarios[i] = null;
                break;
            }
        }
    }

    public void mostrarBibliotecario(String IDEmpleado) {
        Bibliotecario b = retornarBibliotecario(IDEmpleado);
        if (b != null) {
            System.out.println(b.toString());
            }
        }
   
    public Bibliotecario retornarBibliotecario(String IDEmpleado) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null && bibliotecarios[i].getIDEmpleado().equals(IDEmpleado)) {
                return bibliotecarios[i];
            }
        }
        return null;
    }

// ================================= UTILIDADES ==========================
    public Bibliotecario[] todosLosBibliotecarios(){
        int contador = 0;
            for (Bibliotecario b : bibliotecarios) {
                if (b != null) contador++;
            }
                Bibliotecario[] copia = new Bibliotecario[contador];
                int idx = 0;
                for (Bibliotecario b : bibliotecarios) {
                    if (b != null) {
                        copia[idx++] = b;
                    }
            }
        return copia;
    }
    
     public String generarNuevoID(){
        int max = 0;
        for (Bibliotecario b :todosLosBibliotecarios()) {
            if (b != null) {
                try {
                    int valor = Integer.parseInt(b.getIDEmpleado());
                    if (valor > max) max = valor;
                    } catch (NumberFormatException e) {}
                }
            }
            int siguiente = max + 1;
        return String.format("%04d", siguiente);
    }
     
    public Bibliotecario buscarPorCredenciales(String usuario, String contrasena) {
        for (Bibliotecario b : bibliotecarios) {
            if (b != null &&
                b.getUsuario().equals(usuario) &&
                b.getContrasena().equals(contrasena)) {
                return b;
            }
        }
        return null;
    } //para login
}