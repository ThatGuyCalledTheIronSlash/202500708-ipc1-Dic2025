package modelo.estructuras;

public class ListaSimple {

    private NodoSimple cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    public NodoSimple getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoSimple cabeza) {
        this.cabeza = cabeza;
    }

    // Insertar al final
    public void insertarAlFinal(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        NodoSimple actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }
    
    public void limpiar() {
        cabeza = null;
    }
}
