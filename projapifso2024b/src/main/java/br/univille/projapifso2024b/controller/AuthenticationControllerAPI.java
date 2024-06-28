package br.univille.projapifso2024b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projapifso2024b.entity.Usuario;
import br.univille.projapifso2024b.security.JWTUtil;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationControllerAPI {
    @Autowired
    private UserDetailsService service;
    @Autowired
    private JWTUtil serviceJWT;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody Usuario usuario){
        var userDetail = service.loadUserByUsername(usuario.getUsuario());
        if(userDetail.getPassword().equals(usuario.getSenha())){
            var token = serviceJWT.generateToken(userDetail);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }
    
}
