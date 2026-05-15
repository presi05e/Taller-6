# 🎰 The Lucky Arcade — Proyecto Final

Simulador de máquina tragamonedas en consola con persistencia de saldo.

---

## 📁 Estructura del Proyecto

```
LuckyArcade/
├── src/
│   ├── Main.java           → Punto de entrada del programa
│   ├── Jugador.java        → Modelo del jugador (saldo, stats, easter egg)
│   ├── SlotMachine.java    → Controlador principal del juego y menú
│   ├── Rodillo.java        → Matriz 3x3, animación y lógica de premios
│   ├── ResultadoJuego.java → Resultado de cada tirada (líneas ganadoras)
│   ├── GestorCSV.java      → Persistencia: cargarSaldo() / guardarSaldo()
│   ├── Interfaz.java       → Toda la UI: ASCII art, menús, ranking, colores
│   └── Colores.java        → Constantes ANSI para colores en consola
├── jugadores.csv           → Generado automáticamente al correr el juego
└── README.md
```

---

## ▶️ Cómo Compilar y Ejecutar

```bash
# 1. Compilar
javac -d out src/*.java

# 2. Ejecutar
java -cp out Main
```

---

## 🎮 Funcionalidades

### Paso 1 — Persistencia CSV
- Al iniciar, pide el nombre del jugador
- Busca en `jugadores.csv`: si existe carga su saldo, si no lo crea con $1000
- El CSV se actualiza **cada vez que el saldo cambia** y al cerrar el programa

### Paso 2 — Matriz 3x3
- Rodillo de `String[3][3]` con símbolos: `{"7", "X", "$", "*", "@", "#"}`
- Cada celda se llena con `Math.random()` al girar

### Paso 3 — Lógica de Premios
| Símbolo | Multiplicador |
|---------|--------------|
| `7`     | x10 (Jackpot)|
| `$`     | x5           |
| `@`     | x4           |
| `*`     | x3           |
| `#`     | x2.5         |
| `X`     | x2           |

- **Filas**: 3 líneas horizontales verificadas
- **Columnas**: 3 líneas verticales verificadas
- **Diagonal ↘**: x1.5 bonus adicional
- **Diagonal ↙**: x1.5 bonus adicional
- **Múltiples líneas**: el premio total se multiplica por el número de líneas ganadoras

### Paso 4 — Experiencia de Usuario
- Menú con 5 opciones: Apostar / Ver Saldo / Ranking / Tabla Premios / Salir
- Animación de giro con velocidad variable (empieza rápido, termina lento)
- ASCII Art en pantalla de bienvenida
- Colores ANSI en toda la interfaz

### Paso 5 — Modularidad
| Método | Clase | Descripción |
|--------|-------|-------------|
| `cargarOCrearJugador()` | `GestorCSV` | Carga o crea jugador en CSV |
| `guardarJugador()` | `GestorCSV` | Guarda saldo actualizado |
| `dibujarPantalla()` | `Rodillo` | Imprime la matriz 3x3 estéticamente |
| `calcularPremio()` | `Rodillo` | Retorna el monto ganado |
| `animarGiro()` | `Rodillo` | Crea el efecto visual de movimiento |
| `mostrarMenu()` | `Interfaz` | Dibuja el menú principal |
| `mostrarRanking()` | `Interfaz` | Tabla de campeones ordenada |

---

## 🥚 Easter Egg — El Amuleto

**Forma 1 — Nombre LUCKY:**
- Inicia sesión con el nombre `LUCKY`
- Se activan 3 turnos con probabilidades dobles automáticamente

**Forma 2 — Apuesta 777:**
- Apuesta exactamente `777`
- Se activa un **minijuego de dados** con premio en efectivo
- Se activan 3 turnos con probabilidades dobles

---

## 👥 Distribución de Roles (Sugerida para el equipo)

| Integrante | Clases Principales |
|------------|-------------------|
| Persona 1  | `Main.java`, `Jugador.java`, `GestorCSV.java` |
| Persona 2  | `Rodillo.java`, `ResultadoJuego.java` |
| Persona 3  | `SlotMachine.java`, `Interfaz.java`, `Colores.java` |

---

## 📊 Criterios cubiertos

- ✅ **Persistencia CSV** — carga y guarda sin perder información
- ✅ **Lógica de Matrices** — filas, columnas y diagonales con multiplicadores
- ✅ **Modularidad** — 8 clases bien definidas con responsabilidades separadas
- ✅ **Interfaz Visual** — ASCII art, colores ANSI, menús formateados
- ✅ **Easter Egg** — nombre LUCKY + apuesta 777 con minijuego de dados
