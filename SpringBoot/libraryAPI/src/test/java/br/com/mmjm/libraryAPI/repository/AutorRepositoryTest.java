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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setNome("João da Silva");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1912, 12, 11));
        var autorSalvo = autorRepository.save(autor);
        System.out.println("Salvo com sucesso!" + autorSalvo);
    }

    @Test
    public void atualizarTest() {

        var id = UUID.fromString("a5bb288d-4789-40b0-be23-9fd8d6546b76");

        Optional<Autor> autor = autorRepository.findById(id);

        if (autor.isPresent()) {
            System.out.println("Dados do autor sucesso!" + autor.get());
            Autor autorEncontrado = autor.get();
            autorEncontrado.setDataNascimento(LocalDate.of(1990, 12, 11));
            autorRepository.save(autorEncontrado);
        }
    }

    @Test
    public void listarTodosTest() {
        List<Autor> autors = autorRepository.findAll();
        autors.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("Quantidade de Autores: " + autorRepository.count());
    }

    @Test
    public void deletePorIdTest() {
        var id = UUID.fromString("a5bb288d-4789-40b0-be23-9fd8d6546b76");
        autorRepository.deleteById(id);
    }

    @Test
    public void deleteTest() {
        var id = UUID.fromString("7eab3589-494b-472e-928b-047f10677a31");
        var autor = autorRepository.findById(id).get();
        autorRepository.delete(autor);
    }

    @Test
    void salvarAutorComLivrosTest() {
        Autor autor = new Autor();
        autor.setNome("Mariana");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1963, 5, 8));


        Livro livro = new Livro();
        livro.setTitulo("A vida de Mariana");
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setDataPublicacao(LocalDate.of(1989, 10, 10));
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setIsbn("159296f2d9f");
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setTitulo("A Bíblia");
        livro2.setGenero(GeneroLivro.BIOGRAFIA);
        livro2.setDataPublicacao(LocalDate.of(2010, 5, 3));
        livro2.setPreco(BigDecimal.valueOf(150));
        livro2.setIsbn("15929jgjg6f2d9f");
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);


        autorRepository.save(autor);

        //livroRepository.saveAll(autor.getLivros());
    }

    @Test
    void listarLivrosAutor() {
        var id = UUID.fromString("5f1ccd30-fdf8-4d83-95b1-3c84c68993b0");
        var autor = autorRepository.findById(id).get();

        // buscar livros do autor (Melhor forma de utilizar o Lazy nas consultas JPA
        List<Livro> livros = livroRepository.findByAutor(autor);
        autor.setLivros(livros);

        autor.getLivros().forEach(System.out::println);
    }
}
