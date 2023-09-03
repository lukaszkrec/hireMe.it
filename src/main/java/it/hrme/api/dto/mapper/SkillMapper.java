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

    SkillDto mapToDto(Skill skill);

    Skill mapFromDto(SkillDto skillDto);
}
