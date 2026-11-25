package com.tempomedic.componentes

import java.beans.BeanDescriptor
import java.beans.IntrospectionException
import java.beans.PropertyDescriptor
import java.beans.SimpleBeanInfo

/**
 * Clase descriptora (BeanInfo) para el componente CampoPIN.
 *
 * @author María Dolores Barba López
 * @version 1.0
 */
class PinBeanInfo : SimpleBeanInfo() {

    /**
     * Define los metadatos generales del Bean.
     *
     * @return el descriptor del Bean.
     */
    override fun getBeanDescriptor(): BeanDescriptor =
        BeanDescriptor(Pin::class.java).apply {
            displayName = "PIN (4 dígitos)"
            shortDescription = "Componente visual para introducir un código PIN de 4 números."
        }

    /**
     * Define y expone las propiedades personalizadas del componente.
     *
     * @return un array con los descriptores de las propiedades expuestas.
     */
    override fun getPropertyDescriptors(): Array<PropertyDescriptor> {
        return try {
            val propPin = PropertyDescriptor(
                "pin",
                Pin::class.java,
                "getPin",
                "setPin"
            ).apply {
                displayName = "PIN"
                shortDescription = "Código PIN de 4 dígitos validado."
                isPreferred = true
            }

            arrayOf(propPin)
        } catch (ie: IntrospectionException) {
            super.propertyDescriptors
        }
    }
}