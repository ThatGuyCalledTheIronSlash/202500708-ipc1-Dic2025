
package modelo.gestores;

import modelo.Cliente;
import modelo.estructuras.ListaDoble;
import modelo.estructuras.NodoDoble;

public class GestorClientes {
    
    private ListaDoble listaClientes;

    public GestorClientes() {
        this.listaClientes = new ListaDoble();
    }

 //===============GESTIONAR CLIENTES ========================   
    public void registrarCliente(Cliente cliente) {
        if (cliente != null) {
            listaClientes.insertarAlFinal(cliente);
        }
    }

    public Cliente buscarPorId(int idCliente) {
        NodoDoble actual = listaClientes.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Cliente) {
                Cliente c = (Cliente) dato;
                if (c.getIdCliente() == idCliente) {
                    return c;
                }
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public Cliente buscarPorTelefono(String telefono) {
        NodoDoble actual = listaClientes.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Cliente) {
                Cliente c = (Cliente) dato;
                if (c.getTelefono().equals(telefono)) {
                    return c;
                }
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean actualizarCliente(Cliente clienteActualizado) {
        if (clienteActualizado == null) {
            return false;
        }

            int id = clienteActualizado.getIdCliente();
            Cliente encontrado = buscarPorId(id);

        if (encontrado == null) {
            return false;
        }

            encontrado.setNombreCompleto(clienteActualizado.getNombreCompleto());
            encontrado.setDireccionEntrega(clienteActualizado.getDireccionEntrega());
            encontrado.setUsuario(clienteActualizado.getUsuario());
            encontrado.setContrasena(clienteActualizado.getContrasena());
            encontrado.setTelefono(clienteActualizado.getTelefono());
            encontrado.setEmail(clienteActualizado.getEmail());
            encontrado.setNivel(clienteActualizado.getNivel());
            encontrado.setPuntosAcumulados(clienteActualizado.getPuntosAcumulados());

             return true;
        }

    public boolean eliminarClientePorId(int idCliente) {
        NodoDoble actual = listaClientes.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Cliente) {
                Cliente c = (Cliente) dato;
                if (c.getIdCliente() == idCliente) {
                    listaClientes.eliminar(c);
                    return true;
                }
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void listarClientes() {
        NodoDoble actual = listaClientes.getCabeza();
            int indice = 1;

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Cliente) {
                Cliente c = (Cliente) dato;
                System.out.println(indice + ". " + c.toString());
                indice = indice + 1;
            }
            actual = actual.getSiguiente();
        }
    }

    public ListaDoble getListaClientes() {
        return listaClientes;
    }

    public int getCantidadClientes() {
        return listaClientes.getTamaño();
    }
}
