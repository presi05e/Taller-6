/**
 * Clase Colores
 * Constantes de colores ANSI para la interfaz visual del arcade.
 */
public class Colores {

    // ─── Resetear ─────────────────────────────────────────────────────────────
    public static final String RESET = "\u001B[0m";

    // ─── Colores básicos ──────────────────────────────────────────────────────
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

    // ─── Colores brillantes ───────────────────────────────────────────────────
    public static final String NEGRO_BRILLANTE = "\u001B[90m";
    public static final String ROJO_BRILLANTE = "\u001B[91m";
    public static final String VERDE_BRILLANTE = "\u001B[92m";
    public static final String AMARILLO_BRILLANTE = "\u001B[93m";
    public static final String AZUL_BRILLANTE = "\u001B[94m";
    public static final String MAGENTA_BRILLANTE = "\u001B[95m";
    public static final String CIAN_BRILLANTE = "\u001B[96m";
    public static final String BLANCO_BRILLANTE = "\u001B[97m";

    // ─── Estilos ──────────────────────────────────────────────────────────────
    public static final String NEGRITA = "\u001B[1m";
    public static final String SUBRAYADO = "\u001B[4m";
    public static final String PARPADEANTE = "\u001B[5m";
    public static final String INVERTIDO = "\u001B[7m";

    // ─── Fondos ───────────────────────────────────────────────────────────────
    public static final String FONDO_NEGRO = "\u001B[40m";
    public static final String FONDO_ROJO = "\u001B[41m";
    public static final String FONDO_VERDE = "\u001B[42m";
    public static final String FONDO_AMARILLO = "\u001B[43m";
    public static final String FONDO_AZUL = "\u001B[44m";
    public static final String FONDO_MAGENTA = "\u001B[45m";
    public static final String FONDO_CIAN = "\u001B[46m";
    public static final String FONDO_BLANCO = "\u001B[47m";

    // ─── Combinaciones temáticas para el casino ───────────────────────────────
    public static final String TITULO = NEGRITA + AMARILLO_BRILLANTE;
    public static final String EXITO = NEGRITA + VERDE_BRILLANTE;
    public static final String ERROR = NEGRITA + ROJO_BRILLANTE;
    public static final String INFO = CIAN_BRILLANTE;
    public static final String BORDE = AMARILLO;
    public static final String SIMBOLO = NEGRITA + BLANCO_BRILLANTE;
    public static final String JACKPOT = NEGRITA + PARPADEANTE + AMARILLO_BRILLANTE;
    public static final String LUCKY = NEGRITA + MAGENTA_BRILLANTE;
}
