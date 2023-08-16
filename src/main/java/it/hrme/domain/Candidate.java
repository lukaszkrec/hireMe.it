package it.hrme.domain;

import lombok.*;

import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = {"skills", "availability", "address", "contracts"})
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
    Set<Skill> skills;
    Availability availability;
    Address address;
    Set<Contract> contracts;
}
