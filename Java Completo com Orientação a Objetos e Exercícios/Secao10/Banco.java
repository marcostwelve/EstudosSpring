package Secao10;

public class Banco {
    private double saldo;

    public Banco(double saldo)  {
        this.saldo = saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para sacar: " + valor);
        }

        this.saldo -= valor;

        System.out.println("Saldo realizado com sucesso! Saldo atual: " + this.saldo);
    }
}
