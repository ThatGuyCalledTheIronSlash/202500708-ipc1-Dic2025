package modelo.gestores;

import modelo.Producto;
import modelo.estructuras.ListaDoble;
import modelo.estructuras.NodoDoble;

public class GestorProductos {

    private ListaDoble listaProductos;

    public GestorProductos() {
        this.listaProductos = new ListaDoble();
    }

    
//================GESTIONAR PRODUCTOS(MENU)===================
    public void registrarProducto(Producto producto) {
        if (producto != null) {
            listaProductos.insertarAlFinal(producto);
        }
    }

    public Producto buscarPorCodigo(int codigo) {
        NodoDoble actual = listaProductos.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Producto) {
                Producto p = (Producto) dato;
                if (p.getCodigoProducto() == codigo) {
                    return p;
                }
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public Producto buscarPorNombre(String nombre) {
        NodoDoble actual = listaProductos.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Producto) {
                Producto p = (Producto) dato;
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    return p;
                }
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean actualizarProducto(Producto productoActualizado) {
        if (productoActualizado == null) {
            return false;
        }

            int codigo = productoActualizado.getCodigoProducto();
            Producto encontrado = buscarPorCodigo(codigo);

        if (encontrado == null) {
            return false;
        }

            encontrado.setNombre(productoActualizado.getNombre());
            encontrado.setDescripcion(productoActualizado.getDescripcion());
            encontrado.setCategoria(productoActualizado.getCategoria());
            encontrado.setPrecio(productoActualizado.getPrecio());
            encontrado.setTiempoPreparacion(productoActualizado.getTiempoPreparacion());
            encontrado.setDisponible(productoActualizado.isDisponible());

        return true;
    }

    public boolean eliminarPorCodigo(int codigo) {
        NodoDoble actual = listaProductos.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Producto) {
                Producto p = (Producto) dato;
                if (p.getCodigoProducto() == codigo) {
                    listaProductos.eliminar(p);
                    return true;
                }
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    public void listarProductos() {
        NodoDoble actual = listaProductos.getCabeza();
        int indice = 1;

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Producto) {
                Producto p = (Producto) dato;
                System.out.println(indice + ". " + p.toString());
                indice = indice + 1;
            }
            actual = actual.getSiguiente();
        }
    }

    public ListaDoble getListaProductos() {
        return listaProductos;
    }

    public int getCantidadProductos() {
        return listaProductos.getTamaño();
    }
}
