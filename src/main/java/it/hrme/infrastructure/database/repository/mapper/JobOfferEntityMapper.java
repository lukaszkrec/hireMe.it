package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.JobOffer;
import it.hrme.infrastructure.database.entity.JobOfferEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {WorkTypeEntityMapper.class,
        SkillEntityMapper.class,
        RequiredWorkAvailabilityEntityMapper.class,
        LocationEntityMapper.class,
        EmploymentFormEntityMapper.class,
        ContractEntityMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface JobOfferEntityMapper {

    @Mapping(target = "agent", ignore = true)
    JobOffer mapFromEntity(JobOfferEntity jobOfferEntity);

    @Mapping(target = "agent", ignore = true)
    JobOfferEntity mapToEntity(JobOffer jobOffer);
}
