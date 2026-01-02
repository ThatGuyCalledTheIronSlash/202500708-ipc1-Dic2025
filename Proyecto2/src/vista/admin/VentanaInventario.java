package vista.admin;

import controlador.ControladorAdmin;
import modelo.Ingrediente;
import javax.swing.JOptionPane;

public class VentanaInventario extends javax.swing.JFrame {

    private ControladorAdmin controladorAdmin;
    private PanelAdmin panelAdmin;
    private Ingrediente ingredienteEnEdicion;

    public VentanaInventario(ControladorAdmin controladorAdmin, PanelAdmin panelAdmin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controladorAdmin = controladorAdmin;
        this.panelAdmin = panelAdmin;
        this.ingredienteEnEdicion = null;

        txtCodigo.setEditable(false);
        txtCodigo.setText("");
    }

    public VentanaInventario(ControladorAdmin controladorAdmin, PanelAdmin panelAdmin, Ingrediente ingrediente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controladorAdmin = controladorAdmin;
        this.panelAdmin = panelAdmin;
        this.ingredienteEnEdicion = ingrediente;

        txtCodigo.setEditable(false);
        cargarDatosIngrediente();
    }

    private void cargarDatosIngrediente() {
        if (ingredienteEnEdicion != null) {
            txtCodigo.setText(String.valueOf(ingredienteEnEdicion.getCodigoIngrediente()));
            txtNombre.setText(ingredienteEnEdicion.getNombre());
            txtStock.setText(String.valueOf(ingredienteEnEdicion.getCantidadStock()));
            txtUnidadMedida.setText(ingredienteEnEdicion.getUnidadMedida());
            txtNivelMinimo.setText(String.valueOf(ingredienteEnEdicion.getNivelMinimo()));
            txtProveedor.setText(ingredienteEnEdicion.getProveedor());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUnidadMedida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNivelMinimo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        txtProveedor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("CODIGO");

        jLabel3.setText("NOMBRE");

        jLabel4.setText("STOCK");

        jLabel5.setText("U. MEDIDA");

        jLabel10.setText("NIVEL MIN.");

        jLabel1.setText("PROVEEDOR");

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(this::btncancelarActionPerformed);

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(this::btnguardarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btncancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnguardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNivelMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNivelMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar)
                    .addComponent(btnguardar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String nombre = txtNombre.getText();
        String stockTexto = txtStock.getText();
        String unidadMedida = txtUnidadMedida.getText();
        String nivelMinTexto = txtNivelMinimo.getText();
        String proveedor = txtProveedor.getText();

        if (nombre.length() == 0 || stockTexto.length() == 0 || unidadMedida.length() == 0
                || nivelMinTexto.length() == 0 || proveedor.length() == 0) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }

        double stock;
        double nivelMin;
        try {
            stock = Double.parseDouble(stockTexto);
            nivelMin = Double.parseDouble(nivelMinTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Stock o nivel mínimo inválidos.");
            return;
        }

        if (ingredienteEnEdicion == null) {
            // Nuevo ingrediente
            controladorAdmin.registrarIngrediente(nombre, stock, unidadMedida, nivelMin, proveedor);
            JOptionPane.showMessageDialog(this, "Ingrediente registrado con éxito.");
        } else {
            int codigo = ingredienteEnEdicion.getCodigoIngrediente();
            boolean actualizado = controladorAdmin.actualizarIngrediente(
                    codigo, nombre, stock, unidadMedida, nivelMin, proveedor
            );
            if (!actualizado) {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el ingrediente.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Ingrediente actualizado con éxito.");
        }

        panelAdmin.recargarTablas();
        this.dispose();       
    }//GEN-LAST:event_btnguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNivelMinimo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
