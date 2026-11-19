package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Clase descriptora (BeanInfo) para el componente CampoFecha.
 * <p>
 * Permite definir explícitamente qué propiedades se mostrarán en la ventana de
 * Propiedades de NetBeans Matisse.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class FechaBeanInfo extends SimpleBeanInfo {

    /**
     * Constructor por defecto de la clase BeanInfo.
     */
    public FechaBeanInfo() {
    }

    /**
     * Define los metadatos generales del Bean.
     *
     * @return el descriptor del Bean.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(Fecha.class);
        descriptor.setDisplayName("Fecha");
        descriptor.setShortDescription("Campo de texto para introducir una fecha (dd/mm/aaaa).");
        return descriptor;
    }

    /**
     * Define y expone las propiedades personalizadas del componente.
     *
     * @return un array con los descriptores de las propiedades expuestas.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor propFecha = new PropertyDescriptor(
                    "fecha", Fecha.class, "getFecha", "setFecha");
            propFecha.setDisplayName("Fecha (dd/mm/aaaa)");
            propFecha.setShortDescription("Fecha introducida por el usuario.");
            propFecha.setPreferred(true);

            return new PropertyDescriptor[]{propFecha};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}
