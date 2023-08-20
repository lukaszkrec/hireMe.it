package it.hrme.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    public enum Status {
        ACTIVE, SUSPENDED
    }
}
