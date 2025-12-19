package com.D.DID.IT.rpgzin.Controllers;

import com.D.DID.IT.rpgzin.Infrastructure.entities.PersonagemDomain;
import com.D.DID.IT.rpgzin.Business.services.CadastroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tela")
public class CadastroController {
private final CadastroService cadastroService;

    @GetMapping
    public List<PersonagemDomain> listarTodos (){
        return cadastroService.buscarTodos();
    }

    @GetMapping("/buscar-vulgo/{vulgo}")
    public PersonagemDomain buscarPorVulgo(@PathVariable String vulgo){
        return cadastroService.buscarPorVulgo(vulgo);
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody PersonagemDomain p){
        cadastroService.criar(p);
    }

    @DeleteMapping("/deletar/{vulgo}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarPorVulgo(@PathVariable String vulgo){
        cadastroService.deletarPorVulgo(vulgo);
    }

    @PutMapping("/atualizar/{vulgo}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarPorVulgo(@PathVariable String vulgo, @RequestBody PersonagemDomain p){
        cadastroService.atualizarPersonagemPorVulgo(vulgo,p);
    }

}
