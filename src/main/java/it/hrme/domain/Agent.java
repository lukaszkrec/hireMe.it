package it.hrme.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = {"company", "jobOffers"})
@EqualsAndHashCode(of = "uuid")
public class Agent {

    Long id;
    String uuid;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    Company company;
    @Builder.Default
    Set<JobOffer> jobOffers = new HashSet<>();
}
