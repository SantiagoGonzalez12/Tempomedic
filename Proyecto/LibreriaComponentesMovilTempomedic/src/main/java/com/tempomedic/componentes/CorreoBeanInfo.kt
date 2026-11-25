package com.tempomedic.componentes

import java.beans.BeanDescriptor
import java.beans.IntrospectionException
import java.beans.PropertyDescriptor
import java.beans.SimpleBeanInfo

/**
 * Clase descriptora (BeanInfo) para el componente CampoCorreo.
 *
 * @author Alba Durán Bernal
 * @version 1.0
 */
class CorreoBeanInfo : SimpleBeanInfo() {

    /**
     * Define los metadatos generales del Bean.
     *
     * @return el descriptor del Bean.
     */
    override fun getBeanDescriptor(): BeanDescriptor {
        return BeanDescriptor(Correo::class.java).apply {
            displayName = "Correo"
            shortDescription = "Campo de texto con validación de formato de email."
        }
    }

    /**
     * Define y expone las propiedades personalizadas del componente.
     *
     * @return un array con los descriptores de las propiedades expuestas.
     */
    override fun getPropertyDescriptors(): Array<PropertyDescriptor> {
        return try {
            val propCorreo = PropertyDescriptor(
                "correo",
                Correo::class.java,
                "getCorreo",
                "setCorreo"
            ).apply {
                displayName = "Correo Electrónico"
                shortDescription = "Dirección de correo validada."
                isPreferred = true
            }

            arrayOf(propCorreo)
        } catch (ie: IntrospectionException) {
            super.getPropertyDescriptors()
        }
    }
}