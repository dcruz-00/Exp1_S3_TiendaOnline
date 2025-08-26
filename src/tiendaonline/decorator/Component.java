package tiendaonline.decorator;

import tiendaonline.model.Producto;

public interface Component {
    void aplicarDescuento(Producto producto, int porcentaje);
}
