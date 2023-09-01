package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.constants.SkillName;
import it.hrme.infrastructure.database.constants.Status;
import it.hrme.infrastructure.database.entity.CandidateEntity;
import it.hrme.infrastructure.database.entity.SkillEntity;
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
import java.util.Optional;
import java.util.Set;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
 class CandidateJpaRepositoryTest implements EntityFixtures {

    private CandidateJpaRepository candidateJpaRepository;
    private SkillJpaRepository skillJpaRepository;

    @BeforeEach
    void setUp() {
        CandidateEntity candidateEntity = getCandidateEntity();
        SkillEntity skillEntity1 = skillJpaRepository.findAll().stream()
                .filter(skillEntity -> skillEntity.getSkillName().getLabel().equalsIgnoreCase("Java"))
                .findFirst()
                .get();

        candidateEntity.setSkills(Set.of(skillEntity1));
        candidateJpaRepository.saveAndFlush(candidateEntity);

        Assertions.assertThat(skillJpaRepository.findAll()).hasSize(6);
    }

    @Test
    void should_find_candidate_by_email() {
        //when
        String email = "jan.kowalski.@gmail.com";
        CandidateEntity candidateEntity = candidateJpaRepository.findByEmail(email).get();

        //then
        Assertions.assertThat(candidateEntity.getEmail()).isEqualTo(email);
    }

    @Test
    void should_find_candidate_by_status() {
        //when
        Status status = Status.ACTIVE;
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
        Optional<SkillName> actualCandidateSkill = candidateEntity.getSkills()
                .stream()
                .map(SkillEntity::getSkillName)
                .findAny();

        Assertions.assertThat(actualCandidateSkill).hasValue(SkillName.JAVA);
    }
}
