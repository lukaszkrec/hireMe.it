package it.hrme.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = "jobOffers")
@EqualsAndHashCode(of = "uuid")
public class WorkType {

    Long id;
    String uuid;
    Type type;
    @Builder.Default
    Set<JobOffer> jobOffers = new HashSet<>();

    public enum Type {
        REMOTE, STATIONARY, HYBRID
    }
}
