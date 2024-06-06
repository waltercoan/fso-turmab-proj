package br.univille.projfso2024b.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024b.entity.Pedido;
import br.univille.projfso2024b.repository.PedidoRepository;
import br.univille.projfso2024b.service.PedidoService;

@Service
public class PedidoServiceImpl 
    implements PedidoService{

    @Autowired
    private PedidoRepository repository;
    
    @Override
    public void save(Pedido pedido) {
        repository.save(pedido);
    }

    @Override
    public Pedido getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Pedido> getAll() {
        return repository.findAll();
    }

    @Override
    public Pedido delete(long id) {
        var pedido = getById(id);
        repository.delete(pedido);
        return pedido;
    }
    
}
