package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.*;
import it.hrme.integration.configuration.PersistenceContainerTestConfiguration;
import it.hrme.util.MapperFixtures;
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

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobOfferJpaRepositoryTest implements MapperFixtures {

    @Autowired
    private JobOfferJpaRepository jobOfferJpaRepository;

    @BeforeEach
    void setUp() {
        JobOfferEntity jobOfferEntity = getJobOfferEntity();
        jobOfferJpaRepository.saveAndFlush(jobOfferEntity);
    }

    @Test
    void should_find_job_offers_by_work_type() {
        //when
        String workType = "Hybrid";
        List<JobOfferEntity> jobOfferEntities = jobOfferJpaRepository.findAllByWorkType(workType);

        //then
        JobOfferEntity jobOfferEntity = jobOfferEntities.get(0);
        Optional<WorkTypeEntity.Type> actualWorkType = jobOfferEntity.getWorkTypes()
                .stream()
                .map(WorkTypeEntity::getType)
                .findAny();
        Assertions.assertThat(actualWorkType)
                .contains(WorkTypeEntity.Type.HYBRID);
    }

    @Test
    void should_find_job_offers_by_skill() {
        //when
        String skill = "Java";
        List<JobOfferEntity> jobOfferEntities = jobOfferJpaRepository.findAllBySkill(skill);

        //then
        JobOfferEntity jobOfferEntity = jobOfferEntities.get(0);
        Optional<String> actualJobOfferSkill = jobOfferEntity.getSkills()
                .stream()
                .map(SkillEntity::getSkillName)
                .findAny();
        Assertions.assertThat(actualJobOfferSkill)
                .contains(skill);
    }

    @Test
    void should_find_job_offers_by_required_work_availability() {
        //when
        String required_work_availability = "Full_Time";
        List<JobOfferEntity> jobOfferEntities = jobOfferJpaRepository.findAllByRequiredWorkAvailability(required_work_availability);

        //then
        JobOfferEntity jobOfferEntity = jobOfferEntities.get(0);
        Optional<RequiredWorkAvailabilityEntity.WorkAvailability> actualRequiredWorkAvailability = jobOfferEntity
                .getRequiredWorkAvailabilities()
                .stream()
                .map(RequiredWorkAvailabilityEntity::getWorkAvailability)
                .findAny();
        Assertions.assertThat(actualRequiredWorkAvailability)
                .contains(RequiredWorkAvailabilityEntity.WorkAvailability.FULL_TIME);
    }

    @Test
    void should_find_job_offers_by_employment_form() {
        //when
        String employmentForm = "B2B";
        List<JobOfferEntity> jobOfferEntities = jobOfferJpaRepository.findAllByEmploymentForm(employmentForm);

        //then
        JobOfferEntity jobOfferEntity = jobOfferEntities.get(0);
        Optional<EmploymentFormEntity.Form> actualEmploymentForm = jobOfferEntity.getEmploymentForms()
                .stream()
                .map(EmploymentFormEntity::getForm)
                .findAny();
        Assertions.assertThat(actualEmploymentForm)
                .contains(EmploymentFormEntity.Form.B2B);
    }

    @Test
    void should_find_job_offers_by_country() {
        //when
        String country = "Poland";
        List<JobOfferEntity> jobOfferEntities = jobOfferJpaRepository.findAllByCountry(country);

        //then
        JobOfferEntity jobOfferEntity = jobOfferEntities.get(0);
        Optional<String> actualCountry = jobOfferEntity.getLocations()
                .stream()
                .map(LocationEntity::getCountry)
                .findAny();
        Assertions.assertThat(actualCountry)
                .contains(country);
    }
}
