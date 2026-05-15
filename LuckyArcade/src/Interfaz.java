import java.util.List;

/**
 * Clase Interfaz
 * Maneja toda la parte visual del juego: menús, ASCII art, mensajes y ranking.
 */
public class Interfaz {

    // ─── Pantalla de Bienvenida ───────────────────────────────────────────────

    public static void mostrarBienvenida() {
        limpiarPantalla();
        System.out.println();
        System.out.println(Colores.AMARILLO_BRILLANTE + Colores.NEGRITA);
        System.out.println("  ╔══════════════════════════════════════════════════╗");
        System.out.println("  ║                                                  ║");
        System.out.println("  ║   ████████╗██╗  ██╗███████╗                      ║");
        System.out.println("  ║      ██╔══╝██║  ██║██╔════╝                      ║");
        System.out.println("  ║      ██║   ███████║█████╗                        ║");
        System.out.println("  ║      ██║   ██╔══██║██╔══╝                        ║");
        System.out.println("  ║      ██║   ██║  ██║███████╗                      ║");
        System.out.println("  ║      ╚═╝   ╚═╝  ╚═╝╚══════╝                      ║");
        System.out.println("  ║                                                  ║");
        System.out.println("  ║    ██╗     ██╗   ██╗ ██████╗██╗  ██╗██╗   ██╗    ║");
        System.out.println("  ║    ██║     ██║   ██║██╔════╝██║ ██╔╝╚██╗ ██╔╝    ║");
        System.out.println("  ║    ██║     ██║   ██║██║     █████╔╝  ╚████╔╝     ║");
        System.out.println("  ║    ██║     ██║   ██║██║     ██╔═██╗   ╚██╔╝      ║");
        System.out.println("  ║    ███████╗╚██████╔╝╚██████╗██║  ██╗   ██║       ║");
        System.out.println("  ║    ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝   ╚═╝       ║");
        System.out.println("  ║                                                  ║");
        System.out.println("  ║           A R C A D E                            ║");
        System.out.println("  ║                                                  ║");
        System.out.println("  ╚══════════════════════════════════════════════════╝");
        System.out.println(Colores.RESET);
        System.out.println(Colores.CIAN + "         ¡Tu suerte comienza aquí!" + Colores.RESET);
        System.out.println(
                Colores.NEGRO_BRILLANTE + "  ─────────────────────────────────────────────────" + Colores.RESET);
    }

    public static void mostrarMiniTitulo() {
        System.out.println(Colores.AMARILLO_BRILLANTE + Colores.NEGRITA +
                "\n    THE LUCKY ARCADE  " + Colores.RESET);
    }

    // ─── Menú Principal ───────────────────────────────────────────────────────

    public static void mostrarMenu(Jugador jugador) {
                public static void mostrarMenu(Jugador jugador) {
                System.out.println();
                System.out.println(Colores.AMARILLO + "  ╔════════════════════════════════════╗" + Colores.RESET);
                System.out.println(Colores.AMARILLO + "  ║" + Colores.RESET + Colores.NEGRITA
                                + "          MENÚ PRINCIPAL            " + Colores.AMARILLO + "║" + Colores.RESET);
                System.out.println(Colores.AMARILLO + "  ╠════════════════════════════════════╣" + Colores.RESET);
                System.out.printf(
                                Colores.AMARILLO + "  ║" + Colores.RESET + "  Jugador: %-22s" + Colores.AMARILLO
                                                + "   ║%n"
                                                + Colores.RESET,
                                jugador.getNombre());
        System.out.printf(
                                Colores.AMARILLO + "  ║" + Colores.RESET + "   Saldo:   " + Colores.VERDE_BRILLANTE
                                                + "%-22s"
                                                + Colores.AMARILLO + "  ║%n" + Colores.RESET,
                                "$" + String.format("%.2f", jugador.getSaldo()));

                if (jugador.getTurnosBono() > 0) {
                        System.out.printf(
                                        Colores.AMARILLO + "  ║" + Colores.RESET + "   Bonos:   "
                                                        + Colores.MAGENTA_BRILLANTE + "%-22s"
                                                        + Colores.AMARILLO + "║%n" + Colores.RESET,
                                        jugador.getTurnosBono() + " turno(s) activo(s)");
                }
        System.out.println(Colores.AMARILLO + "  ╠════════════════════════════════════╣" + Colores.RESET);
                System.out.println(Colores.AMARILLO + "  ║" + Colores.RESET + "  1 Apostar                         "
                                + Colores.AMARILLO + "║" + Colores.RESET);
                System.out.println(Colores.AMARILLO + "  ║" + Colores.RESET + "  2  Ver Saldo y Estadísticas       "
                                + Colores.AMARILLO + "║" + Colores.RESET);
                System.out.println(Colores.AMARILLO + "  ║" + Colores.RESET + "  3  Ranking de Jugadores           "
                                + Colores.AMARILLO + "║" + Colores.RESET);
                System.out.println(Colores.AMARILLO + "  ║" + Colores.RESET + "  4  Tabla de Premios               "
                                + Colores.AMARILLO + "║" + Colores.RESET);
                System.out.println(Colores.AMARILLO + "  ║" + Colores.RESET + "  5 Salir                           "
                                + Colores.AMARILLO + "║" + Colores.RESET);
                System.out.println(Colores.AMARILLO + "  ╚════════════════════════════════════╝" + Colores.RESET);
                System.out.print(Colores.CIAN + "   Elige una opción: " + Colores.RESET);
        }

    // ─── Estadísticas del Jugador ─────────────────────────────────────────────

    public static void mostrarEstadisticas(Jugador jugador) {
                System.out.println();
                System.out.println(Colores.CIAN + "  ╔═══════════════════════════════════════╗" + Colores.RESET);
                System.out.println(Colores.CIAN + "  ║        TUS ESTADÍSTICAS               ║" + Colores.RESET);
                System.out.println(Colores.CIAN + "  ╠═══════════════════════════════════════╣" + Colores.RESET);
                System.out.printf(
                                Colores.CIAN + "  ║" + Colores.RESET + "   Jugador:        %-20s" + Colores.CIAN + "║%n"
                                                + Colores.RESET,
                                jugador.getNombre());
                System.out.printf(Colores.CIAN + "  ║" + Colores.RESET + "  Saldo actual:   " + Colores.VERDE_BRILLANTE
                                + "%-20s" + Colores.CIAN + " ║%n" + Colores.RESET,
                                "$" + String.format("%.2f", jugador.getSaldo()));
                System.out.printf(
                                Colores.CIAN + "  ║" + Colores.RESET + "   Partidas:       %-20s" + Colores.CIAN + "║%n"
                                                + Colores.RESET,
                                jugador.getPartidasJugadas());
                System.out.printf(
                                Colores.CIAN + "  ║" + Colores.RESET + "   Ganadas:        %-20s" + Colores.CIAN + "║%n"
                                                + Colores.RESET,
                                jugador.getPartidasGanadas());
                System.out.printf(
                                Colores.CIAN + "  ║" + Colores.RESET + "   Tasa de éxito:  %-20s" + Colores.CIAN + "║%n"
                                                + Colores.RESET,
                                String.format("%.1f%%", jugador.getPorcentajeVictorias()));
                System.out.printf(
                                Colores.CIAN + "  ║" + Colores.RESET + "   Mayor ganancia: "
                                                + Colores.AMARILLO_BRILLANTE + "%-20s"
                                                + Colores.CIAN + "║%n" + Colores.RESET,
                                "$" + String.format("%.2f", jugador.getMayorGanancia()));
                System.out.println(Colores.CIAN + "  ╚═══════════════════════════════════════╝" + Colores.RESET);
        }

    // ─── Ranking ──────────────────────────────────────────────────────────────

    public static void mostrarRanking(List<Jugador> jugadores) {
        System.out.println();
        System.out.println(Colores.AMARILLO_BRILLANTE + Colores.NEGRITA +
                "  ╔══════════════════════════════════════════════╗" + Colores.RESET);
        System.out.println(Colores.AMARILLO_BRILLANTE + Colores.NEGRITA +
                "  ║          🏆 RANKING DE CAMPEONES              ║" + Colores.RESET);
        System.out.println(Colores.AMARILLO_BRILLANTE + Colores.NEGRITA +
                "  ╠══════╦════════════════╦═══════════╦══════════╣" + Colores.RESET);
        System.out.println(Colores.AMARILLO_BRILLANTE +
                "  ║  #   ║ Jugador        ║ Saldo     ║ Victorias║" + Colores.RESET);
        System.out.println(Colores.AMARILLO_BRILLANTE +
                "  ╠══════╬════════════════╬═══════════╬══════════╣" + Colores.RESET);

        String[] medallas = { "1", "2", "3" };
        int limite = Math.min(jugadores.size(), 10);

        for (int i = 0; i < limite; i++) {
            Jugador j = jugadores.get(i);
            String pos = i < 3 ? medallas[i] : " #" + (i + 1);
            String color = i == 0 ? Colores.AMARILLO_BRILLANTE
                    : i == 1 ? Colores.BLANCO_BRILLANTE : i == 2 ? Colores.AMARILLO : Colores.RESET;

            System.out.printf(Colores.AMARILLO + "  ║" + Colores.RESET +
                    color + " %-4s " + Colores.AMARILLO + "║" + Colores.RESET +
                    color + " %-14s " + Colores.AMARILLO + "║" + Colores.RESET +
                    color + " %-9s " + Colores.AMARILLO + "║" + Colores.RESET +
                    color + " %-8s " + Colores.AMARILLO + "║%n" + Colores.RESET,
                    pos,
                    truncar(j.getNombre(), 14),
                    "$" + String.format("%.0f", j.getSaldo()),
                    j.getPartidasGanadas());
        }

        if (jugadores.isEmpty()) {
            System.out.println(Colores.AMARILLO + "  ║" + Colores.RESET +
                    "     Aún no hay jugadores registrados      " +
                    Colores.AMARILLO + "║" + Colores.RESET);
        }

        System.out.println(Colores.AMARILLO_BRILLANTE +
                "  ╚══════╩════════════════╩═══════════╩══════════╝" + Colores.RESET);
    }

    // ─── Tabla de Premios ─────────────────────────────────────────────────────

    public static void mostrarTablaPremios() {
                System.out.println();
                System.out.println(Colores.VERDE + "  ╔══════════════════════════════════════════╗" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║          TABLA DE PREMIOS                ║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ╠══════════════════════════════════════════╣" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + " Símbolo │ Nombre    │ Multiplicador   "
                                + Colores.VERDE + "   ║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ╠═════════╪═══════════╪════════════════════╣" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + Colores.AMARILLO_BRILLANTE + Colores.NEGRITA+
                "   7     " + Colores.RESET + Colores.VERDE + "│" + Colores.RESET +
                                " Jackpot   │   x10  (¡MÁXIMO!)  " + Colores.VERDE + "║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + Colores.VERDE_BRILLANTE +
                                "   $     " + Colores.RESET + Colores.VERDE + "│" + Colores.RESET +
                                " Dinero    │   x5               " + Colores.VERDE + "║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + Colores.MAGENTA_BRILLANTE +
                                "   @     " + Colores.RESET + Colores.VERDE + "│" + Colores.RESET +
                                " Arroba    │   x4               " + Colores.VERDE + "║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + Colores.CIAN_BRILLANTE +
                                "   *     " + Colores.RESET + Colores.VERDE + "│" + Colores.RESET +
                                " Estrella  │   x3               " + Colores.VERDE + "║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + Colores.AZUL_BRILLANTE +
                                "   #     " + Colores.RESET + Colores.VERDE + "│" + Colores.RESET +
                                " Hash      │   x2.5             " + Colores.VERDE + "║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + Colores.ROJO_BRILLANTE +
                                "   X     " + Colores.RESET + Colores.VERDE + "│" + Colores.RESET +
                                " Cruz      │   x2               " + Colores.VERDE + "║" + Colores.RESET);
        System.out.println(Colores.VERDE + "  ╠══════════════════════════════════════════╣" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + "  Diagonal gana x1.5 extra           "
                                + Colores.VERDE + "     ║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + "  Múltiples líneas = premio × líneas  "
                                + Colores.VERDE + "    ║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ║" + Colores.RESET + "  Apuesta 777 = Easter Egg activo!     "
                                + Colores.VERDE + "   ║" + Colores.RESET);
                System.out.println(Colores.VERDE + "  ╚══════════════════════════════════════════╝" + Colores.RESET);
        }

    // ─── Resultados de Juego ──────────────────────────────────────────────────

    public static void mostrarResultado(ResultadoJuego resultado, double apuesta) {
                System.out.println();
                if (!resultado.hayPremio()) {
                        System.out.println(Colores.ROJO + "  ╔════════════════════════════════════╗" + Colores.RESET);
                        System.out.println(Colores.ROJO + "  ║     ¡Sin suerte esta vez!          ║" + Colores.RESET);
                        System.out.printf(Colores.ROJO + "  ║  Perdiste: %-24s║%n" + Colores.RESET,
                                        "$" + String.format("%.2f", apuesta));
                        System.out.println(Colores.ROJO + "  ╚════════════════════════════════════╝" + Colores.RESET);
                } else {
            // ¡Ganaste!
            boolean esJackpot = resultado.getLineasGanadoras() >= 3;
                        String color = esJackpot ? Colores.AMARILLO_BRILLANTE + Colores.NEGRITA
                                        : Colores.VERDE_BRILLANTE + Colores.NEGRITA;

                        System.out.println(color + "  ╔════════════════════════════════════╗" + Colores.RESET);
                        if (esJackpot) {
                                System.out.println(
                                                Colores.JACKPOT + "  ║     ¡¡MEGA JACKPOT!!        ║" + Colores.RESET);
                        } else {
                                System.out.println(color + "  ║     ¡¡GANASTE!!                    ║" + Colores.RESET);
                        }
                        System.out.println(color + "  ╠════════════════════════════════════╣" + Colores.RESET);

                        for (ResultadoJuego.LineaGanadora linea : resultado.getLineas()) {
                                System.out.printf(color + "  ║   %-32s ║%n" + Colores.RESET,
                                                linea.getTipo() + " [" + linea.getSimbolo() + "] x" +
                                                                String.format("%.1f", linea.getMultiplicador()));
                        }

            if (resultado.getMultiplicadorTotal() > 1) {
                                System.out.printf(color + "  ║   Multiplicador combinado: x%-6s ║%n" + Colores.RESET,
                                                resultado.getMultiplicadorTotal());
                        }

                        System.out.println(color + "  ╠════════════════════════════════════╣" + Colores.RESET);
                        System.out.printf(color + "  ║   PREMIO TOTAL: %-18s ║%n" + Colores.RESET,
                                        "$" + String.format("%.2f", resultado.getPremioTotal()));
                        System.out.println(color + "  ╚════════════════════════════════════╝" + Colores.RESET);
                }
        }

    // ─── Easter Eggs ─────────────────────────────────────────────────────────

    public static void mostrarEasterEggNombre() {
        System.out.println();
        System.out.println(Colores.LUCKY + Colores.NEGRITA);
        System.out.println("  ╔══════════════════════════════════════════╗");
        System.out.println("  ║    ¡¡EL AMULETO TE RECONOCE!!            ║");
        System.out.println("  ║                                          ║");
        System.out.println("  ║  El nombre LUCKY desbloquea poderes      ║");
        System.out.println("  ║  especiales. ¡Tu primera tirada tendrá   ║");
        System.out.println("  ║  el BONO ACTIVO automáticamente!         ║");
        System.out.println("  ╚══════════════════════════════════════════╝");
        System.out.println(Colores.RESET);
    }

    public static void mostrarEasterEggApuesta() {
        System.out.println();
        System.out.println(Colores.LUCKY + Colores.NEGRITA);
        System.out.println("  ╔══════════════════════════════════════════╗");
        System.out.println("  ║   ¡¡APUESTA MÁGICA DETECTADA!!           ║");
        System.out.println("  ║                                          ║");
        System.out.println("  ║  La apuesta de $777 activa el AMULETO.   ║");
        System.out.println("  ║  Los próximos 3 turnos tendrán           ║");
        System.out.println("  ║  probabilidades dobles de ganar.         ║");
        System.out.println("  ╚══════════════════════════════════════════╝");
        System.out.println(Colores.RESET);
        pausar(2000);
    }

    public static void mostrarMinijuegoDados(Jugador jugador) {
        System.out.println(Colores.MAGENTA_BRILLANTE + Colores.NEGRITA);
        System.out.println("  ╔══════════════════════════════════════════╗");
        System.out.println("  ║           MINIJUEGO DE DADOS             ║");
        System.out.println("  ╠══════════════════════════════════════════╣");
        System.out.println(Colores.RESET);

        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int suma = dado1 + dado2;

        String[] caras = { "", "⚀", "⚁", "⚂", "⚃", "⚄", "⚅" };

        System.out.println(Colores.MAGENTA_BRILLANTE + "  ║  " + caras[dado1] + "  +  " + caras[dado2] + "  =  " + suma
                + " puntos          ║" + Colores.RESET);

        double bonusDados = 0;
        String mensaje;
        if (suma == 12) {
            bonusDados = jugador.getSaldo() * 0.20;
            mensaje = "¡DOBLE 6! +20% de tu saldo";
        } else if (suma >= 10) {
            bonusDados = jugador.getSaldo() * 0.10;
            mensaje = "¡Número alto! +10% de tu saldo";
        } else if (suma >= 7) {
            bonusDados = jugador.getSaldo() * 0.05;
            mensaje = "¡Número medio! +5% de tu saldo";
        } else {
            bonusDados = 0;
            mensaje = "Número bajo... Sin bonus";
        }

        if (bonusDados > 0) {
            jugador.ganar(bonusDados);
        }

        System.out.printf(Colores.MAGENTA_BRILLANTE + "  ║  %-40s║%n" + Colores.RESET, mensaje);
        if (bonusDados > 0) {
            System.out.printf(Colores.VERDE_BRILLANTE + "  ║    Ganaste: %-28s║%n" + Colores.RESET,
                    "$" + String.format("%.2f", bonusDados));
        }
        System.out
                .println(Colores.MAGENTA_BRILLANTE + "  ╚══════════════════════════════════════════╝" + Colores.RESET);
    }

    // ─── Utilidades ──────────────────────────────────────────────────────────

    public static void limpiarPantalla() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 3; i++)
                System.out.println();
        }
    }

    public static void pausar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void presionEnter(java.util.Scanner scanner) {
        System.out.print(Colores.NEGRO_BRILLANTE + "\n  [ Presiona ENTER para continuar... ]" + Colores.RESET);
        scanner.nextLine();
    }

    private static String truncar(String texto, int longitud) {
        if (texto.length() <= longitud)
            return texto;
        return texto.substring(0, longitud - 3) + "...";
    }
}
