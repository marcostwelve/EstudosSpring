package br.com.mmjm.libraryAPI.controller.DTO;

import br.com.mmjm.libraryAPI.model.GeneroLivro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PesquisaLivroDTO(UUID id,
                               String isbn,
                               String titulo,
                               LocalDate dataPublicacao,
                               GeneroLivro genero,
                               BigDecimal preco,
                               AutorDTO autor) {
}
