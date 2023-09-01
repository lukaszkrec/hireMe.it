package it.hrme.api.dto.mapper;

import it.hrme.api.dto.LocationDto;
import it.hrme.domain.Location;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface LocationMapper {

    @Mapping(target = "jobOffers", ignore = true)
    LocationDto mapToDto(Location location);


    @Mapping(target = "jobOffers", ignore = true)
    Location mapFromDto(LocationDto locationDto);
}
