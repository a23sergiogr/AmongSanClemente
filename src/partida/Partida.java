package src.partida;

import src.KeyboardSingleton.KeyBoard;

public class Partida {
    private static Partida instance;
    private KeyBoard kb;
    private Config config;

    private int numTareas;
    private boolean finalizada;
    private int ronda;
    private int numImpostores;	

    private Partida() {

        numImpostores = 2;
        numTareas = 10;
        ronda = 1;

        config = Config.getInstance();
        kb = KeyBoard.getInstance();
        finalizada = false;
    }

    
    public static Partida getInstance() {
        if (instance == null) {
            instance = new Partida();
        }
        return instance;
    }

    public void jugar() {
        config.setTareas(numTareas);
        config.setImpostores(numImpostores);
        config.orderByColor();

        boolean seguinte = true;
        while(seguinte){
            while(!finalizada){
                
                System.out.println("#########################");
                System.out.println("Ronda " + ronda);
                System.out.println("#########################");

                System.out.println(config.showMap());
                System.out.println(config.completeTask());
                System.out.println(config.información());

                System.out.println("Color del estudiante a expulsar:");
                String expulsion = kb.readStringWithTimeout2();
                if(expulsion.equals("Tiempo Excedido"))
                    System.out.println("Se ha excedido el tiempo");
                else{
                    System.out.println("El jugador expulsado es: " + expulsion);
                    if(config.checkImpostor(expulsion))
                        System.out.println("El jugador expulsado era un impostor");
                    else if(config.checkEstudiante(expulsion))
                        System.out.println("El jugador expulsado era un estudiante");
                    else
                        System.out.println("El jugador no existe");
                    config.deletePlayer(expulsion);
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(config.checkWin()==1){
                    System.out.println("Los impostores han ganado pues lograron matar a todos los estudiantes");
                    finalizada = true;
                }
                else if(config.checkWin()==2){
                    System.out.println("Los estudiantes han ganado pues lograron expulsar a todos los impostores");
                    finalizada = true;
                }
                else if (numTareas == ronda){
                    System.out.println("Los estudiantes han completado todas las tareas, por lo tanto ganan la partida");
                    finalizada = true;
                }

                    
                ronda++;
            }
            System.out.println("Fin del juego");
            System.out.println("Otra partida cos mesmos xogadores? (s/n)");
            String respuesta = kb.readString();
            if(respuesta.equals("n"))
                seguinte = false;
            else{
                finalizada = false;
                ronda = 1;
                config.softResert(numTareas,numImpostores);
            }
        }
    }

    public int getNumImpostores() {
        return numImpostores;
    }

    public void setNumeroImpostores(int numImpostores) {
        this.numImpostores = numImpostores;
    }

    public void setNumeroTareas(int numTareas) {
        this.numTareas = numTareas;
    }

    public int getNumeroTareas() {
        return numTareas;
    }
}
