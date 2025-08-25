package tiendaonline;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Inventario inventario;
    private Producto productoSeleccionado;
    private int porcentaje;
    private Component component = new ComponenteConcreto();
    private final Carrito carrito = new Carrito();
    private final Invoker invoker = new Invoker();

    static String[] opcionesMenu = {
        "------------------------",
        "1) Agregar producto al carrito.",
        "2) Eliminar producto del carrito.",
        "3) Aplicar descuento.",
        "4) Mostrar carrito.",
        "5) Salir del programa.",
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
                        if (productoSeleccionado != null) {
                            Command agregar = new AgregarProductoCommand(carrito, productoSeleccionado);
                            invoker.agregarComando(agregar);
                            invoker.ejecutarComando(agregar);
                        }
                    }
                    case 2 -> {
                        productoSeleccionado = inventario.seleccionarProducto();
                        if (productoSeleccionado != null) {
                            Command eliminar = new EliminarProductoCommand(carrito, productoSeleccionado);
                            invoker.agregarComando(eliminar);
                            invoker.ejecutarComando(eliminar);
                        }
                    }
                    case 3 -> {
                        if (productoSeleccionado != null) {
                            int opcion = DiscountManager.getInstance().elegirDescuento();
                            switch (opcion) {
                                case 1:
                                    DiscountManager.getInstance().aplicarDescuento(productoSeleccionado, porcentaje);
                                    break;
                                case 2:
                                    component = new DecoratorDescuentoEstudiante(component);
                                    component.aplicarDescuento(productoSeleccionado, porcentaje);
                                    break;
                                case 3:
                                    component = new DecoratorDescuentoSocio(component);
                                    component.aplicarDescuento(productoSeleccionado, porcentaje);
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            System.out.println("Primero debe seleccionar un producto antes de aplicar un descuento.");
                        }
                    }
                    case 4 -> {
                        carrito.mostrarCarrito();
                    }
                    case 5 -> {
                        System.out.println("Saliendo del sistema...");
                    }
                    default ->
                        System.out.println("Opcion no valida.");
                }
            } else {
                System.out.println("Entrada no valida. Ingrese un numero.");
                scanner.nextLine();
            }
        } while (opcionMenu != 5);

    }

    public void mostrarMenu() {
        for (int i = 0; i < opcionesMenu.length; i++) {
            System.out.println(opcionesMenu[i]);
        }
    }

}
