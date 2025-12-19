package com.D.DID.IT.rpgzin.Infrastructure.entities;

import com.D.DID.IT.rpgzin.Infrastructure.listas.RACA;
import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Personagem")
public class PersonagemDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    @Column(name = "vulgo", unique = true)
    private String vulgo;
    @Enumerated(EnumType.STRING)
    private RACA raca;
    private String poder;
    private Integer vida;
    private Integer mana;
    private Integer forca;
    private Integer defesa;
    private Integer velocidade;
    private Integer exp;
    private Integer nivel;
}

