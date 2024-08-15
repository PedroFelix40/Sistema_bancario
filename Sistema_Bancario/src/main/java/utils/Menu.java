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
            System.out.println("\n\nEscolha a forma de pagamento\n" +
                    "[1] Boleto\n" +
                    "[2] Cartão\n" +
                    "[3] Sair   \n");
            System.out.printf("->");
            resposta =  sc.next();

            switch (resposta)
            {
                case "1" :
                    System.out.printf("\nValor da compra R$%.2f", valorInformado);
                    Boleto boleto = new Boleto();

                    do {
                        boleto.ValorInicial = valorInformado;
                        boleto.Registrar();

                        System.out.println("" +
                                "[1] Finalizar compra\n" +
                                "[2] Cancelar Operação\n");

                        System.out.printf("Insira a opção desejada...");
                        input = sc.next();

                        switch (input)
                        {
                            case "1":
                                System.out.printf("\nCompra Finalizada... Seu boleto vence no dia" + boleto.GerarData());
                                System.exit(0);
                                break;

                            case "2":
                                //boleto.Cancelar();
                                System.out.println("\nA operação será cancelada...\n");
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                MenuInicial(valorInformado, cartaoCadastrado);
                                break;

                            default:
                                System.out.printf("Opção inválida.");
                                sc.next();

                                break;
                        }
                    }while(input != "2");
                    break;

                case "2" :
                    System.out.println("\nPagar no cartão");
                    break;

                case "3" :
                    System.out.println("\nDeseja sair do programa: s/n");
                    resposta = sc.next().toLowerCase();

                    if (resposta == "s")
                    {
                        System.out.printf("Finalizando o programa...");
                        sair = true;

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        System.exit(0);
                    }
                    sair = true;
                    break;
            }
        } while(!sair);
    }

    public void MenuCartao(float ValorInformado, boolean CartaoCadastrado)
    {
        String resposta = "";
        String cadastroCartao = "";
        String outroCartao = "";
        String input = "";
        String bandeira = "";
        String numeroCartao = "";
        String titular = "";
        String cvv = "";
    }

}
