package Secao9;

public class Quadrado extends Forma {

    private double lado;

    public Quadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        System.out.print("Calculando a área do círculo");
        return Math.PI * Math.pow(lado, 2);
    }
}
