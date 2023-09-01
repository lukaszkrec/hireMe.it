package it.hrme.business;

import it.hrme.domain.Candidate;
import it.hrme.domain.Contract;
import it.hrme.domain.JobOffer;
import it.hrme.domain.exception.CandidateSuspendedStatusException;
import it.hrme.domain.exception.ContractNotCompletedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static it.hrme.infrastructure.database.constants.Status.SUSPENDED;

@Service
@RequiredArgsConstructor
class HiringService {

    private final CandidateService candidateService;
    private final JobOfferService jobOfferService;
    private final ContractService contractService;

    @Transactional
    public void hireCandidate(String candidateEmail, Long jobOfferId) {
        Candidate candidate = candidateService.findByEmail(candidateEmail);

        if (candidate.getStatus().equals(SUSPENDED)) {
            throw new CandidateSuspendedStatusException("Can not hire SUSPENDED Candidate");
        }

        if (candidate.getContracts().stream().anyMatch(contract -> contract.getEndDate().isAfter(LocalDate.now()))) {
            throw new ContractNotCompletedException("Candidate has uncompleted contract!");
        }

        Candidate candidateWithChangedStatus = candidate.withStatus(SUSPENDED);
        JobOffer jobOffer = jobOfferService.findById(jobOfferId);
        Contract contract = buildContract(candidateWithChangedStatus, jobOffer);
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
