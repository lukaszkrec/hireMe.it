package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.AgentDAO;
import it.hrme.domain.Agent;
import it.hrme.infrastructure.database.entity.AgentEntity;
import it.hrme.infrastructure.database.repository.jpa.AgentJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.AgentEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AgentRepository implements AgentDAO {

    private final AgentJpaRepository agentJpaRepository;
    private final AgentEntityMapper agentEntityMapper;

    @Override
    public Agent save(Agent agent) {
        AgentEntity agentEntity = agentEntityMapper.mapToEntity(agent);
        AgentEntity savedAgentEntity = agentJpaRepository.save(agentEntity);
        return agentEntityMapper.mapFromEntity(savedAgentEntity);
    }

    @Override
    public Agent findById(Long agentId) {
        AgentEntity agentEntity = agentJpaRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Agent with id: {%s} does not exist!".formatted(agentId))
                );
        return agentEntityMapper.mapFromEntity(agentEntity);
    }

    @Override
    public Agent findByEmail(String agentEmail) {
        return agentJpaRepository.findByEmail(agentEmail)
                .map(agentEntityMapper::mapFromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Agent with email: {%s} does not exist!".formatted(agentEmail))
                );
    }
}
