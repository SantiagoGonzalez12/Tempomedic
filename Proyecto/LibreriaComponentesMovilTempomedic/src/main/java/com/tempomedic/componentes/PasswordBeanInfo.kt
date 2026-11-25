package com.tempomedic.componentes

import java.beans.BeanDescriptor
import java.beans.IntrospectionException
import java.beans.PropertyDescriptor
import java.beans.SimpleBeanInfo

/**
 * Clase descriptora (BeanInfo) para el componente CampoPassword.
 *
 * @author María Dolores Barba López
 * @version 1.0
 */
class PasswordBeanInfo : SimpleBeanInfo() {

    override fun getBeanDescriptor(): BeanDescriptor =
        BeanDescriptor(Password::class.java).apply {
            displayName = "Contraseña"
            shortDescription = "Campo para introducir contraseñas con validación básica."
        }

    override fun getPropertyDescriptors(): Array<PropertyDescriptor> {
        return try {
            val propPassword = PropertyDescriptor(
                "password",
                Password::class.java,
                "getPasswordValidada",
                "setPasswordValidada"
            ).apply {
                displayName = "Contraseña"
                shortDescription = "Contraseña introducida por el usuario."
                isPreferred = true
            }

            arrayOf(propPassword)
        } catch (ie: IntrospectionException) {
            super.propertyDescriptors
        }
    }
}