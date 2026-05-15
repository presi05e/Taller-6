# 🎰 The Lucky Arcade

<p align="center">
  <b>Simulador de máquina tragamonedas en consola desarrollado en Java</b><br>
  <i>Persistencia de datos · Lógica de juego · Experiencia interactiva</i>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/Estado-En%20desarrollo-yellow?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Proyecto-Académico-blue?style=for-the-badge"/>
</p>

---

## 🎮 Descripción del Proyecto

**The Lucky Arcade** es un simulador de casino en consola que recrea el funcionamiento de una máquina tragamonedas (Slot Machine).

El sistema permite a los jugadores:

* Apostar 💰
* Girar los rodillos 🎰
* Ganar premios 🏆
* Mantener su saldo guardado 📊

Todo esto con una experiencia interactiva dentro de la terminal.

---

## 🧠 Conceptos Aplicados

Este proyecto integra múltiples fundamentos clave de programación:

✨ Lectura y escritura de archivos (CSV)
✨ Manejo de matrices (arreglos 2D)
✨ Programación modular (funciones y clases)
✨ Lógica de control y condiciones
✨ Simulación de sistemas interactivos

---

## 💾 Persistencia de Jugadores

El sistema recuerda a cada usuario:

* Se solicita el nombre al iniciar
* Se busca en `jugadores.csv`
* Si existe → se carga su saldo
* Si no existe → se crea con saldo inicial

🔄 El saldo se actualiza automáticamente durante el juego y al salir.

---

## 🔳 Sistema de Tragamonedas

La máquina está representada por una matriz **3x3**:

```java
String[][] rodillos = new String[3][3];
```

🎲 Símbolos disponibles:

```java
{"7", "X", "$", "*", "@", "#"}
```

Cada giro llena la matriz con valores aleatorios usando `Math.random()`.

---

## 🏆 Sistema de Premios

### 🔹 Líneas Horizontales

Ganas si una fila tiene 3 símbolos iguales.

### 🔹 Diagonales

Se evalúan ambas diagonales:

* Principal
* Secundaria

### 🔹 Multiplicadores

Si ganas en múltiples líneas:
➡️ El premio aumenta

### 🔹 Rareza de símbolos

Algunos símbolos valen más que otros
💎 Ejemplo: `"7"` tiene mayor recompensa

---

## 🎨 Experiencia de Usuario

### 🕹️ Menú Interactivo

```
1. Apostar
2. Ver saldo
3. Ranking
4. Salir
```

### 🎬 Animación de Giro

* Simulación visual del movimiento
* Uso de bucles + refresco de pantalla

### 🧾 Interfaz ASCII

* Diseño visual en consola
* Decoración del juego con texto

---

## ⚙️ Estructura del Código

El proyecto está organizado de forma modular:

| Método              | Función                        |
| ------------------- | ------------------------------ |
| `cargarSaldo()`     | Lee datos desde CSV            |
| `guardarSaldo()`    | Guarda información actualizada |
| `dibujarPantalla()` | Muestra la matriz              |
| `animarGiro()`      | Genera el efecto visual        |
| `calcularPremio()`  | Determina ganancias            |

---

## 🥚 Easter Egg — El Amuleto de la Suerte

Un secreto oculto dentro del juego:

### 🎯 Cómo activarlo

* Apostar **777**
  **o**
* Nombre del jugador: **LUCKY**

### ✨ Efectos

* +10% de bonus
* Mayor probabilidad de ganar
* Evento especial (minijuego o ventaja temporal)

---

## 🛠️ Tecnologías Utilizadas

* ☕ **Java**
* 📂 Manejo de archivos (BufferedReader / FileWriter)
* 🧮 Estructuras de datos (arrays y matrices)
* 🧱 Programación orientada a objetos (POO)

---

## 📂 Estructura del Proyecto

```
proyecto_final_arcade/
│
├── src/
│   ├── Main.java
│   ├── Juego.java
│   ├── Jugador.java
│   └── Utilidades.java
│
├── jugadores.csv
└── README.md
```

---

## 🚀 Cómo Ejecutar

```bash
git clone https://github.com/tu-usuario/proyecto_final_arcade.git
```

1. Abrir en tu IDE (IntelliJ, Eclipse o VS Code)
2. Ejecutar la clase `Main`

---

## 👨‍💻 Autores

* Esteban Présiga Posada 
* Luis Leonardo Mosquera
* Jeronimo

---

## 🌟 Conclusión Y Diapositvas 

## Diapositivas
>A continuación se encontraran las Diapositivas que contiene la exposición y la en esta la explicación oral a detalle del proyecto: 
>[Diapositivas](https://canva.link/2jufs9rh99gq34m)

Este proyecto representa la integración de múltiples conceptos fundamentales en un sistema completo, funcional e interactivo.

No solo demuestra habilidades técnicas, sino también la capacidad de diseñar una experiencia de usuario dentro de un entorno de consola.

---

<p align="center">
  🎰 <b>¡Bienvenido a The Lucky Arcade!</b> 🎰
</p>



