package utils;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public void MenuInicial(double valorInformado, boolean cartaoCadastrado)
    {
        String resposta = "";
        String input = "";
        boolean sair = false;

        // Inicio
        System.out.println("            === Bem-vindo ===");
        System.out.printf("\nValor da compra: %.2f", valorInformado);

        do {
            System.out.println("\n\nEscolha a forma de pagamento" +
                    "[1] Boleto" +
                    "[2] Cartão" +
                    "[3] Sair   ");
            resposta =  sc.next();

            switch (resposta)
            {
                case "1" :
                    System.out.println("\nPagar no boleto");
                    break;

                case "2" :
                    System.out.println("\nPagar no cartão");
                    break;

                case "3" :
                    System.out.println("\nDeseja sair");
                    sair = true;
                    break;
            }
        } while(!sair);
    }

}
