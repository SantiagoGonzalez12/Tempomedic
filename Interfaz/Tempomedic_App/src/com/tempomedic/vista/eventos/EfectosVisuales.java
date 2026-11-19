
package com.tempomedic.vista.eventos;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 * Efectos visuales de interacción (hover y foco) para controles Swing
 *
 * @author Santiago González
 * @version 1.0
 */
public final class EfectosVisuales {

    private static final String CLAVE_FONDO = "tempomedic.fondoOriginal";
    private static final String CLAVE_BORDE = "tempomedic.bordeOriginal";
    private static final int GROSOR_FOCO = 2;

    private EfectosVisuales() {

    }

    /**
     * Aplica el aspecto de "puntero encima" y cursor de mano
     *
     * @param c control sobre el que entra el puntero
     */
    public static void entrar(JComponent c) {
        if (!c.isEnabled()) {
            return;
        }
        c.setBackground(fondoOriginal(c).darker());
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Restaura el aspecto normal al salir el puntero
     *
     * @param c control del que sale el puntero
     */
    public static void salir(JComponent c) {
        c.setBackground(fondoOriginal(c));
        c.setCursor(Cursor.getDefaultCursor());
    }

    /**
     * Dibuja un anillo de foco visible
     *
     * @param c control que recibe el foco
     */
    public static void ganarFoco(JComponent c) {
        if (c.getClientProperty(CLAVE_BORDE) == null) {
            c.putClientProperty(CLAVE_BORDE, c.getBorder());
        }
        Color colorFoco = UIManager.getColor("Component.focusColor");
        if (colorFoco == null) {
            colorFoco = c.getForeground();
        }
        Border original = (Border) c.getClientProperty(CLAVE_BORDE);
        c.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorFoco, GROSOR_FOCO), original));
    }

    /**
     * Quita el anillo de foco y restaura el borde original
     *
     * @param c control que pierde el foco
     */
    public static void perderFoco(JComponent c) {
        Border original = (Border) c.getClientProperty(CLAVE_BORDE);
        if (original != null) {
            c.setBorder(original);
        }
    }

    private static Color fondoOriginal(JComponent c) {
        Color fondo = (Color) c.getClientProperty(CLAVE_FONDO);
        if (fondo == null) {
            fondo = c.getBackground();
            c.putClientProperty(CLAVE_FONDO, fondo);
        }
        return fondo;
    }
}
