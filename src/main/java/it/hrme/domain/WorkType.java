package it.hrme.domain;

import lombok.*;

@With
@Value
@Builder
@ToString(exclude = "jobOffer")
@EqualsAndHashCode(of = "uuid")
public class WorkType {

    Long id;
    String uuid;
    Type type;
    JobOffer jobOffer;

    public enum Type {
        REMOTE, STATIONARY, HYBRID
    }
}
