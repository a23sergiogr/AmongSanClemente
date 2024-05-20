package src.KeyboardSingleton;

import java.util.Scanner;

public class KeyBoard {
    private static KeyBoard instance;
    private Scanner scanner;
    private static int LIMIT_TIME = 10; // segundos
    private static boolean timeOut = false;
    private Thread inputThread;
    private static String output;
    private static boolean finalizadoThread = true;
    private static boolean finalizadoPrincipal = true;

    private KeyBoard() {
        scanner = new Scanner(System.in);
    }

    public static KeyBoard getInstance() {
        if (instance == null) 
            instance = new KeyBoard();        
        return instance;
    }

    public void setTimeLimit(int time) {
        LIMIT_TIME = time;
    }

    public int getTimeLimit() {
        return LIMIT_TIME;
    }

    public String readString() {
        String input = "";
        while (input.equals("")) 
            input = scanner.nextLine();            
        
        return input;
    }

    public int readInt() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    static class InputThread extends Thread {
        Scanner scanner;
        private String input = "";
        private boolean puedeContinuar = true;

        public InputThread( Scanner scanner) {
            this.scanner = scanner;
        }

        public void putInput(String input) {
            output = input;
        }

        public void setPuedeContinuar(boolean puedeContinuar) {
            this.puedeContinuar = puedeContinuar;
        }

        public void run() {
            finalizadoThread = false;
            input = scanner.nextLine();
            putInput(input);
            finalizadoThread = true;
            System.out.println("Thread Finalizado");
            return;
        }
    }

    public String readStringWithTimeout() {
        timeOut = false;
        output = null;
        finalizadoPrincipal = false;

        while (!finalizadoThread) {
            try {
                Thread.sleep(1000);
                System.out.println("Esperando");
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        
        inputThread = new InputThread(scanner);
        try {
            inputThread.start();
            int i = 0;
            while (
                output == null &&
                i < LIMIT_TIME * 5
            ) {
                Thread.sleep(200);
                i++;
            }
            
            if(output == null)
                timeOut = true;
        } catch (Exception e) {
            //e.printStackTrace();
        } 

        ((InputThread) inputThread).setPuedeContinuar(false);

        if (timeOut) {
            return "Tiempo Excedido";
        } else {
            return output;
        }
    }

    public String readStringWithTimeout2(){
        long startTime = System.currentTimeMillis();
        long endTime = startTime + LIMIT_TIME * 1000;
        String input = "";

        input = scanner.nextLine();

        if(System.currentTimeMillis() > endTime){
            return "Tiempo Excedido";
        } else {
            return input;
        }
    }
}
