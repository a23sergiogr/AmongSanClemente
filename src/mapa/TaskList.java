package src.mapa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Clase Singleton
public class TaskList {
    private static TaskList instance;
    private List<Task> tasks;

    private TaskList() {
        tasks = new ArrayList<>();
        Task task = new Task("Tarea 1", getKey());
        tasks.add(task);
        Task task2 = new Task("Tarea 2", getKey());
        tasks.add(task2);
        Task task3 = new Task("Tarea 3", getKey());
        tasks.add(task3);
    }

    public static TaskList getInstance() {
        if (instance == null) {
            instance = new TaskList();
        }
        return instance;
    }
    
    public void addTask(String name) {
        /*
        for (Task task : tasks) {
            if (task.nombre().equals(name)) {
                System.out.println("La tarea ya existe");
                return;
            }
        }
        Task task = new Task(name, getKey());
        tasks.add(task);
        */

        if(tasks.stream().anyMatch(a -> a.nombre().equals(name))) {
            System.out.println("La tarea ya existe");
            return;
        }
        Task task = new Task(name, getKey());
        tasks.add(task);
    }

    private int getKey() {
        Random random = new Random();
        int key = random.nextInt(1000);
        return key;
    }

    public void removeTask(String name) {
        tasks.removeIf(task -> task.nombre().equals(name));
    }

    public String showTasks() {
        StringBuilder sb = new StringBuilder();
        tasks.forEach(task -> sb.append(task.toString() + "\n"));
        return sb.toString();
    }

}
