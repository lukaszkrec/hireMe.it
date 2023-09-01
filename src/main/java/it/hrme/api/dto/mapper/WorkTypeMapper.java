package it.hrme.api.dto.mapper;

import it.hrme.api.dto.WorkTypeDto;
import it.hrme.domain.WorkType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface WorkTypeMapper {

    @Mapping(target = "jobOffers", ignore = true)
    WorkType mapFromDto(WorkTypeDto workTypeDto);

    @Mapping(target = "jobOffers", ignore = true)
    WorkTypeDto mapToDto(WorkType workType);
}
