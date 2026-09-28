package br.com.mmjm.libraryAPI.controller.DTO;

import java.time.LocalDate;
import java.util.UUID;

public record AutorRespostaDTO(UUID id, String nome, LocalDate dataNascimento, String nacionalidade) {
}
