package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Address;
import it.hrme.infrastructure.database.entity.AddressEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AddressEntityMapper {

    @Mapping(target = "company", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    AddressEntity mapToEntity(Address address);

    @Mapping(target = "company", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    Address mapFromEntity(AddressEntity addressEntity);
}
