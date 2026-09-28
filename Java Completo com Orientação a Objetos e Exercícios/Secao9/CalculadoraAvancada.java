package Secao9;

public class CalculadoraAvancada implements Calculadora {

    @Override
    public int somar(int a, int b) {
        return a + b;
    }

    @Override
    public int multiplicar(int a, int b) {
        System.out.println("Multiplicando " + a + " e " + b);
        return a * b;
    }
}
