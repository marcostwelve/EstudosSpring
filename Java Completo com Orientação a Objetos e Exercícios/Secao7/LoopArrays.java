package Secao7;

public class LoopArrays {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        String[] frutas = {"A", "B", "C", "D"};

        int soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        System.out.println(soma);


        for(String fruta : frutas) {
            System.out.println(fruta);
        }

        int[] valores = {13, 2, 365, -4, 5};

        int maior = valores[0];
        int j = 0;
        while(j < valores.length) {
            if(valores[j] > maior) {
                maior = valores[j];
            }
            j++;
        }

        System.out.println("O maior valor é: " + maior);
    }
}
