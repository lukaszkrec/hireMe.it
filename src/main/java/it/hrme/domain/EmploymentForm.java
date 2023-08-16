package it.hrme.domain;

import lombok.*;

@With
@Value
@Builder
@ToString(exclude = "jobOffer")
@EqualsAndHashCode(of = "uuid")
public class EmploymentForm {

    Long id;
    String uuid;
    Form form;
    JobOffer jobOffer;

    public enum Form {
        B2B, EMPLOYMENT_CONTRACT
    }
}
