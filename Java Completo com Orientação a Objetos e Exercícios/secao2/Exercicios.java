package secao2;

public class Exercicios {
    public static void main(String[] args) {

        int numero = 10;
        int dobroNumero = numero * 2;

        System.out.println("Resultado: " + dobroNumero);

        char letraB = 'B';

        int codigoLetraB = (int)letraB;

        System.out.println("Resultado: " + codigoLetraB);

        double valor1 = 15.75;
        double  valor2 = 20.40;

        double resultado = valor1 + valor2;
        System.out.println("Resultado: " + resultado);

        long valor3 = 2_000_000_000L;

        int valorCasting = (int) valor3;
        System.out.println("Resultado: " + valorCasting);

        String texto = "Olá, Mundo!";
        String texto2 = "\nSeja bem-vindo ao Java!";
        System.out.println(texto +" "+ texto2);
    }
}
