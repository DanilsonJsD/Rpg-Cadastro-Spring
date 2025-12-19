package com.D.DID.IT.rpgzin.Infrastructure.repositories;

import com.D.DID.IT.rpgzin.Infrastructure.entities.PersonagemDomain;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CadastroRepository extends JpaRepository<PersonagemDomain, UUID> {

    Optional<PersonagemDomain> findByVulgo(String vulgo);

    @Transactional
    void deleteByVulgo(String vulgo);
}
