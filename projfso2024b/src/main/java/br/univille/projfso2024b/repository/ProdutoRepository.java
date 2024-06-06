package br.univille.projfso2024b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfso2024b.entity.Produto;

@Repository
public interface ProdutoRepository
    extends JpaRepository<Produto,Long> {
    
}
