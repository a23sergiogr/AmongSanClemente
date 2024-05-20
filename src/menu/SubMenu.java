package src.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un menú compuesto que contiene submenús o elementos de menú individuales.
 */
public class SubMenu implements Menu{
    private String name;
    private List<Menu> items = new ArrayList<>();

    public SubMenu(String name) {
        this.name = name;
    }

    public void addItems(Menu item) {
        items.add(item);
    }

    public void removeItems(Menu item) {
        items.remove(item);
    }

    @Override
    public String showMenu() {
        return showMenu(true,0);
    }

    @Override
    public String showMenu(boolean menu, int index) {
        if(menu){
            StringBuilder sb = new StringBuilder();
            //sb.append("" + name + "\n");
            for(int i = 0; i < items.size(); i++){
                sb.append(items.get(i).showMenu(false, i) + "\n");
            }
            return sb.toString();
        }else{
            return "\t" + index + ". " + name;
        }
    }

    @Override
    public void funcion() {
        System.out.println("Funcion de submenu");
    }
}

/*
    public String showMenu(int profundidad, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < profundidad; i++) {
            sb.append("\t");
        }
        sb.append("" + index + ". " + name + "\n");

        for(int i = 0; i < items.size(); i++){
            for (int j = 0; j < profundidad; j++) {
                sb.append("\t");
            }

            sb.append(items.get(i).showMenu(profundidad + 1, i) + "\n");
        }

        return sb.toString();
    }
 */