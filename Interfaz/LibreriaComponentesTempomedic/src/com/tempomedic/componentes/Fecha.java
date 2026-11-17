package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * Componente visual reutilizable para introducir una fecha en formato dd/mm/aaaa.
 * <p>
 * Restringe la escritura solo a números, autoformatea las barras '/' y valida
 * que la fecha sea real (ej. evita el 31/02/2023).
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class Fecha extends JTextField implements Serializable {

    /** Constante para notificar cambios en la fecha. */
    public static final String PROP_FECHA = "fecha";

    /** Almacena la fecha validada en formato dd/mm/yyyy. */
    private String fecha;
    
    /** Indica si el campo está mostrando el texto por defecto "dd/mm/aaaa". */
    private boolean textoPorDefecto;
    
    /** Expresión regular para validar el formato básico dd/mm/aaaa. */
    private final String REGEX_FECHA = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

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
     * Configura la interfaz gráfica y los escuchadores de eventos.
     */
    private void inicializarComponente() {
        this.setText("dd/mm/aaaa");
        this.setBackground(new Color(186, 209, 217)); // Azul claro
        this.setForeground(Color.BLACK);
        this.setHorizontalAlignment(JTextField.LEFT);

        //Manejo del foco (borrar texto por defecto)
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textoPorDefecto) {
                    setText("");
                    textoPorDefecto = false;
                }
                setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText("dd/mm/aaaa");
                    textoPorDefecto = true;
                    setFecha("");
                } else {
                    validarYFormatear();
                }
                if (!textoPorDefecto) {
                    setBackground(new Color(186, 209, 217));
                }
            }
        });

        //Restricción de teclado y autoformateo
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                //Solo números. Bloqueo de letras, símbolos y la barra '/'
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    return; //Al borrar, no se autoformatea
                }

                String texto = getText();
                if (texto.length() == 2 && !texto.contains("/")) {
                    setText(texto + "/");
                }
                else if (texto.length() == 5 && texto.chars().filter(ch -> ch == '/').count() == 1) {
                    setText(texto + "/");
                }
            }
        });
    }

    /**
     * Valida la fecha usando Regex y comprobación estricta de calendario.
     */
    private void validarYFormatear() {
        String textoActual = getText().trim();

        //Validación con Regex
        Pattern patron = Pattern.compile(REGEX_FECHA);
        Matcher matcher = patron.matcher(textoActual);

        if (matcher.matches()) {
            //Validación real
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            
            try {
                sdf.parse(textoActual); //Si falla, lanza ParseException
                
                //Si llega aquí, la fecha es correcta
                String fechaAnterior = this.fecha;
                this.fecha = textoActual;
                setText(textoActual);
                this.firePropertyChange(PROP_FECHA, fechaAnterior, this.fecha);
                setBackground(new Color(186, 209, 217)); //Restaurar color
                
            } catch (ParseException ex) {
                //Fecha inexistente
                marcarError();
            }
        } else {
            //Formato incorrecto
            marcarError();
        }
    }

    /**
     * Marca el componente visualmente en rojo cuando hay un error.
     */
    private void marcarError() {
        setBackground(new Color(255, 204, 204)); //Rojo suave
        this.fecha = "";
        this.firePropertyChange(PROP_FECHA, "", "");
    }

    /**
     * Obtiene la fecha actual validada.
     * 
     * @return la fecha en formato dd/mm/yyyy o cadena vacía si no es válida.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha manualmente.
     * 
     * @param fecha la nueva fecha en formato dd/mm/yyyy.
     */
    public void setFecha(String fecha) {
        String fechaAnterior = this.fecha;
        this.fecha = fecha;
        
        if (fecha == null || fecha.isEmpty()) {
            setText("dd/mm/aaaa");
            this.textoPorDefecto = true;
        } else {
            setText(fecha);
            this.textoPorDefecto = false;
        }
        
        this.firePropertyChange(PROP_FECHA, fechaAnterior, this.fecha);
    }
}