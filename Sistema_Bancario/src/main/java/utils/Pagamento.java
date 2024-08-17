package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Pagamento {
    Menu menu = new Menu();

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public double ValorInicial;
    public double ValorFinal;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[41m";



    public String GerarData(){
        Date DataFinal = new Date();
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dataFormatada = formatter.format(DataFinal);
        return dataFormatada;
    }

    public void Cancelar(){
        System.out.println("\n"+ANSI_RED+"A operação será cancelada"+ANSI_RESET);
        System.out.println("Voltando ao menu...");
    }
}
