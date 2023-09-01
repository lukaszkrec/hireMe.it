package it.hrme.api.dto.mapper;

import it.hrme.api.dto.SkillDto;
import it.hrme.domain.Skill;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface SkillMapper {

    @Mapping(target = "jobOffers", ignore = true)
    @Mapping(target = "candidates", ignore = true)
    SkillDto mapToDto(Skill skill);

    @Mapping(target = "jobOffers", ignore = true)
    @Mapping(target = "candidates", ignore = true)
    Skill mapFromDto(SkillDto skillDto);
}
