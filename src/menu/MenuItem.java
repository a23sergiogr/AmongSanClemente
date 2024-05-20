package src.menu;

import src.KeyboardSingleton.KeyBoard;
import src.partida.*;

/**
 * Clase que representa un elemento de menú individual.
 */
public class MenuItem implements Menu{
    private String name;
    private FuncionesMenu funcionesMenu;

    public MenuItem(FuncionesMenu funcionesMenu) {
        this.funcionesMenu = funcionesMenu;
        switch (funcionesMenu) {
            case EngadirTarefa:
                name = "Engadir tarefa";
                break;
            case BorrarTarefa:
                name = "Borrar tarefa";
                break;
            case VerTarefas:
                name = "Ver tarefas";
                break;
            case SalirTarefas:
                name = "Salir";
                break;
            case EngadirXogador:
                name = "Engadir xogador";
                break;
            case BorrarXogador:
                name = "Borrar xogador";
                break;
            case VerXogadores:
                name = "Ver xogadores";
                break;
            case SalirXogadores:
                name = "Salir";
                break;  
            case ConfigurarTempoMaximo:
                name = "Configurar tempo máximo de resposta";
                break;
            case SalirConfiguracion:
                name = "Salir";
                break;
            case Xogar:
                name = "Xogar";
                break;
            case Salir:
                name = "Salir";
                break;        
            default:
                name = "null";
                break;
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FuncionesMenu getFuncionesMenu() {
        return funcionesMenu;
    }

    public void setFuncionesMenu(FuncionesMenu funcionesMenu) {
        this.funcionesMenu = funcionesMenu;
    }

    @Override
    public String showMenu() {
        return showMenu(true,0);
    }

    @Override
    public String showMenu(boolean menu, int index) {
        return "\t" + index + ". "+ name;
    }

    @Override
    public void funcion() 
    {
        switch (funcionesMenu) {
        case EngadirTarefa:
            System.out.println("Nome da tarefa a introducir: ");
            Config.getInstance().addTask(KeyBoard.getInstance().readString());
            CrearMenu.getInstance().menu00();
            break;
        case BorrarTarefa:
            System.out.println("Nome da tarefa a borrar: ");
            Config.getInstance().removeTask(KeyBoard.getInstance().readString());
            CrearMenu.getInstance().menu00();
            break;
        case VerTarefas:
            System.out.println(Config.getInstance().showTasks());
            CrearMenu.getInstance().menu00();
            break;
        case SalirTarefas:
            CrearMenu.getInstance().menu0();
            break;
        case EngadirXogador:
            System.out.println("Nome do xogador: ");
            String nome = KeyBoard.getInstance().readString();
            System.out.println("Cor do xogador: ");
            String color = KeyBoard.getInstance().readString();
            Config.getInstance().addPlayer(nome, color);
            CrearMenu.getInstance().menu01();
            break;
        case BorrarXogador:
            System.out.println("Nome do xogador a borrar: ");
            Config.getInstance().deletePlayer(KeyBoard.getInstance().readString());
            CrearMenu.getInstance().menu01();
            break;
        case VerXogadores:
            System.out.println(Config.getInstance().showPlayers());
            CrearMenu.getInstance().menu01();
            break;
        case SalirXogadores:
            CrearMenu.getInstance().menu0();
            break;
        case ConfigurarTempoMaximo:
            System.out.println("Tempo máximo de resposta: ");
            KeyBoard.getInstance().setTimeLimit(KeyBoard.getInstance().readInt());
            CrearMenu.getInstance().menu0();
            break;
        case SalirConfiguracion:
            CrearMenu.getInstance().useMenu();
            break;
        case Xogar:
            Partida.getInstance().jugar();
            CrearMenu.getInstance().useMenu();
            break;
        case Salir:
            CrearMenu.getInstance().closeMenu();
            break;
        default:
            break;
        }
    }
}
