package tiendaonline;

import java.util.Scanner;

class DecoratorDescuentoSocio extends Decorator {

    public DecoratorDescuentoSocio(Component envoltorio) {
        super(envoltorio);
    }

    @Override
    public void aplicarDescuento(Producto producto, int porcentaje) {
        Scanner sc = new Scanner(System.in);

        if (producto != null) {
            System.out.print("Es socio de nuestra tienda? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();

            if (respuesta.equals("s") || respuesta.equals("si")) {
                porcentaje = 50;
                int precioActual = producto.getValor();
                double descuento = precioActual * (porcentaje / 100.0);
                int nuevoPrecio = (int) (precioActual - descuento);
                producto.setValor(nuevoPrecio);

                System.out.println("Gracias por ser parte de nuestro programa de socios! Descuento del 50% aplicado. Su nuevo precio es: " + nuevoPrecio);
            } else {
                System.out.println("No aplica descuento de socio. Precio normal: " + producto.getValor());
            }
        } else {
            System.out.println("No ha seleccionado un producto.");
        }
    }
}
