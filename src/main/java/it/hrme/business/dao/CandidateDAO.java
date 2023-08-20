package it.hrme.business.dao;

import it.hrme.domain.Candidate;

import java.util.List;

public interface CandidateDAO {
    Candidate save(Candidate candidate);

    List<Candidate> findAll();

    List<Candidate> findAllBySkill(String skill);

    List<Candidate> findAllByStatus(String status);

    Candidate findById(Long candidateId);
}
