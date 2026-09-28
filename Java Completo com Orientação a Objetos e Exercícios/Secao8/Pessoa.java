package Secao8;

public class Pessoa {

    private String nome;
    private int idade;

    public void setNome(String nome) {
        // THIS -> OBJETO DA CLASSE
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return this.idade;
    }
}
