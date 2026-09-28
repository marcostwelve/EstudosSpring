package Secao7;

public class Arrays1 {
    public static void main(String[] args) {
        // 1- sintaxe

        int[] numeros = {1, 2, 3, 4, 5};

        System.out.println("Acessando o primeiro elemento: " + numeros[0]);

        // tamanho fixo vazio

        String[] frutas = new String[3];
        frutas[0] = "Maça";
        frutas[1] = "Banana";
        frutas[2] = "Caramelo";

        System.out.println("Acessando o segundo elemento: " + frutas[1]);

        double[] precos = {1.99, 2.09, 3.59};

        System.out.println("Acessando o segundo elemento: " + precos[0]);

        int somaPares = 0;

        for(int numero : numeros) {
            if(numero % 2 == 0) {
                somaPares += numero;
            }
        }
        System.out.println("Soma de pares: " + somaPares);

        int nums[] = {12, 6, 18, 24, 48, 5};

        int limite = 10;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > limite) {
                System.out.println("Número maior que " + limite + ": " + nums[i]);
            }
        }

        String[] linguagens = {"Java", "C#", "javascript", "python", "C++"};
        String linguagemAlvo = "javascript";

        for(String linguagen : linguagens) {
            if(linguagen.equals(linguagemAlvo)) {
                System.out.println("Linguagem encontrada: " + linguagen);
                break;
            } else {
                System.out.println("Linguagem não encontrada: " + linguagen);
            }
        }
    }
}
