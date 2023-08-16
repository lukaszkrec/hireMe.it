package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.RequiredWorkAvailability;
import it.hrme.infrastructure.database.entity.RequiredWorkAvailabilityEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RequiredWorkAvailabilityEntityMapper {

    @Mapping(target = "jobOffer", ignore = true)
    RequiredWorkAvailability mapFromEntity(RequiredWorkAvailabilityEntity requiredWorkAvailabilityEntity);

    @Mapping(target = "jobOffer", ignore = true)
    RequiredWorkAvailabilityEntity mapToEntity(RequiredWorkAvailability workAvailability);
}
