package br.univille.projapifso2024b.service;

import java.util.List;
import br.univille.projapifso2024b.entity.Cliente;

public interface ClienteService {
    void save(Cliente cliente);
    Cliente getById(long id);
    List<Cliente> getAll();
}
