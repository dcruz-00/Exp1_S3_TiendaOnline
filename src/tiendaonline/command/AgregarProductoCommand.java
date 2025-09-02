package tiendaonline.command;

import tiendaonline.model.Pedido;
import tiendaonline.model.Producto;

public class AgregarProductoCommand implements Command {

    private Pedido pedido;
    private Producto producto;

    public AgregarProductoCommand(Pedido pedido, Producto producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        if (producto != null) {
            pedido.agregarProducto(producto);
            System.out.println("Producto agregado al carrito: " + producto.getNombre());
        }
    }
}