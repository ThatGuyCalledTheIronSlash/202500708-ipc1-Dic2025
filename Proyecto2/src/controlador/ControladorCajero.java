package controlador;

import modelo.Pedido;
import modelo.Cliente;
import modelo.gestores.GestorPedidos;
import modelo.gestores.GestorClientes;
import modelo.gestores.GestorProductos;

public class ControladorCajero {

    private GestorPedidos gestorPedidos;
    private GestorClientes gestorClientes;
    private GestorProductos gestorProductos;

    
//========================== Constructor ===================
    public ControladorCajero(GestorPedidos gestorPedidos,
                             GestorClientes gestorClientes,
                             GestorProductos gestorProductos) {
        this.gestorPedidos = gestorPedidos;
        this.gestorClientes = gestorClientes;
        this.gestorProductos = gestorProductos;
    }

//===============METODOS=======================
    public void registrarPedidoPresencial(Pedido pedido) {
        gestorPedidos.registrarPedidoPresencial(pedido);
    }

    public void registrarPedidoDelivery(Pedido pedido) {
        gestorPedidos.registrarPedidoDelivery(pedido);
    }

    public Pedido verPedidoDeliveryPendiente() {
        return gestorPedidos.verPedidoDeliveryPendiente();
    }

    public Pedido moverPedidoAPreparacion() {
        return gestorPedidos.moverPedidoAPreparacion();
    }

    public Pedido marcarPedidoListoParaEnvio() {
        return gestorPedidos.marcarPedidoListoParaEnvio();
    }

    public boolean hayPedidosDeliveryPendientes() {
        return gestorPedidos.hayPedidosDeliveryPendientes();
    }

    public boolean hayPedidosEnPreparacion() {
        return gestorPedidos.hayPedidosEnPreparacion();
    }

    public Cliente buscarClientePorId(int id) {
        return gestorClientes.buscarPorId(id);
    }
}
