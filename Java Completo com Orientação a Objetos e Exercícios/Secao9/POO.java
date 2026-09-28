package Secao9;

public class POO {
    public static void main(String[] args) {
        Motor motor = new Motor("V8", 450);
        Carro carro = new Carro("Ford", "Mustang", motor);

        carro.exibirInfo();

        // Herança
        Cachorro cachorro = new Cachorro("Rex");
        cachorro.emitirSom();
        cachorro.latir();

        // Classe Object

        Pessoa mauricio = new Pessoa("Mauricio", 25);

        System.out.println(mauricio.toString());
        System.out.println(cachorro.hashCode());

        // Override (sobrecrita)

        Quadrado q1 = new Quadrado(2);
        Circulo c1 = new Circulo(3);

        System.out.println(c1.calcularArea());
        System.out.println(q1.calcularArea());

        // Super

        Funcionario funcionario = new Funcionario("João", 3000);
        Gerente gerente = new Gerente("Maria", 5000, 1000);

        funcionario.exibirDetalhes();
        gerente.exibirDetalhes();

        System.out.println(funcionario.calcularBonus());
        System.out.println(gerente.calcularBonus());

        // Classe abstrata
        InstrumentoMusical violao = new Violao("violão");
        InstrumentoMusical bateria = new Bateria("bateria");
        InstrumentoMusical violino = new Violino("violino");

        violino.exibirDetalhes();
        violao.exibirDetalhes();
        bateria.exibirDetalhes();

        violao.tocar();
        bateria.tocar();
        violino.tocar();

        CalculadoraAvancada calculadoraAvancada = new CalculadoraAvancada();
        System.out.println(calculadoraAvancada.somar(2, 1));
        System.out.println(calculadoraAvancada.multiplicar(2, 2));

    }
}
