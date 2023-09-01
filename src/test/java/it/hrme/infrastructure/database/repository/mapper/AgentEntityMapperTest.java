package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Agent;
import it.hrme.infrastructure.database.entity.AgentEntity;
import it.hrme.infrastructure.database.entity.BaseEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {AgentEntityMapperImpl.class,
        CompanyEntityMapperImpl.class,
        JobOfferEntityMapperImpl.class,
        WorkTypeEntityMapperImpl.class,
        SkillEntityMapperImpl.class,
        RequiredWorkAvailabilityEntityMapperImpl.class,
        LocationEntityMapperImpl.class,
        EmploymentFormEntityMapperImpl.class,
        ContractEntityMapperImpl.class})
@AllArgsConstructor(onConstructor = @__(@Autowired))
class AgentEntityMapperTest implements MapperFixtures {

    private AgentEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_agent_entity_to_agent() {
        //given
        AgentEntity agentEntity = getAgentEntity();

        //when
        Agent agent = mapper.mapFromEntity(agentEntity);

        //then
        Assertions.assertThat(agentEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(agent);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_agent_to_agent_entity() {
        //given
        Agent agent = getAgent();

        //when
        AgentEntity agentEntity = mapper.mapToEntity(agent);

        //then
        Assertions.assertThat(agent)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*uuid")
                .isEqualTo(agentEntity);
    }
}
