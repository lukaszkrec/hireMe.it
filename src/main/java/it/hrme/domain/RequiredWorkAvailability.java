package it.hrme.domain;

import lombok.*;

@With
@Value
@Builder
@ToString(exclude = "jobOffer")
@EqualsAndHashCode(of = "uuid")
public class RequiredWorkAvailability {

    Long id;
    String uuid;
    WorkAvailability workAvailability;
    JobOffer jobOffer;

    public enum WorkAvailability {
        FULL_TIME, PART_TIME
    }
}
