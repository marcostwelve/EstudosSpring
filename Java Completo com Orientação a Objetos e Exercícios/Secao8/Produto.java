package Secao8;

public class Produto {

    private String nome;
    private double preco;

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty() && nome.length() > 5) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome não atende os critérios");
        }
    }

    public void setPreco(double preco) {
        if (preco < 0 || preco > 1000) {
            throw new IllegalArgumentException("O preço não atende os critérios");
        }
        this.preco = preco;
    }

    public String getNome() {
        return this.nome.toUpperCase();
    }

    public String getPreco() {
        return String.format("R$%.2f", this.preco);
    }

    public String getProdutoInfo() {
        return "Nome: " + this.getNome() + ", Preço: " + this.getPreco();
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem > 0 && porcentagem <= 100) {
             double desconto = calcularDesconto(porcentagem);

             double precoFinal = this.preco - desconto;
             setPreco(precoFinal);

             System.out.println("Desconto: " + porcentagem + "% aplicado");

             System.out.println(this.getProdutoInfo());

        } else {
            System.out.println("Porcentagem inválida. O desconto deve ser entre 0 e 100.");
        }
    }

    private double calcularDesconto(double porcentagem) {
        return (this.preco * porcentagem) / 100;
    }
}
