package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para el componente BuscadorCentro.
 * 
 * @author Alba Durán Bernal
 * @version 1.0
 */
public class BuscadorCentroTest {

    private BuscadorCentro componente;

    @Before
    public void setUp() {
        componente = new BuscadorCentro();
    }

    @Test
    public void testValorPorDefecto() {
        assertEquals("", componente.getCentroSeleccionado());
    }

    @Test
    public void testNotificacionEventoCentro() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(BuscadorCentro.PROP_CENTRO_SELECCIONADO, evt -> eventoDisparado.set(true));
        
        componente.setCentroSeleccionado("Hospital Militar");
        
        assertTrue("Debe emitir evento al cambiar el centro", eventoDisparado.get());
        assertEquals("Hospital Militar", componente.getCentroSeleccionado());
    }
}