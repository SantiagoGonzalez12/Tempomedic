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
* **Verde:** `#39C85D` (Indicador de estado y confirmaciones).
* **Naranja:** `#FF8D28` (Indicador de estado).
* **Rojo:** `#FF3D40` (Indicador de accion importante sin retorno).

#### Tabla de Contrastes Comprobados (Texto/Fondo)

| Par de Colores | Uso | Ratio de Contraste | Cumple 4.5:1 (Normal) | Cumple 3:1 (Grande) |
| :--- | :--- | :---: | :---: | :---: |
| **`#3B6A76`** (Azul oscuro) sobre **`#FFFFFF`** (Blanco) | Texto principal, títulos, texto de botones en barra lateral | **5.8 : 1** | 🟩 | 🟩 |
| **`#FFFFFF`** (Blanco) sobre **`#3B6A76`** (Azul oscuro) | Texto en botones primarios (ej. "Iniciar sesión") | **5.8 : 1** | 🟩 | 🟩 |
| **`#000000`** (Negro) sobre **`#FFFFFF`** (Blanco) | Texto general en el fondo de la app | **21.0 : 1** | 🟩 | 🟩 |
| **`#000000`** (Negro) sobre **`#BAD1D9`** (Azul claro) | Texto en campos de texto, tarjetas o tablas | **13.2 : 1** | 🟩 | 🟩 |
| **`#3B6A76`** (Azul oscuro) sobre **`#BAD1D9`** (Azul claro) | Iconos o textos secundarios en las tarjetas | **4.8 : 1** | 🟩 | 🟩 |
| **`#000000`** (Negro) sobre **`#39C85D`** (Verde) | Texto del estado "Tomada" o confirmación (fondo verde) | **7.4 : 1** | 🟩 | 🟩 |
| **`#39C85D`** (Verde) sobre **`#FFFFFF`** (Blanco) | Texto o icono verde sobre fondo blanco | **2.2 : 1** | 🟥 | 🟥 |
| **`#000000`** (Negro) sobre **`#FF8D28`** (Naranja) | Texto del estado "Pendiente" o "Posponer" (fondo naranja) | **8.8 : 1** | 🟩 | 🟩 |
| **`#FF8D28`** (Naranja) sobre **`#FFFFFF`** (Blanco) | Texto o icono naranja sobre fondo blanco | **1.9 : 1** | 🟥 | 🟥 |
| **`#FFFFFF`** (Blanco) sobre **`#FF3D40`** (Rojo) | Texto en botón de acción destructiva (fondo rojo) | **3.7 : 1** | 🟥 (Falla para texto normal) | 🟩 (Válido solo si es texto grande o negrita de 14pt+) |
| **`#FF3D40`** (Rojo) sobre **`#FFFFFF`** (Blanco) | Texto de error o botón "Eliminar cuenta" sin fondo | **3.7 : 1** | 🟥 | 🟩 |

Leyenda: 🟩Sí 🟥No

Nota técnica: 
* El **Verde (`#39C85D`)** y el **Naranja (`#FF8D28`)** no deben usarse como color de texto sobre fondos blancos o azules claros, ya que no superan el ratio de 4.5:1. Para los estados de "Tomada" o "Pendiente", se usarán otro método todavía no acordado.
* El **Rojo (`#FF3D40`)** sobre fondo blanco (ratio 3.7:1) no cumple el mínimo de 4.5:1 para texto normal. Por lo tanto, si se usa para el botón "Eliminar cuenta", el texto deberá ser de **tamaño grande (18pt+) o ir en negrita (14pt+)** para cumplir la excepción de la norma (que exige 3:1). Como alternativa más segura, se puede usar el rojo como **color de fondo del botón con texto blanco en negrita**.

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
