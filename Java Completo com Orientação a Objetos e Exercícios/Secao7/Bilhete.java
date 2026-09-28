package Secao7;

import java.util.Arrays;
import java.util.Random;

public class Bilhete {
    private int[] numerosEscolhidos;
    private int[] numerosSorteados;

    public Bilhete(int[] numerosEscolhidos) {
        this.numerosEscolhidos = Arrays.copyOf(numerosEscolhidos, numerosEscolhidos.length);
    }

    // Método para realizar o Sorteio
    public void realizarSorteio() {
        Random random = new Random();
        numerosSorteados = new int[6];

        for (int i = 0; i < numerosSorteados.length; i++) {
            numerosSorteados[i] = random.nextInt(60) + 1; // Gera números entre 1 e 60
        }

        Arrays.sort(numerosSorteados);
    }

    // Método para verificar quantos números foram acertados

    public int contarAcertos() {
        int acertos = 0;
        for(int numeroEscolhido : numerosEscolhidos) {
            for(int numeroSorteado :  numerosSorteados) {
                if(numeroEscolhido == numeroSorteado) {
                    acertos++;
                }
            }
        }

        return acertos;
    }

    // Exibir resultados

    public void exibirResultados() {
        System.out.println("Números escolhidos: " + Arrays.toString(numerosEscolhidos));
        System.out.println("Números sorteados: " + Arrays.toString(numerosSorteados));

        int acertos = contarAcertos();

        System.out.println("Quantidade de acertos: " + contarAcertos());
        System.out.println();
    }
}
