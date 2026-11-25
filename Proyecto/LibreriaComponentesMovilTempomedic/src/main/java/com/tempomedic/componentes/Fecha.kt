package com.tempomedic.componentes

import java.awt.Color
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import java.io.Serializable
import java.text.ParseException
import java.text.SimpleDateFormat
import javax.swing.JTextField
import javax.swing.text.AbstractDocument
import javax.swing.text.AttributeSet
import javax.swing.text.BadLocationException
import javax.swing.text.DocumentFilter
import javax.swing.text.SimpleAttributeSet

/**
 * Componente visual reutilizable para introducir una fecha (dd/mm/aaaa).
 *
 * @author Alba Durán Bernal
 * @version 1.0
 */
class Fecha : JTextField(), Serializable {

    companion object {
        /** Constante para notificar cambios en la fecha. */
        const val PROP_FECHA = "fecha"

        /** Texto por defecto del campo. */
        private const val TEXTO_POR_DEFECTO = "dd/mm/aaaa"

        /** Expresión regular para validar el formato básico dd/mm/aaaa. */
        private val REGEX_FECHA = Regex("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")

        /** Regex auxiliar para permitir solo dígitos y barras en el filtro. */
        private val REGEX_SOLO_NUMEROS_Y_BARRAS = Regex("[0-9/]*")
    }

    /** Color de fondo por defecto. */
    private val COLOR_FONDO = Color(186, 209, 217)

    /** Color de fondo cuando el campo tiene el foco. */
    private val COLOR_FOCO: Color = Color.WHITE

    /** Color de fondo cuando hay un error. */
    private val COLOR_ERROR = Color(255, 204, 204)

    /** Indica si el campo está mostrando el texto por defecto. */
    private var textoPorDefecto: Boolean = true

    /** Almacena la fecha validada en formato dd/mm/yyyy. */
    var fecha: String? = ""
        set(value) {
            val fechaAnterior = field
            field = value
            val esVacio = value.isNullOrEmpty()
            text = if (esVacio) TEXTO_POR_DEFECTO else value
            textoPorDefecto = esVacio
            firePropertyChange(PROP_FECHA, fechaAnterior, field)
        }

    init {
        inicializarComponente()
    }

    /**
     * Configura la interfaz y los eventos.
     */
    private fun inicializarComponente() {
        text = TEXTO_POR_DEFECTO
        background = COLOR_FONDO
        foreground = Color.BLACK

        // Filtro evita letras, limita a 10 caracteres y autopone barras
        (document as AbstractDocument).documentFilter = object : DocumentFilter() {

            override fun insertString(
                fb: FilterBypass,
                offset: Int,
                string: String?,
                attr: AttributeSet?
            ) {
                replace(fb, offset, 0, string, attr)
            }

            override fun replace(
                fb: FilterBypass,
                offset: Int,
                length: Int,
                text: String?,
                attrs: AttributeSet?
            ) {
                try {
                    if (text == null) return

                    var currentText = fb.document.getText(0, fb.document.length)
                    val newText = currentText.substring(0, offset) + text +
                            currentText.substring(offset + length)

                    if (!REGEX_SOLO_NUMEROS_Y_BARRAS.matches(newText) || newText.length > 10) {
                        return
                    }

                    super.replace(fb, offset, length, text, attrs)

                    // Autoformateo de barras
                    currentText = fb.document.getText(0, fb.document.length)
                    if (currentText.length == 2 && !currentText.contains("/")) {
                        super.insertString(fb, 2, "/", SimpleAttributeSet())
                    } else if (currentText.length == 5 && currentText.count { it == '/' } == 1) {
                        super.insertString(fb, 5, "/", SimpleAttributeSet())
                    }
                } catch (ex: BadLocationException) {
                    System.getLogger(Fecha::class.java.name).log(
                        System.Logger.Level.ERROR,
                        null as String?,
                        ex
                    )
                }
            }
        }

        addFocusListener(object : FocusListener {
            override fun focusGained(e: FocusEvent) {
                if (textoPorDefecto) {
                    text = ""
                    textoPorDefecto = false
                }
                background = COLOR_FOCO
            }

            override fun focusLost(e: FocusEvent) {
                if (text.isEmpty()) {
                    text = TEXTO_POR_DEFECTO
                    textoPorDefecto = true
                    fecha = ""
                    background = COLOR_FONDO
                } else {
                    validarYFormatear()
                }
            }
        })
    }

    /**
     * Valida la fecha con Regex y comprobación estricta de calendario.
     */
    private fun validarYFormatear() {
        val textoActual = text.trim()

        if (REGEX_FECHA.matches(textoActual)) {
            try {
                // Valida si la fecha existe
                val sdf = SimpleDateFormat("dd/MM/yyyy").apply {
                    isLenient = false
                }
                sdf.parse(textoActual)

                // Valida un rango de años lógico (1900 - 2100)
                val year = textoActual.substring(6).toInt()
                if (year !in 1900..2100) {
                    marcarError()
                    return
                }

                val fechaAnterior = this.fecha
                this.fecha = textoActual
                background = COLOR_FONDO
                firePropertyChange(PROP_FECHA, fechaAnterior, this.fecha)
            } catch (ex: Exception) {
                if (ex is ParseException || ex is NumberFormatException) {
                    marcarError() // Si el día no existe o el año falla
                } else {
                    throw ex
                }
            }
        } else {
            marcarError()
        }

        revalidate()
        repaint()
    }

    /**
     * Marca el componente en rojo cuando hay un error.
     */
    private fun marcarError() {
        background = COLOR_ERROR
        this.fecha = ""
        firePropertyChange(PROP_FECHA, "", "")
    }
}