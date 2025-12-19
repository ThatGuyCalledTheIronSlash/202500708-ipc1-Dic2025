
package InterfacesGraficas;

import Repositorios.RepositorioBiblioteca;
import modelos.Bibliotecario;
import javax.swing.JOptionPane;

public class GestionarBibliotecarios extends javax.swing.JDialog {
    
    private final RepositorioBiblioteca repoBiblioteca;
    private Bibliotecario bibliotecarioEditando;
//--
    public GestionarBibliotecarios(java.awt.Frame parent, boolean modal,RepositorioBiblioteca repoBiblioteca) {
            super(parent, modal);
            this.repoBiblioteca = repoBiblioteca;
            this.bibliotecarioEditando = null;
            initComponents();
            setLocationRelativeTo(parent);
            setTitle("Agregar Bibliotecario");
            
            String nuevoID = repoBiblioteca.generarNuevoID();
            textoIDEmpleado.setText(nuevoID);
            textoIDEmpleado.setEnabled(false);

    }
//--
    public GestionarBibliotecarios(java.awt.Frame parent, boolean modal,RepositorioBiblioteca repoBiblioteca,
        Bibliotecario bibliotecarioEditar) {
            super(parent, modal);
            this.repoBiblioteca = repoBiblioteca;
            this.bibliotecarioEditando = bibliotecarioEditar;
            initComponents();
            setLocationRelativeTo(parent);
            setTitle("Modificar Bibliotecario");
            
            String nuevoID = repoBiblioteca.generarNuevoID();
            textoIDEmpleado.setText(nuevoID);
            textoIDEmpleado.setEnabled(false);
            cargarDatosEnFormulario();
    }
//--
    private void cargarDatosEnFormulario() {
        if (bibliotecarioEditando == null) {
            return;
        }
                textoIDEmpleado.setText(bibliotecarioEditando.getIDEmpleado());
                textoNombre.setText(bibliotecarioEditando.getNombre());
                textoUsuario.setText(bibliotecarioEditando.getUsuario());
                textoContrasena.setText(bibliotecarioEditando.getContrasena());
                textoCUI.setText(bibliotecarioEditando.getCUI());
                textoCorreo.setText(bibliotecarioEditando.getCorreo());
                textoTurno.setText(bibliotecarioEditando.getTurno());
                textoTelefono.setText(String.valueOf(bibliotecarioEditando.getTelefono()));
                textoGenero.setText(String.valueOf(bibliotecarioEditando.getGenero()));
                textoEstadoCivil.setText(String.valueOf(bibliotecarioEditando.getEstadoCivil()));
                textoSalario.setText(String.valueOf(bibliotecarioEditando.getSalario()));

                    textoIDEmpleado.setEnabled(false);
            }
//--
    private void guardarBibliotecario() {
        String idEmpleado = textoIDEmpleado.getText().trim();
        String nombre = textoNombre.getText().trim();
        String usuario = textoUsuario.getText().trim();
        String contrasena = textoContrasena.getText().trim();
        String cui = textoCUI.getText().trim();
        String correo = textoCorreo.getText().trim();
        String turno = textoTurno.getText().trim();
        String generoTexto = textoGenero.getText().trim();
        String telefonoTexto = textoTelefono.getText().trim();
        String salarioTexto = textoSalario.getText().trim();
        String estadoCivilTexto = textoEstadoCivil.getText().trim();
        
            //Validación de campos vacios
            if (idEmpleado.isEmpty() || nombre.isEmpty() || usuario.isEmpty()
                   || contrasena.isEmpty() || cui.isEmpty() || correo.isEmpty()
                   || turno.isEmpty() || generoTexto.isEmpty()
                   || telefonoTexto.isEmpty() || salarioTexto.isEmpty()
                   || estadoCivilTexto.isEmpty()) {
               JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
           }
                int telefono;
                double salario;
                //validación de que se ingresen números
                try {
                    telefono = Integer.parseInt(telefonoTexto);
                    salario = Double.parseDouble(salarioTexto);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this,
                            "Telefono y salario deben ser números válidos.");
                    return;
                }

        char genero = generoTexto.charAt(0);
        char estadoCivil = estadoCivilTexto.charAt(0);

        // validar ID único
            if (bibliotecarioEditando == null
                    && repoBiblioteca.retornarBibliotecario(idEmpleado) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un bibliotecario con ese ID.");
                return;
            }
        
            String areaTrabajo = "Area";

        if (bibliotecarioEditando == null) {
            Bibliotecario nuevo = new Bibliotecario(
                idEmpleado,
                turno,
                areaTrabajo,
                nombre,
                cui,
                correo,
                usuario,
                contrasena,
                genero,
                telefono,
                estadoCivil,
                salario
            );
            
            repoBiblioteca.agregarBibliotecarios(nuevo);
                JOptionPane.showMessageDialog(this, "Bibliotecario agregado correctamente.");
                    } else {
                        // Editar existente
                        bibliotecarioEditando.setNombre(nombre);
                        bibliotecarioEditando.setUsuario(usuario);
                        bibliotecarioEditando.setContrasena(contrasena);
                        bibliotecarioEditando.setCUI(cui);
                        bibliotecarioEditando.setCorreo(correo);
                        bibliotecarioEditando.setTurno(turno);
                        bibliotecarioEditando.setTelefono(telefono);
                        bibliotecarioEditando.setSalario(salario);
                        bibliotecarioEditando.setGenero(genero);
                        bibliotecarioEditando.setEstadoCivil(estadoCivil);

                        JOptionPane.showMessageDialog(this, "Bibliotecario modificado correctamente.");
                    }

                    dispose();
                }
//--
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoContrasena = new javax.swing.JTextField();
        textoUsuario = new javax.swing.JTextField();
        textoCUI = new javax.swing.JTextField();
        textoCorreo = new javax.swing.JTextField();
        textoTurno = new javax.swing.JTextField();
        textoIDEmpleado = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        btnguardarnuevoestudiante = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        textoEstadoCivil = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textoSalario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        textoGenero = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        jLabel3.setText("Contraseña");

        jLabel4.setText("Usuario");

        jLabel7.setText("CUI");

        jLabel8.setText("Correo");

        jLabel9.setText("Turno");

        textoContrasena.addActionListener(this::textoContrasenaActionPerformed);

        btnguardarnuevoestudiante.setText("Guardar");
        btnguardarnuevoestudiante.addActionListener(this::btnguardarnuevoestudianteActionPerformed);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(this::cancelarActionPerformed);

        textoTelefono.addActionListener(this::textoTelefonoActionPerformed);

        jLabel11.setText("Telefono");

        jLabel12.setText("Estado Civil");

        jLabel13.setText("Salario");

        jLabel14.setText("Genero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoNombre)
                            .addComponent(textoIDEmpleado)
                            .addComponent(textoUsuario)
                            .addComponent(textoContrasena)
                            .addComponent(textoCUI)
                            .addComponent(textoEstadoCivil)
                            .addComponent(textoTelefono)
                            .addComponent(textoTurno)
                            .addComponent(textoCorreo)
                            .addComponent(textoGenero)
                            .addComponent(textoSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnguardarnuevoestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textoEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textoSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(btnguardarnuevoestudiante))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//--
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
            dispose();
    }//GEN-LAST:event_cancelarActionPerformed
//--
    private void btnguardarnuevoestudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarnuevoestudianteActionPerformed
            guardarBibliotecario();
    }//GEN-LAST:event_btnguardarnuevoestudianteActionPerformed
//--
    private void textoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTelefonoActionPerformed

    }//GEN-LAST:event_textoTelefonoActionPerformed

    private void textoContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoContrasenaActionPerformed

    }//GEN-LAST:event_textoContrasenaActionPerformed
//-------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardarnuevoestudiante;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textoCUI;
    private javax.swing.JTextField textoContrasena;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoEstadoCivil;
    private javax.swing.JTextField textoGenero;
    private javax.swing.JTextField textoIDEmpleado;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoSalario;
    private javax.swing.JTextField textoTelefono;
    private javax.swing.JTextField textoTurno;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
