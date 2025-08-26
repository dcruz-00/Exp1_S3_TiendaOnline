package tiendaonline.model;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public boolean eliminarProducto(Producto producto) {
        return productos.remove(producto);
    }

    public void mostrarCarrito() {
        System.out.println("\n=== LISTA DE PRODUCTOS EN CARRITO ===");
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - $" + p.getValor());
        }
    }    
}
