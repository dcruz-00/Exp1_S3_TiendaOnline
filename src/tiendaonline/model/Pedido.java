package tiendaonline.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int idPedido;
    private Usuario usuario;
    private List<Producto> productos;
    private int total;

    public Pedido(int idPedido, Usuario usuario) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.productos = new ArrayList<>();
        this.total = 0;
    }

    public void agregarProducto(Producto producto) {
        if(producto != null){
            productos.add(producto);
            total += producto.getValor();
        }
    }

    public void eliminarProducto(Producto producto) {
        if(productos.remove(producto)){
            total -= producto.getValor();
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public int getTotal() {
        return total;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
