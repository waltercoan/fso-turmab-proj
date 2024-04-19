package br.univille.projapifso2024b;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.univille.projapifso2024b.entity.Cliente;
import br.univille.projapifso2024b.service.ClienteService;

@Component
public class Startup {
    
    @Autowired
    private ClienteService service;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        var cliente1 = new Cliente();
        cliente1.setNome("Zezinho da Silva Sauro");
        cliente1.setEndereco("Rua lalalala 1000");
        cliente1.setDataNascimento(new Date());
        service.save(cliente1);
    }
}
