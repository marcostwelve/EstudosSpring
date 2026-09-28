package secao6;

public class WhileJava {
    public static void main(String[] args) {

        int i = 0;
        while(i <= 5) {
           System.out.println(i);
            i = i + 1;
        }

        int valor = 0;

        while(valor != 7) {
            valor = (int)(Math.random() * 100);
            System.out.println("Valor aleatório: " + valor);
        }

        // loop infinito
        while(true) {
            System.out.println("Infinito");
        }
    }
}
