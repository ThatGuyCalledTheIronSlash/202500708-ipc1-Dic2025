
package vista.admin;

import controlador.ControladorAdmin;
import modelo.Empleado;
import javax.swing.JOptionPane;
import modelo.estructuras.NodoDoble;


public class VentanaEmpleados extends javax.swing.JFrame {
    
    private ControladorAdmin controladorAdmin;
    private Empleado empleadoEnEdicion;
    private PanelAdmin panelAdmin;
    private NodoDoble nodoActual;
    private NodoDoble cabezaLista;
    
    public VentanaEmpleados(ControladorAdmin controladorAdmin, PanelAdmin panelAdmin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controladorAdmin = controladorAdmin;
        this.panelAdmin = panelAdmin;
        this.empleadoEnEdicion = null;
        txtIdEmpleado.setEditable(false);
        txtIdEmpleado.setText("");
    }
    
    public VentanaEmpleados(ControladorAdmin controladorAdmin,
                            PanelAdmin panelAdmin,
                            NodoDoble cabezaLista,
                            NodoDoble nodoInicial) {
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
            this.empleadoEnEdicion = (Empleado) this.nodoActual.getDato();
        } else {
            this.empleadoEnEdicion = null;
        }

        txtIdEmpleado.setEditable(false);
        cargarDatosEmpleado();
    }
    
    private void cargarDatosEmpleado() {
            if (empleadoEnEdicion != null) {
                txtIdEmpleado.setText(String.valueOf(empleadoEnEdicion.getIdEmpleado()));
                txtNombreEmpleado.setText(empleadoEnEdicion.getNombreCompleto());
                txtUsuarioEmpleado.setText(empleadoEnEdicion.getUsuario());
                txtContrasenaEmpleado.setText(empleadoEnEdicion.getContrasena());
                txtDpiEmpleado.setText(empleadoEnEdicion.getDpi());
                txtTelefonoEmpleado.setText(empleadoEnEdicion.getTelefono());
                txtEmailEmpleado.setText(empleadoEnEdicion.getEmail());
                txtSucursalEmpleado.setText(empleadoEnEdicion.getSucursalAsignada());
                cbxPuesto.setSelectedItem(empleadoEnEdicion.getPuesto());
                cbxTurno.setSelectedItem(empleadoEnEdicion.getTurno());
                txtSalarioEmpleado.setText(String.valueOf(empleadoEnEdicion.getSalarioBase()));
                chkActivo.setSelected(empleadoEnEdicion.isActivo());
            }
        }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnombrecliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdireccioncliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtusuariocliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtcontrasena = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttelefonocliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtemailcliente = new javax.swing.JTextField();
        btnClienteAnterior = new javax.swing.JButton();
        btnSiguientecliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        txtUsuarioEmpleado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtContrasenaEmpleado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDpiEmpleado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTelefonoEmpleado = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEmailEmpleado = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtSucursalEmpleado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtSalarioEmpleado = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        btnguardarEmpleado = new javax.swing.JButton();
        cbxPuesto = new javax.swing.JComboBox<>();
        cbxTurno = new javax.swing.JComboBox<>();
        chkActivo = new javax.swing.JCheckBox();
        btnAnteriorEmpleado = new javax.swing.JButton();
        btnSiguienteEmpleado = new javax.swing.JButton();

        jLabel2.setText("ID CLIENTE");

        jLabel3.setText("NOMBRE");

        jLabel4.setText("DIRECCION");

        jLabel5.setText("USUARIO");

        jLabel10.setText("CONTRASEÑA");

        jLabel6.setText("TELEFONO");

        jLabel7.setText("EMAIL");

        btnClienteAnterior.setText("Anterior");
        btnClienteAnterior.addActionListener(this::btnClienteAnteriorActionPerformed);

        btnSiguientecliente.setText("Siguiente");
        btnSiguientecliente.addActionListener(this::btnSiguienteclienteActionPerformed);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setText("ID EMPLEADO");

        jLabel9.setText("NOMBRE");

        jLabel12.setText("USUARIO");

        jLabel13.setText("CONTRASEÑA");

        jLabel14.setText("TELEFONO");

        jLabel15.setText("EMAIL");

        jLabel16.setText("CUI");

        jLabel17.setText("SUCURSAL");

        jLabel18.setText("PUESTO");

        jLabel19.setText("TURNO");

        jLabel20.setText("SALARIO");

        jLabel21.setText("ACTIVO");

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(this::btncancelarActionPerformed);

        btnguardarEmpleado.setText("Guardar");
        btnguardarEmpleado.addActionListener(this::btnguardarEmpleadoActionPerformed);

        cbxPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Cajero", "Conserje" }));

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino", "Nocturno" }));

        btnAnteriorEmpleado.setText("Anterior");
        btnAnteriorEmpleado.addActionListener(this::btnAnteriorEmpleadoActionPerformed);

        btnSiguienteEmpleado.setText("Siguiente");
        btnSiguienteEmpleado.addActionListener(this::btnSiguienteEmpleadoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDpiEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtContrasenaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmailEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSucursalEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(txtUsuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel21)
                                        .addComponent(btncancelar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtSalarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(chkActivo)
                                                .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbxPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(btnguardarEmpleado)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnAnteriorEmpleado)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnSiguienteEmpleado))))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDpiEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSucursalEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbxPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(chkActivo))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar)
                    .addComponent(btnguardarEmpleado)
                    .addComponent(btnAnteriorEmpleado)
                    .addComponent(btnSiguienteEmpleado))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarEmpleadoActionPerformed
        String nombre = txtNombreEmpleado.getText();
        String usuario = txtUsuarioEmpleado.getText();
        String contrasena = txtContrasenaEmpleado.getText();
        String dpi = txtDpiEmpleado.getText();
        String telefono = txtTelefonoEmpleado.getText();
        String email = txtEmailEmpleado.getText();
        String sucursal = txtSucursalEmpleado.getText();
        String puesto = cbxPuesto.getSelectedItem().toString();
        String turno = cbxTurno.getSelectedItem().toString();
        double salario = Double.parseDouble(txtSalarioEmpleado.getText());
        boolean activo = chkActivo.isSelected();

               if (empleadoEnEdicion == null) {
                   controladorAdmin.registrarEmpleado(
                           nombre, usuario, contrasena, dpi,
                           telefono, email, puesto, turno, sucursal,
                           salario, activo
                   );
                   JOptionPane.showMessageDialog(this, "Empleado creado correctamente.");
               } else {
                   boolean ok = controladorAdmin.actualizarEmpleado(
                           empleadoEnEdicion.getIdEmpleado(),
                           nombre, usuario, contrasena, dpi,
                           telefono, email, puesto, turno, sucursal,
                           salario, activo
                   );
                   if (ok) {
                       JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente.");
                   } else {
                       JOptionPane.showMessageDialog(this, "No se pudo actualizar el empleado.");
                   }
               }

               if (panelAdmin != null) {
                   panelAdmin.recargarTablas();
               }
    }//GEN-LAST:event_btnguardarEmpleadoActionPerformed

    private void btnClienteAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteAnteriorActionPerformed

    }//GEN-LAST:event_btnClienteAnteriorActionPerformed

    private void btnSiguienteclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteclienteActionPerformed

    }//GEN-LAST:event_btnSiguienteclienteActionPerformed

    private void btnAnteriorEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorEmpleadoActionPerformed
       if (nodoActual == null || nodoActual.getAnterior() == null) {
            JOptionPane.showMessageDialog(this, "Ya está en el primer empleado.");
            return;
        }

        nodoActual = nodoActual.getAnterior();
        empleadoEnEdicion = (Empleado) nodoActual.getDato();
        cargarDatosEmpleado();
    }//GEN-LAST:event_btnAnteriorEmpleadoActionPerformed

    private void btnSiguienteEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteEmpleadoActionPerformed
        if (nodoActual == null || nodoActual.getSiguiente() == null) {
             JOptionPane.showMessageDialog(this, "Ya está en el último empleado.");
             return;
         }

         nodoActual = nodoActual.getSiguiente();
         empleadoEnEdicion = (Empleado) nodoActual.getDato();
         cargarDatosEmpleado();
    }//GEN-LAST:event_btnSiguienteEmpleadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnteriorEmpleado;
    private javax.swing.JButton btnClienteAnterior;
    private javax.swing.JButton btnSiguienteEmpleado;
    private javax.swing.JButton btnSiguientecliente;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardarEmpleado;
    private javax.swing.JComboBox<String> cbxPuesto;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtContrasenaEmpleado;
    private javax.swing.JTextField txtDpiEmpleado;
    private javax.swing.JTextField txtEmailEmpleado;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtSalarioEmpleado;
    private javax.swing.JTextField txtSucursalEmpleado;
    private javax.swing.JTextField txtTelefonoEmpleado;
    private javax.swing.JTextField txtUsuarioEmpleado;
    private javax.swing.JTextField txtcontrasena;
    private javax.swing.JTextField txtdireccioncliente;
    private javax.swing.JTextField txtemailcliente;
    private javax.swing.JTextField txtnombrecliente;
    private javax.swing.JTextField txttelefonocliente;
    private javax.swing.JTextField txtusuariocliente;
    // End of variables declaration//GEN-END:variables
}
