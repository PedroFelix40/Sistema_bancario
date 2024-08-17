package utils;

public class CartaoDebito extends Cartao{
    Menu menu = new Menu();

    public double Saldo = 2000;


    @Override
    public void Pagar() {}

    @Override
    public void Pagar(boolean cartaoCardastrado) {
        if(this.getSaldo() < ValorInicial )
        {
            System.out.printf("\nSaldo insuficiente para a compra.");
            Cancelar();
            menu.MenuInicial(this.ValorInicial, cartaoCardastrado);
        }
        else
        {
            this.ValorFinal = this.ValorInicial;
            System.out.printf("\nO valor da compra a ser pago será de: R$%.2f e será debitado em sua conta corrente.", this.ValorFinal);
            Saldo = Saldo - ValorFinal;
        }
    }



    public double getSaldo() {
        return Saldo;
    }

    private void setSaldo(double saldo) {
        Saldo = saldo;
    }
}
