package tiendaonline.view;

import tiendaonline.model.Producto;
import java.util.List;

public class ProductoView {

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        for (Producto p : productos) {
            System.out.println(p.getIdProducto() + ") " + p.getMarca() + " " + p.getNombre() + " - $" + p.getValor());
        }
    }

    public void mostrarProductoSeleccionado(Producto producto) {
        if(producto != null) {
            System.out.println("Producto seleccionado: " + producto.getNombre() + " - $" + producto.getValor());
        } else {
            System.out.println("No se ha seleccionado ningún producto.");
        }
    }
}
