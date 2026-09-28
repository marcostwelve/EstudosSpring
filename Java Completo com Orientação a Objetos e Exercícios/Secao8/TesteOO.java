package Secao8;

public class TesteOO {
    public static void main(String[] args) {
        Pessoa paola = new Pessoa();
        paola.setNome("Paola");
        paola.setIdade(25);

        System.out.println("O nome dela é: " + paola.getNome());
        System.out.println("A idade dela é: " + paola.getIdade());

        ContaBancaria cb = new ContaBancaria();
        cb.setTitular(paola.getNome());
        cb.setSaldo(1000);

        cb.exibirContaBancaria();

        System.out.println("O saldo da conta é: " + cb.getSaldo());

        Produto camisa = new Produto();
        camisa.setNome("Camisa");
        camisa.setPreco(500);

        System.out.println("O nome do produto é: " + camisa.getNome() + " o valor é: " + camisa.getPreco());
        System.out.println(camisa.getProdutoInfo());

        camisa.aplicarDesconto(10);

        Livro livro = new Livro();
        Livro livro2 = new Livro("A Cabana", "Autor", 20.00);
        livro.exibirInfo();
        livro2.exibirInfo();
    }
}
