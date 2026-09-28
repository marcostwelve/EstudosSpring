package Secao7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AvancadoArrays {
    public static void main(String[] args) {

        // 1 - Ordenação

        int[] numbers = {5, 6, 2, 6, 3, 22, 1, 9, 0};

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] name = {"João", "Bob", "Pedro", "Marcos"};

        Arrays.sort(name, Comparator.reverseOrder());
        System.out.println(Arrays.toString(name));

        int[][] matriz = {
                {5, 3, 4},
                {1, 9, 0},
                {8, 7, 6}
        };

        // Ordenação de linhas
        Arrays.sort(matriz, Comparator.comparingInt(a -> a[0]));

        for(int[] linha: matriz) {
            System.out.println(Arrays.toString(linha));
        }

        System.out.println(Arrays.deepToString(matriz));

        // Manipulacao Avançada
        int[] original = {1, 2, 3};

        int[] copia = Arrays.copyOf(original, 2);

        System.out.println(Arrays.toString(copia));

        // fill
        int[] numeros = new int[5];
        System.out.println(Arrays.toString(numeros));

        Arrays.fill(numeros, 4);
        System.out.println(Arrays.toString(numeros));

        //transformando array para stream
        int[] valus = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(valus).sum();
        System.out.println(sum);

        //Arrays dinâmicos
        ArrayList<String> frutas = new ArrayList<String>();
        frutas.add("Banana");
        frutas.add("Maça");
        frutas.add("Pepito");
        frutas.add("Kiwi");

        System.out.println(frutas);

        frutas.remove("Banana");

        frutas.remove(1);

        for(String fruta: frutas){
            System.out.println(fruta);
        }

        String frutaEspecifica = frutas.get(0);
        System.out.println(frutaEspecifica);
    }
}
