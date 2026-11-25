package com.tempomedic.componentes

import java.beans.BeanDescriptor
import java.beans.IntrospectionException
import java.beans.PropertyDescriptor
import java.beans.SimpleBeanInfo

/**
 * Clase descriptora (BeanInfo) para el componente CampoVerificarPassword.
 *
 * @author María Dolores Barba López
 * @version 1.0
 */
class VerificarPasswordBeanInfo : SimpleBeanInfo() {

    override fun getBeanDescriptor(): BeanDescriptor =
        BeanDescriptor(VerificarPassword::class.java).apply {
            displayName = "Verificar Contraseña"
            shortDescription = "Campo para confirmar que la contraseña coincide."
        }

    override fun getPropertyDescriptors(): Array<PropertyDescriptor> {
        return try {
            val propOriginal = PropertyDescriptor(
                "passwordOriginal",
                VerificarPassword::class.java,
                "getPasswordOriginal",
                "setPasswordOriginal"
            ).apply {
                displayName = "Contraseña Original"
                shortDescription = "Contraseña con la que se compara este campo."
                isPreferred = true
            }

            val propVerificacion = PropertyDescriptor(
                "verificacionCorrecta",
                VerificarPassword::class.java,
                "isVerificacionCorrecta",
                null
            ).apply {
                displayName = "¿Coinciden?"
                shortDescription = "Indica si las contraseñas coinciden (solo lectura)."
                isPreferred = true
            }

            arrayOf(propOriginal, propVerificacion)
        } catch (ie: IntrospectionException) {
            super.propertyDescriptors
        }
    }
}