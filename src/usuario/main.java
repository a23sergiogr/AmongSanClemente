package src.usuario;

import src.KeyboardSingleton.*;
import src.menu.*;
import src.mapa.*;
import src.jugadores.*;
import src.partida.*;
import java.util.*;

public class main {

    public static void main(String[] args) {
        // Probar Menú
        /*
         * CrearMenu menu = CrearMenu.getInstance();
         * menu.useMenu();
         */

        // Probar Singleton
        /*
         * KeyBoard keyboard = KeyBoard.getInstance();
         * keyboard.setTimeLimit(5);
         * System.out.println(keyboard.getTimeLimit());
         * System.out.println(keyboard.readStringWithTimeout2());
         * System.out.println(keyboard.readStringWithTimeout2());
         * System.out.println(keyboard.readStringWithTimeout2());
         * System.out.println("continua el");
         */

        // Probar Partida
        
         Partida partida = Partida.getInstance();
         partida.jugar();
          
         
         /*
         * //Probar Mapas
         * MapaFactory mapaA = new MapaFactoryA();
         * MapaFactory mapaB = new MapaFactoryB();
         * 
         * System.out.println(mapaA.getMapa());
         * System.out.println(mapaB.getMapa());
         */

    }

}
