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
