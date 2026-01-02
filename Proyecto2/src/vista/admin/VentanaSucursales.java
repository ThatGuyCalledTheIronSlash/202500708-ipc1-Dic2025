
package vista.admin;

import controlador.ControladorAdmin;
import modelo.Sucursal;
import javax.swing.JOptionPane;

public class VentanaSucursales extends javax.swing.JFrame {

    private ControladorAdmin controladorAdmin;
    private PanelAdmin panelAdmin;
    private Sucursal sucursalEnEdicion;

    // Nueva sucursal
    public VentanaSucursales(ControladorAdmin controladorAdmin, PanelAdmin panelAdmin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controladorAdmin = controladorAdmin;
        this.panelAdmin = panelAdmin;
        this.sucursalEnEdicion = null;

        txtID.setEditable(false);
        txtID.setText("");
        cmbEstado.setSelectedItem("Activa");
    }

    // Editar sucursal existente
    public VentanaSucursales(ControladorAdmin controladorAdmin, PanelAdmin panelAdmin, Sucursal sucursal) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controladorAdmin = controladorAdmin;
        this.panelAdmin = panelAdmin;
        this.sucursalEnEdicion = sucursal;

        txtID.setEditable(false);
        cargarDatosSucursal();
    }

    private void cargarDatosSucursal() {
        if (sucursalEnEdicion != null) {
            txtID.setText(String.valueOf(sucursalEnEdicion.getIdSucursal()));
            txtNombre.setText(sucursalEnEdicion.getNombre());
            txtDireccion.setText(sucursalEnEdicion.getDireccion());
            txtTelefono.setText(sucursalEnEdicion.getTelefono());
            txtGerente.setText(sucursalEnEdicion.getGerenteAsignado());
            txtCapacidad.setText(String.valueOf(sucursalEnEdicion.getCapacidadMesas()));
            txtHorario.setText(sucursalEnEdicion.getHorario());
            cmbEstado.setSelectedItem(sucursalEnEdicion.getEstado());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtGerente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btncancelar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        txtCapacidad = new javax.swing.JTextField();
        txtHorario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("DIRECCION");

        jLabel5.setText("TELEFONO");

        jLabel10.setText("GERENTE");

        jLabel2.setText("ID");

        jLabel1.setText("CAPACIDAD");

        jLabel3.setText("NOMBRE");

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(this::btncancelarActionPerformed);

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(this::btnguardarActionPerformed);

        jLabel6.setText("HORARIO");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "Inactiva" }));

        jLabel7.setText("ESTADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btncancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnguardar))
                                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar)
                    .addComponent(btnguardar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
            String nombre = txtNombre.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            String gerente = txtGerente.getText();
            String capacidadTexto = txtCapacidad.getText();
            String horario = txtHorario.getText();
            String estado = cmbEstado.getSelectedItem().toString();

            if (nombre.length() == 0 || direccion.length() == 0 || telefono.length() == 0
                    || gerente.length() == 0 || capacidadTexto.length() == 0 || horario.length() == 0) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            int capacidad;
            try {
                capacidad = Integer.parseInt(capacidadTexto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Capacidad inválida.");
                return;
            }

            if (sucursalEnEdicion == null) {
                controladorAdmin.registrarSucursal(
                        nombre, direccion, telefono, gerente, capacidad, horario, estado
                );
                JOptionPane.showMessageDialog(this, "Sucursal registrada con éxito.");
            } else {
                int id = sucursalEnEdicion.getIdSucursal();
                boolean actualizado = controladorAdmin.actualizarSucursal(
                        id, nombre, direccion, telefono, gerente, capacidad, horario, estado
                );
                if (!actualizado) {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar la sucursal.");
                    return;
                }
                JOptionPane.showMessageDialog(this, "Sucursal actualizada con éxito.");
            }

            panelAdmin.recargarTablas();
            this.dispose();      
    }//GEN-LAST:event_btnguardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtGerente;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
