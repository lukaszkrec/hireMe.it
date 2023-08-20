package it.hrme.business;

import it.hrme.business.dao.AgentDAO;
import it.hrme.domain.Agent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class AgentService {

    private final AgentDAO agentDAO;

    @Transactional
    public Agent save(Agent agent) {
        return agentDAO.save(agent);
    }

    @Transactional
    public Agent findById(Long agentId) {
        return agentDAO.findById(agentId);
    }

    @Transactional
    public Agent findByEmail(String agentEmail) {
        return agentDAO.findByEmail(agentEmail);
    }
}
