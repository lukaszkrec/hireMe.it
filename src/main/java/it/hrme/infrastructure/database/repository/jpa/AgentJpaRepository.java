package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentJpaRepository extends JpaRepository<AgentEntity, Long> {

    Optional<AgentEntity> findByEmail(String email);
}
