package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.WorkType;
import it.hrme.infrastructure.database.entity.WorkTypeEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WorkTypeEntityMapperImpl.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class WorkTypeEntityMapperTest implements MapperFixtures {

    private WorkTypeEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_work_type_to_work_type_entity() {
        //given
        WorkType workType = getWorkType();

        //when
        WorkTypeEntity workTypeEntity = mapper.mapToEntity(workType);

        //then
        Assertions.assertThat(workType)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(workTypeEntity);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_work_type_entity_to_work_type() {
        //given
        WorkTypeEntity workTypeEntity = getWorkTypeEntity();

        //when
        WorkType workType = mapper.mapFromEntity(workTypeEntity);

        //then
        Assertions.assertThat(workTypeEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(workType);
    }
}
