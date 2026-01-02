package modelos;


public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private String categoria;
    private String ubicacion;
    private String descripcion;
    private int cantidad;
    private int anioPublicacion;

    public Libro(String ISBN, String titulo, String autor, String editorial, int anioPublicacion, String categoria, int cantidad, String ubicacion, String descripcion) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public Libro() {
    }
//----------------------------------------------------------------------   
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
//----------------------------------------------------------------------   
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
//----------------------------------------------------------------------   
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
//----------------------------------------------------------------------   
    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
//----------------------------------------------------------------------   
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
//----------------------------------------------------------------------   
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
//----------------------------------------------------------------------   
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
//----------------------------------------------------------------------   
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
//----------------------------------------------------------------------   
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
//----------------------------------------------------------------------   
    @Override
    public String toString() {
        return "Libro{" + 
                "ISBN=" + ISBN + 
                ", titulo=" + titulo + 
                ", autor=" + autor + 
                ", editorial=" + editorial + 
                ", anioPublicacion=" + anioPublicacion + 
                ", categoria=" + categoria + 
                ", cantidad=" + cantidad + 
                ", ubicacion=" + ubicacion + 
                ", descripcion=" + descripcion + '}';
    }
    
    
    
}
