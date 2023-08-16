package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.CandidateDAO;
import it.hrme.domain.Candidate;
import it.hrme.domain.Skill;
import it.hrme.infrastructure.database.entity.CandidateEntity;
import it.hrme.infrastructure.database.entity.SkillEntity;
import it.hrme.infrastructure.database.repository.jpa.CandidateJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.CandidateEntityMapper;
import it.hrme.infrastructure.database.repository.mapper.SkillEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CandidateRepository implements CandidateDAO {

    private final CandidateJpaRepository candidateJpaRepository;
    private final CandidateEntityMapper candidateEntityMapper;
    private final SkillEntityMapper skillEntityMapper;

    @Override
    public Candidate save(Candidate candidate) {
        CandidateEntity candidateEntity = candidateEntityMapper.mapToEntity(candidate);
        CandidateEntity savedCandidate = candidateJpaRepository.save(candidateEntity);
        return candidateEntityMapper.mapFromEntity(savedCandidate);
    }

    @Override
    public Set<Candidate> findAll() {
        return candidateJpaRepository.findAll()
                .stream()
                .map(candidateEntityMapper::mapFromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public List<Candidate> search(String keyword) {
        return candidateJpaRepository.search(keyword)
                .stream()
                .map(candidateEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public List<Candidate> findAllBySkills(Set<Skill> skills) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withIgnoreCase();
        Set<SkillEntity> skillEntities = skills.stream()
                .map(skillEntityMapper::mapToEntity)
                .collect(Collectors.toSet());

        CandidateEntity candidateEntity = CandidateEntity.builder()
                .skills(skillEntities)
                .build();
        Example<CandidateEntity> example = Example.of(candidateEntity, exampleMatcher);
        return candidateJpaRepository.findAll(example)
                .stream()
                .map(candidateEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public Candidate findByAvailabilityStatus(String status) {
        CandidateEntity candidate = candidateJpaRepository.findByAvailability_Status(status);
        return candidateEntityMapper.mapFromEntity(candidate);
    }

    @Override
    public Candidate findById(Long candidateId) {
        CandidateEntity candidateEntity = candidateJpaRepository.findById(candidateId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Candidate with id: {%s} does not exist!".formatted(candidateId))
                );
        return candidateEntityMapper.mapFromEntity(candidateEntity);
    }
}
