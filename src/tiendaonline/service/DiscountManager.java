package tiendaonline.service;

import tiendaonline.model.Producto;

public class DiscountManager {

    private static DiscountManager instance;

    private DiscountManager() {}

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    public int aplicarDescuento(Producto producto, int porcentaje) {
        if(producto != null && porcentaje > 0) {
            int precioActual = producto.getValor();
            int descuento = (int)(precioActual * (porcentaje / 100.0));
            producto.setValor(precioActual - descuento);
            return producto.getValor();
        }
        return producto != null ? producto.getValor() : 0;
    }
}
