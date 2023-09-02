package it.hrme.api.restcontroller;

import it.hrme.api.dto.SkillDto;
import it.hrme.api.dto.mapper.SkillMapper;
import it.hrme.business.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/skill")
class SkillRestController {

    private final SkillService skillService;
    private final SkillMapper skillMapper;

    @GetMapping
    public List<SkillDto> skills(@RequestParam(value = "query", required = false) String query) {
        if (StringUtils.containsWhitespace(query) || Objects.isNull(query)) {
            return skillService.findAll().stream()
                    .limit(15)
                    .map(skillMapper::mapToDto)
                    .toList();
        }

        return skillService.findAll().stream()
                .filter(skill -> skill.getSkillName().getLabel().toLowerCase().contains(query.toLowerCase()))
                .limit(15)
                .map(skillMapper::mapToDto)
                .toList();
    }
}
