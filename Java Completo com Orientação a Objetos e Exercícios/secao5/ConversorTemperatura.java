package secao5;

import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Qual tipo de temperatura você quer? 1 Celsius 2 Farenheit: ");
        int escolha = input.nextInt();

        switch (escolha) {
            case 1:
                System.out.print("Digite a temperatura em Celsius: ");
                double celsius = input.nextFloat();
                double farenheit = celsiusToFahrenheit(celsius);
                System.out.println("A temperatura em Farenheit é: " + farenheit);
                break;
            case 2:
                System.out.print("Digite a temperatura em Farenheit: ");
                double farenheit2 = input.nextFloat();
                double celsius2 = farenheitToCelsius(farenheit2);
                System.out.println("A temperatura em Celsius é: " + celsius2);
                break;
             default:
                System.out.println("Opção inválida");
                break;
        }

        input.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }
    public static double farenheitToCelsius(double farenheit) {
        return (farenheit - 32) / 1.8;
    }
}
