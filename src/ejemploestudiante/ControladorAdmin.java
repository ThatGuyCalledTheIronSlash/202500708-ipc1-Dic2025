
package ejemploestudiante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelos.Libro;
import modelos.Estudiante;
import modelos.Bibliotecario;

public class ControladorAdmin {
    private RepositorioBiblioteca bibliotecarios;
    private RepositorioEstudiante estudiantes;
    private RepositorioLibro libros;

    public ControladorAdmin(RepositorioBiblioteca bibliotecarios, RepositorioEstudiante estudiantes, RepositorioLibro libros) {
        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiantes;
        this.libros = libros;
    }
//---------------------------------------- 
    public void menuPrincipal(){
        System.out.println("Dentro del menu del administrador");
        estudiantes.mostrarEstudiante("estudiante1");
        cargarLibros();

    }
//----------------------------------------     
    private int cargarLibros() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            System.out.println("Archivo elegido: " + archivoSeleccionado.getAbsolutePath());
            return leerCSVLibros(archivoSeleccionado);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
            return 0;
        }
    }
//---------------------------------------- 
    private int leerCSVLibros(File archivo) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");

                if (columnas.length < 9) {
                    continue;
                }
                if (columnas[0].equalsIgnoreCase("ISBN")) {
                    continue;
                }

                String ISBN = columnas[0];
                String titulo = columnas[1];
                String autor = columnas[2];
                String editorial = columnas[3];
                int anioPublicacion = Integer.parseInt(columnas[4]);
                String categoria = columnas[5];
                int cantidad = Integer.parseInt(columnas[6]);
                String ubicacion = columnas[7];
                String descripcion = columnas[8];

                Libro nuevoLibro = new Libro(ISBN, titulo, autor, editorial, anioPublicacion, categoria, cantidad, ubicacion, descripcion);
                libros.agregarLibro(nuevoLibro);
                contador++;
            }
            System.out.println("Se cargaron " + contador + " libros exitosamente.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato de los datos: " + e.getMessage());
        } catch (Exception e){
            
        }
        return contador;    
    }
//-------------------------------------------
    public String generarVistaPrevia(File archivo, int maxLineas) {
        StringBuilder previa = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null && contador < maxLineas) {
                previa.append(linea).append("\n");
                contador++;
            }
            if(contador == 0){
                return "El archivo está vacío.";
            }
        } catch (Exception e) {
            previa.append("Error al leer archivo: ").append(e.getMessage());
        }
        return previa.toString();
    }
//#=====================Cargas======================#
    public String cargarLibrosCSV(File archivo) {
        int exitosos = 0;
        int errores = 0;
            StringBuilder reporte = new StringBuilder();   
            reporte.append("=== REPORTE DE CARGA DE LIBROS ===");
            
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
                    
                    //tiene 9 campos
                    if (datos.length < 9) {
                        reporte.append("Linea ").append(numeroLinea).append(": Datos incompletos");
                        errores++;
                        continue;
                    }
                     //obtener datos
                    String isbn = datos[0].trim();
                    String titulo = datos[1].trim();
                    String autor = datos[2].trim();
                    String editorial = datos[3].trim();
                    int anio = Integer.parseInt(datos[4].trim());
                    String categoria = datos[5].trim();
                    int cantidad = Integer.parseInt(datos[6].trim());
                    String ubicacion = datos[7].trim();
                    String descripcion = datos[8].trim();
                    
                    // Valida que el ISBN no exista
                    if (libros.verificarLibro(isbn)) {
                        reporte.append("Linea ").append(numeroLinea).append(": ISBN duplicado (").append(isbn).append(")\n");
                        errores++;
                        continue;
                    }
                    
                    // Crea y agrega el libro
                    Libro nuevoLibro = new Libro(isbn, titulo, autor, editorial,anio, categoria, cantidad,  ubicacion, descripcion);
                        libros.agregarLibro(nuevoLibro);
                            exitosos++;
                    
                } catch (NumberFormatException e) {
                    reporte.append("Línea ").append(numeroLinea).append(": Error de formato numérico - ").append(e.getMessage()).append("\n");
                        errores++;
                } catch (Exception e) {
                    reporte.append("Línea ").append(numeroLinea).append(": Error inesperado - ").append(e.getMessage()).append("\n");
                    errores++;
                }
            }
            
        } catch (IOException e) {
                return "Error crítico al leer el archivo: " + e.getMessage();
        }
        
        // Resumen final
        reporte.append("\n=== RESUMEN ===\n");
        reporte.append("Libros cargados exitosamente: ").append(exitosos).append("\n");
        reporte.append("Errores encontrados: ").append(errores).append("\n");
        reporte.append("Total de líneas procesadas: ").append(exitosos + errores).append("\n");
        
        return reporte.toString();
    }
//---------
    public String cargarEstudiantesCSV(File archivo){
        int exitosos = 0;
        int errores = 0;
            StringBuilder reporte = new StringBuilder();   
            reporte.append("=== REPORTE DE CARGA DE ESTUDIANTES ===");
            
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
                    
                    //tiene 13 campos
                    if (datos.length < 13) {
                        reporte.append("Linea ").append(numeroLinea).append(": Datos incompletos");
                        errores++;
                        continue;
                    }
                     //obtener datos
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
                    char estadoCivil = datos[12].trim().isEmpty() ? 'N' :datos[12].trim().charAt(0);
                    
                    // Crea y agrega el libro
                    Estudiante nuevoestudiante = new Estudiante(carrera, semestre, facultad, usuario, nombre, cui, correo,
                        contrasena, carnet, genero, telefono, edad, estadoCivil);
                    
                        estudiantes.agregarEstudiante(nuevoestudiante);
                            exitosos++;
                    
                } catch (NumberFormatException e) {
                    reporte.append("Línea ").append(numeroLinea).append(": Error de formato numérico - ").append(e.getMessage()).append("\n");
                        errores++;
                } catch (Exception e) {
                    reporte.append("Línea ").append(numeroLinea).append(": Error inesperado - ").append(e.getMessage()).append("\n");
                    errores++;
                }
            }
            
        } catch (IOException e) {
                return "Error crítico al leer el archivo: " + e.getMessage();
        }
        
        // Resumen final
        reporte.append("\n=== RESUMEN ===\n");
        reporte.append("Estudiantes cargados exitosamente: ").append(exitosos).append("\n");
        reporte.append("Errores encontrados: ").append(errores).append("\n");
        reporte.append("Total de líneas procesadas: ").append(exitosos + errores).append("\n");
        
        return reporte.toString();
    }
//---------
    public String cargarBibliotecariosCSV(File archivo){
        int exitosos = 0;
        int errores = 0;
            StringBuilder reporte = new StringBuilder();   
            reporte.append("=== REPORTE DE CARGA DE BIBLIOTECARIOS ===");
            
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
                    
                    //tiene 13 campos
                    if (datos.length < 12) {
                        reporte.append("Linea ").append(numeroLinea).append(": Datos incompletos");
                        errores++;
                        continue;
                    }
                     //obtener datos
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
                    int edad = Integer.parseInt(datos[10].trim());
                    char estadoCivil = datos[11].trim().isEmpty() ? 'N' : datos[11].trim().charAt(0); 
                     
                     Bibliotecario nuevobibliotecario = new Bibliotecario(idEmpleado, turno, areaTrabajo, nombre,
                     cui, correo, usuario, contrasena, genero, telefono, edad, estadoCivil
                     );
                     
                     bibliotecarios.agregarBibliotecarios(nuevobibliotecario);
                     exitosos++;
                     
                     
                } catch (NumberFormatException e) {
                    reporte.append("Línea ").append(numeroLinea).append(": Error de formato numérico - ").append(e.getMessage()).append("\n");
                        errores++;
                } catch (Exception e) {
                    reporte.append("Línea ").append(numeroLinea).append(": Error inesperado - ").append(e.getMessage()).append("\n");
                    errores++;
                }
            }
            
        } catch (IOException e) {
                return "Error crítico al leer el archivo: " + e.getMessage();
        }
        
        // Resumen final
        reporte.append("\n=== RESUMEN ===\n");
        reporte.append("Bibliotecarios cargados exitosamente: ").append(exitosos).append("\n");
        reporte.append("Errores encontrados: ").append(errores).append("\n");
        reporte.append("Total de líneas procesadas: ").append(exitosos + errores).append("\n");
        
        return reporte.toString();
    }     
//#================= Get de Repositorios =============#
    public RepositorioBiblioteca getRepoBibliotecarios() {
        return bibliotecarios;
    }
    
    public RepositorioEstudiante getRepoEstudiantes() {
        return estudiantes;
    }
    
    public RepositorioLibro getRepoLibros() {
        return libros;
    }
    
}
