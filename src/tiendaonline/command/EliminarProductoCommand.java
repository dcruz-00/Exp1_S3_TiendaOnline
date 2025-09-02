package tiendaonline.command;

import tiendaonline.model.Pedido;
import tiendaonline.model.Producto;

public class EliminarProductoCommand implements Command {

    private Pedido pedido;
    private Producto producto;

    public EliminarProductoCommand(Pedido pedido, Producto producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        if (producto != null) {
            pedido.eliminarProducto(producto);
            System.out.println("Producto eliminado del carrito: " + producto.getNombre());
        }
    }
}
