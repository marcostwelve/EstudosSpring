package secao4;

public class Condicionais2 {
    public static void main(String[] args) {

        // - If ternário
        int numero = 13;
        String resultado = (numero % 2 == 0) ? "Par" : "Impar";
        System.out.println(resultado);

        // If encadeado

        var idade = 18;
        boolean temCarteira = false;
        if (idade >= 18) {
            if (temCarteira) {
                System.out.println("Você pode dirigir");
            } else {
                System.out.println("Você não pode dirigir");
            }
        } else {
            System.out.println("Você não pode dirigir");
        }

        // Precedência

        boolean a = true;
        boolean b = false;
        boolean c = true;

        boolean resultado1 = (!a || b) && c;
         // (NOT TRUE OR FALSE) AND TRUE
        //  (FALSE OR FALSE) AND TRUE
        //  FALSE AND TRUE
        //  FALSE
        System.out.println(resultado1);
    }
}
