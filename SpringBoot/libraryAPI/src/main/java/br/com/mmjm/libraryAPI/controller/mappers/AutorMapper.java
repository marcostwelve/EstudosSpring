package br.com.mmjm.libraryAPI.controller.mappers;

import br.com.mmjm.libraryAPI.controller.DTO.AutorDTO;
import br.com.mmjm.libraryAPI.controller.DTO.AutorRespostaDTO;
import br.com.mmjm.libraryAPI.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    @Mapping(source = "nacionalidade", target = "nacionalidade")
    Autor toEntity(AutorDTO autorDTO);

    AutorDTO toDTO(Autor autor);

    AutorRespostaDTO toDTORespostaAutor(Autor autor);
}
