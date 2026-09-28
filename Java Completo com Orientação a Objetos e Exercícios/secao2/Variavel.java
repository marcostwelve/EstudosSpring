package secao2;

public class Variavel {

    public static void main(String[] args) {
        /***
         * Exemplo de comentário de documentação
         */

        /*
          Exemplo de comentário de múltiplas linhas
         */

        // Exemplo de comentário de linha única

        int idade = 29;
        String nome = "Maurício";
        double salario = 2500.50;
        double valorComD = 12.10D;
        boolean isAtivo = true;
        char simbolo = '@';
        long populacaoMundial = 7800000000L;
        long grandeNumero = 1_000_000L;

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Salário: " + salario);
        System.out.println("Ativo: " + isAtivo);
        System.out.println("Símbolo: " + simbolo);
        System.out.println("População Mundial: " + populacaoMundial);
        System.out.println("Grande Número: " + grandeNumero);
        System.out.println("Valor com D: " + valorComD);

        // Type Casting
        // Implicito
        int numero2 = 42;

        long numeroLong = numero2;

        double numeroDouble = numero2;

        System.out.println("Numero2: " + numero2);
        System.out.println("Numero Long: " + numeroLong);
        System.out.println("Numero Double: " + numeroDouble);

        // explicito
        double valorDouble = 7.75;
        int valorInt = (int) valorDouble;

        char letraA = 'A';
        int codigoAAscii = (int) letraA;

        System.out.println("Valor Double: " + valorDouble);
        System.out.println("Valor Int: " + valorInt);
        System.out.println("Letra A: " + letraA);
        System.out.println("Código ASCII de A: " + codigoAAscii);

        // constantes
        final int DIAS_SEMANA = 7;

        System.out.println("Dias da semana: "+ DIAS_SEMANA);

        var z = 10;
        System.out.println(z);
    }
}
