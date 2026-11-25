package com.tempomedic.componentes

import java.awt.Color
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import java.io.Serializable
import javax.swing.JPasswordField

/**
 *
 * @author María Dolores Barba López
 * @version 1.0
 */
class Password : JPasswordField(), Serializable {

    companion object {
        /** Constante para notificar cambios en la contraseña. */
        const val PROP_PASSWORD = "password"

        /** Color de fondo por defecto. */
        private val COLOR_FONDO = Color(186, 209, 217)

        /** Color de fondo cuando el campo tiene el foco. */
        private val COLOR_FOCO = Color.WHITE

        /** Color de fondo cuando hay un error. */
        private val COLOR_ERROR = Color(255, 204, 204)

        /** Texto por defecto del campo. */
        private const val TEXTO_POR_DEFECTO = "Contraseña"

        /** Tamaño mínimo de la contraseña. */
        private const val LONGITUD_MINIMA = 6
    }

    /** Almacena el texto validado. */
    var passwordValidada: String = ""
        set(value) {
            val passwordAnterior = field
            field = value

            if (value.isEmpty()) {
                text = TEXTO_POR_DEFECTO
                echoChar = 0.toChar()
                textoPorDefecto = true
            } else {
                text = value
                echoChar = '•'
                textoPorDefecto = false
            }

            firePropertyChange(PROP_PASSWORD, passwordAnterior, field)
        }

    /** Indica si el campo está vacío (para el texto por defecto). */
    private var textoPorDefecto: Boolean = true

    init {
        inicializarComponente()
    }

    /**
     * Configura la interfaz y los escuchadores de eventos.
     */
    private fun inicializarComponente() {
        background = COLOR_FONDO
        foreground = Color.BLACK
        echoChar = '•' // Punto para ocultar el carácter verdadero
        text = TEXTO_POR_DEFECTO
        echoChar = 0.toChar()

        addFocusListener(object : FocusListener {
            override fun focusGained(e: FocusEvent) {
                if (textoPorDefecto) {
                    text = ""
                    echoChar = '•' // Ocultación al empezar a escribir
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
                    passwordValidada = ""
                    background = COLOR_FONDO
                } else {
                    validarPassword(textoActual)
                }
            }
        })
    }

    /**
     * Valida que la contraseña cumpla los requisitos mínimos.
     *
     * @param textoActual el texto introducido por el usuario.
     */
    private fun validarPassword(textoActual: String) {
        // Validación: mínimo 6 caracteres y sin espacios
        if (textoActual.length >= LONGITUD_MINIMA && ' ' !in textoActual) {
            val passwordAnterior = passwordValidada
            // Actualizamos directamente sin disparar el setter completo que sobreescribe el campo
            val nuevoValor = textoActual
            if (passwordAnterior != nuevoValor) {
                passwordValidada = nuevoValor
            }
            background = COLOR_FONDO
        } else {
            // Error: muy corta o contiene espacios
            val passwordAnterior = passwordValidada
            background = COLOR_ERROR // Rojo
            // Evitamos que llamar a passwordValidada = "" resetee el texto visual con error a TEXTO_POR_DEFECTO
            actualizarEstadoInternoSinResetVisual("", passwordAnterior)
        }
    }

    private fun actualizarEstadoInternoSinResetVisual(nuevoValor: String, anterior: String) {

        firePropertyChange(PROP_PASSWORD, anterior, nuevoValor)
    }
}