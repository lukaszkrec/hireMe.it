package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.EmploymentForm;
import it.hrme.infrastructure.database.entity.EmploymentFormEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EmploymentFormEntityMapperImpl.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class EmploymentFormEntityMapperTest implements MapperFixtures {

    private EmploymentFormEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_employment_form_entity_to_employment_form() {
        //given
        EmploymentFormEntity employmentFormEntity = getEmploymentFormEntity();

        //when
        EmploymentForm employmentForm = mapper.mapFromEntity(employmentFormEntity);

        //then
        Assertions.assertThat(employmentFormEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(employmentForm);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_employment_form_to_employment_form_entity() {
        //given
        EmploymentForm employmentForm = getEmploymentForm();

        //when
        EmploymentFormEntity employmentFormEntity = mapper.mapToEntity(employmentForm);

        //then
        Assertions.assertThat(employmentForm)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(employmentFormEntity);
    }
}
