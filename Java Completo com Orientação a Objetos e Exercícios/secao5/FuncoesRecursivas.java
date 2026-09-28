package secao5;

import java.util.Arrays;
import java.util.List;

public class FuncoesRecursivas {

    public static void main(String[] args) {

        // Exemplo de função recursiva para calcular a soma dos números de 1 a n.
        int soma = somaRecursiva(6);
        System.out.println(soma);

        // Sobrecarga de funções (Overloading)
        System.out.println(soma(2, 3)); // Chama a função soma(int a, int b)
        System.out.println(soma(2, 3, 4)); // Chama a função soma(int a, int b, int c)
        System.out.println(soma(2.5, 3.5)); // Chama a função soma(double a, double b)

        // Função anonimas
        Runnable tarefa = () -> System.out.println("Minha dunção anônima");
        tarefa.run();

        List<String> nomes = Arrays.asList("João", "Maria", "Pedro");

        nomes.forEach(nome -> System.out.println(nome));
    }


    // Função recursiva é a forma de a função se auto invocar (chamar ela mesma dentro dela mesma), para resolver um problema, onde a função se chama até chegar em um caso base, onde a função para de se chamar.
    public static int somaRecursiva(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num + somaRecursiva(num - 1);
        }
    }

    public static int soma(int a, int b) {
        return a + b;
    }

    public static int soma(int a, int b, int c) {
        return a + b + c;
    }

    public static double soma(double a, double b) {
        return (a + b);
    }
}
