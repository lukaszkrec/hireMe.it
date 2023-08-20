package it.hrme.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = "jobOffers")
@EqualsAndHashCode(of = "uuid")
public class RequiredWorkAvailability {

    Long id;
    String uuid;
    WorkAvailability workAvailability;
    @Builder.Default
    Set<JobOffer> jobOffers = new HashSet<>();

    public enum WorkAvailability {
        FULL_TIME, PART_TIME
    }
}
