
package ejemploestudiante;
 import modelos.Bibliotecario;

public class RepositorioBiblioteca {
    private Bibliotecario[] bibliotecarios = new Bibliotecario[100];
    
//----------------------------------------------   
    public void agregarBibliotecarios(Bibliotecario nuevoBibliotecario) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] == null) {
                bibliotecarios[i] = nuevoBibliotecario;
                break;
            }
        }
    }
//----------------------------------------------   
    public void eliminarBibliotecario(String IDEmpleado) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null && bibliotecarios[i].getIDEmpleado().equals(IDEmpleado)) {
                bibliotecarios[i] = null;
            }
        }
    }

//----------------------------------------------   
    public void mostrarBibliotecario(String IDEmpleado) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null && bibliotecarios[i].getIDEmpleado().equals(IDEmpleado)) {
                System.out.println(bibliotecarios[i].toString());
            }
        }
    }
//----------------------------------------------   
    public Bibliotecario retornarBibliotecario(String IDEmpleado) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null && bibliotecarios[i].getIDEmpleado().equals(IDEmpleado)) {
                return bibliotecarios[i];
            }
        }
        return null;
    }
//----------------------------------------------   
    public boolean encontrarBibliotecario(String IDEmpleado, String contrasena){
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null && bibliotecarios[i].getIDEmpleado().equals(IDEmpleado) &&
                    bibliotecarios[i].getcontrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;        
    }
//---------------------------------------------- 
 public Bibliotecario[] todosLosBibliotecarios(){
        return bibliotecarios;
 }
}