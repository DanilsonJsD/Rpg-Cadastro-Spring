package com.D.DID.IT.rpgzin.Controllers;

import com.D.DID.IT.rpgzin.Infrastructure.entitys.PersonagemDomain;
import com.D.DID.IT.rpgzin.Business.services.CadastroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tela")
public class CadastroController {
private final CadastroService cadastroService;

    @GetMapping
    public String hello(){
        return "conseguiu criar um controller funcional";
    }

    @GetMapping
    public List<PersonagemDomain> listarTodos (){
        return cadastroService.buscarTodos();
    }

    @PostMapping("/{vulgo}")
    public PersonagemDomain buscarPorVulgo(@PathVariable String vulgo){
        return cadastroService.buscarPorVulgo(vulgo);
    }

    @PostMapping("/criar")
    public void criar(@RequestBody PersonagemDomain p){
        cadastroService.criar(p);
    }

    @DeleteMapping("/deletar/{vulgo}")
    public void deletarPorVulgo(@PathVariable String vulgo){
        cadastroService.deletarPorVulgo(vulgo);
    }

    @PutMapping("/atualizar/{vulgo}")
    public void atualizarPorVulgo(@PathVariable String vulgo, @RequestBody PersonagemDomain p){
        cadastroService.atualizarPersonagemPorVulgo(vulgo,p);
    }

}
