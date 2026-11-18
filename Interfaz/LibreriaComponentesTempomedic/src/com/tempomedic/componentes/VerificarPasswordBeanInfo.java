package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Clase descriptora (BeanInfo) para el componente CampoVerificarPassword.
 * 
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class VerificarPasswordBeanInfo extends SimpleBeanInfo {

    public VerificarPasswordBeanInfo() {
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(VerificarPassword.class);
        descriptor.setDisplayName("Verificar Contraseña");
        descriptor.setShortDescription("Campo para confirmar que la contraseña coincide.");
        return descriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor propOriginal = new PropertyDescriptor(
                    "passwordOriginal", VerificarPassword.class, "getPasswordOriginal", "setPasswordOriginal");
            propOriginal.setDisplayName("Contraseña Original");
            propOriginal.setShortDescription("Contraseña con la que se compara este campo.");
            propOriginal.setPreferred(true); 

            PropertyDescriptor propVerificacion = new PropertyDescriptor(
                    "verificacionCorrecta", VerificarPassword.class, "isVerificacionCorrecta", null);
            propVerificacion.setDisplayName("¿Coinciden?");
            propVerificacion.setShortDescription("Indica si las contraseñas coinciden (solo lectura).");
            propVerificacion.setPreferred(true); 

            return new PropertyDescriptor[]{propOriginal, propVerificacion};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}