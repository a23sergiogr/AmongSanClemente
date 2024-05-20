package src.jugadores;

import java.util.List;


public class Estudiantes extends Jugador{

    public Estudiantes(String nombre, String color) {
        super(nombre, color);
    }

    @Override
    public String completeTask(List<Jugador> jugadores){
        return "";
    }

    @Override
    public Jugador matar(List<Jugador> jugadores) {  return null;  }
    
    @Override
    public String información(List<Jugador> jugadores){
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante ");
        sb.append(getColor());
        sb.append(" ha completado la tarea. ");

        sb.append("Habitacion Actual: ");
        sb.append(getHabitacionActual().getNombre());
        sb.append("\nOtras Personas el la Habitación: \n");

        for (Jugador jugador : jugadores) {
            if (jugador.getHabitacionActual().equals(getHabitacionActual())) {
                sb.append(jugador.getColor() + "  ");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
