package src.menu;

import src.KeyboardSingleton.*;
import src.partida.*;;

public class CrearMenu {
    private static CrearMenu crearMenu;
    private SubMenu menu;
    private SubMenu configuracion;
    private SubMenu tarefas;
    private SubMenu xogadores;
    private MenuItem engadirTarefa;
    private MenuItem borrarTarefa;
    private MenuItem verTarefas;
    private MenuItem salirTarefas;
    private MenuItem engadirXogador;
    private MenuItem borrarXogador;
    private MenuItem verXogadores;
    private MenuItem salirXogadores;
    private MenuItem configurarTempoMaximo;
    private MenuItem salirConfiguracion;
    private MenuItem xogar;
    private MenuItem salir;

    private KeyBoard keyboard;

    /*
        0. Configuracion

            0. Tarefas

                    0. Engadir tarefa

                    1. Borrar tarefa

                    2. Ver tarefas.

                    3. Salir

            1. Xogadores.

                    0. Engadir xogador

                    1. Borrar xogador

                    2. Ver xogadores

                    3. Salir.

            2. Configurar tempo máximo de resposta

            3. Salir.

        1. Xogar

        2. Salir 
     */

    private CrearMenu() {
        keyboard = KeyBoard.getInstance();
        menu = new SubMenu("");
        configuracion = new SubMenu("Configuracion");
        menu.addItems(configuracion);
        tarefas = new SubMenu("Tarefas");
        configuracion.addItems(tarefas);
        engadirTarefa = new MenuItem(FuncionesMenu.EngadirTarefa);
        tarefas.addItems(engadirTarefa);
        borrarTarefa = new MenuItem(FuncionesMenu.BorrarTarefa);
        tarefas.addItems(borrarTarefa);
        verTarefas = new MenuItem(FuncionesMenu.VerTarefas);
        tarefas.addItems(verTarefas);
        salirTarefas = new MenuItem(FuncionesMenu.SalirTarefas);
        tarefas.addItems(salirTarefas);
        xogadores = new SubMenu("Xogadores");
        configuracion.addItems(xogadores);
        engadirXogador = new MenuItem(FuncionesMenu.EngadirXogador);
        xogadores.addItems(engadirXogador);
        borrarXogador = new MenuItem(FuncionesMenu.BorrarXogador);
        xogadores.addItems(borrarXogador);
        verXogadores = new MenuItem(FuncionesMenu.VerXogadores);
        xogadores.addItems(verXogadores);
        salirXogadores = new MenuItem(FuncionesMenu.SalirXogadores);
        xogadores.addItems(salirXogadores);
        configurarTempoMaximo = new MenuItem(FuncionesMenu.ConfigurarTempoMaximo);
        configuracion.addItems(configurarTempoMaximo);
        salirConfiguracion = new MenuItem(FuncionesMenu.SalirConfiguracion);
        configuracion.addItems(salirConfiguracion);
        xogar = new MenuItem(FuncionesMenu.Xogar);
        menu.addItems(xogar);
        salir = new MenuItem(FuncionesMenu.Salir);
        menu.addItems(salir);
    }

    public static CrearMenu getInstance() {
        if (crearMenu == null) {
            crearMenu = new CrearMenu();
        }
        return crearMenu;
    }

    public void useMenu() {
        Partida.getInstance();
        showMenu(menu);
        
        switch (keyboard.readInt()) {
            case 0:
                menu0();
                break;
            case 1:
                menu1();
                break;
            case 2:
                menu2();
                break;        
            default:
                break;
        }
    }

    public void menu0() {
        showMenu(configuracion);
        switch (keyboard.readInt()) {
            case 0:
                menu00();
                break;
            case 1:
                menu01();
                break;
            case 2:
                menu02();
                break;
            case 3:
                menu03();
                break;
            default:
                break;
        }
    }

    public void menu00() {
        showMenu(tarefas);
        switch (keyboard.readInt()) {
            case 0:
                engadirTarefa.funcion();
                break;
            case 1:
                borrarTarefa.funcion();
                break;
            case 2:
                verTarefas.funcion();
                break;
            case 3:
                salirTarefas.funcion();
                break;
            default:
                break;
        }
    }

    public void menu01() {
        showMenu(xogadores);
        switch (keyboard.readInt()) {
            case 0:
                engadirXogador.funcion();
                break;
            case 1:
                borrarXogador.funcion();
                break;
            case 2:
                verXogadores.funcion();
                break;
            case 3:
                salirXogadores.funcion();
                break;
            default:
                break;
        }
    }

    private void menu02() {
        configurarTempoMaximo.funcion();
    }

    private void menu03() {
        salirConfiguracion.funcion();
    }

    private void menu1() {
        xogar.funcion();
    }

    private void menu2() {
        salir.funcion();
    }

    public void closeMenu() {
        return;
    }

    private void showMenu(SubMenu menutoShow) {
        System.out.println(menutoShow.showMenu());
    }
}
