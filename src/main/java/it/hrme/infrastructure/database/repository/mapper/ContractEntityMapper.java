package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Contract;
import it.hrme.infrastructure.database.entity.ContractEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ContractEntityMapper {

    @Mapping(target = "jobOffer", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    ContractEntity mapToEntity(Contract contract);

    @Mapping(target = "jobOffer", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    Contract mapFromEntity(ContractEntity contractEntity);
}
