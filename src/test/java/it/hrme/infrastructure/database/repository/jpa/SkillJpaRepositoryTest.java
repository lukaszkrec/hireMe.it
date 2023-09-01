package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.constants.SkillName;
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

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class SkillJpaRepositoryTest implements EntityFixtures{

    private SkillJpaRepository skillJpaRepository;

    @BeforeEach
    void setUp() {
        skillJpaRepository.deleteAll();
        skillJpaRepository.flush();

        List<SkillEntity> skillsToSave = getSkillsEntityList();
        skillJpaRepository.saveAllAndFlush(skillsToSave);
    }

    @Test
    void should_find_all_skills() {
        //when
        List<SkillEntity> skills = skillJpaRepository.findAll();

        //then
        Assertions.assertThat(skills).hasSize(5);
    }

    @Test
    void should_find_skill_by_name() {
        //when
        SkillName skillName = SkillName.JAVA;
        SkillEntity bySkillName = skillJpaRepository.findBySkillName(skillName);

        Assertions.assertThat(bySkillName.getSkillName()).isEqualTo(skillName);
    }
}
