package secao2;
import java.util.Scanner;

public class TesteScanner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.next();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("OLá " + nome + "! \nVocê tem " + idade + " anos!");

        // Problema NextLine

        System.out.println("Digite um número: ");
        int numero = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite um texto: ");
        String texto = scanner.nextLine();

        System.out.println("Número: " + numero +" texto " + texto);

        // Fechar o scanner para liberar recursos
        scanner.close();



    }
}
