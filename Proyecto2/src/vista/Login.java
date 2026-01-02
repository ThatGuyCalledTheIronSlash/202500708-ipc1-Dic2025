package vista;

import controlador.ControladorLogin;
import controlador.ControladorAdmin;
import vista.admin.PanelAdmin;
import vista.cajero.PanelCajero;
import modelo.gestores.GestorClientes;
import modelo.gestores.GestorEmpleados;
import modelo.gestores.GestorProductos;
import modelo.gestores.GestorInventario;
import modelo.gestores.GestorSucursales;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    private ControladorLogin controladorLogin;

    
    //===================CONSTRUCTOR========================
    public Login(){
        initComponents();
        GestorEmpleados gestorEmpleados = new GestorEmpleados();
        GestorClientes gestorClientes = new GestorClientes();
        GestorProductos gestorProductos = new GestorProductos();
        GestorInventario gestorInventario = new GestorInventario();
        GestorSucursales gestorSucursales = new GestorSucursales();
        controladorLogin = new ControladorLogin(gestorEmpleados, gestorClientes, gestorProductos, gestorInventario, gestorSucursales);
        this.setLocationRelativeTo(null);    
    }

    
    //=================SETTERS Y GETTERS=============
    public void setControlador(ControladorLogin controlador) {
        this.controladorLogin = controlador;
    }

    public String getUsuarioIngresado() {
        return txtUsuario.getText();
    }

    public String getContrasenaIngresada() {
        char[] pass = txtContrasena.getPassword();
        return new String(pass);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }   
 
//---------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        txtContrasena = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("CONTRASEÑA");

        jLabel2.setText("USUARIO");

        jLabel4.setText("¡BIENVENIDO!");

        btnIniciarSesion.setText("INICIAR SESION");
        btnIniciarSesion.addActionListener(this::btnIniciarSesionActionPerformed);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(31, 31, 31)
                        .addComponent(btnIniciarSesion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(247, 247, 247))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1)))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel4)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIniciarSesion)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        String rol = controladorLogin.iniciarSesion(usuario, contrasena);

        if (rol == null) {
             JOptionPane.showMessageDialog(this, "Credenciales inválidas");
             return;
        }

        JOptionPane.showMessageDialog(this,
                "Inicio de sesión correcto. Rol: " + rol,
                "Información",
                JOptionPane.INFORMATION_MESSAGE);

        if (rol.equals("ADMIN")) {
            ControladorAdmin controladorAdmin = controladorLogin.getControladorAdmin();
                PanelAdmin admin = new PanelAdmin(controladorAdmin);
                admin.setVisible(true);
                this.dispose();
        } else if (rol.equals("CAJERO")) {
                PanelCajero panel = new PanelCajero(controladorLogin.getControladorCajero());
                panel.setVisible(true);
                this.dispose();
        } else if (rol.equals("CLIENTE")) {
          //Pendiente
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

      
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);      
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
