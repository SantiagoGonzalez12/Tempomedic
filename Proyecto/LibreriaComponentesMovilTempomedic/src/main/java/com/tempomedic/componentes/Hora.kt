package com.tempomedic.componentes

import java.awt.Color
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import java.io.Serializable
import javax.swing.JTextField
import javax.swing.text.AbstractDocument
import javax.swing.text.AttributeSet
import javax.swing.text.BadLocationException
import javax.swing.text.DocumentFilter
import javax.swing.text.SimpleAttributeSet

/**
 * Componente visual reutilizable para introducir una hora.
 *
 * Valida el formato HH:mm, autoformatea la entrada añadiendo los dos puntos y
 * restringe la escritura únicamente a caracteres numéricos.
 *
 * @author Alba Durán Bernal
 * @version 1.0
 */
class Hora : JTextField(), Serializable {

    companion object {
        /** Constante para notificar cambios en la hora. */
        const val PROP_HORA = "hora"

        /** Texto por defecto del campo. */
        private const val TEXTO_POR_DEFECTO = "--:--"

        /** Expresión regular para validar el formato HH:mm (00:00 a 23:59). */
        private val REGEX_HORA = Regex("^([01]?[0-9]|2[0-3]):[0-5]