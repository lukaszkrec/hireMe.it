package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.AgentEntity;
import it.hrme.integration.configuration.PersistenceContainerTestConfiguration;
import it.hrme.util.EntityFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class AgentJpaRepositoryTest implements EntityFixtures {

    private AgentJpaRepository agentJpaRepository;

    @BeforeEach
    void setUp() {
        AgentEntity agentEntity = getAgentEntity();
        agentJpaRepository.saveAndFlush(agentEntity);
    }

    @Test
    void should_find_agent_by_email() {
        //when
        String email = "ania.anitowna@gmail.com";
        AgentEntity agentEntity = agentJpaRepository.findByEmail(email).get();

        //then
        Assertions.assertThat(agentEntity.getEmail()).isEqualTo(email);
    }
}
