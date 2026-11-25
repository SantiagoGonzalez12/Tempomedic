package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Clase descriptora (BeanInfo) para el componente Medicamento.
 * <p>
 * Permite definir explícitamente qué propiedades se mostrarán en la 
 * ventana de Propiedades de NetBeans Matisse.
 * 
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class MedicamentoBeanInfo extends SimpleBeanInfo {

    /**
     * Constructor por defecto de la clase BeanInfo.
     */
    public MedicamentoBeanInfo() {
    }

    /**
     * Define los metadatos generales del Bean.
     * 
     * @return el descriptor del Bean.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(Medicamento.class);
        descriptor.setDisplayName("Tarjeta Medicamento");
        descriptor.setShortDescription("Componente visual para mostrar un fármaco con semáforo de estado.");
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
            PropertyDescriptor propNombre = new PropertyDescriptor(
                    "nombreMedicamento", Medicamento.class, "getNombreMedicamento", "setNombreMedicamento");
            propNombre.setDisplayName("Nombre del Fármaco");
            propNombre.setPreferred(true);

            PropertyDescriptor propDosis = new PropertyDescriptor(
                    "dosis", Medicamento.class, "getDosis", "setDosis");
            propDosis.setDisplayName("Dosis");
            propDosis.setPreferred(true);

            PropertyDescriptor propHora = new PropertyDescriptor(
                    "hora", Medicamento.class, "getHora", "setHora");
            propHora.setDisplayName("Hora de la toma");
            propHora.setPreferred(true);

            PropertyDescriptor propFrecuencia = new PropertyDescriptor(
                    "frecuencia", Medicamento.class, "getFrecuencia", "setFrecuencia");
            propFrecuencia.setDisplayName("Frecuencia");
            propFrecuencia.setPreferred(true);

            PropertyDescriptor propEstado = new PropertyDescriptor(
                    "estado", Medicamento.class, "getEstado", "setEstado");
            propEstado.setDisplayName("Estado (Pendiente, Tomada, etc.)");
            propEstado.setPreferred(true);

            return new PropertyDescriptor[]{propNombre, propDosis, propHora, propFrecuencia, propEstado};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}