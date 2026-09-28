package Secao9.Avancando;


import java.lang.reflect.*;

public class POO2 {
    public static void main(String[] args) {

        // 1 - Classes com final
        ContaBancaria conta = new ContaBancaria(650.00);

        System.out.println(conta.getSaldo());

        // 2 - Reflexion API
        try {

            Class<?> classePessoa = Class.forName("Secao9.Avancando.Pessoa");
            Constructor<?> constructor = classePessoa.getConstructor(String.class, int.class);
            Object pessoa = constructor.newInstance("Pessoa", 50);
            Method dizerOlaMethod = classePessoa.getMethod("dizerOla");
            dizerOlaMethod.invoke(pessoa);
            Field campoNome = classePessoa.getDeclaredField("nome");
            campoNome.setAccessible(true);
            campoNome.set(pessoa, "Maria");

            dizerOlaMethod.invoke(pessoa);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
