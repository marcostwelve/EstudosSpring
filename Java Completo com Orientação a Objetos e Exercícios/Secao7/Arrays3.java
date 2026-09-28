package Secao7;

import java.util.Arrays;
import java.util.ArrayList;

public class Arrays3 {
    public static void main(String[] args) {
        int[] numeros = {1, 3, 4, 5, 6, 77};

        String[] frutas = {"banana", "maçã", "laranja", "abacaxi"};
        int[] novoArray = new int[numeros.length + 1];

        for (int i = 0; i < numeros.length; i++) {
            novoArray[i] = numeros[i];
        }

        // ultimo elemento do array
        novoArray[novoArray.length - 1] = 4;

        String[] novofrutas = new String[frutas.length + 1];

        System.arraycopy(frutas, 0, novofrutas, 0, frutas.length);

        novofrutas[novofrutas.length - 1] = "Jaca";

        System.out.println("Novo array de números: " + Arrays.toString(novofrutas));

        // ArrayList

        ArrayList<String> listaFrutas = new ArrayList<>(Arrays.asList(frutas));

        listaFrutas.add("Jaca");
        System.out.println("Lista de frutas: " + listaFrutas);
    }
}
