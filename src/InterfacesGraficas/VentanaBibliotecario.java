
package InterfacesGraficas;

import modelos.Libro;
import modelos.Estudiante;
import Controladores.ControladorAdmin;


public class VentanaBibliotecario extends javax.swing.JFrame {
        private javax.swing.table.DefaultTableModel modeloLibros; 

    private final ControladorAdmin controladorAdmin;
 
    
    public VentanaBibliotecario(ControladorAdmin controladorAdmin) {
            initComponents();
                this.controladorAdmin = controladorAdmin;  
                setLocationRelativeTo(null);
                //Configurar las tablas
                configurarTablaLibros();
                //Cargar
                recargarLibrosDesdeRepositorio();
                actualizarDashboard();
        }
//===========================CONFIGURAR TABLAS==============================
    private void configurarTablaLibros() {
    modeloLibros = new javax.swing.table.DefaultTableModel(
        new Object[] {"ISBN", "Titulo", "Autor", "Editorial", "Año", "Categoria", "Cantidad", "Ubicacion"},
        0
    );
    TablaLibros.setModel(modeloLibros);
        recargarLibrosDesdeRepositorio(); //Recarga automaticamente la tabla
}

    public void cargarPerfil(modelos.Bibliotecario bib) {
    if (bib == null) return;
        textobibliotecario.setText(bib.getNombre());
}

    private void actualizarDashboard() {
    int totalLibros = controladorAdmin.contarLibros();
    int totalEstudiantes = controladorAdmin.contarEstudiantes();  
    int totalPrestamos = controladorAdmin.contarPrestamos();
        lblTotalLibros.setText(String.valueOf(totalLibros));
        lblTotalEstudiantes.setText(String.valueOf(totalEstudiantes));
        lbltotalprestamos.setText(String.valueOf(totalPrestamos));
}

    public void recargarTodo() {
    recargarLibrosDesdeRepositorio();
    actualizarDashboard();
}

//========================CARGAR TABLAS=======================================
    private void cargarlibrosalatabla(Libro[] libros){  //Sirve para los ordenamientos(considere mejor simplemente crear una copia)
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

    private void recargarLibrosDesdeRepositorio() {
    Libro[] libros = controladorAdmin.getRepoLibros().todosLosLibros();
    cargarlibrosalatabla(libros);
}
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
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbltotalprestamos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaLibros = new javax.swing.JTable();
        btnrecargarlibros = new javax.swing.JButton();
        textobuscarlibros = new javax.swing.JTextField();
        seleciltroslibros = new javax.swing.JComboBox<>();
        btnbscarlibro = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        textobuscarestudiante = new javax.swing.JTextField();
        btnbuscarestudiante = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ConsultarEstudiantetextArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        Area1 = new javax.swing.JScrollPane();
        txtestudianteprestar = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        area2 = new javax.swing.JScrollPane();
        txtlibroprestar = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Textocarnet = new javax.swing.JTextField();
        isbnlibroaprestat = new javax.swing.JTextField();
        btnbuscarcarnet = new javax.swing.JButton();
        btnbuscarisbn = new javax.swing.JButton();
        RealizarPrestamo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Area4 = new javax.swing.JScrollPane();
        txtlibroadevolver = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        isbnlibrodevolucion = new javax.swing.JTextField();
        btnbuscarisbndevolucion = new javax.swing.JButton();
        Area3 = new javax.swing.JScrollPane();
        txtestudiantedevolver = new javax.swing.JTextArea();
        Textocarnetdevolucion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnbuscarcarnetdevolucion = new javax.swing.JButton();
        btnrealizardevolucion = new javax.swing.JButton();
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
                .addContainerGap(55, Short.MAX_VALUE))
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

        jLabel1.setText("BIENVENIDO");

        textobibliotecario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel11.setBackground(new java.awt.Color(0, 153, 255));
        jPanel11.setForeground(new java.awt.Color(51, 153, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("TOTAL PRESTAMOS");

        lbltotalprestamos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbltotalprestamos.setForeground(new java.awt.Color(0, 0, 0));
        lbltotalprestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltotalprestamos.setText("jLabel11");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lbltotalprestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(lbltotalprestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout TextoBibliotecarioLayout = new javax.swing.GroupLayout(TextoBibliotecario);
        TextoBibliotecario.setLayout(TextoBibliotecarioLayout);
        TextoBibliotecarioLayout.setHorizontalGroup(
            TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextoBibliotecarioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextoBibliotecarioLayout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addGroup(TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextoBibliotecarioLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextoBibliotecarioLayout.createSequentialGroup()
                        .addComponent(textobibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextoBibliotecarioLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327))))
        );
        TextoBibliotecarioLayout.setVerticalGroup(
            TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextoBibliotecarioLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(textobibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(TextoBibliotecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
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
                        .addContainerGap(34, Short.MAX_VALUE))
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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnrecargarlibros)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Libros", jPanel3);

        btnbuscarestudiante.setText("Buscar");
        btnbuscarestudiante.addActionListener(this::btnbuscarestudianteActionPerformed);

        ConsultarEstudiantetextArea.setColumns(20);
        ConsultarEstudiantetextArea.setRows(5);
        jScrollPane1.setViewportView(ConsultarEstudiantetextArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(textobuscarestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnbuscarestudiante)
                .addGap(108, 108, 108))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscarestudiante)
                    .addComponent(textobuscarestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar Estudiantes", jPanel4);

        txtestudianteprestar.setEditable(false);
        txtestudianteprestar.setColumns(20);
        txtestudianteprestar.setRows(5);
        Area1.setViewportView(txtestudianteprestar);

        txtlibroprestar.setEditable(false);
        txtlibroprestar.setColumns(20);
        txtlibroprestar.setRows(5);
        area2.setViewportView(txtlibroprestar);

        jScrollPane2.setViewportView(area2);

        jLabel2.setText("Carné del Estudiante:");

        jLabel3.setText("ISBN del Libro:");

        btnbuscarcarnet.setText("Buscar");
        btnbuscarcarnet.addActionListener(this::btnbuscarcarnetActionPerformed);

        btnbuscarisbn.setText("Buscar");
        btnbuscarisbn.addActionListener(this::btnbuscarisbnActionPerformed);

        RealizarPrestamo.setText("Realizar Prestamo");
        RealizarPrestamo.addActionListener(this::RealizarPrestamoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Textocarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscarcarnet))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isbnlibroaprestat, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscarisbn))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Area1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(RealizarPrestamo)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Textocarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarcarnet))
                .addGap(28, 28, 28)
                .addComponent(Area1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(isbnlibroaprestat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarisbn))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RealizarPrestamo)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Realizar Préstamo", jPanel1);

        txtlibroadevolver.setEditable(false);
        txtlibroadevolver.setColumns(20);
        txtlibroadevolver.setRows(5);
        Area4.setViewportView(txtlibroadevolver);

        jLabel4.setText("ISBN del Libro:");

        btnbuscarisbndevolucion.setText("Buscar");
        btnbuscarisbndevolucion.addActionListener(this::btnbuscarisbndevolucionActionPerformed);

        txtestudiantedevolver.setEditable(false);
        txtestudiantedevolver.setColumns(20);
        txtestudiantedevolver.setRows(5);
        Area3.setViewportView(txtestudiantedevolver);

        jLabel5.setText("Carné del Estudiante:");

        btnbuscarcarnetdevolucion.setText("Buscar");
        btnbuscarcarnetdevolucion.addActionListener(this::btnbuscarcarnetdevolucionActionPerformed);

        btnrealizardevolucion.setText("Realizar Devolución");
        btnrealizardevolucion.addActionListener(this::btnrealizardevolucionActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(Textocarnetdevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnbuscarcarnetdevolucion)
                .addGap(104, 104, 104))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Area3, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(Area4, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(isbnlibrodevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscarisbndevolucion))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(btnrealizardevolucion)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Textocarnetdevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnbuscarcarnetdevolucion))
                .addGap(18, 18, 18)
                .addComponent(Area3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isbnlibrodevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnbuscarisbndevolucion))
                .addGap(18, 18, 18)
                .addComponent(Area4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnrealizardevolucion)
                .addGap(76, 76, 76))
        );

        jTabbedPane1.addTab("Realizar Devolución", jPanel2);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncerrarsesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncerrarsesion)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//=============================BOTONES========================================
    private void btnrecargarlibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecargarlibrosActionPerformed
        recargarLibrosDesdeRepositorio();
    }//GEN-LAST:event_btnrecargarlibrosActionPerformed

    private void btncerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarsesionActionPerformed
        controladorAdmin.cerrarSesion();
    }//GEN-LAST:event_btncerrarsesionActionPerformed

    private void textobuscarlibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textobuscarlibrosActionPerformed

    }//GEN-LAST:event_textobuscarlibrosActionPerformed

    private void btnbscarlibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbscarlibroActionPerformed
        String texto = textobuscarlibros.getText();

            Libro[] resultados = controladorAdmin.buscarLibros(texto, "titulo");

                 cargarlibrosalatabla(resultados);
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
                     cargarlibrosalatabla(listaOrdenada);
            }
    }//GEN-LAST:event_seleciltroslibrosActionPerformed

    private void btnbuscarestudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarestudianteActionPerformed
           String carne = textobuscarestudiante.getText();
           String reporte = controladorAdmin.generarReporteEstudianteConPrestamos(carne);
           ConsultarEstudiantetextArea.setText(reporte);
    }//GEN-LAST:event_btnbuscarestudianteActionPerformed

    private void btnbuscarcarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarcarnetActionPerformed
        String carne = Textocarnet.getText();
        if (carne == null || carne.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un carné.");
        return;
        }

        Estudiante est = controladorAdmin.buscarEstudiantePorCarne(carne);
        if (est == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró estudiante con ese carné.");
            txtestudianteprestar.setText("");
            return;
        }

        StringBuilder info = new StringBuilder();
        info.append("Carné: ").append(est.getCarnet()).append("\n");
        info.append("Nombre: ").append(est.getNombre()).append("\n");
        info.append("Usuario: ").append(est.getUsuario()).append("\n");
        info.append("Carrera: ").append(est.getCarrera()).append("\n");
        info.append("Semestre: ").append(est.getSemestre()).append("\n");
        info.append("Facultad: ").append(est.getFacultad()).append("\n");
        info.append("Correo: ").append(est.getCorreo()).append("\n");

        txtestudianteprestar.setText(info.toString());
    }//GEN-LAST:event_btnbuscarcarnetActionPerformed

    private void btnbuscarisbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarisbnActionPerformed
        String isbn = isbnlibroaprestat.getText();
        if (isbn == null || isbn.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un ISBN.");
        return;
        }

        Libro libro = controladorAdmin.buscarLibroPorISBN(isbn);
        if (libro == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró un libro con ese ISBN.");
            txtlibroprestar.setText("");
            return;
        }

        StringBuilder info = new StringBuilder();
        info.append("ISBN: ").append(libro.getISBN()).append("\n");
        info.append("Título: ").append(libro.getTitulo()).append("\n");
        info.append("Autor: ").append(libro.getAutor()).append("\n");
        info.append("Editorial: ").append(libro.getEditorial()).append("\n");
        info.append("Año: ").append(libro.getAnioPublicacion()).append("\n");
        info.append("Categoría: ").append(libro.getCategoria()).append("\n");
        info.append("Cantidad disponible: ").append(libro.getCantidad()).append("\n");
        info.append("Ubicación: ").append(libro.getUbicacion()).append("\n");

        txtlibroprestar.setText(info.toString());
    }//GEN-LAST:event_btnbuscarisbnActionPerformed

    private void btnbuscarcarnetdevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarcarnetdevolucionActionPerformed
        String carne = Textocarnetdevolucion.getText();
        if (carne == null || carne.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un carné.");
        return;
        }

        Estudiante est = controladorAdmin.buscarEstudiantePorCarne(carne);
        if (est == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró estudiante con ese carné.");
            txtestudiantedevolver.setText("");
            return;
        }

        StringBuilder info = new StringBuilder();
        info.append("Carné: ").append(est.getCarnet()).append("\n");
        info.append("Nombre: ").append(est.getNombre()).append("\n");
        info.append("Usuario: ").append(est.getUsuario()).append("\n");
        info.append("Carrera: ").append(est.getCarrera()).append("\n");
        info.append("Semestre: ").append(est.getSemestre()).append("\n");
        info.append("Facultad: ").append(est.getFacultad()).append("\n");
        info.append("Correo: ").append(est.getCorreo()).append("\n");

        txtestudiantedevolver.setText(info.toString());
    }//GEN-LAST:event_btnbuscarcarnetdevolucionActionPerformed

    private void btnbuscarisbndevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarisbndevolucionActionPerformed
        String isbn = isbnlibrodevolucion.getText();
        if (isbn == null || isbn.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un ISBN.");
        return;
        }

        Libro libro = controladorAdmin.buscarLibroPorISBN(isbn);
        if (libro == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró un libro con ese ISBN.");
            txtlibroadevolver.setText("");
            return;
        }

        StringBuilder info = new StringBuilder();
        info.append("ISBN: ").append(libro.getISBN()).append("\n");
        info.append("Título: ").append(libro.getTitulo()).append("\n");
        info.append("Autor: ").append(libro.getAutor()).append("\n");
        info.append("Editorial: ").append(libro.getEditorial()).append("\n");
        info.append("Año: ").append(libro.getAnioPublicacion()).append("\n");
        info.append("Categoría: ").append(libro.getCategoria()).append("\n");
        info.append("Cantidad disponible: ").append(libro.getCantidad()).append("\n");
        info.append("Ubicación: ").append(libro.getUbicacion()).append("\n");

        txtlibroadevolver.setText(info.toString());
    }//GEN-LAST:event_btnbuscarisbndevolucionActionPerformed

    private void RealizarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarPrestamoActionPerformed
        String carne = Textocarnet.getText();
    String isbn = isbnlibroaprestat.getText();

    String mensaje = controladorAdmin.realizarPrestamo(carne, isbn);
    javax.swing.JOptionPane.showMessageDialog(this, mensaje);

    if (mensaje.startsWith("Préstamo registrado")) {
        recargarLibrosDesdeRepositorio();
        txtestudianteprestar.setText("");
        txtlibroprestar.setText("");
        Textocarnet.setText("");
        isbnlibroaprestat.setText("");
    }
    }//GEN-LAST:event_RealizarPrestamoActionPerformed

    private void btnrealizardevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrealizardevolucionActionPerformed
        String carne = Textocarnetdevolucion.getText();
        String isbn  = isbnlibrodevolucion.getText();

        if (carne == null || carne.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el carné del estudiante.");
            return;
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ISBN del libro.");
            return;
        }

        String mensaje = controladorAdmin.realizarDevolucion(carne, isbn);
        javax.swing.JOptionPane.showMessageDialog(this, mensaje);

        // Si se registró la devolución, refrescar datos y limpiar
        if (mensaje.startsWith("Devolución registrada")) {
            recargarLibrosDesdeRepositorio();
            txtestudiantedevolver.setText("");
            txtlibroadevolver.setText("");
            Textocarnetdevolucion.setText("");
            isbnlibrodevolucion.setText("");
        }
    }//GEN-LAST:event_btnrealizardevolucionActionPerformed
//============================================
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Area1;
    private javax.swing.JScrollPane Area3;
    private javax.swing.JScrollPane Area4;
    private javax.swing.JTextArea ConsultarEstudiantetextArea;
    private javax.swing.JButton RealizarPrestamo;
    private javax.swing.JTable TablaLibros;
    private javax.swing.JPanel TextoBibliotecario;
    private javax.swing.JTextField Textocarnet;
    private javax.swing.JTextField Textocarnetdevolucion;
    private javax.swing.JScrollPane area2;
    private javax.swing.JButton btnbscarlibro;
    private javax.swing.JButton btnbuscarcarnet;
    private javax.swing.JButton btnbuscarcarnetdevolucion;
    private javax.swing.JButton btnbuscarestudiante;
    private javax.swing.JButton btnbuscarisbn;
    private javax.swing.JButton btnbuscarisbndevolucion;
    private javax.swing.JButton btncerrarsesion;
    private javax.swing.JButton btnrealizardevolucion;
    private javax.swing.JButton btnrecargarlibros;
    private javax.swing.JTextField isbnlibroaprestat;
    private javax.swing.JTextField isbnlibrodevolucion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTotalEstudiantes;
    private javax.swing.JLabel lblTotalLibros;
    private javax.swing.JLabel lblTotalPrestamos;
    private javax.swing.JLabel lblTotalPrestamos1;
    private javax.swing.JLabel lbltotalprestamos;
    private javax.swing.JComboBox<String> seleciltroslibros;
    private javax.swing.JLabel textobibliotecario;
    private javax.swing.JTextField textobuscarestudiante;
    private javax.swing.JTextField textobuscarlibros;
    private javax.swing.JTextArea txtestudiantedevolver;
    private javax.swing.JTextArea txtestudianteprestar;
    private javax.swing.JTextArea txtlibroadevolver;
    private javax.swing.JTextArea txtlibroprestar;
    private javax.swing.JScrollPane vistaprevia1;
    // End of variables declaration//GEN-END:variables
}