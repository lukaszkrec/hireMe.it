package it.hrme.api.dto;

import it.hrme.infrastructure.database.constants.WorkAvailability;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequiredWorkAvailabilityDto {

    private Long id;
    private String uuid;
    private WorkAvailability workAvailability;
    @Builder.Default
    private Set<JobOfferDto> jobOffers = new HashSet<>();
}
