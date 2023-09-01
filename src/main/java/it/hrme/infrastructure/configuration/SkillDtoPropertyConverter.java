package it.hrme.infrastructure.configuration;

import it.hrme.api.dto.SkillDto;
import it.hrme.infrastructure.database.constants.SkillName;
import org.springframework.core.convert.converter.Converter;

public class SkillDtoPropertyConverter implements Converter<String, SkillDto> {

    @Override
    public SkillDto convert(String source) {
        String[] propertyValues = source
                .replace("SkillDto", "")
                .replaceAll("[(]", "")
                .replaceAll("[a-zA-Z]+=", "")
                .replaceAll("[,)]", "")
                .split("\\s");

        return SkillDto.builder()
                .id(Long.valueOf(propertyValues[0]))
                .uuid(propertyValues[1])
                .skillName(SkillName.valueOf(propertyValues[2]))
                .build();
    }
}
