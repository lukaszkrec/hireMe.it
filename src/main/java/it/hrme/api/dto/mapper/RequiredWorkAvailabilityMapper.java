package it.hrme.api.dto.mapper;

import it.hrme.api.dto.RequiredWorkAvailabilityDto;
import it.hrme.domain.RequiredWorkAvailability;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface RequiredWorkAvailabilityMapper {


    @Mapping(target = "jobOffers", ignore = true)
    RequiredWorkAvailability mapFromDto(RequiredWorkAvailabilityDto requiredWorkAvailabilityDto);

    @Mapping(target = "jobOffers", ignore = true)
    RequiredWorkAvailabilityDto mapToDto(RequiredWorkAvailability workAvailability);
}
