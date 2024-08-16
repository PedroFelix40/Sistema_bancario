package utils;

public abstract class Cartao extends Pagamento {
    // Atributos
    public String Bandeira = "";
    public String NumeroCartao = "";
    public String Titular = "";
    public String Cvv = "";

    public abstract void Pagar();
    public abstract void Pagar(boolean cartaoCardastrado);

    public String SalvarCartao(String bandeira, String numeroCartao, String titular, String cvv){
        this.Bandeira = bandeira;
        this.NumeroCartao = numeroCartao;
        this.Titular = titular;
        this.Cvv = cvv;

        return "\nCartão cadastrado com sucesso!";
    }


    public String getBandeira() {
        return Bandeira;
    }

    public void setBandeira(String bandeira) {
        Bandeira = bandeira;
    }

    public String getNumeroCartao() {
        return NumeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        NumeroCartao = numeroCartao;
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String titular) {
        Titular = titular;
    }

    public String getCvv() {
        return Cvv;
    }

    public void setCvv(String cvv) {
        Cvv = cvv;
    }
}
