package Secao10;

public class SaldoInsuficienteException extends Exception {

    // Toda classe que herda de Exception, tem que enviar pelo menos a mensagem
    // getMessage -> mensagem
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
