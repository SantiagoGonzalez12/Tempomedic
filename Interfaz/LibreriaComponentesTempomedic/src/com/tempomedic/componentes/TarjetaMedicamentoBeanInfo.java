package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Clase descriptora (BeanInfo) para el componente TarjetaMedicamento.
 * <p>
 * Esta clase permite definir explícitamente qué propiedades se mostrarán en la 
 * ventana de Propiedades de NetBeans Matisse, ocultando las propiedades heredadas 
 * de JPanel que no son relevantes para el desarrollador.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class TarjetaMedicamentoBeanInfo extends SimpleBeanInfo {

    /**
     * Constructor por defecto de la clase BeanInfo.
     */
    public TarjetaMedicamentoBeanInfo() {
        // Constructor vacío requerido por la especificación JavaBeans
    }
    
    /**
     * Define los metadatos generales del Bean (nombre e información descriptiva).
     * 
     * @return el descriptor del Bean.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(TarjetaMedicamento.class);
        descriptor.setDisplayName("Tarjeta de Medicamento");
        descriptor.setShortDescription("Componente visual para mostrar la dosis de un fármaco.");
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
                    "nomMedicamento", TarjetaMedicamento.class, "getNomMedicamento", "setNomMedicamento");
            propNombre.setDisplayName("Nombre del Fármaco");
            propNombre.setPreferred(true); 

            PropertyDescriptor propPauta = new PropertyDescriptor(
                    "pauta", TarjetaMedicamento.class, "getPauta", "setPauta");
            propPauta.setDisplayName("Pauta / Frecuencia");
            propPauta.setPreferred(true);

            PropertyDescriptor propProxima = new PropertyDescriptor(
                    "proximaToma", TarjetaMedicamento.class, "getProxToma", "setProxToma");
            propProxima.setDisplayName("Próxima Toma");
            propProxima.setPreferred(true);

            return new PropertyDescriptor[]{propNombre, propPauta, propProxima};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}
