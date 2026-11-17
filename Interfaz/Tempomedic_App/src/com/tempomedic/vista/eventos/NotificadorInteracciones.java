package com.tempomedic.vista.eventos;

import javax.swing.event.EventListenerList;

/**
 * Gestiona el registro de observadores y el disparo de eventos de interacción
 *
 * @author Santiago González
 * @version 1.0
 */
public class NotificadorInteracciones {

    private final EventListenerList listeners = new EventListenerList();

    /**
     * Registra un observador
     *
     * @param l observador a registrar
     */
    public void addInteraccionListener(InteraccionListener l) {
        if (l != null) {
            listeners.add(InteraccionListener.class, l);
        }
    }

    /**
     * Elimina un observador registrado
     *
     * @param l observador a eliminar
     */
    public void removeInteraccionListener(InteraccionListener l) {
        listeners.remove(InteraccionListener.class, l);
    }

    /**
     * Notifica una interacción a todos los observadores registrados
     *
     * @param origen        objeto que genera el evento
     * @param tipo          tipo de interacción
     * @param nombreControl nombre del control afectado
     */
    public void notificar(Object origen, TipoInteraccion tipo, String nombreControl) {
        EventoInteraccion evt = new EventoInteraccion(origen, tipo, nombreControl);
        Object[] ls = listeners.getListenerList();
        for (int i = ls.length - 2; i >= 0; i -= 2) {
            if (ls[i] == InteraccionListener.class) {
                ((InteraccionListener) ls[i + 1]).interaccionDetectada(evt);
            }
        }
    }
}