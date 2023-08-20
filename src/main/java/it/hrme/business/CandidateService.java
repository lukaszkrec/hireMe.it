package it.hrme.business;

import it.hrme.business.dao.CandidateDAO;
import it.hrme.domain.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateDAO candidateDAO;

    @Transactional
    public Candidate save(Candidate candidate) {
        return candidateDAO.save(candidate);
    }

    @Transactional
    public Candidate findByEmail(String candidateEmail) {
        return candidateDAO.findByEmail(candidateEmail);
    }

    @Transactional
    public List<Candidate> findAll() {
        return candidateDAO.findAll();
    }

    @Transactional
    public List<Candidate> findAllBySkill(String skill) {
        return candidateDAO.findAllBySkill(skill);
    }

    @Transactional
    public List<Candidate> findAllByStatus(String status) {
        return candidateDAO.findAllByStatus(status);
    }

    @Transactional
    public Candidate findById(Long candidateId) {
        return candidateDAO.findById(candidateId);
    }

    @Transactional
    public void updateWorkInterest(String candidateEmail, boolean workInterest) {
        candidateDAO.updateWorkInterest(candidateEmail, workInterest);
    }
}
