package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractJpaRepository extends JpaRepository<ContractEntity, Long> {
}
