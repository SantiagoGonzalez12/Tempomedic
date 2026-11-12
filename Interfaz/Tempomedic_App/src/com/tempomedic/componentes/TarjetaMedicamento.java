package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jorge Espejo Martinez
 * 
 * Componente visual reutilizable que representa una tarjeta de medicamento.
 * Cumple la especificación JavaBeans para su integración en Matisse.
 */
public class TarjetaMedicamento extends JPanel implements Serializable {

    // Constantes para los eventos (Muy importante para PropertyChangeSupport)
    public static final String PROP_NOMBRE = "nomMedicamento";
    public static final String PROP_PAUTA = "pauta";
    public static final String PROP_PROXIMA_TOMA = "proximaToma";

    private JLabel lblNombre;
    private JLabel lblPauta;
    private JLabel lblProximaToma;

    // Propiedades lógicas
    private String nombreMedicamento;
    private String pauta;
    private String proximaToma;

    // El soporte para notificar cambios
    private final PropertyChangeSupport propertySupport;

    // Constructor
    public TarjetaMedicamento() {
        // Inicializacion de valores por defecto
        this.propertySupport = new PropertyChangeSupport(this);
        this.nombreMedicamento = "Nombre por defecto";
        this.pauta = "Pauta por defecto";
        this.proximaToma = "Próxima toma: --:--";

        iniInterfaz();
    }

    private void iniInterfaz() {
        // Uso de colores corporativos
        this.setBackground(new Color(186, 209, 217)); 
        this.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;

        lblNombre = new JLabel(this.nombreMedicamento);
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblNombre.setForeground(new Color(59, 106, 118)); // Azul oscuro
        gbc.gridy = 0;
        this.add(lblNombre, gbc);

        lblPauta = new JLabel(this.pauta);
        lblPauta.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(4, 0, 0, 0);
        this.add(lblPauta, gbc);

        lblProximaToma = new JLabel(this.proximaToma);
        lblProximaToma.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblProximaToma.setForeground(new Color(59, 106, 118));
        gbc.gridy = 2;
        this.add(lblProximaToma, gbc);
    }

    // Métodos

    public String getNomMedicamento() {
        return nombreMedicamento;
    }

    public void setNomMedicamento(String nuevoNombre) {
        String valorAnterior = this.nombreMedicamento;
        this.nombreMedicamento = nuevoNombre;
        if (lblNombre != null) {
            lblNombre.setText(nuevoNombre);
        }
        // Notifica cambio a Matisse o a cualquier escuchador
        propertySupport.firePropertyChange(PROP_NOMBRE, valorAnterior, nuevoNombre);
        this.revalidate();
        this.repaint();
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String nuevaPauta) {
        String valorAnterior = this.pauta;
        this.pauta = nuevaPauta;
        if (lblPauta != null) {
            lblPauta.setText(nuevaPauta);
        }
        propertySupport.firePropertyChange(PROP_PAUTA, valorAnterior, nuevaPauta);
        this.revalidate();
        this.repaint();
    }

    public String getProxToma() {
        return proximaToma;
    }

    public void setProxToma(String nuevaToma) {
        String valorAnterior = this.proximaToma;
        this.proximaToma = nuevaToma;
        if (lblProximaToma != null) {
            lblProximaToma.setText(nuevaToma);
        }
        propertySupport.firePropertyChange(PROP_PROXIMA_TOMA, valorAnterior, nuevaToma);
        this.revalidate();
        this.repaint();
    }

    // Gestion de escuchadores

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}