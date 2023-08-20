package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Location;
import it.hrme.infrastructure.database.entity.LocationEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LocationEntityMapperImpl.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class LocationEntityMapperTest implements MapperFixtures {

    private LocationEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_location_to_location_entity() {
        //given
        Location location = getLocation();

        //when
        LocationEntity locationEntity = mapper.mapToEntity(location);

        //then
        Assertions.assertThat(location)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(locationEntity);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_location_entity_to_location() {
        //given
        LocationEntity locationEntity = getLocationEntity();

        //when
        Location location = mapper.mapFromEntity(locationEntity);

        //then
        Assertions.assertThat(locationEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(location);
    }
}
