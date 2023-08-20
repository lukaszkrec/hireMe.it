package it.hrme.domain;

import it.hrme.domain.exception.CandidateSuspendedStatusException;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import static it.hrme.domain.Candidate.Status.SUSPENDED;

@With
@Value
@Builder
@ToString(exclude = {"skills", "address", "contracts"})
@EqualsAndHashCode(of = "uuid")
public class Candidate {

    Long id;
    String uuid;
    String firstName;
    String lastName;
    String phone;
    String email;
    byte[] photo;
    String overview;
    boolean workInterest;
    @Builder.Default
    Set<Skill> skills = new HashSet<>();
    Status status;
    Address address;
    @Builder.Default
    Set<Contract> contracts = new HashSet<>();

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"), SUSPENDED("Suspended");

        private final String label;
    }
}
