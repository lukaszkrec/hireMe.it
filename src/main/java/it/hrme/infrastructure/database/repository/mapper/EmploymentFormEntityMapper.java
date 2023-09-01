package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.EmploymentForm;
import it.hrme.infrastructure.database.entity.EmploymentFormEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmploymentFormEntityMapper {

    @Mapping(target = "jobOffers", ignore = true)
    EmploymentForm mapFromEntity(EmploymentFormEntity employmentFormEntity);

    @Mapping(target = "jobOffers", ignore = true)
    EmploymentFormEntity mapToEntity(EmploymentForm employmentForm);
}
