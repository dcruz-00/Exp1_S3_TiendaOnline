package tiendaonline.controller;

import tiendaonline.model.Pedido;
import tiendaonline.model.Producto;
import tiendaonline.view.CarritoView;

import java.util.List;

public class CarritoController {

    private Pedido pedido;
    private CarritoView view;

    public CarritoController(Pedido pedido, CarritoView view) {
        this.pedido = pedido;
        this.view = view;
    }

    public void agregarProducto(Producto producto) {
        pedido.agregarProducto(producto);
    }

    public void eliminarProducto(Producto producto) {
        pedido.eliminarProducto(producto);
    }

    public void mostrarCarrito() {
        view.mostrarCarrito(pedido.getProductos());
    }

    // Nuevo método para obtener productos
    public List<Producto> getProductos() {
        return pedido.getProductos();
    }
}
