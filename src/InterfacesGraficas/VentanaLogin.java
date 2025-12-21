package InterfacesGraficas;

import Controladores.ControladorLogin;


public class VentanaLogin extends javax.swing.JFrame {
    private final ControladorLogin controladorLogin;
       
        public VentanaLogin(ControladorLogin controladorLogin) {
            this.controladorLogin = controladorLogin;
            initComponents();
            setLocationRelativeTo(null);
    }
        
//================== LIMPIAR ============================
    public void limpiarCampos() {
        CampoUsuario.setText("");
        campoContrasena.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CampoUsuario = new javax.swing.JTextField();
        campoContrasena = new javax.swing.JPasswordField();
        iniciarsesion = new javax.swing.JButton();
        salirboton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USUARIO");

        jLabel2.setText("CONTRASEÑA");

        CampoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        campoContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        iniciarsesion.setText("INICIAR SESION");
        iniciarsesion.addActionListener(this::iniciarsesionActionPerformed);

        salirboton.setText("Salir");
        salirboton.addActionListener(this::salirbotonActionPerformed);

        jLabel3.setBackground(new java.awt.Color(0, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BIBLIOTECA USAC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(iniciarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salirboton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(CampoUsuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel1)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(iniciarsesion)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salirboton)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//====================BOTONES=============================
    private void iniciarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarsesionActionPerformed
    String usuario = CampoUsuario.getText();
    String contrasena = new String(campoContrasena.getPassword());
         controladorLogin.iniciarSesion(usuario, contrasena);
    }//GEN-LAST:event_iniciarsesionActionPerformed

    private void salirbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirbotonActionPerformed
            System.exit(0);    
    }//GEN-LAST:event_salirbotonActionPerformed
//---------------------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JPasswordField campoContrasena;
    private javax.swing.JButton iniciarsesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton salirboton;
    // End of variables declaration//GEN-END:variables
}
