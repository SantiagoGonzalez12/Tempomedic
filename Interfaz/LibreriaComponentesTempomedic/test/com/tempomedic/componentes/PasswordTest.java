package com.tempomedic.componentes;

import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para el componente Password.
 * 
 * @author Alba Durán Bernal
 * @version 1.0
 */
public class PasswordTest {

    private Password componente;

    @Before
    public void setUp() {
        componente = new Password();
    }

    @Test
    public void testValorPorDefecto() {
        assertEquals("", componente.getPasswordValidada());
    }

    @Test
    public void testNotificacionEventoPassword() {
        AtomicBoolean eventoDisparado = new AtomicBoolean(false);
        componente.addPropertyChangeListener(Password.PROP_PASSWORD, 
                evt -> eventoDisparado.set(true)); //Operador lambda. Separa los parámetros de entrada (izquierda) del código que se va a ejecutar (derecha)
        
        componente.setPasswordValidada("Secreta123");
        
        assertTrue("Debe emitir evento al cambiar la contraseña", eventoDisparado.get());
        assertEquals("Secreta123", componente.getPasswordValidada());
    }
}