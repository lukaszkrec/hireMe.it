package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.constants.SkillName;
import it.hrme.infrastructure.database.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillJpaRepository extends JpaRepository<SkillEntity, Long> {

    SkillEntity findBySkillName(SkillName skillName);
}
