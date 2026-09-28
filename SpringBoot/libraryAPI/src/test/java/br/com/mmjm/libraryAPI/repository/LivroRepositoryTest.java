package br.com.mmjm.libraryAPI.repository;

import br.com.mmjm.libraryAPI.model.Autor;
import br.com.mmjm.libraryAPI.model.GeneroLivro;
import br.com.mmjm.libraryAPI.model.Livro;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class LivroRepositoryTest {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Test
    void saveTest() {
        Livro livro = new Livro();
        livro.setIsbn("123456789");
        livro.setPreco(BigDecimal.valueOf(20));
        livro.setTitulo("Ciencia Livro");
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setDataPublicacao(LocalDate.of(1990, 1, 1));

        var autor = autorRepository.findById(UUID.fromString("4ab3f753-a5f3-478c-9e32-9f19f25332ce")).orElse(null);
        livro.setAutor(autor);
        livroRepository.save(livro);

        System.out.println("Livro salvo com sucesso" +  livro);
    }

    @Test
    void saveCascadeTest() {
        Livro livro = new Livro();
        livro.setIsbn("123456789");
        livro.setPreco(BigDecimal.valueOf(20));
        livro.setTitulo("Outro Livro");
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setDataPublicacao(LocalDate.of(1990, 1, 1));

        Autor autor = new Autor();
        autor.setNome("Ice Cube");
        autor.setNacionalidade("Norte Americano");
        autor.setDataNascimento(LocalDate.of(1912, 12, 11));

        livro.setAutor(autor);
        livroRepository.save(livro);

        System.out.println("Livro salvo com sucesso" +  livro);
    }

    @Test
    void saveAutorELivroTest() {
        Livro livro = new Livro();
        livro.setIsbn("123456789");
        livro.setPreco(BigDecimal.valueOf(20));
        livro.setTitulo("Outro Livro");
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setDataPublicacao(LocalDate.of(1990, 1, 1));

        Autor autor = new Autor();
        autor.setNome("Ice Cube");
        autor.setNacionalidade("Norte Americano");
        autor.setDataNascimento(LocalDate.of(1912, 12, 11));

        autorRepository.save(autor);

        livro.setAutor(autor);
        livroRepository.save(livro);

        System.out.println("Livro salvo com sucesso" +  livro);
    }

    @Test
    void atualizarAutorDoLivroTest() {
        var livroParaAtualizar = livroRepository.findById(UUID.fromString("b87233d4-9118-4ad7-8715-6cd0b82897d7")).orElse(null);

        var autor = autorRepository.findById(UUID.fromString("0191532d-3944-4abf-b79b-4c7dc052a05c")).orElse(null);

        livroParaAtualizar.setAutor(autor);
    }

    @Test
    void deletarLivroTest() {
        UUID id = UUID.fromString("b87233d4-9118-4ad7-8715-6cd0b82897d7");
        livroRepository.deleteById(id);
    }

    @Test
    void deletarLivroCascadeTest() {
        UUID id = UUID.fromString("18540769-7876-47f5-9811-a3091dc95741");
        livroRepository.deleteById(id);
    }

    @Test
    @Transactional // Necessário para poder carregar dados que são necessários (Não é uma boa prática)
    void buscarLivroTest() {
        UUID id  = UUID.fromString("18540769-7876-47f5-9811-a3091dc95741");
        Livro livro = livroRepository.findById(id).orElse(null);
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor().getNome());
    }

    @Test
    void buscarLivroPorTituloTest() {
        List<Livro> livros = livroRepository.findByTitulo("Outro Livro");
        livros.forEach(System.out::println);
    }

    @Test
    void buscarLivroPorIsbnTest() {
        Optional<Livro> livros = livroRepository.findByIsbn("123456789");
        livros.ifPresent(System.out::println);
    }

    @Test
    void buscarLivroPorTituloEPrecoTest() {
        List<Livro> livros = livroRepository.findByTituloAndPreco("Outro Livro", BigDecimal.valueOf(20));
        livros.forEach(System.out::println);
    }

    @Test
    void buscarLivroPorTituloOuIsbnTest() {
        List<Livro> livros = livroRepository.findByTituloOrIsbn("", "159296f2d9f");
        livros.forEach(System.out::println);
    }

    @Test
    void listarLivrosComQueryJPQLTest() {
        List<Livro> livros = livroRepository.listarTodos();

        livros.forEach(System.out::println);
    }

    @Test
    void listarAutoresDosLivrosComQueryJPQLTest() {
        List<Autor> autores = livroRepository.listarAutoresDosLivros();

        autores.forEach(System.out::println);
    }

    @Test
    void listarTitulosNaoRepetidosComQueryJPQLTest() {
        List<String> titulos = livroRepository.listarNomeDosLivros();

        titulos.forEach(System.out::println);
    }

    @Test
    void listarGenerosDeLivrosDeAutoresBrasileirosComQueryJPQLTest() {
        List<String> generos = livroRepository.listarGenerosAutoresBrasileiros();

        generos.forEach(System.out::println);
    }

    @Test
    void listarPorGeneroQueryParam() {
        var resultado = livroRepository.findByGenero(GeneroLivro.BIOGRAFIA, "dataPublicacao");
        resultado.forEach(System.out::println);
    }

    @Test
    void listarPorGeneroPosicionalParam() {
        var resultado = livroRepository.findByGeneroPosicionalParameters(GeneroLivro.BIOGRAFIA, "dataPublicacao");
        resultado.forEach(System.out::println);
    }

    @Test
    void deleteTest() {
        livroRepository.deleteByGenero(GeneroLivro.CIENCIA);
        System.out.println("Livro deletado com sucesso");
    }

    @Test
    void updateTest() {
        livroRepository.updateDataPublicacao(LocalDate.of(2020, 1, 1), LocalDate.of(1990, 1, 1));
        System.out.println("Livro atualizado com sucesso");
    }

}
