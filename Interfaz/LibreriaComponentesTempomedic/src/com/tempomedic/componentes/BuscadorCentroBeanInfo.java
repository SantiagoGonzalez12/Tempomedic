package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Clase descriptora (BeanInfo) para el componente BuscadorCentro.
 * <p>
 * Permite definir explícitamente qué propiedades se mostrarán en la 
 * ventana de Propiedades de NetBeans Matisse.
 *
 * @author Jorge Espejo Martínez
 * @version 1.0
 */
public class BuscadorCentroBeanInfo extends SimpleBeanInfo {

    /**
     * Constructor por defecto de la clase BeanInfo.
     */
    public BuscadorCentroBeanInfo() {
    }

    /**
     * Define los metadatos generales del Bean.
     * 
     * @return el descriptor del Bean.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(BuscadorCentro.class);
        descriptor.setDisplayName("Buscador de Centro");
        descriptor.setShortDescription("Componente de búsqueda y selección de hospitales.");
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
            PropertyDescriptor propCentro = new PropertyDescriptor(
                    "centroSeleccionado", BuscadorCentro.class, "getCentroSeleccionado", "setCentroSeleccionado");
            propCentro.setDisplayName("Centro Seleccionado");
            propCentro.setShortDescription("Nombre del centro médico actualmente seleccionado.");
            propCentro.setPreferred(true); 

            return new PropertyDescriptor[]{propCentro};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}