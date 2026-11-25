package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para validar el comportamiento del JavaBean Medicamento.
 * <p>
 * Asegura que el componente se inicialice correctamente, que las propiedades 
 * emitan los eventos correspondientes y que la lógica del semáforo funcione.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class MedicamentoTest {

    /** Instancia del componente a probar. */
    private Medicamento componente;

    /**
     * Inicializa una instancia limpia del componente antes de la ejecución de cada prueba.
     * Garantiza el aislamiento de los tests.
     */
    @Before
    public void setUp() {
        componente = new Medicamento();
    }

    /**
     * Comprueba que el componente se instancie con los valores por defecto esperados.
     */
    @Test
    public void testValoresPorDefecto() {
        assertEquals("Nombre", componente.getNombreMedicamento());
        assertEquals("0 mg", componente.getDosis());
        assertEquals("00:00", componente.getHora());
        assertEquals("", componente.getFrecuencia());
        assertEquals(Medicamento.ESTADO_PENDIENTE, componente.getEstado());
    }

    /**
     * Verifica que al modificar los datos del medicamento (nombre) se dispare 
     * un PropertyChangeEvent con los valores correctos.
     */
    @Test
    public void testNotificacionEventoDatos() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);

        componente.addPropertyChangeListener(Medicamento.PROP_DATOS, evt -> {
            assertEquals("Nombre", evt.getOldValue());
            assertEquals("Ibuprofeno", evt.getNewValue());
            eventoDisparado.set(true);
        });

        componente.setNombreMedicamento("Ibuprofeno");

        assertTrue("El componente debió emitir un evento de cambio de datos", eventoDisparado.get());
        assertEquals("Ibuprofeno", componente.getNombreMedicamento());
    }

    /**
     * Verifica que al modificar el estado del medicamento se dispare 
     * un PropertyChangeEvent.
     */
    @Test
    public void testNotificacionEventoEstado() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);

        componente.addPropertyChangeListener(Medicamento.PROP_ESTADO, evt -> {
            assertEquals(Medicamento.ESTADO_PENDIENTE, evt.getOldValue());
            assertEquals(Medicamento.ESTADO_TOMADA, evt.getNewValue());
            eventoDisparado.set(true);
        });

        componente.setEstado(Medicamento.ESTADO_TOMADA);

        assertTrue("El componente debió emitir un evento al cambiar el estado", eventoDisparado.get());
        assertEquals(Medicamento.ESTADO_TOMADA, componente.getEstado());
    }

    /**
     * Verifica la lógica del semáforo: asegura que los estados se asignan correctamente.
     */
    @Test
    public void testLogicaSemaforo() {
        assertEquals(Medicamento.ESTADO_PENDIENTE, componente.getEstado());

        componente.setEstado(Medicamento.ESTADO_TOMADA);
        assertEquals(Medicamento.ESTADO_TOMADA, componente.getEstado());

        componente.setEstado(Medicamento.ESTADO_POSPUESTA);
        assertEquals(Medicamento.ESTADO_POSPUESTA, componente.getEstado());

        componente.setEstado(Medicamento.ESTADO_OMITIDA);
        assertEquals(Medicamento.ESTADO_OMITIDA, componente.getEstado());
    }
}