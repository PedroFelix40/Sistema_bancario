package application;

import entities.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        double valor = 2.76;
        boolean bool = true;

        menu.MenuInicial(valor, bool);
    }
}
