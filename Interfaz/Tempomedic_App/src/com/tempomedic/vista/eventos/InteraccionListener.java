package com.tempomedic.vista.eventos;

import java.util.EventListener;

/**
 * Observador de interacciones del usuario con una vista
 *
 * @author Santiago González
 * @version 1.0
 */
public interface InteraccionListener extends EventListener {

    /**
     * Se invoca cuando una vista notifica una interacción
     *
     * @param evt descripción de la interacción.
     */
    void interaccionDetectada(EventoInteraccion evt);
}