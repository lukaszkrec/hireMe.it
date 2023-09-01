package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.SkillDAO;
import it.hrme.domain.Skill;
import it.hrme.infrastructure.database.repository.jpa.SkillJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.SkillEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class SkillRepository implements SkillDAO {

    private final SkillJpaRepository skillJpaRepository;
    private final SkillEntityMapper skillEntityMapper;

    @Override
    public List<Skill> findAll() {
        return skillJpaRepository.findAll()
                .stream()
                .map(skillEntityMapper::mapFromEntity)
                .toList();
    }
}
