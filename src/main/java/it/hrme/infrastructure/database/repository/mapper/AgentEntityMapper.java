package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Agent;
import it.hrme.infrastructure.database.entity.AgentEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {CompanyEntityMapperImpl.class, JobOfferEntityMapperImpl.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AgentEntityMapper {

    Agent mapFromEntity(AgentEntity agentEntity);

    AgentEntity mapToEntity(Agent agent);
}
