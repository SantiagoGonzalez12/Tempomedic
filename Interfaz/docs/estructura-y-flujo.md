# Pautas de diseño estructural: menús, ventanas, diálogos y atajos

Para garantizar una experiencia de usuario consistente, predecible y accesible (cumpliendo con los principios heurísticos de Nielsen [1] y las pautas WCAG [2]), se han definido las siguientes reglas estructurales:

## Documentar pautas estructurales: menús, ventanas, diálogos y atajos

**Distribución de acciones y jerarquía de ventanas**
*   **Navegación principal (Sidebar):** se ha optado por una barra de navegación lateral fija en la zona izquierda. En lugar de menús desplegables clásicos, esta barra muestra siempre las 4 áreas principales (*Hoy, Medicamentos, Citas, Ajustes*), cumpliendo con el principio de **visibilidad** y **reconocer antes que recordar** [1]. 
*   **Ventanas principales:** cada una de las 4 secciones se carga en el área de contenido principal, manteniendo la barra lateral y la cabecera siempre visibles para no perder el contexto.
*   **Ventanas de flujo:** para acciones como *Añadir Medicamento* o *Pedir Cita*, se utilizan ventanas que sustituyen temporalmente el contenido principal, pero mantienen una "flecha de volver" (<) en la esquina superior izquierda y botones de "Cancelar" para ofrecer **control y libertad al usuario** pudiendo abortar la acción en cualquier momento [1].
*   **Cuadros de diálogo:** las acciones críticas o destructivas, como confirmar la eliminación de una cuenta o registrar una toma como "Omitida", se resolverán mediante diálogos modales. Estos bloquean el resto de la interfaz para obligar al usuario a prestar atención y **prevenir errores** [1].

**Comportamiento de teclas en los diálogos y fujos**
Para asegurar la accesibilidad y agilizar el uso, especialmente para usuarios expertos o con dificultades motoras, se estandariza el comportamiento del teclado [2]:
*   **Tecla Enter:** ejecutará siempre la acción principal o por defecto de la ventana (*Iniciar sesión*, *Guardar*, *Confirmar*, *Desbloquear*).
*   **Tecla Esc (Escape):** actuará como el botón "Cancelar" o "Volver", cerrando el diálogo o formulario(fujo) actual sin guardar cambios y devolviendo al usuario a la pantalla anterior.

## Navegación, atajos y orden de tabulación

**Navegación y orden de tabulación**
*   **Foco visible:** todos los componentes interactivos mostrarán un indicador visual claro (borde o cambio de color) cuando están seleccionados mediante el teclado o ratón, garantizando que el usuario sepa en todo momento dónde se encuentra [2].
*   **Orden lógico (tabulación):** el foco del teclado (al pulsar la tecla `Tab`, `↹` o `⇥`) seguirá el orden visual natural de lectura: de arriba hacia abajo y de izquierda a derecha.

**Mnemónicos y aceleradores**
*   **Mnemónicos (Alt + Letra):** se han asociado letras subrayadas a los botones principales de la interfaz para facilitar su activación rápida (`Alt + G` para *Guardar*).
*   **Aceleradores (Ctrl + Letra):** para las acciones de uso más frecuente en el día a día, se han definido combinaciones de teclas rápidas que funcionan de forma global.

**Tabla de Atajos de Teclado**
A continuación se documentan los atajos implementados en el sistema:

| Atajo de Teclado | Acción que realiza | Contexto / Pantalla |
| :--- | :--- | :--- |
| `Ctrl + 1` | Ir a la sección "Hoy" | Global (Navegación) |
| `Ctrl + 2` | Ir a "Medicamentos" | Global (Navegación) |
| `Ctrl + 3` | Ir a "Citas" | Global (Navegación) |
| `Ctrl + 4` | Ir a "Ajustes" | Global (Navegación) |
| `Ctrl + N` | Abrir formulario de "Nuevo medicamento" | Vista Medicamentos |
| `Ctrl + P` | Abrir formulario de "Pedir cita" | Vista Citas |
| `Enter` | Confirmar acción principal (Guardar, Iniciar sesión) | Formularios y Diálogos |
| `Esc` | Cancelar / Cerrar ventana actual | Formularios y Diálogos |


## Mapa de navegación y flujo de control

![Diagrama de flujo de TempoMedic](<imagen/DF TempoMedic.png>)

## Referencias

[1] J. Nielsen, "10 Usability Heuristics for User Interface Design," Nielsen Norman Group, 1994. 28/10/2026. Disponible en: https://www.nngroup.com/articles/ten-usability-heuristics/

[2] W3C, "Web Content Accessibility Guidelines (WCAG) 2.1," W3C Recommendation, Jun. 2018. 28/10/2026. Disponible en: https://www.w3.org/TR/WCAG21/

[3] International Organization for Standardization, "Ergonomics of human-system interaction — Part 110: Interaction principles," ISO 9241-110:2020, 2020. 28/10/2026. https://standards.iteh.ai/catalog/standards/cen/7cfeb7e3-9a82-44af-871c-116631d1d051/en-iso-9241-110-2020?srsltid=AYCX9vKtdD5r3ffqdpOTbjhs6Ok49pDhoBx865ISll5Ncp0lw-5z90j3

