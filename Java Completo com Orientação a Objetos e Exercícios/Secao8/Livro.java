package Secao8;

public class Livro {

    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public Livro() {
        this.titulo = "Livro da Vida";
        this.autor = "Vida";
        this.preco = 12.99;
    }

    public void exibirInfo(){
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Valor: " + this.preco);
    }
}
