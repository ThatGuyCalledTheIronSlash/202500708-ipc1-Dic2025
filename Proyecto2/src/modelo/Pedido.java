package modelo;

public class Pedido {

    private static int contadorId = 1;
    private int numeroPedido;
    private String tipo; 
    private Cliente cliente;
    private String nivelCliente; 
    private String sucursal;
    private String estado;      
    private double subtotal;
    private double costoEnvio;
    private double total;
    private String metodoPago;   

    
//==========================Constructor=====================
    public Pedido(String tipo, Cliente cliente, String sucursal, double subtotal,
        double costoEnvio,double total,String metodoPago,String estado) {
            this.numeroPedido = contadorId;
            this.tipo = tipo;
            this.cliente = cliente;
            this.nivelCliente = cliente.getNivel();
            this.sucursal = sucursal;
            this.subtotal = subtotal;
            this.costoEnvio = costoEnvio;
            this.total = total;
            this.metodoPago = metodoPago;
            this.estado = estado;
            
                contadorId=contadorId+1;
    }
//========================Getters y Setters ========================
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.nivelCliente = cliente.getNivel();
    }

    public String getNivelCliente() {
        return nivelCliente;
    }

    public void setNivelCliente(String nivelCliente) {
        this.nivelCliente = nivelCliente;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String toString() {
        return "Pedido{numero=" + numeroPedido + ", tipo=" + tipo + ", cliente=" + cliente.getNombreCompleto() + ", total=" + total + "}";
    }
}
