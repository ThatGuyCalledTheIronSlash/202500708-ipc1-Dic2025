
package modelo.estructuras;

public class NodoSimple {
    private Object dato;
    private NodoSimple siguiente;
//=====================CONSTRUCTOR=====================
    public NodoSimple(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }
//=========================Getters y Setters ==================
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
//---
    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }
//---
}