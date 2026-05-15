import java.util.Scanner;

/**
 * THE LUCKY ARCADE
 * Punto de entrada principal del programa.
 * Inicializa el juego y maneja el flujo principal.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar pantalla de bienvenida
        Interfaz.mostrarBienvenida();

        // Pedir nombre del jugador
        System.out.print("\n   Ingresa tu nombre de jugador: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            nombre = "Jugador";
        }

        // Cargar o crear jugador desde CSV
        Jugador jugador = GestorCSV.cargarOCrearJugador(nombre);

        // Verificar Easter Egg: nombre LUCKY
        boolean luckyActivo = jugador.verificarEasterEggNombre();
        if (luckyActivo) {
            Interfaz.mostrarEasterEggNombre();
        }

        // Iniciar la máquina tragamonedas
        SlotMachine maquina = new SlotMachine(jugador, scanner);
        maquina.iniciar();

        // Guardar saldo al cerrar
        GestorCSV.guardarJugador(jugador);
        System.out.println("\n   Progreso guardado. ¡Hasta la próxima, " + jugador.getNombre() + "!");
        System.out.println("  " + "═".repeat(50));
        scanner.close();
    }
}
