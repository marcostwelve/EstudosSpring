package br.com.mmjm.libraryAPI.service;


import br.com.mmjm.libraryAPI.model.Usuario;
import br.com.mmjm.libraryAPI.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    public void save(Usuario usuario) {
        var senha = usuario.getSenha();
        usuario.setSenha(encoder.encode(senha));
        usuarioRepository.save(usuario);
    }

    public Usuario obterLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }
}
