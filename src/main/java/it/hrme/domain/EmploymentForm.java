package it.hrme.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = "jobOffers")
@EqualsAndHashCode(of = "uuid")
public class EmploymentForm {

    Long id;
    String uuid;
    Form form;
    @Builder.Default
    Set<JobOffer> jobOffers = new HashSet<>();

    public enum Form {
        B2B, EMPLOYMENT_CONTRACT
    }
}
