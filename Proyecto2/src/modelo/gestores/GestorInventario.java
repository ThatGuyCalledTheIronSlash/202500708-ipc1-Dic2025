package modelo.gestores;

import modelo.Ingrediente;
import modelo.estructuras.ListaDoble;
import modelo.estructuras.NodoDoble;

public class GestorInventario {
    
    private ListaDoble listaIngredientes;

    public GestorInventario() {
        this.listaIngredientes = new ListaDoble();
    }

//================GESTIONAR INVENTARIO==================
    public void registrarIngrediente(Ingrediente ingrediente) {
        if (ingrediente != null) {
            listaIngredientes.insertarAlFinal(ingrediente);
        }
    }

    public Ingrediente buscarPorCodigo(int codigo) {
        NodoDoble actual = listaIngredientes.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Ingrediente) {
                Ingrediente ing = (Ingrediente) dato;
                if (ing.getCodigoIngrediente() == codigo) {
                    return ing;
                }
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean eliminarPorCodigo(int codigo) {
        NodoDoble actual = listaIngredientes.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Ingrediente) {
                Ingrediente ing = (Ingrediente) dato;
                if (ing.getCodigoIngrediente() == codigo) {
                    listaIngredientes.eliminar(ing);
                    return true;
                }
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    public ListaDoble getListaIngredientes() {
        return listaIngredientes;
    }

    public int getCantidadIngredientes() {
        return listaIngredientes.getTamaño();
    }
}
