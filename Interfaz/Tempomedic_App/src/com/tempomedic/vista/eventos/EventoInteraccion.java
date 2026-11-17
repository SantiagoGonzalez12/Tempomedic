package com.tempomedic.vista.eventos;

import java.util.EventObject;

/**
 * Evento personalizado que describe una interacción del usuario con un
 * control de la interfaz
 *
 * @author Santiago González
 * @version 1.0
 */
public class EventoInteraccion extends EventObject {

    private final TipoInteraccion tipo;
    private final String nombreControl;

    /**
     * Crea un evento de interacción.
     *
     * @param origen        vista que genera el evento
     * @param tipo          tipo de interacción detectada
     * @param nombreControl nombre del control afectado
     */
    public EventoInteraccion(Object origen, TipoInteraccion tipo, String nombreControl) {
        super(origen);
        this.tipo = tipo;
        this.nombreControl = nombreControl;
    }

    // @return tipo de interacción detectada
    public TipoInteraccion getTipo() {
        return tipo;
    }

    // @return nombre del control sobre el que ocurrió la interacción
    public String getNombreControl() {
        return nombreControl;
    }
}