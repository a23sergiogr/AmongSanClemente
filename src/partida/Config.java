package src.partida;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import src.jugadores.Estudiantes;
import src.jugadores.Impostor;
import src.jugadores.Jugador;
import src.mapa.Task;
import src.mapa.Mapa;

//Clase Singleton
public class Config {
    private static Config instance;
    private List<Task> tasks;
    private List<Jugador> players;
    private List<Jugador> muertos;
    private Mapa mapa;

    private Config() {
        mapa = Mapa.getInstance();
        iniPlayerList();
        iniTaskList();
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
    
    //Funciones de configuración del mapa
    public String showMap() {
        return mapa.getMapa();
    }


    //Funciones de configuración de la lista de tareas
    private void iniTaskList(){
        tasks = new ArrayList<>();
        tasks.add(new Task("Monitoreo de Sistemas de Vida", 0));                // Cafeteria
        tasks.add(new Task("Operaciones de Navegación", 3));                    // Navegacion
        tasks.add(new Task("Mantenimiento de Propulsores", 1));                 // Armas
        tasks.add(new Task("Gestión de Recursos", 0));                          // Cafeteria
        tasks.add(new Task("Comunicaciones de Misión", 5));                     // Comunicaciones
        tasks.add(new Task("Investigación Científica", 3));                     // Navegacion
        tasks.add(new Task("Mantenimiento de Equipos Electrónicos", 4));        // Electricidad
        tasks.add(new Task("Control de Calidad del Aire", 0));                  // Cafeteria
        tasks.add(new Task("Operaciones de Carga y Descarga", 1));              // Armas
        tasks.add(new Task("Asistencia Médica", 2));                            // Medicina
        tasks.add(new Task("Entrenamiento de Tripulación", 2));                 // Medicina
        tasks.add(new Task("Mantenimiento de Robótica", 6));                    // Reactor
        tasks.add(new Task("Exploración Extravehicular", 3));                   // Navegacion
        tasks.add(new Task("Monitoreo de Radiación", 1));                       // Armas
        tasks.add(new Task("Gestión de Residuos", 0));                          // Cafeteria
        tasks.add(new Task("Despliegue de Satélites", 3));                      // Navegacion
        tasks.add(new Task("Recolección de Datos Meteorológicos", 3));          // Navegacion
        tasks.add(new Task("Pruebas de Sistemas de Emergencia", 4));            // Electricidad
        tasks.add(new Task("Monitoreo de Combustible", 5));                     // Comunicaciones
        tasks.add(new Task("Operación de Instrumentos Científicos", 3));        // Navegacion
        tasks.add(new Task("Mantenimiento de la Integridad Estructural", 6));   // Reactor
        tasks.add(new Task("Control de Temperatura", 0));                       // Cafeteria
        tasks.add(new Task("Monitoreo de Sensores Externos", 3));               // Navegacion
        tasks.add(new Task("Gestión de Energía", 6));                           // Reactor
        tasks.add(new Task("Mantenimiento de Sistemas Hidráulicos", 1));        // Armas
        tasks.add(new Task("Análisis de Datos Científicos", 3));                // Navegacion
        tasks.add(new Task("Coordinación de Experimentos Biológicos", 2));      // Medicina
        tasks.add(new Task("Actualización de Software de Nave", 4));            // Electricidad
    }

    public void addTask(String name) {
        if(tasks.stream().anyMatch(a -> a.nombre().equals(name))) {
            System.out.println("La tarea ya existe");
            return;
        }
        Task task = new Task(name, getKey());
        tasks.add(task);
    }

    private int getKey() {
        Random random = new Random();
        int key = random.nextInt(7);
        return key;
    }

    public void removeTask(String name) {
        tasks.removeIf(task -> task.nombre().equals(name));
    }

    public void setTareas(int numTareas) {
        for(Jugador p: players) {
            for(int i = 0; i < numTareas; i++) {
                int random = new Random().nextInt(tasks.size());
                p.addTarea(tasks.get(random));
            }
        }
    }

    public String showTasks() {
        StringBuilder sb = new StringBuilder();
        tasks.forEach(task -> sb.append(task.toString() + "\n"));
        return sb.toString();
    }

    //Funciones de configuración de la lista de jugadores
    private void iniPlayerList(){
        players = new ArrayList<Jugador>();
        players.add(new Estudiantes("@Es1", "Rojo"));
        players.add(new Estudiantes("@Es2", "Azul"));
        players.add(new Estudiantes("@Es3", "Verde"));
        players.add(new Estudiantes("@Es4", "Amarillo"));
        players.add(new Estudiantes("@Es5", "Naranja"));
        players.add(new Estudiantes("@Es6", "Morado"));
        players.add(new Estudiantes("@Es7", "Cyan"));
        players.add(new Estudiantes("@Es8", "Rosa"));
        muertos = new ArrayList<Jugador>();
    }

    public void addPlayer(String nombre, String color) {
        if(players.stream().anyMatch(j -> j.getNombre().equals(nombre))) {
            System.out.println("El jugador ya existe");
            return;
        }
        players.add(new Jugador(nombre, color));
    }

    public void deletePlayer(String string) {

        if(players.stream().noneMatch(j -> j.getColor().equals(string))) {
            return;
        }

        for(Jugador j: players) {
            if(j.getColor().equals(string)) {
                addMuerto(j);
            }
        }

        //addMuerto(players.stream().filter(j -> j.getColor().equals(string)).findFirst().get());
        
        players.removeIf(j -> j.getColor().equals(string));
    }

    public boolean checkImpostor(String nombre) {
        return players.stream().anyMatch(j -> j.getColor().equals(nombre) && j instanceof Impostor);
    }

    public boolean checkEstudiante(String expulsion) {
        return players.stream().anyMatch(j -> j.getColor().equals(expulsion) && j instanceof Estudiantes);
    }

    public void orderByColor() {
        Collections.sort(players, Comparator.comparing(Jugador::getColor));        
    }

    public void setImpostores(int numImpostores) {
        for(int i = 0; i < numImpostores; i++) {
            int random = new Random().nextInt(players.size());
            while (players.get(random) instanceof Impostor)
                random = new Random().nextInt(players.size());                
            Impostor impostor = new Impostor(players.get(random).getNombre(), players.get(random).getColor());
            deletePlayer(players.get(random).getColor());
            players.add(impostor);
        }
    }

    public String showPlayers() {
        StringBuilder sb = new StringBuilder();
        players.forEach(j -> sb.append(j.toString() + "\n"));
        return sb.toString();
    }

    public void addMuerto(Jugador j) {
        muertos.add(j);
    }

    //Funciones el funcionamiento de la partida
    public String completeTask() {
        
        for(Jugador p: players) {
            if(!p.tareasCompletadas()){
                Task t = p.removeTask();
                p.setHabitacionActual(t.habitacion());       
            }
        }

        StringBuilder sb = new StringBuilder();
        List<Jugador> impostores = new ArrayList<>();
        List<Jugador> estudiantes = new ArrayList<>();
        for(Jugador j: players) {
            if(j instanceof Impostor) {
                impostores.add(j);
            } else {
                estudiantes.add(j);
            }
        }
        for(Jugador j: impostores) {
           Jugador muerto = j.matar(players);
           if(muerto != null) {
               deletePlayer(muerto.getColor());
           }
        }
        for(Jugador j: estudiantes) {
            sb.append(j.completeTask(players) + "\n");
        }
        
        return sb.toString();
    }

    public String información() {
        StringBuilder sb = new StringBuilder();
    
        players.forEach(j -> sb.append(j.información(players) + "\n"));

        return sb.toString();
    }

    public int checkWin() {
        int impostores = 0;
        int estudiantes = 0;
        for(Jugador j: players) {
            if(j instanceof Impostor) {
                impostores++;
            } else {
                estudiantes++;
            }
        }
        if(estudiantes == 0) {
            System.out.println("Los impostores han ganado");
            return 1;
        }
        if(impostores == 0) {
            System.out.println("Los estudiantes han ganado");
            return 2;
        }
        return 0;
    }

    public void softResert(int numTareas, int numImpostores) {
        //Todos los jugadores se vuelven estudiantes
        System.out.println("Todos los jugadores se vuelven estudiantes");
        for(Jugador j: players) {
            if(j instanceof Impostor) {
                players.add(new Estudiantes(j.getNombre(), j.getColor()));
                players.remove(j);
            }
        }
        //Se reviven los muertos
        System.out.println("Se reviven los muertos");
        for(Jugador j: muertos) {
            players.add(new Estudiantes(j.getNombre(), j.getColor()));
        }
        muertos.clear();

        //Se reinician las tareas
        System.out.println("Se reinician las tareas");
        setTareas(numTareas);

        //Se reinicia la habitación de los jugadores
        System.out.println("Se reinicia la habitación de los jugadores");
        for(Jugador j: players) {
            j.setHabitacionActual(0);
        }

        //Se reasignan los impostores
        System.out.println("Se reasignan los impostores");
        setImpostores(numImpostores);

        //Se ordenan los jugadores por color
        System.out.println("Se ordenan los jugadores por color");
        orderByColor();
    }
}
