package br.com.mmjm.libraryAPI.service;

import br.com.mmjm.libraryAPI.model.Autor;
import br.com.mmjm.libraryAPI.model.GeneroLivro;
import br.com.mmjm.libraryAPI.model.Livro;
import br.com.mmjm.libraryAPI.repository.AutorRepository;
import br.com.mmjm.libraryAPI.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public void executar() {
        // salva o autor
        Autor autor = new Autor();
        autor.setNome("Teste Edinaide");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1912, 12, 11));
        autorRepository.save(autor);



        //salva o livro
        Livro livro = new Livro();
        livro.setIsbn("123456789");
        livro.setPreco(BigDecimal.valueOf(20));
        livro.setTitulo("Teste Livro de São Francisco do Conde");
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setDataPublicacao(LocalDate.of(1990, 1, 1));
        livro.setAutor(autor);
        livroRepository.save(livro);

        if (autor.getNome().equals("Teste Edinaide")) {
            throw new RuntimeException("Rollback");
        }
    }

    @Transactional
    public void atualizacaoSemAtualizacao() {
        var livro = livroRepository.findById(UUID.fromString("98772514-c9f0-4e79-858b-2e071e9af40c"))
                                    .orElse(null);

        livro.setDataPublicacao(LocalDate.of(2025,6,1));


    }

    @Transactional
    public void salvarLivroComFoto() {
        // salva o livro
        // repository.save(livro);

        // pega o id  do livro = livro.getId();
        // var id = livro.getId();

        // Salvar foto do livro -> Bucket na nuvem
        // BucketService.salvar(livro.getFoto(), id + ".png");

        // Atualizar o nome do arquivo salvo
        // livro.setNomeArquivoFoto(id + ".png");
    }
}
