package br.com.mmjm.libraryAPI.validator;

import br.com.mmjm.libraryAPI.exceptions.RegistroDuplicadoException;
import br.com.mmjm.libraryAPI.model.Autor;
import br.com.mmjm.libraryAPI.repository.AutorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorValidator {

    private AutorRepository autorRepository;

    public AutorValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void validarAutor(Autor autor) {
        if(existeAutor(autor)) {
            throw new RegistroDuplicadoException("Autor já cadastrado");
        }
    }

    private Boolean existeAutor(Autor autor) {
        Optional<Autor> autorEncontrado = autorRepository.findByNomeAndDataNascimentoAndNacionalidade(autor.getNome(),
                autor.getDataNascimento(), autor.getNacionalidade());

        if(autor.getId() == null) {
            return autorEncontrado.isPresent();
        }
        return !autor.getId().equals(autorEncontrado.get().getId()) && autorEncontrado.isPresent();
    }
}
