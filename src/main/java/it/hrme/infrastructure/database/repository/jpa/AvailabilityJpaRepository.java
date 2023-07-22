package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.AvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityJpaRepository extends JpaRepository<AvailabilityEntity, Long> {
}
