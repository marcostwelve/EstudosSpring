package br.com.mmjm.libraryAPI.controller.DTO;

import br.com.mmjm.libraryAPI.model.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroLivroDTO(@NotBlank(message = "Campo obrigatório") @ISBN String isbn,
                               @NotBlank(message = "Campo obrigatório") String titulo,
                               @NotNull(message = "Campo obrigatório")
                               @Past(message = "Não é possível cadastrar datas futuras") LocalDate dataPublicacao,
                               GeneroLivro genero,
                               BigDecimal preco, @NotNull(message = "Campo obrigatório") UUID idAutor) {
}
