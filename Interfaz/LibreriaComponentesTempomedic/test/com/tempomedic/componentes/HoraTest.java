package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para el componente Hora.
 * 
 * @author Alba Durán Bernal
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
}