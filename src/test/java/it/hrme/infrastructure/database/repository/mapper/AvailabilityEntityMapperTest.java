package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Availability;
import it.hrme.infrastructure.database.entity.AvailabilityEntity;
import it.hrme.util.TestDataProvider;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AvailabilityEntityMapperImpl.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class AvailabilityEntityMapperTest implements TestDataProvider {

    private AvailabilityEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_availability_entity_to_availability() {
        //given
        AvailabilityEntity availabilityEntity = getAvailabilityEntity();

        //when
        Availability availability = mapper.mapFromEntity(availabilityEntity);

        //then
        Assertions.assertThat(availabilityEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(availability);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_availability_to_availability_entity() {
        //given
        Availability availability = getAvailability();

        //when
        AvailabilityEntity availabilityEntity = mapper.mapToEntity(availability);

        //then
        Assertions.assertThat(availability)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(availabilityEntity);

    }
}
