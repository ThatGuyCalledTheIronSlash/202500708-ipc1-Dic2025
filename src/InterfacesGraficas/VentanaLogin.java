package InterfacesGraficas;

import ejemploestudiante.ControladorAdmin;
import ejemploestudiante.RepositorioEstudiante;
import ejemploestudiante.RepositorioBiblioteca;
import ejemploestudiante.RepositorioLibro;
import javax.swing.JOptionPane;


public class VentanaLogin extends javax.swing.JFrame {
    private final RepositorioBiblioteca repoBibliotecarios;
    private final RepositorioEstudiante repoEstudiantes;
    private final RepositorioLibro repoLibros; 
    
        public VentanaLogin(RepositorioBiblioteca repoBibliotecarios,RepositorioEstudiante repoEstudiantes,RepositorioLibro repoLibros) {
            initComponents();
            setLocationRelativeTo(null);
                this.repoBibliotecarios = repoBibliotecarios;
                this.repoEstudiantes = repoEstudiantes;
                this.repoLibros = repoLibros;
    }
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaLogin.class.getName());




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CampoUsuario = new javax.swing.JTextField();
        campocontrasena = new javax.swing.JPasswordField();
        iniciarsesion = new javax.swing.JButton();
        salirboton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USUARIO");

        jLabel2.setText("CONTRASEÑA");

        CampoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        campocontrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salirboton)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CampoUsuario)
                            .addComponent(campocontrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(iniciarsesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(104, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(campocontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniciarsesion)
                    .addComponent(salirboton))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarsesionActionPerformed
    String usuario = CampoUsuario.getText().trim();
    String contrasena = new String(campocontrasena.getPassword());

        if (usuario.equals("admin") && contrasena.equals("admin123")) {
            ControladorAdmin controladorAdmin = new ControladorAdmin(repoBibliotecarios, repoEstudiantes, repoLibros);   
                VentanaAdmin ventanaAdmin = new VentanaAdmin(controladorAdmin);
                ventanaAdmin.setVisible(true);
                this.dispose();
                return;
        }
        //buscar estudiante
        if (repoEstudiantes.encontrarEstudiante(usuario, contrasena)) {
            JOptionPane.showMessageDialog(this, "Bienvenido Estudiante: " + usuario);
            return;
        }
        //buscar bibliotecario
        if (repoBibliotecarios.encontrarBibliotecario(usuario, contrasena)) {
            JOptionPane.showMessageDialog(this, "Bienvenido Bibliotecario: " + usuario);
            return;
        }
        //nada coincide
        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
    }//GEN-LAST:event_iniciarsesionActionPerformed

    private void salirbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirbotonActionPerformed
            System.exit(0);
    
    }//GEN-LAST:event_salirbotonActionPerformed

    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JPasswordField campocontrasena;
    private javax.swing.JButton iniciarsesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton salirboton;
    // End of variables declaration//GEN-END:variables
}
