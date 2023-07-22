package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.EmploymentFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentFormJpaRepository extends JpaRepository<EmploymentFormEntity, Long> {
}
