package tiendaonline.decorator;

import tiendaonline.model.Producto;

public class ComponenteConcreto implements Component {

    @Override
    public void aplicarDescuento(Producto producto, int porcentaje) {
        if (producto != null && porcentaje > 0) {
            int precioActual = producto.getValor();
            double descuento = precioActual * (porcentaje / 100.0);
            int nuevoPrecio = (int) (precioActual - descuento);
            producto.setValor(nuevoPrecio);
        }
    }
}
