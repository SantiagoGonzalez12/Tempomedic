package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JPasswordField;

/**
 * Componente visual reutilizable para introducir una contraseña.
 * <p>
 * Oculta los caracteres introducidos y valida que cumpla un tamaño mínimo.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class Password extends JPasswordField implements Serializable {

    /** Constante para notificar cambios en la contraseña. */
    public static final String PROP_PASSWORD = "password";
    
    /** Tamaño mínimo de la contraseña. */
    private final int LONGITUD_MINIMA = 6;

    /** Almacena el texto validado. */
    private String passwordValidada;
    
    /** Indica si el campo está vacío (para el texto por defecto). */
    private boolean textoPorDefecto;

    /**
     * Constructor por defecto requerido por JavaBeans.
     */
    public Password() {
        super();
        this.passwordValidada = "";
        this.textoPorDefecto = true;
        inicializarComponente();
    }

    /**
     * Configura la interfaz y los escuchadores de eventos.
     */
    private void inicializarComponente() {
        this.setBackground(new Color(186, 209, 217));
        this.setForeground(Color.BLACK);
        this.setEchoChar('•'); //Punto para ocultar el caracter verdadero
        this.setText("Contraseña");
        this.setEchoChar((char) 0);

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textoPorDefecto) {
                    setText("");
                    setEchoChar('•'); //Ocultación al empezar a escribir
                    textoPorDefecto = false;
                }
                setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                String textoActual = new String(getPassword());
                
                if (textoActual.isEmpty()) {
                    setText("Contraseña");
                    setEchoChar((char) 0);
                    textoPorDefecto = true;
                    setPasswordValidada("");
                } else {
                    validarPassword(textoActual);
                }
                setBackground(new Color(186, 209, 217));
            }
        });
    }

    /**
     * Valida que la contraseña cumpla los requisitos mínimos.
     * 
     * @param textoActual el texto introducido por el usuario.
     */
    private void validarPassword(String textoActual) {
        //Validación: mínimo 6 caracteres y sin espacios
        if (textoActual.length() >= LONGITUD_MINIMA && !textoActual.contains(" ")) {
            String passwordAnterior = this.passwordValidada;
            this.passwordValidada = textoActual;
            setBackground(new Color(186, 209, 217));
            this.firePropertyChange(PROP_PASSWORD, passwordAnterior, this.passwordValidada);
        } else {
            //Error: muy corta o contiene espacios
            setBackground(new Color(255, 204, 204)); //Rojo
            this.passwordValidada = "";
            this.firePropertyChange(PROP_PASSWORD, this.passwordValidada, "");
        }
    }

    /**
     * Obtiene la contraseña validada.
     * 
     * @return la contraseña o cadena vacía si no es válida.
     */
    public String getPasswordValidada() {
        return passwordValidada;
    }

    /**
     * Establece la contraseña manualmente.
     * 
     * @param password el nuevo texto.
     */
    public void setPasswordValidada(String password) {
        String passwordAnterior = this.passwordValidada;
        this.passwordValidada = password;
        
        if (password == null || password.isEmpty()) {
            setText("Contraseña");
            setEchoChar((char) 0);
            this.textoPorDefecto = true;
        } else {
            setText(password);
            setEchoChar('•');
            this.textoPorDefecto = false;
        }
        
        this.firePropertyChange(PROP_PASSWORD, passwordAnterior, this.passwordValidada);
    }
}