package tiendaonline;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventario {

    private final Scanner scanner = new Scanner(System.in);
    ArrayList<Producto> productos = new ArrayList<>();

    public Inventario() {
        productos.add(new Producto(1, "Polera Basica Hombre", "Adidas", 14990));
        productos.add(new Producto(2, "Jeans Skinny Mujer", "Levi's", 39990));
        productos.add(new Producto(3, "Chaqueta de Cuero", "Zara", 79990));
        productos.add(new Producto(4, "Zapatillas Air Max", "Nike", 89990));
        productos.add(new Producto(5, "Vestido Estampado", "H&M", 29990));
        productos.add(new Producto(6, "Poleron Oversize", "Puma", 34990));
        productos.add(new Producto(7, "Camisa Formal Hombre", "Tommy Hilfiger", 49990));
        productos.add(new Producto(8, "Abrigo Largo Mujer", "Mango", 99990));
        productos.add(new Producto(9, "Mochila Urbana", "Jansport", 24990));
        productos.add(new Producto(10, "Bufanda de Lana", "Gap", 12990));
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void listarProductos() {
        System.out.println("\n=== LISTA DE PRODUCTOS DISPONIBLES ===");
        for (Producto producto : productos) {
            System.out.println("(" + producto.getIdProducto() + ")" + " " + producto.getMarca() + " " + producto.getNombre() + ", " + "$" + producto.getValor());
        }
    }

    public Producto seleccionarProducto() {
        listarProductos();
        System.out.print("Ingrese el codigo del producto que desea comprar: ");
        try {
            int cod = scanner.nextInt();
            scanner.nextLine();

            for (Producto p : productos) {
                if (p.getIdProducto() == cod) {
                    System.out.println("Ha comprado: " + p.getNombre());
                    return p;
                }
            }
            System.out.println("Producto no encontrado.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no valida. Intente otra vez.");
        }
        return null;
    }
}
