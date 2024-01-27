package it.hrme.business;

import it.hrme.domain.Candidate;
import it.hrme.domain.Contract;
import it.hrme.domain.JobOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
class HiringService {

    private final CandidateService candidateService;
    private final JobOfferService jobOfferService;
    private final ContractService contractService;

    @Transactional
    public void hireCandidate(String candidateEmail, Long jobOfferId) {
        Candidate candidate = candidateService.findByEmail(candidateEmail);
        candidate.hire();

        JobOffer jobOffer = jobOfferService.findById(jobOfferId);
        Contract contract = buildContract(candidate, jobOffer);
        contractService.save(contract);
    }

    private Contract buildContract(Candidate candidate, JobOffer jobOffer) {
        return Contract.builder()
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusYears(1L))
                .candidate(candidate)
                .jobOffer(jobOffer)
                .build();
    }
}
