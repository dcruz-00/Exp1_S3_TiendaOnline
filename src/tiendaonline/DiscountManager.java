package tiendaonline;

public class DiscountManager {

    private static DiscountManager instance;

    private DiscountManager() {

    }

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    public void aplicarDescuento(Producto producto, int porcentaje) {

        if (producto != null) {
            int precioActual = producto.getValor();
            double descuento = precioActual * (porcentaje / 100.0);
            int nuevoPrecio = (int) (precioActual - descuento);

            producto.setValor(nuevoPrecio);

            System.out.println("Descuento aplicado! Su nuevo precio es: " + nuevoPrecio);

        } else {
            System.out.println("No ha seleccionado un producto.");
        }
    }
}
