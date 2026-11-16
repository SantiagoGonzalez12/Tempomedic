package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * Componente visual reutilizable para introducir una hora.
 * <p>
 * Valida el formato HH:mm, autoformatea la entrada añadiendo los dos puntos y
 * restringe la escritura únicamente a caracteres numéricos.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class Hora extends JTextField implements Serializable {

    /**
     * Constante para notificar cambios en la hora a los escuchadores
     * (PropertyChange).
     */
    public static final String PROP_HORA = "hora";

    /**
     * Almacena la hora validada en formato HH:mm.
     */
    private String hora;

    /**
     * Indica si el campo está mostrando el texto por defecto "--:--".
     */
    private boolean textoPorDefecto;

    /**
     * Expresión regular para validar el formato HH:mm (00:00 a 23:59).
     */
    private final String REGEX_HORA = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";

    /**
     * Constructor por defecto sin argumentos requerido por la especificación
     * JavaBeans. Inicializa el componente con su valor por defecto.
     */
    public Hora() {
        super();
        this.hora = "";
        this.textoPorDefecto = true;
        inicializarComponente();
    }

    /**
     * Configura los estilos visuales, el texto por defecto y los escuchadores
     * de eventos (foco y teclado) necesarios para el funcionamiento del
     * componente.
     */
    private void inicializarComponente() {
        this.setText("--:--");
        this.setBackground(new Color(186, 209, 217)); // Azul claro
        this.setForeground(Color.BLACK);
        this.setHorizontalAlignment(JTextField.LEFT);

        // Se pone el foco, si es el texto por defecto, se borra
        this.addFocusListener(new FocusListener() {
            /**
             * Al ganar el foco, borra el texto por defecto y cambia el fondo a
             * blanco.
             *
             * @param e el evento de foco.
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (textoPorDefecto) {
                    setText("");
                    textoPorDefecto = false;
                }
                setBackground(Color.WHITE); // Se ilumina al escribir
            }

            /**
             * Al perder el foco, valida el texto o restaura el valor por
             * defecto si está vacío.
             *
             * @param e el evento de foco.
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText("--:--");
                    textoPorDefecto = true;
                    setHora("");
                } else {
                    validarYFormatear();
                }
                setBackground(new Color(186, 209, 217));
            }
        });

        // Restricción: solo números y el carácter ':'
        this.addKeyListener(new KeyAdapter() {
            /**
             * Restringe la entrada de caracteres, permitiendo solo números, ':'
             * y borrado.
             *
             * @param e el evento de tecla.
             */
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Si no es número ni ':' ni tecla de borrar, se ignora
                if (!Character.isDigit(c) && c != ':' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }

            /**
             * Autoformatea el texto añadiendo los dos puntos cuando se han
             * introducido dos dígitos.
             *
             * @param e el evento de tecla liberada.
             */
            @Override
            public void keyReleased(KeyEvent e) {
                // Autoformatear: si el usuario ha escrito 2 números, se pone ':'
                String texto = getText();
                if (texto.length() == 2 && !texto.contains(":")) {
                    setText(texto + ":");
                }
            }
        });
    }

    /**
     * Valida si la hora cumple el formato esperado, aplica el autoformateo si
     * el usuario ha omitido los dos puntos y notifica los cambios. Si el
     * formato es incorrecto, marca el fondo del campo en rojo.
     */
    private void validarYFormatear() {
        String textoActual = getText().trim();

        // Si se escribe 1230, se convierte a 12:30
        if (textoActual.matches("^[0-9]{4}$")) {
            textoActual = textoActual.substring(0, 2) + ":" + textoActual.substring(2);
        }

        // Validación estricta con Regex
        Pattern patron = Pattern.compile(REGEX_HORA);
        Matcher matcher = patron.matcher(textoActual);

        if (matcher.matches()) {
            String horaAnterior = this.hora;
            this.hora = textoActual;
            setText(textoActual);
            // Si es válido, el fondo es el azul claro
            setBackground(new Color(186, 209, 217));

            // Notificar cambio para Matisse
            this.firePropertyChange(PROP_HORA, horaAnterior, this.hora);
        } else {
            // Si está mal, se marca el fondo en rojo claro
            setBackground(new Color(255, 204, 204)); // Color rojo suave (error)
            this.hora = "";

            // Notificar cambio a vacío para que la app sepa que no hay hora válida
            this.firePropertyChange(PROP_HORA, this.hora, "");
        }
    }

    /**
     * Obtiene la hora actual validada.
     *
     * @return la hora en formato HH:mm o cadena vacía si no es válida.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora manualmente desde código o desde el editor visual.
     *
     * @param hora la nueva hora en formato HH:mm.
     */
    public void setHora(String hora) {
        String horaAnterior = this.hora;
        this.hora = hora;
        setText(hora.isEmpty() ? "--:--" : hora);
        this.textoPorDefecto = hora.isEmpty();
        this.firePropertyChange(PROP_HORA, horaAnterior, hora);
    }
}
