package br.com.gerenciamentogscolar.controller;

import br.com.gerenciamentogscolar.model.Usuario;
import br.com.gerenciamentogscolar.service.UsuarioService;
import br.com.gerenciamentogscolar.view.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("aluno")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para buscar todos os usuários
    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    // Endpoint para consultar um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultarAlunoId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.consultarAlunoId(id));
    }

    // Endpoint para cadastrar um novo usuário
    @PostMapping
    public ResponseEntity<?> cadastraAluno(@RequestBody @Valid UsuarioDTO usuario) {
        Usuario use = new Usuario();
        BeanUtils.copyProperties(usuario, use);

        usuarioService.cadastraAluno(use);
        return ResponseEntity.ok(usuario);
    }

    // Endpoint para editar um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarAluno(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuarioService.editarAluno(id, usuario);
        return ResponseEntity.ok(usuario); // Retorna o usuário com as informações atualizadas
    }

    // Endpoint para excluir um usuário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable Long id) {
        usuarioService.excluirAluno(id);
        return ResponseEntity.ok().build(); // Retorna uma resposta vazia (sem conteúdo) para indicar que a exclusão foi realizada com sucesso
    }
}

