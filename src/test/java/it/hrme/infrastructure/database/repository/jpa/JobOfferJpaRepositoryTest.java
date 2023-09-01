package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.constants.Form;
import it.hrme.infrastructure.database.constants.SkillName;
import it.hrme.infrastructure.database.constants.Type;
import it.hrme.infrastructure.database.constants.WorkAvailability;
import it.hrme.infrastructure.database.entity.*;
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

import java.util.*;

import static it.hrme.infrastructure.database.constants.Type.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
 class JobOfferJpaRepositoryTest implements EntityFixtures {

    private JobOfferJpaRepository jobOfferJpaRepository;
    private WorkTypeJpaRepository workTypeJpaRepository;
    private SkillJpaRepository skillJpaRepository;
    private RequiredWorkAvailabilityJpaRepository requiredWorkAvailabilityJpaRepository;
    private EmploymentFormJpaRepository employmentFormJpaRepository;

    @BeforeEach
    void setUp() {
        JobOfferEntity jobOfferEntity = getJobOfferEntity1();

        WorkTypeEntity workTypeEntity = workTypeJpaRepository.findAll().stream()
                .filter(workType -> workType.getType().equals(HYBRID))
                .findFirst()
                .get();

        SkillEntity skillEntity = skillJpaRepository.findAll().stream()
                .filter(skill -> skill.getSkillName().equals(SkillName.JAVA))
                .findFirst()
                .get();

        RequiredWorkAvailabilityEntity requiredWorkAvailabilityEntity = requiredWorkAvailabilityJpaRepository.findAll()
                .stream()
                .filter(workAvailability ->
                                workAvailability.getWorkAvailability()
                                        .equals(WorkAvailability.FULL_TIME)
                )
                .findFirst()
                .get();

        EmploymentFormEntity employmentFormEntity = employmentFormJpaRepository.findAll().stream()
                .filter(form -> form.getForm().equals(Form.B2B))
                .findFirst()
                .get();

        LocationEntity locationEntity1 = getLocationEntity1();

        Set<EmploymentFormEntity> employmentFormEntities = new HashSet<>(List.of(employmentFormEntity));
        Set<RequiredWorkAvailabilityEntity> requiredWorkAvailabilityEntities = new HashSet<>(List.of(requiredWorkAvailabilityEntity));
        Set<SkillEntity> skillEntities = new HashSet<>(List.of(skillEntity));
        Set<WorkTypeEntity> workTypeEntities = new HashSet<>(List.of(workTypeEntity));
        Set<LocationEntity> locationEntities = new HashSet<>(List.of(locationEntity1));

        jobOfferEntity.setEmploymentForms(employmentFormEntities);
        jobOfferEntity.setRequiredWorkAvailabilities(requiredWorkAvailabilityEntities);
        jobOfferEntity.setSkills(skillEntities);
        jobOfferEntity.setWorkTypes(workTypeEntities);
        jobOfferEntity.setLocations(locationEntities);

        jobOfferJpaRepository.saveAndFlush(jobOfferEntity);
    }

    @Test
    void should_find_job_offers_by_work_type() {
        //when
        String workType = "Hybrid";
        List<JobOfferEntity> jobOfferEntities = jobOfferJpaRepository.findAllByWorkType(workType);

        //then
        JobOfferEntity jobOfferEntity = jobOfferEntities.get(0);
        Optional<Type> actualWorkType = jobOfferEntity.getWorkTypes()
                .stream()
                .map(WorkTypeEntity::getType)
                .findAny();
        Assertions.assertThat(actualWorkType)
                .contains(Type.HYBRID);
    }

    @Test
    void should_find_job_offers_by_skill() {
        //when
        String skill = "Java";
        List<JobOfferEntity> jobOfferEntities = jobOfferJpaRepository.findAllBySkill(skill);

        //then
        JobOfferEntity jobOfferEntity = jobOfferEntities.get(0);
        Optional<SkillName> actualJobOfferSkill = jobOfferEntity.getSkills()
                .stream()
                .map(SkillEntity::getSkillName)
                .findAny();


        Assertions.assertThat(actualJobOfferSkill)
                .contains(SkillName.JAVA);
    }

    @Test
    void should_find_job_offers_by_required_work_availability() {
        //when
        String required_work_availability = "Full_Time";
        List<JobOfferEntity> jobOfferEntities = jobOfferJpaRepository.findAllByRequiredWorkAvailability(required_work_availability);

        //then
        JobOfferEntity jobOfferEntity = jobOfferEntities.get(0);
        Optional<WorkAvailability> actualRequiredWorkAvailability = jobOfferEntity
                .getRequiredWorkAvailabilities()
                .stream()
                .map(RequiredWorkAvailabilityEntity::getWorkAvailability)
                .findAny();
        Assertions.assertThat(actualRequiredWorkAvailability)
                .contains(WorkAvailability.FULL_TIME);
    }

    @Test
    void should_find_job_offers_by_employment_form() {
        //when
        String employmentForm = "B2B";
        List<JobOfferEntity> jobOfferEntities = jobOfferJpaRepository.findAllByEmploymentForm(employmentForm);

        //then
        JobOfferEntity jobOfferEntity = jobOfferEntities.get(0);
        Optional<Form> actualEmploymentForm = jobOfferEntity.getEmploymentForms()
                .stream()
                .map(EmploymentFormEntity::getForm)
                .findAny();
        Assertions.assertThat(actualEmploymentForm)
                .contains(Form.B2B);
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
