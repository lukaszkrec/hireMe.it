package it.hrme.domain;

import it.hrme.infrastructure.database.constants.Status;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = {"skills", "contracts"})
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
    @Builder.Default
    Set<Contract> contracts = new HashSet<>();
}
