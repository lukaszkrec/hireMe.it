package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.CandidateEntity;
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

import java.util.List;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CandidateJpaRepositoryTest implements EntityFixtures {

    private CandidateJpaRepository candidateJpaRepository;

    @BeforeEach
    void setUp() {
        CandidateEntity candidateEntity = getCandidateEntity();
        candidateJpaRepository.save(candidateEntity);
    }

    @Test
    void should_find_candidate_by_status() {
        //when
        CandidateEntity.Status status = CandidateEntity.Status.ACTIVE;
        List<CandidateEntity> candidateEntities = candidateJpaRepository.findByStatus(status);

        //then
        CandidateEntity candidateEntity = candidateEntities.get(0);
        Assertions.assertThat(candidateEntity.getStatus())
                .isEqualTo(status);
    }

    @Test
    void should_find_candidate_by_skill() {
        //when
        String skill = "Java";
        List<CandidateEntity> candidateEntities = candidateJpaRepository.findAllBySkill(skill);

        //then
        CandidateEntity candidateEntity = candidateEntities.get(0);
        Assertions.assertThat(candidateEntity.getSkills())
                .filteredOn(skillEntity -> skillEntity.getSkillName()
                        .equals(skill))
                .isNotEmpty();
    }

    @Test
    void should_find_candidate_by_country() {
        //when
        String country = "Poland";
        List<CandidateEntity> candidateEntities = candidateJpaRepository.findAllByCountry(country);

        //then
        CandidateEntity candidateEntity = candidateEntities.get(0);
        Assertions.assertThat(candidateEntity.getAddress()
                                      .getCountry())
                .isEqualTo("Poland");
    }
}
