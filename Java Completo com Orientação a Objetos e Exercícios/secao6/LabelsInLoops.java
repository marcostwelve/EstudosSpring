package secao6;

public class LabelsInLoops {
    public static void main(String[] args) {

        externo:
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 5 ; j++) {
                if (i == 1 && j == 1) {
                    break externo;
                }

                System.out.println("i " + i + ", j " + j);
            }
        }


        for(int i = 0; i < 5; i++) {

            System.out.println("Externo: " + i);

            interno:
            for(int j = 0; j < 3 ; j++) {
                if (j == 2) {
                    System.out.println("Parou interno");
                    break interno;
                }
                System.out.println("i " + i + ", j " + j);

            }
        }
    }
}
