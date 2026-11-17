package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JPasswordField;

/**
 * Componente visual reutilizable para verificar que una contraseña coincide 
 * con la introducida en otro campo.
 * <p>
 * Compara el texto introducido con la propiedad {@code passwordOriginal}.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class VerificarPassword extends JPasswordField implements Serializable {

    /** Constante para notificar cambios. */
    public static final String PROP_VERIFICACION = "verificacionCorrecta";
    /** Constante para notificar el cambio de la propiedad original. */
    public static final String PROP_PASSWORD_ORIGINAL = "passwordOriginal";

    /** Almacena la contraseña original con la que se compara. */
    private String passwordOriginal;
    /** Indica si la verificación es correcta. */
    private boolean verificacionCorrecta;
    /** Indica si el campo está vacío (para el texto por defecto). */
    private boolean textoPorDefecto;

    /**
     * Constructor por defecto requerido por JavaBeans.
     */
    public VerificarPassword() {
        super();
        this.passwordOriginal = "";
        this.verificacionCorrecta = false;
        this.textoPorDefecto = true;
        inicializarComponente();
    }

    /**
     * Configura la interfaz y los escuchadores de eventos.
     */
    private void inicializarComponente() {
        this.setBackground(new Color(186, 209, 217));
        this.setForeground(Color.BLACK);
        this.setEchoChar('•');
        this.setText("Repetir contraseña");
        this.setEchoChar((char) 0);

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textoPorDefecto) {
                    setText("");
                    setEchoChar('•');
                    textoPorDefecto = false;
                }
                setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                String textoActual = new String(getPassword());
                
                if (textoActual.isEmpty()) {
                    setText("Repetir contraseña");
                    setEchoChar((char) 0);
                    textoPorDefecto = true;
                    boolean anterior = verificacionCorrecta;
                    verificacionCorrecta = false;
                    firePropertyChange(PROP_VERIFICACION, anterior, verificacionCorrecta);
                } else {
                    verificarIgualdad(textoActual);
                }
                setBackground(new Color(186, 209, 217));
            }
        });
    }

    /**
     * Compara el texto actual con la contraseña original.
     * 
     * @param textoActual el texto escrito por el usuario.
     */
    private void verificarIgualdad(String textoActual) {
        boolean anterior = this.verificacionCorrecta;
        
        if (textoActual.equals(passwordOriginal) && !passwordOriginal.isEmpty()) {
            this.verificacionCorrecta = true;
            setBackground(new Color(186, 209, 217)); //Bien
        } else {
            this.verificacionCorrecta = false;
            setBackground(new Color(255, 204, 204)); //Rojo error
        }
        
        this.firePropertyChange(PROP_VERIFICACION, anterior, this.verificacionCorrecta);
    }

    /**
     * Obtiene el estado de la verificación.
     * 
     * @return true si las contraseñas coinciden, false en caso contrario.
     */
    public boolean isVerificacionCorrecta() {
        return verificacionCorrecta;
    }

    /**
     * Obtiene la contraseña original con la que se compara.
     * 
     * @return la contraseña original.
     */
    public String getPasswordOriginal() {
        return passwordOriginal;
    }

    /**
     * Establece la contraseña original con la que se debe comparar este campo.
     * <p>
     * Este método es el que permite enlazar este componente con el {@code CampoPassword}
     * desde el editor visual Matisse.
     * 
     * @param passwordOriginal la contraseña original.
     */
    public void setPasswordOriginal(String passwordOriginal) {
        String anterior = this.passwordOriginal;
        this.passwordOriginal = passwordOriginal;
        
        //Si hay texto escrito, re-verifica inmediatamente
        String textoActual = new String(getPassword());
        if (!textoActual.isEmpty() && !textoPorDefecto) {
            verificarIgualdad(textoActual);
        }
        
        this.firePropertyChange(PROP_PASSWORD_ORIGINAL, anterior, passwordOriginal);
    }
}