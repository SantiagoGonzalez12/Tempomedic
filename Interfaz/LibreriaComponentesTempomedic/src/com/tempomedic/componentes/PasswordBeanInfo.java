package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Clase descriptora (BeanInfo) para el componente CampoPassword.
 * 
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class PasswordBeanInfo extends SimpleBeanInfo {

    public PasswordBeanInfo() {
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(Password.class);
        descriptor.setDisplayName("Contraseña");
        descriptor.setShortDescription("Campo para introducir contraseñas con validación básica.");
        return descriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor propPassword = new PropertyDescriptor(
                    "password", Password.class, "getPasswordValidada", "setPasswordValidada");
            propPassword.setDisplayName("Contraseña");
            propPassword.setShortDescription("Contraseña introducida por el usuario.");
            propPassword.setPreferred(true); 

            return new PropertyDescriptor[]{propPassword};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}