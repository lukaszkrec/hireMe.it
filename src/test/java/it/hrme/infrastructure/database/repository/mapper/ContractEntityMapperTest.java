package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Contract;
import it.hrme.infrastructure.database.entity.ContractEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ContractEntityMapperImpl.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class ContractEntityMapperTest implements MapperFixtures {

    private ContractEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_contract_entity_to_contract() {
        //given
        ContractEntity contractEntity = getContractEntity();

        //when
        Contract contract = mapper.mapFromEntity(contractEntity);

        //then
        Assertions.assertThat(contractEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(contract);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_contract_to_contract_entity() {
        //given
        Contract contract = getContract();

        //when
        ContractEntity contractEntity = mapper.mapToEntity(contract);

        //then
        Assertions.assertThat(contract)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(contractEntity);
    }
}
