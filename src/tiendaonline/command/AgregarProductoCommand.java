package tiendaonline.command;

import tiendaonline.command.Command;
import tiendaonline.model.Carrito;
import tiendaonline.model.Producto;

public class AgregarProductoCommand implements Command {

    private Carrito carrito;
    private Producto producto;

    public AgregarProductoCommand(Carrito carrito, Producto producto) {
        this.carrito = carrito;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        if (producto != null) {
            carrito.agregarProducto(producto);
            System.out.println("Producto agregado al carrito: " + producto.getNombre());
        } else {
            System.out.println("No se puede agregar al carrito.");
        }
    }
}
