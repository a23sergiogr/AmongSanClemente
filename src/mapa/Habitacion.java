package src.mapa;

import java.util.Set;

public class Habitacion {
    private String nombre;
    private Set<Habitacion> habitacionesVecinas;

    public Habitacion(String nombre) {
        habitacionesVecinas = new java.util.HashSet<>();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    

    public Set<Habitacion> getHabitacionesVecinas() {
        return habitacionesVecinas;
    }

    public void setHabitacionesVecinas(Habitacion habitacionVecina) {
        habitacionesVecinas.add(habitacionVecina);
        habitacionVecina.getHabitacionesVecinas().add(this);
    }

    public int getId() {
        return habitacionesVecinas.hashCode();
    }
}
