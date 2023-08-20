package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Address;
import it.hrme.infrastructure.database.entity.AddressEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AddressEntityMapperImpl.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class AddressEntityMapperTest implements MapperFixtures {

    private AddressEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_address_to_address_entity() {
        //given
        Address address = getAddress();

        //when
        AddressEntity addressEntity = mapper.mapToEntity(address);

        //then
        Assertions.assertThat(address)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(addressEntity);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_address_entity_to_address() {
        //given
        AddressEntity addressEntity = getAddressEntity();

        //when
        Address address = mapper.mapFromEntity(addressEntity);

        //then
        Assertions.assertThat(addressEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(address);
    }
}
