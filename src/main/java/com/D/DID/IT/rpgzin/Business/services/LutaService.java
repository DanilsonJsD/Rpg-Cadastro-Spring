package com.D.DID.IT.rpgzin.Business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.max;

@Service
@AllArgsConstructor
public class LutaService {
    private final CadastroService cad;

    public String lutar(String alvoVulgo, String atacanteVulgo){

        var defensor = cad.buscarPorVulgo(alvoVulgo);
        var atacante = cad.buscarPorVulgo(atacanteVulgo);

        Integer alvoVida = checarVidaAlvo(alvoVulgo);
        Integer jogadorVida = checarVida(atacanteVulgo);

        return atacante.getVulgo() + " tem % " + jogadorVida + " de vida, e " + defensor.getVulgo() + " tem " + alvoVida;
    }
    public Integer checarVida(String jogadorVulgo){
        var jogador = cad.buscarPorVulgo(jogadorVulgo);
        return jogador.getVida();
    }
    public Integer checarVidaAlvo(String alvoVulgo){
        var alvo = cad.buscarPorVulgo(alvoVulgo);
        return alvo.getVida();
    }
    public String atacar(String atacanteVulgo, String alvoVulgo) {

        var atacante = cad.buscarPorVulgo(atacanteVulgo);
        var alvo = cad.buscarPorVulgo(alvoVulgo);

        int danoBase = atacante.getForca() - alvo.getDefesa();
        if (danoBase <= 0) danoBase = 1;

        double variacao = ThreadLocalRandom.current().nextDouble(0.5, 1.0);
        int dano = (int) Math.round(danoBase * variacao);

        int vidaRestante = alvo.getVida() - dano;
        alvo.setVida(Math.max(vidaRestante, 0));

        cad.criar(alvo);

        return atacante.getVulgo() + " causou " + dano +
                " de dano em " + alvo.getVulgo() +
                ". Vida restante: " + alvo.getVida();
    }




}
