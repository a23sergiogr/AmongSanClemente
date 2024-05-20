package src.mapa;

public record Task(String nombre, int habitacion) {

    @Override
    public String toString() {
        return "Tareas [nombre=" + nombre + "]";
    }
}
