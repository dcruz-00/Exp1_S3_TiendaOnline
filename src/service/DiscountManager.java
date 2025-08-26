package service;

import tiendaonline.model.Producto;
import java.util.Scanner;

public class DiscountManager {

    private static DiscountManager instance;

    private DiscountManager() {

    }

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

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

    public int elegirDescuento() {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("Ingrese su tipo de descuento: ");
            System.out.println("1. Descuento por cupon");
            System.out.println("2. Descuento estudiante");
            System.out.println("3. Descuento socio");
            System.out.println("Escoja el numero asociado a su tipo de descuento: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= 3) {
                    break;
                } else {
                    System.out.println("Opcion invalida. Intente de nuevo.");
                }

            } else {
                System.out.println("Ingrese una opcion. Intente de nuevo.");
                sc.next();
            }
                        
        } while (true);

        return opcion;
    }
}
