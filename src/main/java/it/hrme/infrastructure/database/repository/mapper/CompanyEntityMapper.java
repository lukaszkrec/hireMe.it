package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Company;
import it.hrme.infrastructure.database.entity.CompanyEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CompanyEntityMapper {

    @Mapping(target = "agents", ignore = true)
    Company mapFromEntity(CompanyEntity companyEntity);

    @Mapping(target = "agents", ignore = true)
    CompanyEntity mapToEntity(Company company);
}
