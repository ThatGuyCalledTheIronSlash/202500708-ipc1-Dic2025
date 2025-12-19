
package InterfacesGraficas;

import modelos.Libro;
import modelos.Estudiante;

import Controladores.ControladorAdmin;


public class VentanaBibliotecario extends javax.swing.JFrame {
        private javax.swing.table.DefaultTableModel modeloLibros; 
        private javax.swing.table.DefaultTableModel modeloEstudiantes;
        private javax.swing.table.DefaultTableModel modeloBibliotecarios;

    private final ControladorAdmin controladorAdmin;
    
        public VentanaBibliotecario(ControladorAdmin controladorAdmin) {
            initComponents();
                this.controladorAdmin = controladorAdmin;  
                    setLocationRelativeTo(null);
                //Configurar las tablas
                    configurarTablaLibros();
                    configurarTablaEstudiantes();
                //Cargar
                    cargarlibrosalatabla();
                    cargarestudiantesalatabla();
                    actualizarDashboard();
        }
//-ConfigurarTablas
private void configurarTablaEstudiantes(){
    modeloEstudiantes = new javax.swing.table.DefaultTableModel(
        new Object[] {
            "Carnet", "Nombre", "Usuario", "Carrera", "Semestre","Facultad",  
            "CUI", "Correo", "Género", "Teléfono", "Edad", "Estado"
            },
        0
    );
    TablaEstudiantes.setModel(modeloEstudiantes);
        cargarestudiantesalatabla(); //Recarga automaticamente la tabla;
}
//--
private void configurarTablaLibros() {
    modeloLibros = new javax.swing.table.DefaultTableModel(
        new Object[] {"ISBN", "Titulo", "Autor", "Editorial", "Año", "Categoria", "Cantidad", "Ubicacion"},
        0
    );
    TablaLibros.setModel(modeloLibros);
        cargarlibrosalatabla(); //Recarga automaticamente la tabla
}
//--Actualizar el Dashboard
private void actualizarDashboard() {
    int totalLibros = controladorAdmin.contarLibros();
    int totalEstudiantes = controladorAdmin.contarEstudiantes();  
        lblTotalLibros.setText(String.valueOf(totalLibros));
        lblTotalEstudiantes.setText(String.valueOf(totalEstudiantes));
}
//--
public void cargarPerfil(modelos.Bibliotecario bib) {
    if (bib == null) return;
        textobibliotecario.setText(bib.getNombre());
}
//CargarTablas con datos
private void cargarlibrosalatabla(){
    modeloLibros.setRowCount(0);     //limpia las filas anteriores
        
        Libro[] libros = controladorAdmin.getRepoLibros().todosLosLibros();

        if (libros != null) {
            for (Libro libro : libros) {
                if (libro != null) {
                    Object[] fila = new Object[] {
                        libro.getISBN(),
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getEditorial(),
                        libro.getAnioPublicacion(),
                        libro.getCategoria(),
                        libro.getCantidad(),
                        libro.getUbicacion()
                    };
                    modeloLibros.addRow(fila); 
                }
            }
        }
    }
//--
private void cargarlibrosalatablaconparametro(Libro[] libros){  //Sirve para los ordenamientos(considere mejor simplemente crear una copia)
    modeloLibros.setRowCount(0); // limpia las filas anteriores
    
        if (libros != null) {
            for (Libro libro : libros) {
                if (libro != null) {
                    Object[] fila = new Object[] {
                        libro.getISBN(),
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getEditorial(),
                        libro.getAnioPublicacion(),
                        libro.getCategoria(),
                        libro.getCantidad(),
                        libro.getUbicacion()
                    };
                    modeloLibros.addRow(fila);
                }
            }
        }
    }
//--
private void cargarestudiantesalatabla(){
    modeloEstudiantes.setRowCount(0);  //Limpia las filas anteriores

        Estudiante[] estudiantes = controladorAdmin.getRepoEstudiantes().todoslosestudiantes();
    
        if (estudiantes != null) {
            for (Estudiante est : estudiantes) {
                if (est != null) {
                    Object[] fila = new Object[] {
                        est.getCarnet(),
                        est.getNombre(),
                        est.getUsuario(),
                        est.getCarrera(),
                        est.getSemestre(),
                        est.getFacultad(),
                        est.getCUI(),
                        est.getCorreo(),
                        est.getGenero(),
                        est.getTelefono(),
                        est.getEdad(),
                        est.getEstadoCivil()
                    };
                    modeloEstudiantes.addRow(fila);
                }
            }
        }
    }
//--
private void cargarestudiantesalatablaConParametro(Estudiante[] estudiantes) {
    modeloEstudiantes.setRowCount(0); // Limpia las filas anteriores
        if (estudiantes == null) {
            return;
        }

        for (Estudiante est : estudiantes) {
            if (est != null) {
                Object[] fila = new Object[] {
                    est.getCarnet(),
                    est.getNombre(),
                    est.getUsuario(),
                    est.getCarrera(),
                    est.getSemestre(),
                    est.getFacultad(),
                    est.getCUI(),
                    est.getCorreo(),
                    est.getGenero(),
                    est.getTelefono(),
                    est.getEdad(),
                    est.getEstadoCivil()
                };
                modeloEstudiantes.addRow(fila);
            }
        }
    }
//--
public void recargarTodo() {
    cargarlibrosalatabla();
    cargarestudiantesalatabla();
    actualizarDashboard();
}
//----------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        vistaprevia1 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        TextoBibliotecario = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblTotalLibros = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblTotalEstudiantes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textobibliotecario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaLibros = new javax.swing.JTable();
        btnrecargarlibros = new javax.swing.JButton();
        textobuscarlibros = new javax.swing.JTextField();
        seleciltroslibros = new javax.swing.JComboBox<>();
        btnbscarlibro = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TablaEstudiantes = new javax.swing.JTable();
        btnrecargarestudiantes = new javax.swing.JButton();
        textobuscarestudiante = new javax.swing.JTextField();
        btnbuscarestudiante = new javax.swing.JButton();
        btncerrarsesion = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("SISTEMA BIBLIOTECA");

        jPanel9.setBackground(new java.awt.Color(0, 153, 255));
        jPanel9.setForeground(new java.awt.Color(51, 153, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("TOTAL LIBROS");

        lblTotalLibros.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalLibros.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalLibros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalLibros.setText("jLabel11");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(lblTotalLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(14, 14, 14))
        );

        jPanel10.setBackground(new java.awt.Color(0, 153, 255));
        jPanel10.setForeground(new java.awt.Color(51, 153, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("TOTAL ESTUDIANTES");

        lblTotalEstudiantes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalEstudiantes.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalEstudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalEstudiantes.setText("jLabel11");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lblTotalEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(lblTotalEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(14, 14, 14))
        );

        jLabel1.setText("BIENVENIDO");

        textobibliotecario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TextoBibliotecarioLayout = new javax.swing.GroupLayout(TextoBibliotecario);
        TextoBibliotecario.setLayout(TextoBibliotecarioLayout);
        TextoBibliotecarioLayout.setHorizontalGroup(
            TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextoBibliotecarioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextoBibliotecarioLayout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addGroup(TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextoBibliotecarioLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextoBibliotecarioLayout.createSequentialGroup()
                        .addComponent(textobibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274))))
        );
        TextoBibliotecarioLayout.setVerticalGroup(
            TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextoBibliotecarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textobibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(281, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dashboard", TextoBibliotecario);

        TablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Titulo", "Autor", "Editorial", "Año", "Categoria", "Cantidad", "Ubicación"
            }
        ));
        jScrollPane6.setViewportView(TablaLibros);

        btnrecargarlibros.setText("Refrescar");
        btnrecargarlibros.addActionListener(this::btnrecargarlibrosActionPerformed);

        textobuscarlibros.addActionListener(this::textobuscarlibrosActionPerformed);

        seleciltroslibros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Titulo", "Autor", "Año", "Editorial" }));
        seleciltroslibros.addActionListener(this::seleciltroslibrosActionPerformed);

        btnbscarlibro.setText("Buscar");
        btnbscarlibro.addActionListener(this::btnbscarlibroActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnrecargarlibros)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(textobuscarlibros, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seleciltroslibros, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbscarlibro)
                        .addGap(121, 121, 121))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textobuscarlibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleciltroslibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbscarlibro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnrecargarlibros)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Libros", jPanel3);

        TablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Carnet", "Nombre", "Usuario", "Carrera", "Semestre", "Facultad", "CUI", "Correo", "Genero", "Telefono", "Edad", "Estado"
            }
        ));
        jScrollPane9.setViewportView(TablaEstudiantes);

        btnrecargarestudiantes.setText("Refrescar");
        btnrecargarestudiantes.addActionListener(this::btnrecargarestudiantesActionPerformed);

        btnbuscarestudiante.setText("Buscar");
        btnbuscarestudiante.addActionListener(this::btnbuscarestudianteActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(textobuscarestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscarestudiante))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(btnrecargarestudiantes)
                            .addGap(40, 40, 40))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscarestudiante)
                    .addComponent(textobuscarestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnrecargarestudiantes)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estudiantes", jPanel4);

        btncerrarsesion.setText("Cerrar Sesión");
        btncerrarsesion.addActionListener(this::btncerrarsesionActionPerformed);

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Gestión");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncerrarsesion))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncerrarsesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//--
    private void btnrecargarestudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecargarestudiantesActionPerformed
        cargarestudiantesalatabla();
    }//GEN-LAST:event_btnrecargarestudiantesActionPerformed
//--
    private void btnrecargarlibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecargarlibrosActionPerformed
        cargarlibrosalatabla();
    }//GEN-LAST:event_btnrecargarlibrosActionPerformed
//--
    private void btncerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarsesionActionPerformed
        controladorAdmin.cerrarSesion();
    }//GEN-LAST:event_btncerrarsesionActionPerformed
//--
    private void textobuscarlibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textobuscarlibrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textobuscarlibrosActionPerformed
//--
    private void btnbscarlibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbscarlibroActionPerformed
        String texto = textobuscarlibros.getText();

            Libro[] resultados = controladorAdmin.buscarLibros(texto, "titulo");

                cargarlibrosalatablaconparametro(resultados);
    }//GEN-LAST:event_btnbscarlibroActionPerformed
//--
    private void seleciltroslibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleciltroslibrosActionPerformed
        String opcion = seleciltroslibros.getSelectedItem().toString();
           Libro[] listaOrdenada = null;
                switch (opcion) {
                    case "ISBN":
                        listaOrdenada = controladorAdmin.ordenarLibros_ISBN_Burbuja();
                        break;
                    case "Titulo":
                        listaOrdenada = controladorAdmin.ordenarLibros_Titulo_Seleccion();
                        break;
                    case "Autor":
                        listaOrdenada = controladorAdmin.ordenarLibros_Autor_Insercion();
                        break;
                    case "Editorial":
                        listaOrdenada = controladorAdmin.ordenarLibros_Editorial_QuickSort();
                        break;
                    case "Año":
                        listaOrdenada = controladorAdmin.ordenarLibros_Anio_MergeSort();
                        break;
                }

                if (listaOrdenada != null) {
                    cargarlibrosalatablaconparametro(listaOrdenada);
            }
    }//GEN-LAST:event_seleciltroslibrosActionPerformed

    private void btnbuscarestudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarestudianteActionPerformed
        String texto = textobuscarestudiante.getText();
        Estudiante[] lista = controladorAdmin.buscarEstudiantes(texto);
        cargarestudiantesalatablaConParametro(lista);
    }//GEN-LAST:event_btnbuscarestudianteActionPerformed
//============================================
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEstudiantes;
    private javax.swing.JTable TablaLibros;
    private javax.swing.JPanel TextoBibliotecario;
    private javax.swing.JButton btnbscarlibro;
    private javax.swing.JButton btnbuscarestudiante;
    private javax.swing.JButton btncerrarsesion;
    private javax.swing.JButton btnrecargarestudiantes;
    private javax.swing.JButton btnrecargarlibros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTotalEstudiantes;
    private javax.swing.JLabel lblTotalLibros;
    private javax.swing.JComboBox<String> seleciltroslibros;
    private javax.swing.JLabel textobibliotecario;
    private javax.swing.JTextField textobuscarestudiante;
    private javax.swing.JTextField textobuscarlibros;
    private javax.swing.JScrollPane vistaprevia1;
    // End of variables declaration//GEN-END:variables
}