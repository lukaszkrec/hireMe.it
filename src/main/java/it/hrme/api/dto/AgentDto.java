package it.hrme.api.dto;

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
public class AgentDto {

    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private CompanyDto company;
    @Builder.Default
    private Set<JobOfferDto> jobOffers = new HashSet<>();
}
