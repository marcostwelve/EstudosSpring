package secao5;

public class Funcoes2 {
    public static void main(String[] args) {
        String r1 = verificarAcesso(19, true, true);

        System.out.println(r1);

        String dia = obterDiaDaSemana(1);
        System.out.println(dia);
        verificarAutenticacao("admin", "senhaSegura");

        var media = calcularMedia(10, 0, 9);
        System.out.println(media);
    }

    public static String verificarAcesso(int idade, boolean temCarteira, boolean temHistoricoNegativo) {
        if (idade >= 18 && temCarteira && !temHistoricoNegativo) {
            return "Acesso permitido";
        } else if (idade >= 18 && temCarteira && temHistoricoNegativo) {
            return "Acesso negado: histórico negativo";
        }else {
            return "Acesso negado";
        }
    }

    public static String obterDiaDaSemana(int diaSemana) {
        switch (diaSemana) {
        case 1:
            return "Domingo";
        case 2:
            return "Segunda-feira";
        case 3:
            return "Terça-feira";
        case 4:
            return "Quarta-feira";
        case 5:
            return "Quinta-feira";
        case 6:
            return "Sexta-feira";
        case 7:
            return "Sábado";
        default:
            return "Dia inválido";
        }
    }

    // Exit = 0 bem-sucedido 1 - falha e/ou erro

    public static void verificarAutenticacao(String usuario, String senha) {
        if (!usuario.equals("admin") || !senha.equals("senhaSegura")) {
            System.out.println("Falha na autenticação");
            System.exit(1);
        }

        System.out.println("Autenticação bem-sucedida");
    }

    /**
     *
     * Calcula a média de três números
     *
     * @param valor1 o primeiro valor/nota a ser enviado
     * @param valor2 o segundo valor/nota a ser enviado
     * @param valor3 o terceiro valor/nota a ser enviado
     * @return A média dos três números dividos por 3
     *
     * */
    public static double calcularMedia(double valor1, double valor2, double valor3) {
        return (valor1 + valor2 + valor3) / 3;
    }
}
