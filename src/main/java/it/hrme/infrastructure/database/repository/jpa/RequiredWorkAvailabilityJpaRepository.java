package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.RequiredWorkAvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequiredWorkAvailabilityJpaRepository extends JpaRepository<RequiredWorkAvailabilityEntity, Long> {
}
