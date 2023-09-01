package it.hrme.api.dto;

import it.hrme.infrastructure.database.constants.Status;
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
public class CandidateDto {

    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private byte[] photo;
    private String overview;
    @Builder.Default
    private boolean workInterest = true;
    @Builder.Default
    private Set<SkillDto> skills = new HashSet<>();
    @Builder.Default
    private Status status = Status.ACTIVE;
    @Builder.Default
    private Set<ContractDto> contracts = new HashSet<>();
}
