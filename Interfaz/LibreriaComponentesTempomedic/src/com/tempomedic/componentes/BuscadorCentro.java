package com.tempomedic.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Componente visual reutilizable que combina un campo de texto y una lista 
 * para buscar y seleccionar un centro médico o dirección.
 * <p>
 * Filtra la lista de centros en tiempo real a medida que el usuario escribe.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class BuscadorCentro extends JPanel implements Serializable {

    /** Constante para notificar cambios en el centro seleccionado. */
    public static final String PROP_CENTRO_SELECCIONADO = "centroSeleccionado";

    /** Campo de texto para escribir y filtrar. */
    private JTextField txtBusqueda;
    
    /** Lista visual con los centros disponibles. */
    private JList<String> listaCentros;
    
    /** Modelo de datos que contiene todos los centros (filtrados o no). */
    private DefaultListModel<String> modeloLista;
    
    /** Almacena el texto del centro finalmente seleccionado. */
    private String centroSeleccionado;

    /** Array con los centros por defecto (puedes ampliarlo). */
    private final String[] centrosPorDefecto = {
        "Hospital Virgen del Rocío", 
        "Hospital Virgen Macarena", 
        "Hospital Quirónsalud Sagrado Cora",
        "Hospital San Juan de Dios",
        "Hospital Duques del Infantado",
        "Hospital Doctor Muñoz Cariñanos",
        "Hospital Quirónsalud Infanta Luisa",
        "Hospital San Lázaro"
    };

    /**
     * Constructor por defecto requerido por JavaBeans.
     */
    public BuscadorCentro() {
        this.centroSeleccionado = "";
        inicializarComponente();
    }

    /**
     * Configura la interfaz gráfica y los eventos del componente.
     */
    private void inicializarComponente() {
        this.setLayout(new BorderLayout(0, 5)); // 5px de separación entre campo y lista
        this.setOpaque(false); // Hereda el color de fondo del contenedor padre

        // 1. Configurar el campo de texto
        txtBusqueda = new JTextField();
        txtBusqueda.setBackground(new Color(186, 209, 217));
        txtBusqueda.setFont(new java.awt.Font("SansSerif", 0, 14));
        txtBusqueda.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(Color.BLACK, 2, true),
                javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        // 2. Configurar el modelo de la lista
        modeloLista = new DefaultListModel<>();
        for (String centro : centrosPorDefecto) {
            modeloLista.addElement(centro);
        }

        // 3. Configurar la lista visual
        listaCentros = new JList<>(modeloLista);
        listaCentros.setBackground(new Color(186, 209, 217));
        listaCentros.setFont(new java.awt.Font("SansSerif", 0, 14));
        listaCentros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCentros.setVisibleRowCount(3); // Mostrar 3 filas

        JScrollPane scrollPane = new JScrollPane(listaCentros);
        scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2));

        // 4. Añadir al panel
        this.add(txtBusqueda, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        // 5. EVENTOS: Filtrado en tiempo real
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { filtrarLista(); }
            @Override
            public void removeUpdate(DocumentEvent e) { filtrarLista(); }
            @Override
            public void changedUpdate(DocumentEvent e) { filtrarLista(); }
        });

        // 6. EVENTOS: Selección de la lista
        listaCentros.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String seleccionado = listaCentros.getSelectedValue();
                    if (seleccionado != null) {
                        // Ponemos el texto en el campo de búsqueda
                        txtBusqueda.setText(seleccionado);
                        // Notificamos el cambio a Matisse
                        String anterior = centroSeleccionado;
                        centroSeleccionado = seleccionado;
                        firePropertyChange(PROP_CENTRO_SELECCIONADO, anterior, centroSeleccionado);
                    }
                }
            }
        });
    }

    /**
     * Filtra los elementos de la lista según el texto introducido en el campo de búsqueda.
     */
    private void filtrarLista() {
        String texto = txtBusqueda.getText().toLowerCase().trim();
        modeloLista.clear();

        if (texto.isEmpty()) {
            // Si está vacío, mostramos todos
            for (String centro : centrosPorDefecto) {
                modeloLista.addElement(centro);
            }
        } else {
            // Si hay texto, filtramos
            for (String centro : centrosPorDefecto) {
                if (centro.toLowerCase().contains(texto)) {
                    modeloLista.addElement(centro);
                }
            }
        }

        // Si solo queda un elemento y coincide exactamente, lo seleccionamos
        if (modeloLista.getSize() == 1) {
            listaCentros.setSelectedIndex(0);
        }
    }

    /**
     * Obtiene el centro actualmente seleccionado.
     * 
     * @return el nombre del centro o cadena vacía si no hay ninguno.
     */
    public String getCentroSeleccionado() {
        return centroSeleccionado;
    }

    /**
     * Establece el centro manualmente (útil para inicializar el componente o 
     * para rellenarlo desde la base de datos).
     * 
     * @param centro el nombre del centro a seleccionar.
     */
    public void setCentroSeleccionado(String centro) {
        String anterior = this.centroSeleccionado;
        this.centroSeleccionado = centro;
        
        if (centro != null) {
            txtBusqueda.setText(centro);
            // Intentamos seleccionarlo en la lista si existe
            listaCentros.setSelectedValue(centro, true);
        } else {
            txtBusqueda.setText("");
            listaCentros.clearSelection();
        }
        
        firePropertyChange(PROP_CENTRO_SELECCIONADO, anterior, centro);
    }

    /**
     * Permite añadir nuevos centros a la lista programáticamente.
     * 
     * @param nuevoCentro el nombre del nuevo centro a añadir.
     */
    public void agregarCentro(String nuevoCentro) {
        if (!nuevoCentro.isEmpty()) {
            modeloLista.addElement(nuevoCentro);
        }
    }
}