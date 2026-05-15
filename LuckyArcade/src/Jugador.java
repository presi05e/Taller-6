/**
 * Clase Jugador
 * Representa a un jugador del casino con su nombre, saldo y estadísticas.
 */
public class Jugador {

    private String nombre;
    private double saldo;
    private int partidasJugadas;
    private int partidasGanadas;
    private double mayorGanancia;

    // Easter Egg: turnos de bonificación activos
    private int turnosBono;

    public Jugador(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
        this.mayorGanancia = 0.0;
        this.turnosBono = 0;
    }

    public Jugador(String nombre, double saldo, int partidasJugadas, int partidasGanadas, double mayorGanancia) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.partidasJugadas = partidasJugadas;
        this.partidasGanadas = partidasGanadas;
        this.mayorGanancia = mayorGanancia;
        this.turnosBono = 0;
    }

    // ─── Getters y Setters ───────────────────────────────────────────────────

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public double getMayorGanancia() {
        return mayorGanancia;
    }

    public int getTurnosBono() {
        return turnosBono;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // ─── Métodos de juego ────────────────────────────────────────────────────

    public void apostar(double monto) {
        this.saldo -= monto;
    }

    public void ganar(double monto) {
        this.saldo += monto;
        this.partidasGanadas++;
        if (monto > this.mayorGanancia) {
            this.mayorGanancia = monto;
        }
    }

    public void registrarPartida() {
        this.partidasJugadas++;
    }

    public boolean tieneSaldoSuficiente(double monto) {
        return this.saldo >= monto;
    }

    // ─── Easter Egg ──────────────────────────────────────────────────────────

    /**
     * Verifica si el nombre es "LUCKY" (case-insensitive) para activar el Easter
     * Egg.
     */
    public boolean verificarEasterEggNombre() {
        return this.nombre.equalsIgnoreCase("LUCKY");
    }

    /**
     * Verifica si la apuesta es 777 para activar el Easter Egg.
     */
    public boolean verificarEasterEggApuesta(double apuesta) {
        return apuesta == 777;
    }

    /**
     * Activa 3 turnos de bono (doble probabilidad).
     */
    public void activarTurnosBono() {
        this.turnosBono = 3;
        System.out.println(Colores.AMARILLO_BRILLANTE
                + "\n   ¡AMULETO ACTIVADO! Tienes 3 turnos con probabilidades dobles." + Colores.RESET);
    }

    /**
     * Consume un turno de bono si está activo.
     * 
     * @return true si el bono está activo en este turno.
     */
    public boolean usarTurnoBono() {
        if (turnosBono > 0) {
            turnosBono--;
            return true;
        }
        return false;
    }

    // ─── Estadísticas ────────────────────────────────────────────────────────

    public double getPorcentajeVictorias() {
        if (partidasJugadas == 0)
            return 0.0;
        return (double) partidasGanadas / partidasJugadas * 100.0;
    }

    @Override
    public String toString() {
        return nombre + "," + saldo + "," + partidasJugadas + "," + partidasGanadas + "," + mayorGanancia;
    }
}
