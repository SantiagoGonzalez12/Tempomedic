# Registro de Cambios en el Diseño de Interfaces (UI/UX)

## Versión 2.0 - Adaptación y Rediseño a Versión de Escritorio

**Fecha:** 28/10/2026  
**Módulo:** DII (Desarrollo de Interfaces) - Sprint 2  
**Issue:** [3.1. Actualizar wireframes y mockups](https://github.com/users/SantiagoGonzalez12/projects/6/views/19?pane=issue&itemId=275491946&issue=SantiagoGonzalez12%7CTempomedic%7C60)

### Resumen de Modificaciones Introducidas

1. **Resolución y Relación de Aspecto:**
   - Rediseño completo del lienzo pasando de formato vertical móvil a una resolución HD fija de **1280x720 (16:9)**, adaptada para ventanas de escritorio de Java Swing.

2. **Estructura de Navegación Principal:**
   - Reemplazo de la barra de navegación inferior (*Bottom Navigation*) por un **menú lateral izquierdo (*Sidebar*)**.
   - Mantenimiento de la navegación accesible mediante **icono + texto** (*Hoy*, *Medicamentos*, *Citas*, *Ajustes*) en disposición horizontal dentro del menú lateral, cumpliendo con los estándares WCAG 2.2 AA.

3. **Autenticación y Seguridad:**
   - **Eliminación del desbloqueo por Biometría** en las pantallas de *Iniciar Sesión* y *Bloqueo por PIN*, al no ser un mecanismo nativo estándar ni viable de simular en aplicaciones de escritorio Swing.
   - Centrado simétrico del logotipo corporativo (cruz con píldora y reloj) y del texto *Tempomedic* en las cabeceras de todas las vistas de acceso y paneles.

4. **Redistribución y Compactación de Formularios:**
   - **Añadir Medicamento y Pedir Cita:** Reorganización de los campos en disposición horizontal y columnas compactas para aprovechar el ancho de 1280 px y evitar espacios vacíos o scroll innecesario.
   - Estandarización de botones de acción principales ("Añadir medicamento", "Pedir cita", "Guardar", "Cancelar") con etiquetas claras y contraste adecuado.

5. **Paneles Principales y Tarjetas de Contenido:**
   - **Pantalla "Hoy":** Rediseño del contenedor principal y de la `TarjetaToma` aprovechando el espacio horizontal para presentar la información del tratamiento y la cita junto a los botones de acción directa (*Tomada*, *Posponer*, *Omitida*) sin saturación visual.
   - **Medicamentos y Citas:** Adaptación de los listados a tablas/tarjetas de escritorio más holgadas para mejorar la legibilidad en pantallas grandes.

6. **Pantalla de Ajustes:**
   - Reestructuración de las opciones de personalización (Selector de tamaño de texto: *Normal*, *Grande*, *Muy grande*; tema *Claro* / *Oscuro*; activación de PIN y botones de cierre/eliminación de cuenta) en bloques alineados y legibles.

7. **Aspecto**

#### Paleta de Colores y Contrastes
Se ha definido una paleta basada en tonos azules y verdes que transmiten confianza y calma, adecuada para el sector salud. Todos los pares texto/fondo han sido comprobados siguiendo las pautas WCAG 2.1 (Nivel AA) para garantizar un ratio mínimo de contraste de 4.5:1 en texto normal y 3:1 en texto grande.

* **Azul oscuro:** `#3B6A76` (Fondos de botones principales, títulos, barra lateral).
* **Azul claro:** `#BAD1D9` (Fondos de tarjetas, campos de texto, bordes).
* **Blanco:** `#FFFFFF` (Fondo general de la aplicación).
* **Negro:** `#000000` (Texto principal).
* **Azul:** `#0075DA` (Texto con enlace u opcionalidad a otro medio)
* **Verde:** `#25853D` (Indicador de estado y confirmaciones).
* **Naranja:** `#BC5800` (Indicador de estado).
* **Rojo:** `#EA0004` (Indicador de accion importante sin retorno).

#### Tabla de Contrastes Comprobados (Texto/Fondo)

| Combinación (Texto/Fondo) | Ratio | ¿Cumple 4.5:1? (Texto Normal) | ¿Cumple 3:1? (Texto Grande / UI) | Uso recomendado |
| :--- | :---: | :---: | :---: | :--- |
| **Azul oscuro** (`#3B6A76`) sobre **Blanco** (`#FFFFFF`) | **5.84 : 1** | 🟩 | 🟩 | Texto principal, títulos, botones. |
| **Blanco** (`#FFFFFF`) sobre **Azul oscuro** (`#3B6A76`) | **5.84 : 1** | 🟩 | 🟩 | Botones primarios (texto blanco). |
| **Azul claro** (`#BAD1D9`) sobre **Blanco** (`#FFFFFF`) | **1.62 : 1** | 🟥 | 🟥 | **Solo** como fondo o borde (nunca como texto). |
| **Negro** (`#000000`) sobre **Blanco** (`#FFFFFF`) | **21.00 : 1** | 🟩 | 🟩 | Texto principal, máxima legibilidad. |
| **Negro** (`#000000`) sobre **Azul claro** (`#BAD1D9`) | **12.94 : 1** | 🟩 | 🟩 | Texto sobre campos de texto y tarjetas. |
| **Verde** (`#25853D`) sobre **Blanco** (`#FFFFFF`) | **4.69 : 1** | 🟩 | 🟩 | Texto de estado "Tomada" o confirmaciones. |
| **Rojo** (`#EA0004`) sobre **Blanco** (`#FFFFFF`) | **4.53 : 1** | 🟩 | 🟩 | Texto de error o botón "Eliminar" (sin fondo). |
| **Azul oscuro** (`#3B6A76`) sobre **Azul claro** (`#BAD1D9`) | **3.59 : 1** | 🟥 | 🟩 | Iconos, bordes o textos grandes (18pt+). |
| **Naranja** (`#BC5800`) sobre **Azul claro** (`#BAD1D9`) | **3.15 : 1** | 🟥 | 🟩 | Iconos o textos grandes en tarjetas. |
| **Verde** (`#25853D`) sobre **Azul claro** (`#BAD1D9`) | **2.89 : 1** | 🟥 | 🟥 | **Evitar**. Usar verde sobre blanco o negro. |
| **Azul** (`#0075DA`) sobre **Blanco** (`#FFFFFF`) | **4.52 : 1** | 🟩 | 🟩 | Enlaces y textos opcionales. |

Leyenda: 🟩Sí 🟥No

Nota técnica: 
* El **Negro sobre Blanco** y **Negro sobre Azul claro** son las combinaciones más seguras y se usarán para todo el texto de lectura principal (párrafos, datos de medicamentos).
* El **Azul oscuro** es el color de marca por excelencia. Funciona perfectamente sobre blanco (5.8:1) y sobre azul claro si se usa en tamaños grandes o para iconos (3.5:1).
* **Colores de estado (Verde y Rojo):** Ambos han sido ajustados y **ahora cumplen perfectamente el nivel AA sobre fondo blanco** (4.69:1 y 4.53:1 respectivamente). ¡Buen trabajo con la elección de estos tonos!
* **El caso del Azul Claro (`#BAD1D9`):** Este color tiene una luminosidad muy alta. **Nunca se debe usar como color de texto sobre blanco** (falla con 1.6:1). Se usará exclusivamente como fondo de tarjetas o campos de texto. 
* **El caso del Verde sobre Azul Claro:** Si queréis poner una etiqueta verde de "Tomada" dentro de una tarjeta (que es azul claro), el verde falla el contraste (2.89:1). **Solución:** En las tarjetas, el estado "Tomada" debe ir con texto **Negro** o con una etiqueta que tenga fondo verde y texto blanco.
* **Enlaces (`#0075DA`):** El azul de los enlaces cumple justo el mínimo (4.52:1). Es correcto, pero si queréis más seguridad, se puede oscurecer un poco más

Se puede calcular las pautas WCAG 2.1 (Nivel AA) en (https://coddy.tech/tools/es/contrast-checker).

#### Tipografía y Tamaños (Escalado)
Se utiliza una tipografía **Sans-Serif** (como Arial, Helvetica o Segoe UI) por su alta legibilidad en pantalla. Se han definido tres escalas de tamaño para adaptarse a las necesidades visuales de los usuarios (especialmente edad avanzada):

| Escala | Botones | Texto General | Encabezados / Títulos |
| :--- | :---: | :---: | :---: |
| **Normal** | 14 pt | 18 pt | 24 pt |
| **Grande** | 18 pt | 22 pt | 30 pt |
| **Muy grande** | 22 pt | 26 pt | 36 pt |

#### Rejilla, Márgenes y Tamaño de Componentes
* **Resolución objetivo:** 1920 x 1080 px (mínimo soportado: 1280 x 720 px).
* **Rejilla base:** sistema de 12 columnas con un margen exterior de 24 px y un *gutter* (espacio entre columnas) de 16 px.
* **Área táctil mínima (Target Size):** todos los botones e iconos interactivos tienen un tamaño mínimo de **48x48 px** (o dp), cumpliendo con las recomendaciones para personas con movilidad reducida o temblores.
* **Iconos:** siempre acompañados de texto para evitar ambigüedades, cumpliendo con el criterio de "Comprensible" de WCAG.
