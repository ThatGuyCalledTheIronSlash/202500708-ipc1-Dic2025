package Repositorios;

    import modelos.Prestamo;

public class RepositorioPrestamo {
   private Prestamo[] prestamos;
    private int contador;

    public RepositorioPrestamo(int capacidadInicial) {
        this.prestamos = new Prestamo[capacidadInicial];
        this.contador = 0;
    }

//===================================Utilidades====================================
    public void agregarPrestamo(Prestamo p) {
        if (p == null) {
            return;
        }
        if (contador >= prestamos.length) {
            return;
        }
        prestamos[contador] = p;
        contador++;
    }

    public Prestamo[] todosLosPrestamos() {
        int contador = 0;
        for (Prestamo prestamo :prestamos){
            if(prestamo != null) contador++;
        }
        Prestamo[] copia = new Prestamo[contador];
         int idx = 0;
         for (Prestamo prestamo :prestamos){
             if(prestamo != null){
                 copia[idx++] = prestamo;
             }
         }
  
        return copia;
    }

    public Prestamo[] prestamosActivosPorEstudiante(String carnet) {
        if (carnet == null) return null;
            carnet = carnet.trim();
        if (carnet.isEmpty()) return null;
        
        int c = 0;
            for (int i = 0; i < contador; i++) {
                Prestamo p = prestamos[i];
                if (p != null
                    && carnet.equals(p.getCarnetEstudiante())
                    && "ACTIVO".equals(p.getEstado())) {
                    c++;
                }
            }

        Prestamo[] resultado = new Prestamo[c];
            int idx = 0;
            for (int i = 0; i < contador; i++) {
                Prestamo p = prestamos[i];
                if (p != null
                    && carnet.equals(p.getCarnetEstudiante())
                    && "ACTIVO".equals(p.getEstado())) {
                    resultado[idx++] = p;
                }
            }
        return resultado;
    }

    public Prestamo[] historialPorEstudiante(String carnet) {
        if (carnet == null) return null;
            carnet = carnet.trim();
        if (carnet.isEmpty()) return null;

        int c = 0;
            for (int i = 0; i < contador; i++) {
                Prestamo p = prestamos[i];
                if (p != null && carnet.equals(p.getCarnetEstudiante())) {
                    c++;
                }
            }

        Prestamo[] resultado = new Prestamo[c];
        int idx = 0;
            for (int i = 0; i < contador; i++) {
                Prestamo p = prestamos[i];
                if (p != null && carnet.equals(p.getCarnetEstudiante())) {
                    resultado[idx++] = p;
                }
            }
        return resultado;
    }

    public Prestamo buscarPrestamoActivo(String carnet, String isbn) {
        if (carnet == null || isbn == null) return null;
            carnet = carnet.trim();
            isbn = isbn.trim();
        if (carnet.isEmpty() || isbn.isEmpty()) return null;

        for (int i = 0; i < contador; i++) {
            Prestamo p = prestamos[i];
            if (p != null
                && carnet.equals(p.getCarnetEstudiante())
                && isbn.equals(p.getIsbnLibro())
                && "ACTIVO".equals(p.getEstado())) {
                return p;
            }
        }
        return null;
    }
}

