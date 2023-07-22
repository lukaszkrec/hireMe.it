package it.hrme.infrastructure.database.repository.jpa;


import it.hrme.infrastructure.database.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageJpaRepository extends JpaRepository<LanguageEntity, Long> {
}
