package br.com.mmjm.libraryAPI.controller;

import br.com.mmjm.libraryAPI.controller.DTO.UsuarioDTO;
import br.com.mmjm.libraryAPI.controller.mappers.UsuarioMapper;
import br.com.mmjm.libraryAPI.model.Usuario;
import br.com.mmjm.libraryAPI.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class usuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody UsuarioDTO dto) {
        var usuario = usuarioMapper.toEntity(dto);
        usuarioService.save(usuario);
    }
}
