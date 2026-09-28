package Secao9;

public class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void emitirSom(){
        System.out.println(this.nome + " está emitindo som");
    }
}
