package Secao7;
import java.util.Scanner;
import java.util.Arrays;

public class JogoForca {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String palavraSecreta = "suco".toUpperCase();

        char[] palavraOculta = new char[palavraSecreta.length()];

        for(int i = 0; i < palavraOculta.length; i++){
            palavraOculta[i] = '_';
        }

        int tentativas = 6;
        boolean venceu = false;

        while(tentativas > 0){
           System.out.println("Palavra: " + String.valueOf(palavraOculta));
           System.out.println("Tentativas: " + tentativas);
           System.out.print("Digite uma letra: ");
           char letra = input.next().toUpperCase().charAt(0);

           boolean acetou = false;

           for(int i = 0; i < palavraSecreta.length(); i++){
               if(palavraSecreta.charAt(i) == letra){
                   palavraOculta[i] = letra;
                   acetou = true;
               }
           }

           if(!acetou){
               tentativas--;
               System.out.println("Letra incorreta!");
           } else {
               System.out.println("Letra correta!");
           }

            System.out.println(String.valueOf(palavraOculta));

           if(String.valueOf(palavraOculta).equals(palavraSecreta)){
                venceu = true;
                break;
           }
        }

        if(venceu){
            System.out.println("Parabéns! Você venceu em tentativas " + tentativas);
        } else {
            System.out.println("Você Perdeu!");
        }

        System.out.println("A palavra era: " + palavraSecreta);

        input.close();
    }
}
