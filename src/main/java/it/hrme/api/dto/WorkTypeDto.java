package it.hrme.api.dto;

import it.hrme.infrastructure.database.constants.Type;
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
public class WorkTypeDto {

    private Long id;
    private String uuid;
    private Type type;
    @Builder.Default
    private Set<JobOfferDto> jobOffers = new HashSet<>();
}
