package tiendaonline.decorator;

import tiendaonline.model.Producto;
import tiendaonline.model.Usuario;

public class DecoratorDescuentoSocio extends Decorator {

    private Usuario usuario;
    private int porcentaje;

    public DecoratorDescuentoSocio(Component envoltorio, Usuario usuario, int porcentaje) {
        super(envoltorio);
        this.usuario = usuario;
        this.porcentaje = porcentaje;
    }

    @Override
    public void aplicarDescuento(Producto producto, int porcentajeBase) {
        super.aplicarDescuento(producto, porcentajeBase);
        if(usuario.getTipo().equalsIgnoreCase("socio")) {
            int precioActual = producto.getValor();
            int descuento = (int)(precioActual * (this.porcentaje / 100.0));
            producto.setValor(precioActual - descuento);
        }
    }
}
