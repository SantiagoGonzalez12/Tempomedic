package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Clase descriptora (BeanInfo) para el componente Hora.
 * <p>
 * Permite definir explícitamente qué propiedades se mostrarán en la ventana de
 * Propiedades de NetBeans Matisse.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class HoraBeanInfo extends SimpleBeanInfo {

    /**
     * Constructor por defecto de la clase BeanInfo.
     */
    public HoraBeanInfo() {
    }

    /**
     * Define los metadatos generales del Bean (nombre e información
     * descriptiva).
     *
     * @return el descriptor del Bean.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(Hora.class);
        descriptor.setDisplayName("Hora");
        descriptor.setShortDescription("Campo de texto para introducir una hora con formato HH:mm.");
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
            //Se expone la propiedad 'hora' y se dice qué getter y setter usar
            PropertyDescriptor propHora = new PropertyDescriptor(
                    "hora", Hora.class, "getHora", "setHora");

            propHora.setDisplayName("Hora (HH:mm)");
            propHora.setShortDescription("Hora introducida por el usuario.");
            propHora.setPreferred(true);

            return new PropertyDescriptor[]{propHora};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}
