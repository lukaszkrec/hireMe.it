package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyJpaRepository extends JpaRepository<TechnologyEntity, Long> {
}
