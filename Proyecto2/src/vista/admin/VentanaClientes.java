package vista.admin;

import modelo.estructuras.NodoDoble;
import controlador.ControladorAdmin;
import modelo.Cliente;
import javax.swing.JOptionPane;

public class VentanaClientes extends javax.swing.JFrame {

    private ControladorAdmin controladorAdmin;
    private Cliente clienteEnEdicion;
    private PanelAdmin panelAdmin;
    private NodoDoble nodoActual;
    private NodoDoble cabezaLista;

    // Constructor para nuevo cliente
    public VentanaClientes(ControladorAdmin controladorAdmin, PanelAdmin panelAdmin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controladorAdmin = controladorAdmin;
        this.panelAdmin = panelAdmin;
        this.cabezaLista = null;
        this.nodoActual = null;
        this.clienteEnEdicion = null;
        txtID.setEditable(false);
        txtID.setText("");
    }

    // Constructor para EDITAR cliente
    public VentanaClientes(ControladorAdmin controladorAdmin,
                           PanelAdmin panelAdmin,
                           NodoDoble cabezaLista, NodoDoble nodoInicial) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controladorAdmin = controladorAdmin;
        this.panelAdmin = panelAdmin;      
        this.cabezaLista = cabezaLista;

            if (nodoInicial != null) {
                this.nodoActual = nodoInicial;
            } else {
                this.nodoActual = cabezaLista;
            }

            if (this.nodoActual != null) {
                this.clienteEnEdicion = (Cliente) this.nodoActual.getDato();
            } else {
                this.clienteEnEdicion = null;
            }

            txtID.setEditable(false);
            cargarDatosCliente();
    }
 
    private void cargarDatosCliente() {
        if (clienteEnEdicion != null) {
            txtID.setText(String.valueOf(clienteEnEdicion.getIdCliente()));
            txtnombrecliente.setText(clienteEnEdicion.getNombreCompleto());
            txtdireccioncliente.setText(clienteEnEdicion.getDireccionEntrega());
            txtusuariocliente.setText(clienteEnEdicion.getUsuario());
            txttelefonocliente.setText(clienteEnEdicion.getTelefono());
            txtemailcliente.setText(clienteEnEdicion.getEmail());
           cbxNivelCliente.setSelectedItem(clienteEnEdicion.getNivel());
            txtptscliente.setText(String.valueOf(clienteEnEdicion.getPuntosAcumulados()));
            txtcontrasena.setText(clienteEnEdicion.getContrasena());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnguardarcliente = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombrecliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtdireccioncliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtusuariocliente = new javax.swing.JTextField();
        txttelefonocliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtemailcliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtptscliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtcontrasena = new javax.swing.JTextField();
        cbxNivelCliente = new javax.swing.JComboBox<>();
        btnSiguientecliente = new javax.swing.JButton();
        btnClienteAnterior = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnguardarcliente.setText("Guardar");
        btnguardarcliente.addActionListener(this::btnguardarclienteActionPerformed);

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(this::btncancelarActionPerformed);

        jLabel2.setText("ID CLIENTE");

        jLabel3.setText("NOMBRE");

        jLabel4.setText("DIRECCION");

        jLabel5.setText("USUARIO");

        jLabel6.setText("TELEFONO");

        jLabel7.setText("EMAIL");

        jLabel8.setText("NIVEL");

        jLabel9.setText("PTS. INICIALES");

        jLabel10.setText("CONTRASEÑA");

        cbxNivelCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Premium", "VIP" }));

        btnSiguientecliente.setText("Siguiente");
        btnSiguientecliente.addActionListener(this::btnSiguienteclienteActionPerformed);

        btnClienteAnterior.setText("Anterior");
        btnClienteAnterior.addActionListener(this::btnClienteAnteriorActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtdireccioncliente, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtusuariocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttelefonocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemailcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtptscliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxNivelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btncancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnguardarcliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClienteAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguientecliente)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdireccioncliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtusuariocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefonocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemailcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxNivelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtptscliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar)
                    .addComponent(btnguardarcliente)
                    .addComponent(btnSiguientecliente)
                    .addComponent(btnClienteAnterior))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarclienteActionPerformed
        String nombre = txtnombrecliente.getText().trim();
        String direccion = txtdireccioncliente.getText().trim();
        String usuario = txtusuariocliente.getText().trim();
        String telefono = txttelefonocliente.getText().trim();
        String email = txtemailcliente.getText().trim();
        String nivel = cbxNivelCliente.getSelectedItem().toString().trim();
        String puntosTexto = txtptscliente.getText().trim();
        String contrasena = txtcontrasena.getText().trim();

        if (nombre.isEmpty() || direccion.isEmpty() || usuario.isEmpty()
                || telefono.isEmpty() || email.isEmpty()
                || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene los campos obligatorios.");
            return;
        }

        int puntos = 0;
        try {
            if (puntosTexto != null && puntosTexto.length() > 0) {
                puntos = Integer.parseInt(puntosTexto);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los puntos deben ser un número entero.");
            return;
        }

        if (clienteEnEdicion == null) {
            // Nuevo cliente
            controladorAdmin.registrarCliente(
                    nombre,
                    direccion,
                    usuario,
                    contrasena,
                    telefono,
                    email,
                    nivel,
                    puntos          // ← aquí va la variable puntos
            );
            JOptionPane.showMessageDialog(this, "Cliente creado correctamente.");
        } else {
            // Editar cliente
            boolean actualizado = controladorAdmin.actualizarCliente(
                    clienteEnEdicion.getIdCliente(),
                    nombre,
                    direccion,
                    usuario,
                    contrasena,
                    telefono,
                    email,
                    nivel,
                    puntos
            );

            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el cliente.");
            }
        }

        if (panelAdmin != null) {
            panelAdmin.recargarTablas();
        }
    }//GEN-LAST:event_btnguardarclienteActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnClienteAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteAnteriorActionPerformed
        if (nodoActual == null) {
            JOptionPane.showMessageDialog(this, "Ya esta en el Primer Cliente");
            return;
            }
            NodoDoble anterior = nodoActual.getAnterior();
            if (anterior == null) {
                JOptionPane.showMessageDialog(this, "No hay Cliente anterior");
                return;
            }
            nodoActual = anterior;
            clienteEnEdicion = (Cliente) nodoActual.getDato();
            cargarDatosCliente();
    }//GEN-LAST:event_btnClienteAnteriorActionPerformed

    private void btnSiguienteclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteclienteActionPerformed
        if (nodoActual == null) {
                JOptionPane.showMessageDialog(this, "Ya esta en el Primer Cliente");
                return;
            }
            NodoDoble siguiente = nodoActual.getSiguiente();
            if (siguiente == null) {
                JOptionPane.showMessageDialog(this, "No hay siguiente Cliente");
                return;
            }
            nodoActual = siguiente;
            clienteEnEdicion = (Cliente) nodoActual.getDato();
            cargarDatosCliente();
    }//GEN-LAST:event_btnSiguienteclienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClienteAnterior;
    private javax.swing.JButton btnSiguientecliente;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardarcliente;
    private javax.swing.JComboBox<String> cbxNivelCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtcontrasena;
    private javax.swing.JTextField txtdireccioncliente;
    private javax.swing.JTextField txtemailcliente;
    private javax.swing.JTextField txtnombrecliente;
    private javax.swing.JTextField txtptscliente;
    private javax.swing.JTextField txttelefonocliente;
    private javax.swing.JTextField txtusuariocliente;
    // End of variables declaration//GEN-END:variables
}
