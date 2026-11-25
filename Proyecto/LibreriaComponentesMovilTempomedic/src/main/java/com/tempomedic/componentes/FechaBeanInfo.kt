package com.tempomedic.componentes

import java.beans.BeanDescriptor
import java.beans.IntrospectionException
import java.beans.PropertyDescriptor
import java.beans.SimpleBeanInfo

/**
 * Clase descriptora (BeanInfo) para el componente CampoFecha.
 *
 *
 *
 * @author Alba Durán Bernal
 * @version 1.0
 */
class FechaBeanInfo : SimpleBeanInfo() {

    /**
     * Define los metadatos generales del Bean.
     *
     * @return el descriptor del Bean.
     */
    override fun getBeanDescriptor(): BeanDescriptor {
        return BeanDescriptor(Fecha::class.java).apply {
            displayName = "Fecha"
            shortDescription = "Campo de texto para introducir una fecha (dd/mm/aaaa)."
        }
    }

    /**
     * Define y expone las propiedades personalizadas del componente.
     *
     * @return un array con los descriptores de las propiedades expuestas.
     */
    override fun getPropertyDescriptors(): Array<PropertyDescriptor> {
        return try {
            val propFecha = PropertyDescriptor(
                "fecha",
                Fecha::class.java,
                "getFecha",
                "setFecha"
            ).apply {
                displayName = "Fecha (dd/mm/aaaa)"
                shortDescription = "Fecha introducida por el usuario."
                isPreferred = true
            }

            arrayOf(propFecha)
        } catch (ie: IntrospectionException) {
            super.getPropertyDescriptors()
        }
    }
}