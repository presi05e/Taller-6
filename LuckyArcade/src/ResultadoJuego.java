import java.util.ArrayList;
import java.util.List;

/**
 * Clase ResultadoJuego
 * Almacena el resultado de una tirada de la tragamonedas,
 * incluyendo todas las líneas ganadoras y el premio total.
 */
public class ResultadoJuego {

    private List<LineaGanadora> lineas;
    private double premioTotal;
    private int lineasGanadoras;
    private int multiplicadorTotal;

    public ResultadoJuego() {
        this.lineas = new ArrayList<>();
        this.premioTotal = 0.0;
        this.lineasGanadoras = 0;
        this.multiplicadorTotal = 1;
    }

    // ─── Métodos ─────────────────────────────────────────────────────────────

    public void agregarLinea(String tipo, String simbolo, double premio, double multiplicador) {
        lineas.add(new LineaGanadora(tipo, simbolo, premio, multiplicador));
    }

    public boolean hayPremio() {
        return premioTotal > 0;
    }

    // ─── Getters y Setters ────────────────────────────────────────────────────

    public List<LineaGanadora> getLineas() { return lineas; }
    public double getPremioTotal() { return premioTotal; }
    public int getLineasGanadoras() { return lineasGanadoras; }
    public int getMultiplicadorTotal() { return multiplicadorTotal; }

    public void setPremioTotal(double premioTotal) { this.premioTotal = premioTotal; }
    public void setLineasGanadoras(int lineasGanadoras) { this.lineasGanadoras = lineasGanadoras; }
    public void setMultiplicadorTotal(int multiplicadorTotal) { this.multiplicadorTotal = multiplicadorTotal; }

    // ─── Clase interna LineaGanadora ─────────────────────────────────────────

    public static class LineaGanadora {
        private String tipo;       // "Fila 1", "Columna 2", "Diagonal ↘", etc.
        private String simbolo;    // Símbolo que ganó
        private double premio;     // Monto ganado por esta línea
        private double multiplicador;

        public LineaGanadora(String tipo, String simbolo, double premio, double multiplicador) {
            this.tipo = tipo;
            this.simbolo = simbolo;
            this.premio = premio;
            this.multiplicador = multiplicador;
        }

        public String getTipo() { return tipo; }
        public String getSimbolo() { return simbolo; }
        public double getPremio() { return premio; }
        public double getMultiplicador() { return multiplicador; }
    }
}
