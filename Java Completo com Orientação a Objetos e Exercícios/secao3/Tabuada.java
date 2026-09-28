package secao3;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o número que você quer ler na tabuada: ");
        int numero = scan.nextInt();
        int resultado = 0;

        for (int i = 1; i <= 10; i++) {
            resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }

        scan.close();
    }
}
