
package modelo.estructuras;

public class ListaCircular {
    private NodoSimple cabeza;
    private int tamaño;
//===============CONSTRUCTOR====================
    public ListaCircular() {
        this.cabeza = null;
        this.tamaño = 0;
    }
//=================INSERTAR====================
    public void insertar(Object dato) {
        NodoSimple nuevoNodo = new NodoSimple(dato);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            nuevoNodo.setSiguiente(cabeza);
        } else {
            NodoSimple actual = cabeza;
            while (actual.getSiguiente() != cabeza) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(cabeza);
            actual.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }

    public boolean eliminar(Object dato) {
        if (estaVacia()) {
            return false;
        }

        if (cabeza.getDato().equals(dato)) {
            if (tamaño == 1) {
                cabeza = null;
            } else {
                NodoSimple actual = cabeza;
                while (actual.getSiguiente() != cabeza) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(cabeza.getSiguiente());
                cabeza = cabeza.getSiguiente();
            }
            tamaño = tamaño - 1;
            return true;
        }

        NodoSimple actual2 = cabeza;
        NodoSimple anterior = null;

        do {
            anterior = actual2;
            actual2 = actual2.getSiguiente();
        } while (!actual2.getDato().equals(dato) && actual2 != cabeza);

        if (actual2.getDato().equals(dato)) {
            anterior.setSiguiente(actual2.getSiguiente());
            tamaño = tamaño - 1;
            return true;
        }

        return false;
    }

    public Object obtener(int indice) {
        if (estaVacia() || indice < 0 || indice >= tamaño) {
            return null;
        }

        NodoSimple actual = cabeza;
        int i = 0;
        while (i < indice) {
            actual = actual.getSiguiente();
            i++;
        }

        return actual.getDato();
    }

    public void rotar() {
        if (!estaVacia() && tamaño > 1) {
            cabeza = cabeza.getSiguiente();
        }
    }

    public Object obtenerCabeza() {
        if (estaVacia()) {
            return null;
        }
        return cabeza.getDato();
    }

    public boolean estaVacia() {
        if (tamaño == 0) {
            return true;
        }
        return false;
    }

    public int getTamaño() {
        return tamaño;
    }
}

