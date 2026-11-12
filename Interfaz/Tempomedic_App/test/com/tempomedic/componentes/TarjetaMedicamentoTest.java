package com.tempomedic.componentes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 
 * @author Jorge Espejo Martínez
 */
class TarjetaMedicamentoTest {

    private TarjetaMedicamento componente;

    @BeforeEach
    void setUp() {
        componente = new TarjetaMedicamento();
    }

    @Test
    @DisplayName("Debe inicializar con los valores por defecto")
    void testValoresPorDefecto() {
        assertEquals("Nombre por defecto", componente.getNomMedicamento());
        assertEquals("Pauta por defecto", componente.getPauta());
        assertEquals("Próxima toma: --:--", componente.getProxToma());
    }

    @Test
    @DisplayName("Debe notificar el cambio mediante PropertyChangeEvent")
    void testNotificacionEventoPropiedad() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        
        componente.addPropertyChangeListener(TarjetaMedicamento.PROP_NOMBRE, evt -> {
            assertEquals("Nombre por defecto", evt.getOldValue());
            assertEquals("Ibuprofeno 400mg", evt.getNewValue());
            eventoDisparado.set(true);
        });

        componente.setNomMedicamento("Ibuprofeno 400mg");

        assertTrue(eventoDisparado.get(), "El componente debió emitir un evento de cambio.");
        assertEquals("Ibuprofeno 400mg", componente.getNomMedicamento());
    }
}