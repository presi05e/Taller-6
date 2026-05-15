import java.util.List;
import java.util.Scanner;

/**
 * Clase SlotMachine
 * Controlador principal del juego. Maneja el menú y el flujo de partidas.
 */
public class SlotMachine {

    private Jugador jugador;
    private Scanner scanner;
    private Rodillo rodillo;

    public SlotMachine(Jugador jugador, Scanner scanner) {
        this.jugador = jugador;
        this.scanner = scanner;
        this.rodillo = new Rodillo();

        // Easter Egg: si el nombre es LUCKY, activar bono inmediatamente
        if (jugador.verificarEasterEggNombre()) {
            jugador.activarTurnosBono();
        }
    }

    // ─── Bucle principal ──────────────────────────────────────────────────────

    public void iniciar() {
        boolean jugando = true;

        while (jugando) {
            Interfaz.mostrarMenu(jugador);
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    menuApostar();
                    break;
                case "2":
                    Interfaz.mostrarEstadisticas(jugador);
                    Interfaz.presionEnter(scanner);
                    break;
                case "3":
                    List<Jugador> ranking = GestorCSV.obtenerRanking();
                    Interfaz.mostrarRanking(ranking);
                    Interfaz.presionEnter(scanner);
                    break;
                case "4":
                    Interfaz.mostrarTablaPremios();
                    Interfaz.presionEnter(scanner);
                    break;
                case "5":
                    jugando = false;
                    break;
                default:
                    System.out.println(Colores.ROJO + "   Opción inválida. Intenta de nuevo." + Colores.RESET);
                    Interfaz.pausar(800);
            }
        }
    }

    // ─── Flujo de apuesta ─────────────────────────────────────────────────────

    private void menuApostar() {
        if (jugador.getSaldo() <= 0) {
            System.out.println(Colores.ROJO + "\n   ¡Te quedaste sin saldo! No puedes apostar." + Colores.RESET);
            Interfaz.presionEnter(scanner);
            return;
        }

        System.out.println();
        System.out.println(Colores.CIAN + "   Saldo disponible: " + Colores.VERDE_BRILLANTE + "$" +
                String.format("%.2f", jugador.getSaldo()) + Colores.RESET);
        System.out.print(Colores.CIAN + "   Ingresa tu apuesta (0 para cancelar): $" + Colores.RESET);

        double apuesta = 0;
        try {
            apuesta = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(Colores.ROJO + "   Apuesta inválida." + Colores.RESET);
            Interfaz.pausar(800);
            return;
        }

        if (apuesta == 0)
            return;

        if (apuesta < 0) {
            System.out.println(Colores.ROJO + "   La apuesta no puede ser negativa." + Colores.RESET);
            Interfaz.pausar(800);
            return;
        }

        if (!jugador.tieneSaldoSuficiente(apuesta)) {
            System.out.println(Colores.ROJO + "   Saldo insuficiente para esa apuesta." + Colores.RESET);
            Interfaz.pausar(800);
            return;
        }

        // Easter Egg: apuesta 777
        if (jugador.verificarEasterEggApuesta(apuesta)) {
            Interfaz.mostrarEasterEggApuesta();
            jugador.activarTurnosBono();
            Interfaz.mostrarMinijuegoDados(jugador);
            GestorCSV.guardarJugador(jugador);
            Interfaz.presionEnter(scanner);
            return;
        }

        // Ejecutar tirada
        ejecutarTirada(apuesta);
    }

    private void ejecutarTirada(double apuesta) {
        boolean bonoActivo = jugador.usarTurnoBono();

        if (bonoActivo) {
            System.out.println(Colores.MAGENTA_BRILLANTE + "\n   ¡TURNO CON BONO ACTIVO! Probabilidades aumentadas."
                    + Colores.RESET);
            Interfaz.pausar(800);
        }

        // Descontar apuesta
        jugador.apostar(apuesta);
        jugador.registrarPartida();

        // Animación de giro
        rodillo.animarGiro();

        // Giro real
        rodillo.girar(bonoActivo);

        // Mostrar resultado final
        Interfaz.limpiarPantalla();
        Interfaz.mostrarMiniTitulo();
        rodillo.dibujarPantalla();

        // Calcular y mostrar premio
        ResultadoJuego resultado = rodillo.calcularPremio(apuesta);
        Interfaz.mostrarResultado(resultado, apuesta);

        if (resultado.hayPremio()) {
            jugador.ganar(resultado.getPremioTotal());
        }

        // Guardar saldo inmediatamente en CSV
        GestorCSV.guardarJugador(jugador);

        System.out.printf(Colores.CIAN + "\n   Saldo actual: " + Colores.VERDE_BRILLANTE + "$%.2f%n" + Colores.RESET,
                jugador.getSaldo());

        if (jugador.getTurnosBono() > 0) {
            System.out.println(
                    Colores.MAGENTA_BRILLANTE + "   Bonos restantes: " + jugador.getTurnosBono() + Colores.RESET);
        }

        Interfaz.presionEnter(scanner);
    }
}
