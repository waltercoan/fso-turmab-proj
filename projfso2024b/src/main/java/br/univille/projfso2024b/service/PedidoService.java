package br.univille.projfso2024b.service;

import java.util.List;

import br.univille.projfso2024b.entity.Pedido;

public interface PedidoService {
    void save(Pedido pedido);
    Pedido getById(long id);
    List<Pedido> getAll();
    Pedido delete(long id);
}
