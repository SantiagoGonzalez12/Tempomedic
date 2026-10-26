/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.tempomedic;

import com.formdev.flatlaf.FlatLightLaf;
import com.tempomedic.vista.VentanaMedicamentos;
import javax.swing.SwingUtilities;

/**
 *
 * @author Santiago González
 */

public class Main {

    public static void main(String[] args) {

        FlatLightLaf.setup();

        System.out.println("Look and Feel: "
                + javax.swing.UIManager.getLookAndFeel().getName());

        SwingUtilities.invokeLater(() -> {
            VentanaMedicamentos ventana = new VentanaMedicamentos();
            ventana.setVisible(true);
        });
    }
}
