package tiendaonline.command;

import tiendaonline.decorator.Component;
import tiendaonline.model.Producto;
import java.util.Scanner;

public class ComponenteConcreto implements Component {
    @Override
    public void aplicarDescuento(Producto producto, int porcentaje) {

        Scanner sc = new Scanner(System.in);
        
        if (producto != null) {
            System.out.println("Ingrese el porcentaje de descuento de su cupon: ");
            porcentaje = sc.nextInt();
            sc.nextLine();
            int precioActual = producto.getValor();
            double descuento = precioActual * (porcentaje / 100.0);
            int nuevoPrecio = (int) (precioActual - descuento);

            producto.setValor(nuevoPrecio);

            System.out.println("Descuento aplicado! Su nuevo precio es: " + nuevoPrecio);

        } else {
            System.out.println("No ha seleccionado un producto.");
        }
    }
}
