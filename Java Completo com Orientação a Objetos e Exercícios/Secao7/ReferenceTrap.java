package Secao7;
import java.util.Arrays;

public class ReferenceTrap {
    public static void main(String[] args) {

        // Dois objetos apontando para o mesmo array na memória
        int[] arrayOriginal = {1, 2, 3};

        int[] arrayCopia = arrayOriginal;

        arrayCopia[0] = 10;

        System.out.println("Array original: " + Arrays.toString(arrayOriginal));
        System.out.println("Array original: " + Arrays.toString(arrayCopia));

        // como evitar?

        int[] arrayClone = arrayOriginal.clone();
        arrayClone[0] = 1;
        System.out.println("Array original: " + Arrays.toString(arrayClone));
    }
}
