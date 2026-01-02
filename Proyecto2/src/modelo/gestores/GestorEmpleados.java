package modelo.gestores;

import modelo.Empleado;
import modelo.estructuras.ListaDoble;
import modelo.estructuras.NodoDoble;

public class GestorEmpleados {
    private ListaDoble listaEmpleados;

    public GestorEmpleados() {
        this.listaEmpleados = new ListaDoble();
    }

    
//====================GESTIONAR EMPLEADOS================
    public void registrarEmpleado(Empleado empleado) {
        if (empleado != null) {
            listaEmpleados.insertarAlFinal(empleado);
        }
    }

    public Empleado buscarPorId(int idEmpleado) {
        NodoDoble actual = listaEmpleados.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Empleado) {
                Empleado e = (Empleado) dato;
                if (e.getIdEmpleado() == idEmpleado) {
                    return e;
                }
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public Empleado buscarPorUsuario(String usuario) {
        NodoDoble actual = listaEmpleados.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Empleado) {
                Empleado e = (Empleado) dato;
                if (e.getUsuario().equals(usuario)) {
                    return e;
                }
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean actualizarEmpleado(Empleado empleadoActualizado) {
        if (empleadoActualizado == null) {
            return false;
        }

            int id = empleadoActualizado.getIdEmpleado();
            Empleado encontrado = buscarPorId(id);

        if (encontrado == null) {
            return false;
        }

            encontrado.setNombreCompleto(empleadoActualizado.getNombreCompleto());
            encontrado.setUsuario(empleadoActualizado.getUsuario());
            encontrado.setContrasena(empleadoActualizado.getContrasena());
            encontrado.setTelefono(empleadoActualizado.getTelefono());
            encontrado.setEmail(empleadoActualizado.getEmail());
            encontrado.setDpi(empleadoActualizado.getDpi());
            encontrado.setFechaNacimiento(empleadoActualizado.getFechaNacimiento());
            encontrado.setPuesto(empleadoActualizado.getPuesto());
            encontrado.setTurno(empleadoActualizado.getTurno());
            encontrado.setSucursalAsignada(empleadoActualizado.getSucursalAsignada());
            encontrado.setSalarioBase(empleadoActualizado.getSalarioBase());
            encontrado.setActivo(empleadoActualizado.isActivo());

        return true;
    }

    public boolean eliminarEmpleadoPorId(int idEmpleado) {
        NodoDoble actual = listaEmpleados.getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Empleado) {
                Empleado e = (Empleado) dato;
                if (e.getIdEmpleado() == idEmpleado) {
                    listaEmpleados.eliminar(e);
                    return true;
                }
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    public void listarEmpleados() {
        NodoDoble actual = listaEmpleados.getCabeza();
        int indice = 1;

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Empleado) {
                Empleado e = (Empleado) dato;
                System.out.println(indice + ". " + e.toString());
                indice = indice + 1;
            }
            actual = actual.getSiguiente();
        }
    }

    public ListaDoble getListaEmpleados() {
        return listaEmpleados;
    }

    public int getCantidadEmpleados() {
        return listaEmpleados.getTamaño();
    }
}
