package br.com.mmjm.libraryAPI.controller.mappers;

import br.com.mmjm.libraryAPI.controller.DTO.CadastroLivroDTO;
import br.com.mmjm.libraryAPI.controller.DTO.PesquisaLivroDTO;
import br.com.mmjm.libraryAPI.model.Livro;
import br.com.mmjm.libraryAPI.repository.AutorRepository;
import br.com.mmjm.libraryAPI.service.AutorService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {AutorMapper.class})
public abstract class LivroMapper {

    @Autowired
    AutorRepository autorRepository;

    @Mapping(target = "autor", expression = "java(autorRepository.findById(cadastroLivroDTO.idAutor()).orElse(null))")
    public abstract Livro toEntity(CadastroLivroDTO cadastroLivroDTO);

    public abstract PesquisaLivroDTO toDTO(Livro livro);

}
