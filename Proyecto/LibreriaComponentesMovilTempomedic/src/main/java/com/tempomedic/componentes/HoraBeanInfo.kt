package com.tempomedic.componentes

import java.beans.BeanDescriptor
import java.beans.IntrospectionException
import java.beans.PropertyDescriptor
import java.beans.SimpleBeanInfo

/**
 * Clase descriptora (BeanInfo) para el componente Hora.
 *
 *
 * @author Alba Durán Bernal
 * @version 1.0
 */
class HoraBeanInfo : SimpleBeanInfo() {

    /**
     * Define los metadatos generales del Bean (nombre e información
     * descriptiva).
     *
     * @return el descriptor del Bean.
     */
    override fun getBeanDescriptor(): BeanDescriptor {
        return BeanDescriptor(Hora::class.java).apply {
            displayName = "Hora"
            shortDescription = "Campo de texto para introducir una hora con formato HH:mm."
        }
    }

    /**
     * Define y expone las propiedades personalizadas del componente.
     *
     * @return un array con los descriptores de las propiedades expuestas.
     */
    override fun getPropertyDescriptors(): Array<PropertyDescriptor> {
        return try {
            // Se expone la propiedad 'hora' y se dice qué getter y setter usar
            val propHora = PropertyDescriptor(
                "hora",
                Hora::class.java,
                "getHora",
                "setHora"
            ).apply {
                displayName = "Hora (HH:mm)"
                shortDescription = "Hora introducida por el usuario."
                isPreferred = true
            }

            arrayOf(propHora)
        } catch (ie: IntrospectionException) {
            super.getPropertyDescriptors()
        }
    }
}