
package Controladores;

import modelos.Estudiante;
import modelos.Libro;
import Repositorios.RepositorioLibro;

public class ControladorEstudiante {
    
    private ControladorPrincipal controladorPrincipal;
    private RepositorioLibro libros;
    private Estudiante estudianteActual;
    
 //-- 
    public ControladorEstudiante(ControladorPrincipal controladorPrincipal,
        RepositorioLibro libros){
            this.controladorPrincipal = controladorPrincipal;
            this.libros = libros;
    }
//--   
    public Libro[] obtenerCatalogoLibros(){
        return libros.todosLosLibros();
    }
//--       
    public void CerrarSesion(){
         controladorPrincipal.mostrarLogin();
    }
//--
    public Libro[] buscarLibros(String texto, String filtro) {
        return libros.buscarLibros(texto, filtro);
    }
//--
    public void setEstudianteActual(modelos.Estudiante estudiante) {
        this.estudianteActual = estudiante;
    }
//--
    public modelos.Estudiante getEstudianteActual() {
        return estudianteActual;
    }
// METODOS DE ORDENAMIENTO
    public Libro[] ordenarLibros_ISBN_Burbuja() {
        Libro[] lista = copiarLibrosSinVacios();
        burbujaPorISBN(lista);
        return lista;
    }
//--
    public Libro[] ordenarLibros_Titulo_Seleccion() {
        Libro[] lista = copiarLibrosSinVacios();
        seleccionPorTitulo(lista);
        return lista;
    }
//--
    public Libro[] ordenarLibros_Autor_Insercion() {
        Libro[] lista = copiarLibrosSinVacios();
        insercionPorAutor(lista);
        return lista;
    }
//--
    public Libro[] ordenarLibros_Editorial_QuickSort() {
        Libro[] lista = copiarLibrosSinVacios();
        quickSortPorEditorial(lista, 0, lista.length - 1);
        return lista;
    }
//--
    public Libro[] ordenarLibros_Anio_MergeSort() {
        Libro[] lista = copiarLibrosSinVacios();
        mergeSortPorAnio(lista);
        return lista;
    }
// ---------- copiar arreglo sin null ----------
    private Libro[] copiarLibrosSinVacios() {
        Libro[] todos = libros.todosLosLibros(); 
        int cantidad = 0;

        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                cantidad++;
            }
        }

        Libro[] copia = new Libro[cantidad];
        int pos = 0;

        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                copia[pos] = todos[i];
                pos++;
            }
        }

        return copia;
    }
//--
    private void intercambiar(Libro[] lista, int i, int j) {
        Libro aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

//  BURBUJA POR ISBN
    private void burbujaPorISBN(Libro[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            boolean huboCambio = false;

            for (int j = 0; j < lista.length - 1 - i; j++) {
                String isbn1 = lista[j].getISBN();
                String isbn2 = lista[j + 1].getISBN();

                if (isbn1.compareToIgnoreCase(isbn2) > 0) {
                    intercambiar(lista, j, j + 1);
                    huboCambio = true;
                }
            }

            if (!huboCambio) {
                break;
            }
        }
    }

//  SELECCIÓN POR TÍTULO 
    private void seleccionPorTitulo(Libro[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            int posMenor = i;

            for (int j = i + 1; j < lista.length; j++) {
                String t1 = lista[j].getTitulo();
                String t2 = lista[posMenor].getTitulo();

                if (t1.compareToIgnoreCase(t2) < 0) {
                    posMenor = j;
                }
            }

            if (posMenor != i) {
                intercambiar(lista, i, posMenor);
            }
        }
    }

//  INSERCIÓN POR AUTOR 
    private void insercionPorAutor(Libro[] lista) {
        for (int i = 1; i < lista.length; i++) {
            Libro actual = lista[i];
            int j = i - 1;

            while (j >= 0 && lista[j].getAutor().compareToIgnoreCase(actual.getAutor()) > 0) {
                lista[j + 1] = lista[j];
                j--;
            }

            lista[j + 1] = actual;
        }
    }

// QUICKSORT POR EDITORIAL 
    private void quickSortPorEditorial(Libro[] lista, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        int p = partirPorEditorial(lista, inicio, fin);

        quickSortPorEditorial(lista, inicio, p - 1);
        quickSortPorEditorial(lista, p + 1, fin);
    }
//--
    private int partirPorEditorial(Libro[] lista, int inicio, int fin) {
        Libro pivote = lista[fin];
        String editorialPivote = pivote.getEditorial();

        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            String editorialActual = lista[j].getEditorial();

            if (editorialActual.compareToIgnoreCase(editorialPivote) <= 0) {
                i++;
                intercambiar(lista, i, j);
            }
        }

        intercambiar(lista, i + 1, fin);
        return i + 1;
    }

// MERGESORT POR AÑO
    private void mergeSortPorAnio(Libro[] lista) {
        Libro[] auxiliar = new Libro[lista.length];
        mergeSortPorAnio(lista, auxiliar, 0, lista.length - 1);
    }
//--
    private void mergeSortPorAnio(Libro[] lista, Libro[] auxiliar, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return;
        }

        int mitad = (izquierda + derecha) / 2;

        mergeSortPorAnio(lista, auxiliar, izquierda, mitad);
        mergeSortPorAnio(lista, auxiliar, mitad + 1, derecha);

        mezclarPorAnio(lista, auxiliar, izquierda, mitad, derecha);
    }
//--
    private void mezclarPorAnio(Libro[] lista, Libro[] auxiliar, int izquierda, int mitad, int derecha) {
        int i = izquierda;
        int j = mitad + 1;
        int k = izquierda;

        while (i <= mitad && j <= derecha) {
            int anio1 = lista[i].getAnioPublicacion();
            int anio2 = lista[j].getAnioPublicacion();

            if (anio1 <= anio2) {
                auxiliar[k] = lista[i];
                i++;
            } else {
                auxiliar[k] = lista[j];
                j++;
            }
            k++;
        }

        while (i <= mitad) {
            auxiliar[k] = lista[i];
            i++;
            k++;
        }

        while (j <= derecha) {
            auxiliar[k] = lista[j];
            j++;
            k++;
        }

        for (int x = izquierda; x <= derecha; x++) {
            lista[x] = auxiliar[x];
        }
    }
}
