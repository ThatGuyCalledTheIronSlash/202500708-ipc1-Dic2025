package Controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import modelos.Libro;
import modelos.Estudiante;
import modelos.Bibliotecario;
import Repositorios.RepositorioBiblioteca;
import Repositorios.RepositorioEstudiante;
import Repositorios.RepositorioLibro;

public class ControladorAdmin {

    private ControladorPrincipal controladorPrincipal;
    private RepositorioBiblioteca bibliotecarios;
    private RepositorioEstudiante estudiantes;
    private RepositorioLibro libros;

    public ControladorAdmin(ControladorPrincipal controladorPrincipal,
                            RepositorioBiblioteca bibliotecarios,
                            RepositorioEstudiante estudiantes,
                            RepositorioLibro libros) {
        this.controladorPrincipal = controladorPrincipal;
        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiantes;
        this.libros = libros;
    }

//getters usados por VentanaAdmin y diálogos
    public RepositorioBiblioteca getRepoBibliotecarios() { return bibliotecarios; }
    public RepositorioEstudiante getRepoEstudiantes() { return estudiantes; }
    public RepositorioLibro getRepoLibros() { return libros; }

//Obtener Datos
    public Libro[] obtenerLibros() {
        return libros.todosLosLibros();
    }
//--
    public Estudiante[] obtenerEstudiantes() {
        return estudiantes.todoslosestudiantes();
    }
//--
    public Bibliotecario[] obtenerBibliotecarios() {
        return bibliotecarios.todosLosBibliotecarios();
    }
//--
    public Estudiante[] buscarEstudiantes(String texto) {
        return estudiantes.buscarEstudiantes(texto);
    }
//--   
    public String generarVistaPrevia(File archivo, int maxLineas) {
        StringBuilder previa = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null && contador < maxLineas) {
                previa.append(linea).append("\n");
                contador++;
            }
            if (contador == 0) {
                return "El archivo está vacío.";
            }
        } catch (Exception e) {
            previa.append("Error al leer archivo: ").append(e.getMessage());
        }
        return previa.toString();
    }   
// Carga de Archivos CSV
    public String cargarLibrosCSV(File archivo) {
        int exitosos = 0;
        int errores = 0;
            StringBuilder reporte = new StringBuilder();
            reporte.append("=== REPORTE DE CARGA DE LIBROS ===\n");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
                boolean primeraLinea = true;
                int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                if (linea.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] datos = linea.split(",");
                    if (datos.length < 9) {
                        reporte.append("Linea ").append(numeroLinea).append(": Datos incompletos\n");
                            errores++;
                            continue;
                    }

                    String isbn = datos[0].trim();
                    String titulo = datos[1].trim();
                    String autor = datos[2].trim();
                    String editorial = datos[3].trim();
                    int anio = Integer.parseInt(datos[4].trim());
                    String categoria = datos[5].trim();
                    int cantidad = Integer.parseInt(datos[6].trim());
                    String ubicacion = datos[7].trim();
                    String descripcion = datos[8].trim();
                    //Validacion de ISBN duplicado
                    if (libros.verificarLibro(isbn)) {
                        reporte.append("Linea ").append(numeroLinea)
                               .append(": ISBN duplicado (").append(isbn).append(")\n");
                            errores++;
                            continue;
                    }

                    Libro nuevoLibro = new Libro(
                            isbn, titulo, autor, editorial,
                            anio, categoria, cantidad, ubicacion, descripcion
                    );
                    libros.agregarLibro(nuevoLibro);
                        exitosos++;

                } catch (NumberFormatException e) {
                    reporte.append("Línea ").append(numeroLinea)
                           .append(": Error de formato numérico - ")
                           .append(e.getMessage()).append("\n");
                    errores++;
                } catch (Exception e) {
                    reporte.append("Línea ").append(numeroLinea)
                           .append(": Error inesperado - ")
                           .append(e.getMessage()).append("\n");
                    errores++;
                }
            }
        } catch (IOException e) {
            return "Error crítico al leer el archivo: " + e.getMessage();
        }

            reporte.append("\n=== RESUMEN ===\n");
            reporte.append("Libros cargados exitosamente: ").append(exitosos).append("\n");
            reporte.append("Errores encontrados: ").append(errores).append("\n");
            reporte.append("Total de líneas procesadas: ").append(exitosos + errores).append("\n");
            return reporte.toString();
    }
//--
    public String cargarEstudiantesCSV(File archivo) {
        int exitosos = 0;
        int errores = 0;
            StringBuilder reporte = new StringBuilder();
            reporte.append("=== REPORTE DE CARGA DE ESTUDIANTES ===\n");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primeraLinea = true;
            int numeroLinea = 0;

        while ((linea = br.readLine()) != null) {
            numeroLinea++;
            if (primeraLinea) {
                primeraLinea = false;
                continue;
            }
            if (linea.trim().isEmpty()) {
                continue;
            }

            try {
                String[] datos = linea.split(",");
                if (datos.length < 13) {
                    reporte.append("Linea ").append(numeroLinea)
                           .append(": Datos incompletos\n");
                    errores++;
                    continue;
                }

                String carrera   = datos[0].trim();
                int semestre     = Integer.parseInt(datos[1].trim());
                String facultad  = datos[2].trim();
                String carnet    = datos[3].trim();
                String nombre    = datos[4].trim();
                String cui       = datos[5].trim();
                String correo    = datos[6].trim();
                String contrasena= datos[7].trim();
                String usuario   = datos[8].trim();
                char genero      = datos[9].trim().isEmpty() ? 'N' : datos[9].trim().charAt(0);
                int telefono     = Integer.parseInt(datos[10].trim());
                int edad         = Integer.parseInt(datos[11].trim());
                char estadoCivil = datos[12].trim().isEmpty() ? 'N' : datos[12].trim().charAt(0);
                
                // Validación para evitar carnet duplicados
                if (estudiantes.buscarPorCarne(carnet) != null) {
                    reporte.append("Linea ").append(numeroLinea)
                           .append(": Carnet duplicado (").append(carnet).append(")\n");
                    errores++;
                    continue;
                }
                Estudiante nuevo = new Estudiante(
                    carrera, semestre, facultad, carnet,
                    nombre, cui, correo, contrasena, usuario,
                    genero, telefono, edad, estadoCivil
                );
                estudiantes.agregarEstudiante(nuevo);
                exitosos++;

                } catch (NumberFormatException e) {
                    reporte.append("Línea ").append(numeroLinea)
                           .append(": Error de formato numérico - ")
                           .append(e.getMessage()).append("\n");
                    errores++;
                } catch (Exception e) {
                    reporte.append("Línea ").append(numeroLinea)
                           .append(": Error inesperado - ")
                           .append(e.getMessage()).append("\n");
                    errores++;
                }
            }
        } catch (IOException e) {
            return "Error crítico al leer el archivo: " + e.getMessage();
    }

        reporte.append("\n=== RESUMEN ===\n");
        reporte.append("Estudiantes cargados exitosamente: ").append(exitosos).append("\n");
        reporte.append("Errores encontrados: ").append(errores).append("\n");
        reporte.append("Total de líneas procesadas: ").append(exitosos + errores).append("\n");
        return reporte.toString();
    
    }
//--
    public String cargarBibliotecariosCSV(File archivo) {
        int exitosos = 0;
        int errores = 0;
            StringBuilder reporte = new StringBuilder();
            reporte.append("=== REPORTE DE CARGA DE BIBLIOTECARIOS ===\n");
            
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primeraLinea = true;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                if (linea.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] datos = linea.split(",");
                    if (datos.length < 12) {
                        reporte.append("Linea ").append(numeroLinea)
                               .append(": Datos incompletos\n");
                        errores++;
                        continue;
                    }

                String idEmpleado = datos[0].trim();
                String turno = datos[1].trim();
                String areaTrabajo = datos[2].trim();
                String nombre = datos[3].trim();
                String cui = datos[4].trim();
                String correo = datos[5].trim();
                String usuario = datos[6].trim();
                String contrasena = datos[7].trim();
                char genero = datos[8].trim().isEmpty() ? 'N' : datos[8].trim().charAt(0);
                int telefono = Integer.parseInt(datos[9].trim());
                double salario = Double.parseDouble(datos[10].trim());
                char estadoCivil = datos[11].trim().isEmpty() ? 'N' : datos[11].trim().charAt(0);
                //Validacion para evitar duplicados
                if (bibliotecarios.retornarBibliotecario(idEmpleado) != null) {
                    reporte.append("Linea ").append(numeroLinea).append(": ID duplicado (").append(idEmpleado).append(")\n");
                        errores++;
                        continue;
                }
               
                Bibliotecario nuevo = new Bibliotecario(
                        idEmpleado, turno, areaTrabajo,
                        nombre, cui, correo, usuario, contrasena,
                        genero, telefono, estadoCivil, salario
                );
                bibliotecarios.agregarBibliotecarios(nuevo);
                exitosos++;

                } catch (NumberFormatException e) {
                    reporte.append("Línea ").append(numeroLinea)
                           .append(": Error de formato numérico - ")
                           .append(e.getMessage()).append("\n");
                    errores++;
                } catch (Exception e) {
                    reporte.append("Línea ").append(numeroLinea)
                           .append(": Error inesperado - ")
                           .append(e.getMessage()).append("\n");
                    errores++;
                }
            }
        } catch (IOException e) {
             return "Error crítico al leer el archivo: " + e.getMessage();
            }

            reporte.append("\n=== RESUMEN ===\n");
            reporte.append("Bibliotecarios cargados exitosamente: ").append(exitosos).append("\n");
            reporte.append("Errores encontrados: ").append(errores).append("\n");
            reporte.append("Total de líneas procesadas: ").append(exitosos + errores).append("\n");
            return reporte.toString();


    }
//--
    public String cargarLibrosConDialogo() {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        javax.swing.filechooser.FileNameExtensionFilter filter =
        new javax.swing.filechooser.FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

         int resultado = fileChooser.showOpenDialog(null);
            if (resultado != javax.swing.JFileChooser.APPROVE_OPTION) {
                return "Operación cancelada por el usuario.";
            }

         File archivoSeleccionado = fileChooser.getSelectedFile();
            //Vista previa + Resultado
         String preview = generarVistaPrevia(archivoSeleccionado, 15);
         String reporte = cargarLibrosCSV(archivoSeleccionado);

         return preview + "\n\n" + reporte;
    }
//--
    public String cargarEstudiantesConDialogo() {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        javax.swing.filechooser.FileNameExtensionFilter filter =
        new javax.swing.filechooser.FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(null);
            if (resultado != javax.swing.JFileChooser.APPROVE_OPTION) {
                return "Operación cancelada por el usuario.";
            }

        File archivoSeleccionado = fileChooser.getSelectedFile();

        //Vista previa + Resultado
        String preview = generarVistaPrevia(archivoSeleccionado, 15);
        String reporte = cargarEstudiantesCSV(archivoSeleccionado);

        return preview + "\n\n" + reporte;
    }
//--
    public String cargarBibliotecariosConDialogo() {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        javax.swing.filechooser.FileNameExtensionFilter filter =
        new javax.swing.filechooser.FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(null);
            if (resultado != javax.swing.JFileChooser.APPROVE_OPTION) {
                 return "Operación cancelada por el usuario.";
            }

            File archivoSeleccionado = fileChooser.getSelectedFile(); 
            //Vista previa + Resultado    
            String preview = generarVistaPrevia(archivoSeleccionado, 15);  
            String reporte = cargarBibliotecariosCSV(archivoSeleccionado);

            return preview + "\n\n" + reporte;
    }  
//Utilidades
    public Libro buscarLibroPorISBN(String isbn){
        if (isbn == null) return null;
            isbn = isbn.trim();
                if (isbn.isEmpty()) return null;
                    return libros.buscarLibro(isbn);
    }
//--
    public String eliminarLibroPorISBN(String isbn){
        
        if (isbn == null) {
            return "Operación cancelada.";
            }
                isbn = isbn.trim();
                
        if (isbn.isEmpty()) {
            return "Debe ingresar un ISBN.";
            }

        Libro libro = libros.buscarLibro(isbn);
            if (libro == null) {
                return "No se encontró un libro con ese ISBN.";
                    }
                    libros.eliminarLibro(isbn);
                        return "Libro \"" + libro.getTitulo() + "\" eliminado correctamente.";
    }
//--
    public Estudiante buscarEstudiantePorCarne(String carne) {
        if (carne == null){
            return null;
        }
            carne = carne.trim();
                if (carne.isEmpty()) return null;
                    return estudiantes.buscarPorCarne(carne);
}
//--
    public String eliminarEstudiantePorCarne(String carne) {
        if (carne == null) {
            return "Operación cancelada.";
        }
        carne = carne.trim();
        if (carne.isEmpty()) {
            return "Debe ingresar un carnet.";
        }

        Estudiante est = estudiantes.buscarPorCarne(carne);
            if (est == null) {
                return "No se encontró un estudiante con ese carnet.";
    }

            estudiantes.eliminarPorCarne(carne);
                return "Estudiante \"" + est.getNombre() + "\" eliminado correctamente.";
    }
//--
    public Bibliotecario buscarBibliotecarioPorID(String idEmpleado) {
        if (idEmpleado == null) return null;
            idEmpleado = idEmpleado.trim();
        if (idEmpleado.isEmpty()) return null;
            return bibliotecarios.retornarBibliotecario(idEmpleado);
}
//--
    public String eliminarBibliotecarioPorID(String idEmpleado) {
        if (idEmpleado == null) {
            return "Operación cancelada.";
        }
        idEmpleado = idEmpleado.trim();
        if (idEmpleado.isEmpty()) {
            return "Debe ingresar un ID de empleado.";
        }

        Bibliotecario bib = bibliotecarios.retornarBibliotecario(idEmpleado);
        if (bib == null) {
            return "No se encontró un bibliotecario con ese ID.";
        }

            bibliotecarios.eliminarBibliotecario(idEmpleado);
            return "Bibliotecario \"" + bib.getNombre() + "\" eliminado correctamente.";
        }
//--
    public void cerrarSesion() {
        controladorPrincipal.mostrarLogin();
    }
//--
    public Libro[] buscarLibros(String texto, String filtro) {
        return libros.buscarLibros(texto, filtro);
    }
//Metodos de Ordenamiento
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
//--
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
// Burbujas
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
//--
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
//--
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
//--
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
//--
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
//Contadores para el dashboard
    public int contarLibros() {
        Libro[] lista = libros.todosLosLibros();
        int contador = 0;
        if (lista != null) {
            for (Libro l : lista) {
                if (l != null) contador++;
            }
        }
        return contador;   
    }
//--
    public int contarEstudiantes() {
    Estudiante[] lista = estudiantes.todoslosestudiantes();
        int contador = 0;
        if (lista != null) {
            for (Estudiante e : lista) {
                if (e != null) contador++;
            }
        }
        return contador;
    }
//--
    public int contarBibliotecarios() {
        Bibliotecario[] lista = bibliotecarios.todosLosBibliotecarios();
            int contador = 0;
            if (lista != null) {
                for (Bibliotecario b : lista) {
                    if (b != null) contador++;
                }
            }
            return contador;
        }
}

