package tiendaonline.main;

import tiendaonline.model.Inventario;
import tiendaonline.ui.Menu;

public class TiendaOnline {

    public static void main(String[] args) {
        TiendaOnline app = new TiendaOnline();
        app.ejecutar();
    }

    public void ejecutar() {
        
        Inventario inventario = new Inventario();
        Menu menu = new Menu(inventario);
        menu.menuInteractivo();
    }
}
