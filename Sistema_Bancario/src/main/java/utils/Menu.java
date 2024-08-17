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

                    MenuCartao(valorInformado, cartaoCadastrado);

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

    // Menu para cadastrar cartão **************************
    public void MenuCartao(double ValorInformado, boolean CartaoCadastrado)  {
        String resposta = "";
        String cadastroCartao = "";
        String outroCartao = "";
        String input = "";
        String bandeira = "";
        String numeroCartao = "";
        String titular = "";
        String cvv = "";

        // Import do cartão de débito
        CartaoDebito debito = new CartaoDebito();
        debito.ValorInicial = ValorInformado;

        // Import do cartão de crédito
        CartaoCredito pagamentoCredito = new CartaoCredito();
        pagamentoCredito.ValorFinal = ValorInformado;

        do {
            if (CartaoCadastrado == false)
            {
                System.out.printf("\nCadastro de cartão\n");

                System.out.printf("\nQual a bandeira do cartão:");
                bandeira = sc.next();

                while (bandeira == "")
                {
                    System.out.printf("\nCampo digitado inválido. Digite um valor válido para a bandeira do cartão:");
                    bandeira = sc.next();
                }

                System.out.printf("\nDigite o número do cartão:");
                numeroCartao = sc.next();

                while (numeroCartao == "")
                {
                    System.out.printf("\nCampo digitado inválido. Digite um valor válido para o número do cartão:");
                    numeroCartao = sc.next();
                }

                System.out.printf("\nInsira o nome do titular do cartão:");
                titular = sc.next();

                while (titular == "")
                {
                    System.out.printf("\nCampo digitado inválido. Digite um valor válido para o titular do cartão:");
                    titular = sc.next();
                }

                System.out.printf("\nInforme o CVV do cartão:");
                cvv = sc.next();

                while (cvv == "")
                {
                    System.out.printf("\nCampo digitado inválido. Digite um valor válido para o CVV do cartão:");
                    cvv = sc.next();
                }

                System.out.printf(debito.SalvarCartao(bandeira, numeroCartao, titular, cvv));
                CartaoCadastrado = true;
            }

            System.out.printf("\nValor da compra: %.2f", ValorInformado);
            System.out.printf("\nDados do cartão cadastrado");
            System.out.printf("\nTitular do cartão: %s", titular);
            System.out.printf("\nBandeira do cartão: %s", bandeira);
            System.out.printf("\nNúmero do cartão: %s", numeroCartao);
            System.out.printf("\nBandeira do cartão: %s\n", cvv);

            System.out.printf("Escolha dentre as opções abaixo:\n" +
                    "[1] Pagar com o Cartão de Débito\n" +
                    "[2] Pagar com o Cartão de Crédito\n" +
                    "[3] Voltar ao Menu de Cartão\n"
            );
            resposta = sc.next();

//****************************************************************************************************************
            switch (resposta)
            {
                case "1":
                    if (CartaoCadastrado)
                    {
                        debito.Pagar(CartaoCadastrado);
                        do
                        {
                            System.out.printf("\n" +
                                            "\n[1] Finalizar compra" +
                                            "\n[2] Cancelar Operação"
                            );
                            System.out.printf("Insira a opção desejada:");
                            input = sc.next();
                            switch (input)
                            {
                                case "1":
                                    System.out.printf("\nCompra Finalizada...");
                                    try {
                                        Thread.sleep(3000);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    // Como ainda n tenho nenhuma váriavel eu n botei pra imprimir o novo saldo ent só ta saindo do programa
                                    System.exit(0);
                                    break;
                                case "2":
                                    debito.Cancelar();
                                    MenuInicial(ValorInformado, CartaoCadastrado);
                                    break;

                                default:
                                    System.out.printf("\nValor inválido, tente novamente...\n");
                                    break;
                            }

                        } while (input != "2");
                    }
                    else
                    {
                        System.out.printf("\nNão há um cartão de débito cadastrado. Pressione ENTER para voltar ao menu de cadastro:");
                        sc.next();
                        MenuCartao(ValorInformado, CartaoCadastrado);
                    }

                    break;

                case "2":

                    //Cartão de Crédito
                    if (CartaoCadastrado)
                    {
                        pagamentoCredito.Pagar(CartaoCadastrado);
                        do
                        {
                            System.out.printf("\n" +
                                    "\n[1] Finalizar compra" +
                                    "\n[2] Cancelar Operação");

                            input = sc.next();

                            switch (input)
                            {
                                case "1":
                                    System.out.printf("\nCompra Finalizada...");
                                    try {
                                        Thread.sleep(3000);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }

                                    // Como ainda n tenho nenhuma váriavel eu n botei pra imprimir o novo saldo ent só ta saindo do programa
                                    System.exit(0);
                                    break;
                                case "2":
                                    pagamentoCredito.Cancelar();
                                    MenuInicial(ValorInformado, CartaoCadastrado);
                                    break;
                                default:
                                    System.out.printf("\nValor inválido, tente novamente...");
                                    break;
                            }

                        } while (input != "2");
                    }
                    else
                    {
                        System.out.printf("\nNão há um cartão de crédito cadastrado. Pressione ENTER para voltar ao menu de cartão:");
                        sc.next();
                        MenuCartao(ValorInformado, CartaoCadastrado);
                    }

                    break;
/*
                case "3":
                    Console.Clear();
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine($"Cancelando a operação...");
                    Console.WriteLine($"Pressione ENTER para continuar");
                    Console.ReadLine();
                    Console.ResetColor();
                    break;

                default:
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.Clear();
                    Console.WriteLine($"Valor inválido, tente novamente...");
                    Console.ResetColor();
                    break;

 */
            }
            //****************************************************************************************************************

        }while (resposta != "3");
    }

}
