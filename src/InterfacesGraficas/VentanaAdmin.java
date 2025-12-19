
package InterfacesGraficas;

import modelos.Libro;
import modelos.Estudiante;
import modelos.Bibliotecario;
import Controladores.ControladorAdmin;
import javax.swing.JOptionPane;


public class VentanaAdmin extends javax.swing.JFrame {
        private javax.swing.table.DefaultTableModel modeloLibros; 
        private javax.swing.table.DefaultTableModel modeloEstudiantes;
        private javax.swing.table.DefaultTableModel modeloBibliotecarios;

    private final ControladorAdmin controladorAdmin;
    
        public VentanaAdmin(ControladorAdmin controladorAdmin) {
            initComponents();
                this.controladorAdmin = controladorAdmin;  
                setLocationRelativeTo(null);
                //Configurar
                    configurarTablaLibros();
                    configurarTablaEstudiantes();
                    configurarTablaBibliotecarios();
                //Cargar
                    cargarlibrosalatabla();
                    cargarestudiantesalatabla();
                    cargarbibliotecariosalatabla();
                    actualizarDashboard();
                

        }
//---------ConfigurarTablas---------
private void configurarTablaEstudiantes(){
    modeloEstudiantes = new javax.swing.table.DefaultTableModel(
        new Object[] {
            "Carnet", "Nombre", "Usuario", "Carrera", "Semestre",
            "Facultad", "CUI", "Correo", "Género", "Teléfono", "Edad", "Estado"
        },
        0
    );
    TablaEstudiantes.setModel(modeloEstudiantes);
    cargarestudiantesalatabla(); //Recarga automaticamente la tabla;
}

private void configurarTablaLibros() {
    modeloLibros = new javax.swing.table.DefaultTableModel(
        new Object[] {"ISBN", "Titulo", "Autor", "Editorial", "Año", "Categoria", "Cantidad", "Ubicacion"},
        0
    );
    TablaLibros.setModel(modeloLibros);
    cargarlibrosalatabla(); //Recarga automaticamente la tabla
}

private void configurarTablaBibliotecarios() {
    modeloBibliotecarios = new javax.swing.table.DefaultTableModel(
        new Object[] {
            "ID", "Nombre", "Usuario", "CUI", "Turno",
            "Área Trabajo", "Teléfono", "Salario", "Estado"
        },
        0
    );
    TablaBibliotecarios.setModel(modeloBibliotecarios);
    cargarbibliotecariosalatabla(); //Recarga automaticamente la tabla
}

//--Actualizar el Dashboard
private void actualizarDashboard() {

    int totalLibros = controladorAdmin.contarLibros();
    int totalEstudiantes = controladorAdmin.contarEstudiantes();
    int totalBibliotecarios = controladorAdmin.contarBibliotecarios();
    
    lblTotalLibros.setText(String.valueOf(totalLibros));
    lblTotalEstudiantes.setText(String.valueOf(totalEstudiantes));
    lblTotalBibliotecarios.setText(String.valueOf(totalBibliotecarios));
}

//----------CargarTablas------------
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

private void cargarlibrosalatablaconparametro(Libro[] libros){
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

private void cargarestudiantesalatabla(){
    modeloEstudiantes.setRowCount(0);

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

private void cargarbibliotecariosalatabla(){
   modeloBibliotecarios.setRowCount(0);
    Bibliotecario[] bibliotecarios = controladorAdmin.getRepoBibliotecarios().todosLosBibliotecarios();
    if (bibliotecarios != null) {
        for (Bibliotecario bib : bibliotecarios) {
            if (bib != null) {
                Object[] fila = new Object[] {
                    bib.getIDEmpleado(),
                    bib.getNombre(),
                    bib.getUsuario(),
                    bib.getCUI(),
                    bib.getTurno(),
                    bib.getAreaTrabajo(),
                    bib.getTelefono(),
                    bib.getSalario(),
                    bib.getEstadoCivil()
                };
                modeloBibliotecarios.addRow(fila);
            }
        }
    } 
}

//----------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        vistaprevia1 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblTotalLibros = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblTotalEstudiantes = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblTotalBibliotecarios = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaBibliotecarios = new javax.swing.JTable();
        btnrecargarpaginabibliotecario = new javax.swing.JButton();
        btndesactivarbibliotecario = new javax.swing.JButton();
        btnmodificarbibliotecario = new javax.swing.JButton();
        btnagregarbibliotecario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaLibros = new javax.swing.JTable();
        btnagregarlibro = new javax.swing.JButton();
        btnBorrarLibro = new javax.swing.JButton();
        btnModificarLibro = new javax.swing.JButton();
        btnrecargarlibros = new javax.swing.JButton();
        textobuscarlibros = new javax.swing.JTextField();
        seleciltroslibros = new javax.swing.JComboBox<>();
        btnbscarlibro = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnagregarestudiante = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        TablaEstudiantes = new javax.swing.JTable();
        btnrecargarestudiantes = new javax.swing.JButton();
        btnDeshabilitarEstudiante = new javax.swing.JButton();
        btnModificarEstudiante = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vistaResultado = new javax.swing.JTextArea();
        vistaprevia = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Iniciarcargalibros = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botoncargarestudiantes = new javax.swing.JButton();
        vistaprevia2 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        vistaResultado2 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botoncargarbibliotecarios = new javax.swing.JButton();
        vistaprevia3 = new javax.swing.JScrollPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        vistaResultado3 = new javax.swing.JTextArea();
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(14, 14, 14))
        );

        jPanel11.setBackground(new java.awt.Color(0, 153, 255));
        jPanel11.setForeground(new java.awt.Color(51, 153, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("TOTAL BIBLIOTECARIOS");

        lblTotalBibliotecarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalBibliotecarios.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalBibliotecarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalBibliotecarios.setText("jLabel11");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(26, 26, 26))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lblTotalBibliotecarios, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(lblTotalBibliotecarios, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(322, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dashboard", jPanel1);

        TablaBibliotecarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Usuario", "DPI", "Turno", "Area Trabajo", "Telefono", "Salario", "Estado"
            }
        ));
        jScrollPane2.setViewportView(TablaBibliotecarios);

        btnrecargarpaginabibliotecario.setText("Recargar");
        btnrecargarpaginabibliotecario.addActionListener(this::btnrecargarpaginabibliotecarioActionPerformed);

        btndesactivarbibliotecario.setText("Desactivar");
        btndesactivarbibliotecario.addActionListener(this::btndesactivarbibliotecarioActionPerformed);

        btnmodificarbibliotecario.setText("Modificar");
        btnmodificarbibliotecario.addActionListener(this::btnmodificarbibliotecarioActionPerformed);

        btnagregarbibliotecario.setText("Agregar Bibliotecario");
        btnagregarbibliotecario.addActionListener(this::btnagregarbibliotecarioActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btndesactivarbibliotecario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnmodificarbibliotecario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnrecargarpaginabibliotecario))
                    .addComponent(btnagregarbibliotecario)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnagregarbibliotecario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodificarbibliotecario)
                    .addComponent(btndesactivarbibliotecario)
                    .addComponent(btnrecargarpaginabibliotecario))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bibliotecarios", jPanel2);

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

        btnagregarlibro.setText("Agregar Libros");
        btnagregarlibro.addActionListener(this::btnagregarlibroActionPerformed);

        btnBorrarLibro.setText("Deshabilitar");
        btnBorrarLibro.addActionListener(this::btnBorrarLibroActionPerformed);

        btnModificarLibro.setText("Modificar");
        btnModificarLibro.addActionListener(this::btnModificarLibroActionPerformed);

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
                        .addComponent(textobuscarlibros, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seleciltroslibros, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbscarlibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnagregarlibro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnBorrarLibro)
                                .addGap(14, 14, 14)
                                .addComponent(btnModificarLibro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnrecargarlibros))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnagregarlibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textobuscarlibros)
                        .addComponent(seleciltroslibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbscarlibro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarLibro)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnrecargarlibros)
                        .addComponent(btnModificarLibro)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Libros", jPanel3);

        btnagregarestudiante.setText("Agregar Estudiantes");
        btnagregarestudiante.addActionListener(this::btnagregarestudianteActionPerformed);

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

        btnDeshabilitarEstudiante.setText("Deshabilitar");
        btnDeshabilitarEstudiante.addActionListener(this::btnDeshabilitarEstudianteActionPerformed);

        btnModificarEstudiante.setText("Modificar");
        btnModificarEstudiante.addActionListener(this::btnModificarEstudianteActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnagregarestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnDeshabilitarEstudiante)
                        .addGap(14, 14, 14)
                        .addComponent(btnModificarEstudiante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnrecargarestudiantes)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnagregarestudiante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeshabilitarEstudiante)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnrecargarestudiantes)
                        .addComponent(btnModificarEstudiante)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estudiantes", jPanel4);

        vistaResultado.setEditable(false);
        vistaResultado.setColumns(20);
        vistaResultado.setRows(5);
        jScrollPane1.setViewportView(vistaResultado);

        jLabel1.setText("Vista Previa");

        jLabel2.setText("Resultado");

        Iniciarcargalibros.setText("Cargar Libros");
        Iniciarcargalibros.addActionListener(this::IniciarcargalibrosActionPerformed);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vistaprevia, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(Iniciarcargalibros, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vistaprevia, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Iniciarcargalibros)
                .addGap(60, 60, 60))
        );

        jTabbedPane2.addTab("Cargar Libros", jPanel6);

        jLabel3.setText("Resultado");

        jLabel4.setText("Vista Previa");

        botoncargarestudiantes.setText("Cargar Estudiantes");
        botoncargarestudiantes.addActionListener(this::botoncargarestudiantesActionPerformed);

        vistaResultado2.setColumns(20);
        vistaResultado2.setRows(5);
        jScrollPane7.setViewportView(vistaResultado2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(vistaprevia2, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(botoncargarestudiantes)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vistaprevia2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botoncargarestudiantes)
                .addGap(57, 57, 57))
        );

        jTabbedPane2.addTab("Cargar Estudiantes", jPanel7);

        jLabel5.setText("Resultado");

        jLabel6.setText("Vista Previa");

        botoncargarbibliotecarios.setText("Cargar Bibliotecarios");
        botoncargarbibliotecarios.addActionListener(this::botoncargarbibliotecariosActionPerformed);

        vistaResultado3.setColumns(20);
        vistaResultado3.setRows(5);
        jScrollPane8.setViewportView(vistaResultado3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(vistaprevia3, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(botoncargarbibliotecarios)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vistaprevia3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botoncargarbibliotecarios)
                .addGap(60, 60, 60))
        );

        jTabbedPane2.addTab("Cargar Bibliotecarios", jPanel8);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Carga Masiva", jPanel5);

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
//---------------------------- BOTONES -----------------------------
    private void IniciarcargalibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarcargalibrosActionPerformed
        String texto = controladorAdmin.cargarLibrosConDialogo();

        String[] partes = texto.split("=== REPORTE DE CARGA DE LIBROS ===", 2);
        if (partes.length == 2) {
            vistaprevia.setViewportView(new javax.swing.JTextArea(partes[0]));
            vistaResultado.setText("=== REPORTE DE CARGA DE LIBROS ===" + partes[1]);
        } else {
            vistaResultado.setText(texto);
        }

        cargarlibrosalatabla(); 
        actualizarDashboard();

    }//GEN-LAST:event_IniciarcargalibrosActionPerformed
//---
    private void botoncargarestudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncargarestudiantesActionPerformed
        String texto = controladorAdmin.cargarEstudiantesConDialogo();
        String[] partes = texto.split("=== REPORTE DE CARGA DE ESTUDIANTES ===", 2);
        if (partes.length == 2) {
            vistaprevia2.setViewportView(new javax.swing.JTextArea(partes[0]));
            vistaResultado2.setText("=== REPORTE DE CARGA DE ESTUDIANTES ===" + partes[1]);
        } else {
            vistaResultado2.setText(texto);
        }

        cargarestudiantesalatabla();
        actualizarDashboard();

    }//GEN-LAST:event_botoncargarestudiantesActionPerformed

    private void botoncargarbibliotecariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncargarbibliotecariosActionPerformed
        String texto = controladorAdmin.cargarBibliotecariosConDialogo();

        String[] partes = texto.split("=== REPORTE DE CARGA DE BIBLIOTECARIOS ===", 2);
        if (partes.length == 2) {
            vistaprevia3.setViewportView(new javax.swing.JTextArea(partes[0]));
            vistaResultado3.setText("=== REPORTE DE CARGA DE BIBLIOTECARIOS ===" + partes[1]);
        } else {
            vistaResultado3.setText(texto);
        }

        cargarbibliotecariosalatabla();
        actualizarDashboard();

    }//GEN-LAST:event_botoncargarbibliotecariosActionPerformed

    private void btnrecargarestudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecargarestudiantesActionPerformed
        cargarestudiantesalatabla();
    }//GEN-LAST:event_btnrecargarestudiantesActionPerformed

    private void btnrecargarlibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecargarlibrosActionPerformed
        cargarlibrosalatabla();
    }//GEN-LAST:event_btnrecargarlibrosActionPerformed

    private void btnagregarlibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarlibroActionPerformed
    GestionarLibros dialog = new GestionarLibros(
            this,
            true,
            controladorAdmin.getRepoLibros()
    );
    dialog.setVisible(true);
    cargarlibrosalatabla();
    actualizarDashboard();
    
    }//GEN-LAST:event_btnagregarlibroActionPerformed

    private void btnrecargarpaginabibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecargarpaginabibliotecarioActionPerformed
        cargarbibliotecariosalatabla();
    }//GEN-LAST:event_btnrecargarpaginabibliotecarioActionPerformed

    private void btnModificarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLibroActionPerformed
        String isbn = JOptionPane.showInputDialog(this,
                    "Ingrese el ISBN del libro a modificar:");
            Libro libro = controladorAdmin.buscarLibroPorISBN(isbn);

            if (libro == null) {
                JOptionPane.showMessageDialog(this,
                        "No se encontró un libro con ese ISBN o el ISBN está vacío.");
                return;
            }

            GestionarLibros dialog = new GestionarLibros(
                    this, true, controladorAdmin.getRepoLibros(), libro
            );
            dialog.setVisible(true);
            cargarlibrosalatabla();
    }//GEN-LAST:event_btnModificarLibroActionPerformed

    private void btnBorrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarLibroActionPerformed
        String isbn = JOptionPane.showInputDialog(this,
            "Ingrese el ISBN del libro a eliminar:");
            String mensaje = controladorAdmin.eliminarLibroPorISBN(isbn);
            JOptionPane.showMessageDialog(this, mensaje);
                cargarlibrosalatabla();
                actualizarDashboard();

    }//GEN-LAST:event_btnBorrarLibroActionPerformed

    private void btnagregarestudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarestudianteActionPerformed
         GestionarEstudiantes dialog = new GestionarEstudiantes(
            this,
            true,
            controladorAdmin.getRepoEstudiantes()
    );
    dialog.setVisible(true);
    cargarestudiantesalatabla();  //recarga automaticamente
    actualizarDashboard();

    }//GEN-LAST:event_btnagregarestudianteActionPerformed

    private void btnModificarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEstudianteActionPerformed
        String carne = JOptionPane.showInputDialog(this,
            "Ingrese el carnet del estudiante a modificar:");
    Estudiante est = controladorAdmin.buscarEstudiantePorCarne(carne);

    if (est == null) {
        JOptionPane.showMessageDialog(this,
                "No se encontró un estudiante con ese carnet o el carnet está vacío.");
        return;
    }

    GestionarEstudiantes dialog = new GestionarEstudiantes(
            this, true, controladorAdmin.getRepoEstudiantes(), est
    );
    dialog.setVisible(true);
    cargarestudiantesalatabla();
    }//GEN-LAST:event_btnModificarEstudianteActionPerformed

    private void btnDeshabilitarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshabilitarEstudianteActionPerformed
        String carne = JOptionPane.showInputDialog(this,
            "Ingrese el carnet del estudiante a eliminar:");
                String mensaje = controladorAdmin.eliminarEstudiantePorCarne(carne);
                JOptionPane.showMessageDialog(this, mensaje);
                    cargarestudiantesalatabla();
    }//GEN-LAST:event_btnDeshabilitarEstudianteActionPerformed

    private void btnagregarbibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarbibliotecarioActionPerformed
        GestionarBibliotecarios dialog = new GestionarBibliotecarios(
            this,
            true,
            controladorAdmin.getRepoBibliotecarios()
    );
    dialog.setVisible(true);
    cargarbibliotecariosalatabla();
    actualizarDashboard();

    }//GEN-LAST:event_btnagregarbibliotecarioActionPerformed

    private void btndesactivarbibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesactivarbibliotecarioActionPerformed
            String id = JOptionPane.showInputDialog(this,
            "Ingrese el ID del bibliotecario a eliminar:");

    String mensaje = controladorAdmin.eliminarBibliotecarioPorID(id);
    JOptionPane.showMessageDialog(this, mensaje);
    cargarbibliotecariosalatabla();
    }//GEN-LAST:event_btndesactivarbibliotecarioActionPerformed

    private void btnmodificarbibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarbibliotecarioActionPerformed
        String id = JOptionPane.showInputDialog(this,
            "Ingrese el ID del bibliotecario a modificar:");

    Bibliotecario bib = controladorAdmin.buscarBibliotecarioPorID(id);
    if (bib == null) {
        JOptionPane.showMessageDialog(this,
                "No se encontró un bibliotecario con ese ID o el ID está vacío.");
        return;
    }

    GestionarBibliotecarios dialog = new GestionarBibliotecarios(
            this,
            true,
            controladorAdmin.getRepoBibliotecarios(),
            bib
    );
    dialog.setVisible(true);
    cargarbibliotecariosalatabla();
    }//GEN-LAST:event_btnmodificarbibliotecarioActionPerformed

    private void btncerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarsesionActionPerformed
        controladorAdmin.cerrarSesion();
    }//GEN-LAST:event_btncerrarsesionActionPerformed

    private void textobuscarlibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textobuscarlibrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textobuscarlibrosActionPerformed

    private void btnbscarlibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbscarlibroActionPerformed
            String texto = textobuscarlibros.getText();

        Libro[] resultados = controladorAdmin.buscarLibros(texto, "titulo");

        cargarlibrosalatablaconparametro(resultados);
    }//GEN-LAST:event_btnbscarlibroActionPerformed

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
//============================================
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iniciarcargalibros;
    private javax.swing.JTable TablaBibliotecarios;
    private javax.swing.JTable TablaEstudiantes;
    private javax.swing.JTable TablaLibros;
    private javax.swing.JButton botoncargarbibliotecarios;
    private javax.swing.JButton botoncargarestudiantes;
    private javax.swing.JButton btnBorrarLibro;
    private javax.swing.JButton btnDeshabilitarEstudiante;
    private javax.swing.JButton btnModificarEstudiante;
    private javax.swing.JButton btnModificarLibro;
    private javax.swing.JButton btnagregarbibliotecario;
    private javax.swing.JButton btnagregarestudiante;
    private javax.swing.JButton btnagregarlibro;
    private javax.swing.JButton btnbscarlibro;
    private javax.swing.JButton btncerrarsesion;
    private javax.swing.JButton btndesactivarbibliotecario;
    private javax.swing.JButton btnmodificarbibliotecario;
    private javax.swing.JButton btnrecargarestudiantes;
    private javax.swing.JButton btnrecargarlibros;
    private javax.swing.JButton btnrecargarpaginabibliotecario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblTotalBibliotecarios;
    private javax.swing.JLabel lblTotalEstudiantes;
    private javax.swing.JLabel lblTotalLibros;
    private javax.swing.JComboBox<String> seleciltroslibros;
    private javax.swing.JTextField textobuscarlibros;
    private javax.swing.JTextArea vistaResultado;
    private javax.swing.JTextArea vistaResultado2;
    private javax.swing.JTextArea vistaResultado3;
    private javax.swing.JScrollPane vistaprevia;
    private javax.swing.JScrollPane vistaprevia1;
    private javax.swing.JScrollPane vistaprevia2;
    private javax.swing.JScrollPane vistaprevia3;
    // End of variables declaration//GEN-END:variables
}