## 1. Planificación General del Sprint 2

El Sprint 2 del proyecto TempoMedic abarca el ciclo completo de diseño UI/UX, maquetación de la interfaz de escritorio a resolución 1280x720 en Java Swing, evaluación de accesibilidad, pruebas de usabilidad con usuarios y documentación técnica.

Para cumplir con la planificación y el reparto de responsabilidades del equipo (Santiago González, Alba Durán, María Dolores Barba y Jorge Espejo), el trabajo se ha estructurado en 6 fases principales:

1. **Análisis:** procesamiento de encuestas de usuarios y estudio normativo de accesibilidad (WCAG 2.2 AA, ISO 9241 y Nielsen).
2. **Diseño e Implementación:** rediseño de wireframes/mockups para escritorio y maquetación visual de las 10 ventanas en NetBeans Matisse / Swing.
3. **Aspecto y Componentes:** estudio de Look & Feel, guías de estilo cromático/tipográfico e integración del tema FlatLaf.
4. **Pruebas y Auditoría:** auditoría técnica de accesibilidad, corrección de mensajes y ejecución de pruebas de usabilidad SUS.
5. **Validación y Estructura:** Definición de pautas estructurales, atajos de teclado y mapa de flujo de control interactivo.
6. **Ajustes y Cierre:** consolidación de evidencias, cronograma final de ejecución y redacción de la entrega.

## 2. Matriz de Fases, Tareas y Asignación de Responsables

| Fase | Nº Issue | Descripción de la Tarea | Responsables | Fechas | Estado |
| :--- | :---: | :--- | :--- | :---: | :---: |
| **1. Análisis** | [#131](https://github.com/SantiagoGonzalez12/Tempomedic/issues/131) / [#57](https://github.com/SantiagoGonzalez12/Tempomedic/issues/57) | Documentar estándares de usabilidad/accesibilidad y análisis de datos de encuesta ($N=66$). | María Dolores Barba | 14/10 - 28/10/2026 | **Completado** |
| **2. Diseño / Impl.** | [#140](https://github.com/SantiagoGonzalez12/Tempomedic/issues/140) / [#34](https://github.com/SantiagoGonzalez12/Tempomedic/issues/34)-[#40](https://github.com/SantiagoGonzalez12/Tempomedic/issues/40) | Maquetación en Swing (1280x720) de las 10 vistas: Login, Registro, PIN, Hoy, Meds, Citas, Ajustes y modales. | Santiago González, Alba Durán | 20/10 - 28/10/2026 | **Completado** |
| | [#59](https://github.com/SantiagoGonzalez12/Tempomedic/issues/59) / [#60](https://github.com/SantiagoGonzalez12/Tempomedic/issues/60) | Actualización de wireframes y mockups en `docs/diseno.md` (adaptación a escritorio). | Santiago González | 17/10 - 22/10/2026 | **Completado** |
| **3. Aspecto** | [#6](https://github.com/SantiagoGonzalez12/Tempomedic/issues/6) / [#61](https://github.com/SantiagoGonzalez12/Tempomedic/issues/61) | Estudio comparativo de Look & Feel (FlatLaf vs Nimbus) y Guía de estilo (contrastes, colores y fuentes). | Jorge Espejo, Alba Durán | 22/10 - 28/10/2026 | **Completado** |
| | [#64](https://github.com/SantiagoGonzalez12/Tempomedic/issues/64) / [#73](https://github.com/SantiagoGonzalez12/Tempomedic/issues/73) | Integración de FlatLaf, desarrollo del componente `TarjetaToma` y documentación técnica. | Jorge Espejo, Alba Durán, Santiago González | 25/10 - 28/10/2026 | **Completado** |
| **4. Pruebas** | [#58](https://github.com/SantiagoGonzalez12/Tempomedic/issues/58) / [#41](https://github.com/SantiagoGonzalez12/Tempomedic/issues/41) | Medidas de auditoría, informe de contrastes e incidente `AUD-01` (paleta FlatLaf en Matisse). | María Dolores Barba | 22/10 - 26/10/2026 | **Completado** |
| | [#71](https://github.com/SantiagoGonzalez12/Tempomedic/issues/71) / [#72](https://github.com/SantiagoGonzalez12/Tempomedic/issues/72) | Revisión de mensajes/errores y pruebas de usabilidad con 3 usuarios calculando el score SUS (86.6/100). | María Dolores Barba | 25/10 - 28/10/2026 | **Completado** |
| **5. Validación** | [#132](https://github.com/SantiagoGonzalez12/Tempomedic/issues/132) / [#74](https://github.com/SantiagoGonzalez12/Tempomedic/issues/74) / [#67](https://github.com/SantiagoGonzalez12/Tempomedic/issues/67) | Documentar pautas estructurales, atajos de teclado (`Ctrl+1..4`), mnemónicos y orden de tabulación. | Jorge Espejo | 24/10 - 28/10/2026 | **Completado** |
| | [#133](https://github.com/SantiagoGonzalez12/Tempomedic/issues/133) / [#62](https://github.com/SantiagoGonzalez12/Tempomedic/issues/62) | Diagrama del mapa de navegación y flujo de control en Mermaid en `docs/estructura-y-flujo.md`. | María Dolores Barba | 26/10 - 28/10/2026 | **Completado** |
| **6. Ajustes / Cierre**| [#55](https://github.com/SantiagoGonzalez12/Tempomedic/issues/55) / [#56](https://github.com/SantiagoGonzalez12/Tempomedic/issues/56) | Elaboración del cronograma de ejecución (Gantt en Mermaid) y publicación del informe final. | Santiago G., Jorge E., Alba D., María Dolores B. | 28/10 - 29/10/2026 | **Completado** |
| | [#134](https://github.com/SantiagoGonzalez12/Tempomedic/issues/134) / [#75](https://github.com/SantiagoGonzalez12/Tempomedic/issues/75) / [#76](https://github.com/SantiagoGonzalez12/Tempomedic/issues/76) | Redacción de entregables, actualización de `README.md` y preparación de la presentación final. | Santiago G., Jorge E., Alba D., María Dolores B. | 28/10 - 29/10/2026 | **Completado** |

# Cronograma Diagrama de Gantt 

![Diagrama de Gantt Sprint 2](img/Diagrama%20de%20Gantt%20Sprint%202.png)
