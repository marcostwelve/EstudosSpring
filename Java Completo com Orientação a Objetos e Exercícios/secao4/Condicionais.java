package secao4;

public class Condicionais {
    public static void main(String[] args) {
        int x = 10;

        System.out.println(x == 10);
        System.out.println(x == 10);
        System.out.println(x != 5);
        System.out.println(x >= 5);
        System.out.println(x <= 5);
        System.out.println(x > 5);
        System.out.println(x < 5);

        // Comparando String
        String str = "Java";
        String str2 = new String("JaVa");

        System.out.println(str == "Java");
        System.out.println(str.equals(str2));
        System.out.println(str2.equals(str));
        System.out.println(str.equalsIgnoreCase(str2));

        double nota = 8.5;

        if (nota >= 9) {
            System.out.println("Nota muito boa");
        } else if (nota >= 7) {
            System.out.println("Acima da média");
        } else {
            System.out.println("Abaixo da média");
        }

        boolean estaChovendo = false;


        System.out.println(!estaChovendo);


    }
}
