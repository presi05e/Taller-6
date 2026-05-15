import java.util.Random;

/**
 * Clase Rodillo
 * Maneja la matriz 3x3 de la tragamonedas y la lógica de premios.
 * Implementa: dibujarPantalla(), calcularPremio(), animarGiro()
 */
public class Rodillo {

    // ─── Símbolos del juego ───────────────────────────────────────────────────
    private static final String[] SIMBOLOS = {"7", "X", "$", "*", "@", "#"};

    // Representación visual de cada símbolo con colores
    private static final String[] SIMBOLOS_COLOREADOS = {
        Colores.AMARILLO_BRILLANTE + Colores.NEGRITA + " 7 " + Colores.RESET,  // 7 - Dorado (mayor premio)
        Colores.ROJO_BRILLANTE     + Colores.NEGRITA + " X " + Colores.RESET,  // X - Rojo
        Colores.VERDE_BRILLANTE    + Colores.NEGRITA + " $ " + Colores.RESET,  // $ - Verde
        Colores.CIAN_BRILLANTE     + Colores.NEGRITA + " * " + Colores.RESET,  // * - Cian
        Colores.MAGENTA_BRILLANTE  + Colores.NEGRITA + " @ " + Colores.RESET,  // @ - Magenta
        Colores.AZUL_BRILLANTE     + Colores.NEGRITA + " # " + Colores.RESET   // # - Azul
    };

    // Multiplicadores de premio por símbolo (índice coincide con SIMBOLOS)
    private static final double[] MULTIPLICADORES_SIMBOLO = {10.0, 2.0, 5.0, 3.0, 4.0, 2.5};

    private String[][] rodillos;
    private Random random;

    public Rodillo() {
        rodillos = new String[3][3];
        random = new Random();
    }

    // ─── Girar ────────────────────────────────────────────────────────────────

    /**
     * Llena la matriz con símbolos aleatorios.
     * Si el bono está activo, aumenta la probabilidad de coincidir.
     */
    public void girar(boolean bonoActivo) {
        if (bonoActivo) {
            girarConBono();
        } else {
            girarNormal();
        }
    }

    private void girarNormal() {
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                int idx = (int) (Math.random() * SIMBOLOS.length);
                rodillos[fila][col] = SIMBOLOS[idx];
            }
        }
    }

    /**
     * Giro con bono: tiene 40% de probabilidad de forzar una línea ganadora.
     */
    private void girarConBono() {
        girarNormal();
        // 40% de probabilidad de forzar coincidencia en una fila aleatoria
        if (random.nextDouble() < 0.40) {
            int filaForzada = random.nextInt(3);
            String simboloForzado = SIMBOLOS[random.nextInt(SIMBOLOS.length)];
            for (int col = 0; col < 3; col++) {
                rodillos[filaForzada][col] = simboloForzado;
            }
        }
    }

    // ─── dibujarPantalla() ────────────────────────────────────────────────────

    /**
     * Imprime la matriz 3x3 de forma estética con bordes y colores.
     */
    public void dibujarPantalla() {
        String borde = Colores.BORDE;
        String reset = Colores.RESET;

        System.out.println();
        System.out.println("  " + borde + "╔═══════════════════════╗" + reset);
        System.out.println("  " + borde + "║" + reset + "   THE LUCKY ARCADE    " + borde + "║" + reset);
        System.out.println("  " + borde + "╠═══════╦═══════╦═══════╣" + reset);

        for (int fila = 0; fila < 3; fila++) {
            System.out.print("  " + borde + "║" + reset);
            for (int col = 0; col < 3; col++) {
                System.out.print(obtenerSimboloColoreado(rodillos[fila][col]));
                System.out.print(borde + "║" + reset);
            }
            System.out.println();
            if (fila < 2) {
                System.out.println("  " + borde + "╠═══════╬═══════╬═══════╣" + reset);
            }
        }

        System.out.println("  " + borde + "╚═══════╩═══════╩═══════╝" + reset);
    }

    /**
     * Versión de dibujo para la animación (más rápida, sin colores complejos).
     */
    public void dibujarPantallaAnimacion() {
        String borde = Colores.NEGRO_BRILLANTE;
        String reset = Colores.RESET;

        System.out.println();
        System.out.println("  " + borde + "╔═══════════════════════╗" + reset);
        System.out.println("  " + borde + "║" + reset + "      GIRANDO...       " + borde + "║" + reset);
        System.out.println("  " + borde + "╠═══════╦═══════╦═══════╣" + reset);

        for (int fila = 0; fila < 3; fila++) {
            System.out.print("  " + borde + "║" + reset);
            for (int col = 0; col < 3; col++) {
                // Durante animación, mostrar símbolos aleatorios rápidamente
                String s = SIMBOLOS[(int)(Math.random() * SIMBOLOS.length)];
                System.out.print(Colores.NEGRO_BRILLANTE + "  " + s + "  " + reset);
                System.out.print(borde + "║" + reset);
            }
            System.out.println();
            if (fila < 2) {
                System.out.println("  " + borde + "╠═══════╬═══════╬═══════╣" + reset);
            }
        }
        System.out.println("  " + borde + "╚═══════╩═══════╩═══════╝" + reset);
    }

    // ─── animarGiro() ─────────────────────────────────────────────────────────

    /**
     * Crea el efecto visual de movimiento de la tragamonedas.
     */
    public void animarGiro() {
        int frames = 8;
        for (int i = 0; i < frames; i++) {
            limpiarPantalla();
            Interfaz.mostrarMiniTitulo();
            dibujarPantallaAnimacion();

            // Velocidad variable: empieza rápido, termina lento
            int delay = 80 + (i * 30);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // ─── calcularPremio() ─────────────────────────────────────────────────────

    /**
     * Calcula el premio ganado basado en líneas coincidentes.
     * Retorna el multiplicador total del premio.
     * 
     * Líneas que se verifican:
     * - 3 filas horizontales
     * - 3 columnas verticales  
     * - 2 diagonales
     */
    public ResultadoJuego calcularPremio(double apuesta) {
        ResultadoJuego resultado = new ResultadoJuego();
        int lineasGanadoras = 0;
        double premioTotal = 0.0;

        // ── Verificar filas ───────────────────────────────────────────────────
        for (int fila = 0; fila < 3; fila++) {
            if (esLineaGanadora(rodillos[fila][0], rodillos[fila][1], rodillos[fila][2])) {
                double multiplicador = obtenerMultiplicador(rodillos[fila][0]);
                double premio = apuesta * multiplicador;
                premioTotal += premio;
                lineasGanadoras++;
                resultado.agregarLinea("Fila " + (fila + 1), rodillos[fila][0], premio, multiplicador);
            }
        }

        // ── Verificar columnas ────────────────────────────────────────────────
        for (int col = 0; col < 3; col++) {
            if (esLineaGanadora(rodillos[0][col], rodillos[1][col], rodillos[2][col])) {
                double multiplicador = obtenerMultiplicador(rodillos[0][col]);
                double premio = apuesta * multiplicador;
                premioTotal += premio;
                lineasGanadoras++;
                resultado.agregarLinea("Columna " + (col + 1), rodillos[0][col], premio, multiplicador);
            }
        }

        // ── Verificar diagonal principal (↘) ──────────────────────────────────
        if (esLineaGanadora(rodillos[0][0], rodillos[1][1], rodillos[2][2])) {
            double multiplicador = obtenerMultiplicador(rodillos[0][0]) * 1.5; // Bonus diagonal
            double premio = apuesta * multiplicador;
            premioTotal += premio;
            lineasGanadoras++;
            resultado.agregarLinea("Diagonal ↘", rodillos[0][0], premio, multiplicador);
        }

        // ── Verificar diagonal secundaria (↙) ─────────────────────────────────
        if (esLineaGanadora(rodillos[0][2], rodillos[1][1], rodillos[2][0])) {
            double multiplicador = obtenerMultiplicador(rodillos[0][2]) * 1.5; // Bonus diagonal
            double premio = apuesta * multiplicador;
            premioTotal += premio;
            lineasGanadoras++;
            resultado.agregarLinea("Diagonal ↙", rodillos[0][2], premio, multiplicador);
        }

        // ── Multiplicador por múltiples líneas ────────────────────────────────
        if (lineasGanadoras > 1) {
            premioTotal *= lineasGanadoras; // Premio se multiplica por # de líneas
            resultado.setMultiplicadorTotal(lineasGanadoras);
        }

        resultado.setPremioTotal(premioTotal);
        resultado.setLineasGanadoras(lineasGanadoras);
        return resultado;
    }

    // ─── Métodos privados de ayuda ────────────────────────────────────────────

    private boolean esLineaGanadora(String a, String b, String c) {
        return a != null && a.equals(b) && b.equals(c);
    }

    private double obtenerMultiplicador(String simbolo) {
        for (int i = 0; i < SIMBOLOS.length; i++) {
            if (SIMBOLOS[i].equals(simbolo)) {
                return MULTIPLICADORES_SIMBOLO[i];
            }
        }
        return 1.0;
    }

    private String obtenerSimboloColoreado(String simbolo) {
        if (simbolo == null) return "  ?  ";
        for (int i = 0; i < SIMBOLOS.length; i++) {
            if (SIMBOLOS[i].equals(simbolo)) {
                return SIMBOLOS_COLOREADOS[i];
            }
        }
        return " " + simbolo + " ";
    }

    private void limpiarPantalla() {
        // Intenta limpiar la consola de forma multiplataforma
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla, usar saltos de línea
            for (int i = 0; i < 5; i++) System.out.println();
        }
    }

    public String[][] getRodillos() { return rodillos; }
}
