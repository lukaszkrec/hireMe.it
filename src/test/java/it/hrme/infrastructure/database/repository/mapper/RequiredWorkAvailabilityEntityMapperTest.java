package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.RequiredWorkAvailability;
import it.hrme.infrastructure.database.entity.RequiredWorkAvailabilityEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RequiredWorkAvailabilityEntityMapperImpl.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class RequiredWorkAvailabilityEntityMapperTest implements MapperFixtures {

    private RequiredWorkAvailabilityEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_required_work_availability_entity_to_required_work_availability() {
        //given
        RequiredWorkAvailabilityEntity requiredWorkAvailabilityEntity = getRequiredWorkAvailabilityEntity();

        //when
        RequiredWorkAvailability requiredWorkAvailability = mapper.mapFromEntity(requiredWorkAvailabilityEntity);

        //then
        Assertions.assertThat(requiredWorkAvailabilityEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(requiredWorkAvailability);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_required_work_availability_to_required_work_availability_entity() {
        //given
        RequiredWorkAvailability requiredWorkAvailability = getRequiredWorkAvailability();

        //when
        RequiredWorkAvailabilityEntity requiredWorkAvailabilityEntity = mapper.mapToEntity(requiredWorkAvailability);

        //then
        Assertions.assertThat(requiredWorkAvailability)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*uuid")
                .isEqualTo(requiredWorkAvailabilityEntity);
    }
}
