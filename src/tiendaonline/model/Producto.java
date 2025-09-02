package tiendaonline.model;

public class Producto {

    private int idProducto;
    private String nombre;
    private String marca;
    private int valor;

    public Producto(int idProducto, String nombre, String marca, int valor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.valor = valor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public int getValor() {
        return valor;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
