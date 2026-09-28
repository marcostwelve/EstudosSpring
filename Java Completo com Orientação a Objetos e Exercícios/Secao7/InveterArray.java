package Secao7;

import java.util.Scanner;

public class InveterArray {
    public static void main(String[] args) {
        var numeros = inverterArray(new int[]{1, 2, 3, 4, 5});
        for(int numero : numeros) {
            System.out.println(numero);
        }
    }

    public static int[]  inverterArray(int[] numeros) {
        int invertido[] = new int[numeros.length];

        for(int i = 0; i < numeros.length; i++) {
            invertido[i] = numeros[numeros.length - 1 - i];
        }

        return invertido;
    }
}
