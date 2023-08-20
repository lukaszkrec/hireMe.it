package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.WorkType;
import it.hrme.infrastructure.database.entity.WorkTypeEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface WorkTypeEntityMapper {

    @Mapping(target = "jobOffers", ignore = true)
    WorkType mapFromEntity(WorkTypeEntity workTypeEntity);

    @Mapping(target = "jobOffers", ignore = true)
    WorkTypeEntity mapToEntity(WorkType workType);
}
