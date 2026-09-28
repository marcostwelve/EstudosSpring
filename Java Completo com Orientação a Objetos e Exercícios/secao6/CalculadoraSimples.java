package secao6;

import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {

        calculadora(10, 5);
    }

    public static void calculadora(double n1, double n2) {

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o tipo de operação que deseja (+, -, *, / )");
        String operacao = input.nextLine();

        switch(operacao){
            case "+":
                System.out.println(n1 + n2);
                break;
            case "-":
                System.out.println(n1 - n2);
                break;
            case "*":
                System.out.println(n1 * n2);
                break;
            case "/":
                System.out.println(n1 / n2);
            default:
                System.out.println("Operação inválida");
                break;
        }

        input.close();
    }
}
