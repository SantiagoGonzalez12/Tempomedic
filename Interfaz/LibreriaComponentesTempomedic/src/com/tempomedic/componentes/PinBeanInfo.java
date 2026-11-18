package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Clase descriptora (BeanInfo) para el componente CampoPIN.
 * 
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class PinBeanInfo extends SimpleBeanInfo {

    /**
     * Constructor por defecto de la clase BeanInfo.
     */
    public PinBeanInfo() {
    }

    /**
     * Define los metadatos generales del Bean.
     * 
     * @return el descriptor del Bean.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(Pin.class);
        descriptor.setDisplayName("PIN (4 dígitos)");
        descriptor.setShortDescription("Componente visual para introducir un código PIN de 4 números.");
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
            PropertyDescriptor propPin = new PropertyDescriptor(
                    "pin", Pin.class, "getPin", "setPin");
            propPin.setDisplayName("PIN");
            propPin.setShortDescription("Código PIN de 4 dígitos validado.");
            propPin.setPreferred(true); 

            return new PropertyDescriptor[]{propPin};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}