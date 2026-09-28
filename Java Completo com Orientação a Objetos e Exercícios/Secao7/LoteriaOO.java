package Secao7;

import java.util.ArrayList;
import java.util.Scanner;

public class LoteriaOO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Bilhete> bilhetes = new ArrayList<>();

        while(true) {
            System.out.println("Digite os seis números para o seu bilhete(entre 1 a 60 ");

            int[] numerosEscolhidos = new int[6];

            // Usuário escolhe números
            for(int i = 0; i < numerosEscolhidos.length; i++) {
                System.out.println("Digite um número " + (i + 1) + ": ");
                numerosEscolhidos[i] = input.nextInt();
            }

            // Criando o bilhete com os números escolhidos
            Bilhete bilhete = new Bilhete(numerosEscolhidos);
            bilhetes.add(bilhete);

            // Pergunta se o usuário quer continuar registrando bilhetes
            System.out.println("Deseja registrar outro bilhete (sim / não)");
            String resposta = input.next();

            if (resposta.equals("não")) {
                break;
            }
        }

        //Realizando Sorteio
        System.out.println("Sorteando os números...");

        for(Bilhete bilhete : bilhetes) {
            bilhete.realizarSorteio();
            bilhete.exibirResultados();
        }

        input.close();

    }
}
