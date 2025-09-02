package tiendaonline.controller;

import tiendaonline.model.Producto;
import tiendaonline.view.DiscountView;
import tiendaonline.service.DiscountManager;

public class DiscountController {

    private DiscountManager discountManager;
    private DiscountView view;

    public DiscountController(DiscountView view) {
        this.discountManager = DiscountManager.getInstance();
        this.view = view;
    }

    public void aplicarDescuento(Producto producto, int porcentaje) {
        int nuevoPrecio = discountManager.aplicarDescuento(producto, porcentaje);
        view.mostrarDescuentoAplicado("Descuento aplicado correctamente!", nuevoPrecio);
    }
}
