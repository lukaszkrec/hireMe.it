package it.hrme.infrastructure.database.repository.jpa;


import it.hrme.infrastructure.database.entity.CertificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationJpaRepository extends JpaRepository<CertificationEntity, Long> {
}

