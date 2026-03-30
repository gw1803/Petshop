package br.gabriel.conta.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gabriel.conta.model.Usuario;
import br.gabriel.conta.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    public final UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id){
        Usuario usuario = usuarioService.getUsuario(id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("")
    public ResponseEntity<List<Usuario>> getUsuarioList(){
        return ResponseEntity.ok().body(usuarioService.getUsuarioList());
    }

    @PostMapping("")
    public ResponseEntity<Usuario> insertUsuario(@RequestBody Usuario usuario){
        Usuario usuarioAux = usuarioService.insertUsuario(usuario);
        return ResponseEntity.ok().body(usuarioAux);
    }

    @PutMapping("")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        Usuario usuarioAux = usuarioService.updateUsuario(usuario);
        return ResponseEntity.ok().body(usuarioAux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id){
        Usuario usuarioAux = usuarioService.deleteUsuario(id);
        return ResponseEntity.ok().body(usuarioAux);
    }
}
