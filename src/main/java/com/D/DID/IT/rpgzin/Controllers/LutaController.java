package com.D.DID.IT.rpgzin.Controllers;

import com.D.DID.IT.rpgzin.Business.services.CadastroService;
import com.D.DID.IT.rpgzin.Business.services.LutaService;
import com.D.DID.IT.rpgzin.DTO.LutaRequest;
import com.D.DID.IT.rpgzin.Infrastructure.entities.PersonagemDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/luta")
@RequiredArgsConstructor
public class LutaController {
    private final CadastroService cadastroService;
    private final LutaService lutaService;

    @GetMapping
    public List<PersonagemDomain> lista(){
        return cadastroService.buscarTodos();
    }

    @PostMapping("/checar")
    @ResponseStatus(HttpStatus.OK)
    public String checagem(@RequestBody LutaRequest lutaRequest){
        return lutaService.lutar(lutaRequest.getAlvo(),lutaRequest.getJogador());
    }

    @PostMapping("/atacar")
    @ResponseStatus(HttpStatus.OK)
    public String atacar(@RequestBody LutaRequest lutaRequest){
        return lutaService.atacar(lutaRequest.getAlvo(), lutaRequest.getJogador());
    }
}
