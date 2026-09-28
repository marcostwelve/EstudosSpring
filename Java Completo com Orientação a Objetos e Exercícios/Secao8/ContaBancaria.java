package Secao8;

public class ContaBancaria {

    private String titular;
    private double saldo;

    public void setTitular(String titular) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        }
        else {
            System.out.println("Titular inválido. O titular não pode ser nulo ou vazio.");
        }
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
        else {
            System.out.println("Saldo inválido. O saldo deve ser maior que zero.");
        }
    }

    public void exibirContaBancaria() {
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);
    }

    public String getTitular() {
        return this.titular;
    }

    public String getSaldo() {
        return "R$ " + this.saldo;
    }


}
