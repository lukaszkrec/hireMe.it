package it.hrme.domain;

import it.hrme.domain.exception.CandidateSuspendedStatusException;
import it.hrme.domain.exception.ContractNotCompletedException;
import it.hrme.infrastructure.database.constants.Status;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static it.hrme.infrastructure.database.constants.Status.SUSPENDED;

@Setter
@Getter
@Builder
@ToString(exclude = {"skills", "contracts"})
@EqualsAndHashCode(of = "uuid")
public class Candidate {

    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private byte[] photo;
    private String overview;
    private boolean workInterest;
    @Builder.Default
    private Set<Skill> skills = new HashSet<>();
    private Status status;
    @Builder.Default
    private Set<Contract> contracts = new HashSet<>();

    public void hire() {
        if (status.equals(SUSPENDED)) {
            throw new CandidateSuspendedStatusException("Can not hire SUSPENDED Candidate");
        }

        if (contracts.stream().anyMatch(contract -> contract.getEndDate().isAfter(LocalDate.now()))) {
            throw new ContractNotCompletedException("Candidate has uncompleted contract!");
        }

        status = SUSPENDED;
    }

}
