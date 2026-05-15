import java.io.*;
import java.util.*;

/**
 * Clase GestorCSV
 * Maneja toda la persistencia de datos en el archivo jugadores.csv.
 * Métodos: cargarSaldo(), guardarSaldo(), obtenerRanking()
 */
public class GestorCSV {

    private static final String ARCHIVO_CSV = "jugadores.csv";
    private static final double SALDO_INICIAL = 1000.0;

    // ─── Cargar o Crear Jugador ───────────────────────────────────────────────

    /**
     * Busca al jugador en el CSV. Si existe, carga su saldo.
     * Si no existe, lo crea con el saldo inicial.
     */
    public static Jugador cargarOCrearJugador(String nombre) {
        asegurarArchivoExiste();

        List<String[]> registros = leerTodosLosRegistros();

        for (String[] registro : registros) {
            if (registro.length >= 2 && registro[0].equalsIgnoreCase(nombre)) {
                // Jugador encontrado
                try {
                    double saldo = Double.parseDouble(registro[1]);
                    int jugadas = registro.length > 2 ? Integer.parseInt(registro[2]) : 0;
                    int ganadas = registro.length > 3 ? Integer.parseInt(registro[3]) : 0;
                    double mayorGanancia = registro.length > 4 ? Double.parseDouble(registro[4]) : 0.0;

                    System.out.println(Colores.VERDE + "\n   ¡Bienvenido de vuelta, " + nombre + "! Saldo cargado: $"
                            + String.format("%.2f", saldo) + Colores.RESET);
                    return new Jugador(nombre, saldo, jugadas, ganadas, mayorGanancia);
                } catch (NumberFormatException e) {
                    System.out
                            .println(Colores.ROJO + "   Error leyendo datos. Creando nuevo perfil..." + Colores.RESET);
                }
            }
        }

        // Jugador no encontrado, crear nuevo
        Jugador nuevo = new Jugador(nombre, SALDO_INICIAL);
        guardarJugador(nuevo);
        System.out.println(Colores.CIAN + "\n   Nuevo jugador registrado: " + nombre + " | Saldo inicial: $"
                + SALDO_INICIAL + Colores.RESET);
        return nuevo;
    }

    // ─── Guardar Jugador ──────────────────────────────────────────────────────

    /**
     * Actualiza o inserta el registro del jugador en el CSV.
     */
    public static void guardarJugador(Jugador jugador) {
        asegurarArchivoExiste();

        List<String[]> registros = leerTodosLosRegistros();
        boolean encontrado = false;

        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).length >= 1 && registros.get(i)[0].equalsIgnoreCase(jugador.getNombre())) {
                // Actualizar registro existente
                registros.set(i, jugador.toString().split(","));
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            registros.add(jugador.toString().split(","));
        }

        escribirTodosLosRegistros(registros);
    }

    // ─── Ranking ──────────────────────────────────────────────────────────────

    /**
     * Obtiene la lista de todos los jugadores ordenados por saldo (descendente).
     */
    public static List<Jugador> obtenerRanking() {
        asegurarArchivoExiste();
        List<String[]> registros = leerTodosLosRegistros();
        List<Jugador> jugadores = new ArrayList<>();

        for (String[] registro : registros) {
            if (registro.length >= 2) {
                try {
                    String nombre = registro[0];
                    double saldo = Double.parseDouble(registro[1]);
                    int jugadas = registro.length > 2 ? Integer.parseInt(registro[2]) : 0;
                    int ganadas = registro.length > 3 ? Integer.parseInt(registro[3]) : 0;
                    double mayorGanancia = registro.length > 4 ? Double.parseDouble(registro[4]) : 0.0;
                    jugadores.add(new Jugador(nombre, saldo, jugadas, ganadas, mayorGanancia));
                } catch (NumberFormatException e) {
                    // Ignorar registros malformados
                }
            }
        }

        // Ordenar por saldo descendente
        jugadores.sort((a, b) -> Double.compare(b.getSaldo(), a.getSaldo()));
        return jugadores;
    }

    // ─── Métodos Privados de Utilidad ─────────────────────────────────────────

    private static void asegurarArchivoExiste() {
        File archivo = new File(ARCHIVO_CSV);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                // Escribir cabecera
                try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
                    pw.println("nombre,saldo,partidasJugadas,partidasGanadas,mayorGanancia");
                }
            } catch (IOException e) {
                System.out.println(Colores.ROJO + "   Error creando archivo CSV: " + e.getMessage() + Colores.RESET);
            }
        }
    }

    private static List<String[]> leerTodosLosRegistros() {
        List<String[]> registros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CSV))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea && linea.startsWith("nombre")) {
                    primeraLinea = false;
                    continue; // Saltar cabecera
                }
                primeraLinea = false;
                if (!linea.trim().isEmpty()) {
                    registros.add(linea.split(","));
                }
            }
        } catch (IOException e) {
            System.out.println(Colores.ROJO + "   Error leyendo CSV: " + e.getMessage() + Colores.RESET);
        }
        return registros;
    }

    private static void escribirTodosLosRegistros(List<String[]> registros) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_CSV))) {
            pw.println("nombre,saldo,partidasJugadas,partidasGanadas,mayorGanancia");
            for (String[] registro : registros) {
                pw.println(String.join(",", registro));
            }
        } catch (IOException e) {
            System.out.println(Colores.ROJO + "   Error guardando CSV: " + e.getMessage() + Colores.RESET);
        }
    }
}
