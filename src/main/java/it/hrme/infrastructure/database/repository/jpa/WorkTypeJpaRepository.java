package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.WorkTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTypeJpaRepository extends JpaRepository<WorkTypeEntity, Long> {
}
