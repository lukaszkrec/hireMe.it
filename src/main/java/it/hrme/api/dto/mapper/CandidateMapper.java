package it.hrme.api.dto.mapper;

import it.hrme.api.dto.CandidateDto;
import it.hrme.domain.Candidate;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {SkillMapperImpl.class, ContractMapperImpl.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CandidateMapper {

    Candidate mapFromDto(CandidateDto candidateDto);

    CandidateDto mapToDto(Candidate candidate);
}
