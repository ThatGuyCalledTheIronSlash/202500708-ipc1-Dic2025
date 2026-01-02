package modelo;

public class Ingrediente {

    private static int contadorCodigos = 1;
    private int codigoIngrediente;
    private String nombre;
    private double cantidadStock;
    private String unidadMedida;
    private double nivelMinimo;
    private String proveedor;

//=================CONSTRUCTOR==========================
    public Ingrediente(String nombre,
                       double cantidadStock,
                       String unidadMedida,
                       double nivelMinimo,
                       String proveedor) {

        this.codigoIngrediente = contadorCodigos;
        contadorCodigos = contadorCodigos + 1;

        this.nombre = nombre;
        this.cantidadStock = cantidadStock;
        this.unidadMedida = unidadMedida;
        this.nivelMinimo = nivelMinimo;
        this.proveedor = proveedor;
    } 
//=================Getters y Setters=====================
    public int getCodigoIngrediente() {
        return codigoIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(double cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(double nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String toString() {
        return "Ingrediente{codigo=" + codigoIngrediente + ", nombre=" + nombre + ", stock=" + cantidadStock + " " + unidadMedida + "}";
    }
}

