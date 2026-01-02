
package modelo.estructuras;

public class Pila {
    private NodoSimple tope;
    private int tamaño;
//=========================CONSTRUCTOR====================
    public Pila() {
        this.tope = null;
        this.tamaño = 0;
    }
//=========================APILAR================
    public void apilar(Object dato) {
        NodoSimple nuevoNodo = new NodoSimple(dato);

        if (estaVacia()) {
            tope = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(tope);
            tope = nuevoNodo;
        }

        tamaño++;
    }

    public Object desapilar() {
        if (estaVacia()) {
            return null;
        }

        Object dato = tope.getDato();
        tope = tope.getSiguiente();
        tamaño--;

        return dato;
    }

    public Object verTope() {
        if (estaVacia()) {
            return null;
        }
        return tope.getDato();
    }

    public boolean contiene(Object dato) {
        NodoSimple actual = tope;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
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

    public void vaciar() {
        tope = null;
        tamaño = 0;
    }
}

