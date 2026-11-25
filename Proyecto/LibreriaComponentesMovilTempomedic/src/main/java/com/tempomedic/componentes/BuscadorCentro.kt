package com.tempomedic.componentes

import java.awt.BorderLayout
import java.awt.Color
import java.awt.Font
import java.io.Serializable
import javax.swing.BorderFactory
import javax.swing.DefaultListModel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextField
import javax.swing.ListSelectionModel
import javax.swing.border.LineBorder
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

/**
 * Componente visual reutilizable que combina un campo de texto y una lista para
 * buscar y seleccionar un centro médico o dirección.
 *
 * Filtra la lista de centros en tiempo real a medida que el usuario escribe.
 *
 * @author Alba Duran Bernal
 * @version 1.0
 */
class BuscadorCentro : JPanel(), Serializable {

    companion object {
        /** Constante para notificar cambios en el centro seleccionado. */
        const val PROP_CENTRO_SELECCIONADO = "centroSeleccionado"

        /** Color de fondo de los componentes. */
        private val COLOR_FONDO = Color(186, 209, 217)
    }

    /** Campo de texto para escribir y filtrar. */
    private lateinit var txtBusqueda: JTextField

    /** Lista visual con los centros disponibles. */
    private lateinit var listaCentros: JList<String>

    /** Modelo de datos que contiene todos los centros. */
    private lateinit var modeloLista: DefaultListModel<String>

    /** Array con los centros por defecto. */
    private val centrosPorDefecto = arrayOf(
        "Hospital Virgen del Rocío",
        "Hospital Virgen Macarena",
        "Hospital Quirónsalud Sagrado Cora",
        "Hospital San Juan de Dios",
        "Hospital Duques del Infantado",
        "Hospital Doctor Muñoz Cariñanos",
        "Hospital Quirónsalud Infanta Luisa",
        "Hospital San Lázaro"
    )

    /** Almacena el texto del centro seleccionado. */
    var centroSeleccionado: String? = ""
        set(value) {
            val anterior = field
            field = value

            if (value != null) {
                txtBusqueda.text = value
                // Intentamos seleccionarlo en la lista si existe
                listaCentros.setSelectedValue(value, true)
            } else {
                txtBusqueda.text = ""
                listaCentros.clearSelection()
            }

            firePropertyChange(PROP_CENTRO_SELECCIONADO, anterior, value)
        }

    init {
        inicializarComponente()
    }

    /**
     * Configura la interfaz gráfica y los eventos del componente.
     */
    private fun inicializarComponente() {
        layout = BorderLayout(0, 5) // 5px de separación entre campo y lista
        isOpaque = false // Hereda el color de fondo del contenedor padre

        // Configuraciones
        // Campo de texto
        txtBusqueda = JTextField().apply {
            background = COLOR_FONDO
            font = Font("SansSerif", Font.PLAIN, 14)
            border = BorderFactory.createCompoundBorder(
                LineBorder(Color.BLACK, 2, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        }

        // Modelo de la lista
        modeloLista = DefaultListModel<String>().apply {
            centrosPorDefecto.forEach { addElement(it) }
        }

        // Lista visual
        listaCentros = JList(modeloLista).apply {
            background = COLOR_FONDO
            font = Font("SansSerif", Font.PLAIN, 14)
            selectionMode = ListSelectionModel.SINGLE_SELECTION
            visibleRowCount = 3
        }

        val scrollPane = JScrollPane(listaCentros).apply {
            border = BorderFactory.createLineBorder(Color.BLACK, 2)
        }

        // Añadir al panel
        add(txtBusqueda, BorderLayout.NORTH)
        add(scrollPane, BorderLayout.CENTER)

        // Eventos
        // Filtración en tiempo real
        txtBusqueda.document.addDocumentListener(object : DocumentListener {
            override fun insertUpdate(e: DocumentEvent) = filtrarLista()
            override fun removeUpdate(e: DocumentEvent) = filtrarLista()
            override fun changedUpdate(e: DocumentEvent) = filtrarLista()
        })

        // Selección de lista (SAM conversion / lambda)
        listaCentros.addListSelectionListener { e ->
            if (!e.valueIsAdjusting) {
                val seleccionado = listaCentros.selectedValue
                if (seleccionado != null) {
                    txtBusqueda.text = seleccionado
                    // Notificar cambio a Matisse
                    val anterior = centroSeleccionado
                    centroSeleccionado = seleccionado
                    firePropertyChange(PROP_CENTRO_SELECCIONADO, anterior, centroSeleccionado)
                }
            }
        }
    }

    /**
     * Filtra los elementos de la lista según el texto introducido en el campo
     * de búsqueda.
     */
    private fun filtrarLista() {
        val texto = txtBusqueda.text.lowercase().trim()
        modeloLista.clear()

        val filtrados = if (texto.isEmpty()) {
            centrosPorDefecto.toList()
        } else {
            centrosPorDefecto.filter { it.lowercase().contains(texto) }
        }

        filtrados.forEach { modeloLista.addElement(it) }

        // Si solo queda un elemento y coincide exactamente, se selecciona
        if (modeloLista.size == 1) {
            listaCentros.selectedIndex = 0
        }
    }

    /**
     * Permite añadir nuevos centros a la lista programáticamente.
     *
     * @param nuevoCentro el nombre del nuevo centro a añadir.
     */
    fun agregarCentro(nuevoCentro: String) {
        if (nuevoCentro.isNotEmpty()) {
            modeloLista.addElement(nuevoCentro)
        }
    }
}