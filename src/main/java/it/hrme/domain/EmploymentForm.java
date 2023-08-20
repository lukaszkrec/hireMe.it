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

    @Getter
    @AllArgsConstructor
    public enum Form {
        B2B("B2B"), EMPLOYMENT_CONTRACT("Emloyment contract");

        private final String label;
    }
}
