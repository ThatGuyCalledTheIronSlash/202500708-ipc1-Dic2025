package modelo;

public class Producto {

    private static int contadorCodigos = 1;
    private int codigoProducto;
    private String nombre;
    private String descripcion;
    private String categoria;    //De comida :P
    private double precio;
    private int tiempoPreparacion; //mins
    private boolean disponible;

//=================CONSTRUCTOR==========================
    public Producto(String nombre,String descripcion,String categoria,double precio, int tiempoPreparacion,
        boolean disponible) {

        this.codigoProducto = contadorCodigos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.disponible = disponible;
        
        contadorCodigos = contadorCodigos + 1;
    }
//=================Getters y Setters=====================
    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String toString() {
        return "Producto{codigo=" + codigoProducto +", nombre=" + nombre +", precio=" + precio + "}";
    }
}
