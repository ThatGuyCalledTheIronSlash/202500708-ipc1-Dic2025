
package InterfacesGraficas;

import Repositorios.RepositorioEstudiante;
import modelos.Estudiante;
import javax.swing.JOptionPane;

public class GestionarEstudiantes extends javax.swing.JDialog {
    
//==========================OBTENER ATRIBUTOS=======================    
    private RepositorioEstudiante repoEstudiantes;
    
    private Estudiante estudianteEditando;
    
//===========================CONSTRUCTORES=========================== 
    //Para Crear
    public GestionarEstudiantes(java.awt.Frame parent, boolean modal, RepositorioEstudiante repoEstudiantes) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.repoEstudiantes = repoEstudiantes;
        this.estudianteEditando = null;
        setTitle("Agregar Estudiante");
    }
    //Para Editar
    public GestionarEstudiantes(java.awt.Frame parent, boolean modal, RepositorioEstudiante repoEstudiantes, Estudiante estudiante) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.repoEstudiantes = repoEstudiantes;
        this.estudianteEditando = estudiante;
        setTitle("Modificar Estudiante");
        cargarDatosEnFormulario();
    }

//============================METODOS================================
    private void cargarDatosEnFormulario() {
        if (estudianteEditando == null) {
            return;
        }
            textoCarne.setText(estudianteEditando.getCarnet());
            textoNombre.setText(estudianteEditando.getNombre());
            textoCarrera.setText(estudianteEditando.getCarrera());
            textoSemestre.setText(String.valueOf(estudianteEditando.getSemestre()));
            textoUsuario.setText(estudianteEditando.getUsuario());
            textoCUI.setText(estudianteEditando.getCUI());
            textoCorreo.setText(estudianteEditando.getCorreo());
            textoGenero.setText(String.valueOf(estudianteEditando.getGenero()));
            textoTelefono.setText(String.valueOf(estudianteEditando.getTelefono()));
            textoEdad.setText(String.valueOf(estudianteEditando.getEdad()));
            textoEstadoCivil.setText(String.valueOf(estudianteEditando.getEstadoCivil()));
            textoContraseña.setText(estudianteEditando.getContrasena());
            
            textoCarne.setEnabled(false); //No cambia el Carnet
    }

    private void guardarEstudiante() {
        String carne = textoCarne.getText().trim();
        String nombre = textoNombre.getText().trim();
        String carrera = textoCarrera.getText().trim();
        String semestreTexto = textoSemestre.getText().trim();
        String usuario = textoUsuario.getText().trim();
        String contrasena = textoContraseña.getText().trim();
        String cui = textoCUI.getText().trim();
        String correo = textoCorreo.getText().trim();
        String generoTexto = textoGenero.getText().trim();
        String telefonoTexto = textoTelefono.getText().trim();
        String edadTexto = textoEdad.getText().trim();
        String estadoCivilTexto = textoEstadoCivil.getText().trim();
        
        
        //Validación de Campos Vacios
        if (carne.isEmpty() || nombre.isEmpty() || carrera.isEmpty()
                || semestreTexto.isEmpty() || usuario.isEmpty()
                || contrasena.isEmpty() || cui.isEmpty() || correo.isEmpty()
                || generoTexto.isEmpty() || telefonoTexto.isEmpty()
                || edadTexto.isEmpty() || estadoCivilTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

            int semestre;
            int telefono;
            int edad;
            
            //validación de ingreso de números
            try {
                semestre = Integer.parseInt(semestreTexto);
                telefono = Integer.parseInt(telefonoTexto);
                edad = Integer.parseInt(edadTexto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Semestre, telefono y edad deben ser numeros enteros.");
                return;
            }

                char genero = generoTexto.charAt(0);
                char estadoCivil = estadoCivilTexto.charAt(0);

        //validar carnet unico
            if (estudianteEditando == null && repoEstudiantes.buscarPorCarne(carne) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un estudiante con ese carnet.");
                return;
            }


        if (estudianteEditando == null) {
                    String facultad = "Ingenieria";
            Estudiante nuevo = new Estudiante(
                    carrera,
                    semestre,
                    facultad,
                    carne,     
                    nombre,
                    cui,
                    correo,
                    contrasena,
                    usuario,
                    genero,
                    telefono,
                    edad,
                    estadoCivil
            );
            repoEstudiantes.agregarEstudiante(nuevo);
            JOptionPane.showMessageDialog(this, "Estudiante agregado correctamente.");
        } else {
            // Editar estudiante existente
            estudianteEditando.setNombre(nombre);
            estudianteEditando.setCarrera(carrera);
            estudianteEditando.setSemestre(semestre);
            estudianteEditando.setUsuario(usuario);
            estudianteEditando.setCUI(cui);
            estudianteEditando.setCorreo(correo);
            estudianteEditando.setGenero(genero);
            estudianteEditando.setTelefono(telefono);
            estudianteEditando.setEdad(edad);
            estudianteEditando.setEstadoCivil(estadoCivil);
            estudianteEditando.setContrasena(contrasena);
            JOptionPane.showMessageDialog(this, "Estudiante modificado correctamente.");
        }

        dispose();
    } 

//-------------------------------------------------------------------
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoSemestre = new javax.swing.JTextField();
        textoCarrera = new javax.swing.JTextField();
        textoUsuario = new javax.swing.JTextField();
        textoCUI = new javax.swing.JTextField();
        textoCorreo = new javax.swing.JTextField();
        textoGenero = new javax.swing.JTextField();
        textoCarne = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        btnguardarnuevoestudiante = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        textoEstadoCivil = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textoEdad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textoContraseña = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Carnet");

        jLabel2.setText("Nombre");

        jLabel3.setText("Semestre");

        jLabel4.setText("Carrera");

        jLabel6.setText("Usuario");

        jLabel7.setText("CUI");

        jLabel8.setText("Correo");

        jLabel9.setText("Genero");

        textoSemestre.addActionListener(this::textoSemestreActionPerformed);

        btnguardarnuevoestudiante.setText("Guardar");
        btnguardarnuevoestudiante.addActionListener(this::btnguardarnuevoestudianteActionPerformed);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(this::cancelarActionPerformed);

        jLabel10.setText("Edad");

        textoTelefono.addActionListener(this::textoTelefonoActionPerformed);

        jLabel11.setText("Telefono");

        jLabel12.setText("Estado Civil");

        jLabel13.setText("Contraseña");

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
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(textoCarne)
                            .addComponent(textoCarrera)
                            .addComponent(textoSemestre)
                            .addComponent(textoUsuario)
                            .addComponent(textoCUI)
                            .addComponent(textoEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(textoEstadoCivil)
                            .addComponent(textoTelefono)
                            .addComponent(textoGenero)
                            .addComponent(textoCorreo)
                            .addComponent(textoContraseña, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnguardarnuevoestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoCUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textoEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(btnguardarnuevoestudiante))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//===========================BOTONES=================================
    private void textoSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoSemestreActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
            dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void btnguardarnuevoestudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarnuevoestudianteActionPerformed
            guardarEstudiante();
    }//GEN-LAST:event_btnguardarnuevoestudianteActionPerformed

    private void textoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoTelefonoActionPerformed

//====================================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardarnuevoestudiante;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textoCUI;
    private javax.swing.JTextField textoCarne;
    private javax.swing.JTextField textoCarrera;
    private javax.swing.JTextField textoContraseña;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoEdad;
    private javax.swing.JTextField textoEstadoCivil;
    private javax.swing.JTextField textoGenero;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoSemestre;
    private javax.swing.JTextField textoTelefono;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
