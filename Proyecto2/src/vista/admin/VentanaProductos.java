package vista.admin;

import controlador.ControladorAdmin;
import modelo.Producto;
import javax.swing.JOptionPane;

public class VentanaProductos extends javax.swing.JFrame {

    private ControladorAdmin controladorAdmin;
    private PanelAdmin panelAdmin;
    private Producto productoEnEdicion;

    // Nuevo producto
    public VentanaProductos(ControladorAdmin controladorAdmin, PanelAdmin panelAdmin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controladorAdmin = controladorAdmin;
        this.panelAdmin = panelAdmin;
        this.productoEnEdicion = null;

        txtCodigo.setEditable(false);
        txtCodigo.setText("");
    }

    // Editar producto 
    public VentanaProductos(ControladorAdmin controladorAdmin, PanelAdmin panelAdmin, Producto producto) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controladorAdmin = controladorAdmin;
        this.panelAdmin = panelAdmin;
        this.productoEnEdicion = producto;

        txtCodigo.setEditable(false);
        cargarDatosProducto();
    }

    private void cargarDatosProducto() {
        if (productoEnEdicion != null) {
            txtCodigo.setText(String.valueOf(productoEnEdicion.getCodigoProducto()));
            txtNombre.setText(productoEnEdicion.getNombre());
            txtDescripcion.setText(productoEnEdicion.getDescripcion());
            txtCategoria.setText(productoEnEdicion.getCategoria());
            txtPrecio.setText(String.valueOf(productoEnEdicion.getPrecio()));
            txtTiempoPrep.setText(String.valueOf(productoEnEdicion.getTiempoPreparacion()));
            chkDisponible.setSelected(productoEnEdicion.isDisponible());
        }
    }
  
//----------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtTiempoPrep = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        chkDisponible = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("PRECIO");

        jLabel10.setText("T. PREPARACION");

        jLabel5.setText("CATEGORIA");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(this::btnguardarActionPerformed);

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(this::btncancelarActionPerformed);

        jLabel2.setText("CODIGO");

        jLabel3.setText("NOMBRE");

        jLabel1.setText("DESCRIPCION");

        jLabel6.setText("DISPONIBILIDAD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
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
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTiempoPrep, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkDisponible)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btncancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btnguardar))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTiempoPrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkDisponible)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncancelar)
                    .addComponent(btnguardar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            String categoria = txtCategoria.getText();
            String precioTexto = txtPrecio.getText();
            String tiempoTexto = txtTiempoPrep.getText();
            boolean disponible = chkDisponible.isSelected();

            if (nombre.length() == 0 || descripcion.length() == 0 || categoria.length() == 0 ||
                precioTexto.length() == 0 || tiempoTexto.length() == 0) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            double precio;
            int tiempoPrep;
            try {
                precio = Double.parseDouble(precioTexto);
                tiempoPrep = Integer.parseInt(tiempoTexto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Precio o tiempo de preparación inválidos.");
                return;
            }

            if (productoEnEdicion == null) {
                // Nuevo
                controladorAdmin.registrarProducto(nombre, descripcion, categoria, precio, tiempoPrep, disponible);
                JOptionPane.showMessageDialog(this, "Producto registrado con éxito.");
            } else {
                int codigo = productoEnEdicion.getCodigoProducto();
                boolean actualizado = controladorAdmin.actualizarProducto(
                        codigo, nombre, descripcion, categoria, precio, tiempoPrep, disponible
                );
                if (!actualizado) {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el producto.");
                    return;
                }
                JOptionPane.showMessageDialog(this, "Producto actualizado con éxito.");
            }

            panelAdmin.recargarTablas();
            this.dispose();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JCheckBox chkDisponible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTiempoPrep;
    // End of variables declaration//GEN-END:variables
}
