package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Componente visual reutilizable para introducir un PIN de 4 dígitos.
 * <p>
 * Consta de 4 cajas de texto individuales que gestionan el foco automáticamente
 * y validan que solo se introduzcan caracteres numéricos.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class Pin extends JPanel implements Serializable {

    /**
     * Constante para notificar cambios en el PIN.
     */
    public static final String PROP_PIN = "pin";

    /**
     * Color de fondo de las cajas.
     */
    private static final Color COLOR_FONDO = new Color(186, 209, 217);
    /**
     * Color de fondo cuando la caja tiene el foco.
     */
    private static final Color COLOR_FOCO = Color.WHITE;

    /**
     * Array con las 4 cajas de texto.
     */
    private JTextField[] cajas;
    /**
     * Almacena el PIN completo (4 dígitos).
     */
    private String pin;

    /**
     * Constructor por defecto requerido por JavaBeans.
     */
    public Pin() {
        this.pin = "";
        inicializarComponente();
    }

    /**
     * Configura la interfaz gráfica creando las 4 cajas y sus eventos.
     */
    private void inicializarComponente() {
        //Uso de GridLayout para poner 4 cajas en horizontal con 14px de separación
        this.setLayout(new GridLayout(1, 4, 14, 0));
        this.setOpaque(false); //El fondo lo ponen las cajas individuales

        cajas = new JTextField[4];

        for (int i = 0; i < 4; i++) {
            cajas[i] = new JTextField();
            cajas[i].setHorizontalAlignment(JTextField.CENTER);
            cajas[i].setFont(new Font("SansSerif", Font.BOLD, 24));
            cajas[i].setBackground(COLOR_FONDO);
            cajas[i].setForeground(Color.BLACK);
            cajas[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
            cajas[i].setPreferredSize(new Dimension(64, 72)); // Tamaño cuadrado

            final int index = i;

            //Restricción de teclado y salto automático
            cajas[i].addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    //Se ignora todo caracter que no sea numérico
                    if (!Character.isDigit(c)) {
                        e.consume();
                    } //Si hay un número escrito, se reemplaza
                    else if (cajas[index].getText().length() >= 1) {
                        cajas[index].setText("");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //Si se pulsa Borrar en una caja vacía, se vuelve a la anterior
                    if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        if (cajas[index].getText().isEmpty() && index > 0) {
                            cajas[index - 1].requestFocus();
                        }
                    } //Si se escribe un número, se salta a la siguiente caja
                    else if (Character.isDigit(e.getKeyChar())) {
                        if (index < 3) {
                            cajas[index + 1].requestFocus();
                        }
                    }
                    actualizarPIN();
                }
            });

            //Selección de texto al recibir el foco
            cajas[i].addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    cajas[index].selectAll();
                    cajas[index].setBackground(COLOR_FOCO); //Se ilumina al escribir
                }

                @Override
                public void focusLost(FocusEvent e) {
                    cajas[index].setBackground(COLOR_FONDO);
                }
            });

            this.add(cajas[i]);
        }
    }

    /**
     * Reconstruye el PIN a partir de las 4 cajas y notifica el cambio si es
     * necesario.
     */
    private void actualizarPIN() {
        StringBuilder sb = new StringBuilder();
        boolean completo = true;

        for (JTextField caja : cajas) {
            String texto = caja.getText();
            if (texto.isEmpty()) {
                completo = false;
                sb.append(" "); //Añadir espacio para mantener la longitud
            } else {
                sb.append(texto);
            }
        }

        String pinAnterior = this.pin;
        this.pin = completo ? sb.toString() : "";
        this.firePropertyChange(PROP_PIN, pinAnterior, this.pin);
    }

    /**
     * Obtiene el PIN completo.
     *
     * @return el PIN de 4 dígitos o cadena vacía si no está completo.
     */
    public String getPin() {
        return pin;
    }

    /**
     * Establece el PIN manualmente, rellenando las cajas.
     *
     * @param pin el PIN de 4 dígitos.
     */
    public void setPin(String pin) {
        String pinAnterior = this.pin;
        this.pin = pin;

        if (pin == null || pin.length() != 4) {
            //Si PIN no válido, se vacian las cajas
            for (JTextField caja : cajas) {
                caja.setText("");
            }
            this.pin = "";
        } else {
            //Relleno de cajas una a una
            for (int i = 0; i < 4; i++) {
                cajas[i].setText(String.valueOf(pin.charAt(i)));
            }
        }

        this.firePropertyChange(PROP_PIN, pinAnterior, this.pin);
    }
}
