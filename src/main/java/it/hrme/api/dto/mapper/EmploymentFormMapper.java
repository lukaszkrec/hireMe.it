package it.hrme.api.dto.mapper;

import it.hrme.api.dto.EmploymentFormDto;
import it.hrme.domain.EmploymentForm;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface EmploymentFormMapper {


    @Mapping(target = "jobOffers", ignore = true)
    EmploymentFormDto mapFromDto(EmploymentForm employmentForm);


    @Mapping(target = "jobOffers", ignore = true)
    EmploymentForm mapToDto(EmploymentFormDto employmentFormDto);
}
