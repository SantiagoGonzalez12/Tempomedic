# Especificación y API pública de TarjetaToma

PI · Sprint 3 · [PI 3.1](https://github.com/SantiagoGonzalez12/Tempomedic/issues/176)

## 1. Propósito

Componente visual que representa una toma de medicación en la vista `Hoy` y permite marcarla como tomada, pospuesta u omitida.

No accede a repositorio ni base de datos: muestra datos, captura la interacción y notifica al exterior. El controlador persiste.

## 2. Anatomía

- Título: `<medicamento> <dosis> - <hora>` (ej. Paracetamol 650 mg - 14:00)
- Estado: texto con color representativo
- Tres botones: Tomada · Posponer · Omitida

## 3. Estados (enum EstadoToma)

| Estado | Texto | Color texto | Ratio sobre `#BAD1D9` |
| --- | --- | --- | --- |
| PENDIENTE | Pendiente | `#8F3E00` | 4,9:1 |
| TOMADA | Tomada | `#16642A` | 5,2:1 |
| POSPUESTA | Pospuesta | `#5B2C83` | 6,2:1 |
| OMITIDA | Omitida | `#A80004` | 5,0:1 |

Cálculo verificado con [WebAIM](https://webaim.org/resources/contrastchecker/).

## 4. Declaración de clase

`TarjetaToma extends JPanel implements Serializable`

Paquete: [COMPLETAR]

## 5. Constructores

| Firma | Nota |
| --- | --- |
| `public TarjetaToma()` | Obligatorio JavaBean. Estado inicial PENDIENTE |
| `public TarjetaToma(String medicamento, String hora, EstadoToma estado)` | Opcional, para uso desde código |

## 6. Propiedades

| Propiedad | Tipo | Por defecto | Getter / Setter | Bound |
| --- | --- | --- | --- | --- |
| medicamento | String | "Medicamento" | getMedicamento / setMedicamento | Sí |
| dosis | String | "" | getDosis / setDosis | Sí |
| hora | String ("HH:mm") | "00:00" | getHora / setHora | Sí |
| estado | EstadoToma | PENDIENTE | getEstado / setEstado | Sí |
| tamanoTexto | TamanoTexto (NORMAL, GRANDE, MUY_GRANDE) | NORMAL | getTamanoTexto / setTamanoTexto | Sí |
| textoEstado | String | derivado de estado | getTextoEstado (solo lectura) | No |

Decisión: `hora` es String porque el panel Properties de Matisse no ofrece editor para LocalTime. Validación de formato en el setter.

## 7. Eventos

- `addActionListener` / `removeActionListener`: se dispara al pulsar un botón.
- `addPropertyChangeListener` / `removePropertyChangeListener`
  (PropertyChangeSupport): notifica cambios de propiedades.

| Botón | Estado resultante | actionCommand |
| --- | --- | --- |
| Tomada | TOMADA | "TOMADA" |
| Posponer | POSPUESTA | "POSPONER" |
| Omitida | OMITIDA | "OMITIDA" |

Flujo al pulsar: la tarjeta ejecuta `setEstado(...)` -> se dispara el `PropertyChangeEvent` de "estado" -> se dispara el `ActionEvent`.

Tras pulsar, los botones siguen activos según cuál pulses:
Si pulsas `Tomada` los botones desaparecen, en los otros casos no.

## 8. Accesibilidad

- Objetivo WCAG 2.2 AA y UNE-EN 301 549.
- Estado siempre con texto. Contraste ≥ 4,5:1 en texto; borde de botones ≥ 3:1.
- Navegación por teclado (Tab, Enter, Espacio, Esc) con foco visible.
- AccessibleContext: `Paracetamol 650 mg, 14:00, Pendiente`.
- Botones de altura amplia; texto escalable (Normal, Grande, Muy grande).

## 9. Cumplimiento JavaBean

- [ ] Constructor público sin argumentos
- [ ] Serializable
- [ ] Getters/setters con convención get/set/is
- [ ] Propiedades bound con PropertyChangeSupport

## 10. Aprobación

Product Owner: Santiago González - 20/11/2026
