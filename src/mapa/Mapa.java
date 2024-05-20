package src.mapa;

import java.util.Map;

public class Mapa {
    private static Mapa instance = null;
    private Map<Integer, Habitacion> habitaciones;

    public static Mapa getInstance() {
        if (instance == null) {
            instance = new Mapa();
        }
        return instance;
    }    

    private Mapa () {
        habitaciones = new java.util.HashMap<>();
        habitaciones.put(0, new Habitacion("Cafeteria"));
        habitaciones.put(1, new Habitacion("Armas"));
        habitaciones.put(2, new Habitacion("Medicina"));
        habitaciones.put(3, new Habitacion("Navegacion"));
        habitaciones.put(4, new Habitacion("Electricidad"));
        habitaciones.put(5, new Habitacion("Comunicaciones"));
        habitaciones.put(6, new Habitacion("Reactor"));

        habitaciones.get(0).setHabitacionesVecinas(habitaciones.get(1));
        habitaciones.get(0).setHabitacionesVecinas(habitaciones.get(2));
        habitaciones.get(1).setHabitacionesVecinas(habitaciones.get(3));
        habitaciones.get(1).setHabitacionesVecinas(habitaciones.get(4));
        habitaciones.get(2).setHabitacionesVecinas(habitaciones.get(3));
        habitaciones.get(2).setHabitacionesVecinas(habitaciones.get(5));
        habitaciones.get(3).setHabitacionesVecinas(habitaciones.get(4));
        habitaciones.get(3).setHabitacionesVecinas(habitaciones.get(6));
        habitaciones.get(4).setHabitacionesVecinas(habitaciones.get(6));
    }

    public Habitacion getHabitacion(int habitacion) {
        return habitaciones.get(habitacion);
    }

    public String getMapa() {
        StringBuilder mapa = new StringBuilder();
        mapa.append("Mapa:\n");
        mapa.append("+---+      +---+\n");
        mapa.append("| 0 |------| 1 |----\\\n");
        mapa.append("+---+      +---+     \\\n");
        mapa.append("  |          |        \\\n");
        mapa.append("  |          |         \\\n");
        mapa.append("+---+      +---+      +---+\n");
        mapa.append("| 2 |------| 3 |------| 4 |\n");
        mapa.append("+---+      +---+      +---+\n");
        mapa.append("  |          |          |\n");
        mapa.append("  |          |          |\n");
        mapa.append("+---+        |        +---+\n");
        mapa.append("| 5 |        +--------| 6 |\n");
        mapa.append("+---+                 +---+\n");
        mapa.append("1.- Cafeteria\n");
        mapa.append("2.- Armas\n");
        mapa.append("3.- Medicina\n");
        mapa.append("4.- Navegacion\n");
        mapa.append("5.- Electricidad\n");
        mapa.append("6.- Comunicaciones\n");
        mapa.append("7.- Reactor\n");
        return mapa.toString();
    }   
}
