package Secao7;

public class ForEachJava {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};

        for(int numero : numeros){
            System.out.println("Núemro é: " + numero);
        }

        //Concatenar arrays

        String[] palavras= {"Java", "é", "fácil"};
        String frase = "";

        for(String palavra : palavras){
            frase += palavra + " ";
        }
        System.out.println(frase);

        char[] letras = {'a', 'e', 'i', 'o', 'u'};
        char letraProcuada = 'i';

        for(char letra : letras) {
            if(letra == letraProcuada) {
                System.out.println("Letra encontrada: " + letra);
            }
        }
    }
}
