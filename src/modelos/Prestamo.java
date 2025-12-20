
package modelos;

import java.time.LocalDate;

public class Prestamo {

    private String idPrestamo;
    private String carnetEstudiante;
    private String idBibliotecario;
    private String isbnLibro;
    private String tituloLibro;
    
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionEsperada;
    private LocalDate fechaDevolucionReal;
    
    private int diasRetraso;
    private double multaGenerada; 
    private boolean multaPagada;
    
    private String estado;
    private String estadoLibroAlDevolver;
    
//Constructor   
     public Prestamo(String idPrestamo,String carnetEstudiante,String idBibliotecario,
        String isbnLibro,String tituloLibro, LocalDate fechaPrestamo,
        LocalDate fechaDevolucionEsperada){
        
            this.idPrestamo = idPrestamo;
            this.carnetEstudiante = carnetEstudiante;
            this.idBibliotecario = idBibliotecario;
            this.isbnLibro = isbnLibro;
            this.tituloLibro = tituloLibro;
            this.fechaPrestamo = fechaPrestamo;
            this.fechaDevolucionEsperada = fechaDevolucionEsperada;
            this.fechaDevolucionReal = null;
            this.diasRetraso = 0;
            this.multaGenerada = 0;
            this.multaPagada = false;
            this.estado = "ACTIVO";
            this.estadoLibroAlDevolver = null;
     }
     
//Getters y Setters
    public String getIdPrestamo() {
        return idPrestamo;
   }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
//-----------------------------------------------
    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(String carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }
//------------------------------------------------
    public String getIdBibliotecario() {
        return idBibliotecario;
    }

    public void setIdBibliotecario(String idBibliotecario) {
        this.idBibliotecario = idBibliotecario;
    }
//--------------------------------------------------
    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }
//-----------------------------------------------------
    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }
//-----------------------------------------------------
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
//-----------------------------------------------------
    public LocalDate getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public void setFechaDevolucionEsperada(LocalDate fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }
//-----------------------------------------------------
    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(LocalDate fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }
//-----------------------------------------------------
    public int getDiasRetraso() {
        return diasRetraso;
    }

    public void setDiasRetraso(int diasRetraso) {
        this.diasRetraso = diasRetraso;
    }
//-----------------------------------------------------
    public double getMultaGenerada() {
        return multaGenerada;
    }

    public void setMultaGenerada(double multaGenerada) {
        this.multaGenerada = multaGenerada;
    }
//-----------------------------------------------------
    public boolean isMultaPagada() {
        return multaPagada;
    }

    public void setMultaPagada(boolean multaPagada) {
        this.multaPagada = multaPagada;
    }
//-----------------------------------------------------
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
//-----------------------------------------------------
    public String getEstadoLibroAlDevolver() {
        return estadoLibroAlDevolver;
    }

    public void setEstadoLibroAlDevolver(String estadoLibroAlDevolver) {
        this.estadoLibroAlDevolver = estadoLibroAlDevolver;
    }        
//-----------------------------------------------------    
}
