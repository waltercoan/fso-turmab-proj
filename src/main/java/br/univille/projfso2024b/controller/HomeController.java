package br.univille.projfso2024b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    @ResponseBody
    public String index(){
        return "Mãe, eu nao acredito";
    }
}
