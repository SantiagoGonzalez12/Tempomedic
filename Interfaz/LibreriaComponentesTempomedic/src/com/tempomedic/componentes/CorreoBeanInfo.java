package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Clase descriptora (BeanInfo) para el componente CampoCorreo.
 * 
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class CorreoBeanInfo extends SimpleBeanInfo {

    /**
     * Constructor por defecto de la clase BeanInfo.
     */
    public CorreoBeanInfo() {
    }

    /**
     * Define los metadatos generales del Bean.
     * 
     * @return el descriptor del Bean.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(Correo.class);
        descriptor.setDisplayName("Campo de Correo");
        descriptor.setShortDescription("Campo de texto con validación de formato de email.");
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
            PropertyDescriptor propCorreo = new PropertyDescriptor(
                    "correo", Correo.class, "getCorreo", "setCorreo");
            propCorreo.setDisplayName("Correo Electrónico");
            propCorreo.setShortDescription("Dirección de correo validada.");
            propCorreo.setPreferred(true); 

            return new PropertyDescriptor[]{propCorreo};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}