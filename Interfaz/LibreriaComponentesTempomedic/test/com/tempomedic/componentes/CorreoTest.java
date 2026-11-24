package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para el componente Correo.
 * 
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class CorreoTest {

    private Correo componente;

    @Before
    public void setUp() {
        componente = new Correo();
    }

    @Test
    public void testValorPorDefecto() {
        assertEquals("", componente.getCorreo());
    }

    @Test
    public void testNotificacionEventoCorreo() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(Correo.PROP_CORREO, evt -> eventoDisparado.set(true));
        
        componente.setCorreo("test@correo.com");
        
        assertTrue("Debe emitir evento al cambiar el correo", eventoDisparado.get());
        assertEquals("test@correo.com", componente.getCorreo());
    }
    @Test
    public void testValoresFueraDeRango() {
        componente.setCorreo(null);
        assertEquals("", componente.getCorreo());
    }

    @Test
    public void testSimulacionInteraccion() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(Correo.PROP_CORREO, evt -> eventoDisparado.set(true));

        componente.dispatchEvent(new java.awt.event.FocusEvent(componente, java.awt.event.FocusEvent.FOCUS_GAINED));
        componente.setText("usuario@valido.com");
        componente.dispatchEvent(new java.awt.event.FocusEvent(componente, java.awt.event.FocusEvent.FOCUS_LOST));

        assertTrue("Debe emitir evento tras la interacción", eventoDisparado.get());
        assertEquals("usuario@valido.com", componente.getCorreo());
    }
}