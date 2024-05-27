package br.univille.projfso2024b.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.service.CidadeService;
import br.univille.projfso2024b.service.ClienteService;
import br.univille.projfso2024b.service.impl.CidadeServiceImpl;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    @Autowired
    private CidadeService serviceCidade;

    @GetMapping
    public ModelAndView index(){
        var listaClientes = service.getAll();
        
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listaClientes",listaClientes);

        return new ModelAndView("cliente/index",dados);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        HashMap<String,Object> dados = new HashMap<>();
        var listaCidades = serviceCidade.getAll();
        dados.put("listaCidades",listaCidades);
        dados.put("cliente",cliente);
        return new ModelAndView("cliente/form",dados);
    }

    @PostMapping()
    public ModelAndView save(Cliente cliente){
        service.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        HashMap<String,Object> dados = new HashMap<>();
        var cliente = service.getById(id);
        dados.put("cliente",cliente);
        var listaCidades = serviceCidade.getAll();
        dados.put("listaCidades",listaCidades);

        return new ModelAndView("cliente/form",dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/clientes");
    }
}
