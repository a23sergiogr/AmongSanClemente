package src.jugadores;

import java.util.List;
import java.util.Stack;

import src.mapa.Habitacion;
import src.mapa.Mapa;
import src.mapa.Task;

public class Jugador {
    private Stack<Task> tareas;
    private int habitacionActual;
    private String nombre;
    private String color;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        tareas = new Stack<Task>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public Habitacion getHabitacionActual() {
        return Mapa.getInstance().getHabitacion(habitacionActual);
    }

    public int getHabitacionActualInt() {
        return habitacionActual;
    }

    public void setHabitacionActual(int habitacionActual) {
        this.habitacionActual = habitacionActual;
    }

    public void addTarea(Task tarea) {
        tareas.push(tarea);
    }

    public Task getTarea() {
        return tareas.peek();
    }

    public Task removeTask() {
        return tareas.pop();
    }

    public boolean tareasCompletadas() {
        return tareas.isEmpty();
    }

    public String completeTask(List<Jugador> jugadores) {
        return "Tarea completada";
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + " Color: " + color;
    }

    public Jugador matar(List<Jugador> jugadores) { return null; }

    public String información(List<Jugador> jugadores) {
        return "";
    }
}
