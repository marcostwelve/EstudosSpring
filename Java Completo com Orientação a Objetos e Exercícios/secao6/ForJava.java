package secao6;

public class ForJava {
    public  static void main(String args[]){

        for (int i = 1; i <= 5; i++) {
            System.out.println("Contador " + i);
        }

        String palavra = "Java";

        for (int i = 0; i < palavra.length(); i++) {
            System.out.println("Caractere: " + palavra.charAt(i));
        }

        for (int i = 5; i > 0; i--) {
            System.out.println("Contador: " + i);
        }

        String palavra2 = "Javax";
        for (int i = palavra2.length() - 1; i >= 0; i--) {
            System.out.println("Caractere: " + palavra2.charAt(i));
        }

        for (int x = 0; x <= 10; x++) {
            System.out.println("Contador: " + x);

            if (x == 5) {
                System.out.println("Parando o Loop");
                break;
            }
        }

        for (int x = 109; x > 0; x--) {
            if (x % 2 == 0) {
                System.out.println("Par");
                continue;
            }
            System.out.println("Contador: " + x);
        }

    }
}
