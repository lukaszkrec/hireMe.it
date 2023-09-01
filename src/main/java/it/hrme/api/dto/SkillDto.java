package it.hrme.api.dto;

import it.hrme.infrastructure.database.constants.SkillName;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@ToString(exclude = {"candidates", "jobOffers"})
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {

    private Long id;
    private String uuid;
    private SkillName skillName;
    @Builder.Default
    private Set<CandidateDto> candidates = new HashSet<>();
    @Builder.Default
    private Set<JobOfferDto> jobOffers = new HashSet<>();
}
