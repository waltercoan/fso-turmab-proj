package br.univille.projapifso2024b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projapifso2024b.entity.Cliente;
import br.univille.projapifso2024b.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteControllerAPI {
    @Autowired
    private ClienteService service;
    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){
        var listaClientes  = service.getAll();
        return new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
    }
}