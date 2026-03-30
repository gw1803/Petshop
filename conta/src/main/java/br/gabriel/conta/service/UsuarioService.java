package br.gabriel.conta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gabriel.conta.model.Usuario;
import br.gabriel.conta.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario getUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Informação não encontrada.");
        }
        return usuario;
    }

    public List<Usuario> getUsuarioList(){
        return usuarioRepository.findAll();
    }

    public Usuario insertUsuario(Usuario usuario){
        usuario.setId(null);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario updateUsuario(Usuario usuario){
        if (usuario.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id é obrigatório.");
        }
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario deleteUsuario(Long id){
        Usuario usuario = this.getUsuario(id);
        if (usuario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado um usuario com o id: " + id);
        }

        usuarioRepository.deleteById(id);

        return usuario;
    }

}
