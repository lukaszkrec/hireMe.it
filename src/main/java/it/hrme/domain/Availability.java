package it.hrme.domain;

import lombok.*;

@With
@Value
@Builder
@ToString(exclude = "candidate")
@EqualsAndHashCode(of = "uuid")
public class Availability {

    Long id;
    String uuid;
    Status status;
    Candidate candidate;

    public enum Status {
        ACTIVE, SUSPENDED
    }
}
