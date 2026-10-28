# 1. Usabilidad y accesibilidad

En primer lugar, debemos identificar las pautas de usabilidad que se van a aplicar en TempoMedic:

### WCAG 2.2 AA
Las Pautas de Accesibilidad para el Contenido Web es la accesibilidad global y guía de creación de sitios web, app y documentos inclusivos. A nivel mundial, hay varias normativas que exigen este cumplimiento. Las WCAG 2.2 es obligatoria para las organizaciones del sector público según el Reglamento de Accesibilidad de los Organismos del Sector Público (Sitios Web y Aplicaciones Móviles) (n.º 2) de 2018.

Los principios POUR de WCAG son:

- **Perceptible:** la información y los componentes de la interfaz de usuario deben presentarse de forma que los usuarios puedan comprenderlos.
  
- **Operable:** los componentes de la interfaz de usuario y la navegación deben ser funcionales y fáciles de usar para los usuarios
  
- **Comprensible:** la información y el funcionamiento de la interfaz de usuario deben ser comprensibles.
  
- **Robusto:** el contenido debe ser lo suficientemente sólido como para que una amplia variedad de usuarios y tecnologías de asistencia puedan interpretarlo de forma fiable.

### Heurística de Nielsen
Se denominan heurísticos porque son reglas generales de usabilidad específica:

**1. Visibilidad del estado del sistema** --> mantener informado a los usuarios
**2. Relación entre el sistema y el mundo real** --> el sistema debe hablar el idioma de los usuarios.
**3. Libertad y control por parte del usuario** --> apoyar funciones de deshacer y rehacer
**4. Consistencia y estándares** --> seguir las convenciones establecidas
**5. Prevención de errores** --> diseño que prevenga la ocurrencia de problemas
**6. Reconocimiento antes que recuerdo** --> las instrucciones deben de estar en la vista o ser fácilmente recuperable cuando sea necesario.
**7. Flexibilidad y eficiencia de uso** --> los usuarios puedan adaptar el sistema a sus usos frecuentes.
**8. Estética y diseño minimalista** --> los diálogos no deben contener información irrelevante o poco usada.
**9. Ayudar a los usuarios a reconocer** --> los mensajes de error se deben entregar en un lenguaje claro y simple para poder ayudar a los usuarios.
**10. Ayuda y documentación** --> cuando sea necesario, ofrecer ayuda y documentación. 


### ISO 9241

Es una norma internacional de varias partes desarrollada por la Organización Internacional de Normalización (ISO), se centra en la interacción de la persona con el ordenador (HCI). Se centra en 3 objetivos:

**- Eficacia:** beneficiar a los usuarios ayudándolos a completar las tareas con éxito.

**- Eficiencia:** promover que dichas tareas se puedan hacer con poco esfuerzo y ahorrando tiempo.

**- Satisfacción:** valorar la experiencia que han tenido los usuarios.


### Aplicación en TempoMedic tras los resultados de la encuesta

En TempoMedic, la adopción rigurosa de estándares responde directamente a las necesidades cuantitativas identificadas en la encuesta inicial realizada a los usuarios ($N = 66$):
* **Distribución demográfica (63.6% con 46 años o más):** la gran mayoría del público objetivo presenta necesidades vinculadas al envejecimiento visual (presbicia, pérdida de agudeza visual y menor sensibilidad al contraste), lo que exige tipografías escalables y ratios de contraste reforzados.
* **Comprensión de simbología e iconos (27.3% indica dificultades para distinguir símbolos):** cerca de un tercio de los usuarios no interpreta con claridad la simbología médica aislada, haciendo imprescindible la asistencia de etiquetas explícitas (Lectura Fácil) y diseño multimodal.
* **Preferencia de alertas (45.5% prefiere combinación de sonido y notificación):** requiere un sistema flexible de avisos que reduzca los descuidos por olvidos de medicación.


## Marco Normativo y Estándares Aplicados

1. **WCAG 2.2 (Nivel AA):** pautas internacionales de accesibilidad web y software para asegurar contenido perceptible, operable, comprensible y robusto.
2. **Heurísticas de Nielsen:** principios fundamentales de usabilidad para el diseño de interacción, prevención de errores y reducción de carga cognitiva.
3. **ISO 9241 (Ergonomía de la interacción persona-sistema):** estándar orientado a maximizar la eficacia, eficiencia y satisfacción del usuario.
4. **Principios de Lectura Fácil:** adaptación lingüística para evitar tecnicismos médicos o terminología clínica compleja en la interfaz.
5. **Java Swing `AccessibleContext`:** API de Java para exponer la jerarquía de la interfaz gráfica a tecnologías asistivas.


## Matriz de Aplicación: Pauta vs. Aplicación en TempoMedic

| Estándar / Pauta | Requisito Principal | Relación con Datos Reales de la Encuesta ($N=66$) | Cómo se aplica en TempoMedic |
| :--- | :--- | :--- | :--- |
| **WCAG 2.2 (Criterio 1.4.3)** | Contraste mínimo de 4.5:1 para texto normal y 3:1 para texto grande. | **63.6% de usuarios $\ge$46 años:** Requieren un elevado contraste cromático para prevenir la fatiga y deficiencias visuales. | Paleta de colores seleccionada con un ratio de contraste superior a **7:1** en textos principales, fondos y botones de acción primarios. |
| **WCAG 2.2 (Criterio 1.4.1)** | No depender únicamente del color para transmitir información o estado. | **27.3% no distingue claramente símbolos:** La simbología o el color aislado generan confusión al marcar estados de salud. | Acompañamiento explícito del estado mediante texto e icono reforzado (ej. "Tomada" con un `check` verde o "Pendiente" con texto e icono explicativo). |
| **ISO 9241-11** | Garantizar usabilidad mediante objetivos claros de eficacia, eficiencia y satisfacción. | **Queja recurrente sobre complejidad y olvidos:** El 63.6 % necesita flujos directos para evitar perderse en la app. | Reducción de la navegación a un máximo de 2 clics para marcar tomas de medicamentos o consultar la agenda médica diaria. |
| **Heurísticas de Nielsen (#2)** | Relación entre el sistema y el mundo real (uso de lenguaje claro y cotidiano). | **27.3% de dificultad en símbolos/términos:** Los nombres técnicos aumentan el abandono de la app. | Sustitución de términos complejos ("Posología", "Frecuencia circadiana") por expresiones sencillas ("Instrucciones de toma", "¿Cada cuántas horas?"). |
| **Lectura Fácil** | Estructura de frases cortas, voz activa y vocabulario común. | **Problemas declarados de memoria y confusión:** Necesidad de claridad inmediata sin ambigüedades. | Redacción de avisos y diálogos en voz activa ("¿Confirmas que has tomado Ibuprofeno 400 mg?"). |
| **Java Swing (`AccessibleContext`)** | Exposición de nombres, roles y descripciones a lectores de pantalla. | **Inclusión accesible universal:** Cobertura para personas con limitaciones visuales severas. | Implementación explícita de `getAccessibleContext().setAccessibleName()` y `setAccessibleDescription()` en botones (`JButton`) y formularios (`JTextField`). |


## 4. Conclusión

El cumplimiento de estas pautas asegura que TempoMedic no solo se adhiera a las normativas técnicas internacionales, sino que responda de forma personalizada a las necesidades de sus 66 usuarios encuestados, erradicando barreras visuales y cognitivas.


## Referencias

[1] *Comprender las WCAG*, Level Access: consultado el 28 de octubre de 2026.[En línea]: <https://www.levelaccess.com/understanding-wcag-emea/?utm_campaign=G_S_WCAG_EMEA&utm_content=NB_WCAG_2.2_EM&adset_id=174080907272&utm_ad=729150304455&ad_id=729150304455&utm_id=22123641981&campaign_id=22123641981&keyword_id=kwd-887427626521&matchtype=e&device=c&GeoLoc=9198266&IntLoc=&placement=&network=g&utm_source=google&utm_medium=cpc&utm_term=wcag%202.2&utm_campaign=FY26-PM-COMPL_22123641981&hsa_cam=22123641981&hsa_grp=174080907272&hsa_ad=729150304455&hsa_src=g&hsa_tgt=kwd-887427626521&hsa_kw=wcag%202.2&hsa_mt=e&hsa_net=adwords&hsa_ver=3&hsa_acc=4319570901&hstk_creative=729150304455&hstk_campaign=22123641981&hstk_network=googleAds&gad_source=1&gad_campaignid=22123641981&gbraid=0AAAAADQ__byaq2fZ5nMB4MKACNfhaHPsz&gclid=CjwKCAjwuobXBhBXEiwAYUaIlYziRNzNQHBYkueAR0NzjYhWZJwILNAVLWYtD1ay8QDbgLrip8AIeBoCqCEQAvD_BwE>

[2] *Los 10 principiios heurísticos de Jakob Nielsen*, Medium: consultado el 28 de octubre de 2026.[En línea]: <https://medium.com/pildorasux/10-heuristicos-nielsen-abc9c6ad04c0>


[3] *¿Qué es la norma ISO 9241? Una guía completa sobre HCI y estándares de usabilidad*, Alekvs: consultado el 28 de octubre de 2026.[En línea]: <https://www.alekvs.com/es/what-is-iso-9241-a-complete-guide-to-hci-and-usability-standards/>
