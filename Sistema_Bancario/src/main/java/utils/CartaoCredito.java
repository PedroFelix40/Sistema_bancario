package utils;

import java.util.Scanner;

public class CartaoCredito extends Cartao{
    Menu menu = new Menu();
    Scanner sc = new Scanner(System.in);

    private double Limite = 2000;
    public double ValorParcela;

    public int Parcelas;

    // Método para exibir o limite do cartão
    public void ExibirLimite()
    {
        System.out.printf("\nO limite atual é: %.2f", this.Limite);
    }



    @Override
    public void Pagar() {
    }

    @Override
    public void Pagar(boolean cartaoCadastrado) {

        ExibirLimite();
        System.out.print("");
        System.out.print("\nInforme em quantas parcelas deseja pagar o produto: (máximo de 12 parcelas)" +
                "\n[1x] - Sem juros" +
                "\n[2x - 6x] - Juros de 5%" +
                "\n[7x - 12x] - Juros de 8%"
        );

        do {
            System.out.print("\nInforme a quantidade de parcelas. Digite entre 1 ou 12 parcelas: ");
            Parcelas = sc.nextInt();
        }while (this.Parcelas > 12 || this.Parcelas <= 0);


        do {
            if (this.ValorInicial > this.Limite)
            {
                System.out.printf("\nLimite do cartão excedido");

                ExibirLimite();

                Cancelar();
                menu.MenuInicial(this.ValorInicial, cartaoCadastrado);

            }

            if (this.Parcelas == 1)
            {
                this.ValorParcela = this.ValorInicial / this.Parcelas;
                ValorFinal = this.ValorParcela;

            }
            else if (this.Parcelas <= 6)
            {
                this.ValorParcela = this.ValorInicial / this.Parcelas;
                this.ValorFinal = this.ValorParcela * 1.05;

            }
            else if (this.Parcelas > 6)
            {
                this.ValorParcela = this.ValorInicial / this.Parcelas;
                this.ValorFinal = this.ValorParcela * 1.08;

            }
            else
            {
                while (this.Parcelas > 12 && this.Parcelas <= 0)
                {
                    System.out.printf("Número de parcelas inválido. Digite entre 1 ou 12 parcelas: ");
                    this.Parcelas = sc.nextInt();
                }
            }
        }while(this.ValorFinal > this.Limite);

        if (this.Parcelas > 1)
        {
            System.out.printf("\nTotal: R$%.2f de %dx com juros.", this.ValorFinal, this.Parcelas);
        }
        else
        {
            System.out.printf("\nTotal: R$%.2f de %dx sem juros.", this.ValorFinal, this.Parcelas);
        }

    }


}
