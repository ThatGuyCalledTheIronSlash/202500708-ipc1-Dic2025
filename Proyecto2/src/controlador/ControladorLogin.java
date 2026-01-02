package controlador;

import modelo.Cliente;
import modelo.Empleado;
import modelo.gestores.GestorPedidos;
import modelo.gestores.GestorClientes;
import modelo.gestores.GestorEmpleados;
import modelo.gestores.GestorProductos;
import modelo.gestores.GestorInventario;
import modelo.gestores.GestorSucursales;
import controlador.ControladorAdmin;
import controlador.ControladorCajero;

public class ControladorLogin {

    private GestorEmpleados gestorEmpleados;
    private GestorClientes gestorClientes;
    private GestorProductos gestorProductos;
    private GestorInventario gestorInventario;
    private GestorSucursales gestorSucursales;
    private GestorPedidos gestorPedidos;
    private ControladorAdmin controladorAdmin;
    private ControladorCajero controladorCajero;

    public ControladorLogin(GestorEmpleados gestorEmpleados,
                            GestorClientes gestorClientes,
                            GestorProductos gestorProductos,
                            GestorInventario gestorInventario,
                            GestorSucursales gestorSucursales) {

        this.gestorEmpleados = gestorEmpleados;
        this.gestorClientes = gestorClientes;
        this.gestorProductos = gestorProductos;
        this.gestorInventario = gestorInventario;
        this.gestorSucursales = gestorSucursales;
        this.gestorPedidos = new GestorPedidos();
        
        controladorAdmin = new ControladorAdmin(
                this.gestorEmpleados,
                this.gestorClientes,
                this.gestorProductos,
                this.gestorInventario,
                this.gestorSucursales
        );
        
        controladorCajero = new ControladorCajero(
                this.gestorPedidos,
                this.gestorClientes,
                this.gestorProductos
        );

        precargarUsuariosPorDefecto();
        controladorAdmin.cargarDatosIniciales();

        
    }
       
//=====================Obtener Datos =============================   
    public GestorEmpleados getGestorEmpleados() {
        return gestorEmpleados;
    }

    public GestorClientes getGestorClientes() {
        return gestorClientes;
    }

    public GestorProductos getGestorProductos() {
        return gestorProductos;
    }
    
    public GestorInventario getGestorInventario(){
        return gestorInventario;
    }
    
    public GestorSucursales getGestorSucursales(){
        return gestorSucursales;
    }
    
    public ControladorAdmin getControladorAdmin() {
        return controladorAdmin;
    }

    public ControladorCajero getControladorCajero() {
        return controladorCajero;
    }

//=====================POR DEFECTO==================================
    private void precargarUsuariosPorDefecto() {
        // Admin por defecto (empleado tipo Gerente)
        Empleado admin = new Empleado(
                "Administrador General",
                "admin",
                "admin123",
                "00000000",
                "admin@restaurante.com",
                "0000000000000",
                "01/01/1990",
                "Gerente",
                "Matutino",
                "Sucursal Central",
                5000.0
        );
        gestorEmpleados.registrarEmpleado(admin);

        // Cajero por defecto
        Empleado cajero = new Empleado(
                "Cajero Principal",
                "cajero1",
                "caj123",
                "11111111",
                "cajero@restaurante.com",
                "1111111111111",
                "02/02/1995",
                "Cajero",
                "Matutino",
                "Sucursal Central",
                3000.0
        );
        gestorEmpleados.registrarEmpleado(cajero);

        // Cliente por defecto
        Cliente cliente = new Cliente(
                "Cliente Ejemplo",
                "Direccion de prueba",
                "cliente1",
                "cli123",
                "22222222",
                "cliente@correo.com",
                "Regular",
                0
        );
        gestorClientes.registrarCliente(cliente);
    }

    public String iniciarSesion(String usuario, String contrasena) {
        if (usuario == null || contrasena == null) {
            return null;
        }

        Empleado empleado = gestorEmpleados.buscarPorUsuario(usuario);
        if (empleado != null) {
            if (empleado.getContrasena().equals(contrasena)) {
                String puesto = empleado.getPuesto();
                if (puesto.equalsIgnoreCase("Gerente")) {
                    return "ADMIN";
                }
                if (puesto.equalsIgnoreCase("Cajero")) {
                    return "CAJERO";
                }
                return "EMPLEADO";
            } else {
                return null;
            }
        }

        Cliente cliente = buscarClientePorUsuario(usuario);
        if (cliente != null) {
            if (cliente.getContrasena().equals(contrasena)) {
                return "CLIENTE";
            } else {
                return null;
            }
        }

        return null;
    }

    private Cliente buscarClientePorUsuario(String usuario) {
        modelo.estructuras.NodoDoble actual = gestorClientes.getListaClientes().getCabeza();

        while (actual != null) {
            Object dato = actual.getDato();
            if (dato instanceof Cliente) {
                Cliente c = (Cliente) dato;
                if (c.getUsuario().equals(usuario)) {
                    return c;
                }
            }
            actual = actual.getSiguiente();
        }

        return null;
    }
    
}
