package secao4;

import java.time.LocalDate;

public class SwitchJava {
    public static void main(String[] args) {

        // Continue
        for (int i = 1; i <= 7; i++) {

            if (i == 5) {
                continue;
            }

            System.out.println(i);
        }

        // Switch
        var diaSemana = 7;
        switch (diaSemana) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sabado");
                break;
            default:
                System.out.println("Dia da semana inválido");
                break;


        }
    }
}
