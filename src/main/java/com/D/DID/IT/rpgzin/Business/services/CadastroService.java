package com.D.DID.IT.rpgzin.Business.services;

import com.D.DID.IT.rpgzin.Infrastructure.entitys.PersonagemDomain;
import com.D.DID.IT.rpgzin.Infrastructure.repositories.CadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastroService {
    private final CadastroRepository cadastroRepository;

    public List<PersonagemDomain> buscarTodos(){
        return cadastroRepository.findAll().stream().toList();
    }

    public PersonagemDomain buscarPorVulgo(String vulgo){
        return cadastroRepository.findByVulgo(vulgo).orElseThrow(() -> new RuntimeException("Vulgo desconhecido"));
    }

    public void criar(PersonagemDomain personagem){cadastroRepository.saveAndFlush(personagem); }

    public void deletarPorVulgo(String vulgo){ cadastroRepository.deletePorVulgo(vulgo); }

    public void atualizarPersonagemPorVulgo(String vulgo, PersonagemDomain personagem){
        PersonagemDomain p = buscarPorVulgo(vulgo); //aqui o cara já pega pelo vulgo se existir, senão dá erro

        PersonagemDomain pNovo = PersonagemDomain.builder() //troca os dados se tiver, senao usa os que já tinha
                .id(p.getId())
                .nome(personagem.getNome() != null ? personagem.getNome() : p.getNome())
                .vulgo(p.getVulgo())
                .raca(personagem.getRaca() != null ? personagem.getRaca() : p.getRaca())
                .poder(personagem.getPoder() != null ? personagem.getPoder() : p.getPoder())
                .build();

        cadastroRepository.saveAndFlush(pNovo);
    }
}
