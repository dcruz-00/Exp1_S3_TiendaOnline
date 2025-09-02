package tiendaonline.view;

import tiendaonline.model.Producto;
import java.util.List;

public class CarritoView {

    public void mostrarCarrito(List<Producto> productos) {
        System.out.println("\n=== CARRITO DE COMPRAS ===");
        if(productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            int total = 0;
            for(Producto p : productos) {
                System.out.println("- " + p.getNombre() + " - $" + p.getValor());
                total += p.getValor();
            }
            System.out.println("TOTAL: $" + total);
        }
    }
}
