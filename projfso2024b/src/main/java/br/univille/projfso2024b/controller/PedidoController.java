package br.univille.projfso2024b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    
}
