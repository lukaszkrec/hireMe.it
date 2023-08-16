package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Availability;
import it.hrme.infrastructure.database.entity.AvailabilityEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AvailabilityEntityMapper {

    @Mapping(target = "candidate", ignore = true)
    Availability mapFromEntity(AvailabilityEntity availabilityEntity);

    @Mapping(target = "candidate", ignore = true)
    AvailabilityEntity mapToEntity(Availability availability);
}
