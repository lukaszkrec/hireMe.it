package it.hrme.api.dto.mapper;

import it.hrme.api.dto.CompanyDto;
import it.hrme.domain.Company;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CompanyMapper {

    @Mapping(target = "agents", ignore = true)
    Company mapFromDto(CompanyDto companyDto);

    @Mapping(target = "agents", ignore = true)
    CompanyDto mapToDto(Company company);
}
