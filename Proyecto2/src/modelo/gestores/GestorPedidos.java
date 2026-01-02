package modelo.gestores;

import modelo.Pedido;
import modelo.Cliente;
import modelo.estructuras.Cola;
import modelo.estructuras.Pila;

public class GestorPedidos {

    private Cola colaPresenciales;
    private Pila pilaPendientesDelivery;
    private Pila pilaEnPreparacionDelivery;

    public GestorPedidos() {
        this.colaPresenciales = new Cola();
        this.pilaPendientesDelivery = new Pila();
        this.pilaEnPreparacionDelivery = new Pila();
    }

//================== GESTIONAR PEDIDOS ==================

    private int obtenerPrioridadPorNivel(String nivel) {
        if (nivel.equalsIgnoreCase("VIP")) {
            return 1;
        }
            if (nivel.equalsIgnoreCase("Premium")) {
                return 2;
            }
                return 3; // Regular
        }

    public void registrarPedidoPresencial(Pedido pedido) {
        if (pedido != null && pedido.getTipo().equalsIgnoreCase("Presencial")) {
            Cliente cliente = pedido.getCliente();
                String nivel = cliente.getNivel();
                
                int prioridad = obtenerPrioridadPorNivel(nivel);
                colaPresenciales.encolar(pedido, prioridad);
            }
        }

    public Pedido verSiguientePedidoPresencial() {
        Object dato = colaPresenciales.peek();
            if (dato == null) {
                return null;
            }
            return (Pedido) dato;
        }

    public Pedido atenderPedidoPresencial() {
        Object dato = colaPresenciales.desencolar();
            if (dato == null) {
                return null;
            }
            return (Pedido) dato;
        }

    public boolean hayPedidosPresenciales() {
        return !colaPresenciales.estaVacia();
    }

    // ================== PEDIDOS (DOBLE PILA) ==================

    public void registrarPedidoDelivery(Pedido pedido) {
        if (pedido != null && pedido.getTipo().equalsIgnoreCase("Delivery")) {
            pilaPendientesDelivery.apilar(pedido);
        }
    }

    public Pedido verPedidoDeliveryPendiente() {
        Object dato = pilaPendientesDelivery.verTope();
            if (dato == null) {
                return null;
            }
            return (Pedido) dato;
        }

    public Pedido moverPedidoAPreparacion() {
        Object dato = pilaPendientesDelivery.desapilar();
            if (dato == null) {
                return null;
            }

        Pedido pedido = (Pedido) dato;
        pedido.setEstado("En Preparación");
        pilaEnPreparacionDelivery.apilar(pedido);
        return pedido;
    }

    public Pedido marcarPedidoListoParaEnvio() {
        Object dato = pilaEnPreparacionDelivery.desapilar();
            if (dato == null) {
                return null;
            }

            Pedido pedido = (Pedido) dato;
            pedido.setEstado("Listo para Envío");
            return pedido;
        }

    public boolean hayPedidosDeliveryPendientes() {
        return !pilaPendientesDelivery.estaVacia();
    }

    public boolean hayPedidosEnPreparacion() {
        return !pilaEnPreparacionDelivery.estaVacia();
    }

    public Pila getPilaPendientesDelivery() {
        return pilaPendientesDelivery;
    }

    public Pila getPilaEnPreparacionDelivery() {
        return pilaEnPreparacionDelivery;
    }
}
