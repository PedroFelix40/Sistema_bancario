package utils;

import java.util.Random;

public class Boleto extends Pagamento {
    Random CodigoDeBarras = new Random();

    private String CodigoBarras()
    {
        int code = CodigoDeBarras.nextInt(9);
        //Código de barras
        String CodigoDeBarras = "0339{CodigoDeBarras.Next(9).ToString()}.{CodigoDeBarras.Next(9000).ToString()}5 {CodigoDeBarras.Next(90000).ToString()}.{CodigoDeBarras.Next(9000).ToString()}5 {CodigoDeBarras.Next(90000).ToString()}.{CodigoDeBarras.Next(9000).ToString()}5 {CodigoDeBarras.Next(9).ToString()} {CodigoDeBarras.Next(90000).ToString()}.{CodigoDeBarras.Next(90000).ToString()}";
        return CodigoDeBarras;
    }
}
