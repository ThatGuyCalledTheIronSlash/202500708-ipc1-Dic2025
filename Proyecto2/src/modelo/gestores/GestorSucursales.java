package modelo.gestores;

import modelo.Sucursal;
import modelo.estructuras.ListaSimple;
import modelo.estructuras.NodoSimple;

public class GestorSucursales {

    private ListaSimple listaSucursales;

    public GestorSucursales() {
        this.listaSucursales = new ListaSimple();
    }

    public ListaSimple getListaSucursales() {
        return listaSucursales;
    }

    public void registrarSucursal(Sucursal sucursal) {
        listaSucursales.insertarAlFinal(sucursal);
    }

    public Sucursal buscarPorId(int idBuscado) {
        NodoSimple actual = listaSucursales.getCabeza();
        while (actual != null) {
            Sucursal s = (Sucursal) actual.getDato();
            if (s.getIdSucursal() == idBuscado) {
                return s;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminarPorId(int idBuscado) {
        NodoSimple cabeza = listaSucursales.getCabeza();
        if (cabeza == null) {
            return false;
        }

        Sucursal sCabeza = (Sucursal) cabeza.getDato();
        if (sCabeza.getIdSucursal() == idBuscado) {
            listaSucursales.setCabeza(cabeza.getSiguiente());
            return true;
        }

        NodoSimple anterior = cabeza;
        NodoSimple actual = cabeza.getSiguiente();
        while (actual != null) {
            Sucursal s = (Sucursal) actual.getDato();
            if (s.getIdSucursal() == idBuscado) {
                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }
}
