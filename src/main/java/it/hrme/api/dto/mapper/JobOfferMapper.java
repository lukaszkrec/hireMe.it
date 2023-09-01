package it.hrme.api.dto.mapper;

import it.hrme.api.dto.JobOfferDto;
import it.hrme.domain.JobOffer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {WorkTypeMapper.class,
        SkillMapperImpl.class,
        RequiredWorkAvailabilityMapperImpl.class,
        LocationMapperImpl.class,
        EmploymentFormMapperImpl.class,
        ContractMapperImpl.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface JobOfferMapper {


    @Mapping(target = "agent", ignore = true)
    JobOffer mapFromDto(JobOfferDto jobOfferDto);

    @Mapping(target = "agent", ignore = true)
    JobOfferDto mapToDto(JobOffer jobOffer);
}
