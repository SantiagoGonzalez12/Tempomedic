package com.tempomedic.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Componente visual reutilizable que representa una tarjeta de medicamento.
 * <p>
 * Cumple estrictamente con la especificación JavaBeans para su integración en 
 * el editor visual Matisse de Apache NetBeans. Permite configurar el nombre del 
 * fármaco, la pauta y la próxima toma mediante propiedades enlazadas (bound properties).
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class TarjetaMedicamento extends JPanel implements Serializable {

    /** Constante que define el nombre de la propiedad para notificar cambios en el nombre. */
    public static final String PROP_NOMBRE = "nomMedicamento";
    
    /** Constante que define el nombre de la propiedad para notificar cambios en la pauta. */
    public static final String PROP_PAUTA = "pauta";
    
    /** Constante que define el nombre de la propiedad para notificar cambios en la próxima toma. */
    public static final String PROP_PROXIMA_TOMA = "proximaToma";

    /** Etiqueta para mostrar el nombre del medicamento. */
    private JLabel lblNombre;
    /** Etiqueta para mostrar la pauta o frecuencia. */
    private JLabel lblPauta;
    /** Etiqueta para mostrar la próxima toma. */
    private JLabel lblProximaToma;

    /** Almacena el nombre del medicamento. */
    private String nomMedicamento;
    /** Almacena la pauta del medicamento. */
    private String pauta;
    /** Almacena el texto de la próxima toma. */
    private String proxToma;

    /**
     * Constructor por defecto sin argumentos requerido por la especificación JavaBeans.
     * Inicializa el componente con valores predeterminados y configura la interfaz gráfica.
     */
    public TarjetaMedicamento() {
        this.nomMedicamento = "Nombre por defecto";
        this.pauta = "Pauta por defecto";
        this.proxToma = "Próxima toma: --:--";

        iniInterfaz();
    }

    /**
     * Inicializa y configura los componentes visuales internos del panel (JLabels)
     * aplicando los colores corporativos y las fuentes definidas.
     */
    private void iniInterfaz() {
        this.setBackground(new Color(186, 209, 217)); 
        this.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;

        lblNombre = new JLabel(this.nomMedicamento);
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblNombre.setForeground(new Color(59, 106, 118)); 
        gbc.gridy = 0;
        this.add(lblNombre, gbc);

        lblPauta = new JLabel(this.pauta);
        lblPauta.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(4, 0, 0, 0);
        this.add(lblPauta, gbc);

        lblProximaToma = new JLabel(this.proxToma);
        lblProximaToma.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblProximaToma.setForeground(new Color(59, 106, 118));
        gbc.gridy = 2;
        this.add(lblProximaToma, gbc);
    }

    /**
     * Obtiene el nombre del medicamento actual.
     * 
     * @return el nombre del fármaco.
     */
    public String getNomMedicamento() {
        return nomMedicamento;
    }

    /**
     * Establece el nombre del medicamento, actualiza la vista y notifica a los observadores.
     * 
     * @param nuevoNombre el nuevo nombre del fármaco a mostrar.
     */
    public void setNomMedicamento(String nuevoNombre) {
        String valorAnterior = this.nomMedicamento;
        this.nomMedicamento = nuevoNombre;
        if (lblNombre != null) {
            lblNombre.setText(nuevoNombre);
        }
        // Usamos el método heredado de JPanel para notificar el cambio
        this.firePropertyChange(PROP_NOMBRE, valorAnterior, nuevoNombre);
        this.revalidate();
        this.repaint();
    }

    /**
     * Obtiene la pauta o frecuencia de toma actual.
     * 
     * @return la pauta configurada.
     */
    public String getPauta() {
        return pauta;
    }

    /**
     * Establece la pauta del medicamento, actualiza la vista y notifica a los observadores.
     * 
     * @param nuevaPauta la nueva frecuencia (ej. "Cada 8 horas").
     */
    public void setPauta(String nuevaPauta) {
        String valorAnterior = this.pauta;
        this.pauta = nuevaPauta;
        if (lblPauta != null) {
            lblPauta.setText(nuevaPauta);
        }
        this.firePropertyChange(PROP_PAUTA, valorAnterior, nuevaPauta);
        this.revalidate();
        this.repaint();
    }

    /**
     * Obtiene el texto descriptivo de la próxima toma.
     * 
     * @return el texto de la próxima toma.
     */
    public String getProxToma() {
        return proxToma;
    }

    /**
     * Establece la próxima toma, actualiza la vista y notifica a los observadores.
     * 
     * @param nuevaToma el nuevo texto (ej. "Próxima toma: 14:00").
     */
    public void setProxToma(String nuevaToma) {
        String valorAnterior = this.proxToma;
        this.proxToma = nuevaToma;
        if (lblProximaToma != null) {
            lblProximaToma.setText(nuevaToma);
        }
        this.firePropertyChange(PROP_PROXIMA_TOMA, valorAnterior, nuevaToma);
        this.revalidate();
        this.repaint();
    }
}