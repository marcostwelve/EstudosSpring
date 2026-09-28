package Secao10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Erro {
    private String caminho;

    public Erro(String caminho) {
        this.caminho = caminho;
    }

    public void processarArquivo(String caminho) throws FileNotFoundException, IOException {
        if (caminho == null || caminho.isEmpty()) {
            throw new IOException("Caminho inválido");
        }

        File arquivo = new File(caminho);

        if(!arquivo.exists()) {
            throw new FileNotFoundException("Arquivo não encontrado");
        }

        System.out.println("Arquivo encontrado com sucesso!");;
    }

}
