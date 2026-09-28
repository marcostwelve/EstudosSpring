package secao6;

public class doWhile {
    public static void main(String[] args) {

        int j = 10;
        do {

            System.out.println(j);
            j--;
        } while(j > 0);

        int numero = 0;
        do {
            numero = (int)(Math.random() * 10);
            System.out.println("Numero gerado: " + numero);
        } while(numero != 1);
    }
}
