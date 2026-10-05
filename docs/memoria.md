# Memoria del Sprint 1: Ideación y Prototipado Base

| | |
| --- | --- |
| **Curso** | DAM 2 |
| **Grupo** | Grupo 2 |
| **Integrantes** | María Dolores Barba<br> Alba Durán <br> Santiago González <br> Jorge Espejo |
| **Módulo / profesor** | PI/DII - Willman Acosta Lugo |
| **Sprint** | Sprint 1 <br> 24/09/2026 – 02/10/2026 |
| **Repositorios** | <https://github.com/SantiagoGonzalez12/Tempomedic> <br> <https://github.com/SantiagoGonzalez12/Tempomedic-Interfaz> |
| **Tablero** | <https://github.com/users/SantiagoGonzalez12/projects/6> |


## DECLARACIÓN DE AUTORÍA Y ORIGINALIDAD

Los integrantes del Grupo 2 del 2º curso de Desarrollo de Aplicaciones Multiplataforma (María Dolores Barba, Alba Durán, Santiago González y Jorge Espejo), declaramos que el presente documento y el prototipo de software que lo acompaña son trabajo original del equipo, elaborado específicamente para el módulo de Proyecto Intermodular (PI/DII) bajo la tutela de Willman Acosta Lugo.

Todo el contenido tomado de fuentes externas (documentación técnica, artículos, estudios, código de ejemplo de terceros) está debidamente citado en el apartado de Referencias, siguiendo el formato *IEEE*. El equipo es consciente de que el plagio no es profesional y de que cualquier uso no declarado de trabajo ajeno constituye una falta grave.

## RESUMEN EJECUTIVO

Tempomedic es una aplicación pensada para resolver dos problemas cotidianos en la gestión de la salud personal: el olvido de tomas de medicación y la dificultad para organizar citas médicas. Según la encuesta propia realizada a 66 personas, el 73% olvida alguna vez su medicación y solo un 15% usa ya una aplicación dedicada a este fin, lo que confirma tanto la necesidad como la oportunidad.

La solución reúne en un único sitio el registro de medicamentos con su pauta de tomas, avisos configurables por notificación y/o alarma, un panel diario ("Hoy") que combina las tomas pendientes y las próximas citas, y una agenda de consultas médicas. El diseño presta especial atención a la accesibilidad (tamaños de texto ajustables, iconos siempre acompañados de texto) y a la privacidad (bloqueo por PIN, consentimiento explícito para datos de salud), dos aspectos que la encuesta señaló como prioritarios para el 95% y el 70% de los encuestados respectivamente, muchos de ellos mayores de 46 años.

Este primer sprint (*Sprint 1: Ideación y Prototipado Base*) se centra en el diseño del prototipo de la interfaz gráfica. El prototipo cubre las cinco vistas principales de la aplicación (acceso, Hoy, Medicamentos, Citas y Ajustes). El trabajo se ha organizado con metodología Scrum, documentado en GitHub mediante issues, tablero y entregas por sprint.

## PALABRAS CLAVE
 
Java - Swing - NetBeans Matisse - MVC - salud digital - Health - recordatorios de medicación - gestión de citas médicas - accesibilidad - privacidad - Scrum - healthcare - medication-reminder

## ÍNDICE 

- [1. INTRODUCCIÓN](#1-introducción)
  - [1.1. Contexto del proyecto](#11-contexto-del-proyecto)
  - [1.2. Problema o necesidad detectada](#12-problema-o-necesidad-detectada)
  - [1.3. Propuesta de solución](#13-propuesta-de-solución)
  - [1.4. Objetivos del proyecto](#14-objetivos-del-proyecto)
    - [1.4.1. Objetivo general](#141-objetivo-general)
    - [1.4.2. Objetivos específicos](#142-objetivos-específicos)
  - [1.5. Alcance del proyecto](#15-alcance-del-proyecto)
  - [1.6. Limitaciones y exclusiones](#16-limitaciones-y-exclusiones)
  - [1.7. Estructura de la memoria](#17-estructura-de-la-memoria)
- [2. ANÁLISIS DEL CONTEXTO Y VIABILIDAD](#2-análisis-del-contexto-y-viabilidad)
  - [2.1. Sector profesional y perfil de usuarios](#21-sector-profesional-y-perfil-de-usuarios)
  - [2.2. Análisis de la necesidad](#22-análisis-de-la-necesidad)
  - [2.3. Estudio de soluciones existentes](#23-estudio-de-soluciones-existentes)
  - [2.4. Partes interesadas](#24-partes-interesadas)
  - [2.5. Estudio de viabilidad técnica](#25-estudio-de-viabilidad-técnica)
  - [2.6. Estudio de viabilidad económica](#26-estudio-de-viabilidad-económica)
  - [2.7. Estudio de viabilidad legal y normativa](#27-estudio-de-viabilidad-legal-y-normativa)
    - [2.7.1. Protección de datos personales](#271-protección-de-datos-personales)
    - [2.7.2. Propiedad intelectual y licencias](#272-propiedad-intelectual-y-licencias)
    - [2.7.3. Accesibilidad y otros requisitos aplicables](#273-accesibilidad-y-otros-requisitos-aplicables)
  - [2.8. Análisis de riesgos inicial](#28-análisis-de-riesgos-inicial)
- [3. PLANIFICACIÓN Y GESTIÓN DEL PROYECTO](#3-planificación-y-gestión-del-proyecto)
  - [3.1. Metodología de desarrollo empleada](#31-metodología-de-desarrollo-empleada)
  - [3.2. Organización del equipo y reparto de responsabilidades](#32-organización-del-equipo-y-reparto-de-responsabilidades)
  - [3.3. Roles del proyecto](#33-roles-del-proyecto)
  - [3.4. Plan de trabajo](#34-plan-de-trabajo)
  - [3.5. Cronograma e hitos](#35-cronograma-e-hitos)
  - [3.6. Estimación de recursos](#36-estimación-de-recursos)
  - [3.7. Presupuesto estimado](#37-presupuesto-estimado)
  - [3.8. Gestión de riesgos](#38-gestión-de-riesgos)
  - [3.9. Herramientas de comunicación, coordinación y seguimiento](#39-herramientas-de-comunicación-coordinación-y-seguimiento)
  - [3.10. Gestión de versiones y repositorio de código](#310-gestión-de-versiones-y-repositorio-de-código)
- [4. ANÁLISIS DE REQUISITOS](#4-análisis-de-requisitos)
  - [4.1. Identificación de usuarios y perfiles](#41-identificación-de-usuarios-y-perfiles)
  - [4.2. Requisitos funcionales](#42-requisitos-funcionales)
  - [4.3. Requisitos no funcionales](#43-requisitos-no-funcionales)
  - [4.4. Reglas de negocio](#44-reglas-de-negocio)
  - [4.5. Casos de uso o historias de usuario](#45-casos-de-uso-o-historias-de-usuario)
  - [4.6. Priorización de requisitos](#46-priorización-de-requisitos)
  - [4.7. Matriz de trazabilidad de requisitos](#47-matriz-de-trazabilidad-de-requisitos)


## 1. INTRODUCCIÓN

### 1.1. Contexto del proyecto

En la actualidad, el uso de dispositivos móviles se ha vuelto indispensable para la gestión de tareas cotidianas, y el ámbito de la salud digital es una de las áreas con mayor crecimiento y demanda tecnológica.

El proyecto consiste en el desarrollo de una aplicación móvil orientada a la gestión individual de la salud, la plataforma tiene en un único sistema dos funcionalidades clave: 

* La reserva y gestión de citas médicas 
* Módulo de control de medicación con alertas automáticas

En cuanto a la parte técnica de este proyecto el sistema se ha estructurado mediante una arquitectura cliente-servidor. Cuenta con una aplicación móvil como frontend, un backend y una base de datos relacional para la persistencia de la información, además, la aplicación hace uso de servicios en segundo plano y gestores de tareas del sistema operativo móvil para garantizar el lanzamiento preciso de las notificaciones de los medicamentos, incluso en el caso de que no haya conexión a Internet.

### 1.2. Problema o necesidad detectada

En el día a día del cuidado de la salud, las personas se encuentran principalmente con dos problemas:

* **Olvidos con la medicación:** Muchas personas se preguntan continuamente *"¿A qué hora me tocaba la pastilla?"* y terminan olvidando tomarla. Esto es peligroso para la salud, tanto para quienes toman un tratamiento puntual (como un antibiótico durante una semana) como para pacientes mayores o crónicos que tienen que tomar varias medicinas al día.
* **Dificultades para pedir cita médica:** Conseguir una cita con el médico, ya sea por internet o en persona, suele ser un proceso lento y desesperante para la mayoría de los usuarios.

### 1.3. Propuesta de solución

Para resolver estos dos problemas nace TempoMedic, una aplicación móvil muy fácil de usar que ayuda a los usuarios a gestionar su salud desde un solo lugar:

* **Recordatorios inteligentes de medicamentos:** El usuario escribe qué medicina tiene que tomar, la dosis y cada cuánto tiempo. La app envía avisos al teléfono (que pueden ser con sonido o solo con vibración) para avisar del momento exacto de la toma, sin necesidad de tener conexión a internet. Además, cuenta con una pantalla principal para ir marcando las pastillas como "Tomada" u "Omitida".
* **Agenda sencilla de citas médicas:** Permite guardar las próximas visitas al médico eligiendo el especialista o la fecha. La aplicación avisa automáticamente al usuario dos veces (24 horas y 2 horas antes de la cita) y permite guardar el recordatorio en el calendario del propio móvil (como Google Calendar).

  
### 1.4. Objetivos del proyecto
  #### 1.4.1. Objetivo general
  Desarrollar Tempomedic, una aplicación de gestión de salud personal que ayude a los usuarios a no olvidar sus tomas de medicación ni sus citas médicas, mediante recordatorios personalizables y una interfaz sencilla, accesible y respetuosa con la privacidad de los datos de salud.

  #### 1.4.2. Objetivos específicos 
  Aunque el proyecto tiene muy claro dónde quiere llegar, la verdadera captación son en los pequeños detalles que marcan la diferencia. Hoy en día existen muchas aplicaciones que se limitan a cumplir sus función, pero lo que realmente distinguirá a esta es su facilidad de uso y su capacidad para no dejar a nadie fuera.

  La aplicación, TempoMedic, nace para acompañar a personas de cualquier edad, aunque pone la mirada en un grupo fundamental, los mayores. Ellos son la población más expuesta a los cambios de los últimos tiempo; no crecieron rodeados de pantallas y han tenido que adaptarse, paso a paso, tanto a las transformaciones tecnológicas como a los avances médicos.

  Por eso, la app prescinde de complicaciones innecesarias. Apuesta por una navegación limpia y sencilla, donde la información siempre estará en primera mano junto a la ayuda que se soliciten. 

### 1.5. Alcance del proyecto
Para definir el alcance de la app, lo ideal es estructurarla en tres fases que vayan progresivamente para tenerla muy clara desde el principio.
* Primera fase: recopilar la información de los usuarios. Una vez completado, desarrollar un programa de recordatorios de medicación con notificaciones, alarmas o registros de tomas. Posibilidad de asociarlo a aplicaciones nativas del móvil como Apple Calendar o Google.
* Segunda fase: fidelizar a los usuarios sin complicar en exceso la tecnología. Aquí se incluye el control de inventario de pastillas para avisar cuando toque ir a la farmacia, la opción de gestionar perfiles de familiares dependientes, el guardado de fotos de recetas o informes médicos y la generación de un PDF con el historial de tomas para enseñárselo al médico (opcional).
* Tercera fase: se intentará conectar la app con bases de datos oficiales de medicamentos para buscar la medicina y detectar interacciones entre ellos. Poder integrar APIS con clínicas para reservar citas desde la app y añadir seguimiento de la medicación.

Los medicamentos tienen que estar protegidos legalmente por la normativa RGPD.

### 1.6. Limitaciones y exclusiones
El desarrollo de la aplicación no solo define las funciones que se van a construir, sino también aquellas que quedan fuera de la app para evitar costes innecesarios, problemas de tiempo o riesgos en la entrega.

Las limitaciones son los problemas técnicos con los que nace la app. La principal dificultad es la dependencia de los avisos del propio teléfono, los sistemas operativos a veces bloquean o retrasan las notificaciones para ahorrar batería, por lo que la app debe pedir permisos especiales al usuario. Otra limitación clave es que toda la información se guarda únicamente en el móvil durante esta primera versión, si el usuario pierde o cambia de teléfono, perderá su historial a menos que haga una copia de seguridad manual. Además, la precisión de las citas dependerá al 100% de que el usuario escriba bien las fechas y lugares, ya que la app no se conecta en tiempo real con la agenda del médico.

Las exclusiones son las funciones que quedan expresamente fuera de la app desde el primer día. La aplicación no ofrecerá diagnósticos, consejos de salud ni recetas de ningún tipo. Tampoco se conectará con los sistemas informáticos de la sanidad pública ni con historiales médicos oficiales. Queda excluida la posibilidad de comprar medicinas a domicilio, gestionar urgencias médicas o conectarse con aparatos físicos como pastilleros inteligentes.

Para que la app funcione de forma ágil y ordenada en Java, el código se organiza separando la pantalla de la lógica interna. La pantalla solo se encarga de mostrar la información y recoger lo que toca el usuario, como pulsar "Tomar pastilla"). Por detrás, un módulo invisible procesa esa orden, guarda el dato en la memoria del teléfono y le pide al sistema operativo que reeprograme o cancele la próxima alarma, sin que la aplicación tenga que estar abierta todo el tiempo.

El interior de la app en Java se compone de cuatro elementos principales:

**El Medicamento:** guarda la ficha del tratamiento (nombre de la medicina, cantidad que hay que tomar y cada cuántas horas). Se encarga de calcular automáticamente las fechas y horas de las futuras tomas.

**La Toma:** es el registro de una alarma concreta. Guarda el día, la hora exacta, y si la pastilla se ha marcado como tomada, posponer u omitida.

**La Cita Médica:** guarda la información de la consulta (médico, fecha, hora y lugar) y se encarga de preparar los datos para pasárselos al calendario del teléfono (Google Calendar) cuando el usuario quiera guardarla allí (futura idea).

**El Gestor de Avisos:** Es la pieza que habla directamente con el móvil para poner las alarmas a sonar a la hora exacta, y tiene la función vital de volver a activar todos los recordatorios si el usuario apaga o reinicia el teléfono.

### 1.7. Estructura de la memoria
En primer lugar hay que hablar del alcance del proyecto:
* Objetivo general: desarrollar una aplicación móvil para la gestión personal de tratamientos médicos y recordatorios de citas.
* Objetivos específicos: reducir el olvido de las tomas, centralizar la agenda de consultas y garantizar la privacidad del usuario mediante almacenamiento local.

Módulos y funcionalidades:
* Módulo de medicación: registro de tratamientos, programación de alarmas/notificaciones y marcar el cumplimiento.
* Módulo de citas: agenda manual de consultas y sincronización con el calendario nativo.
* Módulo de persistencia local: almacenamiento seguro en el dispositivo.

En segundo lugar, limitaciones del sistema:
* Gestión en segundo plano: optimización de la dependencia del sistema operativo.
* Persistencia y Backup: ausencia de sincronización en la nube, la pérdida del dispositivo implica la pérdida del historial.
* Entrada de datos: la exactitud de los mismos depende totalmente del registro manual introducido por el usuario.

En tercer lugar, exclusiones del proyecto que están fuera de su alcance:
* Asistencia médica: no se proporciona diagnóstico ni asesoramiento
* Integración externa: sin conexión a historial clínico oficiales, APIS de salud pública.
* Hardware y comercio: sin soporte para un pastillero inteligente ni gestión de compra/envío de medicamentos.
* Urgencias: no incluye botones de pánico ni protocolos de emergencia médica.

## 2. ANÁLISIS DEL CONTEXTO Y VIABILIDAD

### 2.1. Sector profesional y perfil de usuarios
### 2.2. Análisis de la necesidad
### 2.3. Estudio de soluciones existentes
Aplicaciones similares en el mercado:

* **MedControl**: funciona como un asistente de salud personal y pastillero virtual. Permite crear alarmas personalizadas para medicamentos, llevar un control de inventario y organizar recordatorios para citas médicas. Además, incluye un diario de tensión arterial y seguimiento de síntomas.  
* **Recordatorio de Medicamentos 2**: se centra en la adherencia al tratamiento. Ofrece recordatorios altamente configurables (cada X horas, días específicos, etc.), alertas cuando quedan pocas pastillas y la posibilidad de enviar reportes por correo al médico. Además permite agendar recordatorios de citas médicas.  
* **CareClinic**: va más allá de la medicación. Permite a los usuarios registrar síntomas, mediciones, estado de ánimo y nutrición. Sus recordatorios son personalizables para medicamentos y citas, también admite la gestión de múltiples perfiles, como hijos o personas mayores.  
* **Biva**: está diseñada para pacientes y cuidadores. Permite registrar condiciones médicas y tratamientos, estableciendo recordatorios para cada uno. Integra servicios como la recarga de medicamentos y la reserva de citas médicas, con un enfoque en la relación paciente-cuidador.  
* **DayMedy**: es una aplicación de telemedicina que integra consultas en línea, gestión de prescripciones digitales y programación de citas. Tras una consulta, el usuario recibe la receta en la app y puede configurar recordatorios para la medicación. También permite gestionar los registros de salud de la familia.  
* **Medical Reminder**: se enfoca en la simplicidad y la privacidad, funcionando sin conexión a internet. Ofrece recordatorios fiables para medicamentos y citas médicas, con un diseño de texto grande ideal para adultos mayores y cuidadores. Permite generar informes de salud en PDF para compartir con los médicos.  
* **Otras aplicaciones**: también existen ejemplos como **IMQ** (de una aseguradora de salud), **MyCarePlan**, **PineApp** y **MedGemak**, que ofrecen funcionalidades parciales o totales, como gestión de citas, historial clínico, videoconsulta y alarmas de medicación.

Noticias y tendencias recientes:

* **Éxito de las tarjetas sanitarias virtuales**: en la Comunidad de Madrid, la Tarjeta Sanitaria Virtual (TSV) ha registrado cerca de 57 millones de accesos en 2025, un 43,5% más que el año anterior. Los servicios más utilizados son la gestión de citas médicas, la consulta de medicación y el acceso a informes. La aplicación ha incorporado herramientas como recordatorios de citas de atención primaria, que han enviado más de 5 millones de notificaciones, y alertas sobre la dispensación de medicamentos en farmacias.  
* **Integración de IA en portales de pacientes**: Oracle Health ha lanzado un portal de pacientes con inteligencia artificial que ofrece resúmenes de salud, recordatorios automáticos de visitas y la posibilidad de programar citas de seguimiento. Esta IA ayuda a los pacientes a entender sus planes de cuidado y medicamentos en un lenguaje sencillo, buscando mejorar la adherencia al tratamiento.  
* **Nuevos modelos de negocio y funcionalidades**: Startups como **Assort Health** han levantado capital significativo para plataformas que utilizan IA para conectar la programación de citas, la gestión de medicamentos y los pagos en un solo sistema. Por otro lado, **Amazon** ha lanzado un agente de IA para la salud que puede reservar citas y gestionar recetas médicas.  
* **Investigación en universidades**: investigadores de la Universidad Miguel Hernández (UMH) de Elche han desarrollado una aplicación para que personas con inmunodeficiencias puedan autogestionar su enfermedad, incluyendo el control de citas y tratamientos con recordatorios personalizados.

Comparación
| | Otras apps | Tempomedic |

### 2.4. Partes interesadas
### 2.5. Estudio de viabilidad técnica
### 2.6. Estudio de viabilidad económica
### 2.7. Estudio de viabilidad legal y normativa
   #### 2.7.1. Protección de datos personales
   #### 2.7.2. Propiedad intelectual y licencias
   #### 2.7.3. Accesibilidad y otros requisitos aplicables
### 2.8. Análisis de riesgos inicial


## 3. PLANIFICACIÓN Y GESTIÓN DEL PROYECTO
  ### 3.1. Metodología de desarrollo empleada
  Para el desarrollo del proyecto, se ha seleccionado el modelo en cascada tradicional. Esta metodología se caracteriza por un enfoque secuencial, donde cada fase del ciclo del desarrollo debe completarse y validarse por todos antes de pasar a la siguiente.

  ### 3.2. Organización del equipo y reparto de responsabilidades
  1. **Alba Durán:**
	Coordinacion de las reuniones, planificación general de sprint, supervisión del cumplimiento de los plazos de entrega, redacción de la descripción, problemas y soluciones del proyecto

2. **Santiago Gonzalez:** 
Creación de la maquetación, diseño de los componentes visuales,cuidado de colores y cumplimiento de las especificaciones visuales de la aplicación, además de diseñar una interfaz sencilla y fácil de usar para los  usuarios

3. **Jorge Espejo:**
Al no haber parte de código como tal en este sprint, ha realizado colaboración con el frontend para definir como se van a comunicar los componentes gráficos, además de la redacción de puntos como las decisione técnicas tomadas, etc 

4. **Maria Dolores Barba:**  
   Evaluación de que las interface scumplen todos los criterios, revisión de toda la documentación, además de participación en partes del proyecto 

  ### 3.3. Roles del proyecto
  -Alba Duran → Scrum Máster 
  
  -Jorge Espejo → Backend

  -Santiago Gonzalez → Frontend 
  
  -Maria Dolores Barba → Tester (UQ)

  ### 3.4. Plan de trabajo
  ### 3.5. Cronograma e hitos
  ### 3.6. Estimación de recursos
  ### 3.7. Presupuesto estimado
  ### 3.8. Gestión de riesgos
  ### 3.9. Herramientas de comunicación, coordinación y seguimiento
  ### 3.10. Gestión de versiones y repositorio de código
## 4. ANÁLISIS DE REQUISITOS
  ### 4.1. Identificación de usuarios y perfiles
  ### 4.2. Requisitos funcionales
  ### 4.3. Requisitos no funcionales
  ### 4.4. Reglas de negocio
  ### 4.5. Casos de uso o historias de usuario
  ### 4.6. Priorización de requisitos
  ### 4.7. Matriz de trazabilidad de requisitos
