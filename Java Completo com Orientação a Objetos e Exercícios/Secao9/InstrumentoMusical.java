package Secao9;

abstract class InstrumentoMusical {

    protected String nome;

    public InstrumentoMusical(String nome) {
        this.nome = nome;
    }

    // abstrato: Tem que ser implementado na classe filha
    public abstract void tocar();

    // Método concreto: pode ser herdado
    public void exibirDetalhes() {
        System.out.println("Instrumento: " + nome);
    }
}
