package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Candidate;
import it.hrme.infrastructure.database.entity.CandidateEntity;
import it.hrme.util.TestDataProvider;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {CandidateEntityMapperImpl.class,
        ContractEntityMapperImpl.class,
        AvailabilityEntityMapperImpl.class,
        SkillEntityMapperImpl.class,
        AddressEntityMapperImpl.class,})
@AllArgsConstructor(onConstructor = @__(@Autowired))
class CandidateEntityMapperTest implements TestDataProvider {

    private CandidateEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_candidate_entity_to_candidate() {
        //given
        CandidateEntity candidateEntity = getCandidateEntity();

        //when
        Candidate candidate = mapper.mapFromEntity(candidateEntity);

        //then
        Assertions.assertThat(candidateEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(candidate);

    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_candidate_to_candidate_entity() {
        //given
        Candidate candidate = getCandidate();

        //when
        CandidateEntity candidateEntity = mapper.mapToEntity(candidate);

        //then
        Assertions.assertThat(candidate)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(candidateEntity);

    }
}
