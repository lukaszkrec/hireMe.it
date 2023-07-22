package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.JobOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferJpaRepository extends JpaRepository<JobOfferEntity, Long> {
}
