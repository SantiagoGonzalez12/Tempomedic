package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * Componente visual reutilizable para introducir y validar una dirección de
 * correo electrónico.
 * <p>
 * Valida que el formato del correo sea correcto utilizando expresiones
 * regulares.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class Correo extends JTextField implements Serializable {

    /**
     * Constante para notificar cambios en el correo.
     */
    public static final String PROP_CORREO = "correo";

    /**
     * Color de fondo por defecto.
     */
    private static final Color COLOR_FONDO = new Color(186, 209, 217);
    /**
     * Color de fondo cuando el campo tiene el foco.
     */
    private static final Color COLOR_FOCO = Color.WHITE;
    /**
     * Color de fondo cuando hay un error.
     */
    private static final Color COLOR_ERROR = new Color(255, 204, 204);
    /**
     * Texto por defecto del campo.
     */
    private static final String TEXTO_POR_DEFECTO = "nombre@correo.com";
    /**
     * Expresión regular para validar el correo. Exige: Texto + @ + Texto + . +
     * al menos 2 letras.
     */
    private static final String REGEX_CORREO = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    /**
     * Almacena el correo validado.
     */
    private String correo;
    /**
     * Indica si el campo está mostrando el texto por defecto.
     */
    private boolean textoPorDefecto;

    /**
     * Constructor por defecto requerido por JavaBeans.
     */
    public Correo() {
        super();
        this.correo = "";
        this.textoPorDefecto = true;
        inicializarComponente();
    }

    /**
     * Configura la interfaz gráfica y los escuchadores de eventos.
     */
    private void inicializarComponente() {
        this.setText(TEXTO_POR_DEFECTO);
        this.setBackground(COLOR_FONDO); //Azul claro
        this.setForeground(Color.BLACK);
        this.setHorizontalAlignment(JTextField.LEFT);

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textoPorDefecto) {
                    setText("");
                    textoPorDefecto = false;
                }
                setBackground(COLOR_FOCO);
            }

            @Override
            public void focusLost(FocusEvent e) {
                String textoActual = getText().trim();

                if (textoActual.isEmpty()) {
                    setText(TEXTO_POR_DEFECTO);
                    textoPorDefecto = true;
                    setCorreo("");
                    setBackground(COLOR_FONDO);
                } else {
                    validarCorreo(textoActual);
                }
            }
        });
    }

    /**
     * Valida el formato del correo utilizando la expresión regular.
     *
     * @param textoActual el correo introducido por el usuario.
     */
    private void validarCorreo(String textoActual) {
        Matcher matcher = Pattern.compile(REGEX_CORREO,
                Pattern.CASE_INSENSITIVE).matcher(textoActual);

        if (matcher.matches()) {
            String correoAnterior = this.correo;
            this.correo = textoActual;
            setBackground(COLOR_FONDO);
            this.firePropertyChange(PROP_CORREO, correoAnterior, this.correo);
        } else {
            setBackground(COLOR_ERROR);
            this.correo = "";
            this.firePropertyChange(PROP_CORREO, this.correo, "");
        }
    }

    /**
     * Obtiene el correo electrónico validado.
     *
     * @return el correo como String o cadena vacía si no es válido.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico manualmente.
     *
     * @param correo el nuevo correo a establecer.
     */
    public void setCorreo(String correo) {
        String correoAnterior = this.correo;

        this.correo = correo;
        setText(correo == null || correo.isEmpty() ? TEXTO_POR_DEFECTO : correo);
        this.textoPorDefecto = (correo == null || correo.isEmpty());
        this.firePropertyChange(PROP_CORREO, correoAnterior, this.correo);
    }
}
