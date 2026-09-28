package Secao7;
import java.util.Arrays;
public class Arrays2 {
    public static void main(String[] args) {
        int[] numeros = {1, 3, 4, 5, 6, 77};

        String[] frutas = {"banana", "maçã", "laranja", "abacaxi"};

        for(int i = 0; i < numeros.length; i++) {
            numeros[i] *= i;
        }

        for(int numero : numeros) {
            System.out.println(numero);
        }

        for(int i = 0; i < frutas.length; i++) {
           if(frutas[i].equals("laranja")) {
               frutas[i] = "abacate";
           }
        }

        for(String fruta : frutas) {
            System.out.println(fruta);
        }

        String dadosNumericos = Arrays.toString(numeros);
        System.out.println(dadosNumericos);

        int[] teste = new int[3];
        System.out.println(Arrays.toString(teste));
    }
}
