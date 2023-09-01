package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Company;
import it.hrme.infrastructure.database.entity.CompanyEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CompanyEntityMapperImpl.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class CompanyEntityMapperTest implements MapperFixtures {

    private CompanyEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_company_to_company_entity() {
        //given
        Company company = getCompany();

        //when
        CompanyEntity companyEntity = mapper.mapToEntity(company);

        //then
        Assertions.assertThat(company)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*uuid")
                .isEqualTo(companyEntity);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_company_entity_to_company() {
        //given
        CompanyEntity companyEntity = getCompanyEntity();

        //when
        Company company = mapper.mapFromEntity(companyEntity);

        //then
        Assertions.assertThat(companyEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(company);
    }
}
