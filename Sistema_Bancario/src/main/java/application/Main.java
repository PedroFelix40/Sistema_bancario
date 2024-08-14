package application;

import utils.Menu;
import utils.Pagamento;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        //menu.MenuInicial(38.9,true);

        Pagamento p = new Pagamento();

        Date now = new Date();
        System.out.println(p.GerarData());
    }
}
