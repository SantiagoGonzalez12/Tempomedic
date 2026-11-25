package com.tempomedic.componentes

import java.awt.Color
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import java.io.Serializable
import javax.swing.JPasswordField
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

/**
 * Componente visual reutilizable para verificar que una contraseña coincide.
 *
 * @author María Dolores Barba López
 * @version 1.0
 */
class VerificarPassword : JPasswordField(), Serializable {

    companion object {
        /** Constante para notificar cambios. */
        const val PROP_VERIFICACION = "verificacionCorrecta"

        /** Constante para notificar el cambio de la propiedad original. */
        const val PROP_PASSWORD_ORIGINAL = "passwordOriginal"

        /** Texto por defecto del campo. */
        private const val TEXTO_POR_DEFECTO = "Repetir contraseña"

        /** Color de fondo por defecto. */
        private val COLOR_FONDO = Color(186, 209, 217)

        /** Color de fondo cuando el campo tiene el foco. */
        private val COLOR_FOCO = Color.WHITE

        /** Color de fondo cuando hay un error. */
        private val COLOR_ERROR = Color(255, 204, 204)
    }

    /** Almacena la contraseña original con la que se compara. */
    var passwordOriginal: String = ""
        set(value) {
            val anterior = field
            field = value

            // Si hay texto, re-verificar inmediatamente
            checkMatch()

            firePropertyChange(PROP_PASSWORD_ORIGINAL, anterior, value)
        }

    /** Indica si la verificación es correcta. */
    @get:JvmName("isVerificacionCorrecta")
    var verificacionCorrecta: Boolean = false
        private set

    /** Indica si el campo está vacío. */
    private var textoPorDefecto: Boolean = true

    init {
        inicializarComponente()
    }

    /**
     * Configura la interfaz y los escuchadores.
     */
    private fun inicializarComponente() {
        background = COLOR_FONDO
        foreground = Color.BLACK
        echoChar = '•'
        text = TEXTO_POR_DEFECTO
        echoChar = 0.toChar()

        // Escuchador comprueba en tiempo real mientras se escribe
        document.addDocumentListener(object : DocumentListener {
            override fun insertUpdate(e: DocumentEvent) = checkMatch()
            override fun removeUpdate(e: DocumentEvent) = checkMatch()
            override fun changedUpdate(e: DocumentEvent) = checkMatch()
        })

        addFocusListener(object : FocusListener {
            override fun focusGained(e: FocusEvent) {
                if (textoPorDefecto) {
                    text = ""
                    echoChar = '•'
                    textoPorDefecto = false
                }
                background = COLOR_FOCO
            }

            override fun focusLost(e: FocusEvent) {
                val textoActual = String(password)
                if (textoActual.isEmpty()) {
                    text = TEXTO_POR_DEFECTO
                    echoChar = 0.toChar()
                    textoPorDefecto = true
                    updateVerificacion(false)
                    background = COLOR_FONDO
                } else {
                    checkMatch()
                }
            }
        })
    }

    /**
     * Comprueba si el texto actual coincide con la contraseña original.
     */
    private fun checkMatch() {
        if (textoPorDefecto) return

        val textoActual = String(password)
        if (textoActual.isEmpty()) return

        if (textoActual == passwordOriginal && passwordOriginal.isNotEmpty()) {
            updateVerificacion(true)
            background = COLOR_FONDO
        } else {
            updateVerificacion(false)
            background = COLOR_ERROR
        }
    }

    /**
     * Actualiza el estado y notifica a los escuchadores.
     *
     * @param estado el nuevo estado de verificación.
     */
    private fun updateVerificacion(estado: Boolean) {
        val anterior = verificacionCorrecta
        verificacionCorrecta = estado
        firePropertyChange(PROP_VERIFICACION, anterior, verificacionCorrecta)
    }
}