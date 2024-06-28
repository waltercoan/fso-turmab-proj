package br.univille.projapifso2024b.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.univille.projapifso2024b.entity.Usuario;
import br.univille.projapifso2024b.repository.UsuarioRepository;
import br.univille.projapifso2024b.service.UsuarioService;
import org.springframework.security.core.userdetails.User;

@Service
public class UsuarioServiceImpl implements UserDetailsService,UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void save(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public Optional<Usuario> findByUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = repository.findByUsuario(username);
        if(usuario.isPresent()){
            var usuarioEncontrado = usuario.get();
            return new User(usuarioEncontrado.getUsuario(),
                            usuarioEncontrado.getSenha(),
                            new ArrayList<>());
        }
        return null;
    }
    
}
