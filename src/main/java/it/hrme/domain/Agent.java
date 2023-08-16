package it.hrme.domain;

import lombok.*;

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
    Set<JobOffer> jobOffers;
}
