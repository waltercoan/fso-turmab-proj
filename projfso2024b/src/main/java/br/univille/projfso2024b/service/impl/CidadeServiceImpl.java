package br.univille.projfso2024b.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024b.entity.Cidade;
import br.univille.projfso2024b.repository.CidadeRepository;
import br.univille.projfso2024b.service.CidadeService;

@Service
public class CidadeServiceImpl 
    implements CidadeService{

    @Autowired
    private CidadeRepository repository;
    @Override
    public List<Cidade> getAll() {
        return repository.findAll();
    }
    
}
