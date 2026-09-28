package Secao9;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    // Override - sobrescrita
    @Override
    public String toString(){
        return  "nome= " + nome + ", idade= " + idade;
    }
}
