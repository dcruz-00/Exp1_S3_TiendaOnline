package tiendaonline.decorator;

import tiendaonline.decorator.Component;
import tiendaonline.model.Producto;
import java.util.Scanner;

public class DecoratorDescuentoEstudiante extends Decorator {

    public DecoratorDescuentoEstudiante(Component envoltorio) {
        super(envoltorio);
    }

    @Override
    public void aplicarDescuento(Producto producto, int porcentaje) {
        Scanner sc = new Scanner(System.in);

        if (producto != null) {
            System.out.println("Ingrese su edad para acceder al descuento de estudiante (30%): ");
            if (sc.hasNextInt()) {
                int edad = sc.nextInt();
                if (edad <= 25) {
                    System.out.println("Su edad es: " + edad + ". " + "Aplica descuento estudiante.");
                    porcentaje = 30;
                    int precioActual = producto.getValor();
                    double descuento = precioActual * (porcentaje / 100.0);
                    int nuevoPrecio = (int) (precioActual - descuento);
                    producto.setValor(nuevoPrecio);

                    System.out.println("Descuento de 30% aplicado! Su nuevo precio es: " + nuevoPrecio);

                } else {
                    System.out.println("No aplica descuento de estudiante.");
                }
            } else {
                System.out.println("Entrada invalida. Debe ingresar un numero para la edad.");
                sc.next(); 
            }
        } else {
            System.out.println("No ha seleccionado un producto.");
        }
    }
}
