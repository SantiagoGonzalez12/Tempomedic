package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para el componente Fecha.
 * 
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class FechaTest {

    private Fecha componente;

    @Before
    public void setUp() {
        componente = new Fecha();
    }

    @Test
    public void testValorPorDefecto() {
        assertEquals("", componente.getFecha());
    }

    @Test
    public void testNotificacionEventoFecha() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(Fecha.PROP_FECHA, evt -> eventoDisparado.set(true));
        
        componente.setFecha("15/10/2024");
        
        assertTrue("Debe emitir evento al cambiar la fecha", eventoDisparado.get());
        assertEquals("15/10/2024", componente.getFecha());
    }
    @Test
    public void testValoresFueraDeRango() {
        componente.setFecha(null);
        assertEquals("", componente.getFecha());
    }

    @Test
    public void testSimulacionInteraccion() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(Fecha.PROP_FECHA, evt -> eventoDisparado.set(true));

        componente.dispatchEvent(new java.awt.event.FocusEvent(componente, java.awt.event.FocusEvent.FOCUS_GAINED));
        componente.setText("25/11/2026");
        componente.dispatchEvent(new java.awt.event.FocusEvent(componente, java.awt.event.FocusEvent.FOCUS_LOST));

        assertTrue("Debe emitir evento tras la interacción", eventoDisparado.get());
        assertEquals("25/11/2026", componente.getFecha());
    }
}