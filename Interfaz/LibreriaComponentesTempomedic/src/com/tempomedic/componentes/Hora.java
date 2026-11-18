package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.SimpleAttributeSet;

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

    /** Constante para notificar cambios en la hora. */
    public static final String PROP_HORA = "hora";

    /** Color de fondo por defecto. */
    private final Color COLOR_FONDO = new Color(186, 209, 217);
    /** Color de fondo cuando el campo tiene el foco. */
    private final Color COLOR_FOCO = Color.WHITE;
    /** Color de fondo cuando hay un error. */
    private final Color COLOR_ERROR = new Color(255, 204, 204);
    /** Texto por defecto del campo. */
    private static final String TEXTO_POR_DEFECTO = "--:--";
    /** Expresión regular para validar el formato HH:mm (00:00 a 23:59). */
    private final String REGEX_HORA = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";

    /** Almacena la hora validada en formato HH:mm. */
    private String hora;
    /** Indica si el campo está mostrando el texto por defecto. */
    private boolean textoPorDefecto;

    /**
     * Constructor por defecto sin argumentos requerido por la especificación JavaBeans.
     */
    public Hora() {
        super();
        this.hora = "";
        this.textoPorDefecto = true;
        inicializarComponente();
    }

    /**
     * Configura los estilos, el texto por defecto y los eventos.
     */
    private void inicializarComponente() {
        this.setText("--:--");
        this.setBackground(COLOR_FONDO);
        this.setForeground(Color.BLACK);

        //DocumentFilter controla la entrada de texto (en vez de KeyListener)
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new DocumentFilter() {
            
            /**
             * Inserta una cadena de texto en el documento.
             * 
             * @param fb el bypass del filtro.
             * @param offset la posición de inserción.
             * @param string el texto a insertar.
             * @param attr los atributos del texto.
             */
            @Override
            public void insertString(FilterBypass fb, int offset, String string, 
                    AttributeSet attr)
            {
                replace(fb, offset, 0, string, attr);
            }

            /**
             * Reemplaza un fragmento de texto en el documento validando su contenido.
             * 
             * @param fb el bypass del filtro.
             * @param offset la posición de inicio.
             * @param length la longitud del texto a borrar.
             * @param text el texto nuevo.
             * @param attrs los atributos del texto.
             * @throws BadLocationException si la posición es inválida.
             */
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) {
                try {
                    if (text == null) return;
                    
                    String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                    String newText = currentText.substring(0, offset) + text + 
                            currentText.substring(offset + length);
                    
                    //Permite números, ':' y un máximo de 5 caracteres
                    if (!newText.matches("[0-9:]*") || newText.length() > 5) {
                        return;
                    }
                    
                    super.replace(fb, offset, length, text, attrs);
                    
                    //Autoformateo: si hay 2 números, se añade los ':'
                    currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                    if (currentText.length() == 2 && !currentText.contains(":")) {
                        super.insertString(fb, 2, ":", new SimpleAttributeSet());
                    }
                } catch (BadLocationException ex) {
                    System.getLogger(Hora.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        });

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
                if (getText().isEmpty() || getText().equals(TEXTO_POR_DEFECTO)) {
                    setText(TEXTO_POR_DEFECTO);
                    textoPorDefecto = true;
                    setHora("");
                    setBackground(COLOR_FONDO);
                } else {
                    validarYFormatear();
                }
            }
        });
    }

    /**
     * Valida si la hora cumple el formato y notifica los cambios.
     */
    private void validarYFormatear() {
        String textoActual = getText().trim();
        Matcher matcher = Pattern.compile(REGEX_HORA).matcher(textoActual);

        if (matcher.matches()) {
            String horaAnterior = this.hora;
            this.hora = textoActual;
            setBackground(COLOR_FONDO);
            this.firePropertyChange(PROP_HORA, horaAnterior, this.hora);
        } else {
            setBackground(COLOR_ERROR);
            this.hora = "";
            this.firePropertyChange(PROP_HORA, this.hora, "");
        }
        this.revalidate();
        this.repaint();
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
     * Establece la hora manualmente.
     * 
     * @param hora la nueva hora en formato HH:mm.
     */
    public void setHora(String hora) {
        String horaAnterior = this.hora;
        this.hora = hora;
        setText(hora == null || hora.isEmpty() ? "--:--" : hora);
        this.textoPorDefecto = (hora == null || hora.isEmpty());
        this.firePropertyChange(PROP_HORA, horaAnterior, this.hora);
    }
}