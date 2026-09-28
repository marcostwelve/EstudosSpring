package br.com.mmjm.libraryAPI.service;

import br.com.mmjm.libraryAPI.exceptions.OperacaoNaoPermitidaException;
import br.com.mmjm.libraryAPI.model.Autor;
import br.com.mmjm.libraryAPI.model.Usuario;
import br.com.mmjm.libraryAPI.repository.AutorRepository;
import br.com.mmjm.libraryAPI.repository.LivroRepository;
import br.com.mmjm.libraryAPI.security.SecurityService;
import br.com.mmjm.libraryAPI.validator.AutorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor /* Adiciona o construtor automaticamente. (Necessário declarar com final (Ex: private final) */
public class AutorService {

    private final AutorRepository autorRepository;
    private final AutorValidator autorValidator;
    private final LivroRepository livroRepository;
    private final SecurityService securityService;

//    public AutorService(AutorRepository autorRepository, AutorValidator autorValidator, LivroRepository livroRepository) {
//        this.autorRepository = autorRepository;
//        this.autorValidator = autorValidator;
//        this.livroRepository = livroRepository;
//    }

    public Autor salvar(Autor autor) {
        autorValidator.validarAutor(autor);
        Usuario usuario = securityService.obterUsuarioLogado();
        autor.setUsuario(usuario);
        return autorRepository.save(autor);
    }

    public void atualizar(Autor autor) {
        if (autor.getId() == null) {
            throw new IllegalArgumentException("Para atualizar, é necessário que o autor já esteja cadastrado");
        }
        autorValidator.validarAutor(autor);
        autorRepository.save(autor);
    }

    public Optional<Autor> buscarPorId(UUID id) {
        return autorRepository.findById(id);
    }

    public void deletar(Autor autor) {

        if(autorPossuiLivro(autor)) {
            throw new OperacaoNaoPermitidaException("Não é permitido excuir autor que possui livro");
        }
        autorRepository.delete(autor);
    }

    public List<Autor> pesquisar(String nome, String nacionalidade) {

        if(nome != null && nacionalidade != null) {
            return autorRepository.findByNomeAndNacionalidade(nome, nacionalidade);
        }

        if(nome != null) {
            return autorRepository.findByNome(nome);
        }

        if(nacionalidade != null) {
            return autorRepository.findByNacionalidade(nacionalidade);
        }

        return autorRepository.findAll();
    }

    public List<Autor> pesquisarByExample(String nome, String nacionalidade) {
        var autor = new Autor();
        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("id", "dataNascimento", "dataCadastro")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Autor> autorExample = Example.of(autor, matcher);
        return autorRepository.findAll(autorExample);
    }

    private boolean autorPossuiLivro(Autor autor) {
        return livroRepository.existsByAutor(autor);
    }
}
