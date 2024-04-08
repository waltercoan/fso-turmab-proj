package br.univille.projapifso2024b.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteControllerAPI {
    
    @GetMapping
    public ResponseEntity<Cliente> getClientes(){
        return new ResponseEntity<Cliente>(new Cliente("Zezinho"), HttpStatus.OK);
    }
}

class Cliente{
    private String nome;
    public Cliente(String nome) {
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
}