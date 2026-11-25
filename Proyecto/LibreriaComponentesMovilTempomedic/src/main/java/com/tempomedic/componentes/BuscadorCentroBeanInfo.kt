package com.tempomedic.componentes

import java.beans.BeanDescriptor
import java.beans.IntrospectionException
import java.beans.PropertyDescriptor
import java.beans.SimpleBeanInfo

/**
 * Clase descriptora (BeanInfo) para el componente BuscadorCentro.
 *
 * Permite definir explícitamente qué propiedades se mostrarán en la ventana de
 * Propiedades de NetBeans Matisse.
 *
 * @author Alba Duran Bernal
 * @version 1.0
 */
class BuscadorCentroBeanInfo : SimpleBeanInfo() {

    /**
     * Define los metadatos generales del Bean.
     *
     * @return el descriptor del Bean.
     */
    override fun getBeanDescriptor(): BeanDescriptor {
        return BeanDescriptor(BuscadorCentro::class.java).apply {
            displayName = "Buscador de Centro"
            shortDescription = "Componente de búsqueda y selección de hospitales."
        }
    }

    /**
     * Define y expone las propiedades personalizadas del componente.
     *
     * @return un array con los descriptores de las propiedades expuestas.
     */
    override fun getPropertyDescriptors(): Array<PropertyDescriptor> {
        return try {
            val propCentro = PropertyDescriptor(
                "centroSeleccionado",
                BuscadorCentro::class.java,
                "getCentroSeleccionado",
                "setCentroSeleccionado"
            ).apply {
                displayName = "Centro Seleccionado"
                shortDescription = "Nombre del centro médico actualmente seleccionado."
                isPreferred = true
            }

            arrayOf(propCentro)
        } catch (ie: IntrospectionException) {
            super.getPropertyDescriptors()
        }
    }
}