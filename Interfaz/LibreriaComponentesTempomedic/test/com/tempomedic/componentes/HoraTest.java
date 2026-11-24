package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para el componente Hora.
 * 
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class HoraTest {

    private Hora componente;

    @Before
    public void setUp() {
        componente = new Hora();
    }

    @Test
    public void testValorPorDefecto() {
        assertEquals("", componente.getHora());
    }

    @Test
    public void testNotificacionEventoHora() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(Hora.PROP_HORA, evt -> eventoDisparado.set(true));
        
        componente.setHora("12:30");
        
        assertTrue("Debe emitir evento al cambiar la hora", eventoDisparado.get());
        assertEquals("12:30", componente.getHora());
    }
    @Test
    public void testValoresFueraDeRango() {
        componente.setHora(null);
        assertEquals("", componente.getHora());
    }

    @Test
    public void testSimulacionInteraccion() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(Hora.PROP_HORA, evt -> eventoDisparado.set(true));

        componente.dispatchEvent(new java.awt.event.FocusEvent(componente, java.awt.event.FocusEvent.FOCUS_GAINED));
        componente.setText("18:45");
        componente.dispatchEvent(new java.awt.event.FocusEvent(componente, java.awt.event.FocusEvent.FOCUS_LOST));

        assertTrue("Debe emitir evento tras la interacción", eventoDisparado.get());
        assertEquals("18:45", componente.getHora());
    }
}