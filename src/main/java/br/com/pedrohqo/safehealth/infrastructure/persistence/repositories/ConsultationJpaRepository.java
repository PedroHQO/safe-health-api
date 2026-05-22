package br.com.pedrohqo.safehealth.infrastructure.persistence.repositories;

import br.com.pedrohqo.safehealth.infrastructure.persistence.entities.ConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultationJpaRepository extends JpaRepository<ConsultationEntity, UUID> {
}
