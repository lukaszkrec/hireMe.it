package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Skill;
import it.hrme.infrastructure.database.entity.SkillEntity;
import it.hrme.util.MapperFixtures;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SkillEntityMapperImpl.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class SkillEntityMapperTest implements MapperFixtures {

    private SkillEntityMapper mapper;

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void should_map_skill_to_skill_entity() {
        //given
        Skill skill = getSkill();

        //when
        SkillEntity skillEntity = mapper.mapToEntity(skill);

        //then
        Assertions.assertThat(skill)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(skillEntity);
    }

    @Test
    void should_map_skill_entity_to_skill() {
        //given
        SkillEntity skillEntity = getSkillEntity();

        //when
        Skill skill = mapper.mapFromEntity(skillEntity);

        //then
        Assertions.assertThat(skillEntity)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(skill);
    }
}
