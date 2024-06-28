package br.univille.projapifso2024b.service;

import java.util.Optional;
import br.univille.projapifso2024b.entity.Usuario;

public interface UsuarioService {
    void save(Usuario usuario);
    Optional<Usuario> findByUsuario(String usuario);
}
