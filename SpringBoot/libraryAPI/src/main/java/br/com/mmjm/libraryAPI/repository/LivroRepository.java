package br.com.mmjm.libraryAPI.repository;

import br.com.mmjm.libraryAPI.model.Autor;
import br.com.mmjm.libraryAPI.model.GeneroLivro;
import br.com.mmjm.libraryAPI.model.Livro;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID>, JpaSpecificationExecutor<Livro> {

    // QUERY METHOD
    // select * from livro where id_autor = id_autor
    List<Livro> findByAutor(Autor autor);

    List<Livro> findByTitulo(String titulo);

    Optional<Livro> findByIsbn(String isbn);

    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    List<Livro> findByTituloOrIsbn(String titulo, String isbn);

    List<Livro> findByDataPublicacaoBetween(LocalDate dataInicio, LocalDate dataFim);

    List<Livro> findByTituloOrIsbnOrderByTitulo(String titulo, String isbn);

    // JPQL -> REFERÊNCIA AS ENTIDADES E AS PROPRIEDADES
    @Query("select l from Livro as l order by l.titulo, l.preco")
    List<Livro> listarTodos();

    @Query("select a from Livro l join l.autor a")
    List<Autor> listarAutoresDosLivros();

    @Query("select distinct l.titulo from Livro l")
    List<String> listarNomeDosLivros();

    @Query("""
    select l.genero
    from Livro l
    join l.autor a
    where a.nacionalidade = 'Brasileira'
    order by l.genero
        """)
    List<String> listarGenerosAutoresBrasileiros();

    // named parameters -> parametros nomeados
    @Query("select l from Livro l where l.genero = :genero order by :paramOrdenacao")
    List<Livro> findByGenero(@Param("genero") GeneroLivro genero, @Param("paramOrdenacao") String paramOrdenacao);

    // posicional parameters
    @Query("select l from Livro l where l.genero = ?1 order by ?2")
    List<Livro> findByGeneroPosicionalParameters(GeneroLivro genero, String paramOrdenacao);

    @Modifying
    @Transactional
    @Query("delete from Livro where genero = ?1")
    void deleteByGenero(GeneroLivro genero);

    @Modifying
    @Transactional
    @Query("update Livro l set l.dataPublicacao = :novaData where l.dataPublicacao >= :dataLimite")
    void updateDataPublicacao(@Param("novaData") LocalDate novaData, @Param("dataLimite")LocalDate dataLimite);

    Boolean existsByAutor(Autor autor);

}
