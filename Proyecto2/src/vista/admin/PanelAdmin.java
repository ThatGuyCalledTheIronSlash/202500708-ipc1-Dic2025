package vista.admin;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;
import modelo.Ingrediente;
import modelo.Sucursal;
import javax.swing.JFileChooser;
import modelo.estructuras.NodoSimple;
import modelo.estructuras.NodoDoble;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class PanelAdmin extends javax.swing.JFrame {
    
    private controlador.ControladorAdmin controladorAdmin;
    
    public PanelAdmin(controlador.ControladorAdmin controladorAdmin) {

            initComponents();
            this.setLocationRelativeTo(null);           
            this.controladorAdmin = controladorAdmin;
            recargarTablas();
        }
 
    public PanelAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
//=================================CARGAR TABLAS====================
    public void recargarTablas(){
        cargarTablaClientes();
        cargarTablaEmpleados();
        cargarTablaProductos();
        cargarTablaInventario();
        cargarTablaSucursales();
    }   
    //================Cargar especifico==================
    private void cargarTablaClientes(NodoDoble cabeza) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaclientes.getModel();

         int filas = modeloTabla.getRowCount();
         int i = 0;
         while (i < filas) {
             modeloTabla.removeRow(0);
             i = i + 1;
         }

         NodoDoble actual = cabeza;
         while (actual != null) {
             Cliente c = (Cliente) actual.getDato();

             Object[] fila = new Object[8];
             fila[0] = c.getIdCliente();
             fila[1] = c.getNombreCompleto();
             fila[2] = c.getDireccionEntrega();
             fila[3] = c.getUsuario();
             fila[4] = c.getTelefono();
             fila[5] = c.getEmail();
             fila[6] = c.getNivel();
             fila[7] = c.getPuntosAcumulados();

             modeloTabla.addRow(fila);
             actual = actual.getSiguiente();
         }
     }
    
    private void cargarTablaProductos(NodoDoble cabeza) {
    DefaultTableModel modeloTabla = (DefaultTableModel) tablamenu.getModel();

    // Limpiar tabla
    int filas = modeloTabla.getRowCount();
    int i = 0;
    while (i < filas) {
        modeloTabla.removeRow(0);
        i = i + 1;
    }

    NodoDoble actual = cabeza;
    while (actual != null) {
        Producto p = (Producto) actual.getDato();

        Object[] fila = new Object[7];
        fila[0] = p.getCodigoProducto();
        fila[1] = p.getNombre();
        fila[2] = p.getDescripcion();
        fila[3] = p.getCategoria();
        fila[4] = p.getPrecio();
        fila[5] = p.getTiempoPreparacion();

        String disponibleTexto = "No";
        if (p.isDisponible()) {
            disponibleTexto = "Sí";
        }
        fila[6] = disponibleTexto;

        modeloTabla.addRow(fila);
        actual = actual.getSiguiente();
    }
}
    
    private void cargarTablaInventario() {
    NodoDoble cabeza = controladorAdmin.obtenerCabezaIngredientes();
    cargarTablaInventario(cabeza);
}
    
    private void cargarTablaSucursales() {
        NodoSimple cabeza = controladorAdmin.obtenerCabezaSucursales();
    cargarTablaSucursales(cabeza);
    }
    
    //===============Cargar todo==================
    private void cargarTablaClientes() {
        NodoDoble cabeza = controladorAdmin.obtenerCabezaClientes();
        cargarTablaClientes(cabeza);
    }
    
   private void cargarTablaEmpleados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaempleados.getModel();

        int filas = modeloTabla.getRowCount();
        int i = 0;
        while (i < filas) {
            modeloTabla.removeRow(0);
            i = i + 1;
        }
        
        NodoDoble actual = controladorAdmin.obtenerCabezaEmpleados();

        while (actual != null) {
            Empleado e = (Empleado) actual.getDato();

            Object[] fila = new Object[11];
            fila[0] = e.getIdEmpleado();
            fila[1] = e.getNombreCompleto();
            fila[2] = e.getUsuario();
            fila[3] = e.getDpi();
            fila[4] = e.getTelefono();
            fila[5] = e.getEmail();
            fila[6] = e.getPuesto();
            fila[7] = e.getTurno();
            fila[8] = e.getSucursalAsignada();
            fila[9] = e.getSalarioBase();  

            String estadoTexto = "Inactivo";
            if (e.isActivo()) {
                estadoTexto = "Activo";
            }
            fila[10] = estadoTexto;  

            modeloTabla.addRow(fila);
            actual = actual.getSiguiente();
        }
    }

    private void cargarTablaProductos() {
       NodoDoble cabeza = controladorAdmin.obtenerCabezaProductos();
        cargarTablaProductos(cabeza);
    }
              
    private void cargarTablaInventario(NodoDoble cabeza) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablainventario.getModel();

        // Limpiar tabla
        int filas = modeloTabla.getRowCount();
        int i = 0;
        while (i < filas) {
            modeloTabla.removeRow(0);
            i = i + 1;
        }

        NodoDoble actual = cabeza;
        while (actual != null) {
            Ingrediente ing = (Ingrediente) actual.getDato();

            Object[] fila = new Object[6];
            fila[0] = ing.getCodigoIngrediente();
            fila[1] = ing.getNombre();
            fila[2] = ing.getCantidadStock();
            fila[3] = ing.getUnidadMedida();
            fila[4] = ing.getNivelMinimo();
            fila[5] = ing.getProveedor();

            modeloTabla.addRow(fila);
            actual = actual.getSiguiente();
        }
    }

    private void cargarTablaSucursales(NodoSimple cabeza) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablasucursales.getModel();

        int filas = modeloTabla.getRowCount();
        int i = 0;
        while (i < filas) {
            modeloTabla.removeRow(0);
            i = i + 1;
        }

        NodoSimple actual = cabeza;
        while (actual != null) {
            Sucursal s = (Sucursal) actual.getDato();

            Object[] fila = new Object[8];
            fila[0] = s.getIdSucursal();
            fila[1] = s.getNombre();
            fila[2] = s.getDireccion();
            fila[3] = s.getTelefono();
            fila[4] = s.getGerenteAsignado();
            fila[5] = s.getCapacidadMesas();
            fila[6] = s.getHorario();
            fila[7] = s.getEstado();

            modeloTabla.addRow(fila);
            actual = actual.getSiguiente();
        }
    }
       
//=============================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablasucursales = new javax.swing.JTable();
        btnBuscarSucursal = new javax.swing.JButton();
        FiltroSucursal = new javax.swing.JComboBox<>();
        txtSucursal = new javax.swing.JTextField();
        btnEliminarSucursal = new javax.swing.JButton();
        btnModificarSucursal = new javax.swing.JButton();
        btnAgregarSucursal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaempleados = new javax.swing.JTable();
        btnBuscarEmpleado = new javax.swing.JButton();
        FiltroEmpleado = new javax.swing.JComboBox<>();
        txtEmpleado = new javax.swing.JTextField();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnModificarEmpleado = new javax.swing.JButton();
        btnAgregarEmpleado = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        btnAgregarCliente = new javax.swing.JButton();
        btnModificarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        FiltroCliente = new javax.swing.JComboBox<>();
        btnBuscarCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablainventario = new javax.swing.JTable();
        btnAgregarIngrediente = new javax.swing.JButton();
        btnModificarIngrediente = new javax.swing.JButton();
        btnEliminarIngrediente = new javax.swing.JButton();
        txtIngrediente = new javax.swing.JTextField();
        FiltroIngrediente = new javax.swing.JComboBox<>();
        btnBuscarIngrediente = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablamenu = new javax.swing.JTable();
        btnAgregarProducto = new javax.swing.JButton();
        btnModificarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        filtroProducto = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        btnCargarEmpleados = new javax.swing.JButton();
        vistaEmpleados = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        reporteEmplados = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        btnCargarClientes = new javax.swing.JButton();
        vistaClientes = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        reporteClientes = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        btnCargarProductos = new javax.swing.JButton();
        vistaPreviaProductos = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        reporteProductos = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        btnCargarMenús = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        vistaPreviaMenu = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        reporteMenu = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        reporteSucursales = new javax.swing.JTextArea();
        btnCargarSucursales = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        vistaPreviaSucursales = new javax.swing.JTextArea();
        btnCerrarSesión = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablasucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Sucursal", "Nombre ", "Direccion", "Telefono", "Gerente", "Capacidad", "Horario", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tablasucursales);

        btnBuscarSucursal.setText("Buscar");
        btnBuscarSucursal.addActionListener(this::btnBuscarSucursalActionPerformed);

        FiltroSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Telefono" }));

        btnEliminarSucursal.setText("Eliminar");
        btnEliminarSucursal.addActionListener(this::btnEliminarSucursalActionPerformed);

        btnModificarSucursal.setText("Modificar");
        btnModificarSucursal.addActionListener(this::btnModificarSucursalActionPerformed);

        btnAgregarSucursal.setText("Agregar");
        btnAgregarSucursal.addActionListener(this::btnAgregarSucursalActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAgregarSucursal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarSucursal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarSucursal)
                        .addGap(18, 18, 18)
                        .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FiltroSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarSucursal))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarSucursal)
                    .addComponent(btnModificarSucursal)
                    .addComponent(btnEliminarSucursal)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarSucursal)
                    .addComponent(FiltroSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Sucursales", jPanel2);

        tablaempleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Empleado", "Nombre", "Usuario", "DPI", "Telefono", "Email", "Puesto", "Turno", "Sucursal", "Salario", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaempleados);

        btnBuscarEmpleado.setText("Buscar");

        FiltroEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "DPI", "Puesto", "Sucursal" }));

        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.addActionListener(this::btnEliminarEmpleadoActionPerformed);

        btnModificarEmpleado.setText("Modificar");
        btnModificarEmpleado.addActionListener(this::btnModificarEmpleadoActionPerformed);

        btnAgregarEmpleado.setText("Agregar");
        btnAgregarEmpleado.addActionListener(this::btnAgregarEmpleadoActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnAgregarEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarEmpleado)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FiltroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarEmpleado)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarEmpleado)
                    .addComponent(btnModificarEmpleado)
                    .addComponent(btnEliminarEmpleado)
                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleado)
                    .addComponent(FiltroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Empleados", jPanel3);

        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nombre", "Dirección ", "Usuario", "Teléfono", "Email", "Nivel", "Puntos "
            }
        ));
        jScrollPane3.setViewportView(tablaclientes);

        btnAgregarCliente.setText("Agregar");
        btnAgregarCliente.addActionListener(this::btnAgregarClienteActionPerformed);

        btnModificarCliente.setText("Modificar");
        btnModificarCliente.addActionListener(this::btnModificarClienteActionPerformed);

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(this::btnEliminarClienteActionPerformed);

        FiltroCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Nivel" }));

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(this::btnBuscarClienteActionPerformed);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAgregarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCliente))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCliente)
                    .addComponent(btnModificarCliente)
                    .addComponent(btnEliminarCliente)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(FiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel9);

        tablainventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Cantidad Stock", "Unidad de medida", "Nivel Min.", "Proveedor"
            }
        ));
        jScrollPane5.setViewportView(tablainventario);

        btnAgregarIngrediente.setText("Agregar");
        btnAgregarIngrediente.addActionListener(this::btnAgregarIngredienteActionPerformed);

        btnModificarIngrediente.setText("Modificar");
        btnModificarIngrediente.addActionListener(this::btnModificarIngredienteActionPerformed);

        btnEliminarIngrediente.setText("Eliminar");
        btnEliminarIngrediente.addActionListener(this::btnEliminarIngredienteActionPerformed);

        FiltroIngrediente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Proveedor" }));

        btnBuscarIngrediente.setText("Buscar");
        btnBuscarIngrediente.addActionListener(this::btnBuscarIngredienteActionPerformed);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnAgregarIngrediente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarIngrediente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarIngrediente)
                        .addGap(18, 18, 18)
                        .addComponent(txtIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FiltroIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarIngrediente)
                        .addGap(26, 26, 26))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarIngrediente)
                    .addComponent(btnModificarIngrediente)
                    .addComponent(btnEliminarIngrediente)
                    .addComponent(txtIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarIngrediente)
                    .addComponent(FiltroIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Inventario", jPanel11);

        tablamenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Descripción", "Categoría", "Precio", "T. Preparación", "Disponibilidad"
            }
        ));
        jScrollPane4.setViewportView(tablamenu);
        if (tablamenu.getColumnModel().getColumnCount() > 0) {
            tablamenu.getColumnModel().getColumn(6).setHeaderValue("Disponibilidad");
        }

        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(this::btnAgregarProductoActionPerformed);

        btnModificarProducto.setText("Modificar");
        btnModificarProducto.addActionListener(this::btnModificarProductoActionPerformed);

        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(this::btnEliminarProductoActionPerformed);

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(this::btnBuscarProductoActionPerformed);

        filtroProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Categoria" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filtroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnBuscarProducto))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProducto)
                    .addComponent(btnModificarProducto)
                    .addComponent(btnEliminarProducto)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto)
                    .addComponent(filtroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Menú", jPanel10);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Menú/Inventario", jPanel4);

        btnCargarEmpleados.setText("Cargar Archivo");
        btnCargarEmpleados.addActionListener(this::btnCargarEmpleadosActionPerformed);

        vistaEmpleados.setColumns(20);
        vistaEmpleados.setRows(5);

        jLabel17.setText("Vista Previa");

        jLabel18.setText("Reporte");

        reporteEmplados.setColumns(20);
        reporteEmplados.setRows(5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reporteEmplados, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(vistaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(btnCargarEmpleados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vistaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(reporteEmplados, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnCargarEmpleados)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cargar Empleados", jPanel6);

        btnCargarClientes.setText("Cargar Archivo");
        btnCargarClientes.addActionListener(this::btnCargarClientesActionPerformed);

        vistaClientes.setColumns(20);
        vistaClientes.setRows(5);

        jLabel15.setText("Vista Previa");

        jLabel16.setText("Reporte");

        reporteClientes.setColumns(20);
        reporteClientes.setRows(5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(505, 505, 505)
                        .addComponent(btnCargarClientes))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reporteClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(vistaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vistaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(reporteClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnCargarClientes)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cargar Clientes", jPanel7);

        btnCargarProductos.setText("Cargar Archivo");
        btnCargarProductos.addActionListener(this::btnCargarProductosActionPerformed);

        vistaPreviaProductos.setColumns(20);
        vistaPreviaProductos.setRows(5);

        jLabel13.setText("Reporte");

        reporteProductos.setColumns(20);
        reporteProductos.setRows(5);

        jLabel14.setText("Vista Previa");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(btnCargarProductos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reporteProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(vistaPreviaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vistaPreviaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(reporteProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnCargarProductos)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cargar Productos", jPanel8);

        btnCargarMenús.setText("Cargar Archivo");
        btnCargarMenús.addActionListener(this::btnCargarMenúsActionPerformed);

        jLabel10.setText("Vista Previa");

        jLabel12.setText("Reporte");

        vistaPreviaMenu.setColumns(20);
        vistaPreviaMenu.setRows(5);
        jScrollPane8.setViewportView(vistaPreviaMenu);

        reporteMenu.setColumns(20);
        reporteMenu.setRows(5);
        jScrollPane9.setViewportView(reporteMenu);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(505, 505, 505)
                        .addComponent(btnCargarMenús))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
                            .addComponent(jScrollPane9))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel10)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCargarMenús)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cargar Menús", jPanel20);

        reporteSucursales.setColumns(20);
        reporteSucursales.setRows(5);
        jScrollPane10.setViewportView(reporteSucursales);

        btnCargarSucursales.setText("Cargar Archivo");
        btnCargarSucursales.addActionListener(this::btnCargarSucursalesActionPerformed);

        jLabel19.setText("Vista Previa");

        jLabel20.setText("Reporte");

        vistaPreviaSucursales.setColumns(20);
        vistaPreviaSucursales.setRows(5);
        jScrollPane11.setViewportView(vistaPreviaSucursales);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(505, 505, 505)
                        .addComponent(btnCargarSucursales))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
                            .addComponent(jScrollPane10))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel19)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCargarSucursales)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cargar Sucursales", jPanel12);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cargar Datos", jPanel5);

        btnCerrarSesión.setText("Cerrar Sesión");
        btnCerrarSesión.addActionListener(this::btnCerrarSesiónActionPerformed);

        Archivo.setText("Archivo");

        jMenuItem1.setText("GuardarClientes");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        Archivo.add(jMenuItem1);

        jMenuItem2.setText("GuardarEmpleados");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        Archivo.add(jMenuItem2);

        jMenuItem3.setText("Guardar Inventario");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        Archivo.add(jMenuItem3);

        jMenuItem4.setText("Guardar Menu");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        Archivo.add(jMenuItem4);

        jMenuItem5.setText("GuardarSucursales");
        jMenuItem5.addActionListener(this::jMenuItem5ActionPerformed);
        Archivo.add(jMenuItem5);

        jMenuBar1.add(Archivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarSesión)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrarSesión)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesiónActionPerformed
        this.dispose();
            vista.Login login = new vista.Login();
                login.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesiónActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        File carpetaDatos = new File("datos");
            if (!carpetaDatos.exists()) {
                carpetaDatos.mkdirs();
        }

            File archivo = new File(carpetaDatos, "Empleados.csv");
            String mensaje = controladorAdmin.guardarEmpleadosCSV(archivo);
            JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        File carpetaDatos = new File("datos");
            if (!carpetaDatos.exists()) {
             carpetaDatos.mkdirs();
            }

        File archivo = new File(carpetaDatos, "Clientes.csv");
        String mensaje = controladorAdmin.guardarClientesCSV(archivo);
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        File carpetaDatos = new File("datos");
            if (!carpetaDatos.exists()) {
                carpetaDatos.mkdirs();
            }

        File archivo = new File(carpetaDatos, "Inventario.csv");
        String mensaje = controladorAdmin.guardarInventarioCSV(archivo);
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        File carpetaDatos = new File("datos");
            if (!carpetaDatos.exists()) {
                carpetaDatos.mkdirs();
        }

        File archivo = new File(carpetaDatos, "Menú.csv");
        String mensaje = controladorAdmin.guardarProductosCSV(archivo);
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnCargarMenúsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarMenúsActionPerformed
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(this);
        if (resultado != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File archivo = chooser.getSelectedFile();

        StringBuilder vista = new StringBuilder();
        try (BufferedReader br =
            new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null && contador < 10) {
                vista.append(linea).append("\n");
                contador = contador + 1;
            }
        } catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer vista previa: " + e.getMessage());
        }
        vistaPreviaMenu.setText(vista.toString());
        String reporte = controladorAdmin.cargarProductosDesdeCSV(archivo);
        reporteMenu.setText(reporte);

        recargarTablas();
    }//GEN-LAST:event_btnCargarMenúsActionPerformed

    private void btnCargarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarProductosActionPerformed
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(this);
        if (resultado != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File archivo = chooser.getSelectedFile();

        StringBuilder vista = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(archivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null && contador < 10) {
                vista.append(linea).append("\n");
                contador++;
            }
        } catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer vista previa: " + e.getMessage());
        }
        vistaPreviaProductos.setText(vista.toString());
        String reporte = controladorAdmin.cargarIngredientesDesdeCSV(archivo);
        reporteProductos.setText(reporte);

        recargarTablas();
    }//GEN-LAST:event_btnCargarProductosActionPerformed

    private void btnCargarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarClientesActionPerformed
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(this);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File archivo = chooser.getSelectedFile();
        if (archivo == null) {
            return;
        }

        StringBuilder vista = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(archivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null && contador < 10) {
                vista.append(linea).append("\n");
                contador++;
            }
        } catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer archivo: " + e.getMessage());
            return;
        }

        vistaClientes.setText(vista.toString());

        String reporte = controladorAdmin.cargarClientesDesdeCSV(archivo);
        reporteClientes.setText(reporte);

        JOptionPane.showMessageDialog(this, "Carga de clientes finalizada.");
        recargarTablas();
    }//GEN-LAST:event_btnCargarClientesActionPerformed

    private void btnCargarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarEmpleadosActionPerformed
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(this);

        if (resultado != javax.swing.JFileChooser.APPROVE_OPTION) {
            return;
        }

        File archivo = chooser.getSelectedFile();
        if (archivo == null) {
            return;
        }

        StringBuilder vista = new StringBuilder();
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(archivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null && contador < 10) {
                vista.append(linea).append("\n");
                contador++;
            }
        } catch (java.io.IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al leer archivo: " + e.getMessage());
            return;
        }

        vistaEmpleados.setText(vista.toString());
        String reporte = controladorAdmin.cargarEmpleadosDesdeCSV(archivo);
        reporteEmplados.setText(reporte);

        javax.swing.JOptionPane.showMessageDialog(this, "Carga de empleados finalizada.");
        recargarTablas();
    }//GEN-LAST:event_btnCargarEmpleadosActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        String texto = txtProducto.getText();
        String filtro = filtroProducto.getSelectedItem().toString();

        if (texto == null || texto.length() == 0) {
            cargarTablaProductos();
            return;
        }
        NodoDoble cabezaResultados = null;

        if (filtro.equals("Codigo")) {
            int codigo;
            try {
                codigo = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Código inválido.");
                return;
            }
            cabezaResultados = controladorAdmin.buscarProductosPorCodigo(codigo);

        } else if (filtro.equals("Nombre")) {
            cabezaResultados = controladorAdmin.buscarProductosPorNombre(texto);

        } else if (filtro.equals("Categoria")) {
            cabezaResultados = controladorAdmin.buscarProductosPorCategoria(texto);
        }

        cargarTablaProductos(cabezaResultados);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        String texto = JOptionPane.showInputDialog(
            this,
            "Ingrese el código del producto a eliminar:"
        );
        if (texto == null || texto.length() == 0) {
            return;
        }

        int codigo;
        try {
            codigo = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido.");
            return;
        }

        boolean eliminado = controladorAdmin.eliminarProductoPorCodigo(codigo);
        if (!eliminado) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Producto eliminado con éxito.");
        recargarTablas();
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
        String texto = JOptionPane.showInputDialog(
            this,
            "Ingrese el código del producto a modificar:"
        );
        if (texto == null || texto.length() == 0) {
            return;
        }

        int codigo;
        try {
            codigo = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido.");
            return;
        }

        Producto producto = controladorAdmin.buscarProductoPorCodigo(codigo);
        if (producto == null) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            return;
        }

        VentanaProductos ventana = new VentanaProductos(controladorAdmin, this, producto);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        VentanaProductos ventana = new VentanaProductos(controladorAdmin, this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnBuscarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIngredienteActionPerformed
        String texto = txtIngrediente.getText();
        String filtro = FiltroIngrediente.getSelectedItem().toString();

        if (texto == null || texto.length() == 0) {
            // Sin texto, mostrar todo
            cargarTablaInventario();
            return;
        }

        NodoDoble cabezaResultados = null;

        if (filtro.equals("Codigo")) {
            int codigo;
            try {
                codigo = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Código inválido.");
                return;
            }
            cabezaResultados = controladorAdmin.buscarIngredientesPorCodigo(codigo);

        } else if (filtro.equals("Nombre")) {
            cabezaResultados = controladorAdmin.buscarIngredientesPorNombre(texto);

        } else if (filtro.equals("Proveedor")) {
            cabezaResultados = controladorAdmin.buscarIngredientesPorProveedor(texto);
        }

        cargarTablaInventario(cabezaResultados);
    }//GEN-LAST:event_btnBuscarIngredienteActionPerformed

    private void btnEliminarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIngredienteActionPerformed
        String texto = JOptionPane.showInputDialog(this,"Ingrese el código del ingrediente a eliminar:");
        if (texto == null || texto.length() == 0) {
            return;
        }

        int codigo;
        try {
            codigo = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido.");
            return;
        }

        boolean eliminado = controladorAdmin.eliminarIngredientePorCodigo(codigo);
        if (!eliminado) {
            JOptionPane.showMessageDialog(this, "Ingrediente no encontrado.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Ingrediente eliminado con éxito.");
        recargarTablas();
    }//GEN-LAST:event_btnEliminarIngredienteActionPerformed

    private void btnModificarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarIngredienteActionPerformed
        String texto = JOptionPane.showInputDialog(
            this,
            "Ingrese el código del ingrediente a modificar:"
        );
        if (texto == null || texto.length() == 0) {
            return;
        }

        int codigo;
        try {
            codigo = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido.");
            return;
        }

        Ingrediente ing = controladorAdmin.buscarIngredientePorCodigo(codigo);
        if (ing == null) {
            JOptionPane.showMessageDialog(this, "Ingrediente no encontrado.");
            return;
        }

        VentanaInventario ventana = new VentanaInventario(controladorAdmin, this, ing);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnModificarIngredienteActionPerformed

    private void btnAgregarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIngredienteActionPerformed
        VentanaInventario ventana = new VentanaInventario(controladorAdmin, this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnAgregarIngredienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        String texto = txtCliente.getText();
        String filtro = FiltroCliente.getSelectedItem().toString();

        if (texto == null || texto.length() == 0) {
            cargarTablaClientes();
            return;
        }

        NodoDoble cabezaResultados = null;

        if (filtro.equals("ID")) {
            int id;
            try {
                id = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
                return;
            }
            cabezaResultados = controladorAdmin.buscarClientesPorId(id);
        } else if (filtro.equals("Nombre")) {
            cabezaResultados = controladorAdmin.buscarClientesPorNombre(texto);
        } else if (filtro.equals("Nivel")) {
            cabezaResultados = controladorAdmin.buscarClientesPorNivel(texto);
        }

        cargarTablaClientes(cabezaResultados);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        String idTexto = JOptionPane.showInputDialog(
            this,
            "Ingrese el ID del cliente a eliminar:"
        );
        if (idTexto == null || idTexto.length() == 0) {
            return;
        }

        int idCliente;
        try {
            idCliente = Integer.parseInt(idTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Eliminar cliente con ID " + idCliente + "?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        boolean eliminado = controladorAdmin.eliminarClientePorId(idCliente);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el cliente.");
        }

        recargarTablas();
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClienteActionPerformed
        String idTexto = JOptionPane.showInputDialog(this,"Ingrese el ID del cliente a modificar:" );
        if (idTexto == null || idTexto.length() == 0) {
            return;
        }
        int idCliente;
        try {
            idCliente = Integer.parseInt(idTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
            return;
        }

        NodoDoble cabeza = controladorAdmin.obtenerCabezaClientes();
        if (cabeza == null) {
            JOptionPane.showMessageDialog(this, "No hay clientes en la lista.");
            return;
        }

        NodoDoble nodoCliente = controladorAdmin.buscarNodoClientePorId(idCliente);
        if (nodoCliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            return;
        }

        VentanaClientes ventana = new VentanaClientes(controladorAdmin, this, cabeza, nodoCliente);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnModificarClienteActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        VentanaClientes ventana = new VentanaClientes(controladorAdmin, this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoActionPerformed
        VentanaEmpleados ventana = new VentanaEmpleados(controladorAdmin, this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnAgregarEmpleadoActionPerformed

    private void btnModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoActionPerformed
        String idTexto = JOptionPane.showInputDialog(
            this,
            "Ingrese el ID del empleado a modificar:"
        );
        if (idTexto == null || idTexto.length() == 0) {
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
            return;
        }

        NodoDoble cabeza = controladorAdmin.obtenerCabezaEmpleados();
        if (cabeza == null) {
            JOptionPane.showMessageDialog(this, "No hay empleados en la lista.");
            return;
        }

        NodoDoble nodoEmpleado = controladorAdmin.buscarNodoEmpleadoPorId(id);
        if (nodoEmpleado == null) {
            JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
            return;
        }

        VentanaEmpleados ventana = new VentanaEmpleados(controladorAdmin, this, cabeza, nodoEmpleado);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnModificarEmpleadoActionPerformed

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        String idTexto = JOptionPane.showInputDialog(
            this,
            "Ingrese el ID del empleado a eliminar:"
        );
        if (idTexto == null || idTexto.length() == 0) {
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
            return;
        }

        int conf = JOptionPane.showConfirmDialog(
            this,
            "¿Eliminar empleado con ID " + id + "?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION
        );
        if (conf != JOptionPane.YES_OPTION) {
            return;
        }

        boolean eliminado = controladorAdmin.eliminarEmpleadoPorId(id);
        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el empleado.");
        }
        recargarTablas();
    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void btnAgregarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSucursalActionPerformed
        VentanaSucursales ventana = new VentanaSucursales(controladorAdmin, this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnAgregarSucursalActionPerformed

    private void btnModificarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarSucursalActionPerformed
        String idTexto = JOptionPane.showInputDialog(
            this,
            "Ingrese el ID de la sucursal a modificar:"
        );
        if (idTexto == null || idTexto.length() == 0) {
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
            return;
        }

        Sucursal sucursal = controladorAdmin.buscarSucursalPorId(id);
        if (sucursal == null) {
            JOptionPane.showMessageDialog(this, "Sucursal no encontrada.");
            return;
        }

        VentanaSucursales ventana = new VentanaSucursales(controladorAdmin, this, sucursal);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnModificarSucursalActionPerformed

    private void btnEliminarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSucursalActionPerformed
        String idTexto = JOptionPane.showInputDialog(
            this,
            "Ingrese el ID de la sucursal a eliminar:"
        );
        if (idTexto == null || idTexto.length() == 0) {
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
            return;
        }

        int conf = JOptionPane.showConfirmDialog(
            this,
            "¿Eliminar sucursal con ID " + id + "?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION
        );
        if (conf != JOptionPane.YES_OPTION) {
            return;
        }

        boolean eliminado = controladorAdmin.eliminarSucursalPorId(id);
        if (!eliminado) {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar la sucursal.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Sucursal eliminada correctamente.");
        recargarTablas();
    }//GEN-LAST:event_btnEliminarSucursalActionPerformed

    private void btnBuscarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSucursalActionPerformed
        String texto = txtSucursal.getText();
        String filtro = FiltroSucursal.getSelectedItem().toString();

        if (texto == null || texto.length() == 0) {
            cargarTablaSucursales();
            return;
        }

        NodoSimple cabezaResultados = null;

        if (filtro.equals("ID")) {
            int id;
            try {
                id = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
                return;
            }
            cabezaResultados = controladorAdmin.buscarSucursalesPorId(id);

        } else if (filtro.equals("Nombre")) {
            cabezaResultados = controladorAdmin.buscarSucursalesPorNombre(texto);

        } else if (filtro.equals("Telefono")) {
            cabezaResultados = controladorAdmin.buscarSucursalesPorTelefono(texto);
        }
        cargarTablaSucursales(cabezaResultados);
    }//GEN-LAST:event_btnBuscarSucursalActionPerformed

    private void btnCargarSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarSucursalesActionPerformed
        JFileChooser chooser = new JFileChooser();
            int resultado = chooser.showOpenDialog(this);
            if (resultado != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File archivo = chooser.getSelectedFile();

            String mensaje = controladorAdmin.cargarSucursalesDesdeCSV(archivo);
            JOptionPane.showMessageDialog(this, mensaje);

            recargarTablas();
    }//GEN-LAST:event_btnCargarSucursalesActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        File carpetaDatos = new File("datos");
            if (!carpetaDatos.exists()) {
                carpetaDatos.mkdirs();
            }

        File archivo = new File(carpetaDatos, "Sucursales.csv");
        String mensaje = controladorAdmin.guardarSucursalesEnCSV(archivo);
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_jMenuItem5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Archivo;
    private javax.swing.JComboBox<String> FiltroCliente;
    private javax.swing.JComboBox<String> FiltroEmpleado;
    private javax.swing.JComboBox<String> FiltroIngrediente;
    private javax.swing.JComboBox<String> FiltroSucursal;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnAgregarEmpleado;
    private javax.swing.JButton btnAgregarIngrediente;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnAgregarSucursal;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarIngrediente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarSucursal;
    private javax.swing.JButton btnCargarClientes;
    private javax.swing.JButton btnCargarEmpleados;
    private javax.swing.JButton btnCargarMenús;
    private javax.swing.JButton btnCargarProductos;
    private javax.swing.JButton btnCargarSucursales;
    private javax.swing.JButton btnCerrarSesión;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnEliminarIngrediente;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEliminarSucursal;
    private javax.swing.JButton btnModificarCliente;
    private javax.swing.JButton btnModificarEmpleado;
    private javax.swing.JButton btnModificarIngrediente;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JButton btnModificarSucursal;
    private javax.swing.JComboBox<String> filtroProducto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextArea reporteClientes;
    private javax.swing.JTextArea reporteEmplados;
    private javax.swing.JTextArea reporteMenu;
    private javax.swing.JTextArea reporteProductos;
    private javax.swing.JTextArea reporteSucursales;
    private javax.swing.JTable tablaclientes;
    private javax.swing.JTable tablaempleados;
    private javax.swing.JTable tablainventario;
    private javax.swing.JTable tablamenu;
    private javax.swing.JTable tablasucursales;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtIngrediente;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSucursal;
    private javax.swing.JTextArea vistaClientes;
    private javax.swing.JTextArea vistaEmpleados;
    private javax.swing.JTextArea vistaPreviaMenu;
    private javax.swing.JTextArea vistaPreviaProductos;
    private javax.swing.JTextArea vistaPreviaSucursales;
    // End of variables declaration//GEN-END:variables
}
