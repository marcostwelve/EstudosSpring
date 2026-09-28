package br.com.mmjm.libraryAPI.controller;

import br.com.mmjm.libraryAPI.controller.DTO.AutorDTO;
import br.com.mmjm.libraryAPI.controller.DTO.AutorRespostaDTO;
import br.com.mmjm.libraryAPI.controller.DTO.ErroResposta;
import br.com.mmjm.libraryAPI.controller.mappers.AutorMapper;
import br.com.mmjm.libraryAPI.exceptions.OperacaoNaoPermitidaException;
import br.com.mmjm.libraryAPI.exceptions.RegistroDuplicadoException;
import br.com.mmjm.libraryAPI.model.Autor;
import br.com.mmjm.libraryAPI.model.Usuario;
import br.com.mmjm.libraryAPI.security.SecurityService;
import br.com.mmjm.libraryAPI.service.AutorService;
import br.com.mmjm.libraryAPI.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController implements GenericController {

    private final AutorService autorService;
    private final AutorMapper mapper;

//    public AutorController(AutorService autorService) {
//        this.autorService = autorService;
//    }
    //@RequestMapping(method = RequestMethod.POST)

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('OPERADOR', 'GERENTE')")
    public ResponseEntity<AutorRespostaDTO> obterDetalhes(@PathVariable("id") String id) {
        var idAutor = UUID.fromString(id);

        return autorService
                .buscarPorId(idAutor)
                .map(autor -> {
                    AutorRespostaDTO dto = mapper.toDTORespostaAutor(autor);
                    return ResponseEntity.ok(dto);
                }).orElseGet( () -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<Void> salvar(@RequestBody @Valid AutorDTO autorDto) {
            var autor = mapper.toEntity(autorDto);
            autorService.salvar(autor);
            URI location = gerarHeaderLocation(autor.getId());
            return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {

            var idAutor = UUID.fromString(id);
            Optional<Autor> autorOptional = autorService.buscarPorId(idAutor);

            if(autorOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            autorService.deletar(autorOptional.get());
            return ResponseEntity.noContent().build();

    }

    @GetMapping
    @PreAuthorize("hasAnyRole('OPERADOR', 'GERENTE')")
    public ResponseEntity<List<AutorRespostaDTO>> pesquisar(@RequestParam(value = "nome", required = false)String nome,
                                                            @RequestParam(value= "nacionalidade", required = false) String nacionalidade) {
        List<Autor> resultado = autorService.pesquisarByExample(nome, nacionalidade);
        List<AutorRespostaDTO> lista = resultado.stream().map(mapper::toDTORespostaAutor).collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<Void> atualizar(@PathVariable("id") String id,  @RequestBody @Valid AutorDTO autorDto) {

            var idAutor = UUID.fromString(id);
            Optional<Autor> autorOptional = autorService.buscarPorId(idAutor);

            if(autorOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            var autor = autorOptional.get();
            autor.setNome(autorDto.nome());
            autor.setNacionalidade(autorDto.nacionalidade());
            autor.setDataNascimento(autorDto.dataNascimento());
            autorService.atualizar(autor);
            return ResponseEntity.noContent().build();

    }

}
