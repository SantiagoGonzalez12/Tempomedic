# Memoria del Sprint 1: Ideación y Prototipado Base

| | |
| --- | --- |
| **Curso** | DAM 2 |
| **Grupo** | Grupo 2 |
| **Integrantes** | María Dolores Barba <br> Alba Durán <br> Santiago González <br> Jorge Espejo |
| **Módulo / profesor** | PI/DII - Willman Acosta Lugo |
| **Sprint** | Sprint 1 (24/09/2026 – 02/10/2026) <br> Sprint 2 (03/10/2026 - 30/10/2026)|
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
- [5. DISEÑO DE LA SOLUCIÓN]()
  - [5.1. Visión general de la arquitectura]()
  - [5.2. Arquitectura software]()
    - [5.2.1. Patrón arquitectónico utilizado]()
    - [5.2.2. Componentes y módulos]()
    - [5.2.3. Comunicación entre componentes]()
  - [5.3. Diseño de la base de datos]()
    - [5.3.1. Modelo conceptual]()
    - [5.3.2. Modelo lógico]()
    - [5.3.3. Modelo físico]()
    - [5.3.4. Diccionario de datos]()
  - [5.4. Diseño de la interfaz de usuario]()
    - [5.4.1. Principios de usabilidad y accesibilidad]()
    - [5.4.2. Mapa de navegación]()
    - [5.4.3. Wireframes o prototipos]()
    - [5.4.4. Diseño visual final]()
  - [5.5. Diseño de seguridad]()
    - [5.5.1. Autenticación y autorización]()
    - [5.5.2. Protección de datos]()
    - [5.5.3. Gestión de errores y validaciones]()
  - [5.6. Diseño de integraciones y APIs externas]()
- [6. DESARROLLO E IMPLEMENTACIÓN](#6-desarrollo-e-implementación)
  - [6.1. Tecnologías, lenguajes y frameworks utilizados](#61-tecnologías-lenguajes-y-frameworks-utilizados)
  - [6.6. Implementación de la interfaz de usuario](#66-implementación-de-la-interfaz-de-usuario)
- [REFERENCIAS](#referencias)

## 1. INTRODUCCIÓN

### 1.1. Contexto del proyecto

Hoy en día, la transformación digital ha cambiado radicalmente la forma en que gestionamos nuestra vida diaria a través de los dispositivos móviles. Dentro de este proceso, la salud digital se ha consolidado como una de las áreas de mayor expansión, respondiendo a una demanda creciente de herramientas que faciliten el cuidado personal.

Sin embargo, a pesar de este avance, las personas siguen encontrando serias dificultades para mantener una correcta adherencia a sus tratamientos y organizar sus consultas médicas, lo que evidencia la necesidad de soluciones tecnológicas más integrales y eficientes.

Como respuesta a este escenario, se presenta **Tempomedic**: una aplicación móvil orientada a la gestión personal de la salud que unifica en una sola plataforma dos funciones esenciales:

- **Reserva y gestión centralizada de citas médicas.**
- **Módulo de control de medicación con alertas automáticas.**

### 1.2. Problema o necesidad detectada

En el día a día del cuidado de la salud, las personas se encuentran principalmente con dos problemas:

- **Olvidos con la medicación:** Muchas personas se preguntan continuamente *"¿A qué hora me tocaba la pastilla?"* y terminan olvidando tomarla. Esto es peligroso para la salud, tanto para quienes toman un tratamiento puntual (como un antibiótico durante una semana) como para pacientes mayores o crónicos que tienen que tomar varias medicinas al día
- **Dificultades para pedir cita médica:** Conseguir una cita con el médico, ya sea por internet o en persona, suele ser un proceso lento y desesperante para la mayoría de los usuarios

Estas problemáticas se confirmaron a través de una **recolección de datos primarios mediante una encuesta**. A partir de las preguntas realizadas a los usuarios, analizamos directamente sus necesidades reales y de uso diario. En base a estas evidencias y a las carencias detectadas, diseñamos y desarrollamos nuestra aplicación: **Tempomedic**

### 1.3. Propuesta de solución

Para dar respuesta a los problemas identificados en el estudio de mercado, nace **Tempomedic**: una solución tecnológica integral diseñada para centralizar la gestión de la salud personal en una única plataforma móvil intuitiva y accesible.

La propuesta aborda las necesidades del usuario estructurándose en dos módulos principales:

- **Módulo de Gestión y Recordatorios de Medicamentos:**
  - **Configuración personalizada:** El usuario puede registrar el nombre del fármaco, la dosis exacta y la frecuencia de toma de forma sencilla.
  - **Sistema de alertas offline:** La aplicación programa notificaciones automáticas en el dispositivo que se ejecutan de manera precisa, sin necesidad de contar con conexión a Internet activa
  - **Control de seguimiento diario:** Incluye una pantalla principal interactiva donde el paciente puede marcar el estado de cada toma en tiempo real (como *"Tomada"*, *"Posponer"* u *"Omitida"*)

- **Módulo de Agenda y Citas Médicas:**
  - **Centralización de consultas:** Ofrece una agenda organizada para registrar, consultar y gestionar las próximas citas médicas, evitando la pérdida de fechas o la dispersión de información en papeles
  - **Control de especialidades y centros:** Permite asociar cada cita a su correspondiente especialidad médica y centro hospitalario para un control exhaustivo del historial de consultas

### 1.4. Objetivos del proyecto

#### 1.4.1. Objetivo general

  Desarrollar Tempomedic, una aplicación de gestión de salud personal que ayude a los usuarios a no olvidar sus tomas de medicación ni sus citas médicas, mediante recordatorios personalizables y una interfaz sencilla, accesible y respetuosa con la privacidad de los datos de salud.

#### 1.4.2. Objetivos específicos

  Aunque el proyecto tiene muy claro dónde quiere llegar, la realidad se marca aunque sea en los pequeños detalles. Hoy en día existen muchas aplicaciones que se limitan a cumplir sus función, pero lo que realmente distinguirá a esta es su facilidad de uso y su capacidad para no dejar a nadie fuera.

Tempomedic nace para recordar y acompañar a personas de cualquier edad, aunque pone la mirada en un grupo fundamental, los mayores. Ellos son la población más expuesta a los cambios de los últimos tiempo; no crecieron rodeados de pantallas y han tenido que adaptarse, paso a paso, tanto a las transformaciones tecnológicas como a los avances médicos.

Por eso, la app queda exenta de cualquier complicación. Se apuesta por una navegación sencilla y a una disposición de ayuda necesitada.

### 1.5. Alcance del proyecto

Para definir el alcance de la app, lo ideal es estructurarla en tres fases que vayan progresivamente para tenerla muy clara desde el principio.

- Primera fase: recopilar la información de los usuarios. Una vez completado, desarrollar un programa de recordatorios de medicación con notificaciones, alarmas o registros de tomas. Posibilidad de asociarlo a aplicaciones nativas del móvil como Apple Calendar o Google.
- Segunda fase: fidelizar a los usuarios sin complicar en exceso la tecnología. Aquí se incluye el control de inventario de pastillas para avisar cuando toque ir a la farmacia, la opción de gestionar perfiles de familiares dependientes, el guardado de fotos de recetas o informes médicos y la generación de un PDF con el historial de tomas para enseñárselo al médico (opcional).
- Tercera fase: se intentará conectar la app con bases de datos oficiales de medicamentos para buscar la medicina y detectar interacciones entre ellos. Poder integrar APIS con clínicas para reservar citas desde la app y añadir seguimiento de la medicación.

Los medicamentos tienen que estar protegidos legalmente por la normativa RGPD.

### 1.6. Limitaciones y exclusiones

El desarrollo de la aplicación no solo define las funciones que se van a construir, sino también aquellas que quedan fuera de la app para evitar costes innecesarios, problemas de tiempo o riesgos en la entrega.

Las limitaciones son los problemas técnicos con los que nace la app. La principal dificultad es la dependencia de los avisos del propio teléfono, los sistemas operativos a veces bloquean o retrasan las notificaciones para ahorrar batería, por lo que la app debe pedir permisos especiales al usuario. Otra limitación clave es que toda la información se guarda únicamente en el móvil durante esta primera versión, si el usuario pierde o cambia de teléfono, perderá su historial a menos que haga una copia de seguridad manual. Además, la precisión de las citas dependerá al 100% de que el usuario escriba bien las fechas y lugares, ya que la app no se conecta en tiempo real con la agenda del médico.

Las exclusiones son las funciones que quedan expresamente fuera de la app desde el primer día. La aplicación no ofrecerá diagnósticos, consejos de salud ni recetas de ningún tipo. Tampoco se conectará con los sistemas informáticos de la sanidad pública ni con historiales médicos oficiales. Queda excluida la posibilidad de comprar medicinas a domicilio, gestionar urgencias médicas o conectarse con aparatos físicos como pastilleros inteligentes.

Para que la app funcione de forma ágil y ordenada en Java, el código se organiza separando la pantalla de la lógica interna. La pantalla solo se encarga de mostrar la información y recoger lo que toca el usuario, como pulsar "Tomar pastilla". Por detrás, un módulo invisible procesa esa orden, guarda el dato en la memoria del teléfono y le pide al sistema operativo que reeprograme o cancele la próxima alarma, sin que la aplicación tenga que estar abierta todo el tiempo.

El interior de la app en Java se compone de cuatro elementos principales:

**El Medicamento:** guarda la ficha del tratamiento (nombre de la medicina, cantidad que hay que tomar y cada cuántas horas). Se encarga de calcular automáticamente las fechas y horas de las futuras tomas.

**La Toma:** es el registro de una alarma concreta. Guarda el día, la hora exacta, y si la pastilla se ha marcado como tomada, posponer u omitida.

**La Cita Médica:** guarda la información de la consulta (médico, fecha, hora y lugar) y se encarga de preparar los datos para pasárselos al calendario del teléfono (Google Calendar) cuando el usuario quiera guardarla allí (futura idea).

**El Gestor de Avisos:** Es la pieza que habla directamente con el móvil para poner las alarmas a sonar a la hora exacta, y tiene la función vital de volver a activar todos los recordatorios si el usuario apaga o reinicia el teléfono.

### 1.7. Estructura de la memoria

En primer lugar hay que hablar del alcance del proyecto:

- Objetivo general: desarrollar una aplicación móvil para la gestión personal de tratamientos médicos y recordatorios de citas.
- Objetivos específicos: reducir el olvido de las tomas, centralizar la agenda de consultas y garantizar la privacidad del usuario mediante almacenamiento local.

Módulos y funcionalidades:

- Módulo de medicación: registro de tratamientos, programación de alarmas/notificaciones y marcar el cumplimiento.
- Módulo de citas: agenda manual de consultas y sincronización con el calendario nativo.
- Módulo de persistencia local: almacenamiento seguro en el dispositivo.

En segundo lugar, limitaciones del sistema:

- Gestión en segundo plano: optimización de la dependencia del sistema operativo.
- Persistencia y Backup: ausencia de sincronización en la nube, la pérdida del dispositivo implica la pérdida del historial.
- Entrada de datos: la exactitud de los mismos depende totalmente del registro manual introducido por el usuario.

En tercer lugar, exclusiones del proyecto que están fuera de su alcance:

- Asistencia médica: no se proporciona diagnóstico ni asesoramiento
- Integración externa: sin conexión a historial clínico oficiales, APIS de salud pública.
- Hardware y comercio: sin soporte para un pastillero inteligente ni gestión de compra/envío de medicamentos.
- Urgencias: no incluye botones de pánico ni protocolos de emergencia médica.

## 2. ANÁLISIS DEL CONTEXTO Y VIABILIDAD

### 2.1. Sector profesional y perfil de usuarios

#### 2.1.1 ¿En qué consiste?

La aplicación se encuadra en el sector de las tecnologías de la información aplicadas a la salud, un área estratégica del mercado del software orientada a la digitalización, gestión y optimización de los servicios sanitarios y el autocuidado del paciente.

El entorno productivo en el que operará la solución es un ecosistema híbrido que abarca:

- **El ámbito del autocuidado y la salud personal:** Soluciones dirigidas a capacitar al paciente en el control diario de su plan terapéutico
- **El ámbito del seguimiento y asistencia sanitaria:** Sistemas de programación, control de agenda y seguimiento de citas con profesionales médicos o centros de salud.

### Clasificación y definición de perfiles de usuario

1. **Perfil Paciente, Usuario Final (Perfil Principal):**

- **Descripción:** Personas que requieren llevar un control riguroso de su calendario de citas médicas y el horario de toma de sus medicamentos (por ejemplo, pacientes crónicos, personas en tratamientos temporales o adultos mayores).
- **Rol en el sistema:** Crear y gestionar recordatorios de medicación, visualizar la agenda de citas, marcar tomas como realizadas y consultar historiales/estadísticas de adherencia al tratamiento.

2. **Perfil Cuidador, Familiar (Perfil Secundario):**

- **Descripción:** Familiares o tutores legales a cargo de la supervisión de la salud de un tercero (por ejemplo, hijos al cuidado de padres mayores o tutores de personas dependientes).
- **Rol en el sistema:** Consultar o administrar de forma delegada la agenda de citas y recibir alertas en caso de omisión o incumplimiento en las tomas de medicamentos.

  ### 2.2.1. ¿Qué deben hacer y aportar?

#### 2.2.1.1. Caracterización del sector

#### A. Ámbito de actividad
El sector sanitario se encuentra en un proceso de transformación donde la atención no se limita a la visita presencial en el centro médico, sino que se extiende al hogar del paciente a través del seguimiento contínuo desde casa.

#### B. Tendencias de digitalización del sector
1. **Empoderamiento del paciente:** Transición de un modelo pasivo a uno donde el usuario gestiona activamente sus citas, recetas y hábitos de salud mediante aplicaciones accesibles en dispositivos personales.
2. **Uso de interfaces accesibles e inclusivas:** Apuesta por diseños limpios, con tonos cromáticos relajantes (como tonos azules) y componentes visuales adaptados a personas de avanzada edad o con diversidad funcional visual.
3. **Pérdida de adherencia como problema global:** Estudios del sector de la salud digital destacan que entre el 30% y el 50% de los pacientes crónicos no toman adecuadamente su medicación. La digitalización busca resolver este déficit mediante sistemas automáticos de notificación y trazabilidad.

#### C. Necesidades tecnológicas del sector
* **Centralización de la información sanitaria personal:** Unificar en una única herramienta la agenda y el plan de medicación para evitar la dispersión de datos.
* **Alertas y notificaciones persistentes:** Implementación de recordatorios fiables que funcionen incluso en segundo plano.
* **Arquitecturas modulares y escalables (MVC):** Necesidad de plataformas desacopladas que permitan conectar la lógica de negocio con interfaces limpias y adaptables 



### 2.2. Análisis de la necesidad

#### 2.2.1 ¿En qué consiste?

Tras la consultas y análisis de las necesidades del proyecto, hay que verificar si esos problemas son en verdad problemas reales. Se debe de justificar el tiempo en el que se invierte para poder solucionar las necesidad y no carecer de ellas.

#### 2.2.2 ¿Qué deben hacer y aportar?

#### 2.2.2.1 Diagnóstico de la situación de partida (As-Is)

En la actualidad la gestión cotidiana de los tratamientos farmacológicos y el control de las citas médicas se realiza, en su mayoría, mediante métodos tradicionales y poco estructurados:

**Control de la medicación:** los usuarios suelen confiar en su propia memoria, anotaciones manuscritas en los envases o recordatorios impresos. Esta falta de automatización dificulta el cumplimiento puntual de las tomas.

**Gestión de consultas y documentación:** los justificantes, recetas e informes médicos se conservan en papel o en distintos soportes físicos, lo que facilita su pérdida y complica llevar un seguimiento claro de cara a las siguientes revisiones

**Control de existencias(stock):** el recuento del inventario de medicamentos se realiza de forma visual e intuitiva, lo que provoca que el usuario descubra la falta de dosis cuando ya se ha agotado el tratamiento.

#### 2.2.2.2 Problemas y consecuencias identificadas

Este modelo de gestión manual genera incidencias recurrentes que afectan al bienestar del paciente y a la organización diaria:

**Olvidos y confusiones en las dosis:** la incertidumbre sobre si una toma se ha realizado previamente ocasiona omitir dosis necesarias o repetirlas de forma errónea, lo que compromete la efectividad del tratamiento.

**Barreras de uso en aplicaciones móviles:** las alternativas digitales actuales suelen presentar interfaces complejas, fuentes pequeñas, publicidad contextual o la necesidad constante de contar con conexión a Internet para operar.

**Pérdida de citas e historial clínico fragmentado:** las distracciones u olvidos derivan en inasistencias a consultas de seguimiento. Además, resulta difícil para el paciente presentar un registro detallado de su cumplimiento cuando acude a la revisión médica.

**Preocupación por la privacidad:** el manejo de información relativa a la salud genera reticencia si el usuario no cuenta con la certeza de que sus datos personales permanecen bajo su estricto control y protección.

#### 2.2.2.3 Propuesta de valor y situación deseada (To-Be)

Tempomedic unifica la gestión personal de la salud en una única aplicación móvil accesible, intuitiva y capaz de funcionar de manera autónoma sin conexión a Internet:

- Alertas de medicación y control del stock restante
- Agenda de citas médicas y archivo de imágenes de recetas
- Interfaz accesible (texto extensible y etiquetas asociadas)
- Almacenamiento local protegido mediante PIN

Con estas 4 propuesta se quiere conseguir:

- Registro instantáneo de la toma: Tomada / Pospuesta / Omitida
- Generación de informe en PDF para la consulta médica

#### 2.2.2.4 Aportación documetal

**Literatura de lo investigado**
- Organización Mundial de la Salud: la OMS dicta que más del 50% de los pacientes con problemas de salud crónica no se toman la medicación como es debido y, del 75% los psiquiátricos, provocando así que los síntomas se agraven y tengan un coste más elevado para el paciente. La preocupación de los sanitarios no es solo esa, sino que a algunos pacientes, las medicinas le provocan daño evitando que se las tomen. Por esto último, la OMS ha determinado que la Medicación sin daño es el tema del tercer reto mundial por la seguridad del paciente. 


### 2.3. Estudio de soluciones existentes

#### 2.3.1. ¿En qué consiste?

El estudio de soluciones existentes consiste en un análisis comparativo de mercado (*benchmarking*) exhaustivo sobre las alternativas digitales disponibles para la gestión de tratamientos farmacológicos y citas de salud. Su propósito fundamental es identificar los vacíos funcionales, los problemas de usabilidad, las barreras de coste y las vulnerabilidades de privacidad presentes en las soluciones actuales, justificando de manera fundamentada la ventaja competitiva y el valor diferencial que aporta Tempomedic dentro del sector.

#### 2.3.2. Identificación de software competidor y contexto de mercado

Se ha realizado una búsqueda de las aplicaciones más representativas en las tiendas oficiales de software y plataformas de salud:

- **MedControl:** Funciona como un asistente de salud personal y pastillero virtual. Permite crear alarmas personalizadas para medicamentos, llevar un control de inventario y organizar recordatorios para citas médicas, diario de tensión arterial y seguimiento de síntomas.
- **Recordatorio de Medicamentos 2:** Centrada en la adherencia al tratamiento. Ofrece recordatorios altamente configurables (cada X horas, días específicos), alertas de stock escaso de pastillas, envío de reportes por correo al médico y agenda de recordatorios para citas.
- **CareClinic:** Plataforma integral de salud. Registra síntomas, mediciones, estado de ánimo y nutrición. Incluye recordatorios personalizables de medicación/citas y admite la gestión de múltiples perfiles (hijos, adultos mayores).
- **Biva:** Diseñada para pacientes y cuidadores. Registra condiciones médicas y tratamientos con recordatorios. Integra servicios de recarga de medicamentos y reserva de citas médicas.
- **DayMedy:** Aplicación de telemedicina con consultas en línea, gestión de prescripciones digitales y programación de citas. Tras la consulta, el usuario recibe la receta en la app y configura recordatorios de medicación.
- **Medical Reminder:** Enfocada en la simplicidad y la privacidad local sin conexión a internet. Ofrece recordatorios para medicamentos y citas con un diseño de texto grande para adultos mayores y generación de informes de salud en PDF.
- **Otras aplicaciones del sector:** Soluciones institucionales y corporativas como **IMQ** (aseguradora), **MyCarePlan**, **PineApp** y **MedGemak**, que ofrecen funcionalidades parciales o totales de gestión de citas, historial clínico y alarmas.

##### Noticias y tendencias recientes del sector

- **Éxito de las tarjetas sanitarias virtuales:** En la Comunidad de Madrid, la Tarjeta Sanitaria Virtual (TSV) ha registrado cerca de 57 millones de accesos en 2025 (+43,5%), consolidando servicios como recordatorios de citas de atención primaria (más de 5 millones de notificaciones) y alertas de dispensación en farmacias.
- **Integración de IA en portales de pacientes:** Oracle Health ha lanzado un portal con IA que ofrece resúmenes de salud y recordatorios automáticos en lenguaje sencillo para mejorar la adherencia.
- **Nuevos modelos de negocio:** Startups como **Assort Health** han captado inversión para unificar programación de citas, medicación y pagos con IA. **Amazon** ha desplegado un agente de IA para salud enfocado en citas y recetas.
- **Investigación universitaria:** Investigadores de la Universidad Miguel Hernández (UMH) de Elche han desarrollado software especializado para que pacientes con inmunodeficiencias autogestionen citas y tratamientos mediante recordatorios personalizados.

##### Aportaciones de la literatura científica

- **Diabetes Mellitus Tipo 2:** Metaanálisis de 2025 demuestran un efecto altamente positivo de las apps móviles en la adherencia a la medicación y el control glucémico.
- **Intervenciones mHealth en enfermedades crónicas:** Revisiones sistemáticas en el *Journal of Medical Systems* (2025) confirman que los recordatorios digitales incrementan significativamente el cumplimiento del tratamiento.
- **Enfermedad Renal Crónica y Oncología:** Estudios de 2025 ratifican que los sistemas de recordatorio reducen las omisiones involuntarias de dosis en tratamientos de alta complejidad.

#### 2.3.3. Análisis comparativo (Coste, usabilidad, plataforma y limitaciones)

1. **MedControl (Android):**
   - *Coste:* Gratuito con publicidad integrada (opción de pago para eliminar anuncios).
   - *Curva de aprendizaje y usabilidad:* Curva media-baja. Interfaz recargada de banners publicitarios que distraen a usuarios senior.
   - *Multiplataforma:* Exclusivo para Android.
   - *Limitaciones:* No diferencia técnicamente entre una notificación estándar y una alarma sonora continuada; el sistema en segundo plano falla con frecuencia por ahorro de batería.

2. **Recordatorio de Medicamentos 2 (iOS):**
   - *Coste:* Freemium con compras dentro de la app.
   - *Curva de aprendizaje y usabilidad:* Curva media. La configuración de pautas es completa pero compleja de navegar para personas con poca destreza digital.
   - *Multiplataforma:* Exclusivo para iOS.
   - *Limitaciones:* Exclusión del mercado de usuarios Android. Carece de opciones avanzadas de accesibilidad de texto.

3. **CareClinic (iOS / Android / Web):**
   - *Coste:* Modelo de suscripción mensual/anual de coste elevado.
   - *Curva de aprendizaje y usabilidad:* Curva alta. Múltiples menús y formularios complejos orientados a usuarios avanzados.
   - *Multiplataforma:* Excelente (iOS, Android y cliente Web).
   - *Limitaciones:* Requiere conexión obligatoria a la nube y registro de cuenta, comprometiendo la privacidad local de datos de salud.

4. **Biva (Android):**
   - *Coste:* Gratuito con servicios de farmacia adheridos.
   - *Curva de aprendizaje y usabilidad:* Curva media. Orientada a la relación paciente-cuidador.
   - *Multiplataforma:* Limitado a Android.
   - *Limitaciones:* Fuerte dependencia de conexión a servidores externos y falta de distinción en el tipo de aviso sonoro.

5. **DayMedy (iOS / Android):**
   - *Coste:* Modelo de negocio basado en cobro por teleconsulta.
   - *Curva de aprendizaje y usabilidad:* Curva alta. Centrada en videollamadas médicas más que en la gestión diaria del paciente.
   - *Multiplataforma:* iOS y Android.
   - *Limitaciones:* Inoperativa sin conexión a internet y sin adaptabilidad para usuarios con discapacidad visual.

6. **Medical Reminder (Android / iOS):**
   - *Coste:* Gratuito y sin anuncios.
   - *Curva de aprendizaje y usabilidad:* Curva muy baja. Diseño con fuentes grandes y pocos pasos.
   - *Multiplataforma:* Android e iOS.
   - *Limitaciones:* Herramienta excesivamente rígida; no unifica el calendario de citas médicas con la medicación en una única vista diaria.

#### 2.3.4. Aportación documental

##### 2.3.4.1. Matriz comparativa

| Característica | MedControl | Recordat. Med. 2 | CareClinic | Biva | DayMedy | Medical Reminder | **Tempomedic** |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Plataforma** | Android | iOS | iOS/Android | Android | iOS/Android | Android/iOS | **Android/Ordenador** |
| **Recordatorios de medicación** | 🟩 | 🟩 | 🟩 | 🟩 | 🟩 | 🟩 | **🟩** |
| **Recordatorios de citas médicas** | 🟩 | 🟩 | 🟩 | 🟩 | 🟩 | 🟩 | **🟩** |
| **Configuración de pauta (X horas / días)** | 🟩 | 🟩 | 🟩 | 🟩 | 🟨 | 🟩 | **🟩** |
| **Distinción notificación / alarma sonora** | 🟥 | 🟨 | 🟥 | 🟥 | 🟥 | 🟥 | **🟩** |
| **Registro de tomas (tomada/pospuesta/omitida)** | 🟨 | 🟩 | 🟩 | 🟩 | 🟨 | 🟨 | **🟩** |
| **Control de inventario de pastillas** | 🟩 | 🟩 | 🟥 | 🟨 | 🟥 | 🟥 | **🟥 (¿Futuro?)** |
| **Multiperfil (hijos, mayores)** | 🟥 | 🟥 | 🟩 | 🟩 | 🟩 | 🟥 | **🟥 (¿Futuro?)** |
| **Sincronización con calendario nativo** | 🟥 | 🟥 | 🟥 | 🟥 | 🟨 | 🟥 | **🟩** |
| **Funciona sin conexión (Offline)** | 🟨 | 🟨 | 🟥 | 🟥 | 🟥 | 🟩 | **🟩** |
| **Informes en PDF** | 🟥 | 🟩 (email) | 🟨 | 🟥 | 🟥 | 🟩 | **🟥** |
| **Telemedicina / consulta en línea** | 🟥 | 🟥 | 🟥 | 🟥 | 🟩 | 🟥 | **🟥** |
| **IA / asistente inteligente** | 🟥 | 🟥 | 🟥 | 🟥 | 🟥 | 🟥 | **🟥** |
| **Enfoque en accesibilidad (Texto grande)** | 🟥 | 🟥 | 🟥 | 🟥 | 🟥 | 🟩 | **🟩** |
| **Privacidad (Offline, sin nube, PIN)** | 🟨 | 🟨 | 🟥 | 🟥 | 🟥 | 🟩 | **🟩** |
| **Gratuita / sin registro obligatorio** | 🟨 | 🟨 | 🟨 | 🟨 | 🟨 | 🟩 | **🟩** |

(Leyenda: 🟩 Incluido | 🟨 Parcial o limitado | 🟥 No incluido)

##### 2.3.4.2. Justificación de la propuesta (Ventaja competitiva)

Tempomedic fundamenta su ventaja competitiva en dar respuesta directa a las carencias críticas detectadas tanto en las soluciones comerciales del mercado como en los resultados de nuestra encuesta realizada a 66 usuarios reales.
Mientras que las grandes plataformas (como CareClinic o DayMedy) imponen modelos de suscripción, registro obligatorio en la nube y pantallas saturadas de opciones complejas, Tempomedic prioriza la **simplicidad operativa, la accesibilidad universal y la privacidad absoluta de los datos de salud**.

Su propuesta de valor diferencial reside en tres pilares:

1. **Unificación en una sola vista ("Hoy"):** Integra en una única pantalla navegable las tomas de medicación y las citas médicas, cubriendo la necesidad expresada por el 59% de los encuestados.
2. **Sistema dual y preciso de avisos:** Es la única solución gratuita que permite al usuario diferenciar entre una notificación discreta (41% preferencia) y una alarma sonora continuada (20% preferencia) o ambas (39%), garantizando que las personas mayores o con deficiencias auditivas no omitan tomas.
3. **Privacidad y accesibilidad desde el diseño (*Privacy & Accessibility by Design*):** Funciona 100% offline sin necesidad de servidores externos ni registro obligatorio, protegiendo los datos con PIN local y ofreciendo una interfaz de alto contraste, tipografía escalable y botones táctiles adaptados al 70% de usuarios mayores de 46 años identificados en la investigación.

### 2.4. Partes interesadas

#### 2.4.1 ¿En qué consiste?

#### 2.4.2 ¿Qué deben de hacer y aportar?

##### 2.4.2.1 Identificación exhaustiva

##### 2.4.2.2 Análisis de poder e interés

##### 2.4.2.3 Aportación documental

##### 2.4.2.3.1 Matriz de Interesados (Poder vs. Interés)

### 2.5. Estudio de viabilidad técnica

#### 2.5.1 ¿En qué consiste?

#### 2.5.2 ¿Qué deben hacer y aportar?

##### 2.5.2.1 Pila tecnológica (Tech Stack)

##### 2.5.2.2 Requisitos de hardware y despliegue

##### 2.5.2.3 Curva de aprendizaje y madurez técnica

##### 2.5.2.4 Aportación documental

###### 2.5.2.4.1 Ficha técnica del stack de desarrollo y entorno de ejecución

###### 2.5.2.4.2 Conclusión explícita sobre la viabilidad técnica del desarrollo

### 2.6. Estudio de viabilidad económica

### 2.7. Estudio de viabilidad legal y normativa

#### 2.7.1. Protección de datos personales

#### 2.7.2. Propiedad intelectual y licencias

#### 2.7.3. Accesibilidad y otros requisitos aplicables

### 2.8. Análisis de riesgos inicial

## 3. PLANIFICACIÓN Y GESTIÓN DEL PROYECTO

### 3.1. Metodología de desarrollo empleada

### 3.2. Organización del equipo y reparto de responsabilidades

### 3.3. Roles del proyecto

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

## 6. DESARROLLO E IMPLEMENTACIÓN

### 6.1. Tecnologías, lenguajes y frameworks utilizados

### 6.6. Implementación de la interfaz de usuario

## REFERENCIAS
[1]: Organización Mundial de la Salud (OMS). Información sobre la Medicación Sin Daño. 2022

[2]: Encuesta propia de validación TempoMedic. 2026

[3]: Servicio de Información sobre Discapacidad. Porcentaje de pacientes que incumplen el tratamiento. 2019

