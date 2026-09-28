package Secao8;
import java.util.Arrays;


public class Poo2 {

    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("João", 2000.0, "1234");

        funcionario1.exibirDados();
        funcionario1.aumentarSalario(10);

        funcionario1.nome = "Teste";
        funcionario1.salario = 12000.0;

        if(funcionario1.autenticar("1234")) {
            System.out.println("Autenticado com sucesso");
        }

        // 2 - Classe Imutável

        PessoaImutavel pessoaImutavel = new PessoaImutavel("Maria", 30);
        System.out.println("Nome: " + pessoaImutavel.getNome() + " Idade: " + pessoaImutavel.getIdade());

        // 2 - Encapsulamento de Arrays
        String[] meusAlunos = {"Paola", "Mariana", "Edinaide"};
        Turma turma = new Turma(meusAlunos);
        String[] aluno = {"Arthur"};
        turma.setAlunos(aluno);
        System.out.println("Alunos da turma: " + Arrays.toString(turma.getAlunos()));
    }
}
