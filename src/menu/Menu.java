package src.menu;

/**
 * Interfaz para representar un menú, que puede ser un elemento de menú individual o un menú compuesto.
 */
public interface Menu {

    String showMenu();
    String showMenu(boolean menu, int index);

    void funcion();
}