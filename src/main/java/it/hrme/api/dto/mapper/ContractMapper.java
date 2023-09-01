package it.hrme.api.dto.mapper;

import it.hrme.api.dto.ContractDto;
import it.hrme.domain.Contract;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ContractMapper {

    @Mapping(target = "jobOffer", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    ContractDto mapToDto(Contract contract);


    @Mapping(target = "jobOffer", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    Contract mapFromDto(ContractDto contractDto);
}
