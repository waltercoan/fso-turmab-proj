package br.univille.projfso2024b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfso2024b.entity.Cidade;

@Repository
public interface CidadeRepository 
    extends JpaRepository<Cidade,Long>{
    
}
