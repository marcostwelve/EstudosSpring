package Secao7;

import java.util.Arrays;

public class Matrizes {
    public static void main(String[] args) {

        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(matriz[0][1]);

        int[][] tabela = new int[3][3];
        tabela[0][0] = 10;
        tabela[1][1] = 20;
        tabela[2][2] = 30;

        for(int[] linha : tabela){
            System.out.println(Arrays.toString(linha));
        }

        int[][] grade = new int[4][5];

        for(int m = 0; m < grade.length; m++){
            for(int n = 0; n < grade[m].length; n++){
                grade[m][n] = m * n;
            }
        }
        for(int[] linha : grade){
            System.out.println(Arrays.toString(linha));
        }
    }
}
