package it.hrme.api.dto.mapper;

import it.hrme.api.dto.AgentDto;
import it.hrme.domain.Agent;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {CompanyMapperImpl.class, JobOfferMapperImpl.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AgentMapper {

    Agent mapFromDto(AgentDto agentDto);

    AgentDto mapToDto(Agent agent);
}
