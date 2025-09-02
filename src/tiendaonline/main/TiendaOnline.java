package tiendaonline.main;

import tiendaonline.model.*;
import tiendaonline.ui.Menu;

public class TiendaOnline {
    public static void main(String[] args){
        Usuario usuario = new Usuario(1, "Cliente", "estudiante");
        Inventario inventario = new Inventario();
        Menu menu = new Menu(inventario, usuario);
        menu.menuInteractivo();
    }
}
