package it.hrme.infrastructure.database.repository.mapper;

import it.hrme.domain.Skill;
import it.hrme.infrastructure.database.entity.SkillEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SkillEntityMapper {

    @Mapping(target = "jobOffers", ignore = true)
    @Mapping(target = "candidates", ignore = true)
    SkillEntity mapToEntity(Skill skill);

    @Mapping(target = "jobOffers", ignore = true)
    @Mapping(target = "candidates", ignore = true)
    Skill mapFromEntity(SkillEntity skillEntity);
}
