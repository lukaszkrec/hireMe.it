package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Location;
import it.hrme.infrastructure.database.entity.LocationEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LocationEntityMapper {

    @Mapping(target = "jobOffers", ignore = true)
    LocationEntity mapToEntity(Location location);

    @Mapping(target = "jobOffers", ignore = true)
    Location mapFromEntity(LocationEntity locationEntity);
}
