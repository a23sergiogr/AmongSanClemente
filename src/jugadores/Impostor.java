package src.jugadores;

import java.util.List;
import java.util.Random;

public class Impostor extends Jugador{
    private List<Jugador> jugadoresAsesinados;

    public Impostor(String nombre, String color) {
        super(nombre, color);        
        jugadoresAsesinados = new java.util.ArrayList<>();
    }
    
    @Override
    public String completeTask(List<Jugador> jugadores){
       StringBuilder sb = new StringBuilder();
         sb.append("Impostor ");
            sb.append(getColor());
        return sb.toString();
    }

    @Override
    public Jugador matar(List<Jugador> jugadores) {
        //Cara o Cruz para ver si intenta matar o no
        Random random = new Random();
        if (random.nextBoolean()) {
            return null;
        }

        //Si decide matar a alguien se elige a alguien al azar
        int index = random.nextInt(jugadores.size());
        int i = 0;

        //Se asegura que no se mate a otro impostor y se intenta 10 veces
        //WIP: Se puede mejorar 
        while (jugadores.get(index) instanceof Impostor && i < 10) {
            index = random.nextInt(jugadores.size());   
            i++;         
        }   

        Jugador jugador = jugadores.get(index);
        int habitacion = jugador.getHabitacionActualInt();

        System.out.println(jugador.getColor() + " ha muerto");
        jugadores.stream().filter(j -> j.getHabitacionActualInt() == habitacion && !(j instanceof Impostor) && !(j.equals(jugador)))
                            .forEach(j -> System.out.println(jugador.getColor() + " ha sido encontrado muerto en " + jugador.getHabitacionActual().getNombre()));

                            
        jugador.setHabitacionActual(habitacion);
        setHabitacionActual(habitacion);
        this.setHabitacionActual(habitacion);   
        jugadoresAsesinados.add(jugador);
        return jugador;
    }

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

    public List<Jugador> getJugadoresAsesinados() {
        return jugadoresAsesinados;
    }
}
