package it.hrme.business.dao;

import it.hrme.domain.Agent;

public interface AgentDAO {

    Agent save(Agent agent);

    Agent findById(Long agentId);

    Agent findByEmail(String agentEmail);
}
