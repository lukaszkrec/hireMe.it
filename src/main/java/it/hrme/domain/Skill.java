package it.hrme.domain;

import lombok.*;

import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = {"candidates", "jobOffers"})
@EqualsAndHashCode(of = "uuid")
public class Skill {

    Long id;
    String uuid;
    String skillName;
    Set<Candidate> candidates;
    Set<JobOffer> jobOffers;
}
