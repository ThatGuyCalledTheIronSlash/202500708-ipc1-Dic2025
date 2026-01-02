package controlador;

import java.io.*;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;
import modelo.Ingrediente;
import modelo.Sucursal;
import modelo.estructuras.NodoSimple;
import modelo.estructuras.ListaDoble;
import modelo.estructuras.ListaSimple;
import modelo.estructuras.NodoDoble;
import modelo.gestores.GestorClientes;
import modelo.gestores.GestorEmpleados;
import modelo.gestores.GestorProductos;
import modelo.gestores.GestorInventario;
import modelo.gestores.GestorSucursales;

public class ControladorAdmin {

    private GestorEmpleados gestorEmpleados;
    private GestorClientes gestorClientes;
    private GestorProductos gestorProductos;
    private GestorInventario gestorInventario;
    private GestorSucursales gestorSucursales;
        private String rutaEmpleados = "datos/Empleados.csv";
        private String rutaClientes = "datos/Clientes.csv";
        private String rutaInventario = "datos/Inventario.csv";
        private String rutaProductos = "datos/Menú.csv";
        private String rutaSucursales = "datos/Sucursales.csv";

//==============================CONSTRUCTOR==========================
    public ControladorAdmin(GestorEmpleados gestorEmpleados,
                            GestorClientes gestorClientes,
                            GestorProductos gestorProductos,
                            GestorInventario gestorInventario,
                            GestorSucursales gestorSucursales) {

        this.gestorEmpleados = gestorEmpleados;
        this.gestorClientes = gestorClientes;
        this.gestorProductos = gestorProductos;
        this.gestorInventario = gestorInventario;
        this.gestorSucursales = gestorSucursales;
    }
    
//======================== DATOS INICIALES =========================
   public void cargarDatosIniciales() {
        File carpetaDatos = new File("datos");

        if (!carpetaDatos.exists()) {
            carpetaDatos.mkdirs();
        }

        File empleados = new File(carpetaDatos, "Empleados.csv");
        File clientes = new File(carpetaDatos, "Clientes.csv");
        File productos = new File(carpetaDatos, "Menú.csv");
        File inventario = new File(carpetaDatos, "Inventario.csv");
        File sucursales = new File(carpetaDatos, "Sucursales.csv");

        if (empleados.exists()) {
            cargarEmpleadosDesdeCSV(empleados);
        }

        if (clientes.exists()) {
            cargarClientesDesdeCSV(clientes);
        }

        if (productos.exists()) {
            cargarProductosDesdeCSV(productos);
        }

        if (inventario.exists()) {
            cargarIngredientesDesdeCSV(inventario);
        }
        if (sucursales.exists()) {
            cargarSucursalesDesdeCSV(sucursales);
        }
    }
 

//====================== CLIENTES ======================

    public NodoDoble obtenerCabezaClientes() {
        return gestorClientes.getListaClientes().getCabeza();
    }

    public void registrarCliente(String nombreCompleto,String direccionEntrega,String usuario,String contrasena, 
            String telefono,String email,String nivel, int puntosAcumulados) {

        Cliente c = new Cliente(
                nombreCompleto,
                direccionEntrega,
                usuario,
                contrasena,
                telefono,
                email,
                nivel,
                puntosAcumulados
        );
        gestorClientes.registrarCliente(c);
    }

    public Cliente buscarClientePorId(int idCliente) {
        return gestorClientes.buscarPorId(idCliente);
    }
    
    public NodoDoble buscarClientesPorId(int idBuscado) {
        ListaDoble resultados = new ListaDoble();

         NodoDoble actual = gestorClientes.getListaClientes().getCabeza();
         while (actual != null) {
              Cliente c = (Cliente) actual.getDato();
                 if (c.getIdCliente() == idBuscado) {
                     resultados.insertarAlFinal(c);
                 }
             actual = actual.getSiguiente();
         }

            return resultados.getCabeza();
        }
    
    public NodoDoble buscarNodoClientePorId(int idBuscado) {
        NodoDoble actual = gestorClientes.getListaClientes().getCabeza();
        while (actual != null) {
            Cliente c = (Cliente) actual.getDato();
            if (c.getIdCliente() == idBuscado) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public NodoDoble buscarClientesPorNombre(String texto) {
        ListaDoble resultados = new ListaDoble();
            String criterio = texto.toLowerCase();

        NodoDoble actual = gestorClientes.getListaClientes().getCabeza();
        while (actual != null) {            
                Cliente c = (Cliente) actual.getDato();
                if (c.getNombreCompleto().toLowerCase().contains(criterio)) {
                    resultados.insertarAlFinal(c);
                }
                actual = actual.getSiguiente();
            }           
                return resultados.getCabeza();
    }
    
    public NodoDoble buscarClientesPorNivel(String nivelBuscado) {
        ListaDoble resultados = new ListaDoble();

        NodoDoble actual = gestorClientes.getListaClientes().getCabeza();
        while (actual != null) {
             Cliente c = (Cliente) actual.getDato();
             if (c.getNivel().equalsIgnoreCase(nivelBuscado)) {
                 resultados.insertarAlFinal(c);
             }
             actual = actual.getSiguiente();
         }
         return resultados.getCabeza();
     }

    public boolean actualizarCliente(int idCliente,String nombreCompleto,String direccionEntrega,
            String usuario,String contrasena,String telefono,String email,String nivel,int puntos) {
        Cliente existente = gestorClientes.buscarPorId(idCliente);
        if (existente == null) {
            return false;
        }

        existente.setNombreCompleto(nombreCompleto);
        existente.setDireccionEntrega(direccionEntrega);
        existente.setUsuario(usuario);
        existente.setContrasena(contrasena);
        existente.setTelefono(telefono);
        existente.setEmail(email);
        existente.setNivel(nivel);
        existente.setPuntosAcumulados(puntos);

        return true;
    }

    public boolean eliminarClientePorId(int idCliente) {
        return gestorClientes.eliminarClientePorId(idCliente);
    }
    
// ================== EMPLEADOS ==================
    public NodoDoble obtenerCabezaEmpleados() {
        return gestorEmpleados.getListaEmpleados().getCabeza();
    }
    
    public void registrarEmpleado(String nombreCompleto,String usuario,String contrasena,String dpi,
            String telefono,String email,String puesto,String turno, String sucursal,double salarioBase,boolean activo) {

        Empleado e = new Empleado(
                   nombreCompleto,
                   usuario,
                   contrasena,
                   telefono,      
                   email,         
                   dpi,           
                   "",            
                   puesto,     
                   turno,        
                   sucursal,      
                   salarioBase
           );
           e.setActivo(activo);
           gestorEmpleados.registrarEmpleado(e);
            }

    public Empleado buscarEmpleadoPorId(int idEmpleado) {
        return gestorEmpleados.buscarPorId(idEmpleado);
        }
    
    public NodoDoble buscarNodoEmpleadoPorId(int idBuscado) {
        NodoDoble actual = obtenerCabezaEmpleados();
        while (actual != null) {
            Empleado e = (Empleado) actual.getDato();
            if (e.getIdEmpleado() == idBuscado) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean actualizarEmpleado(int idEmpleado,String nombreCompleto, String usuario,
            String contrasena,String dpi,String telefono, String email,
                String puesto,String turno,String sucursal,double salarioBase,boolean activo) {

                Empleado existente = gestorEmpleados.buscarPorId(idEmpleado);
                if (existente == null) {
                    return false;
                }

            existente.setNombreCompleto(nombreCompleto);
            existente.setUsuario(usuario);
            existente.setContrasena(contrasena);
            existente.setDpi(dpi);
            existente.setTelefono(telefono);
            existente.setEmail(email);
            existente.setPuesto(puesto);
            existente.setTurno(turno);
            existente.setSucursalAsignada(sucursal);
            existente.setSalarioBase(salarioBase);
            existente.setActivo(activo);

            return true;
        } 
            
    public boolean eliminarEmpleadoPorId(int idEmpleado) {
        return gestorEmpleados.eliminarEmpleadoPorId(idEmpleado);
    }
    
// ================== PRODUCTOS (MENÚ) ==================

    public NodoDoble obtenerCabezaProductos() {
        return gestorProductos.getListaProductos().getCabeza();
    }
    
    public void registrarProducto(String nombre, String descripcion, String categoria,
                              double precio, int tiempoPreparacion, boolean disponible) {
    
    Producto p = new Producto(nombre, descripcion, categoria, precio, tiempoPreparacion, disponible);
        gestorProductos.registrarProducto(p);
}

    public Producto buscarProductoPorCodigo(int codigo) {
        return gestorProductos.buscarPorCodigo(codigo);
    }
    
    //busqueda con nodo y lista doble
    public NodoDoble buscarProductosPorCodigo(int codigoBuscado) {
        ListaDoble resultados = new ListaDoble();

        NodoDoble actual = gestorProductos.getListaProductos().getCabeza();
        while (actual != null) {
            Producto p = (Producto) actual.getDato();
            if (p.getCodigoProducto() == codigoBuscado) {
                resultados.insertarAlFinal(p);
            }
            actual = actual.getSiguiente();
        }
        return resultados.getCabeza();
    }

    public NodoDoble buscarProductosPorNombre(String texto) {
        modelo.estructuras.ListaDoble resultados = new modelo.estructuras.ListaDoble();
        String criterio = texto.toLowerCase();

        NodoDoble actual = gestorProductos.getListaProductos().getCabeza();
        while (actual != null) {
            Producto p = (Producto) actual.getDato();
            if (p.getNombre().toLowerCase().contains(criterio)) {
                resultados.insertarAlFinal(p);
            }
            actual = actual.getSiguiente();
        }
        return resultados.getCabeza();
    }

    public NodoDoble buscarProductosPorCategoria(String categoriaBuscada) {
        ListaDoble resultados = new ListaDoble();
            String criterio = categoriaBuscada.toLowerCase();

        NodoDoble actual = gestorProductos.getListaProductos().getCabeza();
        while (actual != null) {
            Producto p = (Producto) actual.getDato();
            if (p.getCategoria().toLowerCase().equals(criterio)) {
                resultados.insertarAlFinal(p);
            }
            actual = actual.getSiguiente();
        }
        return resultados.getCabeza();
    }
    
    public boolean actualizarProducto(int codigo, String nombre, String descripcion, String categoria,
                                      double precio, int tiempoPreparacion, boolean disponible) {
        Producto existente = gestorProductos.buscarPorCodigo(codigo);
        if (existente == null) {
            return false;
        }

        existente.setNombre(nombre);
        existente.setDescripcion(descripcion);
        existente.setCategoria(categoria);
        existente.setPrecio(precio);
        existente.setTiempoPreparacion(tiempoPreparacion);
        existente.setDisponible(disponible);

        return true;
    }

    public boolean eliminarProductoPorCodigo(int codigo) {
        return gestorProductos.eliminarPorCodigo(codigo);
    }
     
// ================== INVENTARIO ==================

    public NodoDoble obtenerCabezaIngredientes() {
        return gestorInventario.getListaIngredientes().getCabeza();
    } 
    
    public void registrarIngrediente(String nombre, double cantidadStock, String unidadMedida,
                                     double nivelMinimo, String proveedor) {
        Ingrediente ing = new Ingrediente(nombre, cantidadStock, unidadMedida, nivelMinimo, proveedor);
        gestorInventario.registrarIngrediente(ing);
    }   

    public Ingrediente buscarIngredientePorCodigo(int codigo) {
        return gestorInventario.buscarPorCodigo(codigo);
    }
          
    public NodoDoble buscarIngredientesPorCodigo(int codigoBuscado) {
        ListaDoble resultados = new ListaDoble();
            NodoDoble actual = gestorInventario.getListaIngredientes().getCabeza();
            while (actual != null) {
                Ingrediente ing = (Ingrediente) actual.getDato();
                if (ing.getCodigoIngrediente() == codigoBuscado) {
                    resultados.insertarAlFinal(ing);
                }
                actual = actual.getSiguiente();
            }
            return resultados.getCabeza();
        }

    public NodoDoble buscarIngredientesPorNombre(String texto) {
        ListaDoble resultados = new ListaDoble();
        String criterio = texto.toLowerCase();

        NodoDoble actual = gestorInventario.getListaIngredientes().getCabeza();
        while (actual != null) {
            Ingrediente ing = (Ingrediente) actual.getDato();
            if (ing.getNombre().toLowerCase().contains(criterio)) {
                resultados.insertarAlFinal(ing);
            }
            actual = actual.getSiguiente();
        }
        return resultados.getCabeza();
    }

    public NodoDoble buscarIngredientesPorProveedor(String texto) {
        ListaDoble resultados = new ListaDoble();
            String criterio = texto.toLowerCase();

            NodoDoble actual = gestorInventario.getListaIngredientes().getCabeza();
            while (actual != null) {
                Ingrediente ing = (Ingrediente) actual.getDato();
                if (ing.getProveedor().toLowerCase().contains(criterio)) {
                    resultados.insertarAlFinal(ing);
                }
                actual = actual.getSiguiente();
            }
            return resultados.getCabeza();
        }
    
    public boolean actualizarIngrediente(int codigo, String nombre, double cantidadStock,
                                     String unidadMedida, double nivelMinimo, String proveedor) {
        Ingrediente existente = gestorInventario.buscarPorCodigo(codigo);
        if (existente == null) {
            return false;
        }

        existente.setNombre(nombre);
        existente.setCantidadStock(cantidadStock);
        existente.setUnidadMedida(unidadMedida);
        existente.setNivelMinimo(nivelMinimo);
        existente.setProveedor(proveedor);

        return true;
    }
    
    public boolean eliminarIngredientePorCodigo(int codigo) {
        return gestorInventario.eliminarPorCodigo(codigo);
    }
 
//===============================SUCURSALES===============================
    public NodoSimple obtenerCabezaSucursales() {
            return gestorSucursales.getListaSucursales().getCabeza();
        }

    public void registrarSucursal(String nombre, String direccion, String telefono,
                                      String gerente, int capacidadMesas,
                                      String horario, String estado) {
            Sucursal s = new Sucursal(nombre, direccion, telefono, gerente, capacidadMesas, horario, estado);
            gestorSucursales.registrarSucursal(s);
        }

    public Sucursal buscarSucursalPorId(int idSucursal) {
            return gestorSucursales.buscarPorId(idSucursal);
        }
        
   public NodoSimple buscarSucursalesPorId(int idBuscado) {
        ListaSimple resultados = new ListaSimple();

        NodoSimple actual = gestorSucursales.getListaSucursales().getCabeza();
        while (actual != null) {
            Sucursal s = (Sucursal) actual.getDato();
            if (s.getIdSucursal() == idBuscado) {
                resultados.insertarAlFinal(s);
            }
            actual = actual.getSiguiente();
        }
        return resultados.getCabeza();
    }

    public NodoSimple buscarSucursalesPorNombre(String texto) {
        ListaSimple resultados = new ListaSimple();
            String criterio = texto.toLowerCase();

        NodoSimple actual = gestorSucursales.getListaSucursales().getCabeza();
        while (actual != null) {
            Sucursal s = (Sucursal) actual.getDato();
            if (s.getNombre().toLowerCase().contains(criterio)) {
                resultados.insertarAlFinal(s);
            }
            actual = actual.getSiguiente();
        }
        return resultados.getCabeza();
    }

    public NodoSimple buscarSucursalesPorTelefono(String texto) {
        modelo.estructuras.ListaSimple resultados = new modelo.estructuras.ListaSimple();
        String criterio = texto.toLowerCase();

        NodoSimple actual = gestorSucursales.getListaSucursales().getCabeza();
        while (actual != null) {
            Sucursal s = (Sucursal) actual.getDato();
            if (s.getTelefono().toLowerCase().contains(criterio)) {
                resultados.insertarAlFinal(s);
            }
            actual = actual.getSiguiente();
        }
        return resultados.getCabeza();
    }

    public boolean actualizarSucursal(int idSucursal, String nombre, String direccion,
                                          String telefono, String gerente, int capacidadMesas,
                                          String horario, String estado) {
            Sucursal existente = gestorSucursales.buscarPorId(idSucursal);
            if (existente == null) {
                return false;
            }
            existente.setNombre(nombre);
            existente.setDireccion(direccion);
            existente.setTelefono(telefono);
            existente.setGerenteAsignado(gerente);
            existente.setCapacidadMesas(capacidadMesas);
            existente.setHorario(horario);
            existente.setEstado(estado);
            return true;
        }

    public boolean eliminarSucursalPorId(int idSucursal) {
            return gestorSucursales.eliminarPorId(idSucursal);
        }
        
        
//==========================================CARGA CSV=====================================
  
    public String cargarEmpleadosDesdeCSV(File archivo) {
        
            StringBuilder reporte = new StringBuilder();
            int exitosos = 0;
            int conErrores = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                int numeroLinea = 0;

                while ((linea = br.readLine()) != null) {
                    numeroLinea++;

                    // Saltar encabezado
                    if (numeroLinea == 1 && linea.toLowerCase().contains("nombre")) {
                        continue;
                    }

                    String[] partes = linea.split(",");


                    if (partes.length < 11) {
                        reporte.append("Línea ").append(numeroLinea)
                               .append(": columnas insuficientes.\n");
                        conErrores++;
                        continue;
                    }

                    try {
                        String nombre = partes[0].trim();
                        String usuario = partes[1].trim();
                        String contrasena = partes[2].trim();
                        String dpi = partes[3].trim();
                        String telefono = partes[4].trim();
                        String email = partes[5].trim();
                        String puesto = partes[6].trim();
                        String turno = partes[7].trim();
                        String sucursal = partes[8].trim();
                        double salario = Double.parseDouble(partes[9].trim());
                        boolean activo = partes[10].trim().equalsIgnoreCase("true")
                                      || partes[10].trim().equalsIgnoreCase("activo");

                        registrarEmpleado(
                                nombre,
                                usuario,
                                contrasena,
                                dpi,
                                telefono,
                                email,
                                puesto,
                                turno,
                                sucursal,
                                salario,
                                activo
                        );

                        exitosos++;
                    } catch (Exception e) {
                        reporte.append("Línea ").append(numeroLinea)
                               .append(": error al procesar -> ")
                               .append(e.getMessage()).append("\n");
                        conErrores++;
                    }
                }
            } catch (IOException e) {
                return "Error al leer el archivo: " + e.getMessage();
            }

            reporte.append("Empleados cargados correctamente: ").append(exitosos).append("\n");
            reporte.append("Líneas con errores: ").append(conErrores).append("\n");

            return reporte.toString();
        }
    
    public String cargarClientesDesdeCSV(File archivo) {
        StringBuilder reporte = new StringBuilder();
            int exitosos = 0;
            int conErrores = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                int numeroLinea = 0;

                while ((linea = br.readLine()) != null) {
                    numeroLinea++;

                    if (numeroLinea == 1 && linea.toLowerCase().contains("nombre")) {
                        continue;
                    }

                    String[] partes = linea.split(",");

                    if (partes.length < 8) {
                        reporte.append("Línea ").append(numeroLinea)
                               .append(": formato inválido.\n");
                        conErrores++;
                        continue;
                    }

                    try {
                        String nombre     = partes[0].trim();
                        String direccion  = partes[1].trim();
                        String usuario    = partes[2].trim();
                        String contrasena = partes[3].trim();
                        String telefono   = partes[4].trim();
                        String email      = partes[5].trim();
                        String nivel      = partes[6].trim();
                        int puntos        = Integer.parseInt(partes[7].trim());

                        registrarCliente(
                                nombre,
                                direccion,
                                usuario,
                                contrasena,
                                telefono,
                                email,
                                nivel,
                                puntos
                        );

                        exitosos++;
                    } catch (Exception e) {
                        reporte.append("Línea ").append(numeroLinea)
                               .append(": error al procesar -> ")
                               .append(e.getMessage()).append("\n");
                        conErrores++;
                    }
                }
            } catch (IOException e) {
                return "Error al leer el archivo: " + e.getMessage();
            }

            reporte.append("Clientes cargados correctamente: ").append(exitosos).append("\n");
            reporte.append("Líneas con errores: ").append(conErrores).append("\n");

            return reporte.toString();
        }
   
    public String cargarIngredientesDesdeCSV(File archivo) {
       StringBuilder detalleErrores = new StringBuilder(); 
        int exitosos = 0;
        int errores = 0;
        

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numeroLinea = 1;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().length() == 0) {
                    numeroLinea++;
                    continue;
                }

                String[] partes = linea.split(",");
                if (partes.length < 5) {
                    errores++;
                    detalleErrores.append("Línea ").append(numeroLinea)
                            .append(": formato inválido (se esperaban 5 campos)\n");
                    numeroLinea++;
                    continue;
                }

                try {
                    String nombre = partes[0].trim();
                    double cantidadStock = Double.parseDouble(partes[1].trim());
                    String unidadMedida = partes[2].trim();
                    double nivelMinimo = Double.parseDouble(partes[3].trim());
                    String proveedor = partes[4].trim();

                    Ingrediente ing = new Ingrediente(
                            nombre,
                            cantidadStock,
                            unidadMedida,
                            nivelMinimo,
                            proveedor
                    );

                    gestorInventario.registrarIngrediente(ing);
                    exitosos++;

                } catch (NumberFormatException e) {
                    errores++;
                    detalleErrores.append("Línea ").append(numeroLinea)
                            .append(": error numérico (cantidad/nivel)\n");
                }

                numeroLinea++;
            }

        } catch (java.io.IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("Registros exitosos: ").append(exitosos).append("\n");
        reporte.append("Registros con error: ").append(errores).append("\n\n");


        return reporte.toString();
    }
    
    public String cargarProductosDesdeCSV(File archivo) {
        StringBuilder detalleErrores = new StringBuilder();
        int exitosos = 0;
        int errores = 0;
        
        try (java.io.BufferedReader br = 
                new BufferedReader(new FileReader(archivo))) {

            String linea;
            int numeroLinea = 1;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().length() == 0) {
                    numeroLinea = numeroLinea + 1;
                    continue;
                }

                String[] partes = linea.split(",");
                if (partes.length < 6) {
                    errores = errores + 1;
                    detalleErrores.append("Línea ").append(numeroLinea)
                            .append(": formato inválido (se esperaban 6 campos)\n");
                    numeroLinea = numeroLinea + 1;
                    continue;
                }

                try {
                    String nombre = partes[0].trim();
                    String descripcion = partes[1].trim();
                    String categoria = partes[2].trim();
                    double precio = Double.parseDouble(partes[3].trim());
                    int tiempoPreparacion = Integer.parseInt(partes[4].trim());
                    String disponibleTexto = partes[5].trim().toLowerCase();
                    boolean disponible = false;
                    if (disponibleTexto.equals("true") || disponibleTexto.equals("si") 
                            || disponibleTexto.equals("sí")) {
                        disponible = true;
                    }

                    Producto p = new Producto(
                            nombre,
                            descripcion,
                            categoria,
                            precio,
                            tiempoPreparacion,
                            disponible
                    );

                    gestorProductos.registrarProducto(p);
                    exitosos = exitosos + 1;

                } catch (NumberFormatException e) {
                    errores = errores + 1;
                    detalleErrores.append("Línea ").append(numeroLinea)
                            .append(": error numérico (precio/tiempo)\n");
                }

                numeroLinea = numeroLinea + 1;
            }

        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("Registros exitosos: ").append(exitosos).append("\n");
        reporte.append("Registros con error: ").append(errores).append("\n\n");

        return reporte.toString();
    }
    
    public String cargarSucursalesDesdeCSV(File archivo) {
        StringBuilder detalleErrores = new StringBuilder();
        int exitosos = 0;
        int errores = 0;
        

        try (BufferedReader br =
                new BufferedReader(new FileReader(archivo))) {

            String linea;
            int numeroLinea = 1;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().length() == 0) {
                    numeroLinea = numeroLinea + 1;
                    continue;
                }

                String[] partes = linea.split(",");
                if (partes.length < 7) {
                    errores = errores + 1;
                    detalleErrores.append("Línea ").append(numeroLinea)
                            .append(": formato inválido (se esperaban 7 campos)\n");
                    numeroLinea = numeroLinea + 1;
                    continue;
                }

                try {
                    String nombre = partes[0].trim();
                    String direccion = partes[1].trim();
                    String telefono = partes[2].trim();
                    String gerente = partes[3].trim();
                    int capacidad = Integer.parseInt(partes[4].trim());
                    String horario = partes[5].trim();
                    String estado = partes[6].trim();

                    Sucursal s = new Sucursal(
                            nombre,
                            direccion,
                            telefono,
                            gerente,
                            capacidad,
                            horario,
                            estado
                    );

                    gestorSucursales.registrarSucursal(s);
                    exitosos = exitosos + 1;

                } catch (NumberFormatException e) {
                    errores = errores + 1;
                    detalleErrores.append("Línea ").append(numeroLinea)
                            .append(": error numérico en capacidad\n");
                }

                numeroLinea = numeroLinea + 1;
            }

        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("Registros exitosos: ").append(exitosos).append("\n");
        reporte.append("Registros con error: ").append(errores).append("\n\n");

        return reporte.toString();
    }


//====================================GUARDADO CSV=========================================
    public void guardarDatosEnCSV() {
        File carpetaDatos = new File("datos");
        if (!carpetaDatos.exists()) {
            carpetaDatos.mkdirs();
        }

        guardarEmpleadosCSV(new File(carpetaDatos, "Empleados.csv"));
        guardarClientesCSV(new File(carpetaDatos, "Clientes.csv"));
        guardarProductosCSV(new File(carpetaDatos, "Menú.csv"));
        guardarInventarioCSV(new File(carpetaDatos, "Inventario.csv"));
        guardarSucursalesEnCSV(new File(carpetaDatos, "Sucursales.csv"));
    } 
   
    public String guardarInventarioCSV(File archivo) {
        BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(archivo));
                NodoDoble actual = gestorInventario.getListaIngredientes().getCabeza();

                while (actual != null) {
                    Ingrediente ing = (Ingrediente) actual.getDato();

                    String linea = ing.getNombre() + "," +
                            ing.getCantidadStock() + "," +
                            ing.getUnidadMedida() + "," +
                            ing.getNivelMinimo() + "," +
                            ing.getProveedor();

                    bw.write(linea);
                    bw.newLine();

                    actual = actual.getSiguiente();
                }

                bw.flush();
                return "Inventario guardado correctamente en: " + archivo.getAbsolutePath();

            } catch (IOException e) {
                return "Error al guardar inventario: " + e.getMessage();
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }

    public String guardarProductosCSV(File archivo) {
        BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(archivo));
                NodoDoble actual = gestorProductos.getListaProductos().getCabeza();

                while (actual != null) {
                    Producto p = (Producto) actual.getDato();

                    String disponibleTexto = "false";
                    if (p.isDisponible()) {
                        disponibleTexto = "true";
                    }

                    String linea = p.getNombre() + "," +
                            p.getDescripcion() + "," +
                            p.getCategoria() + "," +
                            p.getPrecio() + "," +
                            p.getTiempoPreparacion() + "," +
                            disponibleTexto;

                    bw.write(linea);
                    bw.newLine();

                    actual = actual.getSiguiente();
                }

                bw.flush();
                return "Productos guardados correctamente en: " + archivo.getAbsolutePath();

            } catch (IOException e) {
                return "Error al guardar productos: " + e.getMessage();
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }

        public String guardarEmpleadosCSV(File archivo) {
            NodoDoble actual = gestorEmpleados.getListaEmpleados().getCabeza();
            if (actual == null) {
                return "No hay empleados para guardar.";
            }

            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(archivo));

                while (actual != null) {
                    Empleado e = (Empleado) actual.getDato();

                    String linea =
                            e.getNombreCompleto() + "," +
                            e.getUsuario() + "," +
                            e.getContrasena() + "," +
                            e.getDpi() + "," +
                            e.getTelefono() + "," +
                            e.getEmail() + "," +
                            e.getPuesto() + "," +
                            e.getTurno() + "," +
                            e.getSucursalAsignada() + "," +
                            e.getSalarioBase() + "," +
                            e.isActivo();

                    bw.write(linea);
                    bw.newLine();

                    actual = actual.getSiguiente();
                }

                bw.flush();
                return "Empleados guardados correctamente en: " + archivo.getAbsolutePath();

            } catch (IOException e) {
                return "Error al guardar empleados: " + e.getMessage();
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }


    public String guardarClientesCSV(File archivo) {
        NodoDoble actual = gestorClientes.getListaClientes().getCabeza();
            if (actual == null) {
                return "No hay clientes para guardar.";
            }

            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(archivo));

                while (actual != null) {
                    Cliente c = (Cliente) actual.getDato();

                    String linea = c.getNombreCompleto() + "," +
                            c.getDireccionEntrega() + "," +
                            c.getUsuario() + "," +
                            c.getContrasena() + "," +
                            c.getTelefono() + "," +
                            c.getEmail() + "," +
                            c.getNivel() + "," +
                            c.getPuntosAcumulados();

                    bw.write(linea);
                    bw.newLine();

                    actual = actual.getSiguiente();
                }

                bw.flush();
                return "Clientes guardados correctamente en: " + archivo.getAbsolutePath();

            } catch (IOException e) {
                return "Error al guardar clientes: " + e.getMessage();
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                }
            }
        }
    }

    
    public String guardarSucursalesEnCSV(File archivo) {
        BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(archivo));

                modelo.estructuras.NodoSimple actual =
                        gestorSucursales.getListaSucursales().getCabeza();

                while (actual != null) {
                    Sucursal s = (Sucursal) actual.getDato();

                    String linea = s.getNombre() + "," +
                            s.getDireccion() + "," +
                            s.getTelefono() + "," +
                            s.getGerenteAsignado() + "," +
                            s.getCapacidadMesas() + "," +
                            s.getHorario() + "," +
                            s.getEstado();

                    bw.write(linea);
                    bw.newLine();

                    actual = actual.getSiguiente();
                }

                bw.flush();
                return "Sucursales guardadas correctamente en: " + archivo.getAbsolutePath();

            } catch (IOException e) {
                return "Error al guardar sucursales: " + e.getMessage();
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }
}    
    
    
    
    
    
    
    
    
    
    

