package secao4;

import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite sua altura: ");
        float altura = scanner.nextFloat();
        System.out.print("Digite sua peso: ");
        float peso = scanner.nextFloat();

        float imc = peso / (altura * altura);

        if (imc < 18.5) {
            System.out.println("Seu imc: " +imc+ " Você está abaixo do peso!");
        } else if (imc > 18.5 && imc < 24.9) {
            System.out.println("Seu imc: " +imc+ " Você está com peso normal!");
        } else if (imc > 24.9 && imc < 29.9) {
            System.out.println("Seu imc: " +imc+ " Você está com sobrepeso!");
        } else if (imc > 29.9 && imc < 31) {
            System.out.println("Seu imc: " +imc+ " Você está acima do peso!");
        } else {
            System.out.println("Seu imc: " +imc+ " Obesidade! Procure um médico");
        }
    }
}
