package it.hrme.business.dao;

import it.hrme.domain.Candidate;
import it.hrme.domain.Skill;

import java.util.List;
import java.util.Set;

public interface CandidateDAO {

    Candidate save(Candidate candidate);

    Set<Candidate> findAll();

    List<Candidate> search(String keyword);

    List<Candidate> findAllBySkills(Set<Skill> skills);

    Candidate findByAvailabilityStatus(String status);

    Candidate findById(Long candidateId);
}
