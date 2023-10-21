package br.com.gerenciamentogscolar.service;

import br.com.gerenciamentogscolar.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public abstract class UsuarioService {

    public Iterable<Usuario> buscarTodos() {
        return null;
    }

    public Usuario consultarAlunoId(Long id) {
        return null;
    }

    public void cadastraAluno(Usuario usuario) {

    }

    public void editarAluno(Long id, Usuario usuario) {

    }

    public void excluirAluno(long id) {

    }

    public abstract void excluirAluno(Long id);
}
