package it.hrme.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobOfferDto {

    private Long id;
    private String uuid;
    private String title;
    private String description;
    private BigDecimal salary;
    private LocalDate datePublished;
    @Builder.Default
    private Set<SkillDto> skills = new HashSet<>();
    private AgentDto agent;
    private ContractDto contract;
    @Builder.Default
    private Set<WorkTypeDto> workTypes = new HashSet<>();
    @Builder.Default
    private Set<RequiredWorkAvailabilityDto> requiredWorkAvailabilities = new HashSet<>();
    @Builder.Default
    private Set<EmploymentFormDto> employmentForms = new HashSet<>();
    @Builder.Default
    private Set<LocationDto> locations = new HashSet<>();
}
