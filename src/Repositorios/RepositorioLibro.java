package Repositorios;

import modelos.Libro;
   
public class RepositorioLibro {
    
    private Libro[] libros = new Libro[200];
    
//---------------------------------------------
    public void agregarLibro(Libro libroNuevo) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                libros[i] = libroNuevo;
                break;
            }
        }
    }
//---------------------------------------------
    public void eliminarLibro(String ISBN) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getISBN().equals(ISBN)) {
                libros[i]= null;
                break;
            }
        }
    }
//---------------------------------------------    
   public Libro buscarLibro(String ISBN) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getISBN().equals(ISBN)) {
                return libros[i];
            }
        }
        return null;
    }
//---------------------------------------------
    public boolean verificarLibro(String ISBN) {
            return buscarLibro(ISBN) != null;
    } 
//---------------------------------------------    
    public void mostarTodosLibros(){
        for (int i = 0; i < libros.length; i++) {
            if(libros[i]!=null){
                System.out.println(libros[i].toString());
            }
        }        
    }
//---------------------------------------------
    public Libro[] todosLosLibros() {
        int contador = 0;
        for (Libro libro : libros) {
            if (libro != null) contador++;
        }
        Libro[] copia = new Libro[contador];
        int idx = 0;
        for (Libro libro : libros) {
            if (libro != null) {
                copia[idx++] = libro;
            }
        }
        return copia;
    }
//---------------------------------------------
    public void ordenarPorTitulo() {
    for (int i = 0; i < libros.length - 1; i++) {
        for (int j = 0; j < libros.length - 1 - i; j++) {
            Libro a = libros[j];
            Libro b = libros[j + 1];

            if (a == null || b == null) continue;

            String ta = a.getTitulo() == null ? "" : a.getTitulo();
            String tb = b.getTitulo() == null ? "" : b.getTitulo();

            if (ta.compareToIgnoreCase(tb) > 0) {
                libros[j] = b;
                libros[j + 1] = a;
            }
        }
    }
}
    
    
}

