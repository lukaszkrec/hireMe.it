package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.CandidateDAO;
import it.hrme.domain.Candidate;
import it.hrme.infrastructure.database.entity.CandidateEntity;
import it.hrme.infrastructure.database.repository.jpa.CandidateJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.CandidateEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CandidateRepository implements CandidateDAO {

    private final CandidateJpaRepository candidateJpaRepository;
    private final CandidateEntityMapper candidateEntityMapper;

    @Override
    public Candidate save(Candidate candidate) {
        CandidateEntity candidateEntity = candidateEntityMapper.mapToEntity(candidate);
        CandidateEntity savedCandidate = candidateJpaRepository.save(candidateEntity);
        return candidateEntityMapper.mapFromEntity(savedCandidate);
    }

    @Override
    public List<Candidate> findAll() {
        return candidateJpaRepository.findAll()
                .stream()
                .map(candidateEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public List<Candidate> findAllBySkill(String skill) {
        List<CandidateEntity> candidateEntities = candidateJpaRepository.findAllBySkill(skill);
        return candidateEntities.stream()
                .map(candidateEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public List<Candidate> findAllByStatus(String status) {
        if (status.equalsIgnoreCase("ACTIVE")) {
            List<CandidateEntity> candidateEntities = candidateJpaRepository.findByStatus(CandidateEntity.Status.ACTIVE);
            return candidateEntities.stream()
                    .map(candidateEntityMapper::mapFromEntity)
                    .toList();
        }

        if (status.equalsIgnoreCase("SUSPENDED")) {
            List<CandidateEntity> candidateEntities = candidateJpaRepository.findByStatus(CandidateEntity.Status.SUSPENDED);
            return candidateEntities.stream()
                    .map(candidateEntityMapper::mapFromEntity)
                    .toList();
        }

        throw new EntityNotFoundException("Unknown status for CandidateEntity [%s]".formatted(status));
    }

    @Override
    public Candidate findById(Long candidateId) {
        CandidateEntity candidateEntity = candidateJpaRepository.findById(candidateId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Candidate with id: {%s} does not exist!".formatted(candidateId))
                );
        return candidateEntityMapper.mapFromEntity(candidateEntity);
    }

    @Override
    public Candidate findByEmail(String candidateEmail) {
        return candidateJpaRepository.findByEmail(candidateEmail)
                .map(candidateEntityMapper::mapFromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Candidate with email: {%s} does not exist!".formatted(candidateEmail))
                );
    }

    @Override
    public void updateWorkInterest(String candidateEmail, boolean workInterest) {
        Candidate candidate = findByEmail(candidateEmail);
        CandidateEntity candidateEntity = candidateEntityMapper.mapToEntity(candidate);
        if (workInterest) {
            candidateEntity.setWorkInterest(true);
            candidateEntity.setStatus(CandidateEntity.Status.ACTIVE);
        }
        candidateEntity.setWorkInterest(false);
        candidateEntity.setStatus(CandidateEntity.Status.SUSPENDED);
    }
}
