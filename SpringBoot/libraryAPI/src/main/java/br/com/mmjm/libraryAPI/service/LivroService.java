package br.com.mmjm.libraryAPI.service;

import br.com.mmjm.libraryAPI.model.Livro;
import br.com.mmjm.libraryAPI.model.Usuario;
import br.com.mmjm.libraryAPI.repository.LivroRepository;
import br.com.mmjm.libraryAPI.repository.specs.LivroSpecs;
import br.com.mmjm.libraryAPI.security.SecurityService;
import br.com.mmjm.libraryAPI.validator.LivroValidador;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;
    private final LivroValidador livroValidador;
    private final SecurityService securityService;

    public void salvar(Livro livro) {
        livroValidador.validar(livro);
        Usuario  usuario = securityService.obterUsuarioLogado();
        livro.setUsuario(usuario);
        repository.save(livro);
    }

    public Optional<Livro> obterPorId(UUID id) {
        return repository.findById(id);
    }

    public void deletar(Livro livro) {
        repository.delete(livro);
    }

    public Page<Livro> pesquisa(String isbn, String titulo, String nomeAutor, String genero,
                                Integer anoPublicacao, Integer pagina, Integer tamanhoPagina) {
//        Specification<Livro> specification =
//                Specification.where(LivroSpecs.isbnEqual(isbn))
//                        .and(LivroSpecs.generoEqual(genero))
//                        .and(LivroSpecs.tituloLike(titulo));

        Specification<Livro> specs = Specification.where((root, query, cb)
                -> cb.conjunction());

        if (isbn != null) {
            specs = specs.and(LivroSpecs.isbnEqual(isbn));
        }

        if (titulo != null) {
            specs = specs.and(LivroSpecs.tituloLike(titulo));
        }

        if (genero != null) {
            specs = specs.and(LivroSpecs.generoEqual(genero));
        }

        if (anoPublicacao != null) {
            specs = specs.and(LivroSpecs.anoPublicacaoEqual(anoPublicacao));
        }

        if(nomeAutor != null) {
            specs = specs.and(LivroSpecs.nomeAutorLike(nomeAutor));
        }

        Pageable pageRequest = PageRequest.of(pagina, tamanhoPagina);

        return repository.findAll(specs, pageRequest);
    }

    public void atualizar(Livro livro) {
        if (livro.getId() == null) {
            throw new IllegalArgumentException("Para atualizar o livro. É necessário que o mesmo esteja na base");
        }
        livroValidador.validar(livro);
        repository.save(livro);
    }
}
