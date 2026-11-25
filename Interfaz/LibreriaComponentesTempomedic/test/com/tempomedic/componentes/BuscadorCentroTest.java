package com.tempomedic.componentes;


import java.util.concurrent.atomic.AtomicBoolean;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
    @Test
    public void testValoresFueraDeRango() {
        componente.setCentroSeleccionado(null);
        assertNull(componente.getCentroSeleccionado());
    }

    @Test
    public void testSimulacionInteraccion() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(BuscadorCentro.PROP_CENTRO_SELECCIONADO, evt -> eventoDisparado.set(true));

        javax.swing.JTextField campoBusqueda = (javax.swing.JTextField) componente.getComponent(0);
        campoBusqueda.setText("Macarena");

        assertTrue("Debe emitir evento al filtrar y autoseleccionar", eventoDisparado.get());
        assertEquals("Hospital Virgen Macarena", componente.getCentroSeleccionado());
    }
}