package utils;

import java.util.Random;

public class Boleto extends Pagamento {
    Random CodigoDeBarras = new Random();

    private String CodigoBarras()
    {
        int code1 = CodigoDeBarras.nextInt(9);
        int code2 = CodigoDeBarras.nextInt(9000);
        int code3 = CodigoDeBarras.nextInt(90000);
        int code4 = CodigoDeBarras.nextInt(9000);
        int code5 = CodigoDeBarras.nextInt(90000);
        int code6 = CodigoDeBarras.nextInt(9000);
        int code7 = CodigoDeBarras.nextInt(9);
        int code8 = CodigoDeBarras.nextInt(90000);
        int code9 = CodigoDeBarras.nextInt(90000);
        //Código de barras

        return "0339"+ code1 +"."+code2+".5 "+code3+"."+code4+"5 "+code5+"."+code6+"5 "+code7+" "+code8+"."+code9;
    }

    public void Registrar()
    {
        this.ValorFinal = this.ValorInicial * 0.88f;

        System.out.println("\n");
        System.out.println("Compras efetuadas no boleto têm 12% de desconto!!");

        String boletoFormat = String.format(
                "\n____________________________________________________________________________\n" +
                        "Beneficiário: Projeto Loja Virtual\n" +
                        "Valor do boleto: R$%.2f\n" +
                        "Código de barras: %s",
                this.ValorFinal,CodigoBarras()
        );

        System.out.println(boletoFormat);
    }
}
