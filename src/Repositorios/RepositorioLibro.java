package Repositorios;

import modelos.Libro;
   
public class RepositorioLibro {
    
    private Libro[] libros = new Libro[200];
    
    
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
//======================Utilidades========================
    public void agregarLibro(Libro libroNuevo) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                libros[i] = libroNuevo;
                break;
            }
        }
    }

    public void eliminarLibro(String ISBN) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getISBN().equals(ISBN)) {
                libros[i]= null;
                break;
            }
        }
    }
   
   public Libro buscarLibro(String ISBN) {
        if (ISBN == null) {
            return null;
        }
        return buscarLibroRecursivo(ISBN, 0);
    }

   public boolean verificarLibro(String ISBN) {
            return buscarLibro(ISBN) != null;
    } 
   
//=====================Metodos de ayuda====================
    public void mostarTodosLibros(){
        for (int i = 0; i < libros.length; i++) {
            if(libros[i]!=null){
                System.out.println(libros[i].toString());
            }
        }        
    }   
//=======================Busqueda =====================
    public Libro[] buscarLibros(String texto, String filtro){
                if (texto == null) texto = "";
    texto = texto.trim().toLowerCase();

    // Si no hay texto, se muestran todos los libros
    if (texto.isEmpty()) {
        return todosLosLibros();
    }

    if (filtro == null) {
        filtro = "titulo"; 
    }

    int conteo = contarCoincidenciasRecursivo(texto, filtro, 0);
    Libro[] resultados = new Libro[conteo];
    llenarResultadosRecursivo(texto, filtro, 0, resultados, 0);
    return resultados;
        }
    
    private int contarCoincidenciasRecursivo(String texto, String filtro, int indice) {
        if (indice >= libros.length) {
            return 0;
        }
           Libro actual = libros[indice];
                int suma;
                    if (coincideConFiltro(actual, texto, filtro)) {
                        suma = 1;
                    } else {
                        suma = 0;
                    }
                return suma + contarCoincidenciasRecursivo(texto, filtro, indice + 1);
        }
    
    private int llenarResultadosRecursivo(String texto, String filtro, int indiceArreglo, Libro[] resultados, int indiceResultado) {
        if (indiceArreglo >= libros.length || indiceResultado >= resultados.length) {
            return indiceResultado;
        }
        
        Libro actual = libros[indiceArreglo];
            if (coincideConFiltro(actual, texto, filtro)) {
                resultados[indiceResultado] = actual;
                return llenarResultadosRecursivo(texto, filtro, indiceArreglo + 1, resultados, indiceResultado + 1);
        } else {
                return llenarResultadosRecursivo(texto, filtro, indiceArreglo + 1, resultados, indiceResultado);
             }
        }

    private boolean coincideConFiltro(Libro libro, String texto, String filtro) {
        if (libro == null) return false;

            switch (filtro.toLowerCase()) {
                case "titulo":
                    return contieneSeguro(libro.getTitulo(), texto);
                case "autor":
                    return contieneSeguro(libro.getAutor(), texto);
                case "categoria":
                    return contieneSeguro(libro.getCategoria(), texto);
                case "isbn":
                    return contieneSeguro(libro.getISBN(), texto);
                case "editorial":
                    return contieneSeguro(libro.getEditorial(), texto);
                default:
                    return contieneSeguro(libro.getTitulo(), texto);
            }
        }
    
    private boolean contieneSeguro(String campo, String texto) {
        if (campo == null) return false;
            return campo.toLowerCase().contains(texto);
        }
    
    private Libro buscarLibroRecursivo(String ISBN, int indice) {
    // Se regresa valor vacio si se llega el final y no encuentra coincidencia.
    if (indice >= libros.length) {
        return null;
    }

    Libro actual = libros[indice];

    // Si hay libro en esta posición y coincide con el ISBN, se devuelve
    if (actual != null && ISBN.equals(actual.getISBN())) {
        return actual;
    }

    //buscar en la siguiente posición
    return buscarLibroRecursivo(ISBN, indice + 1);
}
//==========================Ordenamiento==================
   public void ordenarPorTitulo() {
        for (int i = 0; i < libros.length - 1; i++) {
            for (int j = 0; j < libros.length - 1 - i; j++) {
                Libro a = libros[j];
                Libro b = libros[j + 1];

                if (a == null || b == null) continue;

                String ta;
                    if (a.getTitulo() == null) {
                        ta = "";
                    } else {
                        ta = a.getTitulo();
                    }

                String tb;
                    if (b.getTitulo() == null) {
                        tb = "";
                    } else {
                        tb = b.getTitulo();
                    }


                if (ta.compareToIgnoreCase(tb) > 0) {
                    libros[j] = b;
                    libros[j + 1] = a;
                }
            }
        }
    }   
    

}


