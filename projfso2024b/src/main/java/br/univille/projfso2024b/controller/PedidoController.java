package br.univille.projfso2024b.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.entity.ItemPedido;
import br.univille.projfso2024b.entity.Pedido;
import br.univille.projfso2024b.service.PedidoService;
import br.univille.projfso2024b.service.ProdutoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView index(){
        var listaPedidos = pedidoService.getAll();
        return new ModelAndView("pedido/index","listaPedidos",listaPedidos);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var pedido = new Pedido();
        var novoItem = new ItemPedido();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pedido",pedido);
        dados.put("novoItem",novoItem);
        dados.put("listaProdutos", produtoService.getAll());
        return new ModelAndView("pedido/form",dados);
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Pedido pedido, 
                                    ItemPedido novoItem){
        pedido.getItensPedido().add(novoItem);
        
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pedido",pedido);
        dados.put("novoItem",new ItemPedido());
        dados.put("listaProdutos", produtoService.getAll());
        return new ModelAndView("pedido/form",dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(Pedido pedido){

        pedidoService.save(pedido);        

        return new ModelAndView("redirect:/pedidos");
    }
    
}
