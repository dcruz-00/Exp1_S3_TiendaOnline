package tiendaonline.command;

import tiendaonline.decorator.Component;
import tiendaonline.model.Producto;

public class AplicarDescuentoCommand implements Command {

    private Component component;
    private Producto producto;
    private int porcentaje;

    public AplicarDescuentoCommand(Component component, Producto producto, int porcentaje) {
        this.component = component;
        this.producto = producto;
        this.porcentaje = porcentaje;
    }

    @Override
    public void ejecutar() {
        component.aplicarDescuento(producto, porcentaje);
        System.out.println("Descuento aplicado a: " + producto.getNombre());
    }
}
