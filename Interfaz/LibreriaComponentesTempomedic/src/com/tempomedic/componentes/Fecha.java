package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.SimpleAttributeSet;

/**
 * Componente visual reutilizable para introducir una fecha (dd/mm/aaaa).
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class Fecha extends JTextField implements Serializable {

    /**
     * Constante para notificar cambios en la fecha.
     */
    public static final String PROP_FECHA = "fecha";

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
    private static final String TEXTO_POR_DEFECTO = "dd/mm/aaaa";
    /**
     * Expresión regular para validar el formato básico dd/mm/aaaa.
     */
    private static final String REGEX_FECHA = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

    /**
     * Almacena la fecha validada en formato dd/mm/yyyy.
     */
    private String fecha;
    /**
     * Indica si el campo está mostrando el texto por defecto.
     */
    private boolean textoPorDefecto;

    /**
     * Constructor por defecto requerido por JavaBeans.
     */
    public Fecha() {
        super();
        this.fecha = "";
        this.textoPorDefecto = true;
        inicializarComponente();
    }

    /**
     * Configura la interfaz y los eventos.
     */
    private void inicializarComponente() {
        this.setText(TEXTO_POR_DEFECTO);
        this.setBackground(COLOR_FONDO);
        this.setForeground(Color.BLACK);

        //Filtro evita letras, limita a 10 caracteres y autopone barras
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
                    AttributeSet attr) {
                replace(fb, offset, 0, string, attr);
            }

            /**
             * Reemplaza un fragmento de texto en el documento validando su
             * contenido.
             *
             * @param fb el bypass del filtro.
             * @param offset la posición de inicio.
             * @param length la longitud del texto a borrar.
             * @param text el texto nuevo.
             * @param attrs los atributos del texto.
             * @throws BadLocationException si la posición es inválida.
             */
            @Override
            public void replace(FilterBypass fb, int offset, int length,
                    String text, AttributeSet attrs) {
                try {
                    if (text == null) {
                        return;
                    }

                    String currentText = fb.getDocument().getText(0,
                            fb.getDocument().getLength());
                    String newText = currentText.substring(0, offset) + text
                            + currentText.substring(offset + length);

                    if (!newText.matches("[0-9/]*") || newText.length() > 10) {
                        return;
                    }

                    super.replace(fb, offset, length, text, attrs);

                    //Autoformateo de barras
                    currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                    if (currentText.length() == 2 && !currentText.contains("/")) {
                        super.insertString(fb, 2, "/", new SimpleAttributeSet());
                    } else if (currentText.length() == 5
                            && currentText.chars().filter(ch -> ch == '/').count() == 1) {
                        super.insertString(fb, 5, "/", new SimpleAttributeSet());
                    }
                } catch (BadLocationException ex) {
                    System.getLogger(Fecha.class.getName()).log(System.Logger.Level.ERROR,
                            (String) null, ex);
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
                if (getText().isEmpty()) {
                    setText(TEXTO_POR_DEFECTO);
                    textoPorDefecto = true;
                    setFecha("");
                    setBackground(COLOR_FONDO);
                } else {
                    validarYFormatear();
                }
            }
        });
    }

    /**
     * Valida la fecha con Regex y comprobación estricta de calendario.
     */
    private void validarYFormatear() {
        String textoActual = getText().trim();
        Matcher matcher = Pattern.compile(REGEX_FECHA).matcher(textoActual);

        if (matcher.matches()) {
            try {
                //Valida si la fecha existe
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                sdf.parse(textoActual);

                //Valida un rango de años lógico (1900 - 2100)
                int year = Integer.parseInt(textoActual.substring(6));
                if (year < 1900 || year > 2100) {
                    marcarError();
                    return;
                }

                String fechaAnterior = this.fecha;
                this.fecha = textoActual;
                setBackground(COLOR_FONDO);
                this.firePropertyChange(PROP_FECHA, fechaAnterior, this.fecha);

            } catch (ParseException | NumberFormatException ex) {
                marcarError(); //Si el día no existe o el año falla
            }
        } else {
            marcarError();
        }
        this.revalidate();
        this.repaint();
    }

    /**
     * Marca el componente en rojo cuando hay un error.
     */
    private void marcarError() {
        setBackground(COLOR_ERROR);
        this.fecha = "";
        this.firePropertyChange(PROP_FECHA, "", "");
    }

    /**
     * Obtiene la fecha validada.
     *
     * @return la fecha en formato dd/mm/yyyy o cadena vacía.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha manualmente.
     *
     * @param fecha la nueva fecha.
     */
    public void setFecha(String fecha) {
        String fechaAnterior = this.fecha;
        this.fecha = fecha;
        setText(fecha == null || fecha.isEmpty() ? TEXTO_POR_DEFECTO : fecha);
        this.textoPorDefecto = (fecha == null || fecha.isEmpty());
        this.firePropertyChange(PROP_FECHA, fechaAnterior, this.fecha);
    }
}
