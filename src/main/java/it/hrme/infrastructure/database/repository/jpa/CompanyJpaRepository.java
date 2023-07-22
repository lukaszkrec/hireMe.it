package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Long> {
}
