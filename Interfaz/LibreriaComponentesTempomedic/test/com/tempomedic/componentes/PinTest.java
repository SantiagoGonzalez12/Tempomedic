package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para el componente Pin.
 * 
 * @author Alba Durán Bernal
 * @version 1.0
 */
public class PinTest {

    private Pin componente;

    @Before
    public void setUp() {
        componente = new Pin();
    }

    @Test
    public void testValorPorDefecto() {
        assertEquals("", componente.getPin());
    }

    @Test
    public void testNotificacionEventoPin() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(Pin.PROP_PIN, evt -> eventoDisparado.set(true));
        
        componente.setPin("1234");
        
        assertTrue("Debe emitir evento al cambiar el PIN", eventoDisparado.get());
        assertEquals("1234", componente.getPin());
    }
}