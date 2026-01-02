
package modelo.estructuras;

public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;
    private int tamaño;
//=======================CONSTRUCTOR==================
    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }
//========================INSERTAR==================
    public void insertarAlInicio(Object dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
            cabeza = nuevoNodo;
        }
        tamaño = tamaño + 1;
    }

    public void insertarAlFinal(Object dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
        tamaño++;
    }

    private NodoDoble buscar(Object dato) {
        NodoDoble actual = cabeza;
            while (actual != null) {
                if (actual.getDato().equals(dato)) {
                    return actual;
                }
             actual = actual.getSiguiente();
            }
            return null;
        }

    public boolean contiene(Object dato) {
        NodoDoble nodo = buscar(dato);
            if (nodo != null) {
                return true;
            }
            return false;
        }

    public boolean eliminar(Object dato) {
        NodoDoble nodo = buscar(dato);

        if (nodo == null) {
            return false;
        }

        if (tamaño == 1) {
            cabeza = null;
            cola = null;
        } else if (nodo == cabeza) {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        } else if (nodo == cola) {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        } else {
            NodoDoble anterior = nodo.getAnterior();
            NodoDoble siguiente = nodo.getSiguiente();
                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);
            }

        tamaño--;
        return true;
    }

    public Object obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            return null;
            }

        NodoDoble actual;
        int i;

        if (indice < tamaño / 2) {
            actual = cabeza;
            i = 0;
            while (i < indice) {
                actual = actual.getSiguiente();
                i = i + 1;
            }
        } else {
            actual = cola;
            i = tamaño - 1;
            while (i > indice) {
                actual = actual.getAnterior();
                i = i - 1;
            }
        }

        if (actual != null) {
            return actual.getDato();
        }
        return null;
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

    public NodoDoble getCabeza() {
        return cabeza;
    }

    public NodoDoble getCola() {
        return cola;
    }
}
