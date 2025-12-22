package Controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import modelos.Libro;
import modelos.Estudiante;
import modelos.Bibliotecario;
import modelos.Prestamo;
import Repositorios.RepositorioBiblioteca;
import Repositorios.RepositorioEstudiante;
import Repositorios.RepositorioLibro;
import Repositorios.RepositorioPrestamo;

public class ControladorAdmin {
    private ControladorPrestamos controladorPrestamos;
    private ControladorPrincipal controladorPrincipal;
    private RepositorioBiblioteca bibliotecarios;
    private RepositorioEstudiante estudiantes;
    private RepositorioLibro libros;
    private RepositorioPrestamo prestamos;
//===================================CONSTRUCTOR==================================
    public ControladorAdmin(ControladorPrincipal controladorPrincipal,
                            RepositorioBiblioteca bibliotecarios,
                            RepositorioEstudiante estudiantes,
                            RepositorioLibro libros, RepositorioPrestamo prestamos) {
        this.controladorPrincipal = controladorPrincipal;
        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiantes;
        this.libros = libros;
        this.prestamos = prestamos;
        this.controladorPrestamos = new ControladorPrestamos(prestamos, libros, estudiantes);
    }

// ================================GETTERS===================================
    public RepositorioBiblioteca getRepoBibliotecarios() {
        return bibliotecarios; 
    }

    public RepositorioEstudiante getRepoEstudiantes() {
        return estudiantes; 
    }

    public RepositorioLibro getRepoLibros() {
        return libros; 
    }

    public RepositorioPrestamo getRepoPrestamos() {
        return prestamos;
    }

//================================OBTENER DATOS =============================
    public Libro[] obtenerLibros() {
        return libros.todosLosLibros();
    }

    public Estudiante[] obtenerEstudiantes() {
        return estudiantes.todoslosestudiantes();
    }

    public Bibliotecario[] obtenerBibliotecarios() {
        return bibliotecarios.todosLosBibliotecarios();
    }

    public Estudiante[] buscarEstudiantes(String texto) {
        return estudiantes.buscarEstudiantes(texto);
     }
    
    public Prestamo[] obtenerPrestamos(){
        return prestamos.todosLosPrestamos();
    }
    

//========================CARGA DE CSV===============================
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
                
                char genero;
                    String generoStr = datos[9].trim();
                    if (generoStr.isEmpty()) {
                        genero = 'N';
                    } else {
                        genero = generoStr.charAt(0);
                    }
                    
                int telefono     = Integer.parseInt(datos[10].trim());
                int edad         = Integer.parseInt(datos[11].trim());
                
                char estadoCivil;
                    String estadoStr = datos[12].trim();
                    if (estadoStr.isEmpty()) {
                        estadoCivil = 'N';
                    } else {
                        estadoCivil = estadoStr.charAt(0);
                    }
                
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
                
                char genero;
                    String generoStr = datos[9].trim();
                    if (generoStr.isEmpty()) {
                        genero = 'N';
                    } else {
                        genero = generoStr.charAt(0);
                    }
                    
                int telefono = Integer.parseInt(datos[9].trim());
                double salario = Double.parseDouble(datos[10].trim());
                
                
                char estadoCivil;
                     String estadoStr = datos[12].trim();
                     if (estadoStr.isEmpty()) {
                         estadoCivil = 'N';
                     } else {
                         estadoCivil = estadoStr.charAt(0);
                     }
                     
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

//====================== PRESTAMOS =========================== 
    public String realizarPrestamo(String carne, String isbn) {
        return controladorPrestamos.realizarPrestamo(carne, isbn);
    }

    public String realizarDevolucion(String carne, String isbn) {
        return controladorPrestamos.realizarDevolucion(carne, isbn);
    }

    public String generarReporteEstudianteConPrestamos(String carne) {
        return controladorPrestamos.generarReporteEstudianteConPrestamos(carne);
    }  

//======================CONTADORES DASHBOARD==============================
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
    
    public int contarPrestamos() {
        Prestamo[] lista = prestamos.todosLosPrestamos();
            int contador = 0;
                if (lista != null) {
            for (Prestamo p : lista) {
                if (p != null) contador++;
            }
        }
        return contador;
    }
//=================================NAVEGACION============================ 
        public void cerrarSesion() {
        controladorPrincipal.mostrarLogin();
    }
//=================================BUSQUEDAS=============================
    public Libro[] buscarLibros(String texto, String filtro) {
        return libros.buscarLibros(texto, filtro);
    } 
    
    public Libro buscarLibroPorISBN(String isbn){
        if (isbn == null) return null;
            isbn = isbn.trim();
                if (isbn.isEmpty()) return null;
                    return libros.buscarLibro(isbn);
    }
        
    public Bibliotecario buscarBibliotecarioPorID(String idEmpleado) {
        if (idEmpleado == null) return null;
            idEmpleado = idEmpleado.trim();
        if (idEmpleado.isEmpty()) return null;
            return bibliotecarios.retornarBibliotecario(idEmpleado);
}   
        
    public Estudiante buscarEstudiantePorCarne(String carne) {
        if (carne == null){
            return null;
        }
            carne = carne.trim();
                if (carne.isEmpty()) return null;
                    return estudiantes.buscarPorCarne(carne);
}
    
//===================================OPERACIONES===========================

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

//===============================-Metodos de Ordenamiento==============================
    public Libro[] ordenarLibros_ISBN_Burbuja() {
        Libro[] lista = copiarLibrosSinVacios();
            burbujaPorISBN(lista);
                return lista;
    }

    public Libro[] ordenarLibros_Titulo_Seleccion() {
        Libro[] lista = copiarLibrosSinVacios();
            seleccionPorTitulo(lista);
                return lista;
    }

    public Libro[] ordenarLibros_Autor_Insercion() {
        Libro[] lista = copiarLibrosSinVacios();
            insercionPorAutor(lista);
                return lista;
    }
   
    public Libro[] ordenarLibros_Editorial_QuickSort() {
        Libro[] lista = copiarLibrosSinVacios();
            quickSortPorEditorial(lista, 0, lista.length - 1);
                return lista;
    }

    public Libro[] ordenarLibros_Anio_MergeSort() {
        Libro[] lista = copiarLibrosSinVacios();
            mergeSortPorAnio(lista);
                return lista;
    }

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

    private void intercambiar(Libro[] lista, int i, int j) {
        Libro aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
     }

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

    private void quickSortPorEditorial(Libro[] lista, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        int p = partirPorEditorial(lista, inicio, fin);

        quickSortPorEditorial(lista, inicio, p - 1);
        quickSortPorEditorial(lista, p + 1, fin);
    }

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

    private void mergeSortPorAnio(Libro[] lista) {
        Libro[] auxiliar = new Libro[lista.length];
        mergeSortPorAnio(lista, auxiliar, 0, lista.length - 1);
    }

    private void mergeSortPorAnio(Libro[] lista, Libro[] auxiliar, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return;
        }

        int mitad = (izquierda + derecha) / 2;

        mergeSortPorAnio(lista, auxiliar, izquierda, mitad);
        mergeSortPorAnio(lista, auxiliar, mitad + 1, derecha);

        mezclarPorAnio(lista, auxiliar, izquierda, mitad, derecha);
    }

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
  
//===================================PERSISTENCIA DE ARHCIVOS ===========================
    public String guardarEstudiantesCSV(File archivo) {
       Estudiante[] lista = estudiantes.todoslosestudiantes();
           if (lista == null || lista.length == 0) {
            return "No hay estudiantes para guardar.";
           }

       try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
           pw.println("Carrera,Semestre,Facultad,Carnet,Nombre,CUI,Correo,Contrasena,Usuario,Genero,Telefono,Edad,EstadoCivil");

           for (Estudiante e : lista) {
               if (e == null) continue;
               pw.printf("%s,%d,%s,%s,%s,%s,%s,%s,%s,%c,%d,%d,%c%n",
                   e.getCarrera(),
                   e.getSemestre(),
                   e.getFacultad(),
                   e.getCarnet(),
                   e.getNombre(),
                   e.getCUI(),
                   e.getCorreo(),
                   e.getContrasena(),
                   e.getUsuario(),
                   e.getGenero(),
                   e.getTelefono(),
                   e.getEdad(),
                   e.getEstadoCivil()
               );
           }
           return "Archivo de estudiantes guardado correctamente.";
       } catch (Exception ex) {
           return "Error al guardar estudiantes: " + ex.getMessage();
       }
   }

    public String guardarLibrosCSV(File archivo) {
       Libro[] lista = libros.todosLosLibros();
           if (lista == null || lista.length == 0) {
               return "No hay libros para guardar.";
           }

       try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
           pw.println("ISBN,Titulo,Autor,Editorial,Anio,Categoria,Cantidad,Ubicacion,Descripcion");
           for (Libro l : lista) {
               if (l == null) continue;
               pw.printf("%s,%s,%s,%s,%d,%s,%d,%s,%s%n",
                   l.getISBN(),
                   l.getTitulo(),
                   l.getAutor(),
                   l.getEditorial(),
                   l.getAnioPublicacion(),
                   l.getCategoria(),
                   l.getCantidad(),
                   l.getUbicacion(),
                   l.getDescripcion()
               );
           }
           return "Archivo de libros guardado correctamente.";
       } catch (Exception ex) {
           return "Error al guardar libros: " + ex.getMessage();
       }
   }

    public String guardarBibliotecariosCSV(File archivo) {
       Bibliotecario[] lista = bibliotecarios.todosLosBibliotecarios();
       if (lista == null || lista.length == 0) {
           return "No hay bibliotecarios para guardar.";
       }

       try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
           pw.println("IDEmpleado,Turno,AreaTrabajo,Nombre,CUI,Correo,Usuario,Contrasena,Genero,Telefono,Salario,EstadoCivil");
           for (Bibliotecario b : lista) {
               if (b == null) continue;
               pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%c,%d,%.2f,%c%n",
                   b.getIDEmpleado(),
                   b.getTurno(),
                   b.getAreaTrabajo(),
                   b.getNombre(),
                   b.getCUI(),
                   b.getCorreo(),
                   b.getUsuario(),
                   b.getContrasena(),
                   b.getGenero(),
                   b.getTelefono(),
                   b.getSalario(),
                   b.getEstadoCivil()
               );
           }
           return "Archivo de bibliotecarios guardado correctamente.";
       } catch (Exception ex) {
           return "Error al guardar bibliotecarios: " + ex.getMessage();
       }
   }   
  
//====================================REPORTE HTML =======================================
    public String generarReporteHTML(String carnet, File archivo) {
        if (carnet == null || carnet.trim().isEmpty()) {
            return "Debe ingresar un carné.";
        }
        carnet = carnet.trim();

        Estudiante est = buscarEstudiantePorCarne(carnet);
        if (est == null) {
            return "No se encontró estudiante con ese carné.";
        }

        Prestamo[] activos = prestamos.prestamosActivosPorEstudiante(carnet);
        Prestamo[] historial = prestamos.historialPorEstudiante(carnet);

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println("<!DOCTYPE html>");
            pw.println("<html><head><meta charset=\"UTF-8\"><title>Reporte de Estudiante</title>");
            pw.println("<style>");
            pw.println("table { border-collapse: collapse; width: 100%; }");
            pw.println("th, td { border: 1px solid #000; padding: 4px; text-align: left; }");
            pw.println("th { background-color: #ddd; }");
            pw.println("</style>");
            pw.println("</head><body>");

            pw.println("<h1>Información del Estudiante</h1>");
            pw.println("<p><b>Carné:</b> " + est.getCarnet() + "</p>");
            pw.println("<p><b>Nombre:</b> " + est.getNombre() + "</p>");
            pw.println("<p><b>Carrera:</b> " + est.getCarrera() + "</p>");
            pw.println("<p><b>Correo:</b> " + est.getCorreo() + "</p>");
            pw.println("<p><b>Estado:</b> " + est.getEstadoCivil() + "</p>");

            int totalActivos;
            if (activos == null) {
                totalActivos = 0;
            } else {
                totalActivos = activos.length;  
            }

            int totalPrestamos;
            if (historial == null) {
                totalPrestamos = 0;
            } else {
                totalPrestamos = historial.length;
            }

            pw.println("<h2>Resumen</h2>");
            pw.println("<p><b>Préstamos activos:</b> " + totalActivos + "</p>");
            pw.println("<p><b>Total préstamos:</b> " + totalPrestamos + "</p>");

            pw.println("<h2>Préstamos activos</h2>");
            pw.println("<table>");
            pw.println("<tr><th>Libro</th><th>ISBN</th><th>Fecha préstamo</th><th>Fecha devolución</th><th>Días restantes</th></tr>");

            if (activos != null) {
                for (Prestamo p : activos) {
                    if (p == null) continue;
                    int diasRestantes = 0;
                    if (p.getFechaDevolucionEsperada() != null) {
                        diasRestantes = java.time.Period.between(
                            java.time.LocalDate.now(),
                            p.getFechaDevolucionEsperada()
                        ).getDays();
                    }
                    pw.println("<tr>"
                        + "<td>" + p.getTituloLibro() + "</td>"
                        + "<td>" + p.getIsbnLibro() + "</td>"
                        + "<td>" + p.getFechaPrestamo() + "</td>"
                        + "<td>" + p.getFechaDevolucionEsperada() + "</td>"
                        + "<td>" + diasRestantes + "</td>"
                        + "</tr>");
                }
            }
            pw.println("</table>");

            pw.println("</body></html>");
            return "Reporte HTML generado correctamente.";
        } catch (Exception e) {
            return "Error al generar el reporte HTML: " + e.getMessage();
        }
    }

}

