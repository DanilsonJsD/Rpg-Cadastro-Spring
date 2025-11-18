package com.D.DID.IT.rpgzin.Infrastructure.entitys;

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
    private RACA raca;
    private String poder;
}

