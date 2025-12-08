
package IPC1_Practica1_202500708;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import java.util.Scanner;

public class IPC1_Practica1_202500708 {
    //Variables Globales
    private static Scanner sc = new Scanner(System.in);
    private static final int Filas=20;
    private static final int Columnas = 10;
    private static int[][] Tablero = new int[Filas][Columnas];
    private static int puntaje = 0;
    private static int nivel = 1;
    private static int lineasEliminadas = 0;
    private static int partidasJugadas = 0;
    private static int lineasTotalesHistoricas = 0;
    private static int mejorPuntajeHistorico = 0;
    private static int puntosTotalesHistoricos = 0;
    private static int nivelTotalHistorico = 0; 
    private static int tetrisRealizados = 0;
    
    //Crea las Piezas
    private static int[][] piezaI= {
        {0,1,0,0},
        {0,1,0,0},
        {0,1,0,0},
        {0,1,0,0}
    };
     private static int[][] piezaO= {
        {1,1,0,0},
        {1,1,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };
     private static int[][] piezaT= {
        {0,1,0,0},
        {1,1,1,0},
        {0,0,0,0},
        {0,0,0,0}
    };
     private static int[][] piezaS= {
        {0,1,1,0},
        {1,1,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };
      private static int[][] piezaZ= {
        {1,1,0,0},
        {0,1,1,0},
        {0,0,0,0},
        {0,0,0,0}
    };
     private static int[][] piezaJ= {
        {1,0,0,0},
        {1,1,1,0},
        {0,0,0,0},
        {0,0,0,0}
    };
    private static int[][] piezaL= {
        {0,0,1,0},
        {1,1,1,0},
        {0,0,0,0},
        {0,0,0,0}
    };

public static void main(String[] args) {
    boolean salir = false;
    cargarEstadisticas();  // lee 1estadisticas.txt
    while(!salir){  
    System.out.println("|==================================|");    
    System.out.println("|         Carnet 202500708         |");
    System.out.println("|==================================|"); 
    System.out.println("|MENU PRINCIPAL                    |");
    System.out.println("|1. Jugar Partida Nueva            |");
    System.out.println("|2. Ver Mejores Puntajes           |");
    System.out.println("|3. Ver Estadisticas Generales     |");
    System.out.println("|4. Salir                          |");
    System.out.println("|==================================|");
    System.out.print("Elija una opcion: ");
    String entrada = sc.nextLine();
 try{
    
    int opcion = Integer.parseInt(entrada);
    switch(opcion){
        case 1:
            limpiarConsola();
            nuevapartida();
            break;
        case 2:
            limpiarConsola();
            verpuntajes();
            break;
        case 3:
            limpiarConsola();
            verEstadisticasGenerales();
            break;
        case 4:
            System.out.println("Fin del programa");
            salir = true;
            break;
        default:
            System.out.println("No es una opción valida");
            limpiarConsola();
            break;
        }   
    } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Por favor ingrese un numero de opcion.");
            limpiarConsola();
        }

        System.out.println();
    }
}
//----------------------------------------------------------------------
public static void nuevapartida() {
    boolean salir = false;
    puntaje = 0;
    nivel = 1;
    lineasEliminadas = 0;

    int inicioFila = 0;
    int inicioColumna = 4;

    int ejex = inicioColumna;
    int ejey = inicioFila;

    int[][] piezaActual = piezaAleatoria();
    int[][] piezaSiguiente = piezaAleatoria();

    iniciartablero();

    do {
        limpiarConsola();
        // Dibujar tablero y vista previa
        mostrartablero(piezaActual, ejey, ejex, piezaSiguiente);

        System.out.println("Comandos (ENTER=caer, espacio=hard drop, a=izq, d=der, w=rotar, s=bajar rapido, p= pausa, q=salir)");
        System.out.print("Ingrese un comando: ");
        String entrada = sc.nextLine();

        if (entrada.equalsIgnoreCase("a")) {
            if (colocable(piezaActual, ejey, ejex - 1)) {
                ejex -= 1; //mover a la izquierda
            }
        } else if (entrada.equalsIgnoreCase("d")) {
            if (colocable(piezaActual, ejey, ejex + 1)) {
                ejex += 1; //mover a la derecha
            }
        } else if (entrada.equalsIgnoreCase("w")) {
            // Rotar pieza 90 grados
            int[][] piezaRotada = rotarPieza(piezaActual);
            if (colocable(piezaRotada, ejey, ejex)) {
                piezaActual = piezaRotada;
            } else {
                System.out.println("No se puede rotar en esta posicion.");
            }

        } else if (entrada.equalsIgnoreCase("p")) {
             // Pausar el juego hasta que el usuario presione otra tecla
                System.out.println("Juego en PAUSA. Presione ENTER para reanudar...");
                sc.nextLine(); // espera a que el usuario presione ENTER
        }else if (entrada.equalsIgnoreCase("s")) {
            // Soft drop: bajar dos celdas y sumar 1 punto si se pudo
            if (colocable(piezaActual, ejey + 1, ejex)) {
                ejey += 2; 
                puntaje += 1;
            } else {
                // Ya no puede bajar: fijar pieza y manejar líneas / nueva pieza
                colocarpiezaentablero(piezaActual, ejex, ejey);
                System.out.println("La pieza ha sido fijada.");

                int lineasEliminadasAhora = eliminarLineas();
                lineasEliminadas += lineasEliminadasAhora;

                // Puntuación por líneas
                if (lineasEliminadasAhora == 1) {
                    puntaje += 100 * nivel;
                } else if (lineasEliminadasAhora == 2) {
                    puntaje += 300 * nivel;
                } else if (lineasEliminadasAhora == 3) {
                    puntaje += 500 * nivel;
                } else if (lineasEliminadasAhora == 4) {
                    puntaje += 800 * nivel;
                    tetrisRealizados++;
                }

                // Actualizar nivel (cada 10 líneas)
                int nuevoNivel = (lineasEliminadas / 10) + 1;
                if (nuevoNivel > nivel) {
                    nivel = nuevoNivel;
                    System.out.println("Subiste al nivel " + nivel + "!");
                }

                // Pasar siguiente pieza a actual y generar nueva siguiente
                piezaActual = piezaSiguiente;
                piezaSiguiente = piezaAleatoria();

                // Reiniciar posición
                ejex = inicioColumna;
                ejey = inicioFila;

                // Verificar si cabe la nueva pieza
                if (!colocable(piezaActual, ejey, ejex)) {
                    mostrartablero(null, -1, -1, null);
                    System.out.println("");
                    System.out.println("");
                    System.out.println("GAME OVER: no hay espacio para una nueva pieza.");
                    System.out.println("");
                    System.out.println("");
                    System.out.print("Ingrese su nombre: ");
                        String nombreJugador = sc.nextLine();
                        guardarMejorPuntaje(nombreJugador, puntaje, nivel, lineasEliminadas);
                        partidasJugadas++;
                        lineasTotalesHistoricas += lineasEliminadas;
                if (puntaje > mejorPuntajeHistorico) {
                    mejorPuntajeHistorico = puntaje;
                }
                            puntosTotalesHistoricos += puntaje;
                            nivelTotalHistorico += nivel;
                            guardarEstadisticas(); 
                            limpiarConsola();
                    salir = true;
                }
            }

        }else if (entrada.equalsIgnoreCase(" ")) {
    // Hard drop: bajar la pieza hasta el fondo
    int celdasBajadas = 0;

    // Bajar mientras se pueda
    while (colocable(piezaActual, ejey + 1, ejex)) {
        ejey += 1;
        celdasBajadas++;
    }

    // Si bajó al menos una celda, sumar puntos (2 por celda)
    if (celdasBajadas > 0) {
        puntaje += celdasBajadas * 2;
    }

    // Ya no puede bajar más: fijar pieza y manejar igual que cuando ENTER no puede bajar
    colocarpiezaentablero(piezaActual, ejex, ejey);
    System.out.println("Hard drop realizado. La pieza ha sido fijada.");

    int lineasEliminadasAhora = eliminarLineas();
    lineasEliminadas += lineasEliminadasAhora;

    // Puntuación por líneas
    if (lineasEliminadasAhora == 1) {
        puntaje += 100 * nivel;
    } else if (lineasEliminadasAhora == 2) {
        puntaje += 300 * nivel;
    } else if (lineasEliminadasAhora == 3) {
        puntaje += 500 * nivel;
    } else if (lineasEliminadasAhora == 4) {
        puntaje += 800 * nivel;
        tetrisRealizados++;
    }

    // Actualizar nivel
    int nuevoNivel = (lineasEliminadas / 10) + 1;
    if (nuevoNivel > nivel) {
        nivel = nuevoNivel;
        System.out.println("Subiste al nivel " + nivel + "!");
    }

    // Nueva pieza
    piezaActual = piezaSiguiente;
    piezaSiguiente = piezaAleatoria();

    ejex = inicioColumna;
    ejey = inicioFila;

    if (!colocable(piezaActual, ejey, ejex)) {
        mostrartablero(null, -1, -1, null);
        System.out.println("");
        System.out.println("");
        System.out.println("GAME OVER: no hay espacio para una nueva pieza.");
        System.out.println("");
        System.out.println("");
        System.out.print("Ingrese su nombre: ");
                        String nombreJugador = sc.nextLine();
                            guardarMejorPuntaje(nombreJugador, puntaje, nivel, lineasEliminadas);
                            partidasJugadas++;
                        lineasTotalesHistoricas += lineasEliminadas;
                if (puntaje > mejorPuntajeHistorico) {
                    mejorPuntajeHistorico = puntaje;
                }
                            puntosTotalesHistoricos += puntaje;
                            nivelTotalHistorico += nivel;
                            guardarEstadisticas();  
                            limpiarConsola();
                            
                            
                            salir = true;
        } 
    }else if (entrada.equals("")) {
            // ENTER vacío: caída automática sin puntos extra
            if (colocable(piezaActual, ejey + 1, ejex)) {
                ejey += 1;
            } else {
                // Misma lógica que cuando S no puede bajar
                colocarpiezaentablero(piezaActual, ejex, ejey);
                System.out.println("La pieza ha sido fijada.");

                int lineasEliminadasAhora = eliminarLineas();
                lineasEliminadas += lineasEliminadasAhora;

                // Puntuación por líneas
                if (lineasEliminadasAhora == 1) {
                    puntaje += 100 * nivel;
                } else if (lineasEliminadasAhora == 2) {
                    puntaje += 300 * nivel;
                } else if (lineasEliminadasAhora == 3) {
                    puntaje += 500 * nivel;
                } else if (lineasEliminadasAhora == 4) {
                    puntaje += 800 * nivel;
                }

                // Actualizar nivel
                int nuevoNivel = (lineasEliminadas / 10) + 1;
                if (nuevoNivel > nivel) {
                    nivel = nuevoNivel;
                    System.out.println("Subiste al nivel " + nivel + "!");
                }

                // Nueva pieza
                piezaActual = piezaSiguiente;
                piezaSiguiente = piezaAleatoria();

                ejex = inicioColumna;
                ejey = inicioFila;

                if (!colocable(piezaActual, ejey, ejex)) {
                    mostrartablero(null, -1, -1, null);
                    System.out.println("");
                    System.out.println("");
                    System.out.println("GAME OVER: no hay espacio para una nueva pieza.");
                    System.out.println("");
                    System.out.println("");
                    System.out.print("Ingrese su nombre: ");
                        String nombreJugador = sc.nextLine();
                            guardarMejorPuntaje(nombreJugador, puntaje, nivel, lineasEliminadas);
                     partidasJugadas++;
                        lineasTotalesHistoricas += lineasEliminadas;
                if (puntaje > mejorPuntajeHistorico) {
                    mejorPuntajeHistorico = puntaje;
                }
                            puntosTotalesHistoricos += puntaje;
                            nivelTotalHistorico += nivel;
                            guardarEstadisticas(); 
                            limpiarConsola();
                            salir = true;
                }
            }

        } else if (entrada.equals("q")) {
            salir = true;
            limpiarConsola();
        } else {
            System.out.println("Comando no reconocido.");
        }

    } while (!salir);
}
//----------------------------------------------------------------------
public static void iniciartablero(){
    for (int i=0; i<Filas;i++){
        for(int j=0; j<Columnas;j++){
            Tablero[i][j]=0;
            }
        }
    }
//----------------------------------------------------------------------
public static void mostrartablero(int[][] piezaActiva, int filaPieza, int colPieza, int[][] piezaSiguiente){
    // Barra superior
    System.out.println("========================================");
    System.out.println("=       TETRIS - CARNE: 202500708      =");
    System.out.println("========================================");
    System.out.println();

    // Borde superior del tablero
    System.out.print(" +-");
    for (int i = 0; i < Columnas; i++) {
        System.out.print("--");
    }
    System.out.println("+");

    // Filas del tablero
    for (int j = 0; j < Filas; j++) {
        // Parte izquierda: tablero
        System.out.print(" |");
        for (int x = 0; x < Columnas; x++) {

            boolean esPiezaActiva = false;
            if (piezaActiva != null) {
                int iPieza = j - filaPieza;
                int jPieza = x - colPieza;
                if (iPieza >= 0 && iPieza < 4 && jPieza >= 0 && jPieza < 4) {
                    if (piezaActiva[iPieza][jPieza] == 1) {
                        esPiezaActiva = true;
                    }
                }
            }

            if (esPiezaActiva) {
                System.out.print(" #");
            } else if (Tablero[j][x] == 0) {
                System.out.print(" .");
            } else {
                System.out.print(" =");
            }
        }
        System.out.print(" |");

        // Parte derecha: siguiente + puntaje
        if (j == 0) {
            System.out.print("    SIGUIENTE");
        } else if (j == 1) {
            System.out.print("    +---------+");
        } else if (j >= 2 && j <= 5) {
            System.out.print("    |");
            if (piezaSiguiente != null) {
                int filaPrev = j - 2; // 0..3
                for (int k = 0; k < 4; k++) {
                    if (piezaSiguiente[filaPrev][k] == 1) {
                        System.out.print(" =");
                    } else {
                        System.out.print(" .");
                    }
                }
            } else {
                System.out.print(" . . . .");
            }
            System.out.print(" |");
        } else if (j == 6) {
            System.out.print("    +---------+");
        } else if (j == 8) {
            System.out.print("  PUNTUACION");
        } else if (j == 9) {
            System.out.print("  --------------");
        } else if (j == 10) {
            System.out.print("  " + puntaje + " pts");
        } else if (j == 12) {
            System.out.print("  NIVEL: " + nivel);
        } else if (j == 13) {
            System.out.print("  LINEAS: " + lineasEliminadas);
        }

        System.out.println();
    }

    // Borde inferior del tablero
    System.out.print(" +-");
    for (int i = 0; i < Columnas; i++) {
        System.out.print("--");
    }
    System.out.println("+");

    System.out.println();
    System.out.println("CONTROLES: A/D (izq/der) | S (abajo rapido) | W (rotar) | ESPACIO (hard drop) | P (pausa) | 1 (salir)");
}
//----------------------------------------------------------------------
public static void colocarpiezaentablero(int[][] pieza, int columna, int fila){
 for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (pieza[i][j] == 1) {
                int filaTablero = fila + i;
                int colTablero = columna + j;
                Tablero[filaTablero][colTablero] = 1;
            }
        }
    }    
}    
//----------------------------------------------------------------------
public static boolean colocable(int[][] pieza, int fila, int columna){
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (pieza[i][j] == 1) {
                int filaTablero = fila + i;
                int colTablero = columna + j;
                // Verificar que no se salga del tablero
                if (filaTablero < 0 || filaTablero >= Filas) {
                    return false;
                }
                if (colTablero < 0 || colTablero >= Columnas) {
                    return false;
                }
                
                if (Tablero[filaTablero][colTablero] == 1) {
                    return false;
                }
            }
        }
    }
    return true;
}
//----------------------------------------------------------------------
public static int[][] piezaAleatoria(){
    int numero = (int)(Math.random() * 7);
//Dependiendo el numero que se genere, se escoge la pieza
        if (numero == 0) {
            return piezaI;
            } else if (numero == 1) {
                return piezaO;
            } else if (numero == 2) {
                return piezaT;
            } else if (numero == 3) {
                return piezaS;
            } else if (numero == 4) {
                return piezaZ;
            } else if (numero == 5) {
                return piezaJ;
            } else {
                return piezaL;
        }
    }
//----------------------------------------------------------------------
public static int[][] rotarPieza(int[][] pieza) {
    int[][] rotada = new int[4][4];

    // Transponer: rotada[i][j] = pieza[j][i]
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            rotada[i][j] = pieza[3 - j][i];
        }
    }

    return rotada;
}
//----------------------------------------------------------------------
public static int eliminarLineas(){
    int lineasEliminadasActual = 0;

    // Recorremos de abajo hacia arriba
    for (int fila = Filas - 1; fila >= 0; fila--) {
        boolean filaCompleta = true;

        // Verificar si la fila está llena
        for (int col = 0; col < Columnas; col++) {
            if (Tablero[fila][col] == 0) {
                filaCompleta = false;
                break;
            }
        }

        // Si la fila está completa, la eliminamos
        if (filaCompleta) {
            lineasEliminadasActual++;

            // Bajar todas las filas superiores una posición
            for (int fArriba = fila; fArriba > 0; fArriba--) {
                for (int col = 0; col < Columnas; col++) {
                    Tablero[fArriba][col] = Tablero[fArriba - 1][col];
                }
            }

            // La fila superior (fila 0) se llena de ceros
            for (int col = 0; col < Columnas; col++) {
                Tablero[0][col] = 0;
            }

            // Volvemos a revisar la misma fila, porque ahora tiene el contenido de arriba
            fila++;
        }
    }
    
    return lineasEliminadasActual;
    }
//----------------------------------------------------------------------
public static void guardarMejorPuntaje(String nombre, int puntaje, int nivel, int lineas) {
    // Limitar nombre a 15 caracteres
    if (nombre.length() > 15) {
        nombre = nombre.substring(0, 15);
    }

    // Fecha y hora actual
    LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    String fechaTexto = ahora.format(formato);

    // Formato: nombre;puntos;nivel;lineas;fecha
    String linea = nombre + ";" + puntaje + ";" + nivel + ";" + lineas + ";" + fechaTexto;

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("mejores_puntajes.txt", true))) {
        bw.write(linea);
        bw.newLine();
    } catch (IOException e) {
        System.out.println("No se pudo guardar el puntaje en el archivo.");
    }
}
//----------------------------------------------------------------------
public static void verpuntajes() {
    System.out.println("|=============================================|");    
    System.out.println("|               Carnet 202500708              |");
    System.out.println("|=============================================|");
    System.out.println("|=============== MEJORES PUNTAJES ============|");
    try (java.io.BufferedReader br = new java.io.BufferedReader(
            new java.io.FileReader("mejores_puntajes.txt"))) {

        String[] lineas = new String[100];
        int[] puntos = new int[100];
        int cantidad = 0;

        String linea;
        while ((linea = br.readLine()) != null && cantidad < 100) {
            String[] partes = linea.split(";");
            if (partes.length >= 2) {
                lineas[cantidad] = linea;
                try {
                    puntos[cantidad] = Integer.parseInt(partes[1]); // puntos en posición 1
                } catch (NumberFormatException e) {
                    puntos[cantidad] = 0;
                }
                cantidad++;
            }
        }
        // Ordenar por puntaje de mayor a menor (burbuja simple)
        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad - 1 - i; j++) {
                if (puntos[j] < puntos[j + 1]) {
                    int tmpP = puntos[j];
                    puntos[j] = puntos[j + 1];
                    puntos[j + 1] = tmpP;

                    String tmpL = lineas[j];
                    lineas[j] = lineas[j + 1];
                    lineas[j + 1] = tmpL;
                }
            }
        }
        // Mostrar hasta 10 mejores
        if (cantidad == 0) {
            System.out.println("No hay puntajes registrados aún.");
        } else {
            int limite = (cantidad < 10) ? cantidad : 10;
            for (int i = 0; i < limite; i++) {
                String[] partes = lineas[i].split(";");
                if (partes.length >= 5) {
                    String nombre = partes[0];
                    String puntosTxt = partes[1];
                    String nivelTxt = partes[2];
                    String lineasTxt = partes[3];
                    String fecha = partes[4];

                    System.out.println((i + 1) + ". " + nombre +
                            " | Pts: " + puntosTxt +
                            " | Nivel: " + nivelTxt +
                            " | Lineas: " + lineasTxt +
                            " | " + fecha);
                }
            }
        }

    } catch (java.io.IOException e) {
        System.out.println("No se pudo leer el archivo mejores_puntajes.txt");
    }

    System.out.println("\nPresione ENTER para volver al menú...");
    sc.nextLine();
    limpiarConsola();
}
//----------------------------------------------------------------------
public static void guardarEstadisticas() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("estadisticas.txt"))) {
        bw.write("PARTIDAS JUGADAS: " + partidasJugadas);
        bw.newLine();
        bw.write("LINEAS ELIMINADAS TOTALES: " + lineasTotalesHistoricas);
        bw.newLine();
        bw.write("MEJOR PUNTAJE: " + mejorPuntajeHistorico);
        bw.newLine();
        int promedioPuntos = (partidasJugadas > 0) ? puntosTotalesHistoricos / partidasJugadas : 0;
        int promedioNivel = (partidasJugadas > 0) ? nivelTotalHistorico / partidasJugadas : 0;
        bw.write("PROMEDIO PUNTOS: " + promedioPuntos);
        bw.newLine();
        bw.write("PROMEDIO NIVEL: " + promedioNivel);
        bw.newLine();
        bw.write("TETRIS REALIZADOS: " + tetrisRealizados);
        bw.newLine();
    } catch (IOException e) {
        System.out.println("No se pudo guardar estadisticas.txt");
    }
}
//----------------------------------------------------------------------
public static void cargarEstadisticas() {
    java.io.File f = new java.io.File("estadisticas.txt");
    if (!f.exists()) {
        return; // primera vez, no hay archivo
    }

    try (java.io.BufferedReader br = new java.io.BufferedReader(
            new java.io.FileReader(f))) {

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(":");
            if (partes.length == 2) {
                String clave = partes[0];
                int valor;
                try {
                    valor = Integer.parseInt(partes[1]);
                } catch (NumberFormatException e) {
                    continue;
                }

                if (clave.equals("PARTIDAS JUGADAS")) {
                    partidasJugadas = valor;
                } else if (clave.equals("LINEAS ELIMINADAS TOTALES")) {
                    lineasTotalesHistoricas = valor;
                } else if (clave.equals("MEJOR PUNTAJE")) {
                    mejorPuntajeHistorico = valor;
                } else if (clave.equals("TETRIS REALIZADOS")){
                    tetrisRealizados = valor;                
                }else if (clave.equals("PROMEDIO PUNTOS")){
                }else if(clave.equals("PROMEDIO NIVEL")){
                    
                }
            }
        }
    } catch (java.io.IOException e) {
        System.out.println("No se pudo leer estadisticas.txt");
    }
}
//----------------------------------------------------------------------
public static void verEstadisticasGenerales() {
    int promedioPuntos = (partidasJugadas > 0) ? puntosTotalesHistoricos / partidasJugadas : 0;
    int promedioNivel = (partidasJugadas > 0) ? nivelTotalHistorico / partidasJugadas : 0;
    
    System.out.println("|=============================================|");    
    System.out.println("|               Carnet 202500708              |");
    System.out.println("|=============================================|");
    System.out.println("|================== GENERALES ================|");
    System.out.println("|Partidas jugadas: " + partidasJugadas + "                          |");
    System.out.println("|Lineas totales eliminadas: " + lineasTotalesHistoricas + "                 |");
    System.out.println("|Mejor puntaje historico: " + mejorPuntajeHistorico + "                   |");
    System.out.println("|Total puntos: " + puntosTotalesHistoricos+ "                              |");
    System.out.println("|Promedio puntos: " + promedioPuntos + "                           |");
    System.out.println("|Promedio nivel: " + promedioNivel + "                            |");
    System.out.println("|Tetris realizados: " + tetrisRealizados + "                         |");
    System.out.println("|=============================================|");
    System.out.println("\nPresione ENTER para volver al menú...");
    
    sc.nextLine();
    limpiarConsola();
}
//----------------------------------------------------------------------
public static void limpiarConsola() {
    //"Limpia la consola" (No encontre otra forma de hacerlo)
   for (int i = 0; i < 40; i++) {
        System.out.println();
        }
    }
}




































//Trikitrakatelas :p
       
