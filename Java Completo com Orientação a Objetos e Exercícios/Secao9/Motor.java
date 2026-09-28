package Secao9;

public class Motor {
    private String tipo;
    private int potencia;

    public Motor(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public void exibirInfo() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Potencia: " + potencia + " cavalos");
    }
}
