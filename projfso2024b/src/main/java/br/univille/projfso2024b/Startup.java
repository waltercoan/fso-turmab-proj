package br.univille.projfso2024b;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.entity.Produto;
import br.univille.projfso2024b.service.ClienteService;
import br.univille.projfso2024b.service.ProdutoService;

@Component
public class Startup {
    
    @Autowired
    private ClienteService service;
    @Autowired
    private ProdutoService produtoService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        var cliente1 = new Cliente();
        cliente1.setNome("Zezinho da Silva Sauro");
        cliente1.setEndereco("Rua lalalala 1000");
        cliente1.setDataNascimento(new Date());
        service.save(cliente1);

        var prod1 = new Produto();
        prod1.setDescricao("Nintendo Switch");
        prod1.setValor(2000f);
        produtoService.save(prod1);

        var prod2 = new Produto();
        prod2.setDescricao("XBOX Series X");
        prod2.setValor(4500f);
        produtoService.save(prod2);
    }
}
