package src.KeyboardSingleton;

import java.util.Scanner;

public class KeyBoard {
    private static KeyBoard instance;
    private Scanner scanner;
    private static int LIMIT_TIME = 10; // segundos

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
