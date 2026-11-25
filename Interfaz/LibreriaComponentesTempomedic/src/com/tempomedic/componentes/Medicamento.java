package com.tempomedic.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Componente visual reutilizable que representa una tarjeta de medicamento interactiva.
 * <p>
 * Muestra el nombre, la dosis, la hora y la frecuencia. Incluye un sistema 
 * de "semáforo" con botones para marcar la toma como Tomada, Pospuesta u Omitida.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class Medicamento extends JPanel implements Serializable {

    /** Constante para notificar cambios en el estado del medicamento. */
    public static final String PROP_ESTADO = "estado";
    /** Constante para notificar cambios en los datos del medicamento. */
    public static final String PROP_DATOS = "datos";

    /** Estado: La toma está pendiente. */
    public static final String ESTADO_PENDIENTE = "Pendiente";
    /** Estado: La toma se ha tomado. */
    public static final String ESTADO_TOMADA = "Tomada";
    /** Estado: La toma se ha pospuesto. */
    public static final String ESTADO_POSPUESTA = "Pospuesta";
    /** Estado: La toma se ha omitido. */
    public static final String ESTADO_OMITIDA = "Omitida";

    /** Color de fondo de la tarjeta. */
    private static final Color COLOR_FONDO = new Color(186, 209, 217);
    /** Color del texto principal. */
    private static final Color COLOR_TEXTO = new Color(59, 106, 118);
    /** Color verde para el estado "Tomada". */
    private static final Color COLOR_VERDE = new Color(37, 133, 61);
    /** Color naranja/amarillo para "Pendiente" o "Pospuesta". */
    private static final Color COLOR_NARANJA = new Color(255, 140, 26);
    /** Color rojo para "Omitida". */
    private static final Color COLOR_ROJO = new Color(234, 0, 4);

    /** Etiqueta para el título del medicamento. */
    private JLabel lblTitulo;
    /** Etiqueta para mostrar el estado actual (semáforo). */
    private JLabel lblEstado;
    /** Panel que contiene los botones de acción. */
    private JPanel pnlBotones;
    /** Botón para marcar como Tomada. */
    private JButton btnTomada;
    /** Botón para posponer la toma. */
    private JButton btnPosponer;
    /** Botón para marcar como Omitida. */
    private JButton btnOmitida;

    /** Nombre del medicamento. */
    private String nombreMedicamento;
    /** Dosis del medicamento. */
    private String dosis;
    /** Hora de la toma. */
    private String hora;
    /** Frecuencia de la toma. */
    private String frecuencia;
    /** Estado actual del medicamento. */
    private String estado;

    /**
     * Constructor por defecto requerido por JavaBeans.
     */
    public Medicamento() {
        this.nombreMedicamento = "Nombre";
        this.dosis = "0 mg";
        this.hora = "00:00";
        this.frecuencia = "";
        this.estado = ESTADO_PENDIENTE;
        inicializarComponente();
    }

    /**
     * Configura la interfaz gráfica y los eventos del componente.
     */
    private void inicializarComponente() {
        this.setLayout(new BorderLayout(5, 5));
        this.setBackground(COLOR_FONDO);
        this.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));

        //Panel superior para los textos
        JPanel pnlTextos = new JPanel(new GridLayout(2, 1, 0, 2));
        pnlTextos.setOpaque(false);

        lblTitulo = new JLabel();
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setForeground(COLOR_TEXTO);

        lblEstado = new JLabel();
        lblEstado.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        pnlTextos.add(lblTitulo);
        pnlTextos.add(lblEstado);

        //Panel inferior para los botones
        pnlBotones = new JPanel(new GridLayout(1, 3, 10, 0));
        pnlBotones.setOpaque(false);

        btnTomada = crearBoton("Tomada");
        btnPosponer = crearBoton("Posponer");
        btnOmitida = crearBoton("Omitida");

        pnlBotones.add(btnTomada);
        pnlBotones.add(btnPosponer);
        pnlBotones.add(btnOmitida);

        //Añadir al panel principal
        this.add(pnlTextos, BorderLayout.NORTH);
        this.add(pnlBotones, BorderLayout.SOUTH);

        //Eventos de botones
        btnTomada.addActionListener(e -> setEstado(ESTADO_TOMADA));
        btnPosponer.addActionListener(e -> setEstado(ESTADO_POSPUESTA));
        btnOmitida.addActionListener(e -> setEstado(ESTADO_OMITIDA));

        //Actualizar vista inicial
        actualizarVista();
    }

    /**
     * Método auxiliar para crear los botones con el mismo estilo.
     * 
     * @param texto el texto del botón.
     * @return el botón configurado.
     */
    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setForeground(COLOR_TEXTO);
        btn.setContentAreaFilled(false);
        btn.setBorder(BorderFactory.createLineBorder(COLOR_TEXTO, 2, true));
        btn.setFocusPainted(false);
        return btn;
    }

    /**
     * Actualiza el título y el estado visual (color y visibilidad de botones) 
     * basándose en las propiedades actuales.
     */
    private void actualizarVista() {
        //Actualizar título
        String titulo = nombreMedicamento + " " + dosis + " - " + hora;
        lblTitulo.setText(titulo);

        //Actualizar semáforo
        if (ESTADO_TOMADA.equals(estado)) {
            lblEstado.setText(ESTADO_TOMADA);
            lblEstado.setForeground(COLOR_VERDE);
            pnlBotones.setVisible(false); //Se ocultan los botones
        } else if (ESTADO_POSPUESTA.equals(estado)) {
            lblEstado.setText("- " + ESTADO_POSPUESTA);
            lblEstado.setForeground(COLOR_NARANJA);
            pnlBotones.setVisible(true); //Se muestran los botones
        } else if (ESTADO_OMITIDA.equals(estado)) {
            lblEstado.setText("- " + ESTADO_OMITIDA);
            lblEstado.setForeground(COLOR_ROJO);
            pnlBotones.setVisible(true); //Se muestran los botones
        } else {
            //Estado por defecto (Pendiente)
            lblEstado.setText("- " + ESTADO_PENDIENTE);
            lblEstado.setForeground(COLOR_NARANJA);
            pnlBotones.setVisible(true);
        }

        this.revalidate();
        this.repaint();
    }

    //Getters y Setters

    /**
     * Obtiene el nombre del medicamento.
     * 
     * @return el nombre del medicamento.
     */
    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    /**
     * Establece el nombre del medicamento.
     * 
     * @param nombreMedicamento el nuevo nombre.
     */
    public void setNombreMedicamento(String nombreMedicamento) {
        String anterior = this.nombreMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        actualizarVista();
        this.firePropertyChange(PROP_DATOS, anterior, nombreMedicamento);
    }

    /**
     * Obtiene la dosis del medicamento.
     * 
     * @return la dosis.
     */
    public String getDosis() {
        return dosis;
    }

    /**
     * Establece la dosis del medicamento.
     * 
     * @param dosis la nueva dosis.
     */
    public void setDosis(String dosis) {
        String anterior = this.dosis;
        this.dosis = dosis;
        actualizarVista();
        this.firePropertyChange(PROP_DATOS, anterior, dosis);
    }

    /**
     * Obtiene la hora de la toma.
     * 
     * @return la hora.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora de la toma.
     * 
     * @param hora la nueva hora.
     */
    public void setHora(String hora) {
        String anterior = this.hora;
        this.hora = hora;
        actualizarVista();
        this.firePropertyChange(PROP_DATOS, anterior, hora);
    }

    /**
     * Obtiene la frecuencia de la toma.
     * 
     * @return la frecuencia.
     */
    public String getFrecuencia() {
        return frecuencia;
    }

    /**
     * Establece la frecuencia de la toma.
     * 
     * @param frecuencia la nueva frecuencia.
     */
    public void setFrecuencia(String frecuencia) {
        String anterior = this.frecuencia;
        this.frecuencia = frecuencia;
        actualizarVista();
        this.firePropertyChange(PROP_DATOS, anterior, frecuencia);
    }

    /**
     * Obtiene el estado actual del medicamento.
     * 
     * @return el estado actual.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del medicamento y actualiza el semáforo.
     * 
     * @param estado el nuevo estado (Pendiente, Tomada, Pospuesta, Omitida).
     */
    public void setEstado(String estado) {
        String anterior = this.estado;
        this.estado = estado;
        actualizarVista();
        this.firePropertyChange(PROP_ESTADO, anterior, estado);
    }
}