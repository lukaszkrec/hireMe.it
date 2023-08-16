package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Candidate;
import it.hrme.infrastructure.database.entity.CandidateEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {SkillEntityMapper.class,
        ContractEntityMapper.class,
        AvailabilityEntityMapper.class,
        AddressEntityMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CandidateEntityMapper {

    Candidate mapFromEntity(CandidateEntity candidateEntity);

    CandidateEntity mapToEntity(Candidate candidate);
}
