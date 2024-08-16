package application;

import utils.Boleto;
import utils.Menu;
import utils.Pagamento;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Console.WriteLine($"\nInsira o valor da compra:");
//        string valorDigitado = Console.ReadLine()!;
//
//        while(valorDigitado == ""){
//            Console.WriteLine($"\nValor informado inválido, digite um preço adequado para um produto");
//            valorDigitado = Console.ReadLine()!;
//        }
//
//        float valorInformado = float.Parse(valorDigitado);
//
//        while(valorInformado <= 0){
//            Console.WriteLine($"\nValor informado inválido, digite um preço adequado para um produto");
//            valorInformado = float.Parse(Console.ReadLine()!);
//        }
//
//
//        bool cartaoCardastrado = false;
//        MenuPrograma.MenuInicial(valorInformado, cartaoCardastrado);
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        double valorDigitado = 0;
        boolean entradaValida = false;

        System.out.printf("\nInsira o valor da compra: ");

        // Validação para verficar se o valor é realmente um número
        while (!entradaValida) {
            if (sc.hasNextDouble()) {
                valorDigitado = sc.nextDouble();

                while (valorDigitado <= 0)
                {
                    System.out.println("Valor inválido. Por favor, insira um número0000.");
                    sc.nextLine();
                    System.out.printf("\nInsira o valor da compra: ");
                    if (sc.hasNextDouble()) {
                        valorDigitado = sc.nextDouble();
                    }
                }


                entradaValida = true;
            }
            else {
                System.out.println("Valor inválido. Por favor, insira um número.");
                sc.nextLine();
                System.out.printf("\nInsira o valor da compra: ");
            }
        }

        boolean cartaoCadastrado = false;
        menu.MenuInicial(valorDigitado, cartaoCadastrado);
        System.out.println("Valor digitado: " + valorDigitado);
    }
}
