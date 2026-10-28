# Tempomedic

<img src="Proyecto/docs/img/logo/Logo_Tempomedic.svg" alt="Logo" width="100%" height="100">

> Recordatorio de medicamentos y gestión de citas médicas: registra tus tratamientos, avisa por notificación o alarma a la hora de cada toma y te ayuda a organizar tus citas médicas.

Proyecto Intermodular | Grado Superior de Desarrollo de Aplicaciones Multiplataforma (DAM) | FP Campus Camara

![Estado](https://img.shields.io/badge/Estado-En%20desarrollo-yellow)
![Sprint](https://img.shields.io/badge/Sprint-1%3A%20Ideación%20y%20Prototipado-blue)

## Índice

- [El problema](#el-problema)
- [Qué hace la app](#qué-hace-la-app)
- [Estado del proyecto](#estado-del-proyecto)
- [Equipo](#equipo)
- [Tecnología](#tecnología)
- [Estructura del repositorio](#estructura-del-repositorio)
- [Documentación](#documentación)
- [Licencia](#licencia)

## El problema

Olvidar una toma de medicación o perder de vista una cita médica es fácil cuando se combinan varios tratamientos, horarios distintos y poco tiempo. Tempomedic centraliza medicación y citas en un solo sitio, con avisos que el usuario elige cómo quiere recibir: una notificación discreta o una alarma con sonido.

Este proyecto está validando el problema y el público objetivo con una encuesta propia: <https://forms.gle/7wxaZCByMmXmqsCx9>.

## Qué hace la app

**En el alcance de este sprint (Sprint 1: Ideación y Prototipado Base):**

- Prototipo de las vistas principales (inicio de sesión, hoy, medicamentos, citas, ajustes) construido con NetBeans Matisse.
- Arquitectura MVC con un componente visual propio y reutilizable (`TarjetaToma`).

**Alcance previsto del producto (MVP, próximos sprints):**

- Registro e inicio de sesión con consentimiento explícito (los datos de medicación son datos de salud).
- Alta, edición y eliminación de medicamentos con su pauta de tomas.
- Recordatorios configurables por medicamento: notificación o alarma.
- Registro de cada toma (tomada, pospuesta, omitida) e historial.
- Petición, consulta y cancelación de citas médicas.

**Fuera de alcance** (por ser un proyecto académico): conexión con sistemas sanitarios reales, receta electrónica, cualquier función de diagnóstico. No sustituye el criterio de un profesional sanitario.

## Estado del proyecto

| | |
| --- | --- |
| Sprint actual | Sprint 1: Ideación y Prototipado Base (24/09 → 02/10/2026) |
| Tablero | <https://github.com/users/SantiagoGonzalez12/projects/6> |
| Memoria | [`docs/memoria.md`](docs/memoria.md) |
| Metodología | Scrum, sprints de 2 semanas |

## Equipo

| Nombre | Rol en el equipo |
| --- | --- |
| María Dolores | Scrum Master / Lead Developer <br> QA Tester & Release Manager |
| Alba Durán | Scrum Master / Lead Developer <br> QA Tester & Release Manager |
| Santiago González | Especialista UI/UX (Frontend) |
| Jorge Espejo | Desarrollador de Lógica y Datos (Backend) |

Tutor del módulo: Willman Acosta Lugo.

## Tecnología

| | |
| --- | --- |
| Lenguaje | Java |
| Interfaz gráfica | Swing, diseñada con el editor visual NetBeans Matisse |
| Arquitectura | MVC (Modelo–Vista–Controlador) |
| Gestión de dependencias | Maven |
| Persistencia | En memoria en el Sprint 1 |
| Control de versiones | Git / GitHub, con Issues y Projects para el seguimiento Scrum |

## Estructura del repositorio

```
Tempomedic/
├─ docs/
│  ├─ diagramas/        Arquitectura, modelo de datos, navegación
│  ├─ img/              Capturas y bocetos
│  ├─ requisitos/       Público objetivo, benchmarking, requisitos
│  ├─ sprints/          Planning, Review y Retrospective de cada sprint
│  └─ memoria.md        Memoria del proyecto 
└─ src/
   ├─ main/
   └─ test/
```

## Documentación

- Memoria completa del proyecto: [`docs/memoria.md`](docs/memoria.md)
- Encuesta al público objetivo: [`docs/requisitos/ResultadosEncuesta.xml`](docs/requisitos/ResultadosEncuesta.xml)
- Aplicaciones similares, noticias, estudios y resumen de la encuesta: [`docs/requisitos/recopilaInfo.md`](docs/requisitos/recopilaInfo.md)

### Encuesta
#### Formatos incluidos

| Archivo | Formato | Explicación |
|---------|---------|-----------------|
| `respuestas.csv` | CSV | Datos crudos, fáciles de abrir en Excel/LibreOffice/Hoja de calculo. |
| `respuestas.xml` | XML | Representación semántica, consumible por máquinas. |
| `respuestas.xsd` | XSD | Contrato que valida y documenta la estructura del XML. |

Los tres archivos contienen **la misma información**; solo cambia la representación.

#### Normalización aplicada

Para garantizar la sostenibilidad y validación del XML, se han normalizado los campos de opción múltiple:

- **Rangos de edad**: `menos_18`, `18_30`, `31_45`, `46_60`, `61_75`, `mas_75`
- **Sí/No**: `si`, `no` (en minúscula, sin tildes)
- **Marca temporal**: ISO 8601 (`AAAA-MM-DDThh:mm:ss`)
- **Campos de texto libre**: se mantienen pero en snake_case, sin tildes ni espacios.

#### Validación

El XML se puede validar con el XSD con cualquier herramienta, ejemplo: VSCode con extensión XML.

#### Privacidad
Las respuestas son anónimas.

## Licencia

Proyecto académico desarrollado como Proyecto Intermodular del ciclo de Grado Superior DAM.
