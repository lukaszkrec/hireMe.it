package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.JobOffer;
import it.hrme.infrastructure.database.entity.JobOfferEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {JobOfferEntityMapperImpl.class, WorkTypeEntityMapperImpl.class, SkillEntityMapperImpl.class, RequiredWorkAvailabilityEntityMapperImpl.class, LocationEntityMapperImpl.class, EmploymentFormEntityMapperImpl.class, ContractEntityMapperImpl.class,})
@AllArgsConstructor(onConstructor = @__(@Autowired))
class JobOfferEntityMapperTest implements MapperFixtures {

    private JobOfferEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_job_offer_entity_to_job_offer() {
        //given
        JobOfferEntity jobOfferEntity = getJobOfferEntity();

        //when
        JobOffer jobOffer = mapper.mapFromEntity(jobOfferEntity);

        //then
        Assertions.assertThat(jobOfferEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(jobOffer);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_job_offer_to_job_offer_entity_entity() {
        //given
        JobOffer jobOffer = getJobOffer();

        //when
        JobOfferEntity jobOfferEntity = mapper.mapToEntity(jobOffer);

        //then
        Assertions.assertThat(jobOffer)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*uuid")
                .isEqualTo(jobOfferEntity);
    }
}
