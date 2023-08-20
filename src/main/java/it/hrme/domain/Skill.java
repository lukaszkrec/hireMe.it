package it.hrme.domain;

import lombok.*;

import java.util.HashSet;
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
    @Builder.Default
    Set<Candidate> candidates = new HashSet<>();
    @Builder.Default
    Set<JobOffer> jobOffers = new HashSet<>();
}
