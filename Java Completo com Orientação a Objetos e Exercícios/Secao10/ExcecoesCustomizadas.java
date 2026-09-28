package Secao10;

import java.io.*;

public class ExcecoesCustomizadas {

    public static void main(String[] args) {

        Banco minha_conta = new Banco(5000);
        try {
            minha_conta.sacar(6000);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Verificadas e não verificadas

        // verificada
        try {
            BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
            String linha = reader.readLine();
            System.out.println(linha);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Não verificadas
        String texto = null;
        // System.out.println(texto.length());

        Erro erro = new Erro("");

        try {
            erro.processarArquivo("");

        } catch (FileNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Encadeamento de Exceções

        try {
            abrirArquivo(null);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

            System.out.println("Erro: " + e.getCause());
        } finally {
            System.out.println("Finalizado");
        }

        try {
            processarDados(null);
        } catch (Exception e) {
            System.out.println("Outra coisa");

            System.out.println("MSG: " + e.getMessage());

            System.out.println("Pilha de execução: " + e.getStackTrace());
        }

    }

    public static void abrirArquivo(String caminho) {
        try {

            if (caminho == null) {
                throw new NullPointerException("Caminho nulo");
            }

            throw new FileNotFoundException("Arquivo não encontrado");

        } catch (FileNotFoundException e) {
            NullPointerException npe = new NullPointerException("Erro ao processar arquivo");

            npe.initCause(e);

            throw npe;
        }
    }

    public static void processarDados(String dados) throws Exception {
        try {
            if(dados == null) {
                throw new NullPointerException("Os dados são nulo");
            }
        } catch (Exception e) {
            System.out.println("Tratamento e erros de log");
            throw e;
        }
    }
}
