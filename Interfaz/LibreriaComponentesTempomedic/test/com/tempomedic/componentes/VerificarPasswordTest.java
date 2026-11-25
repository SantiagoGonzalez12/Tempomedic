package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para el componente VerificarPassword.
 * 
 * @author Alba Durán Bernal
 * @version 1.0
 */
public class VerificarPasswordTest {

    private VerificarPassword componente;

    @Before
    public void setUp() {
        componente = new VerificarPassword();
    }

    @Test
    public void testValoresPorDefecto() {
        assertFalse(componente.isVerificacionCorrecta());
        assertEquals("", componente.getPasswordOriginal());
    }

    @Test
    public void testNotificacionEventoOriginal() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(VerificarPassword.PROP_PASSWORD_ORIGINAL, evt -> eventoDisparado.set(true));
        
        componente.setPasswordOriginal("Secreta123");
        
        assertTrue("Debe emitir evento al cambiar la contraseña original", eventoDisparado.get());
        assertEquals("Secreta123", componente.getPasswordOriginal());
    }
}