package tiendaonline.decorator;

import tiendaonline.model.Producto;

public abstract class Decorator implements Component {

    protected Component envoltorio;

    public Decorator(Component envoltorio) {
        this.envoltorio = envoltorio;
    }

    @Override
    public void aplicarDescuento(Producto producto, int porcentaje) {
        envoltorio.aplicarDescuento(producto, porcentaje);
    }
}
