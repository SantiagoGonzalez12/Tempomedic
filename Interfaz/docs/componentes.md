# Componentes utilizados

## TarjetaToma (pnlTarjetaToma)

- Qué es: panel reutilizable que muestra una toma de medicación con su estado y sus acciones.
- Características: JPanel con GridBagLayout, fondo `#BAD1D9`, Empty Border (10,12,10,12). Contiene `lblTitulo` (medicamento, dosis y hora), `lblEstado` (símbolo y texto) y los botones `btnTomada`, `btnPosponer` y `btnOmitida`. El estado se indica con texto y símbolo, no solo con color: Pendiente (círculo naranja), Tomada (tick verde) y Omitida (cruz roja). Solo la tarjeta Pendiente muestra los botones.
- Dónde se usa: `pnlHoy` (VentanaHoy), una tarjeta por toma del día.
- Por qué: las tomas comparten estructura, y un panel clonado evita repetir la configuración y mantiene el aspecto uniforme.
- Limitación: sin código el estado se fija al diseñar, y se cambiará al programar la lógica.

## Parte 1: Contenedores

- Fichas añadidas: JFrame, JPanel, JScrollPane

### JFrame (nativo)

- Qué es: ventana de nivel superior de Swing.
- Características: `defaultCloseOperation` = EXIT, centrado con `Generate Center`, *Form Size Policy* en Generate Pack. No se fija su tamaño (incluye la barra de título): se da `preferredSize` a los paneles para obtener 960x540 de contenido. Layout según la ventana: GridBagLayout en las que tienen sidebar (Hoy, Medicamentos, Citas, Ajustes) y BorderLayout en las demás. `resizable` activado: el contenido se adapta al maximizar.
- Dónde se usa: las 10 ventanas (VentanaHoy, VentanaMedicamentos, VentanaNuevoMedicamento, VentanaCitas, VentanaPedirCita, VentanaAjustes, VentanaCrearCuenta, VentanaInicioSesion, VentanaBloqueoPIN, VentanaRecuperarContrasena).
- Por qué: es la ventana principal estándar de Swing. Alternativa descartada: JDialog, porque cada pantalla es una vista completa.

### JPanel (nativo)

- Qué es: contenedor genérico para agrupar componentes y asignarles un layout propio.
- Características: `background` por propiedad (`#3B6A76`, `#BAD1D9`, blanco), `border` y `preferredSize`/`minimumSize`/`maximumSize`/`alignmentX` para controlar cómo se estira. `pnlSidebar` tiene ancho fijo de 120 px (`weightx` 0 en el JFrame); `pnlContenido` absorbe el resto.
- Dónde se usa: `pnlSidebar`, `pnlContenido`, `pnlEncabezado`, `pnlTitulo`, `pnlFormulario` (NuevoMedicamento, PedirCita, CrearCuenta e InicioSesion), `pnlAviso`, `pnlAcciones`, `pnlTarjeta`, `pnlTarjetaCita`, `pnlListaMedicamentos`, `pnlListaCitas`, `pnlAjustes`, `pnlAvisoDefecto`, `pnlTamano`, `pnlTema`, `pnlCuenta`, `pnlHoy`, `pnlTarjetaToma1`, `pnlTarjetaToma2`, `pnlTarjetaCita1`, `pnlTarjetaCita2` (Hoy), `pnlPIN`, `pnlCasillasPIN` (BloqueoPIN), `pnlRecuperar` (RecuperarContrasena).
- Por qué: permite anidar un layout distinto en cada zona (BorderLayout general, GridBag en formularios y tarjetas, Grid en filas de botones, Flow en las casillas del PIN).

### JScrollPane (nativo)

- Qué es: contenedor que añade barras de desplazamiento a su contenido.
- Características: `border` None, `horizontalScrollBarPolicy` = NEVER, viewport con fondo propio.
- Dónde se usa: `sclpnlListaMedicamentos`, `sclpnlListaCitas` (lista de tarjetas), `sclSugerencias` (lista de centros) y `sclHoy` (contenido de VentanaHoy).
- Por qué: el número de tarjetas es variable. Con scroll vertical la lista crece sin romper la ventana. En Hoy se usa además porque la pantalla va justa en 540 px y no cabrá con los modos de texto Grande y Muy grande.

## Parte 2: Texto y acciones

- Fichas añadidas: JLabel, JButton

### JLabel (nativo)

- Qué es: componente de texto o imagen no editable.
- Características: fuente SansSerif (Bold/Plain, 14 a 30 pt), colores `#3B6A76` / negro, `icon` para el logo y los estados, `horizontalAlignment`. Los enlaces ("Inicia sesión", "¿Olvidaste el PIN?", "Volver a iniciar sesión", "¿Olvidaste tu contraseña?", "Crear cuenta") son JLabel con `cursor` HAND_CURSOR y color azul. Los estados usan color propio (Pendiente naranja, Tomada verde) con icono PNG y `iconTextGap`. `lblConfirmacion` lleva borde compuesto verde.
- Dónde se usa: `logo` y `txtTempomedic` en todas las ventanas, títulos de pantalla, etiquetas de formulario (Nombre, Dosis, Fecha, Correo, Contraseña...), `lblDescripcion` (CrearCuenta, InicioSesion, BloqueoPIN, RecuperarContrasena), textos de las tarjetas (`lblNombre`, `lblPauta`, `lblProximaToma`, `lblEspecialidad`, `lblFechaHora`, `lblHospital`, `lblTomaTitulo1/2`, `lblEstado1/2`, `lblCitaTitulo1/2`, `lblCitaHospital1/2`), secciones de Ajustes, `lblNotaEliminar`, `lblFecha`, `lblIniciaSesion`, `lblDatosSalud`, `lblOlvidoPIN`, `lblConfirmacion`, `lblVolverInicioSesion`, `lblOlvidaContrasena`, `lblCrearCuenta`.
- Por qué: es el componente indicado para texto de solo lectura y permite mezclar texto e icono. Los enlaces se hicieron con JLabel y no con JButton porque no son acciones con aspecto de botón.

### JButton (nativo)

- Qué es: botón de acción de un solo clic.
- Características:
  - Sidebar: `icon` + `text`, `verticalTextPosition` BOTTOM, `horizontalTextPosition` CENTER, tamaño [104, 84], `margin` [2,2,2,2], `focusPainted` y `borderPainted` desactivados. El botón de la pantalla actual lleva `contentAreaFilled` y `opaque` activados, fondo `#BAD1D9`, texto e icono negros. Los otros, transparentes con texto e icono blancos.
  - Botones primarios (Añadir medicamento, Guardar, Cancelar, Confirmar, Pedir cita, Crear cuenta, Iniciar sesión, Desbloquear, Enviar instrucciones): fondo `#3B6A76`, texto blanco, Bold 14.
  - Botones secundarios (Editar, Eliminar, Cancelar cita, Cerrar sesión): fondo `#BAD1D9` con borde negro. Tomada, Posponer y Omitida: fondo `#BAD1D9`, texto y borde `#3B6A76`. Eliminar cuenta: fondo blanco y borde rojo.
- Dónde se usa: todas las ventanas.
- Por qué: todas las acciones son un clic puntual. En el sidebar se eligió `JButton` y no `JToggleButton` porque cada botón abre una ventana distinta; la pantalla actual se marca con fondo, texto e icono distintos en cada ventana.
- Limitación: Swing no rellena esquinas redondeadas sin código, así que los fondos son rectangulares.

## Parte 3: Entrada de datos

- Fichas añadidas: JTextField, JPasswordField, JComboBox, JList

### JTextField (nativo)

- Qué es: campo de texto de una línea.
- Características: fondo `#BAD1D9`, SansSerif Plain 18, `preferredSize` [343, 41] ([563, 41] en las ventanas de acceso), `columns` 0 (si no, limita el ancho), borde compuesto (Line + Empty (0,12,0,12) para el margen interior). Borde negro en la mayoría y `#3B6A76` en Crear cuenta.
- Dónde se usa: `txtNombre`, `txtDosis`, `txtPrimeraToma` (NuevoMedicamento); `txtCentro`, `txtFecha`, `txtHora` (PedirCita); `txtCorreo` (CrearCuenta, InicioSesion y RecuperarContrasena).
- Por qué: son datos cortos. Fecha y hora son `JTextField` porque no se admite código para estilizar un selector. Alternativa descartada: `JSpinner` con modelo de fecha, más difícil de dar estilo.

### JPasswordField (nativo)

- Qué es: campo de texto que oculta lo escrito con un carácter (`echoChar` • (`\u2022`)).
- Características: mismo estilo que `JTextField`. En los campos del PIN: tamaño fijo [72, 80] (`preferredSize`, `minimumSize` y `maximumSize`), `columns` 0, `horizontalAlignment` CENTER, SansSerif Bold 24, `opaque` activado, borde Line negro de 2 px y `margin` 0.
- Dónde se usa: `pwdContrasena`, `pwdRepetirContrasena` (CrearCuenta); `pwdContrasena` (InicioSesion); `pwdPin1` a `pwdPin4` (BloqueoPIN).
- Por qué: contraseñas y PIN no deben verse al escribirlos. Se usan cuatro campos para el PIN porque cada dígito va en su casilla, como en el diseño.

### JComboBox (nativo)

- Qué es: lista desplegable de opciones excluyentes.
- Características: propiedad `model` con los elementos (Cada X horas / Diaria / Días concretos; Cardiología / Traumatología...), mismo estilo que los campos de texto.
- Dónde se usa: `cmbFrecuencia` (NuevoMedicamento), `cmbEspecialidad` (PedirCita).
- Por qué: la lista de valores es cerrada y ocupa una sola línea.
- Limitación: la flecha queda a la derecha y no junto al texto como en Figma.

### JList (nativo)

- Qué es: lista de elementos visible, con selección.
- Características: dentro de un `JScrollPane`, `model` con 3 centros, `selectionMode` SINGLE, mismo fondo y fuente que los campos.
- Dónde se usa: `lstSugerencias` (PedirCita).
- Por qué: las sugerencias deben verse todas a la vez bajo el campo. Con un `JComboBox` habría que desplegarlas.

## Parte 4: Selección

- Fichas añadidas: JRadioButton, ButtonGroup, JCheckBox

### JRadioButton (nativo)

- Qué es: opción seleccionable dentro de un grupo de opciones excluyentes.
- Características: `horizontalAlignment` CENTER, `opaque` activado, `focusPainted` desactivado. Seleccionado: fondo `#3B6A76`, texto blanco. No seleccionado: fondo `#BAD1D9`, texto negro. Borde Line negro (grosor 3 al seleccionar y 1 al no seleccionar en Ajustes). `icon` (círculo vacío) y `selectedIcon` (círculo relleno) en PNG de 16x16.
- Dónde se usa: Aviso (NuevoMedicamento), Aviso por defecto, Tamaño de texto y Tema (Ajustes).
- Por qué: las opciones se excluyen entre sí.
- Limitación: el color y el borde solo cambian al seleccionar cuando se programe la lógica. Por ahora están fijados como en Figma. El círculo sí cambia solo, gracias a `selectedIcon`.

### ButtonGroup (nativo)

- Qué es: objeto no visual que garantiza que solo un botón del grupo esté seleccionado.
- Características: se asigna desde la propiedad `buttonGroup` de cada radio. Un grupo por bloque: `grpAviso`, `grpTamano`, `grpTema`. Con un solo grupo se anularían entre bloques.
- Dónde se usa: NuevoMedicamento y Ajustes.
- Por qué: es el mecanismo estándar de Swing para la exclusión mutua.

### JCheckBox (nativo)

- Qué es: casilla de activación independiente (sí/no).
- Características: `selected` activado, SansSerif Plain 18, fondo blanco, `focusPainted` desactivado, `icon` y `selectedIcon` en PNG de 20x20 para la casilla oscura de Figma.
- Dónde se usa: `chkPin`, "Pedir PIN al abrir la aplicación" (Ajustes).
- Por qué: es una opción que se activa o no, sin relación con otras.

## Parte 5: Espaciado

- Fichas añadidas: Box.Filler (Glue y Rigid Area)

### Box.Filler: Glue (nativo)

- Qué es: relleno invisible que absorbe el espacio sobrante.
- Características: se arrastra desde la paleta (Swing Fillers -> Glue). En el sidebar va en vertical, arriba, entre botones y abajo. En los paneles centrados (`pnlPIN`, `pnlRecuperar`, `pnlFormulario` de InicioSesion) y en `pnlHoy` va al final, con `weighty` 1, para empujar el contenido y que no se centre mal al maximizar.
- Dónde se usa: `pnlSidebar` de Hoy, Medicamentos, Citas y Ajustes; `pnlHoy`, `pnlPIN`, `pnlRecuperar`, `pnlFormulario` (InicioSesion, `filler1`).
- Por qué: reparte los 4 botones por toda la altura aunque se maximice la ventana, sin fijar posiciones.

### Box.Filler: Rigid Area (nativo)

- Qué es: espacio invisible de tamaño fijo.
- Características: 0x12 px entre tarjetas.
- Dónde se usa: `pnlListaMedicamentos` y `pnlListaCitas`.
- Por qué: separa las tarjetas con una distancia constante. Alternativa descartada: insets en cada tarjeta, porque BoxLayout no los aplica. En Hoy sí se usan insets, porque `pnlHoy` es GridBagLayout.

## Parte 6: Layouts

- Fichas añadidas: BorderLayout, BoxLayout, GridBagLayout, GridLayout, FlowLayout

| Layout | Dónde se usa | Por qué se eligió |
| --- | --- | --- |
| `BorderLayout` | `JFrame` de las ventanas sin sidebar, `pnlContenido` (encabezado NORTH, centro, acciones SOUTH; solo CENTER en InicioSesion), `pnlAcciones` de Medicamentos y Citas | Estructura general de la pantalla. El centro absorbe el espacio al redimensionar. |
| `BoxLayout` | `pnlSidebar` (eje Y), `pnlListaMedicamentos` y `pnlListaCitas` (eje Y) | Apila elementos en una columna y respeta `maximumSize` y `alignmentX`. |
| `GridBagLayout` | `JFrame` de las ventanas con sidebar (sidebar `weightx` 0, contenido `weightx` 1), `pnlEncabezado`, `pnlTarjeta`, `pnlTarjetaCita`, `pnlFormulario` (incluido InicioSesion), `pnlAjustes`, `pnlHoy`, tarjetas de Hoy, `pnlPIN`, `pnlRecuperar` | Permite celdas de varias columnas, reparto con `weightx`, anclajes e insets. Es el que más se parece a Figma. Hay que poner `ipadx`/`ipady` a 0 y `columns` a 0 en los campos, porque si no desajustan los tamaños. |
| `GridLayout` | `pnlAviso`, `pnlAvisoDefecto`, `pnlTamano`, `pnlTema`, `pnlCuenta`, `pnlAcciones` (NuevoMedicamento y PedirCita) | Reparte botones en columnas de igual ancho, con `hgap` entre ellos. |
| `FlowLayout` | `pnlTitulo` (flecha + título), `pnlCasillasPIN` (4 casillas con `hgap` 14) | Coloca elementos en línea respetando su tamaño. Las casillas se metieron en su propio panel porque, dentro del GridBag, el enlace ancho las separaba. |

## Parte 7: Bordes

- Fichas añadidas: EmptyBorder, LineBorder, CompoundBorder

### EmptyBorder (nativo)

- Qué es: borde invisible que añade márgenes interiores.
- Dónde se usa: márgenes de `pnlListaMedicamentos` (0,18,0,18), `pnlTarjeta` (12,12,12,12), `pnlFormulario` (0,123,0,123), `pnlAcciones` y `pnlAjustes`, `pnlHoy`, tarjetas de Hoy (10,12,10,12) y paneles centrados de acceso (`pnlPIN`, `pnlRecuperar`, `pnlFormulario` de CrearCuenta e InicioSesion).
- Por qué: da el espaciado de Figma sin tocar los layouts.

### LineBorder (nativo)

- Qué es: borde de línea de color y grosor configurables, con opción *Rounded Corners*.
- Dónde se usa: Editar, Eliminar, Cancelar cita, Cerrar sesión, Eliminar cuenta (borde rojo), radios y campos de texto, Tomada/Posponer/Omitida (`#3B6A76`), casillas del PIN (negro) y mensaje de confirmación (verde).
- Limitación: con grosor 2 el redondeo apenas se nota y no redondea el relleno, solo el contorno.

### CompoundBorder (nativo)

- Qué es: combinación de un borde exterior y uno interior.
- Dónde se usa: `JTextField`, `JPasswordField` y `JComboBox` (Line 2 px + Empty (0,12,0,12)), y `lblConfirmacion` (Line verde + Empty (0,14,0,14)).
- Por qué: con solo LineBorder el texto queda pegado al borde.
