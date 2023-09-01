package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.LocationEntity;
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
class LocationJpaRepositoryTest implements EntityFixtures {

    private LocationJpaRepository locationJpaRepository;

    @BeforeEach
    void setUp() {
        LocationEntity locationEntity1 = getLocationEntity1();
        LocationEntity locationEntity2 = getLocationEntity2();

        List<LocationEntity> locations = List.of(locationEntity1, locationEntity2);

        locationJpaRepository.saveAllAndFlush(locations);
    }

    @Test
    void should_find_all_locations_by_country() {
        //when
        List<LocationEntity> locations = locationJpaRepository.findAll();

        //then
        Assertions.assertThat(locations).hasSize(2);
    }

}
