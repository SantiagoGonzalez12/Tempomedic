package com.tempomedic.componentes

import java.awt.Color
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import java.io.Serializable
import javax.swing.JTextField

/**
 * Componente visual reutilizable para introducir y validar una dirección de
 * correo electrónico.
 *
 * Valida que el formato del correo sea correcto utilizando expresiones
 * regulares.
 *
 * @author Alba Duran Bernal
 * @version 1.0
 */
class Correo : JTextField(), Serializable {

    companion object {
        /** Constante para notificar cambios en el correo. */
        const val PROP_CORREO = "correo"

        /** Color de fondo por defecto. */
        private val COLOR_FONDO = Color(186, 209, 217)

        /** Color de fondo cuando el campo tiene el foco. */
        private val COLOR_FOCO: Color = Color.WHITE

        /** Color de fondo cuando hay un error. */
        private val COLOR_ERROR = Color(255, 204, 204)

        /** Texto por defecto del campo. */
        private const val TEXTO_POR_DEFECTO = "nombre@correo.com"

        /**
         * Expresión regular para validar el correo. Exige: Texto + @ + Texto + . +
         * al menos 2 letras.
         */
        private val REGEX_CORREO = Regex(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            RegexOption.IGNORE_CASE
        )
    }

    /** Indica si el campo está mostrando el texto por defecto. */
    private var textoPorDefecto: Boolean = true

    /** Almacena el correo validado. */
    var correo: String? = ""
        set(value) {
            val correoAnterior = field
            field = value
            val esVacio = value.isNullOrEmpty()
            text = if (esVacio) TEXTO_POR_DEFECTO else value
            textoPorDefecto = esVacio
            firePropertyChange(PROP_CORREO, correoAnterior, field)
        }

    init {
        inicializarComponente()
    }

    /**
     * Configura la interfaz gráfica y los escuchadores de eventos.
     */
    private fun inicializarComponente() {
        text = TEXTO_POR_DEFECTO
        background = COLOR_FONDO // Azul claro
        foreground = Color.BLACK
        horizontalAlignment = LEFT

        addFocusListener(object : FocusListener {
            override fun focusGained(e: FocusEvent) {
                if (textoPorDefecto) {
                    text = ""
                    textoPorDefecto = false
                }
                background = COLOR_FOCO
            }

            override fun focusLost(e: FocusEvent) {
                val textoActual = text.trim()

                if (textoActual.isEmpty()) {
                    text = TEXTO_POR_DEFECTO
                    textoPorDefecto = true
                    correo = ""
                    background = COLOR_FONDO
                } else {
                    validarCorreo(textoActual)
                }
            }
        })
    }

    /**
     * Valida el formato del correo utilizando la expresión regular.
     *
     * @param textoActual el correo introducido por el usuario.
     */
    private fun validarCorreo(textoActual: String) {
        if (REGEX_CORREO.matches(texto