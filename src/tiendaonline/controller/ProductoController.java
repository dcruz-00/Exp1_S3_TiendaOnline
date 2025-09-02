package tiendaonline.controller;

import tiendaonline.model.Producto;
import tiendaonline.model.Inventario;
import tiendaonline.view.ProductoView;

import java.util.List;

public class ProductoController {

    private Inventario inventario;
    private ProductoView view;

    public ProductoController(Inventario inventario, ProductoView view) {
        this.inventario = inventario;
        this.view = view;
    }

    public List<Producto> obtenerProductos() {
        return inventario.getProductos();
    }

    public void mostrarProductos() {
        view.mostrarProductos(inventario.getProductos());
    }

    public Producto seleccionarProducto(int idProducto) {
        Producto producto = inventario.getProductos().stream()
                .filter(p -> p.getIdProducto() == idProducto)
                .findFirst()
                .orElse(null);
        view.mostrarProductoSeleccionado(producto);
        return producto;
    }
}
