
package InterfacesGraficas;
import Repositorios.RepositorioLibro;
import modelos.Libro;
import javax.swing.JOptionPane;

public class GestionarLibros extends javax.swing.JDialog {
    
    private final RepositorioLibro repoLibros;
    private Libro libroEditando;
    
    public GestionarLibros(java.awt.Frame parent, boolean modal,RepositorioLibro repoLibros) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.repoLibros = repoLibros;
        this.libroEditando = null;
        setTitle("Agregar Libro");
    }
     public GestionarLibros(java.awt.Frame parent, boolean modal, RepositorioLibro repoLibros, Libro libro) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.repoLibros = repoLibros;
        this.libroEditando = libro;
        setTitle("Modificar Libro");
        cargarDatosEnFormulario();
    }
   //------------------------------------     
       private void cargarDatosEnFormulario() {
        if (libroEditando == null) {
            return;
        }
            textoISBN.setText(libroEditando.getISBN());
            textoTitulo.setText(libroEditando.getTitulo());
            textoAutor.setText(libroEditando.getAutor());
            textoEditorial.setText(libroEditando.getEditorial());
            textoAnio.setText(String.valueOf(libroEditando.getAnioPublicacion()));
            textoCategoria.setText(libroEditando.getCategoria());
            textoEjemplares.setText(String.valueOf(libroEditando.getCantidad()));
            textoUbicacion.setText(libroEditando.getUbicacion());
            textoDesc.setText(libroEditando.getDescripcion());
            textoISBN.setEnabled(false);
    }
    //------------------------------------
    private void guardarLibro() {
        String isbn = textoISBN.getText().trim();
        String titulo = textoTitulo.getText().trim();
        String autor = textoAutor.getText().trim();
        String editorial = textoEditorial.getText().trim();
        String anioTexto = textoAnio.getText().trim();
        String categoria = textoCategoria.getText().trim();
        String cantidadTexto = textoEjemplares.getText().trim();
        String ubicacion = textoUbicacion.getText().trim();
        String descripcion = textoDesc.getText().trim();
        
        //validar que no haya campos vacios
        if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty()
                || editorial.isEmpty() || anioTexto.isEmpty()
                || categoria.isEmpty() || cantidadTexto.isEmpty()
                || ubicacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos (excepto descripcion) son obligatorios.");
            return;
        }

        int anio;
        int cantidad;
        //Validar que se ingresen numeros
        try {
            anio = Integer.parseInt(anioTexto);
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Año y cantidad deben ser numeros enteros.");
            return;
        }
        //Evitar cantidades negativas de ejemplares
        if (cantidad < 0) {
            JOptionPane.showMessageDialog(this, "La cantidad no puede ser negativa.");
                return;
        }

        // Verificar ISBN
        if (libroEditando == null && repoLibros.verificarLibro(isbn)) {
            JOptionPane.showMessageDialog(this, "Ya existe un libro con ese ISBN.");
                return;
        }
         // Crear nuevo libro
        if (libroEditando == null) {  
            Libro nuevo = new Libro(isbn, titulo, autor, editorial,
                    anio, categoria, cantidad, ubicacion, descripcion);
            repoLibros.agregarLibro(nuevo);
            JOptionPane.showMessageDialog(this, "Libro agregado correctamente.");
        } else {
            
            // Editar libro existente
            libroEditando.setTitulo(titulo);
            libroEditando.setAutor(autor);
            libroEditando.setEditorial(editorial);
            libroEditando.setAnioPublicacion(anio);
            libroEditando.setCategoria(categoria);
            libroEditando.setCantidad(cantidad);
            libroEditando.setUbicacion(ubicacion);
            libroEditando.setDescripcion(descripcion);
            JOptionPane.showMessageDialog(this, "Libro modificado correctamente.");
        }

        dispose();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoEditorial = new javax.swing.JTextField();
        textoAutor = new javax.swing.JTextField();
        textoAnio = new javax.swing.JTextField();
        textoEjemplares = new javax.swing.JTextField();
        textoCategoria = new javax.swing.JTextField();
        textoUbicacion = new javax.swing.JTextField();
        textoDesc = new javax.swing.JTextField();
        textoISBN = new javax.swing.JTextField();
        textoTitulo = new javax.swing.JTextField();
        btnguardarnuevolibro = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ISBN");

        jLabel2.setText("Titulo");

        jLabel3.setText("Editorial");

        jLabel4.setText("Autor");

        jLabel5.setText("Categoria");

        jLabel6.setText("Año");

        jLabel7.setText("Ejemplares");

        jLabel8.setText("Ubicación");

        jLabel9.setText("Descripción ");

        textoEditorial.addActionListener(this::textoEditorialActionPerformed);

        btnguardarnuevolibro.setText("Guardar");
        btnguardarnuevolibro.addActionListener(this::btnguardarnuevolibroActionPerformed);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(this::cancelarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnguardarnuevolibro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(textoISBN)
                        .addComponent(textoAutor)
                        .addComponent(textoEditorial)
                        .addComponent(textoAnio)
                        .addComponent(textoCategoria)
                        .addComponent(textoEjemplares)
                        .addComponent(textoUbicacion)
                        .addComponent(textoDesc)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textoUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(btnguardarnuevolibro))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoEditorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoEditorialActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
            dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void btnguardarnuevolibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarnuevolibroActionPerformed
            guardarLibro();
    }//GEN-LAST:event_btnguardarnuevolibroActionPerformed
//-------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardarnuevolibro;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textoAnio;
    private javax.swing.JTextField textoAutor;
    private javax.swing.JTextField textoCategoria;
    private javax.swing.JTextField textoDesc;
    private javax.swing.JTextField textoEditorial;
    private javax.swing.JTextField textoEjemplares;
    private javax.swing.JTextField textoISBN;
    private javax.swing.JTextField textoTitulo;
    private javax.swing.JTextField textoUbicacion;
    // End of variables declaration//GEN-END:variables
}
