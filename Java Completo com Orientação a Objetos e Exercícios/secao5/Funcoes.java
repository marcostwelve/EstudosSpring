package secao5;

public class Funcoes {
    public static void main(String[] args) {
        saudacao();
        soma(1, 2);
        saudar("Maurício");
        int numeroDobrado = dobrar(2);
        System.out.println(numeroDobrado);
        System.out.println(dobrar(54));

        String r1 = verificarPar(3);
        String r2 = verificarPar(numeroDobrado);
        System.out.println(r1);
        System.out.println(r2);

        int x = dobrar(soma2(3, 4));
        System.out.println(x);
    }

    public static void saudacao() {
        System.out.println("Saudando");
    }

    public static void soma(int a, int b) {
        int soma = a + b;
        System.out.println(soma);
    }

    public static void saudar(String nome) {
        System.out.println("Olá " +nome+ "! Seja bem vindo");
    }

    public static int dobrar(int n) {
        return n * 2;
    }

    public static String verificarPar(int n) {
        if (n % 2 == 0) {
            return "O número " +n+ " é par!";
        } else {
            return "O número " +n+ " é ímpar!";
        }
    }

    public static int soma2(int a, int b) {
        return a + b;
    }
}
