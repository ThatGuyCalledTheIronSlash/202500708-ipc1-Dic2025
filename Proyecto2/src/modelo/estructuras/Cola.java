package modelo.estructuras;

public class Cola {

    private class Nodo {
        Object dato;
        int prioridad;
        Nodo siguiente;
//===============CONSTRUCTOR====================
        Nodo(Object dato, int prioridad) {
            this.dato = dato;
            this.prioridad = prioridad;
            this.siguiente = null;
        }
    }

    private Nodo frente;
    private Nodo finalCola;
    private int tamaño;

    public Cola() {
        this.frente = null;
        this.finalCola = null;
        this.tamaño = 0;
    }

    public void encolar(Object dato, int prioridad) {
        Nodo nuevoNodo = new Nodo(dato, prioridad);

        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else if (prioridad < frente.prioridad) {
            nuevoNodo.siguiente = frente;
            frente = nuevoNodo;
        } else if (prioridad >= finalCola.prioridad) {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            Nodo actual = frente;
            while (actual.siguiente != null &&
                   actual.siguiente.prioridad < prioridad) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }

        tamaño = tamaño + 1;
    }

    public Object desencolar() {
        if (estaVacia()) {
            return null;
        }

        Object dato = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            finalCola = null;
        }

        tamaño = tamaño - 1;
        return dato;
    }

    public Object peek() {
        if (estaVacia()) {
            return null;
        }
        return frente.dato;
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
        frente = null;
        finalCola = null;
        tamaño = 0;
    }
}
