package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.WorkTypeEntity;
import it.hrme.integration.configuration.PersistenceContainerTestConfiguration;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
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
 class WorkTypeJpaRepositoryTest {

    private WorkTypeJpaRepository workTypeJpaRepository;

    @Test
    void should_find_all_work_types() {
        //when
        List<WorkTypeEntity> workTypeEntities = workTypeJpaRepository.findAll();

        Assertions.assertThat(workTypeEntities).hasSize(3);
    }
}
