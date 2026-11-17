package com.tempomedic.vista.eventos;

/**
 * Tipos de interacción de bajo nivel que una vista puede notificar
 *
 * @author Santiago González
 * @version 1.0
 */
public enum TipoInteraccion {
    // El puntero entra en el control
    RATON_ENTRA,
    // El puntero sale del control
    RATON_SALE,
    // Se pulsa un botón del ratón sobre el control
    RATON_PULSADO,
    // Se suelta un botón del ratón sobre el control
    RATON_SOLTADO,
    // Clic completo sobre el control
    RATON_CLIC,
    // El control recibe el foco
    FOCO_GANADO,
    // El control pierde el foco
    FOCO_PERDIDO,
    // Se pulsa una tecla con el control enfocado
    TECLA_PULSADA
}