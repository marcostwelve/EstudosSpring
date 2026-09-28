package Secao9;

public class Circulo extends Forma {
    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        System.out.print("Calculando a área do círculo");
        return Math.PI * Math.pow(raio, 2);
    }
}
