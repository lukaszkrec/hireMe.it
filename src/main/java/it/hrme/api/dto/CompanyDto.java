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
public class CompanyDto {

    private Long id;
    private String uuid;
    private String companyName;
    private String industry;
    private String description;
    @Builder.Default
    private Set<AgentDto> agents = new HashSet<>();
}

