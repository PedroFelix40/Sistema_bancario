package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Pagamento {
    Menu menu = new Menu();

    public Date DataAtual = new Date(System.currentTimeMillis());
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public String DataFormatada;
    public double ValorInicial;
    public double ValorFinal;



    public Date GerarData(){
        Date DataFinal = new Date(DataAtual.getYear(), DataAtual.getMonth(), DataAtual.getDay() + 3, DataAtual.getHours(), DataAtual.getMinutes(), DataAtual.getSeconds());
        return DataFinal;
    }

    public void Cancelar(){

        System.out.println("\nA operação será cancelada");
        System.out.println("Voltando ao menu...");
    }
}
