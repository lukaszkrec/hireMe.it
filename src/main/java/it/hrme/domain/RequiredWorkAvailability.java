package it.hrme.domain;

import it.hrme.infrastructure.database.constants.WorkAvailability;
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
}
