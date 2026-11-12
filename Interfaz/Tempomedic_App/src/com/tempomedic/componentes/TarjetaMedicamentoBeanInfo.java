package com.tempomedic.componentes;

import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 *
 * @author Jorge Espejo Martinez
 */
public class TarjetaMedicamentoBeanInfo extends SimpleBeanInfo {

    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor = new BeanDescriptor(TarjetaMedicamento.class);
        descriptor.setDisplayName("Tarjeta de Medicamento");
        descriptor.setShortDescription("Componente visual para mostrar la dosis de un fármaco.");
        return descriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor propNombre = new PropertyDescriptor(
                    "nombreMedicamento", TarjetaMedicamento.class, "getNombreMedicamento", "setNombreMedicamento");
            propNombre.setDisplayName("Nombre del Fármaco");
            propNombre.setPreferred(true); // Hace que salga arriba en Matisse

            PropertyDescriptor propPauta = new PropertyDescriptor(
                    "pauta", TarjetaMedicamento.class, "getPauta", "setPauta");
            propPauta.setDisplayName("Pauta / Frecuencia");
            propPauta.setPreferred(true);

            PropertyDescriptor propProxima = new PropertyDescriptor(
                    "proximaToma", TarjetaMedicamento.class, "getProximaToma", "setProximaToma");
            propProxima.setDisplayName("Próxima Toma");
            propProxima.setPreferred(true);

            return new PropertyDescriptor[]{propNombre, propPauta, propProxima};
        } catch (IntrospectionException ie) {
            return super.getPropertyDescriptors();
        }
    }
}