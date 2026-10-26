# Definir medidas y herramientas de auditoría

## 1. Selección y Justificación de Métricas

Para evaluar la usabilidad y accesibilidad de TempoMedic de forma cuantitativa y cualitativa, se han seleccionado 5 métricas clave adaptadas a nuestro público objetivo (especialmente adultos mayores y pacientes crónicos).

### 1.1. Ratio de Contraste de Color (Accesibilidad Visual)
Medición numérica de la diferencia de luminancia entre el texto/icono y su fondo. Es un requisito crítico de la norma WCAG 2.1 (Nivel AA). Muchos de nuestros usuarios son personas de edad avanzada con agudeza visual reducida. Garantizar un contraste mínimo evita la fatiga visual y los errores de lectura en el Dashboard o al revisar posologías.

### 1.2. Tiempo por Tarea 
Tiempo total (en segundos) que tarda el usuario desde que inicia una tarea hasta que la completa exitosamente. Permite evaluar la eficiencia de la interfaz y la fricción cognitiva. Un tiempo elevado al marcar una toma ("Tomada") o pedir una cita indica que la jerarquía visual o los botones no son intuitivos.

### 1.3. Tasa y Tipo de Errores
Número de acciones incorrectas, clics erróneos o confusiones cometidas por el usuario antes de completar una tarea. Nos ayuda a identificar puntos de confusión en los formularios, por ejemplo, al seleccionar la frecuencia de un medicamento, y evaluar la claridad de los textos e iconos.

### 1.4. Número de Clics 
Cantidad total de interacciones pulsar en la pantalla realizadas para completar un flujo. Evalúa la simplicidad y la navegación plana. Nuestro objetivo UI/UX es que las tareas cotidianas se realicen en el menor número de toques posible (idealmente 1 o 2 clics desde la barra de navegación inferior).

### 1.5. Satisfacción del Usuario 
Percepción subjetiva del usuario sobre la facilidad de uso, claridad y utilidad de la app (medida mediante escala System Usability Scale o valoración de 1 a 5). Mide la confianza y comodidad del usuario con la interfaz, aspecto crucial para la adherencia al tratamiento y la aceptación por parte de adultos mayores.

## 2. Herramientas de Evaluación

Para la auditoría y la recolección de datos se emplearán las siguientes herramientas:

1. **Comprobadores de Contraste:**
   * *WebAIM Contrast Checker* / *Stark plugin (Figma)*: Para verificar que los textos normales cumplen un contraste mínimo de 4.5:1 y los textos grandes/iconos un contraste de 3:1 (WCAG AA).
2. **Lista de Comprobación WCAG 2.1 (Nivel AA) & Principios Heurísticos de Nielsen:**
   * Utilizada en el Issue #41 para revisar contraste, tamaños de fuente/botones, navegabilidad, tabulación, atajos y coherencia textual.
3. **Guion de Pruebas con Usuarios:**
   * Estructura formal de prueba para dirigir las sesiones en vivo o con prototipo con usuarios objetivos (3 a 5 personas, idealmente ≥ 46 años).
4. **Plantilla de Registro de Problemas (Issue Log):**
   * Formato normalizado para categorizar y priorizar incidencias detectadas.

## 3. Guion de Prueba con Usuarios (Para Tarea 2.4)

### Perfil del Participante
* **Muestra:** 3 a 5 personas.
* **Criterio clave:** usuarios de 46 años o más o pacientes con tratamientos temporales/crónicos.

### Instrucciones para el Facilitador
1. Explicar brevemente el propósito de la prueba, se evalúa la aplicación, no al usuario.
2. Pedir al usuario que piense en voz alta mientras realiza las tareas.
3. Registrar tiempos, clics, errores y comentarios sin intervenir a menos que el usuario se bloquee por completo.

### Tareas a Evaluar

* **Tarea 1: añadir un medicamento**
  * *Ejamplo:* "Acabas de volver del médico y te ha recetado Ibuprofeno 600mg cada 8 horas durante 7 días. Registra este medicamento en la app para recibir alertas."
* **Tarea 2: marcar una toma diaria**
  * *Ejamplo:* "Es la hora de tu medicación de la tarde. Revisa la pantalla principal y marca la toma pendiente de Ibuprofeno como 'Tomada'."
* **Tarea 3: pedir / programar una cita médica**
  * *Ejemplo:* "Tienes una revisión con tu médico de cabecera el próximo martes a las 10:00 AM en el Centro de Salud. Añade esta cita a la agenda de la app."


## 4. Lista de Comprobación de Auditoría Interna (Para Tarea 2.3)

| Criterio | Descripción / Verificación | Cumple (S/N) | Notas / Observaciones |
| :--- | :--- | :---: | :--- |
| **Contraste** | Textos y elementos interactivos cumplen mínimo 4.5:1 (o 3:1 en grandes). | | |
| **Tamaño de Target** | Botones e iconos tienen un área táctil mínima de 48x48 dp. | | |
| **Jerarquía y Fuentes** | Escalado de texto funcional (Normal, Grande, Muy Grande) sin desbordamiento. | | |
| **Tabulación y Foco** | Navegación por teclado/lector accesible muestra foco visible en elementos. | | |
| **Coherencia Textual** | Botones y mensajes usan un lenguaje claro, conciso y sin modismos confusos. | | |
| **Retroalimentación** | Confirmación clara al completar acciones (ej. cambio visual tras "Tomada"). | | |


## 5. Plantilla de Registro de Problemas (Issue Log)

Utilizar la siguiente tabla para registrar los hallazgos encontrados durante la auditoría (#41) y las pruebas con usuarios (#72):

### Escala de Prioridad
* **Alta (P1):** impide completar la tarea o vulnera gravemente la accesibilidad (debe corregirse de inmediato).
* **Media (P2):** provoca confusión, demora en la tarea o genera errores leves.
* **Baja (P3):** detalle estético, sugerencia de mejora o pequeña inconsistencia visual.

### Tabla de Registro de Incidencias

| ID | Origen (#41 / #72) | Vista / Pantalla | Descripción del Problema | Criterio / Métrica Afectada | Prioridad (P1/P2/P3) | Estado | Solución Aplicada / Propuesta |
| :--- | :--- | :--- | :--- | :--- | :---: | :---: | :--- |
| *ERR-01* | *#41* | *Hoy (Dashboard)* | *El botón "Omitir" tiene un contraste de 2.8:1 sobre el fondo claro.* | *Contraste WCAG* | *P1* | *Pendiente* | *Aumentar la saturación del color del texto/fondo.* |
| *ERR-02* | *#72* | *Formulario Cita* | *El usuario de 52 años dudó al elegir el tipo de especialista por texto pequeño.* | *Tiempo / Errores* | *P2* | *Pendiente* | *Aumentar tamaño de fuente y padding del dropdown.* |

---

## 6. Documentación de Mejoras (Evidencia)

Para cada problema **P1** o **P2** corregido, se adjuntará la evidencia gráfica correspondiente:

### Registro de Cambio: [ID del Problema]
* **Descripción del ajuste:** Explicación técnica/visual del cambio.
* **Captura Antes:** `![Antes](ruta/a/captura_antes.png)`
* **Captura Después:** `![Después](ruta/a/captura_despues.png)`

---

## 7. Revisar mensajes y textos

En cumplimiento de las pautas WCAG 2.1 y con el objetivo de garantizar una comunicación clara para personas mayores y cuidadores, se ha investigado y rediseñado la interfaz de la aplicación TempoMedic.

Esas pautas hacen referencia a las 4 principios fundamentales:

- Perceptible: la información y los componentes de la interfaz deben presentarse de manera que los usuarios puedan percibirlos.
- Operable: los componentes de la interfaz y la navegación deben poder ser utilizados mediante el teclado y otros dispositivos de apoyo.
- Comprensible: la información y el funcionamiento de la interfaz deben ser claros, legibles y con un comportamiento predecible.
- Robusto: el contenido debe ser lo suficientemente fiable para ser interpretado por una gran variedad de agentes de usuario, incluidas las tecnologías de asistencia.

### Criterios de Redacción Aplicados
* **Claridad y Empatía:** explicar el problema sin usar tecnicismos ni códigos de error.
* **Orientación a la Acción:** indicar siempre el paso siguiente para solucionar la situación.
* **Brevedad:** textos concisos y directos para evitar la sobrecarga cognitiva.

### Tabla Comparativa de Mensajes (Antes -> Después)

| ID | Tipo de Mensaje | Pantalla / Contexto | Texto Original (Antes) | Texto Rediseñado (Después) | Justificación / Mejora Aplicada |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **MSG-01** | Error de Validación | Iniciar Sesión | `Error 401: Credenciales inválidas.` | `El correo o la contraseña no son correctos. Por favor, revisa los datos e inténtalo de nuevo.` | Elimina el código técnico y explica qué verificar. |
| **MSG-02** | Error de Formulario | Crear Cuenta | `Formato de email no válido.` | `Escribe un correo electrónico válido (ejemplo: usuario@correo.com).` | Añade un ejemplo para orientar a personas con menor competencia digital. |
| **MSG-03** | Confirmación | Módulo Medicamentos | `Registro guardado con éxito.` | `¡Medicamento guardado! Te avisaremos según el horario configurado.` | Confirma la acción y aporta tranquilidad sobre el aviso. |
| **MSG-04** | Confirmación | Vista "Hoy" (Dashboard) | `Estado cambiado.` | `Toma registrada como "Tomada". ¡Buen trabajo!` | Da retroalimentación clara sobre el estado asignado. |
| **MSG-05** | Confirmación / Alerta | Vista "Hoy" (Dashboard) | `Toma pospuesta.` | `Toma pospuesta. Te volveremos a avisar en 15 minutos.` | Especifica el tiempo en el que reaparecerá la alarma. |
| **MSG-06** | Ayuda | Formulario Citas | `Introduce dirección...` | `Escribe el centro de salud, hospital o dirección de la consulta.` | Aclara qué tipo de lugar se espera en el campo. |
| **MSG-07** | Error de Campo Vacío | Añadir Medicamento | `Campo requerido.` | `Por favor, escribe el nombre del medicamento para poder continuar.` | Indica de forma amable el campo que falta por completar. |
| **MSG-08** | Advertencia / Confirmación | Ajustes | `¿Seguro que quieres borrar todo?` | `¿Quieres eliminar tu cuenta? Se borrarán todos tus medicamentos y citas guardados.` | Explica el impacto exacto de la acción irrecuperable. |
| **MSG-09** | Error de Acceso | Desbloqueo por PIN | `PIN erróneo.` | `El PIN introducido no es correcto. Te quedan 2 intentos.` | Informa del fallo y del margen de intentos restantes. |
| **MSG-10** | Estado Vacío | Módulo Citas | `No hay registros.` | `No tienes citas programadas. Pulsa en "+ Pedir cita" para añadir la primera.` | Convierte una pantalla vacía en una llamada a la acción (CTA). |
