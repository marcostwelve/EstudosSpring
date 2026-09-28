package br.com.mmjm.libraryAPI.controller.mappers;

import br.com.mmjm.libraryAPI.controller.DTO.UsuarioDTO;
import br.com.mmjm.libraryAPI.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO usuarioDTO);
    UsuarioDTO toDto(Usuario usuario);
}
