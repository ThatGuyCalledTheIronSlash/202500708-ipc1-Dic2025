
package Controladores;

import modelos.Libro;
import modelos.Estudiante;
import modelos.Prestamo;
import Repositorios.RepositorioLibro;
import Repositorios.RepositorioEstudiante;
import Repositorios.RepositorioPrestamo;
import java.time.LocalDate;


public class ControladorPrestamos {
    
    private RepositorioPrestamo prestamos;
    private RepositorioLibro repoLibros;
    private RepositorioEstudiante repoEstudiantes;
    
    public ControladorPrestamos(RepositorioPrestamo prestamos,
                                RepositorioLibro repoLibros,
                                RepositorioEstudiante repoEstudiantes) {
        this.prestamos = prestamos;
        this.repoLibros = repoLibros;
        this.repoEstudiantes = repoEstudiantes;
    }
//=============================PRESTAMOS ==================================  
 
public String realizarPrestamo(String carne, String isbn) {
        if (carne == null || carne.trim().isEmpty()) {
            return "Ingresar Carnet.";
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            return "ingresar un ISBN.";
        }
        Estudiante est = repoEstudiantes.buscarPorCarne(carne);
        if (est == null) {
            return "No se encontró estudiante.";
        }
        Libro libro = repoLibros.buscarLibro(isbn);
        if (libro == null) {
            return "No se encontró ISBN.";
        }
        if (libro.getCantidad() <= 0) {
            return "No hay ejemplares este libro.";
        }

        Prestamo[] activos = prestamos.prestamosActivosPorEstudiante(carne);
        if (activos != null && activos.length >= 3) {
            return "El estudiante ya tiene 3 préstamos activos";
        }


        String idPrestamo = "P-" + System.currentTimeMillis();
        String idBibliotecario = "BIB-1";
        String tituloLibro = libro.getTitulo();

        LocalDate hoy = LocalDate.now();
        LocalDate fechaDevolucionEsperada = hoy.plusDays(7); // plazo de 7 días

        Prestamo nuevo = new Prestamo(
                idPrestamo,
                carne,
                idBibliotecario,
                isbn,
                tituloLibro,
                hoy,
                fechaDevolucionEsperada
        );
        // Guardar en el repositorio
        prestamos.agregarPrestamo(nuevo);

        libro.setCantidad(libro.getCantidad() - 1);     // Descontar un ejemplar

        return "Préstamo registrado correctamente.";
    }
 

    public String realizarDevolucion(String carne, String isbn) {
        if (carne == null || carne.trim().isEmpty()) {
            return "Ingresar Carnet.";
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            return "Ingresar un ISBN.";
        }

    Estudiante est = repoEstudiantes.buscarPorCarne(carne);
        if (est == null) {
            return "No se encontro estudiante.";
        }

    Libro libro = repoLibros.buscarLibro(isbn);
        if (libro == null) {
            return "No se encontro ISBN.";
        }

    Prestamo prestamo = prestamos.buscarPrestamoActivo(carne, isbn);
        if (prestamo == null) {
            return "No hay un préstamo activo de ese libro para este estudiante.";
        }

    LocalDate hoy = LocalDate.now(); //Fecha de devolución
    prestamo.setFechaDevolucionReal(hoy);
    prestamo.setEstado("DEVUELTO");

    int diasRetraso = 0;
    double multa = 0;

        if (prestamo.getFechaDevolucionEsperada() != null &&
            hoy.isAfter(prestamo.getFechaDevolucionEsperada())) {

            diasRetraso = (int) java.time.temporal.ChronoUnit.DAYS.between(
                    prestamo.getFechaDevolucionEsperada(), hoy);
        
            if (diasRetraso < 0) diasRetraso = 0;
                multa = diasRetraso * 1; //1Q por día
            }

    prestamo.setDiasRetraso(diasRetraso);
    prestamo.setMultaGenerada(multa);
    prestamo.setMultaPagada(false);

    libro.setCantidad(libro.getCantidad() + 1);  // Devolver ejemplar al inventario

        if (multa > 0) {
            return "Devolución registrada. Mullta de Q " + multa ;
        } else {
            return "Devolución registrada. Sin Multa";
        }
    }
        
    public String generarReporteEstudianteConPrestamos(String carne) {
        if (carne == null || carne.trim().isEmpty()) {
            return "Debe ingresar un carné.\n";
        }

    Estudiante est = repoEstudiantes.buscarPorCarne(carne);
        if (est == null) {
            return "No se encontró estudiante con ese carné.\n";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("__________________________________________\n");
        sb.append("        INFORMACIÓN DEL ESTUDIANTE       \n");
        sb.append("__________________________________________\n");
        sb.append("Carné:   ").append(est.getCarnet()).append("\n");
        sb.append("Nombre:  ").append(est.getNombre()).append("\n");
        sb.append("Carrera: ").append(est.getCarrera()).append("\n");
        sb.append("Correo:  ").append(est.getCorreo()).append("\n");
        sb.append("Estado:  ").append(est.getEstadoCivil()).append("\n\n");

        Prestamo[] activos = prestamos.prestamosActivosPorEstudiante(carne);
        Prestamo[] historial = prestamos.historialPorEstudiante(carne);

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

        sb.append("Préstamos Activos:   ").append(totalActivos).append("\n");
        sb.append("Total Préstamos:     ").append(totalPrestamos).append("\n");
        sb.append("Multas Pendientes:   Q 0.00\n\n");

        sb.append("PRÉSTAMOS ACTIVOS:\n");
        sb.append("__________________________________________\n");

        if (totalActivos == 0) {
            sb.append("No tiene préstamos activos.\n");
        } else {
            for (Prestamo p : activos) {
                if (p == null) continue;
                sb.append("Libro:            ").append(p.getTituloLibro()).append("\n");
                sb.append("ISBN:             ").append(p.getIsbnLibro()).append("\n");
                sb.append("Fecha Préstamo:   ").append(p.getFechaPrestamo()).append("\n");
                sb.append("Fecha Devolución: ").append(p.getFechaDevolucionEsperada()).append("\n");
                sb.append("Días Restantes:   ").append(
                    java.time.Period.between(java.time.LocalDate.now(),p.getFechaDevolucionEsperada()).getDays()
                ).append("\n");
                sb.append("__________________________________________\n");
                }
            }
        return sb.toString();
    }        
        
        
        
        
 }
















    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
