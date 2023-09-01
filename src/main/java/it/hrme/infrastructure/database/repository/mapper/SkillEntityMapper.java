package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Skill;
import it.hrme.infrastructure.database.entity.SkillEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SkillEntityMapper {

    SkillEntity mapToEntity(Skill skill);

    Skill mapFromEntity(SkillEntity skillEntity);
}
