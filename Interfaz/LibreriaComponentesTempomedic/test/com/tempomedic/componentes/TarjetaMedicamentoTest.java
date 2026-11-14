package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Suite de pruebas unitarias para validar el comportamiento del JavaBean TarjetaMedicamento.
 * <p>
 * Asegura que el componente se inicialice correctamente y que las propiedades 
 * enlazadas (bound properties) emitan los eventos correspondientes.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class TarjetaMedicamentoTest {

    private TarjetaMedicamento componente;

    /**
     * Inicializa una instancia limpia del componente antes de la ejecución de cada prueba.
     * Garantiza el aislamiento de los tests.
     */
    @Before
    public void setUp() {
        componente = new TarjetaMedicamento();
    }

    /**
     * Comprueba que el componente se instancie con los valores por defecto esperados.
     */
    @Test
    public void testValoresPorDefecto() {
        assertEquals("Nombre por defecto", componente.getNomMedicamento());
        assertEquals("Pauta por defecto", componente.getPauta());
        assertEquals("Próxima toma: --:--", componente.getProxToma());
    }

    /**
     * Verifica que al modificar el nombre del medicamento se dispare 
     * un PropertyChangeEvent con los valores correctos.
     */
    @Test
    public void testNotificacionEventoNombre() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);

        componente.addPropertyChangeListener(TarjetaMedicamento.PROP_NOMBRE, evt -> {
            assertEquals("Nombre por defecto", evt.getOldValue());
            assertEquals("Ibuprofeno 400mg", evt.getNewValue());
            eventoDisparado.set(true);
        });

        componente.setNomMedicamento("Ibuprofeno 400mg");

        assertTrue("El componente debió emitir un evento de cambio", eventoDisparado.get());
    }

    /**
     * Verifica que al modificar la pauta del medicamento se dispare 
     * un PropertyChangeEvent.
     */
    @Test
    public void testNotificacionEventoPauta() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);

        componente.addPropertyChangeListener(TarjetaMedicamento.PROP_PAUTA, evt -> {
            eventoDisparado.set(true);
        });

        componente.setPauta("Cada 8 horas");

        assertTrue("El componente debió emitir un evento al cambiar la pauta", eventoDisparado.get());
    }
}