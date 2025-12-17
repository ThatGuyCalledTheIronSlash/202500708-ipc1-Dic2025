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

    // ==== getters usados por VentanaAdmin y diálogos ====
    public RepositorioBiblioteca getRepoBibliotecarios() { return bibliotecarios; }
    public RepositorioEstudiante getRepoEstudiantes() { return estudiantes; }
    public RepositorioLibro getRepoLibros() { return libros; }

    // ==== utilidades ====
//---------------------------------------------------------------
    public Libro[] obtenerLibros() {
        return libros.todosLosLibros();
    }
//------------------------------------------------------------------
    public Estudiante[] obtenerEstudiantes() {
        return estudiantes.todoslosestudiantes();
    }
//-----------------------------------------------------------------
    public Bibliotecario[] obtenerBibliotecarios() {
        return bibliotecarios.todosLosBibliotecarios();
    }
//----------------------------------------------------------------    
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
//-----------------------------------------------------------------
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
                        reporte.append("Linea ").append(numeroLinea)
                               .append(": Datos incompletos\n");
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
//------------------------------------------------------------------
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

                String carrera = datos[0].trim();
                int semestre = Integer.parseInt(datos[1].trim());
                String facultad = datos[2].trim();
                String usuario = datos[3].trim();
                String nombre = datos[4].trim();
                String cui = datos[5].trim();
                String correo = datos[6].trim();
                String contrasena = datos[7].trim();
                String carnet = datos[8].trim();
                char genero = datos[9].trim().isEmpty() ? 'N' : datos[9].trim().charAt(0);
                int telefono = Integer.parseInt(datos[10].trim());
                int edad = Integer.parseInt(datos[11].trim());
                char estadoCivil = datos[12].trim().isEmpty() ? 'N' : datos[12].trim().charAt(0);

                Estudiante nuevo = new Estudiante(
                        carrera, semestre, facultad, usuario, nombre,
                        cui, correo, contrasena, carnet, genero,
                        telefono, edad, estadoCivil
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
//-------------------------------------------------------------------
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
//---------------------------------------------------------------------
    public Libro buscarLibroPorISBN(String isbn){
        if (isbn == null) return null;
            isbn = isbn.trim();
            if (isbn.isEmpty()) return null;
            return libros.buscarLibro(isbn);
    }
//-----------------------------------------------------------------
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
//-----------------------------------------------------------------
    public Estudiante buscarEstudiantePorCarne(String carne) {
    if (carne == null) return null;
    carne = carne.trim();
    if (carne.isEmpty()) return null;
    return estudiantes.buscarPorCarne(carne);
}
//-----------------------------------------------------------------
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
//-----------------------------------------------------------------
    public Bibliotecario buscarBibliotecarioPorID(String idEmpleado) {
    if (idEmpleado == null) return null;
    idEmpleado = idEmpleado.trim();
    if (idEmpleado.isEmpty()) return null;
    return bibliotecarios.retornarBibliotecario(idEmpleado);
}
//-----------------------------------------------------------------
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
    
}