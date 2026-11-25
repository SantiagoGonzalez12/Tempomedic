package com.tempomedic.componentes

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.GridLayout
import java.awt.event.FocusAdapter
import java.awt.event.FocusEvent
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.io.Serializable
import javax.swing.BorderFactory
import javax.swing.JPanel
import javax.swing.JTextField

/**
 *
 * @author María Dolores Barba López
 * @version 1.0
 */
class Pin : JPanel(), Serializable {

    companion object {
        /** Constante para notificar cambios en el PIN. */
        const val PROP_PIN = "pin"

        /** Color de fondo de las cajas. */
        private val COLOR_FONDO = Color(186, 209, 217)

        /** Color de fondo cuando la caja tiene el foco. */
        private val COLOR_FOCO = Color.WHITE
    }

    /** Lista con las 4 cajas de texto. */
    private lateinit var cajas: List<JTextField>

    /** Almacena el PIN completo (4 dígitos). */
    var pin: String = ""
        set(value) {
            val pinAnterior = field

            if (value.length != 4) {
                // Si PIN no válido, se vacían las cajas
                cajas.forEach { it.text = "" }
                field = ""
            } else {
                // Relleno de cajas una a una
                field = value
                cajas.forEachIndexed { i, caja ->
                    caja.text = value[i].toString()
                }
            }

            firePropertyChange(PROP_PIN, pinAnterior, field)
        }

    init {
        inicializarComponente()
    }

    /**
     * Configura la interfaz gráfica creando las 4 cajas y sus eventos.
     */
    private fun inicializarComponente() {
        // Uso de GridLayout para poner 4 cajas en horizontal con 14px de separación
        layout = GridLayout(1, 4, 14, 0)
        isOpaque = false // El fondo lo ponen las cajas individuales

        cajas = List(4) { index ->
            JTextField().apply {
                horizontalAlignment = JTextField.CENTER
                font = Font("SansSerif", Font.BOLD, 24)
                background = COLOR_FONDO
                foreground = Color.BLACK
                border = BorderFactory.createLineBorder(Color.BLACK, 2, true)
                preferredSize = Dimension(64, 72) // Tamaño cuadrado

                // Restricción de teclado y salto automático
                addKeyListener(object : KeyAdapter() {
                    override fun keyTyped(e: KeyEvent) {
                        val c = e.keyChar
                        when {
                            // Se ignora todo carácter que no sea numérico
                            !c.isDigit() -> e.consume()
                            // Si hay un número escrito, se reemplaza
                            text.isNotEmpty() -> text = ""
                        }
                    }

                    override fun keyReleased(e: KeyEvent) {
                        when {
                            // Si se pulsa Borrar en una caja vacía, se vuelve a la anterior
                            e.keyCode == KeyEvent.VK_BACK_SPACE -> {
                                if (text.isEmpty() && index > 0) {
                                    cajas[index - 1].requestFocus()
                                }
                            }
                            // Si se escribe un número, se salta a la siguiente caja
                            e.keyChar.isDigit() -> {
                                if (index < 3) {
                                    cajas[index + 1].requestFocus()
                                }
                            }
                        }
                        actualizarPIN()
                    }
                })

                // Selección de texto al recibir el foco
                addFocusListener(object : FocusAdapter() {
                    override fun focusGained(e: FocusEvent) {
                        selectAll()
                        background = COLOR_FOCO // Se ilumina al escribir
                    }

                    override fun focusLost(e: FocusEvent) {
                        background = COLOR_FONDO
                    }
                })
            }.also { add(it) }
        }
    }

    /**
     * Reconstruye el PIN a partir de las 4 cajas y notifica el cambio si es necesario.
     */
    private fun actualizarPIN() {
        val completo = cajas.all { it.text.isNotEmpty() }
        val pinAnterior = pin

        val nuevoPin = if (completo) cajas.joinToString("") { it.text } else ""
        if (pinAnterior != nuevoPin) {
            pin = nuevoPin
        }
    }
}