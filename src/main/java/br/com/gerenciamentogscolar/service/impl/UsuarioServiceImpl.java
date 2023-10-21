package br.com.gerenciamentogscolar.service.impl;


import br.com.gerenciamentogscolar.model.Usuario;
import br.com.gerenciamentogscolar.model.UsuarioRepository;
import br.com.gerenciamentogscolar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para buscar todos os usuários
    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    // Método para consultar um usuário por ID
    @Override
    public Usuario consultarAlunoId(Long id) {
        // Procura um usuário pelo ID
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get(); // Retorna o usuário encontrado (certifique-se de tratar casos onde o usuário pode não existir)
    }

    // Método para cadastrar um novo usuário
    @Override
    public void cadastraAluno(Usuario usuario) {
        salvarAluno(usuario); // Chama o método para salvar o usuário no banco de dados
    }

    // Método para editar um usuário existente
    @Override
    public void editarAluno(Long id, Usuario usuario) {
        Optional<Usuario> usuariobd = usuarioRepository.findById(id); // Procura o usuário existente pelo ID
        if (usuariobd.isPresent()) {
            // Atualiza os campos do usuário existente com os valores do novo usuário
            usuariobd.get().setDisciplina(usuario.getDisciplina());
            usuariobd.get().setIdade(usuario.getIdade());
            usuariobd.get().setNivelEducacional(usuario.getNivelEducacional());
            salvarAluno(usuariobd.get()); // Salva as alterações no banco de dados
        }
    }

    // Método para excluir um usuário por ID
    @Override
    public void excluirAluno(Long id) {
        usuarioRepository.deleteById(id); // Remove o usuário com o ID especificado do banco de dados
    }

    // Método privado para salvar um usuário no banco de dados
    private void salvarAluno(Usuario usuario) {
        usuarioRepository.save(usuario); // Salva o usuário no banco de dados
    }
}
