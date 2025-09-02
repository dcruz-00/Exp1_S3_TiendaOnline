package tiendaonline.ui;

import tiendaonline.model.*;
import tiendaonline.decorator.*;
import tiendaonline.command.*;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Inventario inventario;
    private final Pedido pedido;
    private Producto productoSeleccionado;
    private Component component = new ComponenteConcreto();
    private final Usuario usuario;
    private final Invoker invoker = new Invoker();

    public Menu(Inventario inventario, Usuario usuario) {
        this.inventario = inventario;
        this.usuario = usuario;
        this.pedido = new Pedido(1, usuario);
    }

    public void menuInteractivo() {
        int opcionMenu = -1;
        System.out.println("..:: Bienvenido a nuestra Tienda! ::..");

        do {
            mostrarMenu();
            if(scanner.hasNextInt()){
                opcionMenu = scanner.nextInt();
                scanner.nextLine();

                switch(opcionMenu){
                    case 1 -> agregarProducto();
                    case 2 -> eliminarProducto();
                    case 3 -> aplicarDescuento();
                    case 4 -> mostrarCarrito();
                    case 5 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida");
                }
            } else {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
            }
        } while(opcionMenu != 5);
    }

    private void agregarProducto() {
        productoSeleccionado = inventario.seleccionarProducto();
        if(productoSeleccionado != null){
            Command agregar = new AgregarProductoCommand(pedido, productoSeleccionado);
            invoker.agregarComando(agregar);
            invoker.ejecutarComando(agregar);
        }
    }

    private void eliminarProducto() {
        productoSeleccionado = inventario.seleccionarProducto();
        if(productoSeleccionado != null){
            Command eliminar = new EliminarProductoCommand(pedido, productoSeleccionado);
            invoker.agregarComando(eliminar);
            invoker.ejecutarComando(eliminar);
        }
    }

    private void aplicarDescuento() {
        if(productoSeleccionado == null){
            System.out.println("Seleccione un producto primero.");
            return;
        }
        System.out.println("1) Porcentaje manual");
        System.out.println("2) Estudiante");
        System.out.println("3) Socio");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        switch(tipo){
            case 1 -> {
                System.out.print("Ingrese porcentaje: ");
                int porcentaje = scanner.nextInt();
                scanner.nextLine();
                component.aplicarDescuento(productoSeleccionado, porcentaje);
            }
            case 2 -> {
                component = new DecoratorDescuentoEstudiante(component, usuario, 30);
                component.aplicarDescuento(productoSeleccionado,0);
            }
            case 3 -> {
                component = new DecoratorDescuentoSocio(component, usuario,50);
                component.aplicarDescuento(productoSeleccionado,0);
            }
            default -> System.out.println("Opción inválida");
        }
    }

    private void mostrarCarrito() {
        System.out.println("\n=== CARRITO ===");
        int total = 0;
        for(Producto p: pedido.getProductos()){
            System.out.println("- " + p.getNombre() + " - $" + p.getValor());
            total += p.getValor();
        }
        System.out.println("TOTAL: $" + total);
    }

    private void mostrarMenu(){
        System.out.println("------------------------");
        System.out.println("1) Agregar producto al carrito.");
        System.out.println("2) Eliminar producto del carrito.");
        System.out.println("3) Aplicar descuento.");
        System.out.println("4) Mostrar carrito.");
        System.out.println("5) Salir.");
        System.out.println("------------------------");
    }
}
