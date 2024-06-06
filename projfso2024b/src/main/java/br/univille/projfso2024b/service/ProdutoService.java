package br.univille.projfso2024b.service;

import java.util.List;
import br.univille.projfso2024b.entity.Produto;

public interface ProdutoService {
    void save(Produto produto);
    Produto getById(long id);
    List<Produto> getAll();
    Produto delete(long id);
}
