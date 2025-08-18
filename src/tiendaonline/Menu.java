package tiendaonline;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Inventario inventario;
    private Producto productoSeleccionado;
    private int porcentaje;

    static String[] opcionesMenu = {
        "------------------------",
        "1) Seleccionar producto.",
        "2) Aplicar descuento.",
        "3) Salir del programa.",
        "------------------------",};

    public Menu(Inventario inventario) {
        this.inventario = inventario;
    }

    public void menuInteractivo() {

        int opcionMenu = -1;
        System.out.println("..:: Bienvenido a nuestra Tienda! ::..");
        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcionMenu = scanner.nextInt();
                scanner.nextLine();
                switch (opcionMenu) {
                    case 1 -> {
                        productoSeleccionado = inventario.seleccionarProducto();
                    }

                    case 2 -> {
                        if (productoSeleccionado != null) {
                            System.out.println("Ingrese el porcentaje de descuento de su cupon: ");
                            int porcentaje = scanner.nextInt();
                            scanner.nextLine();
                            
                            DiscountManager.getInstance().aplicarDescuento(productoSeleccionado, porcentaje);                                                                              
                        } else {
                            System.out.println("Primero debe seleccionar un producto antes de aplicar un descuento.");
                        }
                    }

                    case 3 ->
                        System.out.println("Saliendo del sistema...");
                        
                    default ->
                        System.out.println("Opcion no valida.");
                }
            } else {
                System.out.println("Entrada no valida. Ingrese un numero.");
                scanner.nextLine();
            }
        } while (opcionMenu != 3);

    }

    public void mostrarMenu() {
        for (int i = 0; i < opcionesMenu.length; i++) {
            System.out.println(opcionesMenu[i]);
        }
    }


}
