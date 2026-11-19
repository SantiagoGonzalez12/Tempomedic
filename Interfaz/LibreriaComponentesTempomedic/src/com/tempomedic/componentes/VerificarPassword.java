package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Componente visual reutilizable para verificar que una contraseña coincide.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class VerificarPassword extends JPasswordField implements Serializable {

    /**
     * Constante para notificar cambios.
     */
    public static final String PROP_VERIFICACION = "verificacionCorrecta";
    /**
     * Constante para notificar el cambio de la propiedad original.
     */
    public static final String PROP_PASSWORD_ORIGINAL = "passwordOriginal";

    /**
     * Color de fondo por defecto.
     */
    private final Color COLOR_FONDO = new Color(186, 209, 217);
    /**
     * Color de fondo cuando el campo tiene el foco.
     */
    private final Color COLOR_FOCO = Color.WHITE;
    /**
     * Color de fondo cuando hay un error.
     */
    private final Color COLOR_ERROR = new Color(255, 204, 204);
    /**
     * Texto por defecto del campo.
     */
    private static final String TEXTO_POR_DEFECTO = "Repetir contraseña";

    /**
     * Almacena la contraseña original con la que se compara.
     */
    private String passwordOriginal;
    /**
     * Indica si la verificación es correcta.
     */
    private boolean verificacionCorrecta;
    /**
     * Indica si el campo está vacío.
     */
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
     * Configura la interfaz y los escuchadores.
     */
    private void inicializarComponente() {
        this.setBackground(COLOR_FONDO);
        this.setForeground(Color.BLACK);
        this.setEchoChar('•');
        this.setText(TEXTO_POR_DEFECTO);
        this.setEchoChar((char) 0);

        //Escuchador comprueba en tiempo real mientras se escribe
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkMatch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkMatch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkMatch();
            }
        });

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textoPorDefecto) {
                    setText("");
                    setEchoChar('•');
                    textoPorDefecto = false;
                }
                setBackground(COLOR_FOCO);
            }

            @Override
            public void focusLost(FocusEvent e) {
                String textoActual = new String(getPassword());
                if (textoActual.isEmpty()) {
                    setText(TEXTO_POR_DEFECTO);
                    setEchoChar((char) 0);
                    textoPorDefecto = true;
                    updateVerificacion(false);
                    setBackground(COLOR_FONDO);
                } else {
                    checkMatch();
                }
            }
        });
    }

    /**
     * Comprueba si el texto actual coincide con la contraseña original.
     */
    private void checkMatch() {
        if (textoPorDefecto) {
            return;
        }

        String textoActual = new String(getPassword());
        if (textoActual.isEmpty()) {
            return;
        }

        if (textoActual.equals(passwordOriginal) && !passwordOriginal.isEmpty()) {
            updateVerificacion(true);
            setBackground(COLOR_FONDO);
        } else {
            updateVerificacion(false);
            setBackground(COLOR_ERROR);
        }
    }

    /**
     * Actualiza el estado y notifica a los escuchadores.
     *
     * @param estado el nuevo estado de verificación.
     */
    private void updateVerificacion(boolean estado) {
        boolean anterior = this.verificacionCorrecta;
        this.verificacionCorrecta = estado;
        this.firePropertyChange(PROP_VERIFICACION, anterior, this.verificacionCorrecta);
    }

    /**
     * Obtiene el estado de la verificación.
     *
     * @return true si coinciden.
     */
    public boolean isVerificacionCorrecta() {
        return verificacionCorrecta;
    }

    /**
     * Obtiene la contraseña original.
     *
     * @return la contraseña original.
     */
    public String getPasswordOriginal() {
        return passwordOriginal;
    }

    /**
     * Establece la contraseña original (enlazable con Matisse).
     *
     * @param passwordOriginal la contraseña original.
     */
    public void setPasswordOriginal(String passwordOriginal) {
        String anterior = this.passwordOriginal;
        this.passwordOriginal = passwordOriginal;

        //Si hay texto, re-verificar inmediatamente
        checkMatch();

        this.firePropertyChange(PROP_PASSWORD_ORIGINAL, anterior, passwordOriginal);
    }
}
