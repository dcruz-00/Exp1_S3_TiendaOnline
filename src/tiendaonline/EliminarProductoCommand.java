package tiendaonline;

public class EliminarProductoCommand implements Command {
    private Carrito carrito;
    private Producto producto;

    public EliminarProductoCommand(Carrito carrito, Producto producto) {
        this.carrito = carrito;
        this.producto = producto;
    }
    
    @Override
    public void ejecutar() {
        if (producto != null && carrito.eliminarProducto(producto)) {            
            System.out.println("Producto eliminado del carrito: " + producto.getNombre());
        } else {
            System.out.println("No se pudo eliminar del carrito.");
        }
    }
}
